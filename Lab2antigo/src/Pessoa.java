import java.util.Date;

public class Pessoa {

    private String nome;
    private long cpf;
    private Date dataDeNascimento;
    private String endereco;

    public Pessoa(String nome, long cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

}
