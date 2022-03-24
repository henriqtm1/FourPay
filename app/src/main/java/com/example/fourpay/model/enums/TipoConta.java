package com.example.fourpay.model.enums;

public enum TipoConta {

    CORRENTE(1), POUPANCA(2);

    private final int id;

    TipoConta(int id){
            this.id = id;

    }
    public int getId() {
            return id;
        }

    public static TipoConta valueOf(int id){
        for(TipoConta value: TipoConta.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Tipo Inválido");
    }
}