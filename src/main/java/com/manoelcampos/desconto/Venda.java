package com.manoelcampos.desconto;

import lombok.Data;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

/**
 * Venda realizada para um {@link Cliente}.
 *
 * @author Manoel Campos da Silva Filho
 */
@Data
public class Venda {
    private long id;
    private Cliente cliente;
    private LocalDate data = LocalDate.now();
    private double valorTotal;
    private String tipoDesconto;
    private double valorPagar;

    public Venda() {/**/}

    public Venda(long id, Cliente cliente, LocalDate data, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    void valorCompraComDesconto(double valorCompra, double desconto) {
        this.valorPagar = valorCompra - (valorCompra * desconto);
    }

    @Override
    public String toString() {
        NumberFormat real = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return "Venda-ID: " + id +
                "\n" +
                cliente + "\n" +
                "Valor Total: " + real.format(valorTotal) +
                "\n" + "Descontos: " +
                tipoDesconto + "\n" +
                "Valor a pagar: " +
                real.format(valorPagar) +
                "\n";
    }
}