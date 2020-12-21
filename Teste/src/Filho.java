public class Filho extends Pai {
    String escola;
    String corFavorita;
    int numeroDaChamada;

    public Filho(String nome, int idade, int numeroDaChamada){
        super(nome, idade);
        this.numeroDaChamada = numeroDaChamada;
    }

    public int getNumeroDaChamada() {
        return numeroDaChamada;
    }
}
