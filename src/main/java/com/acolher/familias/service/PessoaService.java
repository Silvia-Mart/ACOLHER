package com.acolher.familias.service;

import com.acolher.familias.exception.EntityException;
import com.acolher.familias.model.Familia;
import com.acolher.familias.model.Pessoa;
import com.acolher.familias.repository.FamiliaRepository;
import com.acolher.familias.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    PessoaRepository pessoaRepository;
    FamiliaRepository familiaRepository;
    PessoaService(PessoaRepository pessoaRepository, FamiliaRepository familiaRepository){
        this.pessoaRepository = pessoaRepository;
        this.familiaRepository = familiaRepository;
    }

    public Pessoa cadastrarPessoa(Long familiaId, Pessoa pessoa){
        Optional<Familia> dadosFamilia = familiaRepository.findById(familiaId);
        if (dadosFamilia.isPresent()){
            Familia familia = dadosFamilia.get();
            pessoa.setFamilia(familia);
            return pessoaRepository.save(pessoa);
        }
        throw new EntityException("Não foi encontrado a familia para fazer conexão.");
    }


    public Pessoa pegarDadosDaPessoa(Long pessoaId){
        Optional<Pessoa> dados = pessoaRepository.findById(pessoaId);
        if (dados.isPresent()){
            return dados.get();
        }
        throw new EntityException("Essa pessoa não existe.");
    }

    public List<Pessoa> listarTodasAsPessoasCadastradas(){
        return pessoaRepository.findAll();
    }

    public Pessoa atualizarPessoa(Long pessoaId, Pessoa pessoa){
        Optional<Pessoa> dados = pessoaRepository.findById(pessoaId);
        if (dados.isPresent()){
            Pessoa dadosAntigos = dados.get();
            pessoa.setId(pessoaId);
            pessoa.setFamilia(dadosAntigos.getFamilia());

            return pessoaRepository.save(pessoa);
        }
        throw new EntityException("Essa pessoa não existe.");
    }

    public void deletarPessoa(Long pessoaId){
        Optional<Pessoa> dados = pessoaRepository.findById(pessoaId);
        if (dados.isPresent()){
            pessoaRepository.deleteById(pessoaId);
        }else {
            throw new EntityException("Essa pessoa não existe.");
        }
    }

}
