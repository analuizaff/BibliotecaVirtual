package usuario;

public abstract class Usuarios {
	
	String nome;
	String email;
	String senha;
	String tipo; //tipo do usuário(bibliotecario, professor, aluno)
	
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
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public abstract void devolucao();
	
	public abstract void emprestimo();
	
}
