package com.manoelcampos.desconto;

public class DescontoViaAniversario extends CalcularDescontoViaRegraDeNegocio {
    private Venda venda;

    public DescontoViaAniversario(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    @Override
    public Venda percentualDescontoNaCompra() {
        return percentualDescontoAniversario();
    }
}