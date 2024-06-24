package com.manoelcampos.desconto;

public class DescontoAniversario extends VendaMetodo implements Desconto {
    private Venda venda;

    public DescontoAniversario(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    @Override
    public Venda percentualDesconto() {
        venda.descontoAniversarioClienteCompra(venda.getValorTotal(), venda.getCliente().isAniversario());
        return venda;
    }
}