package com.example.fourpay.model;

import java.io.Serializable;

public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private double valorEmprestimo = 0d;
    private int qtdParcelas = 1;
    private int dataPagamento = 2;

    public Emprestimo() {}

    public Emprestimo(double valorEmprestimo, int qtdParcelas, int dataPagamento) {
        this.valorEmprestimo = valorEmprestimo;
        this.qtdParcelas = qtdParcelas;
        this.dataPagamento = dataPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public int getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(int dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }
}
