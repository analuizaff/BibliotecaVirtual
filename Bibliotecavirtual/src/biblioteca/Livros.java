package biblioteca;

public class Livros {
	
	private String titulo, autor, edicao;
	private int id;
	private static int idL = 1;
	
	public Livros(String titulo, String edicao, String autor) {
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
	
	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	@Override
	public String toString() {
		String s = "ID: " + idL + "T�tulo: " + titulo + " ; Autor: " + autor;
		return s;
	}
	
}
