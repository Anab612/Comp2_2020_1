public class Principal {

    public static void main(String[] args){

        ContaCorrente minhaConta = new ContaCorrente();
        System.out.println(minhaConta.getSaldoEmReais());
        minhaConta.setSaldoEmReais(100000f);
        System.out.println(minhaConta.getSaldoEmReais());
        System.out.println(minhaConta.getHistoricoDeOperacoes());
//        minhaConta.historicoDeOperacoes.add("Depósito em espécie de 100000");
//        System.out.println(minhaConta.historicoDeOperacoes);
//        minhaConta.saldoEmReais += 120;
//        minhaConta.historicoDeOperacoes.add("Depósito em espécia de 120");
//        System.out.println(minhaConta.historicoDeOperacoes);
        minhaConta.setSaldoEmReais(77f);
        System.out.println(minhaConta.getHistoricoDeOperacoes());


    }
}
