package com.acolher.familias.controller;

import com.acolher.familias.dto.PessoaDto;
import com.acolher.familias.model.Pessoa;
import com.acolher.familias.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    PessoaService pessoaService;
    PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Pessoa> cadastrarPessoa(@PathVariable("id")Long id, @Valid @RequestBody PessoaDto pessoaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.cadastrarPessoa(id, pessoaDto.transferenciaDeDados()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> pegarDadosDaPessoa(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(pessoaService.pegarDadosDaPessoa((id)));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodasAsPessoasCadastradas(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarTodasAsPessoasCadastradas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable("id")Long id, @Valid @RequestBody PessoaDto pessoaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.atualizarPessoa(id, pessoaDto.transferenciaDeDados()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPessoa(@PathVariable("id")Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }
}
