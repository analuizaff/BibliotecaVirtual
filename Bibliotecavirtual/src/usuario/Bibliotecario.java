package usuario;
import biblioteca.*;

public class Bibliotecario extends Usuarios {

	String nome = "Bibliotecário";
	String email = "admin@biblioteca.com";
	String senha = "admin";
	
	Registro bibliotecario;
	
	public Bibliotecario(String email, String senha) {
		super(email, senha);
	}

	
	public void addAluno(Usuarios aluno) {
		bibliotecario.adicionaAluno(aluno);
	}
	
	public void addProfessor(Usuarios professor) {
		bibliotecario.adicionaProfessor(professor);
	}
	
	//Comentado porque acho que nao vai precisar
	/*
	public void removeAluno(Usuarios aluno) {
		bibliotecario.adicionaAluno(aluno);
	}*/
	
	/*
	public void removeProfessor(Usuarios professor) {
		bibliotecario.adicionaProfessor(professor);
	}*/
	
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
