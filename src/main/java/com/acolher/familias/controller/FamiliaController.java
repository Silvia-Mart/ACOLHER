package com.acolher.familias.controller;

import com.acolher.familias.model.Familia;
import com.acolher.familias.repository.FamiliaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

    FamiliaRepository familiaRepository;
    FamiliaController(FamiliaRepository familiaRepository){
        this.familiaRepository = familiaRepository;
    }

    @PostMapping
    public Familia cadastrarFamilia(@RequestBody Familia familia){
        return familiaRepository.save(familia);
    }
}
