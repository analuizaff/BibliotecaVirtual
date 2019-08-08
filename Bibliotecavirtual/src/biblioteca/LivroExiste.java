package biblioteca;

public class LivroExiste extends Exception {
	
	public LivroExiste() {
		super("Livro ja existe no acervo");
	}
}	
