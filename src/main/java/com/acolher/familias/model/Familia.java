package com.acolher.familias.model;

import com.acolher.familias.enums.SituacaoFamiliaEnum;

import javax.persistence.*;
import java.util.List;

@Entity
public class Familia {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String cidade;

    private String cep;

    private String rua;

    private int numero;

    private String bairro;

    private String complemento;

    private SituacaoFamiliaEnum situacaoFamilia;

    @OneToMany(mappedBy="familia")
    private List<Pessoa> pessoa;

    public Familia() {
    }

    public Familia(String cidade, String cep, String rua, int numero, String bairro, String complemento, SituacaoFamiliaEnum situacaoFamilia) {
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.situacaoFamilia = situacaoFamilia;
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

    public SituacaoFamiliaEnum getSituacaoFamilia() {
        return situacaoFamilia;
    }

    public void setSituacaoFamilia(SituacaoFamiliaEnum situacaoFamilia) {
        this.situacaoFamilia = situacaoFamilia;
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
                ", situacaoFamilia='" + situacaoFamilia + '\'' +
                ", pessoa=" + pessoa +
                '}';
    }
}
