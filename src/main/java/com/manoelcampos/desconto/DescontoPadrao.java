package com.manoelcampos.desconto;

import java.util.List;

public class DescontoPadrao implements Desconto{
    private static double descontoPadrao(double valorCompra) {
        return valorCompra * descontoPadrao;
    }

    @Override
    public List<Venda> vendaComDesconto(Venda fazerVenda) {
        fazerVenda.setDesconto(descontoPadrao(fazerVenda.getValorTotal()));
        fazerVenda.setValorPagar(fazerVenda.getValorTotal() - fazerVenda.getDesconto());
        return List.of(fazerVenda);
    }
}