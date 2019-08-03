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
	
	//Aqui ta comentado porque tinha deixado como possivel passar o objeto como parametro
	//Mas acho que faz mais sentido deixar remover soh por ID
	/*
	public void removeProfessor(Usuarios professor) {
		registroProfessor.remove((Professor) professor);
	}*/
	
	public void removeProfessor(int indice) {
		registroProfessor.remove(indice);
	}
	
	//Aqui ta comentado porque tinha deixado como possivel passar o objeto como parametro
	//Mas acho que faz mais sentido deixar remover soh por ID
	/* 
	public void removeAluno(Usuarios aluno) {
		registroAluno.remove((Aluno) aluno);
	}*/
	
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
	
	public int getIDProfessor(Professor professor) {
		int ID = professor.getId();
		return ID;
	}
	
	//Funcao pra saber a quantidade de professores ja foram cadastrados
	//E poder usar na hora de limitar o for
	public int quantidadeProfessor() {
		return registroProfessor.size();
	}
	
	//Funcao pra saber a quantidade de alunos ja foram cadastrados
	//E poder usar na hora de limitar o for
	public int quantidadeAluno() {
		return registroAluno.size();
	}
}
