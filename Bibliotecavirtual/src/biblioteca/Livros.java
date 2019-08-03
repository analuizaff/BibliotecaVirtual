	package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Livros {
	
	String code;
	private String titulo;
	private String autor;
	private String edicao;
	private List <LivroExemplar> exemplar = new ArrayList<LivroExemplar>();
	private int id =0;
	private int qtdExemplares = 0;
	
	private static int contadorId =0;
	private static ArrayList <Integer> idlivros = new ArrayList <Integer> ();//só guarda os ids dos exeplres, feito apenas para verificações futuras
	
	public Livros(String titulo, String autor, String edicao, String code) {
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.code = code;
		this.id++;
	}
	public void adicionaExemplar(){	//adiciona Exemplar ao meu livro
		contadorId++;
		idlivros.add(contadorId);
		qtdExemplares++;
		exemplar.add (new LivroExemplar(titulo, autor, edicao, contadorId));
		
		
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

	
	public List<LivroExemplar> getExemplar() {
		return exemplar;
	}
	public void setExemplar(List<LivroExemplar> exemplar) {
		this.exemplar = exemplar;
	}
	public static int getContadorId() {
		return contadorId;
	}
	public static void setContadorId(int contadorId) {
		Livros.contadorId = contadorId;
	}
	
	@Override
	public String toString() {
		return "Livros [" +getTitulo()+  ", autor:" +getAutor()+ ", edicaoo:" +getEdicao()+ ", id: " +getId()+ ",exemplares: " +qtdExemplares+"]" ;
	}
}
