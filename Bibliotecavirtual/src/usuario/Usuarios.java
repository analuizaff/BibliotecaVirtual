package usuario;

import biblioteca.Livros;

public abstract class Usuarios {
	
	String nome;
	String email;
	String senha;
	int emprestimo;
	
	public Usuarios(String nome, String email, String senha) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}
	
	public void setLogin(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void emprestimoAumenta() {
		emprestimo++;
	}
	
	public int getEmprestimo() {
		return emprestimo;
	}

	public void emprestimo(Livros livro, Aluno aluno) {
	}

	public void emprestimo(Livros livro, Professor professor) {
	}
}
