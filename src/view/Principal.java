package view;

import controller.ImpressoraController;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        ImpressoraController impressora = new ImpressoraController();
        String menu = "Escolha uma opção:\n1. Inserir documento\n2. Imprimir documento\n3. Sair";
        boolean executando = true;

        while (executando) {
            String opcao = JOptionPane.showInputDialog(menu);

            if (opcao == null) {
                break;
            }

            switch (opcao) {
                case "1":
                    String documento = JOptionPane.showInputDialog("Digite o documento no formato ID_PC;Nome_Arquivo");
                    if (documento != null && documento.matches("\\d+;[\\w\\d]+")) {
                        impressora.insereDocumento(documento);
                    } else {
                        JOptionPane.showMessageDialog(null, "Formato inválido. Use ID_PC;Nome_Arquivo");
                    }
                    break;

                case "2":
                    try {
                        impressora.imprime();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case "3":
                    executando = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }

        JOptionPane.showMessageDialog(null, "Programa encerrado.");
    }
}
