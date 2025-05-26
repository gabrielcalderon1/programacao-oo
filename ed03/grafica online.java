interface Imprimivel {
    void imprimir();
}

class DocumentoTexto implements Imprimivel {
    private String titulo;
    private String conteudo;

    public DocumentoTexto(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public void imprimir() {
        System.out.println(titulo.toUpperCase());
        System.out.println(conteudo);
        System.out.println();
    }
}

class ImagemDigital implements Imprimivel {
    private String nomeArquivo;
    private String resolucao;

    public ImagemDigital(String nomeArquivo, String resolucao) {
        this.nomeArquivo = nomeArquivo;
        this.resolucao = resolucao;
    }

    public void imprimir() {
        System.out.println("Arquivo: " + nomeArquivo);
        System.out.println("Resolução: " + resolucao);
        System.out.println();
    }
}

class GraficoEstatistico implements Imprimivel {
    private String titulo;
    private String tipoGrafico;

    public GraficoEstatistico(String titulo, String tipoGrafico) {
        this.titulo = titulo;
        this.tipoGrafico = tipoGrafico;
    }

    public void imprimir() {
        System.out.println("Gráfico do tipo: " + tipoGrafico.toUpperCase());
        System.out.println("Título: " + titulo.toUpperCase());
        System.out.println();
    }
}

class RelatorioPDF implements Imprimivel {
    private String autor;
    private int numeroPaginas;

    public RelatorioPDF(String autor, int numeroPaginas) {
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    public void imprimir() {
        System.out.println("Autor: " + autor);
        System.out.println("Total de páginas: " + numeroPaginas);
        System.out.println();
    }
}

public class ProgramaImpressao {
    public static void main(String[] args) {
        DocumentoTexto doc = new DocumentoTexto("Documento de Apresentação", "Este é o conteúdo do documento.");
        ImagemDigital img = new ImagemDigital("paisagem.jpg", "1920x1080");
        GraficoEstatistico grafico = new GraficoEstatistico("Distribuição de Vendas", "barra");
        RelatorioPDF relatorio = new RelatorioPDF("João Silva", 12);

        doc.imprimir();
        img.imprimir();
        grafico.imprimir();
        relatorio.imprimir();
    }
}
