import java.util.ArrayList;
import java.util.Date;

public class   ContaCorrente {

    private long numeroDaConta;
    private Agencia agencia;
    private float saldoEmReais;
    private Date dataDeCriacao;
    private Pessoa correntista;
    private ArrayList<String> historicoDeOperacoes = new ArrayList<>();

    public float getSaldoEmReais(){
        return saldoEmReais;
    }

//    public void setSaldoEmReais(float saldoEmReais){
//        if(saldoEmReais < 0){
//            return;
//        }
//        this.saldoEmReais += saldoEmReais;
//        historicoDeOperacoes.add("Saldo em reais modificado para " + this.saldoEmReais + " na data " + new Date());
//    }

    public ArrayList<String> getHistoricoDeOperacoes(){
        return this.historicoDeOperacoes;
    }

    public void depositar(float deposito){
        if(deposito <= 0){
            return;
        }
        this.saldoEmReais += deposito;
        this.historicoDeOperacoes.add("Depósito em dinheiro" + deposito + " na data " + new Date());
    }


}
