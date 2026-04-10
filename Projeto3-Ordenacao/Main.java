import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] volumes = {1000, 10000};

        for (int n : volumes) {
            System.out.println("\n--------------------------------------");
            System.out.println("   BENCHMARK DE ORDENAÇÃO - N = " + n);
            System.out.println("----------------------------------------");

            int[] casoMedio = gerarAleatorio(n);
            int[] melhorCaso = casoMedio.clone();
            Arrays.sort(melhorCaso);
            int[] piorCaso = gerarInvertido(n);

            System.out.println("\n--- ALGORITMO: INSERTION SORT ---");
            executarExperimento("Melhor Caso", melhorCaso, "insertion");
            executarExperimento("Caso Médio", casoMedio, "insertion");
            executarExperimento("Pior Caso", piorCaso, "insertion");

            System.out.println("\n--- ALGORITMO: QUICK SORT ---");
            executarExperimento("Melhor Caso", melhorCaso, "quick");
            executarExperimento("Caso Médio", casoMedio, "quick");
            executarExperimento("Pior Caso", piorCaso, "quick");
        }
    }

    private static void executarExperimento(String cenario, int[] dadosOriginais, String algoritmo) {
        int repeticoes = 30;
        long[] tempos = new long[repeticoes];

        for (int i = 0; i < repeticoes; i++) {
            int[] copia = dadosOriginais.clone();
            long inicio = System.nanoTime();

            if (algoritmo.equals("insertion")) {
                AlgoritmosOrdenacao.insertionSort(copia);
            } else {
                AlgoritmosOrdenacao.quickSort(copia, 0, copia.length - 1);
            }

            tempos[i] = System.nanoTime() - inicio;
        }

        double media = calcularMedia(tempos);
        double desvio = calcularDesvioPadrao(tempos, media);

        System.out.printf("%-15s | Média: %12.2f ns | DP: %12.2f ns%n", cenario, media, desvio);
    }

    private static double calcularMedia(long[] dados) {
        double soma = 0;
        for (long d : dados) soma += d;
        return soma / dados.length;
    }

    private static double calcularDesvioPadrao(long[] dados, double media) {
        double somaVar = 0;
        for (long d : dados) {
            somaVar += Math.pow(d - media, 2);
        }
        return Math.sqrt(somaVar / dados.length);
    }

    private static int[] gerarAleatorio(int n) {
        Random rand = new Random();
        return rand.ints(n, 0, 100000).toArray();
    }

    private static int[] gerarInvertido(int n) {
        int[] arr = gerarAleatorio(n);
        java.util.Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}