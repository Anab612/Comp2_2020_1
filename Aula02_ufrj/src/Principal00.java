import java.util.Scanner;

public class Principal00{

    public static void imprimirArray(boolean[] numerosCompostos){
        for(int pos = 0; pos < (numerosCompostos.length); pos++){
            System.out.printf("numerosCompostos[%d] = %s\n", pos, numerosCompostos[pos]);
        }
        numerosCompostos[0] = false; // mudou o array por referencia
    }

    public static void imprimirArrayDeInteiros(int [] primos){
        for(int i = 0; i < primos.length; i++){
            System.out.printf("primos[%d] = %d\n", i, primos[i]);
        }
        System.out.println("\n\n");
    }


    /**
     * retorna a quantodade de numeros primos
     * no intervalo [1, limite]
     * internamente utiliza o crivo de Eratóstenes
     * @param limite o maior numero desejado, fechando o intervalo de busca
     * @return a quantidade de primos naquele intervalo
     */
    public static int[] obterPrimosViaCrivo(int limite){
        boolean [] numerosCompostos; // null
        //tudo false a principio
        // riscar é colocar true
        //todos os primos serao false, os compostos serao true
        //por nao ter inicializado, dá pra perceber que os primos serão 'false'
        numerosCompostos = new boolean[limite + 1];
        numerosCompostos[0] = true; // 0 é composto
        numerosCompostos[1] = true; // 1 é composto

        //crivo
        int passo = 2;
        while(passo <= limite){
            for(int numeroASerRiscado = passo*2; numeroASerRiscado <= limite; numeroASerRiscado += passo){
                numerosCompostos[numeroASerRiscado] = true; // os compostos sao true. Esse numero eh composto porque ele eh multiplo do passo
            }
            int novoPasso = 0;
            for (int i = passo + 1; i < (limite + 1); i++){
                if(!numerosCompostos[i]){
                    novoPasso = i;
                    break;
                }
            }
            if(novoPasso == 0){
                break; // nao ha mais nada a ser feito
            }
            passo = novoPasso;
        }
        int contPrimos = 0;
        //conta os primos que estão marcados com 'false'
        for (int i = 0; i <= limite; i++){
            if(!numerosCompostos[i]){
                contPrimos++;
            }
        }
//        imprimirArray(numerosCompostos);
//        System.out.println(numerosCompostos[0]); // é true

        int [] results = new int[contPrimos];
        int i = 0;
        for (int numero = 2; numero < (limite + 1) ; numero++){
            if(!numerosCompostos[numero]){
                results[i++] = numero;
            }
        }

        return results;
    }

    /**
     * retorna se op numero dado é primo
     * @param numero o numero desejado
     * @return true se for primo, false caso contrário
     */
    public static boolean ehPrimo(int numero){
        if(numero < 2){
            return false; // composto é falso
        }
        if(numero == 2){
            return true;
        }
        if(numero % 2 == 0){
            return false;
        }
//            if(numero == 2){
//                return true; // primo é true
//            }
        int raiz = (int)Math.sqrt(numero);
        for(int divisor = 3; divisor <= raiz; divisor += 2){
            if(numero % divisor == 0){
                return false; // composto é falso
            }
        }
        return true; // primo é true
    }

    /**
     * retorna a quantidade de numeros primos
     * no intervalo [1, limite]
     * força bruta para cada numero do intervalo
     * @param limite o maior numero desejado, fechando o intervalo de busca
     * @return a quantidade de primos naquele intervalo
     */
    public static int[] obterPrimos(int limite){
        int [] primos = new int[limite]; // pre alocando o array com tamanho bem exagerada
        int cont = 0;
        for(int x = 0; x <= limite; x++){
            if(ehPrimo(x)){
                primos[cont++] = x;
            }
        }
        int [] results = new int[cont];

        for (int i = 0; i < cont; i++){
            results[i] = primos[i];
        }

        return results;
    }

    /**
     * retorna a quantidade de numeros primos
     * no intervalo [1, limite]
     * força bruta para cada numero do intervalo
     * @param limite o maior numero desejado, fechando o intervalo de busca
     * @return a quantidade de primos naquele intervalo
     */
    public static int contarPrimos(int limite){
        int[] primos = obterPrimosViaCrivo(limite);
        return primos.length;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Digite um número: ");
            int x = scanner.nextInt();
            if(x < 0){
                return;
            }
            long inicio = System.currentTimeMillis();
            int[] primos = obterPrimos(x);
            long termino = System.currentTimeMillis();
            float duracao = (termino - inicio) / 1000f;
            System.out.println("\n\nPor 'força bruta':");
            System.out.println(String.format("Quantidade de primos em [1, %d] = %d (duração %.3f segundos)", x, primos.length, duracao));
            imprimirArrayDeInteiros(primos);

            inicio = System.currentTimeMillis();
            primos = obterPrimosViaCrivo(x);
            termino = System.currentTimeMillis();
            duracao = (termino - inicio) / 1000f;
            System.out.println("Por crivo de Eratóstenes: ");
            System.out.println(String.format("Quantidade de primos em [1, %d] = %d (duração %.3f segundos)", x, primos.length, duracao));
            imprimirArrayDeInteiros(primos);
        }

    }
}