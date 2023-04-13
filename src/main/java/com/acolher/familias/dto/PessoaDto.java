package com.acolher.familias.dto;

import com.acolher.familias.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class PessoaDto {
    @NotBlank
    private String nomeCompleto;
    @NotNull
    private int idade;
    @NotBlank
    private String telefone;
    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @NotBlank
    private String profissao;
    @NotNull
    private Boolean estaTrabalhando;

    public PessoaDto() {
    }

    public Pessoa transferenciaDeDados(){
        return new Pessoa(nomeCompleto,idade,telefone,dataNascimento,profissao, estaTrabalhando);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Boolean getEstaTrabalhando() {
        return estaTrabalhando;
    }

    public void setEstaTrabalhando(Boolean estaTrabalhando) {
        this.estaTrabalhando = estaTrabalhando;
    }
}
