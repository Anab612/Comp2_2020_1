import java.util.Scanner;

public class Principal00 {

    /**
     * Calcula o MDC entre dois inteiros positivos
     * @param num1 um dos inteiros
     * @param num2 o outro inteiro
     * @return retorna o MDC entre x e y, ou 0 caso um deles não seja positivo
     */

    public static int calcularMDC(int num1, int num2){
//        if(num1 < num2){
//            int aux = num1;
//            num1 = num2;
//            num2 = aux;
//        }

        if( num1 <= 0 || num2 <= 0){
            return 0;
        }
        int resto = num1 % num2;
        while(resto != 0){
            num1 = num2;
            num2 = resto;
            resto = num1 % num2;
        }
        return num2;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int minhaVariavelDeTeste = 2;
        int MinhaVariavelDeTeste = 9;
        int minhavariavelDeTeste = 7;
//        System.out.println(minhaVariavelDeTeste);
//        System.out.println(MinhaVariavelDeTeste);
//        System.out.println(minhavariavelDeTeste);
        boolean meuBooleano = true;
        System.out.println(meuBooleano);
        while(true) {
            System.out.print("Didite dois números positivos: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(x < 0 || y < 0) break;

            int mdc = calcularMDC(x, y);
            System.out.println(String.format("MDC(%d, %d) = %d", x, y, mdc));
        }
    }
}
