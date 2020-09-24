public class Knapsack {

    static int contador;

    public static void main(String[] args) {

        //problema da mochila
        //Exemplo 1
        int valores[] = new int[]{1, 2, 2, 10, 4};
        int pesos[] = new int[]{1, 1, 2, 4, 12};
        int capacidade_mochila = 19;

        //Exemplo 2 - descomente esse e comente o acima para usar
        //int valores[] = new int[]{92, 57, 49, 68, 60, 43, 67, 84, 87, 72};
        //int pesos[] = new int[]{23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        //int capacidade_mochila = 165;

        //Exemplo 3 - descomente esse e comente o acima para usar
        //int valores[] = new int[]{50, 50, 64, 46, 50, 05};
        //int pesos[] = new int[]{56, 59, 80, 64, 75, 17};
        //int capacidade_mochila = 190;

        //solução por força bruta
        System.out.println("-----Problema da mochila-----");
        System.out.println("Solução por força bruta");
        contador=0;
        System.out.println("Valor máximo na mochila com capacidade de " + capacidade_mochila + ": " + knapSackBruteForce(capacidade_mochila, pesos, valores, valores.length));
        System.out.println("Quantidade de operações: " + contador);

        // solução por programação dinâmica
        System.out.println("\nSolução por programação dinâmica");
        contador=0;
        System.out.println("Valor máximo na mochila com capacidade de " + capacidade_mochila + ": " + knapSack(capacidade_mochila, pesos, valores));
        System.out.println("Quantidade de operações: " + contador);

    }


    public static int knapSack(int capacidade_mochila, int pesos[], int valores[]){
        int tam = valores.length;
        int i, w;
        int K[][] = new int[tam + 1][capacidade_mochila + 1];
        for (i = 0; i<= tam; i++) {
            contador++;
            for (w = 0; w<= capacidade_mochila; w++) {
                contador++;
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (pesos[i - 1] <= w)
                    K[i][w] = Math.max(valores[i - 1] + K[i - 1][w - pesos[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[tam][capacidade_mochila];
    }

    public static int knapSackBruteForce (int capacidade_mochila, int pesos[], int valores[], int n){
        if (n == 0 || capacidade_mochila == 0) {
            contador++;
            return 0;
        }

        if (pesos[n-1] > capacidade_mochila){
            contador++;
            return knapSackBruteForce(capacidade_mochila, pesos, valores, n-1);
        }

        else {
            contador++;
            return Math.max(valores[n-1] + knapSackBruteForce(capacidade_mochila-pesos[n-1], pesos, valores, n-1),
                    knapSackBruteForce(capacidade_mochila, pesos, valores, n-1));
        }
    }

}