package usuario;

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

}