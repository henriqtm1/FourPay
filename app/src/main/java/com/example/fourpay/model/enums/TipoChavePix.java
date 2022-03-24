package com.example.fourpay.model.enums;


public enum TipoChavePix {
    CPF(1), EMAIL(2), TELEFONE(3), ALEATORIO(4);

    private final int id;

    TipoChavePix(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TipoChavePix valueOf(int id){
        for(TipoChavePix value: TipoChavePix.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Tipo Inválido");
    }
}
