public class ListaSimplesmenteEncadeada {
    private No inicio;

    public void clear() {
        inicio = null;
    }

    public No getPrimeiro() {
        return inicio;  // Retorna o primeiro nó da lista
    }

    public void insereFinal(int dado) {
        No novo = new No(dado);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        No atual = inicio;
        while (atual != null) {
            sb.append(atual.dado).append(" ");
            atual = atual.proximo;
        }
        return sb.toString().trim();
    }

    public class No {
        int dado;
        No proximo;

        public No(int dado) {
            this.dado = dado;
            this.proximo = null;
        }

        public int getValor() {
            return dado;  // Retorna o valor armazenado no nó
        }
    }

}
