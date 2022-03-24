package com.example.fourpay.model;

import java.io.Serializable;

public class CartaoDebito extends Cartao implements Serializable {

    private Double limitePorTransacao = 0.0;

    public CartaoDebito() {
    }

    public CartaoDebito(String bandeira, String senha, Double limitePorTransacao) {
        super(bandeira, senha, true);
        this.limitePorTransacao = limitePorTransacao;
    }

    public Double getLimitePorTransacao() {
        return limitePorTransacao;
    }

    public void setLimitePorTransacao(Double limitePorTransacao) {
        this.limitePorTransacao = limitePorTransacao;
    }
}
