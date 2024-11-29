import java.io.PrintWriter;

public class ArvoreBinariaBusca {

    private No raiz;

    public void adicionar(String texto, int numeroLinha) {
        Palavra novaPalavra = new Palavra(texto);
        novaPalavra.adicionarOcorrencia(numeroLinha);
        raiz = adicionarRecursivo(raiz, novaPalavra);
    }

    public boolean contem(String texto) {
        return contemRecursivo(raiz, texto);
    }

    public void clear() {
        raiz = null;

    }

    private boolean contemRecursivo(No no, String texto) {
        if (no == null) {
            return false;
        }

        int comparacao = texto.compareTo(no.getPalavra().getTexto());

        if (comparacao == 0) {
            return true;
        } else if (comparacao < 0) {
            return contemRecursivo(no.getEsquerda(), texto);
        } else {
            return contemRecursivo(no.getDireita(), texto);
        }
    }

    private No adicionarRecursivo(No no, Palavra palavra) {
        if (no == null) {
            return new No(palavra);
        }

        int comparacao = palavra.getTexto().compareTo(no.getPalavra().getTexto());

        if (comparacao < 0) {
            no.setEsquerda(adicionarRecursivo(no.getEsquerda(), palavra));
        } else if (comparacao > 0) {
            no.setDireita(adicionarRecursivo(no.getDireita(), palavra));
        } else {
            no.getPalavra().adicionarOcorrencia(palavra.getOcorrencias().getPrimeiro().getValor());
        }

        return no;
    }

    public void imprimirEmOrdem(PrintWriter escritor) {
        imprimirEmOrdemRecursivo(raiz, escritor);
    }

    public boolean isVazia() {
        return raiz == null;
    }

    private void imprimirEmOrdemRecursivo(No no, PrintWriter escritor) {
        if (no != null) {
            imprimirEmOrdemRecursivo(no.getEsquerda(), escritor);
            no.getPalavra().exibir(escritor);
            imprimirEmOrdemRecursivo(no.getDireita(), escritor);
        }
    }
}
