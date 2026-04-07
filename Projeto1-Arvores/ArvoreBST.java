public class ArvoreBST {
    protected No raiz;

    public void inserir(int valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    protected No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }
        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        }
        else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }
        return atual;
    }

    public void remover(int valor) {
        this.raiz = removerRecursivo(this.raiz, valor);
    }

    protected No removerRecursivo(No atual, int valor) {
        if (atual == null) {
            return null;
        }
        if (valor < atual.valor) {
            atual.esquerda = removerRecursivo(atual.esquerda, valor);
        }
        else if (valor > atual.valor) {
            atual.direita = removerRecursivo(atual.direita, valor);
        }
        else {
            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }
            atual.valor = encontrarMinimo(atual.direita);
            atual.direita = removerRecursivo(atual.direita, atual.valor);
        }
        return atual;
    }

    private int encontrarMinimo(No atual) {
        while (atual.esquerda != null) atual = atual.esquerda;
        return atual.valor;
    }

    public boolean buscar(int valor) {
        No atual = this.raiz;
        while (atual != null && atual.valor != 0) {
            if (valor == atual.valor) {
                return true;
            }
            atual = (valor < atual.valor) ? atual.esquerda : atual.direita;
        }
        return false;
    }

    public int obterAltura() {
        return calcularAltura(this.raiz);
    }

    protected int calcularAltura(No atual) {
        if (atual == null || (atual.valor == 0 && !atual.cor)) return 0;
        return Math.max(calcularAltura(atual.esquerda), calcularAltura(atual.direita)) + 1;
    }
}