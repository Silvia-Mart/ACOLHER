package com.acolher.familias.service;

import com.acolher.familias.model.Familia;
import com.acolher.familias.model.Pessoa;
import com.acolher.familias.repository.FamiliaRepository;
import com.acolher.familias.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    PessoaRepository pessoaRepository;
    FamiliaRepository familiaRepository;
    PessoaService(PessoaRepository pessoaRepository, FamiliaRepository familiaRepository){
        this.pessoaRepository = pessoaRepository;
        this.familiaRepository = familiaRepository;
    }

    public Pessoa cadastrarPessoa(Long familiaId,Pessoa pessoa){
        boolean familiaExiste = familiaRepository.existsById(familiaId);
        if(familiaExiste == true){
            Familia familia = familiaRepository.getReferenceById(familiaId);
            pessoa.setFamilia(familia);
            return pessoaRepository.save(pessoa);
        }
        return pessoa;
    }

}
