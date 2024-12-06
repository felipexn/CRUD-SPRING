package com.consumption.crud.services;

import com.consumption.crud.models.PessoaModel;
import com.consumption.crud.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@AllArgsConstructor

public class PessoaService {
private PessoaRepository pessoaRepository;



    public List<PessoaModel> pegaTodasAsPessoas(){
        return pessoaRepository.findAll();
    }

    public PessoaModel criaNovaPessoa( PessoaModel novaPessoa){
        //novaPessoa.setId(null);
        return pessoaRepository.save(novaPessoa);
    }

    public PessoaModel editaPessoa(Integer id){
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("pessoa nao encontrada"));
    }

    public void deletaPessoa( Integer id){
        pessoaRepository.deleteById(id);
    }
}
