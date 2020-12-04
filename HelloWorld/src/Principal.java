import java.util.Scanner;

public class Principal {
    public static int calculaMDC(int num1, int num2){
        if (num1 < num2){
            int aux = num2;
            num2 = num1;
            num1 = aux;
        }
        int res = num1 % num2;
        if(res == 0){
            return num2;
        }
        while (true){
                num1 = num2;
                num2 = res;
                int aux2 = num1 % num2;
                if(aux2 ==
                        0){
                    return res;
                }
                res = aux2;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro numero: ");
        int num1 = sc.nextInt();
        System.out.print("Digite o segundo numero: ");
        int num2 = sc.nextInt();
        System.out.printf("MDC(%d, %d) = %d\n", num1, num2, calculaMDC(num1, num2));
        System.out.printf("MDC(%d, %d) = %d\n", num1, num2, calculaMDC(num1, num2));
        System.out.printf("MDC(%d, %d) = %d\n", num1, num2, calculaMDC(num1, num2));
    }
}
