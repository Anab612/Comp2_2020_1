import jdk.swing.interop.SwingInterOpUtils;

public class Principal {

    public static void main(String[] args){
        Pessoa fulano  = new Pessoa("Fulano de Tal", 12345678);
        fulano.setEndereco("Rua BlaBlaBla, numero tal");

        Agencia agencia = new Agencia();

        ContaCorrente minhaConta = new ContaCorrente(1, fulano, agencia);

        System.out.println(minhaConta.getSaldoEmReais());

        minhaConta.depositar(1000);
        System.out.println(minhaConta.getSaldoEmReais());

        minhaConta. depositar(1000);
        System.out.println(minhaConta.getSaldoEmReais());


        System.out.println(fulano);

        int x;
        long y = Long.MAX_VALUE;
        System.out.println(y);
        x = (int)y;
        System.out.println(x);

        float m;
        double n = Double.MAX_VALUE;
        System.out.println(n);
        m = (float)n;
        System.out.println(m);

        x = Integer.MAX_VALUE;
        System.out.println(x);

    }
}










