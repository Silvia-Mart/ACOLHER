package com.acolher.familias.controller;

import com.acolher.familias.dto.FamiliaDto;
import com.acolher.familias.model.Familia;
import com.acolher.familias.service.FamiliaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

    FamiliaService familiaService;

    FamiliaController(FamiliaService familiaService){
        this.familiaService = familiaService;
    }

    @PostMapping
    public ResponseEntity<Familia> cadastrarFamilia(@Valid @RequestBody FamiliaDto familiaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.cadastrarFamilia(familiaDto.transferenciaDeDados()));
    }
    @GetMapping
    public ResponseEntity<List<Familia>> listaDeFamiliasCadastradas(){
        return ResponseEntity.status(HttpStatus.FOUND).body(familiaService.listaDeFamiliasCadastradas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Familia> dadosDaFamilia(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(familiaService.dadosDaFamilia(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Familia> atualizarFamilia(@PathVariable("id")Long id, @Valid @RequestBody FamiliaDto familiaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.atualizarFamilia(id, familiaDto.transferenciaDeDados()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFamilia(@PathVariable("id")Long id){
        familiaService.deletarFamilia(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
