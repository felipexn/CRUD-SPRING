package com.consumption.crud.controler;

import com.consumption.crud.dtos.PessoaDTO;
import com.consumption.crud.models.PessoaModel;
import com.consumption.crud.services.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*")
@AllArgsConstructor
public class PessoaControler {
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> pegaTodasAsPessoas(){
        return new ResponseEntity<>(pessoaService.pegaTodasAsPessoas(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PessoaModel> criaNovaPessoa(@RequestBody @Valid PessoaDTO novaPessoa){
        //novaPessoa.setId(null);
        PessoaModel pessoa =  new PessoaModel();
        pessoa.setNome(novaPessoa.getNome());
        pessoa.setDescription(novaPessoa.getDescription());
        pessoa.setSenha(novaPessoa.getSenha());
        return new ResponseEntity<>(pessoaService.criaNovaPessoa(pessoa), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PessoaModel> editaPessoa(@PathVariable Integer id,@RequestBody @Valid PessoaDTO novaPessoa){
        PessoaModel pessoa = pessoaService.editaPessoa(id);
        pessoa.setNome(novaPessoa.getNome());
        pessoa.setDescription(novaPessoa.getDescription());
        pessoa.setSenha(novaPessoa.getSenha());

        return new ResponseEntity<>(pessoaService.criaNovaPessoa(pessoa), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Integer id){
        pessoaService.deletaPessoa(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PatchMapping("/{id}/senha")
    public ResponseEntity<Void> alterarSenha(@PathVariable Integer id, @RequestBody String novaSenha){
        PessoaModel pessoa = pessoaService.editaPessoa(id);
        pessoa.setSenha(novaSenha);
        pessoaService.criaNovaPessoa(pessoa);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
