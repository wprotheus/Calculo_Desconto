package com.manoelcampos.desconto;

public abstract class VendaMetodo {
    private Venda venda;

    public VendaMetodo(Venda venda) {
        this.venda = venda;
    }
}