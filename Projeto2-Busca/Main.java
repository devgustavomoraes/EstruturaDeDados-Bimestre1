import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] volumes = {10000, 100000, 1000000};

        for (int n : volumes) {
            System.out.println("\n----- TESTANDO PARA N = " + n + " -----");
            int[] dados = gerarArrayAleatorio(n);
            int alvo = -1;

            ArvoreBST bst = new ArvoreBST();
            for (int x : dados) bst.inserir(x);

            int[] dadosOrdenados = dados.clone();
            Arrays.sort(dadosOrdenados);

            executarExperimento("Busca Sequencial", () -> AlgoritmosBusca.buscaSequencial(dados, alvo));
            executarExperimento("Busca Binária", () -> AlgoritmosBusca.buscaBinaria(dadosOrdenados, alvo));
            executarExperimento("Busca em Árvore", () -> bst.buscar(alvo));
        }
    }

    private static void executarExperimento(String nome, Runnable algoritmo) {
        int rodadas = 30;
        long[] tempos = new long[rodadas];

        for (int i = 0; i < rodadas; i++) {
            long inicio = System.nanoTime();
            algoritmo.run();
            tempos[i] = System.nanoTime() - inicio;
        }

        double media = calcularMedia(tempos);
        double desvio = calcularDesvioPadrao(tempos, media);

        System.out.printf("%s -> Média: %.2f ns | Desvio Padrão: %.2f ns%n", nome, media, desvio);
    }

    private static double calcularMedia(long[] tempos) {
        double soma = 0;
        for (long t : tempos) soma += t;
        return soma / tempos.length;
    }

    private static double calcularDesvioPadrao(long[] tempos, double media) {
        double somaVar = 0;
        for (long t : tempos) somaVar += Math.pow(t - media, 2);
        return Math.sqrt(somaVar / tempos.length);
    }

    private static int[] gerarArrayAleatorio(int n) {
        Random rand = new Random();
        return rand.ints(n, 0, 10000000).toArray();
    }
}