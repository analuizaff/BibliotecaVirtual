package biblioteca;

public class Livros {
	
	private String titulo, autor;
	private int id;
	private static int idL = 1;
	
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
	
	@Override
	public String toString() {
		String s = "ID: " + idL + "Título: " + titulo + " ; Autor: " + autor;
		return s;
	}
	
}
