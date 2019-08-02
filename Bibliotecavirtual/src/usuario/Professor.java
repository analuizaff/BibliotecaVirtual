package usuario;

import biblioteca.Livros;

public class Professor extends Usuarios {

	private int id;
	private static int idProfessor = 0;
	
	
	public Professor() {
		super();
		this.id = idProfessor;
		idProfessor++;
	}

	public int getId() {
		return id;
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
