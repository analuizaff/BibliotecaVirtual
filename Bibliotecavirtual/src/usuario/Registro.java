package usuario;
import java.util.ArrayList;

public class Registro{
	
	private ArrayList<Aluno> registroAluno;
	private ArrayList<Professor> registroProfessor;
	
	public Registro() {
		registroAluno = new ArrayList<Aluno>();
		registroProfessor = new ArrayList<Professor>();
	}
	
	public void adicionaProfessor(Usuarios professor) {
		registroProfessor.add((Professor) professor);
	}
	
	public void adicionaAluno(Usuarios aluno) {
		registroAluno.add((Aluno) aluno);
	}
	
	public void removeProfessor(int indice) {
		registroProfessor.remove(indice);
	}
	
	public void removeAluno(int indice) {
		registroAluno.remove(indice);
	}
	
	public Usuarios getProfessor(int indice) {
		return registroProfessor.get(indice);
	}
	
	public Usuarios getAluno(int indice) {
		return registroAluno.get(indice);
	}
	
	public int getIDAluno(Aluno aluno) {
		int ID = aluno.getId();
		return ID;
	}
	
	public String getEmailAluno(Aluno aluno) {
		String email = aluno.getEmail();
		return email;
	}
	
	public String getSenhaAluno(Aluno aluno) {
		String senha = aluno.getSenha();
		return senha;
	}
	
	public String getEmailProfessor(Professor professor) {
		String email = professor.getEmail();
		return email;
	}
	
	public String getSenhaProfessor(Professor professor) {
		String senha = professor.getSenha();
		return senha;
	}
	
	public int getIDProfessor(Professor professor) {
		int ID = professor.getId();
		return ID;
	}
	
	public int quantidadeProfessor() {
		return registroProfessor.size();
	}
	
	public int quantidadeAluno() {
		return registroAluno.size();
	}
}
