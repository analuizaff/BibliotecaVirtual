package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Livros {
	
	private String titulo;
	private String autor;
	private String edicao;
	private List <LivroExemplar> exemplar = new ArrayList<LivroExemplar>();
	private String code; //cada livro tem um codigo
	private int qtdExemplares = 0;
	private static int idexemplar =-1; ////todos os exemplares terão um um id de 0 a n. esse id será incrementado toda vez que for criado um novo exemplar, assim o id tbm é a posicao que o livro esta guardado no array
	
	private static ArrayList <Integer> idlivros = new ArrayList <Integer> ();//só guarda os ids dos exeplres, feito apenas para verificações futuras
	
	public Livros(String titulo, String autor, String edicao, String code) {
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.code = code;
	}
	public void adicionaExemplar(){	//adiciona Exemplares ao  livro
		idexemplar ++;
		idlivros.add(idexemplar);
		qtdExemplares++;
		exemplar.add (new LivroExemplar(titulo, autor, edicao, idexemplar));	
	}
	
	public void removeExemplar(int idexemplar) {//remove exemplares do livro pelo id do exemplar
		qtdExemplares--;
		idlivros.remove(idexemplar);
		qtdExemplares--;
		exemplar.remove(idexemplar);
		System.out.println("removeu exemplar" );
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

	
	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	
	public int getQtdExemplares() {
		return qtdExemplares;
	}
	public void setQtdExemplares(int qtdExemplares) {
		this.qtdExemplares = qtdExemplares;
	}

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<LivroExemplar> getExemplar() {
		return exemplar;
	}
	public void setExemplar(List<LivroExemplar> exemplar) {
		this.exemplar = exemplar;
	}
	
	
	
	@Override
	public String toString() {
		return "Livros [" +getTitulo()+  ", autor:" +getAutor()+ ", edição:" +getEdicao()+ ", código: " +getCode()+ ",exemplares: " +qtdExemplares+"]" ;
	}
}
