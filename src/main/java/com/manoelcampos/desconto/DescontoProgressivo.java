package com.manoelcampos.desconto;

public class DescontoProgressivo extends VendaMetodo implements Desconto {
    private Venda venda;

    public DescontoProgressivo(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    @Override
    public Venda percentualDesconto() {
        venda.descontoProgressivoCompra(venda.getValorTotal());
        return venda;
    }
}