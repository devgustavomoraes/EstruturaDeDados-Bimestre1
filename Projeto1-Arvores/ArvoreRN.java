public class ArvoreRN extends ArvoreAVL {
    private No nil;

    public ArvoreRN() {
        nil = new No(0);
        nil.cor = false; // Preto
        this.raiz = nil;
    }

    @Override
    public void inserir(int valor) {
        No novo = new No(valor);
        novo.esquerda = nil;
        novo.direita = nil;
        novo.pai = nil;

        No y = nil;
        No x = this.raiz;

        while (x != nil) {
            y = x;
            if (novo.valor < x.valor) x = x.esquerda;
            else x = x.direita;
        }

        novo.pai = y;
        if (y == nil) this.raiz = novo;
        else if (novo.valor < y.valor) y.esquerda = novo;
        else y.direita = novo;

        consertarInsercao(novo);
    }

    private void consertarInsercao(No z) {
        while (z.pai != null && z.pai != nil && z.pai.cor) {
            if (z.pai == z.pai.pai.esquerda) {
                No tio = z.pai.pai.direita;
                // CASO 1: Tio existe e é vermelho
                if (tio != nil && tio.cor) {
                    z.pai.cor = false;
                    tio.cor = false;
                    z.pai.pai.cor = true;
                    z = z.pai.pai;
                } else {
                    // CASO 2: Joelho
                    if (z == z.pai.direita) {
                        z = z.pai;
                        rotacionarEsquerda(z);
                    }
                    // CASO 3: Linha reta
                    z.pai.cor = false;
                    z.pai.pai.cor = true;
                    rotacionarDireita(z.pai.pai);
                }
            } else {
                No tio = z.pai.pai.esquerda;
                if (tio != nil && tio.cor) {
                    z.pai.cor = false;
                    tio.cor = false;
                    z.pai.pai.cor = true;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.esquerda) {
                        z = z.pai;
                        rotacionarDireita(z);
                    }
                    z.pai.cor = false;
                    z.pai.pai.cor = true;
                    rotacionarEsquerda(z.pai.pai);
                }
            }
        }
        this.raiz.cor = false;
    }
}