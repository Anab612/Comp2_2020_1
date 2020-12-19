import java.util.Scanner;

public class Principal01 {

    /**
     * Calcula o MDC entre dois inteiros positivos
     * @param x um dos inteiros
     * @param y outro inteiro
     * @return o MDC entre x e y ou 0 caso um deles nãp seja positivo
     */
    public static int calcularMDC(int x, int y){
//        if(x < y){
//            int aux = x;
//            x = y;
//            y = aux;
//        }
        if(x <= 0 || y <= 0){
            return 0;
        }
        int r = x % y;
        while(r != 0){
            x = y;
            y = r;
            r = x % y;
        }
        return y;
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean meuBoolean = true;
        System.out.println(meuBoolean);
        while(true){
            System.out.println("Digite dois números inteiros: ");

            int x = scanner.nextInt();
            if(x < 0){
                break;
            }
            int y = scanner.nextInt();
            int mdc = calcularMDC(x, y);
            System.out.printf("MDC(%d, %d) = %d\n", x, y, mdc);

        }


    }

}
