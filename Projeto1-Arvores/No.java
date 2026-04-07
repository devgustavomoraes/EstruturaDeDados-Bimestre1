public class No {
    int valor;
    No esquerda, direita, pai;
    int altura;
    boolean cor;

    public No(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.cor = true;
    }
}
