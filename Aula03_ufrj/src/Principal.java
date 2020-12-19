import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void imprimirArray(int[] primos){
        for(int ind = 0; ind < primos.length; ind++){
            System.out.printf("primos[%d] = %d\n", ind, primos[ind]);
        }
    }

    public static void imprimirArray(boolean[] numerosCompostos){
        for (int ind = 0; ind < numerosCompostos.length; ind++){
            System.out.printf("numerosCompostos[%d] = %s\n", ind, numerosCompostos[ind]);
        }
        numerosCompostos[0] = false;
    }

    public static int[] obterPrimosViaCrivo(int limite){
        boolean[] numerosCompostos = new boolean[limite + 1];
        numerosCompostos[0] = true;  // true se é composto
        numerosCompostos[1] = true;
        int passo = 2;
        while(passo <= limite) {
            for (int numeroASerRiscado = passo * 2; numeroASerRiscado <= limite; numeroASerRiscado += passo) {
                numerosCompostos[numeroASerRiscado] = true;
            }
            int novoPasso = 0;
            for(int i = passo + 1; i <= limite; i++){
                if(!numerosCompostos[i]){
                    novoPasso = i;
                    break;
                }
            }
            if(novoPasso == 0) break;
            passo = novoPasso;
        }
        int quantPrimos = 0;
        for (int i = 2; i <= limite; i++){
            if(!numerosCompostos[i]){
                quantPrimos++;
            }
        }
//        int[] primos = new int[quantPrimos];
//        int indice = 0;
//        for (int candidatoAPrimo = 2; candidatoAPrimo <= limite; candidatoAPrimo++){
//            if(ehPrimo(candidatoAPrimo)){
//                primos[indice++] = candidatoAPrimo;
//            }
//        }

        int[] primos = new int[5];
        int indice = 0;
        for (int candidatoAPrimo = 2; candidatoAPrimo <= limite; candidatoAPrimo++){

            if(ehPrimo(candidatoAPrimo)){
                if(indice == primos.length){
                    int[] novoPrimos = new int[primos.length*2];
                    for(int i = 0; i < indice; i++){
                        novoPrimos[i] = primos[i];
                    }
                    primos = novoPrimos;
                }
                primos[indice++] = candidatoAPrimo;
            }
        }
//        imprimirArray(numerosCompostos);
//        System.out.printf("Após modificação --> numerosCompostos[0]: %s\n", numerosCompostos[0]);
        return primos;
    }

    public static boolean ehPrimo(int num){
        if(num < 2){
            return false;
        }
        if (num == 2) return true;
        if(num % 2 == 0) return false;
        int raiz = (int)Math.sqrt(num);
        for(int i = 3; i <= raiz; i += 2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static int contarPrimos(int limite){
        return obterPrimosViaCrivo(limite).length;
    }

    public static ArrayList<Integer> obterPrimos(int limite){
        //int primosComFolga[] = obterPrimosViaCrivo(limite);
        ArrayList<Integer> primos = new ArrayList<>();
//        int quantPrimos = 0;
//        for(int i = 0; i < primosComFolga.length; i++){
//            if(primosComFolga[i] != 0){
//                quantPrimos++;
//            }
//        }
//        int[] primos = new int[quantPrimos];
//        int indice = 0;
        int ind = 0;
        for(int candidatoAPrimo = 2; candidatoAPrimo <= limite; candidatoAPrimo++){
            if(ehPrimo(candidatoAPrimo)){
                //primos[ind++] = candidatoAPrimo;
                primos.add(candidatoAPrimo);
            }
        }
        return primos;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(true) {

            System.out.print("Digite um inteiro positivo: ");

            int x = scanner.nextInt();
            if(x < 0) break;
            long inicio = System.currentTimeMillis();
            ArrayList<Integer> primos = obterPrimos(x);
            long termino = System.currentTimeMillis();
            float duracao = (termino - inicio)/1000f;
            System.out.printf("Via força bruta\nQuantidade de primos em [1, %d] = %d (duracao: %.3f)\n", x, primos.stream().count(), duracao);

            //imprimirArray(primos);
            System.out.println(primos);

            int[] primos2;
            inicio = System.currentTimeMillis();
            primos2 = obterPrimosViaCrivo(x);
            termino = System.currentTimeMillis();
            duracao = (termino - inicio)/1000f;
            System.out.printf("Via Crivo\nQuantidade de primos em [1, %d]: %d (duraçao: %.3f)\n", x, primos2.length, duracao);
            imprimirArray(primos2);
        }
    }
}











