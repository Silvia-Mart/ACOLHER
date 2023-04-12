package com.acolher.familias.service;

import com.acolher.familias.model.Familia;
import com.acolher.familias.repository.FamiliaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamiliaService {

    FamiliaRepository familiaRepository;
    FamiliaService(FamiliaRepository familiaRepository){
        this.familiaRepository = familiaRepository;
    }
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
        return null;
    }
}
