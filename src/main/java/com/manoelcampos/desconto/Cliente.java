package com.manoelcampos.desconto;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Cliente da loja.
 *
 * @author Manoel Campos da Silva Filho
 */

@Data
public class Cliente {
    private long id;
    private String nome;
    private LocalDate dataNascimento;

    public Cliente() {/**/}

    public Cliente(long id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    boolean isAniversario() {
        return dataNascimento.getDayOfMonth() == LocalDate.now().getDayOfMonth()
                && dataNascimento.getMonth() == LocalDate.now().getMonth();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new StringBuilder("Cliente-ID: ")
                .append(id).append("\n")
                .append("Nome: ").append(nome).append("\n")
                .append("Data de Nascimento: ")
                .append(dataNascimento.format(formatter))
                .toString();
    }
}