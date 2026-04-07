import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] tamanhosArvores = {1000, 5000, 10000};
        Random random = new Random();

        System.out.println("---------- ÁRVORES DE BUSCA -----------");
        for (int n : tamanhosArvores) {
            long somaBST = 0, somaAVL = 0, somaRN = 0;

            for (int i = 0; i < 30; i++) {
                int[] dados = gerarVetorAleatorio(n, random);

                ArvoreBST bst = new ArvoreBST();
                somaBST += medirInsercao(bst, dados);

                ArvoreAVL avl = new ArvoreAVL();
                somaAVL += medirInsercao(avl, dados);

                ArvoreRN rn = new ArvoreRN();
                somaRN += medirInsercao(rn, dados);
            }

            System.out.println("\nResultados para N = " + n + ":");
            System.out.println("Média BST: " + (somaBST / 30) + " ns");
            System.out.println("Média AVL: " + (somaAVL / 30) + " ns");
            System.out.println("Média RN:  " + (somaRN / 30) + " ns");
        }

        System.out.println("\n\n----------  CAIXEIRO-VIAJANTE ----------");
        int[] tamanhosPCV = {10, 30, 50}; // Tamanhos menores pois PCV é O(n²)
        CaixeiroViajante pcv = new CaixeiroViajante();

        for (int n : tamanhosPCV) {
            long somaPCV = 0;

            for (int i = 0; i < 30; i++) {
                int[][] matriz = gerarMatrizDistancias(n, random);

                long inicio = System.nanoTime();
                pcv.resolver(matriz);
                long fim = System.nanoTime();

                somaPCV += (fim - inicio);
            }

            System.out.println("Cidades: " + n + " | Média PCV: " + (somaPCV / 30) + " ns");
        }
    }

    private static long medirInsercao(ArvoreBST arvore, int[] dados) {
        long inicio = System.nanoTime();
        for (int valor : dados) {
            arvore.inserir(valor);
        }
        return System.nanoTime() - inicio;
    }

    private static int[] gerarVetorAleatorio(int n, Random r) {
        int[] v = new int[n];
        for (int i = 0; i < n; i++) v[i] = r.nextInt(n * 10);
        return v;
    }

    private static int[][] gerarMatrizDistancias(int n, Random r) {
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) matriz[i][j] = 0;
                else matriz[i][j] = r.nextInt(100) + 1;
            }
        }
        return matriz;
    }
}