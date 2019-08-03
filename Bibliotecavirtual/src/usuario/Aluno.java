package usuario;

import biblioteca.Livros;

public class Aluno extends Usuarios {

	private int id;
	private static int idAluno = 0;
	private static int DISPONIVEL = 5;
	
	
	public Aluno(String nome, String senha) {
		super(senha, senha);
		this.id = idAluno;
		idAluno++;
	}

	public int getId() {
		return id;
	}

	//Aqui ainda nao sei como vai ficar, mas a ideia era toda vez que chamar a funcao emprestimo
	//Acrescenta 1 de disponivel
	@Override
	public void devolucao() {
		if(DISPONIVEL==5) {
			System.out.println("O aluno não tem livros para devolver.");
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

}
