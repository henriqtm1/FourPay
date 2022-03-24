package com.example.fourpay.model;

import com.example.fourpay.model.enums.TipoOperadora;

import java.io.Serializable;
import java.util.Objects;

public class Recarga implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String numero = "+55(74)99963-7391";
    private Double valor = 0d;
    private TipoOperadora operadora = TipoOperadora.CLARO;
    private Conta conta = new Conta();

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoOperadora getOperadora() {
        return operadora;
    }

    public void setOperadora(TipoOperadora operadora) {
        this.operadora = operadora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recarga recarga = (Recarga) o;
        return Objects.equals(id, recarga.id) && Objects.equals(numero, recarga.numero) && Objects.equals(valor, recarga.valor) && operadora == recarga.operadora;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, valor, operadora);
    }
}
