package com.manoelcampos.desconto;

public class DescontoProgressivo extends VendaMetodo implements Desconto {
    private Venda venda;

    public DescontoProgressivo(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    private static double descontoProgressivo(double valorCompra) {
        return (valorCompra * 0.04) / 100;
    }

    @Override
    public Venda vendaComDesconto() {
        double percentual = descontoProgressivo(venda.getValorTotal());
        venda.setDesconto(venda.getValorTotal() * desconto(percentual));
        venda.setValorPagar(venda.getValorTotal() - venda.getDesconto());
        return venda;
    }

    private double desconto(double percentual) {
        return percentual > 0.19 ? descontoProgressivo : percentual;
    }
}