package usuario;

import biblioteca.Biblioteca;
import biblioteca.Livros;

public class Aluno extends Usuarios {

	private int id;
	private static int idAluno = 0;
	private static int DISPONIVEL = 5;
	
	
	public Aluno(String nome, String email, String senha) {
		super(nome, email, senha);
		this.id = idAluno;
		idAluno++;
	}

	public int getId() {
		return id;
	}

	//Aqui ainda nao sei como vai ficar, mas a ideia era toda vez que chamar a funcao devolucao
	//Acrescenta 1 de disponivel
	@Override
	public void devolucao() {
		if(DISPONIVEL==5) {
			System.out.println("O aluno nï¿½o tem livros para devolver.");
		}
		else {
			DISPONIVEL++;
		}
		
	}

	//Aqui ainda nao sei como vai ficar, mas a ideia era toda vez que chamar a funcao emprestimo
	//Decresce 1 de disponivel
	@Override
	public void emprestimo() {
		if(DISPONIVEL<=0) {
			System.out.println("Limite de emprï¿½stimos atingidos.");
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

	@Override
	public void emprestimo(Livros livro, Aluno aluno) {
		Livros livroEmprestimo = livro;
		if(livroEmprestimo.getContadorId() != 0 && livro.getContadorExemplares(livroEmprestimo)> 0) {
			System.out.println("Livro disponível!");
			Biblioteca.emprestimoLivroA(livroEmprestimo, aluno);
			System.out.println("Livro: '" + livroEmprestimo.getTitulo() + "' emprestado com sucesso.");
			System.out.println("Data:" + livroEmprestimo.getDataEmprestimo());
			aluno.emprestimoAumenta();
			livro.decresceContadorExemplares(livroEmprestimo);
			livroEmprestimo.setUsuarioEmprestadoID(aluno.getId());	
		}
		else {
			System.out.println("Nao ha exemplares disponiveis!");
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

	@Override
	public void emprestimo(Livros livro, Usuarios aluno) {
		// TODO Auto-generated method stub
		
	}

}
