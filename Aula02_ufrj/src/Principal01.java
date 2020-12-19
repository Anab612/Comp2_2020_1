import java.util.Scanner;

public class Principal01 {


    /** retorna a quantidade de primos no intervalo
     *  [1, limite] através do crivo Eratóstenes
     * @param limite numero ate o qual voce deseja saber a quantidade de primos existentes
     * @return a quantidade de primos
     */
    public static int[] obterPrimosViaCrivo(int limite){
        boolean [] numerosCompostos = new boolean[limite + 1];
        numerosCompostos[0] = true;
        numerosCompostos[1] = true;

        //crivo
        int passo = 2;
        while(passo < limite + 1){
            for(int numeroASerRiscado = passo*2; numeroASerRiscado < limite+1; numeroASerRiscado+=passo){
                numerosCompostos[numeroASerRiscado] = true;
            }
            int novoPasso = 0;
            for(int candidato = passo + 1; candidato < limite + 1; candidato++){
                if(!numerosCompostos[candidato]){
                    novoPasso = candidato;
                    break;
                }
            }
            if(novoPasso==0){
                break;
            }
            passo = novoPasso;
        }
//        int contPrimos = 0;
//        for(int i = 2; i < limite + 1; i++){
//            if(!numerosCompostos[i]){
//                contPrimos++;
//            }
//        }
        //imprimirArray(numerosCompostos);
        //System.out.println("pos modificação numerosCompostos[0] ---> " + numerosCompostos[0]);

        int[]  primos = new int[limite];
        int contPrimos = 0;
        for(int i = 2; i < limite + 1; i++){
            if(!numerosCompostos[i]){
                primos[contPrimos++] = i;
            }
        }
        int[] novosPrimos = new int[contPrimos];
        for(int i = 0; i < contPrimos; i++){
            novosPrimos[i] = primos[i];
        }
//        int dimensao = 0;
//        for(int i = 0; i < limite + 1; i++){
//            if(!numerosCompostos[i]){
//                dimensao++;
//            }
//        }
//        int[] primos = new int[dimensao];
//        int i = 0;
//        for (int ind = 2; ind < limite + 1; ind++){
//            if (!numerosCompostos[ind]){
//                primos[i++] = ind;
//            }
//        }
        return novosPrimos;
    }

    public static void imprimirArray(int[] numerosCompostos){
        for (int i = 0; i < numerosCompostos.length; i++){
            System.out.printf("primos[%d] = %d\n", i, numerosCompostos[i]);
        }
    }

    // overload
    public static void imprimirArray(boolean[] primos){
        for (int i = 0; i < primos.length; i++){
            System.out.printf("primos[%d] = %s\n", i, primos[i]);
        }
    }

    public static int contarPrimos(int limite){
        int primos = obterPrimosViaCrivo(limite).length;
        return primos;
    }


    /**
     * retorna true se o numero é primo e false caso contrario
     * @param numero o numero que vc quer saber se é primo ou comosto
     * @return true se é primo e false caso contrario
     */
    public static boolean ehPrimo(int numero){
        if (numero < 2){
            return false;
        }
        if(numero == 2){
            return true;
        }
        if(numero % 2 == 0){
            return false;
        }
        int raiz = (int)Math.sqrt(numero);
        for (int i = 3; i <= raiz; i+=2){
            if(numero % i == 0){
                return false;
            }
        }
        return true;
    }

    /** retorna a quantidade de primos no intervalo
     *  [1, limite] via força bruta
     * @param limite numero ate o qual voce deseja saber a quantidade de primos existentes
     * @return a quantidade de primos
     */
    public static int[] obterPrimos(int limite){
        int[] primos = new int[5];
        int cont = 0;
        for(int i = 2; i <= limite; i++){
            if(ehPrimo(i)){
                if(cont == primos.length){
                    int [] novoPrimos = new int[primos.length * 2];
                    for(int j = 0; j < primos.length; j++){
                        novoPrimos[i] = primos[i];
                    }
                    primos = novoPrimos;
                }
                primos[cont++] = i;
            }
        }

//        int [] novosPrimos = new int[cont];
//        for(int i = 0; i < cont; i++){
//            novosPrimos[i] = primos[i];
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
            long fim = System.currentTimeMillis();
            float duracao = (fim - inicio)/1000f;
            System.out.printf("\nA quantidade de primos via força bruta em [1, %d] = %d  \n(duração %.3f segundos)\n\n",x, primos.length, duracao);
            imprimirArray(primos);
            System.out.println("====================================================================");

            inicio = System.currentTimeMillis();
            primos = obterPrimosViaCrivo(x);
            fim = System.currentTimeMillis();
            duracao = (fim - inicio)/1000f;
            System.out.printf("\nA quantidade de primos via crivo em [1, %d] = %d  \n(duração %.3f segundos)\n\n\n",x, primos.length, duracao);
            imprimirArray(primos);
        }
    }
}
