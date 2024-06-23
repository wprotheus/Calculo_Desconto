package com.manoelcampos.desconto;

import java.util.List;

public interface Desconto {
    double descontoPadrao = 0.08;
    double descontoAniversario = 0.15;
    double descontoProgressivo = 0.20;

    List<Venda> vendaComDesconto(Venda fazerVenda);
}