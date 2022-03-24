package com.example.fourpay.model.enums;

public enum TipoCliente {
    COMUM(1), SUPER(2), PREMIUM(3);

    private final int id;

    TipoCliente(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TipoCliente valueOf(int id){
        for(TipoCliente value: TipoCliente.values()){
            if(value.getId() == id){
                return value;
            }
        }
        throw new IllegalArgumentException("Tipo Inválido");
    }
}
