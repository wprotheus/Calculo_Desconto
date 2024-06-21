package com.manoelcampos.desconto;

import java.util.List;

public class DescontoPadrao implements Desconto{
    private static double descontoPadrao(double valorCompra) {
        return valorCompra * descontoPadrao;
    }

    @Override
    public List<Venda> vendaComDesconto(Venda fazerVenda) {
        double desconto = descontoPadrao(fazerVenda.getValorTotal());
        fazerVenda.setDesconto(desconto);
        fazerVenda.setValorPagar(fazerVenda.getValorTotal() - desconto);
        return List.of(fazerVenda);
    }
}