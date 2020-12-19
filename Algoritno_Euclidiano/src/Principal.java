import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite dois números inteiros: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int mdc = calculaMDC(num1, num2);
        System.out.println("=============================");
        System.out.printf("mdc(%d, %d) = %d", num1, num2, mdc);
    }





    public static int calculaMDC(int x, int y){
        if (x < y){
            int aux = y;
            y = x;
            x = aux;
        }
        if (x % y == 0){
            //System.out.println(y);
            return y;
        }


        //int r = 0;
        //int aux = 0;
        do{
            int aux = x % y;
            x = y;
            y = aux;
        }while(x % y != 0);
        return y;
    }
}
