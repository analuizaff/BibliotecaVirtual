package usuario;

import biblioteca.Biblioteca;
import biblioteca.Livros;
import biblioteca.LivroExemplar;

public class Aluno extends Usuarios {

	private int id;
	private static int idAluno = 0;
	private int DISPONIVEL = 5;
	
	
	public Aluno(String nome, String email, String senha) {
		super(nome, email, senha);
		this.id = idAluno;
		idAluno++;
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
	public void emprestimo(Livros livro, Aluno aluno) {
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
			
				Biblioteca.emprestimoLivroA(livroEmprestimo, aluno);
				System.out.println("Livro: '" + livroEmprestimo.getTitulo() + "' emprestado com sucesso.");
				System.out.println("Data:" + livroEmprestimo.getDataEmprestimo());
				System.out.println("---------------------------------");
				aluno.emprestimoAumenta();
				livro.decresceContadorExemplares(livroEmprestimo);
				livroEmprestimo.setUsuarioEmprestadoID(aluno.getId());	
				exemplardisponivel.setDisponibilidade(false);//seta a disponibilidade do exemplar para false
				DISPONIVEL--;
			}
		}
	}

	private LivroExemplar livroExemplarDisponivel(Livros livro) {
		return null;
	}

}