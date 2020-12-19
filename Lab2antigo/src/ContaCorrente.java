import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {

    private long numeroDaConta;
    private Agencia agencia;
    private float saldoEmReais;
    private Date dataDeCriacao;
    private Pessoa correntista;
    private ArrayList<String> historicoDeOperacao = new ArrayList<>();

    public float getSaldoEmReais(){
        return saldoEmReais;
    }

//    public void setSaldoEmReais(float saldoEmReais){
//        if(saldoEmReais < 0){
//            return;
//        }
//        this.saldoEmReais += saldoEmReais;
//        historicoDeOperacao.add("Saldo modificado para " + this.saldoEmReais + " na data " + new Date());
//    }

    public ArrayList<String> getHistoricoDeOperacao(){
        return historicoDeOperacao;
    }

    public void depositar(float valor){
        if(valor <= 0){
            return;
        }
        this.saldoEmReais += valor;
        historicoDeOperacao.add("Deposito em dinheiro: " + valor + " na data " + new Date());
    }

    public void sacar(float saque){
        if(saque <= saldoEmReais){
            saldoEmReais -= saque;
            historicoDeOperacao.add("Saque em dinheiro: " + saque + " na data " + new Date());
        }
    }

}
