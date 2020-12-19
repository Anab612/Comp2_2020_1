import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        ContaCorrente minhaConta = new ContaCorrente();
        //minhaConta.historicoDeOperacao = new ArrayList<>();

        //System.out.println(minhaConta.saldoEmReais);
        //minhaConta.saldoEmReais = 1000000;
        //System.out.println(minhaConta.saldoEmReais);
        //minhaConta.historicoDeOperacao.add("Depósito em espécie de 1000000");
        //System.out.println(minhaConta.historicoDeOperacao);

        System.out.println(minhaConta.getSaldoEmReais());

        minhaConta.depositar(10000);
        System.out.println(minhaConta.getSaldoEmReais());
        System.out.println(minhaConta.getHistoricoDeOperacao());

        minhaConta.depositar(1000);
        System.out.println(minhaConta.getSaldoEmReais());
        System.out.println(minhaConta.getHistoricoDeOperacao());

        minhaConta.sacar(11000);
        System.out.println(minhaConta.getSaldoEmReais());
        System.out.println(minhaConta.getHistoricoDeOperacao());

        Pessoa fulano = new Pessoa("fulano", 1234);
        System.out.println(fulano);
    }
}
