import java.util.List;
import java.util.Scanner;

/**
 * Classe ContatoView.
 */
public class ContatoView {
    private ContatoController controller = new ContatoController();
    private Scanner scanner = new Scanner(System.in);

/**
 * Método public void exibirMenu().
 */
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n1 - Adicionar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("3 - Remover contato");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> mostrarContatos(controller.listar());
                case 3 -> removerContato();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void adicionarContato() {
        try {
            System.out.print("Tipo (1-Física, 2-Jurídica): ");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            ContatoBase contato;
            if (tipo == 1) {
                PessoaFisica pf = new PessoaFisica();
                preencherDados(pf);
                System.out.print("CPF (11 dígitos): ");
                pf.setCpf(scanner.nextLine());
                contato = pf;
            } else {
                PessoaJuridica pj = new PessoaJuridica();
                preencherDados(pj);
                System.out.print("CNPJ (14 dígitos): ");
                pj.setCnpj(scanner.nextLine());
                contato = pj;
            }

            controller.adicionar(contato);
            System.out.println("Contato adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void preencherDados(ContatoBase contato) {
        System.out.print("Nome: ");
        contato.setNome(scanner.nextLine());
        System.out.print("Telefone: ");
        contato.setTelefone(scanner.nextLine());
        System.out.print("Email: ");
        contato.setEmail(scanner.nextLine());
    }

    private void removerContato() {
        System.out.print("Informe CPF ou CNPJ do contato a remover: ");
        String documento = scanner.nextLine();
        controller.remover(documento);
        System.out.println("Se existia, contato foi removido.");
    }

/**
 * Método public void mostrarContatos(List<Contato> contatos).
 */
    public void mostrarContatos(List<Contato> contatos) {
        System.out.println("\nContatos cadastrados:");
        for (Contato c : contatos) {
            System.out.println(c.toString());
        }
    }
}