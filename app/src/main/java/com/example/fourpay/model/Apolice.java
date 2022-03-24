package com.example.fourpay.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Apolice implements Serializable {
    private Long id;
    private Double valorApolice = 0.0;
    private String descricaoCondicoes = "";
    private Seguro seguro = new Seguro();
    private String DataAssinatura = "2001-05-21";
    private String DataCarencia = "2001-05-21";
    /*
    private String dataString1 = "";
    private String dataString2 = "";

     */

    /*
    public String getDataString1() {
        return dataString1;
    }

    public void setDataString1(String dataString) {
        this.dataString1 = dataString;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            this.DataAssinatura = sdf.parse(dataString);
        } catch (ParseException e) {
            this.DataAssinatura = Calendar.getInstance().getTime();
        }
    }

    public String getDataString2() {
        return dataString2;
    }

    public void setDataString2(String dataString) {
        this.dataString2 = dataString;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            this.DataCarencia = sdf.parse(dataString);
        } catch (ParseException e) {
            this.DataCarencia = Calendar.getInstance().getTime();
        }
    }

     */

    public Apolice() {}

    public Apolice(double valorApolice, String descricaoCondicoes, Seguro seguro, String dataAssinatura, String dataCarencia) {
        this.valorApolice = valorApolice;
        this.descricaoCondicoes = descricaoCondicoes;
        this.seguro = seguro;
        DataAssinatura = dataAssinatura;
        DataCarencia = dataCarencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apolice apolice = (Apolice) o;
        return id.equals(apolice.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorApolice() {
        return valorApolice;
    }

    public void setValorApolice(Double valorApolice) {
        this.valorApolice = valorApolice;
    }

    public String getDescricaoCondicoes() {
        return descricaoCondicoes;
    }

    public void setDescricaoCondicoes(String descricaoCondicoes) {
        this.descricaoCondicoes = descricaoCondicoes;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public String getDataAssinatura() {
        return DataAssinatura;
    }

    public void setDataAssinatura(String dataAssinatura) {
        DataAssinatura = dataAssinatura;
    }

    public String getDataCarencia() {
        return DataCarencia;
    }

    public void setDataCarencia(String dataCarencia) {
        DataCarencia = dataCarencia;
    }
}
