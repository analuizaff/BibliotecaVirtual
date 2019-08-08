package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class LivroExemplar {
	//sttatus do livro;
	private int idExemplar;
	private boolean disponibilidade;


	public LivroExemplar(String titulo, String autor, String edicao, int id) {
		this.idExemplar = id;
		this.disponibilidade = true;
	}

	public int getIdExemplar() {
		return idExemplar;
	}

	public void setIdExemplar(int idExemplar) {
		this.idExemplar = idExemplar;
	}
	
	public boolean isDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}


}
