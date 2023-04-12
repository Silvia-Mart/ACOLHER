package com.acolher.familias.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nome;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="familia_id", nullable=false)
    private Familia familia;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Familia familia) {
        this.id = id;
        this.nome = nome;
        this.familia = familia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}
