package usuario;

import biblioteca.Biblioteca;
import biblioteca.Livros;

public class Bibliotecario extends Usuarios{

	String nome = "Bibliotec�rio";
	String email = "admin@biblioteca.com";
	String senha = "admin";
	
	public Bibliotecario() {
		super();
		
	}

	@Override
	public void devolucao() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emprestimo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void emprestimo(Livros livro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolucao(Livros livro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Livros busca(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livros verifica(Livros livro) {
		// TODO Auto-generated method stub
		return null;
	}

}
