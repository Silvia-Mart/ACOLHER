package com.acolher.familias.controller;

import com.acolher.familias.dto.FamiliaDto;
import com.acolher.familias.model.Familia;
import com.acolher.familias.service.FamiliaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

    FamiliaService familiaService;

    FamiliaController(FamiliaService familiaService){
        this.familiaService = familiaService;
    }

    @PostMapping
    public Familia cadastrarFamilia(@RequestBody FamiliaDto familiaDto){
        return familiaService.cadastrarFamilia(familiaDto.transferenciaDeDados());
    }
    @GetMapping
    public List<Familia> listaDeFamiliasCadastradas(){
        return familiaService.listaDeFamiliasCadastradas();
    }
    @GetMapping("/{id}")
    public Familia dadosDaFamilia(@PathVariable("id")Long id){
        return familiaService.dadosDaFamilia(id);
    }
    @PutMapping("/{id}")
    public Familia atualizarFamilia(@PathVariable("id")Long id, @RequestBody FamiliaDto familiaDto){
        return familiaService.atualizarFamilia(id, familiaDto.transferenciaDeDados());
    }
    @DeleteMapping("/{id}")
    public void deletarFamilia(@PathVariable("id")Long id){
        familiaService.deletarFamilia(id);
    }
}
