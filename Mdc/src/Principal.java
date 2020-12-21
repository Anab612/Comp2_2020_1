import java.util.Scanner;

public class Principal {

    public static int calcularMDC(int n1, int n2){
        if (n1<= 0 || n2 <= 0){
            return 0;
        }
        int resto = n1 % n2;
        while (resto != 0){
            n1 = n2;
            n2 = resto;
            resto = n1 % n2;
        }
        return n2;
    }

    public static void main(String[] args){
        int n1;
        int n2;


        System.out.print("Digite dois numeros positivos: ");
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
//        if (n1 <= 0 || n2 <= 0){
//            break;
//        }
        System.out.printf(String.format("MDC(%d, %d) = %d\n", n1, n2, calcularMDC(n1, n2)));

    }
}
