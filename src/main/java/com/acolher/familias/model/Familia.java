package com.acolher.familias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Familia {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String endereco;

    @JsonIgnore
    @OneToMany(mappedBy="familia")
    private List<Pessoa> pessoa;

    public Familia() {
    }

    public Familia(Long id, String endereco, List<Pessoa> pessoa) {
        this.id = id;
        this.endereco = endereco;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
