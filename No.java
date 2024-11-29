public class No {

    private Palavra palavra;  // Alterado de String para Palavra
    private No esquerda, direita;

    // Construtor atualizado para receber um objeto do tipo Palavra
    public No(Palavra palavra) {
        this.palavra = palavra;
        this.esquerda = null;
        this.direita = null;
    }

    // Métodos getters e setters
    public Palavra getPalavra() {
        return palavra;
    }

    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}