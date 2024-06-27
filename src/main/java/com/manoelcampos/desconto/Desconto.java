package com.manoelcampos.desconto;

public interface Desconto {
    double descontoPadrao = 0.08;
    double descontoAniversario = 0.15;
    double descontoProgressivo = 0.20;

    Venda percentualDescontoNaCompra();
}