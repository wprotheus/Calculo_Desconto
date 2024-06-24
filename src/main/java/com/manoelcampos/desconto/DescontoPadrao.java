package com.manoelcampos.desconto;

public class DescontoPadrao extends VendaMetodo implements Desconto {
    private Venda venda;
    
    public DescontoPadrao(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    private static double descontoPadrao(double valorCompra) {
        return valorCompra * descontoPadrao;
    }

    @Override
    public Venda vendaComDesconto() {
        venda.setDesconto(descontoPadrao(venda.getValorTotal()));
        venda.setValorPagar(venda.getValorTotal() - venda.getDesconto());
        return venda;
    }
}