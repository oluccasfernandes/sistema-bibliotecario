import java.util.Scanner;

public class App {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        biblioteca.iniciarAcervo();

        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    gerenciarLivros();
                    break;
                case 2:
                    gerenciarClientes();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Gerenciar Livros");
        System.out.println("2. Gerenciar Clientes");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void gerenciarLivros() {
        int opcaoLivro;
        do {
            exibirMenuLivros();
            opcaoLivro = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoLivro) {
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
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoLivro != 5);
    }

    private static void exibirMenuLivros() {
        System.out.println("\n=== Menu de Livros ===");
        System.out.println("1. Inserir Livro");
        System.out.println("2. Alterar Livro");
        System.out.println("3. Remover Livro");
        System.out.println("4. Listar Livros");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void inserirLivro() {
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de publicação do livro: ");
        int anoPublicacao = scanner.nextInt();
        scanner.nextLine(); 

        Livro livro = new Livro(titulo, autor, anoPublicacao);
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro inserido com sucesso.");
    }

    private static void alterarLivro() {
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

    private static void gerenciarClientes() {
        int opcaoCliente;
        do {
            exibirMenuClientes();
            opcaoCliente = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcaoCliente) {
                case 1:
                    inserirCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    removerCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoCliente != 5);
    }

    private static void exibirMenuClientes() {
        System.out.println("\n=== Menu de Clientes ===");
        System.out.println("1. Inserir Cliente");
        System.out.println("2. Alterar Cliente");
        System.out.println("3. Remover Cliente");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void inserirCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(nome, idade, email);
        biblioteca.adicionarCliente(cliente);
        System.out.println("Cliente inserido com sucesso.");
    }

    private static void alterarCliente() {
        System.out.print("Nome do cliente a ser alterado: ");
        String nome = scanner.nextLine();
        for (Cliente cliente : biblioteca.getClientes()) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Novo nome do cliente: ");
                String novoNome = scanner.nextLine();
                cliente.setNome(novoNome);
                System.out.print("Nova idade do cliente: ");
                int novaIdade = scanner.nextInt();
                scanner.nextLine(); 
                cliente.setIdade(novaIdade);
                System.out.print("Novo email do cliente: ");
                String novoEmail = scanner.nextLine();
                cliente.setEmail(novoEmail);
                System.out.println("Cliente alterado com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    private static void removerCliente() {
        System.out.print("Nome do cliente a ser removido: ");
        String nome = scanner.nextLine();
        for (Cliente cliente : biblioteca.getClientes()) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                biblioteca.removerCliente(cliente);
                System.out.println("Cliente removido com sucesso.");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    private static void listarClientes() {
        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente cliente : biblioteca.getClientes()) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("-----------------------");
        }
    }
}
