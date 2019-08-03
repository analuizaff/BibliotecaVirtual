package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Biblioteca {
 
	private ArrayList<Livros> acervo;
	
	//Construtor
	public Biblioteca() {
		//super();
		acervo = new ArrayList<Livros>();
	}
	
	//metodo para adicionar livros ao acervo
	public void adicionarLivro(Livros livro) {
		acervo.add(livro);
	}
	
	
	//metodo para remover livros do acervo
	public void removeLivro(Livros livro) {
		acervo.remove(livro);
	}
	
	public void removeLivro(int ID) {
		acervo.remove(ID);
	}
	
	public Livros getLivro(int indice) {
		return acervo.get(indice);
	}
	
	//Funcao pra saber a quantidade de livros ja foram cadastrados
	//E poder usar na hora de limitar o for
	public int quantidadeLivro() {
		return acervo.size();
	}
	
	//Ainda precisa implementar mas pelo que vi tem uma funcao que faz isso
	public void ordenaAlfabeto() {
	}
}
