import com.manoelcampos.desconto.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "João", LocalDate.of(2004, 6, 27));
        Cliente c2 = new Cliente(2, "Maria", LocalDate.of(2004, 5, 2));
        Cliente c3 = new Cliente(3, "Ana", LocalDate.of(1999, 8, 15));

        Venda v1 = new Venda(1, c1, LocalDate.now(), 500.0);
        Venda v2 = new Venda(2, c2, LocalDate.now(), 400.0);
        Venda v3 = new Venda(3, c3, LocalDate.now(), 4080.0); //435 dizima

        DescontoViaAniversario descontoAniversario = new DescontoViaAniversario(v1);
        System.out.println(descontoAniversario.percentualDescontoAniversario());

        DescontoViaPadrao descontoPadrao = new DescontoViaPadrao(v2);
        System.out.println(descontoPadrao.percentualDescontoNaCompra());

        DescontoViaProgressivo descontoProgressivo = new DescontoViaProgressivo(v3);
        System.out.println(descontoProgressivo.percentualDescontoProgressivo());
    }
}