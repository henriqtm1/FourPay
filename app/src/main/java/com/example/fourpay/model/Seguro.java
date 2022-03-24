package com.example.fourpay.model;

import java.io.Serializable;
import java.util.Objects;

public class Seguro implements Serializable {

    private Long id;
    private String nome = "";
    private String regras = "";
    private Double valorAno = 0d;

    public Seguro() {
    }

    public Seguro(Long id, String nome, String regras, Double valor) {
        this.id = id;
        this.nome = nome;
        this.regras = regras;
        this.valorAno = valor;
    }

    @Override
    public String toString() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public Double getValorAno() {
        return valorAno;
    }

    public void setValorAno(Double valorAno) {
        this.valorAno = valorAno;
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

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seguro seguro = (Seguro) o;
        return id.equals(seguro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
