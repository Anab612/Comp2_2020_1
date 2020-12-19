import java.util.ArrayList;
import java.util.Scanner;
public class Principal {

    public static void imprimirArrayDeInteiros(int[] primos){
        for(int i = 0; i < primos.length; i++){
            System.out.printf("primos[%d] = %d\n", i, primos[i]);
        }
    }

    public static boolean ehPrimo(int numero){
        if(numero < 2){
            return false;
        }
        if(numero == 2){
            return true;
        }
        if(numero % 2 == 0){
            return false;
        }
        int raiz = (int)Math.sqrt(numero);
        for(int i = 3; i <= raiz; i+= 2){
            if(numero % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void imprimirArrayBooleano(boolean [] array){
        for(int i = 0; i < array.length; i++){
            System.out.printf("numerosCompostos[%d] = %s\n", i, array[i]);
        }
        //array[1] = false;
    }
    public static int[] obterPrimosViaCrivo(int limite){
        boolean[] numerosCompostos = new boolean[limite + 1];
        numerosCompostos[1] = true;
        numerosCompostos[0] = true;

        int passo = 2;
        while(passo <= limite){
            for(int numeroASerRiscado = passo*2 ; numeroASerRiscado <= limite; numeroASerRiscado+=passo){
                numerosCompostos[numeroASerRiscado] = true;
            }
            int novoPasso = 0;
            for(int ind = passo + 1; ind <= limite; ind++){
                if(!numerosCompostos[ind]){
                    novoPasso = ind;
                    break;
                }
            }
            if(novoPasso == 0){
                break;
            }
            passo = novoPasso;
        }

        int quantidadeDePrimos = 0;
        int[] arrayComOsPrimosComFolga = new int[5];

        for(int candidatoAPrimo = 2; candidatoAPrimo <= limite; candidatoAPrimo++){
            if(!numerosCompostos[candidatoAPrimo]){

                if(quantidadeDePrimos >= arrayComOsPrimosComFolga.length){

                    int[] novoArray = new int[2* arrayComOsPrimosComFolga.length];
                    for(int i = 0; i < arrayComOsPrimosComFolga.length; i++){
                        novoArray[i] = arrayComOsPrimosComFolga[i];
                    }
                    arrayComOsPrimosComFolga = novoArray;
                }

                arrayComOsPrimosComFolga[quantidadeDePrimos++] = candidatoAPrimo;
            }
        }
        //deixando o array justo:
//        int[] result = new int[quantidadeDePrimos];
//        for(int i = 0; i < quantidadeDePrimos; i++){
//            result[i]= arrayComOsPrimosComFolga[i];
//        }

        //imprimirArrayBooleano(numerosCompostos);
        //System.out.println("pos atualização -->> numerosCompostos[1] = " + numerosCompostos[1]);

        return arrayComOsPrimosComFolga;
    }

    public static int contarPrimos(int limite){
        int contPrimos = 0;
        int [] array = obterPrimosViaCrivo(limite);
        for(int i = 0; i < array.length; i++){
            if(array[i] != 0){
                contPrimos++;
            }
        }
        return contPrimos;
    }

    public static ArrayList<Integer> obterPrimos(int limite){
        //int dimensao = contarPrimos(limite);
        //int[] arrayComOsPrimos = new int[dimensao];
        ArrayList<Integer> primos = new ArrayList<Integer>();

        int ind = 0;
        for(int candidatoAPrimo = 2; candidatoAPrimo <= limite; candidatoAPrimo++){
            if(ehPrimo(candidatoAPrimo)){
                primos.add(candidatoAPrimo);
            }
        }
        return primos;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Digite um número inteiro positivo: ");
            int x = scanner.nextInt();
            if(x < 0){
                break;
            }
            long inicio = System.currentTimeMillis();
            ArrayList<Integer> primos = obterPrimos(x);
            long termino = System.currentTimeMillis();
            float duracao = (termino - inicio)/1000f;
            System.out.printf("primos no intervalo [1, %d] = %d  (duração %.3f)\n", x, primos.size(), duracao);
            System.out.println(primos);


            inicio = System.currentTimeMillis();
            int[] primo = obterPrimosViaCrivo(x);
            termino = System.currentTimeMillis();
            duracao = (termino - inicio)/1000f;
            System.out.printf("primos no intervalo [1, %d] = %d  (duração %.3f)\n", x, primo.length, duracao);
            imprimirArrayDeInteiros(primo);
        }

    }

}
