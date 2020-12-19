import java.util.Scanner;

public class Principal02 {

    // OVERLOAD
    public static void imprimirArrayInteiros(int[] numerosCompostos){
        for(int i = 0; i < numerosCompostos.length; i++){
            System.out.println(String.format("numerosPrimos[%d] = %d", i, numerosCompostos[i]));
        }
    }
    public static void imprimirArray(boolean[] numerosCompostos){
        for(int i = 0; i < numerosCompostos.length; i++){
            System.out.println(String.format("numerosCompostos[%d] = %s", i, numerosCompostos[i]));
            numerosCompostos[0] = false;
        }
    }

    /**
     * Retorna a quantidade de primos ate um limite dado
     * @param limite O limite desejado
     * @return
     */
    public static int[] obterPrimosViaCrivo(int limite){
        boolean[] numerosCompostos = new boolean[limite + 1];
        numerosCompostos[0] = true;
        numerosCompostos[1] = true;

        // crivo
        int passo = 2;
        while(passo < (limite + 1)){
            for(int numeroASerRiscado = passo*2; numeroASerRiscado < (limite + 1); numeroASerRiscado += passo){
                numerosCompostos[numeroASerRiscado] = true;
            }
            int novoPasso = 0;
            for(int candidato = (passo + 1); candidato < (limite + 1); candidato++){
                if(!numerosCompostos[candidato]){
                    novoPasso = candidato;
                    break;
                }
            }
            if(novoPasso == 0) break;
            passo = novoPasso;
        }
        int[] primos = new int[limite];
        int contPrimos = 0;
        for(int i = 2; i < (limite + 1); i++){
            if(!numerosCompostos[i]){
                primos[contPrimos++] = i;
            }
        }
        int[] novosPrimos = new int[contPrimos];
        for(int pos = 0; pos < contPrimos; pos++){
            novosPrimos[pos] = primos[pos];
        }

        //imprimirArray(numerosCompostos);
        //System.out.println("após modificação --> numerosCompostos[0] = " + numerosCompostos[0]);
//        int dimensao = contarPrimos(limite);
//        int[] primos = new int[dimensao];
//        int ind = 0;
//        for(int numero = 2; numero < (limite + 1); limite++){
//            if(!numerosCompostos[numero]){
//                primos[ind++] = numero;
//            }
//        }
//        return primos;
//        int contPrimos = 0;
//        for (int i = 0; i < (limite + 1); i++){
//
//        }
        return novosPrimos;
    }

    /**
     * Diz o número é primo ou não, se for retorna true, caso contrário retorna false
     * @param x O número que queremos saber se é primo
     * @return
     */
    public static boolean ehPrimo(int x){
        if(x == 2){
            return true;
        }
        if(x < 2 || (x % 2 == 0)){
            return false;
        }
        int raiz = (int)Math.sqrt(x);
        for(int i = 3; i <= raiz; i += 2){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }

    public static int contarPrimos(int numero){
        int[] primos = obterPrimosViaCrivo(numero);
        return primos.length;
    }

    /**
     * Retorna a quantidade de primos no intervalo [1, limite]
     * @param limite o número que fecha o limite de busca
     * @return
     */
    public static int[] obterPrimos(int limite){
        int[] primos = new int[5];
        int quantPrimos = 0;

        for(int i = 2; i <= limite; i++){
            if(ehPrimo(i)){
                if(quantPrimos == primos.length){
                    int[] novosPrimos = new int[primos.length*2];
                    for(int pos = 0; pos < primos.length; pos++){
                        novosPrimos[pos] = primos[pos];
                    }
                    primos = novosPrimos;
                }
                primos[quantPrimos++] = i;
            }
        }
//        int[] novosPrimos = new int[quantPrimos];
//        for(int ind = 0; ind < quantPrimos; ind++){
//            novosPrimos[ind] = numerosPrimos[ind];
//        }
        return primos;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Digite um número positivo: ");
            int x = scanner.nextInt();
            if(x < 0){
                break;
            }
            long inicio = System.currentTimeMillis();
            int[] primos = obterPrimos(x);
            long termino = System.currentTimeMillis();
            float duracao = (termino - inicio)/1000f;
            System.out.println(String.format("Quantidade de primos em [1, %d] = %d [duração: %.3f segundos]", x, primos.length, duracao));
            imprimirArrayInteiros(primos);

            System.out.printf("\n*****\n\n");

            inicio = System.currentTimeMillis();
            primos = obterPrimosViaCrivo(x);
            termino = System.currentTimeMillis();
            duracao = (termino - inicio)/1000f;
            System.out.println(String.format("Quantidade de primos em [1, %d] = %d [duração: %.3f segundos]", x, primos.length, duracao));
            imprimirArrayInteiros(primos);
        }

    }
}

















