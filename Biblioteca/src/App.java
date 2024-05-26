import java.util.Scanner;
public class App {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        biblioteca.iniciarAcervo();

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    inserirLivro();
                    break;
                case 2:
                    alterarLivro();
                    break;
                case 3:
                    removerLivro();
                    break;
                case 4:
                    listarLivros();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Inserir Livro");
        System.out.println("2. Alterar Livro");
        System.out.println("3. Remover Livro");
        System.out.println("4. Listar Livros");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void inserirLivro() {
        scanner.nextLine(); 
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de publicação do livro: ");
        int anoPublicacao = scanner.nextInt();

        Livro livro = new Livro(titulo, autor, anoPublicacao);
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro inserido com sucesso.");
    }

    private static void alterarLivro() {
        scanner.nextLine(); 
        System.out.print("Título do livro a ser alterado: ");
        String titulo = scanner.nextLine();
        for (Livro livro : biblioteca.getAcervo()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.print("Novo título do livro: ");
                String novoTitulo = scanner.nextLine();
                livro.setTitulo(novoTitulo);
                System.out.println("Livro alterado com sucesso.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private static void removerLivro() {
        scanner.nextLine(); 
        System.out.print("Título do livro a ser removido: ");
        String titulo = scanner.nextLine();
        for (Livro livro : biblioteca.getAcervo()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                biblioteca.removerLivro(livro);
                System.out.println("Livro removido com sucesso.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private static void listarLivros() {
        System.out.println("\n=== Lista de Livros ===");
        for (Livro livro : biblioteca.getAcervo()) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
            System.out.println("Disponível: " + (livro.isDisponivel() ? "Sim" : "Não"));
            System.out.println("-----------------------");
        }
    }
}
