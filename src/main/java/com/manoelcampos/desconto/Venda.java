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

    private static double percentualDesconto(double valorCompra) {
        return (valorCompra * 0.04) / 100;
    }

    void descontoPadraoCompra(double valorCompra) {
        double desconto = Desconto.descontoPadrao;
        tipoDesconto((desconto * 100) + " %");
        valorDesconto(valorCompra, desconto);
    }

    void descontoAniversarioClienteCompra(double valorCompra, boolean aniversario) {
        double desconto = aniversario ? Desconto.descontoAniversario : Desconto.descontoPadrao;
        tipoDesconto((desconto * 100) + " %");
        valorDesconto(valorCompra, desconto);
    }

    void descontoProgressivoCompra(double valorCompra) {
        double percentual = percentualDesconto(valorCompra);
        double desconto = descontoPercentual(percentual);
        tipoDesconto(String.format("%.2f", (desconto * 100)) + " %");
        valorDesconto(valorCompra, desconto);
    }

    private void valorDesconto(double valorCompra, double desconto) {
        this.valorPagar = valorCompra - (valorCompra * desconto);
    }

    private void tipoDesconto(String tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    private double descontoPercentual(double percentual) {
        return percentual > 0.19 ? Desconto.descontoProgressivo : percentual;
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