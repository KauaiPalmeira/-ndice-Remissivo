import java.io.PrintWriter;

public class TabelaHashComABB {
    private static final int TAMANHO = 26; // (A-Z)
    private ArvoreBinariaBusca[] tabela;

    public TabelaHashComABB() {
        tabela = new ArvoreBinariaBusca[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new ArvoreBinariaBusca();
        }
    }

    public void adicionarPalavra(String texto, int numeroLinha) {
        if (texto == null || texto.isEmpty()) return;

        char primeiraLetra = Character.toLowerCase(texto.charAt(0));
        if (primeiraLetra >= 'a' && primeiraLetra <= 'z') {
            int indice = primeiraLetra - 'a';
            tabela[indice].adicionar(texto, numeroLinha);
        }
    }
    // verifica se a palavra ja esta na hash
    public boolean contemPalavra(String texto) {
        char primeiraLetra = Character.toLowerCase(texto.charAt(0));
        if (primeiraLetra >= 'a' && primeiraLetra <= 'z') {
            int indice = primeiraLetra - 'a';
            return tabela[indice].contem(texto);
        }
        return false;
    }

    public void imprimirTabelaOrdenada(PrintWriter writer) {
        for (ArvoreBinariaBusca abb : tabela) {
            if (abb != null && !abb.isVazia()) {
                abb.imprimirEmOrdem(writer);
            }
        }
    }
}



/*
    public void clear() {
        for (int i = 0; i < tabela.length; i++) {
            tabela[i].clear();
        }
    }


    private int calcularIndice(String palavra) {
        char primeiraLetra = Character.toUpperCase(palavra.charAt(0));
        return primeiraLetra - 'A';
    }

     */


