package com.acolher.familias.service;

import com.acolher.familias.model.Familia;
import com.acolher.familias.model.Pessoa;
import com.acolher.familias.repository.FamiliaRepository;
import com.acolher.familias.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    PessoaRepository pessoaRepository;
    FamiliaRepository familiaRepository;
    PessoaService(PessoaRepository pessoaRepository, FamiliaRepository familiaRepository){
        this.pessoaRepository = pessoaRepository;
        this.familiaRepository = familiaRepository;
    }

    public Pessoa cadastrarPessoaNova(Long familiaId, Pessoa pessoa){
        Optional<Familia> dadosFamilia = familiaRepository.findById(familiaId);
        if (dadosFamilia.isPresent()){
            Familia familia = dadosFamilia.get();
            pessoa.setFamilia(familia);
            return pessoaRepository.save(pessoa);
        }
        return null;
    }


    public Pessoa dadosDaPessoa(Long pessoaId){
        Optional<Pessoa> dados = pessoaRepository.findById(pessoaId);
        if (dados.isPresent()){
            return dados.get();
        }
        return null;
    }

}
