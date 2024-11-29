import java.io.PrintWriter;

public class Palavra {
    private String texto;  // Palavra armazenada
    private ListaSimplesmenteEncadeada ocorrencias;

    // Construtor
    public Palavra(String texto) {
        this.texto = texto;
        this.ocorrencias = new ListaSimplesmenteEncadeada();
    }


    public void adicionarOcorrencia(int linha) {
        ocorrencias.insereFinal(linha);
    }

    // Getter para a palavra
    public String getTexto() {
        return texto;
    }

    // Getter para as ocorrências
    public ListaSimplesmenteEncadeada getOcorrencias() {
        return ocorrencias;
    }


    public void exibir(PrintWriter escritor) {
        escritor.print(texto + " - ");
        escritor.println(ocorrencias.toString());  // Escreve as ocorrências da palavra
    }
}
