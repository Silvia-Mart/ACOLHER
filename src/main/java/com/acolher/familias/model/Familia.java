package com.acolher.familias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Familia {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;
    @NotBlank
    private String rua;
    @NotBlank
    private int numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String complemento;

    @OneToMany(mappedBy="familia")
    private List<Pessoa> pessoa;

    public Familia() {
    }

    public Familia(Long id, String cidade, String cep, String rua, int numero, String bairro, String complemento, List<Pessoa> pessoa) {
        this.id = id;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Familia{" +
                "id=" + id +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
