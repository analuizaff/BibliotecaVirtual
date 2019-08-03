package biblioteca;

import usuario.Usuarios;
import java.time.LocalDateTime;

public class Livros {
	
	private LocalDateTime data;
	private String titulo, autor;
	private int id;
	private static int idL = 1;
	Usuarios usuario;
	
	public Livros(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.id = idL;
		idL++;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getId() {
		return id;
	}
	
	//Proximos dois provavelmente necessario na hora de configurar o emprestimo/devolucao
	public String getUsuarioComLivro() {
		return usuario.getNome();
	}
	
	public void setUsuarioComLivro(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		String s = "ID: " + this.getId() + "Título: " + titulo + " ; Autor: " + autor;
		return s;
	}
	
}
