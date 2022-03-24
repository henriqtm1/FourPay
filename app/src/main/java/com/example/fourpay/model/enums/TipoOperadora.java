package com.example.fourpay.model.enums;

public enum TipoOperadora {

    OI(1), CLARO(2), VIVO(3), TIM(4), FOURCALL(5);

    private final int id;

    TipoOperadora(int id){
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
