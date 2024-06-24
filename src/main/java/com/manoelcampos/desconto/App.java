package com.manoelcampos.desconto;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "João",  LocalDate.of(2004, 6, 24)); //LocalDate.now());
        Cliente c2 = new Cliente(2, "Maria", LocalDate.of(2004, 5, 2));
        Cliente c3 = new Cliente(3, "Ana", LocalDate.of(1999, 8, 15));

        Venda v1 = new Venda(1, c1, LocalDate.now(), 600.0);
        Venda v2 = new Venda(2, c2, LocalDate.now(), 400.0);
        Venda v3 = new Venda(3, c3, LocalDate.now(), 600.0);

        DescontoAniversario descontoAniversario = new DescontoAniversario(v1);
        DescontoPadrao descontoPadrao = new DescontoPadrao(v2);
        DescontoProgressivo descontoProgressivo = new DescontoProgressivo(v3);

        Venda vcd1 = descontoAniversario.vendaComDesconto();
        System.out.println(vcd1);

        Venda vcd2 = descontoPadrao.vendaComDesconto();
        System.out.println(vcd2);

        Venda vcd3 = descontoProgressivo.vendaComDesconto();
        System.out.println(vcd3);
    }
}