package usuario;

import biblioteca.Livros;

public class Aluno extends Usuarios {

	private int id;
	private static int idAluno = 0;
	
	
	public Aluno() {
		super();
		this.id = idAluno;
		idAluno++;
	}
	
	public int getId() {
		return id;
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
