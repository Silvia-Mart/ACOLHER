package com.acolher.familias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nomeCompleto;

    private int idade;

    private String telefone;

    private Date dataNascimento;

    private String profissao;

    private Boolean estaTrabalhando;

    private LocalDateTime dataCadastro = LocalDateTime.now();


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="familia_id", nullable=false)
    private Familia familia;

    public Pessoa() {
    }

    public Pessoa(String nomeCompleto, int idade, String telefone, Date dataNascimento, String profissao, Boolean estaTrabalhando) {
        this.nomeCompleto = nomeCompleto;
        this.idade = idade;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.estaTrabalhando = estaTrabalhando;
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

    public Boolean getEstaTrabalhando() {
        return estaTrabalhando;
    }

    public void setEstaTrabalhando(Boolean estaTrabalhando) {
        this.estaTrabalhando = estaTrabalhando;
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
                ", estaTrabalhando=" + estaTrabalhando +
                ", dataCadastro=" + dataCadastro +
                ", familia=" + familia +
                '}';
    }
}
