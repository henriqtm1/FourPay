package com.example.fourpay.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class Compra implements Serializable {
    private Long id;
    private String nomeProduto = "";
    private String compra = "2001-05-21";
    private Double valor = 0d;

    /*
    private String dataString = "";



    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            this.compra = sdf.parse(dataString);
        } catch (ParseException e) {
            this.compra = Calendar.getInstance().getTime();
        }
    }

     */

    public Compra() {
    }

    public Compra(Long id, String nomeProduto, double valor) {
        this.id = id;
        Calendar calendario = Calendar.getInstance();
        String dataCompra = calendario.getTime().toString();
        this.nomeProduto = nomeProduto;
        this.compra = dataCompra;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataCompra = fmt.format(compra);
        return "Data da Compra: " + dataCompra +
                ", Valor: " + valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return id.equals(compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
