package com.manoelcampos.desconto;

import lombok.Data;

import javax.swing.text.NumberFormatter;
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
    private double valorPagar;
    private double desconto;

    public Venda() {/**/}

    public Venda(long id, Cliente cliente, LocalDate data, double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        NumberFormat real = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return new StringBuilder("Venda-ID: ").append(id)
                .append("\n")
                .append(cliente).append("\n")
                .append("Valor Total: ").append(real.format(valorTotal))
                .append("\n").append("Descontos: ")
                .append(real.format(desconto)).append("\n")
                .append("Valor a pagar: ")
                .append(real.format(valorPagar))
                .append("\n").toString();
    }
}