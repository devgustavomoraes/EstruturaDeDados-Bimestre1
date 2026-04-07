public class ArvoreAVL extends ArvoreBST {
    @Override
    public void inserir(int valor) { this.raiz = inserirAVL(this.raiz, valor); }

    private No inserirAVL(No atual, int valor) {
        atual = super.inserirRecursivo(atual, valor);
        return balancear(atual);
    }

    @Override
    public void remover(int valor) { this.raiz = removerAVL(this.raiz, valor); }

    private No removerAVL(No atual, int valor) {
        atual = super.removerRecursivo(atual, valor);
        return (atual == null) ? null : balancear(atual);
    }

    private No balancear(No atual) {
        int fator = fator(atual);
        if (fator > 1) {
            if (fator(atual.esquerda) < 0) {
                atual.esquerda = rotacionarEsquerda(atual.esquerda);
            }
            return rotacionarDireita(atual);
        }
        if (fator < -1) {
            if (fator(atual.direita) > 0) {
                atual.direita = rotacionarDireita(atual.direita);
            }
            return rotacionarEsquerda(atual);
        }
        return atual;
    }

    private int fator(No atual) {
        return (atual == null) ? 0 : calcularAltura(atual.esquerda) - calcularAltura(atual.direita);
    }

    protected No rotacionarDireita(No y) {
        No x = y.esquerda;
        y.esquerda = x.direita;

        if (x.direita != null) x.direita.pai = y;
        x.pai = y.pai;

        // Se y era a raiz da árvore toda, agora x é a raiz
        if (y.pai == null) this.raiz = x;
        else if (y == y.pai.direita) y.pai.direita = x;
        else y.pai.esquerda = x;

        x.direita = y;
        y.pai = x;
        return x;
    }

    protected No rotacionarEsquerda(No x) {
        No y = x.direita;
        x.direita = y.esquerda;

        if (y.esquerda != null) y.esquerda.pai = x;
        y.pai = x.pai;

        if (x.pai == null) this.raiz = y;
        else if (x == x.pai.esquerda) x.pai.esquerda = y;
        else x.pai.direita = y;

        y.esquerda = x;
        x.pai = y;
        return y;
    }
}