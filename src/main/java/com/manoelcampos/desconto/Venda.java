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
        tipoDesconto("padrao");
        valorDesconto(valorCompra, desconto);
    }

    void descontoAniversarioClienteCompra(double valorCompra, boolean aniversario) {
        double desconto = aniversario ? Desconto.descontoAniversario : Desconto.descontoPadrao;
        tipoDesconto("aniversario");
        valorDesconto(valorCompra, desconto);
    }

    void descontoProgressivoCompra(double valorCompra) {
        double percentual = percentualDesconto(valorCompra);
        double desconto = descontoPercentual(percentual);
        tipoDesconto(String.valueOf(desconto * 100));
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
        String formaDesconto = getFormaDesconto();
        return new StringBuilder("Venda-ID: ").append(id)
                .append("\n")
                .append(cliente).append("\n")
                .append("Valor Total: ").append(real.format(valorTotal))
                .append("\n").append("Descontos: ")
                .append(formaDesconto).append("\n")
                .append("Valor a pagar: ")
                .append(real.format(valorPagar))
                .append("\n").toString();
    }

    private String getFormaDesconto() {
        String formaDesconto;
        if (tipoDesconto.equals("aniversario"))
            formaDesconto = "15 %";
        else if (tipoDesconto.equals("padrao"))
            formaDesconto = "8 %";
        else if (tipoDesconto.equals("0.2"))
            formaDesconto = "20 %";
        else
            formaDesconto = tipoDesconto + " %";
        return formaDesconto;
    }
}