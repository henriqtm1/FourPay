package com.example.fourpay.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CartaoCredito extends Cartao implements Serializable {

    private Double limite = 1000.0;
    private Double valorFatura = 0.0;
    private String dataVencimento = "2001-09-21";
    private List<Compra> compras = new ArrayList<>();
    private List<Apolice> apolices = new ArrayList<>();

    public CartaoCredito() {
    }

    public CartaoCredito(String bandeira, String senha, String dataVencimento) {
        super(bandeira, senha, true);
        this.dataVencimento = dataVencimento;
    }

    public void addApolice(Apolice apolice) {
        apolices.add(apolice);
    }

    public List<Apolice> getApolices() {
        return apolices;
    }

    public void setApolices(List<Apolice> apolices) {
        this.apolices = apolices;
    }

    public String dateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(this.dataVencimento);
    }

    public Date dateAddOneMonth() {
        Calendar calendarAplicacaoTaxa = Calendar.getInstance();
        calendarAplicacaoTaxa.add(Calendar.MONTH, 1);
        return calendarAplicacaoTaxa.getTime();
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public void addCompra(Compra compra) {
        valorFatura += compra.getValor();
        compras.add(compra);
    }

    public String toStringCompras() {
        String resultado = "";
        for (Compra compra : compras) {
            resultado += compra.toString();
            resultado += "\n";
        }
        return resultado;
    }

    public boolean pagarFatura(Conta conta) {
        if (conta.getSaldo() < valorFatura) {
            return false;
        }
        conta.setSaldo(conta.getSaldo() - valorFatura);
        this.valorFatura = 0.0;
        return true;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(Double valorFatura) {
        this.valorFatura = valorFatura;
    }

    public void removeApolice(Apolice apolice){
        apolices.remove(apolice);
    }
}
