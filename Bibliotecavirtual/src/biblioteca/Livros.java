	package biblioteca;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import usuario.Aluno;
import usuario.Professor;
import usuario.Usuarios;

public class Livros {
	
	String code;
	private String titulo;
	private String autor;
	private String edicao;
	private List <LivroExemplar> exemplar = new ArrayList<LivroExemplar>();
	private int id;
	private static int idLivros = 0;
	private int qtdExemplares = 0;
	private static int qtdExemplaresFinal;
	private LocalDateTime datadehoje;
	Usuarios usuarioComLivro;
	private int usuarioEmprestadoID;
	
	private static int contadorId =0;
	private static ArrayList <Integer> idlivros = new ArrayList <Integer> ();//só guarda os ids dos exeplres, feito apenas para verificações futuras
	
	public Livros(String titulo, String autor, String edicao, String code) {
		this.titulo = titulo;
		this.autor = autor;
		this.edicao = edicao;
		this.code = code;
		this.id = idLivros;
		idLivros++;
	}
	public void adicionaExemplar(){	//adiciona Exemplar ao meu livro
		contadorId++;
		idlivros.add(contadorId);
		qtdExemplares++;
		exemplar.add (new LivroExemplar(titulo, autor, edicao, contadorId));
		
		
	}
	
	public void removeExemplar(int idexemplar) {//remove exemplares do livro pelo id do exemplar
		idlivros.remove(idexemplar);
		qtdExemplares--;
		exemplar.remove(idexemplar);
		System.out.println("Exemplar removido com sucesso." );
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
	
	public static int getContadorExemplares(Livros livro) {
		return livro.qtdExemplares;
	}
	
	public static int decresceContadorExemplares(Livros livro) {
		return livro.qtdExemplares--;
	}
	
	public void setQtdExemplaresFinal() {
		this.qtdExemplaresFinal = qtdExemplares;
	}
	
	public static int getQtdExemplaresFinal() {
		return qtdExemplaresFinal;
	}
	
	/*
	@Override
	public String toString() {
		return "Livros [" +getTitulo()+  ", autor:" +getAutor()+ ", edicaoo:" +getEdicao()+ ", id: " + getId() + ",exemplares: " +qtdExemplares+"]" ;
	}*/
	
	@Override
	public String toString() {
		String s = "ID: " + getId() + "; Titulo: "+ getTitulo() + "; Autor: " + getAutor() + " ; Edicao: " + getEdicao() + "; Exemplares: " + qtdExemplares;
		return s;
	}
	
	public void setDataEmprestimo(LocalDateTime datadehoje) {
		this.datadehoje = datadehoje;
	}
	
	public String getUsuarioEmprestado() {
		return usuarioComLivro.getNome();
	}
	
	public void setUsuarioEmprestadoID(int id) {
		this.usuarioEmprestadoID = id;
	}
	
	public int getUsuarioEmprestadoID(Aluno aluno) {
		return usuarioEmprestadoID = aluno.getId();
	}

	public void setUsuarioEmprestado(Usuarios usuarioComLivro) {
		this.usuarioComLivro = usuarioComLivro;
	}
	
	public LocalDateTime getDataEmprestimo() {
		return this.datadehoje;
	}
	public int getUsuarioEmprestadoID(Professor professor) {
		return usuarioEmprestadoID = professor.getId();
	}
}
