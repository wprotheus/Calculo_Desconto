package com.manoelcampos.desconto;

import java.util.List;

public class DescontoProgressivo implements Desconto{
    private static double descontoProgressivo(double valorCompra) {
        return valorCompra * descontoPadrao;
    }

    @Override
    public List<Venda> vendaComDesconto(Venda fazerVenda) {
        double percentual = (descontoProgressivo(fazerVenda.getValorTotal())) / 100;
        double desconto = percentual > 0.2 ? fazerVenda.getValorTotal() * descontoProgressivo : fazerVenda.getValorTotal() * percentual;
        fazerVenda.setDesconto(desconto);
        fazerVenda.setValorPagar(fazerVenda.getValorTotal() - desconto);
        return List.of(fazerVenda);
    }
}