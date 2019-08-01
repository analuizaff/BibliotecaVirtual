package usuario;

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
	public void devolucao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emprestimo() {
		// TODO Auto-generated method stub
		
	}

}
