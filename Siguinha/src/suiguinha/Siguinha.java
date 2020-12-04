
package suiguinha;
import java.util.Scanner;
public class Siguinha {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Aluno meuAluno = new Aluno();
        System.out.print("Digite o nome do aluno: ");
        String nome2 = sc.nextLine();
        meuAluno.setNome(nome2);
        System.out.println(meuAluno.getNome());

            System.out.print("Digite: ");
            String coisa = sc.nextLine();
            System.out.println(coisa);


    }
}

