public class CaixeiroViajante {

    public int[] resolver(int[][] distancias) {
        int n = distancias.length;
        boolean[] visitado = new boolean[n];
        int[] rota = new int[n];

        int cidadeAtual = 0;
        visitado[cidadeAtual] = true;
        rota[0] = cidadeAtual;

        for (int i = 1; i < n; i++) {
            int proximaCidade = -1;
            int menorDistancia = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visitado[j] && distancias[cidadeAtual][j] < menorDistancia) {
                    menorDistancia = distancias[cidadeAtual][j];
                    proximaCidade = j;
                }
            }

            rota[i] = proximaCidade;
            visitado[proximaCidade] = true;
            cidadeAtual = proximaCidade;
        }

        return rota;
    }
}