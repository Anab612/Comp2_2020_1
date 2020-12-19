import java.util.Scanner;

public class Principal00{

    public static void imprimirArray(boolean[] numerosCompostos){
        for(int i = 0; i < numerosCompostos.length; i++){
            System.out.println(String.format("numerosCompostos[%d] = %s", i, numerosCompostos[i]));
        }
        numerosCompostos[0] = false;
    }

    public static void imprimirArrayInteiros(int[] primos){
        for(int i = 0; i < primos.length; i++){
            System.out.println(String.format("primos[%d] = %d", i, primos[i]));
        }
    }

    /**
     * Retorna a quantidade de números primos existentes no intervalo [1, limite]
     * Internamente utiliza o crivo de Eratóstenes
     * @param limite O maior número desejado, fechando o intervalo de busca
     * @return a quantidade de primos naquele intervalo
     */
    public static int[] obterPrimosViaCrivo(int limite){  // TRUE -> COMPOSTO   // FALSE -> TRUE
        boolean[] numerosCompostos;  // ponteiro nullo
        numerosCompostos = new boolean[limite + 1];
        numerosCompostos[0] = true;
        numerosCompostos[1] = true;

        int passo = 2;
        while(passo <= limite){
            for(int numeroASerRiscado = passo*2; numeroASerRiscado <= limite; numeroASerRiscado += passo){ // laço para riscar multiplos
                numerosCompostos[numeroASerRiscado] = true; // true -> compostos
            }
            // o próximo numero que ta como false vai ser o proximo passo
            int novoPasso = 0;
            for(int i = passo + 1; i < numerosCompostos.length; i++){
                if(!numerosCompostos[i]){
                    novoPasso = i;
                    break;
                }
            }
            if(novoPasso == 0){
                break;
            }
            passo = novoPasso;
        }
        // cota os primos que estão marcados com falso
        int contPrimos = 0;
        for (int i = 0; i <= limite; i++){
            if(!numerosCompostos[i]){
                contPrimos++;
            }
        }
        //imprimirArray(numerosCompostos);
        //System.out.println("modificação ----> numerosCompostos[0]: " + numerosCompostos[0]);
        int[] results = new int[contPrimos];
        int ind = 0;
        for(int numero = 2; numero < (limite + 1); numero++){
            if(!numerosCompostos[numero]){
                results[ind++] = numero;
            }
        }
        return results;
    }

    /**
     * Retorna se o número dado é primo
     * @param numero número desejado
     * @return true se o número for primo, falso caso contrário
     */
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
        int raiz = (int) Math.sqrt(numero);
//        if(numero == 2){
//            return true;
//        }
        for(int divisor = 3; divisor <= raiz; divisor += 2){
            if(numero % divisor == 0){
                return false; // eh ***composto = FALSO***
            }
        }
        return true;
    }

    /**
     * Retorna a quantidade de números primos existentes no intervalo [1, limite]
     * Força bruta para cada numero do intervalo
     * @param limite O maior número desejado, fechando o intervalo de busca
     * @return a quantidade de primos naquele intervalo
     */
    public static int[] obterPrimos(int limite){ // vetor inteiros com os primos
        int[] primos = new int[limite];
        int cont = 0;
        for (int x = 0; x <= limite; x++){
            if(ehPrimo(x)){
                primos[cont++] = x;
            }
        }
        int[] results = new int[cont];
        for(int ind = 0; ind < cont; ind++){
            results[ind] = primos[ind];
        }
        return results;
    }

//    /**
//     * Retorna todos os primos em um limite [1, limite] ordenados em ordem crescente
//     * @param limite O número que fecha o limite desejado
//     * @return Array de inteiros contendo os primos (o tamanho do array será exato)
//     */

    ///  PEQUENA (faz o que as grandes faziam antes)

    public static int contarPrimos(int limite){
        int[] primos = obterPrimosViaCrivo(limite);
        return primos.length;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Digite o número: ");
            int x = scanner.nextInt();
            if(x < 0){
                return;
            }

            long inicio = System.currentTimeMillis();
            int[] primos = obterPrimos(x);
            long termino = System.currentTimeMillis();
            float duracao = (termino - inicio)/1000f;
            System.out.println("Crivo de Eratóstenes");
            System.out.println(String.format("Quantidade de primos em [1, %d] = %d (duracao: %.3f segundos)", x, primos.length, duracao));
            imprimirArrayInteiros(primos);

            System.out.printf("\n****************************\n");

            System.out.println("Força bruta");
            inicio = System.currentTimeMillis();
            primos = obterPrimosViaCrivo(x);
            termino = System.currentTimeMillis();
            duracao = (termino - inicio)/1000f;
            System.out.println(String.format("Quantidade de primos em [1, %d] = %d (duracao: %.3f segundos)", x, primos.length, duracao));
            imprimirArrayInteiros(primos);




        }
    }
}




