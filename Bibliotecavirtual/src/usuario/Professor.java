package usuario;

import biblioteca.Biblioteca;
import biblioteca.LivroExemplar;
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
	public String toString() {
		String s = "Nome: " + getNome() + "; Email: " + email + " ; Senha: " + senha;
		return s;
	}

	@Override
	public void emprestimo(Livros livro, Professor professor) {
		int i;
		livro.LivroExemplar(livro);
		if(DISPONIVEL<=0) { //primeiro verifica se aluno ainda pode  pegar livros
			
			System.out.println("Limite de emprestimos atingidos.");
		}
		else { // se aluno ainda pode pegar livro então verificará se existem livros disponiveis
		
		LivroExemplar exemplardisponivel = null;
		if(livro.LivroExemplar(livro) == null) {
			return;
		}
			else{//se existir livros disponiveis guarda o livro exemplar disponivel
				exemplardisponivel = livro.LivroExemplar(livro);
				Livros livroEmprestimo = livro;
			
				Biblioteca.emprestimoLivroP(livroEmprestimo, professor);
				System.out.println("Livro: '" + livroEmprestimo.getTitulo() + "' emprestado com sucesso.");
				System.out.println("Data:" + livroEmprestimo.getDataEmprestimo());
				System.out.println("---------------------------------");
				professor.emprestimoAumenta();
				livro.decresceContadorExemplares(livroEmprestimo);
				livroEmprestimo.setUsuarioEmprestadoID(professor.getId());	
				exemplardisponivel.setDisponibilidade(false);//seta a disponibilidade do exemplar para false
				DISPONIVEL--;
			}
		}
	}

}
