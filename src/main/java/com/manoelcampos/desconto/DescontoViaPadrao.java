package com.manoelcampos.desconto;

public class DescontoViaPadrao extends CalcularDescontoViaRegraDeNegocio {
    private Venda venda;

    public DescontoViaPadrao(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    @Override
    public Venda percentualDescontoNaCompra() {
        return percentualDescontoPadrao();
    }
}