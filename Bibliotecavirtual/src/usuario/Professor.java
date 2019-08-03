package usuario;

import biblioteca.Livros;

public class Professor extends Usuarios {

	private int id;
	private static int idProfessor = 0;
	private static int DISPONIVEL = 10;
	
	
	public Professor(String email, String senha) {
		super(email, senha);
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

	public Object getId(int indice) {
		
		return null;
	}

}
