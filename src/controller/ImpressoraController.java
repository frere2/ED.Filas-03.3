package controller;

import br.edu.fateczl.fila.Fila;

import java.util.Random;

public class ImpressoraController {
    private final Fila<String> filaDeImpressao = new Fila<>();

    public void insereDocumento(String documento) {
        filaDeImpressao.insert(documento);
        System.out.println("Documento enfileirado: " + documento);
    }

    public void imprime() throws Exception {
        if (filaDeImpressao.isEmpty()) {
            System.out.println("A fila de impressão está vazia.");
            return;
        }

        String documento = filaDeImpressao.remove();
        String[] partes = documento.split(";");
        String idPC = partes[0];
        String nomeArquivo = partes[1];

        Random random = new Random();
        int tempoImpressao = 1000 + random.nextInt(1000);

        System.out.println("[#PC: " + idPC + " – Arquivo: " + nomeArquivo + "]");

        Thread.sleep(tempoImpressao);
        System.out.println("Impressão concluída.");
    }
}
