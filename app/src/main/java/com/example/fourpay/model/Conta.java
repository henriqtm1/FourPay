package com.example.fourpay.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.fourpay.model.enums.TipoConta;

public class Conta implements Serializable {

    private Long id;

    private Double saldo = 0.0;

    private String senha;

    private Cliente cliente = new Cliente();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getCliente() {
        return cliente;
    }
}