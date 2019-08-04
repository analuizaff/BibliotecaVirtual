package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class LivroExemplar {
	//sttatus do livro;
	private int idExemplar;


	public LivroExemplar(String titulo, String autor, String edicao, int id) {
		this.idExemplar = id;
		//super(titulo, autor, edicao, id);
		// TODO Auto-generated constructor stub
	}

	public int getIdExemplar() {
		return idExemplar;
	}
	

}
