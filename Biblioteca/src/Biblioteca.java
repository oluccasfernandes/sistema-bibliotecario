import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> acervo;
    private ArrayList<Cliente> clientes;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void iniciarAcervo() {
        adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        adicionarLivro(new Livro("1984", "George Orwell", 1949));
        adicionarLivro(new Livro("Dom Quixote", "Miguel de Cervantes", 1605));
    }

    public void adicionarLivro(Livro livro) {
        acervo.add(livro);
    }

    public void removerLivro(Livro livro) {
        acervo.remove(livro);
    }

    public ArrayList<Livro> getAcervo() {
        return acervo;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
