package com.acolher.familias.controller;

import com.acolher.familias.model.Pessoa;
import com.acolher.familias.repository.PessoaRepository;
import com.acolher.familias.service.PessoaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    PessoaService pessoaService;
    PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }


    @PostMapping("/{id}")
    public Pessoa cadastrarPessoa(@PathVariable("id")Long id, @RequestBody Pessoa pessoa){
        return pessoaService.cadastrarPessoa(id, pessoa);
    }
}