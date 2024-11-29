import java.io.*;

public class IndiceRemissivo {
    private TabelaHashComABB tabelaHash;
    private TabelaHashComABB palavrasChave;

    public IndiceRemissivo() {
        tabelaHash = new TabelaHashComABB();
        palavrasChave = new TabelaHashComABB();
    }

    public void carregarPalavrasChave(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] palavras = linha.split(",");
                for (String palavra : palavras) {
                    palavra = palavra.trim().toLowerCase();
                    palavrasChave.adicionarPalavra(palavra, -1);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de palavras-chave: " + e.getMessage());
        }
    }

    public void processarTexto(String texto, int numeroLinha) {
        String[] palavras = texto.split("\\s+");
        for (String palavra : palavras) {
            palavra = palavra.toLowerCase().replaceAll("[^a-zA-Z-]", "").trim();
            if (!palavra.isEmpty() && palavrasChave.contemPalavra(palavra)) {
                tabelaHash.adicionarPalavra(palavra, numeroLinha);
            }
        }
    }

    public void lerArquivoTexto(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int numeroLinha = 1;
            while ((linha = reader.readLine()) != null) {
                processarTexto(linha, numeroLinha);
                numeroLinha++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gerarIndiceRemissivo(String caminhoSaida) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoSaida))) {
            tabelaHash.imprimirTabelaOrdenada(writer);
        } catch (IOException e) {
            System.err.println("Erro ao gerar índice remissivo: " + e.getMessage());
        }
    }


    public static void main(String[] args) {

        String caminhoEntrada = "texto.txt";
        String caminhoPalavrasChave = "palavras-chave.txt";
        String caminhoSaida = "indice_remissivo.txt";


        IndiceRemissivo indice = new IndiceRemissivo();
        indice.carregarPalavrasChave(caminhoPalavrasChave);
        indice.lerArquivoTexto(caminhoEntrada);

        indice.gerarIndiceRemissivo(caminhoSaida);

        System.out.println("Índice remissivo gerado com sucesso!");
    }
}
