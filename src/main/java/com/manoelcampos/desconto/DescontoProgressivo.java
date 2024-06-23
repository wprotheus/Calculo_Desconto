package com.manoelcampos.desconto;

import java.util.List;

public class DescontoProgressivo implements Desconto {
    private static double descontoProgressivo(double valorCompra) {
        return (valorCompra * 0.04) / 100;
    }

    @Override
    public List<Venda> vendaComDesconto(Venda fazerVenda) {
        double percentual = descontoProgressivo(fazerVenda.getValorTotal());
        fazerVenda.setDesconto(fazerVenda.getValorTotal() * desconto(percentual));
        fazerVenda.setValorPagar(fazerVenda.getValorTotal() - fazerVenda.getDesconto());
        return List.of(fazerVenda);
    }

    private double desconto(double percentual) {
        return percentual > 0.19 ? descontoProgressivo : percentual;
    }
}