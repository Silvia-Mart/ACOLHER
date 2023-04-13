package com.acolher.familias.dto;

import com.acolher.familias.enums.SituacaoFamiliaEnum;
import com.acolher.familias.model.Familia;

import javax.validation.constraints.NotBlank;

public class FamiliaDto {
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

    @NotBlank
    private SituacaoFamiliaEnum situacaoFamilia;

    public FamiliaDto() {
    }

    public Familia transferenciaDeDados(){
        return new Familia(cidade,cep,rua,numero,bairro,complemento,situacaoFamilia);
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
}
