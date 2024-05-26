import java.util.ArrayList;
public class Biblioteca {
    private ArrayList<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
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

    public void iniciarAcervo(){
        Livro livro = new Livro("Harry Potter", "JK Rowling", 1968);
        this.adicionarLivro(livro);

        livro = new Livro("Percy Jackson", "N sei", 4567);
        this.adicionarLivro(livro);
    }
}
