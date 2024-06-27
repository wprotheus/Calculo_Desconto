package com.manoelcampos.desconto;

public class DescontoViaProgressivo extends CalcularDescontoViaRegraDeNegocio {
    private Venda venda;

    public DescontoViaProgressivo(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    @Override
    public Venda percentualDescontoNaCompra() {
        return percentualDescontoProgressivo();
    }
}