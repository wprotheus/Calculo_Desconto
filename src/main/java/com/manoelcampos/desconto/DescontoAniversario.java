package com.manoelcampos.desconto;

public class DescontoAniversario extends VendaMetodo implements Desconto {
    private Venda venda;

   public DescontoAniversario(Venda venda) {
        super(venda);
        this.venda = venda;
    }

    @Override
    public Venda vendaComDesconto() {
        double desconto = venda.getCliente().isAniversario() ? descontoAniversario : descontoPadrao;
        venda.setDesconto(venda.getValorTotal() * desconto);
        venda.setValorPagar(venda.getValorTotal() - venda.getDesconto());
        return venda;
    }
}