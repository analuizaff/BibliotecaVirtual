package usuario;

import biblioteca.Biblioteca;
import biblioteca.Livros;

public class Professor extends Usuarios {

	private int id;
	private static int idProfessor = 0;
	private static int DISPONIVEL = 10;
	
	
	public Professor(String nome, String email, String senha) {
		super(nome, email, senha);
		this.id = idProfessor;
		idProfessor++;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public void devolucao() {
		if(DISPONIVEL==10) {
			System.out.println("O professor não tem livros para devolver.");
		}
		else {
			DISPONIVEL++;
		}
		
	}

	@Override
	public void emprestimo() {
		if(DISPONIVEL<=0) {
			System.out.println("Limite de empréstimos atingidos.");
		}
		else {
			DISPONIVEL--;
		}
		
	}
	
	@Override
	public String toString() {
		String s = "Nome: " + getNome() + "; Email: " + email + " ; Senha: " + senha;
		return s;
	}

	public void emprestimo(Livros livro, Professor professor) {
		Livros livroEmprestimo = livro;
		if(livroEmprestimo.getContadorId() != 0) {
			System.out.println("Livro disponível!");
			Biblioteca.emprestimoLivroP(livroEmprestimo, professor);
			System.out.println("Livro: '" + livroEmprestimo.getTitulo() + "' emprestado com sucesso.");
			System.out.println("Data:" + livroEmprestimo.getDataEmprestimo());
			professor.emprestimoAumenta();
		}
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

	public Object getId(int indice) {
		
		return null;
	}

	@Override
	public void emprestimo(Livros livro, Aluno usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emprestimo(Livros livro, Usuarios aluno) {
		// TODO Auto-generated method stub
		
	}

}
