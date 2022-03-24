package com.example.fourpay.model;

import com.example.fourpay.model.enums.TipoChavePix;

import java.io.Serializable;
import java.util.Objects;


public class Pix implements Serializable {

    private Long id;
    private TipoChavePix chavePix = TipoChavePix.CPF;
    private Double valor = 0.0;
    private String conteudoChave = "";
    private Boolean isAtivado = false;
    private Conta conta = new Conta();

    public Pix() {
    }

    public Pix(TipoChavePix chavePix, double valor, String conteudoChave, boolean isAtivado, Conta conta) {
        this.chavePix = chavePix;
        this.valor = valor;
        this.conteudoChave = conteudoChave;
        this.isAtivado = isAtivado;
        this.conta = conta;
    }

    public Pix(TipoChavePix chavePix, String conteudoChave, boolean isAtivado, Conta conta) {
        this.chavePix = chavePix;
        this.conteudoChave = conteudoChave;
        this.isAtivado = isAtivado;
        this.conta = conta;
    }

    public void ativarChave(TipoChavePix chavePix,String conteudoChave){
        this.chavePix = chavePix;
        this.conteudoChave = conteudoChave;
        this.isAtivado = true;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public TipoChavePix getChavePix() {
        return chavePix;
    }

    public void setChavePix(TipoChavePix chavePix) {
        this.chavePix = chavePix;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getConteudoChave() {
        return conteudoChave;
    }

    public void setConteudoChave(String conteudoChave) {
        this.conteudoChave = conteudoChave;
    }

    public boolean isAtivado() {
        return isAtivado;
    }

    public void setAtivado(boolean ativado) {
        isAtivado = ativado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pix pix = (Pix) o;
        return id.equals(pix.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
