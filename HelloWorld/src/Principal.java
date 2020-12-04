import java.util.Scanner;

public class Principal {
    public static int calculaMDC(int x, int num2){
        if (x < num2){
            int aux = num2;
            num2 = x;
            x = aux;
        }
        int res = x % num2;
        if(res == 0){
            return num2;
        }
        while (true){
                x = num2;
                num2 = res;
                int aux2 = x % num2;
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
