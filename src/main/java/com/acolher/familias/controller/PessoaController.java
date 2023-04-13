package com.acolher.familias.controller;

import com.acolher.familias.dto.PessoaDto;
import com.acolher.familias.model.Pessoa;
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
    public Pessoa cadastrarPessoa(@PathVariable("id")Long id, @RequestBody PessoaDto pessoaDto){
        return pessoaService.cadastrarPessoa(id, pessoaDto.transferenciaDeDados());
    }

    @GetMapping("/{id}")
    public Pessoa dadosDaPessoa(@PathVariable("id")Long id){
        return pessoaService.dadosDaPessoa(id);
    }
    @PutMapping("/{id}")
        public Pessoa atualizarPessoa(@PathVariable("id")Long id, @RequestBody PessoaDto pessoaDto){
        return pessoaService.atualizarPessoa(id, pessoaDto.transferenciaDeDados());
    }

    @DeleteMapping("/{id}")
    public  void deletarPessoa(@PathVariable("id")Long id){
        pessoaService.deletarPessoa(id);
    }

}
