import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {

    public static final float SALDO_INICIAL_DE_NOVAS_CONTAS = 10.0f;

    private float saldoEmReais;

    private final long numeroDaConta;

    private final Agencia agencia;

    private Date dataDeCriacao;

    private Pessoa correntista;

    private Pessoa gerenteDaConta;

    private ArrayList<String> historicoDeOperacoes;

    public ContaCorrente(Pessoa correntista, Agencia agencia){
        this.historicoDeOperacoes = new ArrayList<>();
        this.dataDeCriacao = new Date();
        this.saldoEmReais = SALDO_INICIAL_DE_NOVAS_CONTAS;

        // ToDo: FIX ME!!
        this.numeroDaConta = 0; // ......................;
        this.correntista = correntista;
        this.agencia = agencia;
    }

    public long getNumeroDaConta(){
        return this.numeroDaConta;
    }

    public float getSaldoEmReais(){
        return this.saldoEmReais;
    }

    void depositar(float deposito){

        if (deposito <= 0){
            return;
        }

        this.saldoEmReais += deposito;
        this.historicoDeOperacoes.add(String.format("Deposito em dinheiro de R$%.2f na data %s", deposito, new Date()));
    }

    public void sacar(float valor){
        // valida o parâmetro
        if (valor <= 0){
            return; // ToDo: lançar exceção!!!
        }

        // verifica se há fundos na conta
        if (valor > this.saldoEmReais){
            return; // ToDo: lançar exceção
        }

        this.saldoEmReais -= valor;
        this.historicoDeOperacoes.add(String.format("Saque em dinheiro de R$%.2f na data %s", this.saldoEmReais, new Date()));

    }

    /**
     * Transfere um valor desta conta para a conta de destino informada, se houver saldo suficiente
     * nesta conta.
     * @param valor o valor desejado
     * @param contaDestino a conta de destino
     */
    public void transferir(float valor, ContaCorrente contaDestino){
        // valida o parâmetro
        if (valor <= 0){
            return; // ToDo: lançar exceção!!!
        }

        // verifica se há fundos na conta
        if (valor > this.saldoEmReais){
            return; // ToDo: lançar exceção
        }

        this.saldoEmReais -= valor;
        contaDestino.saldoEmReais += valor;
        

        this.historicoDeOperacoes.add(String.format("Tranferência efetuada para a conta  %d: R$%.2f na data %s", contaDestino.numeroDaConta, valor, new Date()));
        contaDestino.historicoDeOperacoes.add(String.format("Tranferência recebida da a conta  %d: R$%.2f na data %s", this.numeroDaConta, valor, new Date()));
    }

}








