package com.manoelcampos.desconto;

public abstract class CalcularDescontoViaRegraDeNegocio implements Desconto {
    private Venda venda;

    public CalcularDescontoViaRegraDeNegocio(Venda venda) {
        this.venda = venda;
    }

    public Venda percentualDescontoAniversario() {
        double desconto = venda.getCliente().isAniversario() ?
                descontoAniversario : descontoPadrao;
        venda.setTipoDesconto((desconto * 100) + " %");
        venda.valorCompraComDesconto(venda.getValorTotal(), desconto);
        return venda;
    }

    public Venda percentualDescontoPadrao() {
        venda.setTipoDesconto((descontoPadrao * 100) + " %");
        venda.valorCompraComDesconto(venda.getValorTotal(), descontoPadrao);
        return venda;
    }

    public Venda percentualDescontoProgressivo() {
        double percentual = (venda.getValorTotal() * 0.04) / 100;
        double desconto = descontoPercentual(percentual);
        venda.setTipoDesconto(String.format("%.2f", (desconto * 100)) + " %");
        venda.valorCompraComDesconto(venda.getValorTotal(), desconto);
        return venda;
    }

    private double descontoPercentual(double percentual) {
        return percentual > 0.19 ? descontoProgressivo : percentual;
    }
}