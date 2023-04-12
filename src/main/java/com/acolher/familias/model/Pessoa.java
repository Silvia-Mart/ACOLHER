package com.acolher.familias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String nomeCompleto;
    @NotNull
    private int idade;
    @NotBlank
    private String telefone;
    @NotNull
    @Past
    private Date dataNascimento;
    @NotBlank
    private String profissao;
    @NotNull
    private Boolean isTrabalha;

    private LocalDateTime dataCadastro = LocalDateTime.now();


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="familia_id", nullable=false)
    private Familia familia;

    public Pessoa() {
    }

    public Pessoa(Long id, String nomeCompleto, int idade, String telefone, Date dataNascimento, String profissao, Boolean isTrabalha, LocalDateTime dataCadastro, Familia familia) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.isTrabalha = isTrabalha;
        this.dataCadastro = dataCadastro;
        this.familia = familia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
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

    public Boolean getTrabalha() {
        return isTrabalha;
    }

    public void setTrabalha(Boolean trabalha) {
        isTrabalha = trabalha;
    }

    public  LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro( LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", profissao='" + profissao + '\'' +
                ", isTrabalha=" + isTrabalha +
                ", dataCadastro=" + dataCadastro +
                ", familia=" + familia +
                '}';
    }
}
