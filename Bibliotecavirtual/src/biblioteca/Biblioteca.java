package biblioteca;

import java.util.ArrayList;
import java.util.List;

public interface Biblioteca {
 
	List <Livros> acervo = new ArrayList <Livros>();
	
	public static void adicionarLivro(String titulo, String edicao, String autor, int id) {
		//metodo para adicionar livros ao acervo
	}
	
	

	public static void removeLivro(String titulo, String edicao, String autor) {
		
	}//metodo para remover livros do acervo

	
	
	
	
	
}
