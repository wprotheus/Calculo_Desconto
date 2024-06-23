package com.manoelcampos.desconto;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "João", LocalDate.now());
        Cliente c2 = new Cliente(2, "Maria", LocalDate.of(2004, 5, 2));
        Cliente c3 = new Cliente(3, "Ana", LocalDate.of(1999, 8, 15));

        Venda v1 = new Venda(1, c1, LocalDate.now(), 500.0);
        Venda v2 = new Venda(2, c2, LocalDate.now(), 400.0);
        Venda v3 = new Venda(3, c3, LocalDate.now(), 480.0);

        DescontoAniversario descontoAniversario = new DescontoAniversario();
        DescontoPadrao descontoPadrao = new DescontoPadrao();
        DescontoProgressivo descontoProgressivo = new DescontoProgressivo();

        List<Venda> vcd1 = descontoAniversario.vendaComDesconto(v1);
        vcd1.forEach(System.out::println);

        List<Venda> vcd2 = descontoPadrao.vendaComDesconto(v2);
        vcd2.forEach(System.out::println);

        List<Venda> vcd3 = descontoProgressivo.vendaComDesconto(v3);
        vcd3.forEach(System.out::println);
    }
}