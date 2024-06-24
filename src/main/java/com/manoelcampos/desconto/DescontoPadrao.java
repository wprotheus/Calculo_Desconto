package com.manoelcampos.desconto;

public class DescontoPadrao extends VendaMetodo implements Desconto {
    private Venda venda;

    public DescontoPadrao(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    @Override
    public Venda percentualDesconto() {
        venda.descontoPadraoCompra(venda.getValorTotal());
        return venda;
    }
}