package com.manoelcampos.desconto;

import java.time.LocalDate;
import java.util.List;

public class DescontoAniversario implements Desconto {
    private static Double descontoAniversario(LocalDate dataAniversario) {
        return dataAniversario.isEqual(LocalDate.now()) ? descontoAniversario : descontoPadrao;
    }

    @Override
    public List<Venda> vendaComDesconto(Venda fazerVenda) {
        double desconto = descontoAniversario(fazerVenda.getCliente().getDataNascimento());
        fazerVenda.setDesconto(fazerVenda.getValorTotal() * desconto);
        fazerVenda.setValorPagar(fazerVenda.getValorTotal() - fazerVenda.getDesconto());
        return List.of(fazerVenda);
    }
}