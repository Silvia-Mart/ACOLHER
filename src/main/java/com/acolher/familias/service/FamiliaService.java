package com.acolher.familias.service;

import com.acolher.familias.exception.EntityException;
import com.acolher.familias.model.Familia;
import com.acolher.familias.repository.FamiliaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FamiliaService {

    FamiliaRepository familiaRepository;
    FamiliaService(FamiliaRepository familiaRepository){
        this.familiaRepository = familiaRepository;
    }
    @Transactional
    public Familia cadastrarFamilia(Familia familia){
        return familiaRepository.save(familia);
    }

    public List<Familia> listaDeFamiliasCadastradas(){
        return familiaRepository.findAll();
    }

    public Familia dadosDaFamilia(Long familiaId){
        Optional<Familia> dadosFamilia = familiaRepository.findById(familiaId);
        if (dadosFamilia.isPresent()){
            return dadosFamilia.get();
        }
        throw new EntityException("Essa familia não existe.");
    }

    public Familia atualizarFamilia(Long familiaId, Familia familia){
        Optional<Familia> dados = familiaRepository.findById(familiaId);
        if (dados.isPresent()){
            familia.setId(familiaId);
            return familiaRepository.save(familia);
        }
        throw new EntityException("Não foi possivel atualizar essa familia porque ela não existe.");
    }

    public void deletarFamilia(Long familiaId){
        Optional<Familia> dados = familiaRepository.findById(familiaId);
        if (dados.isPresent()){
            familiaRepository.deleteById(familiaId);
        }else{
            throw new EntityException("Essa familia não existe.");
        }
    }
}
