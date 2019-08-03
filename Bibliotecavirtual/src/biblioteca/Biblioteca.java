package biblioteca;

import java.util.ArrayList;
import java.util.List;

import biblioteca.Livros;


public class Biblioteca {
	public static List <Livros> acervo = new ArrayList <Livros>();;
	static List <String> titulosExistentes = new ArrayList <String> (); //só guarda o titulo do meu livro apenas para verificações futuras
	private static int contadorId = 0;
	
	public static void adicionaLivro(Livros livro) throws LivroExiste{ //esse metodo adiciona um livro a minha biblioteca. esse livro n será um obj de biblioteca.
		// a exceção livroexiste n permite adicionar um livro já existente
		if (titulosExistentes.contains(livro.getTitulo())) {
			for(int i=0; i < acervo.size(); i++) {
				if(((Livros) acervo.get(i)).getEdicao() == livro.getEdicao()) {
					throw new LivroExiste();
				}
			}	
		}	
		contadorId ++;
		acervo.add(livro); 
		titulosExistentes.add(livro.getTitulo());
	}
	public static void ListaLivros() {
		for (int i=0; i < acervo.size(); i++) {
			System.out.println(acervo.get(i).toString()+ "\n");
		}
	}

	public static List<Livros> getAcervo() {
		return acervo;
	}

	public static void setAcervo(List<Livros> acervo) {
		Biblioteca.acervo = acervo;
	}

	public static List<String> getTitulosExistentes() {
		return titulosExistentes;
	}

	public static void setTitulosExistentes(List<String> titulosExistentes) {
		Biblioteca.titulosExistentes = titulosExistentes;
	}

	public static int getContadorId() {
		return contadorId;
	}

	public static void setContadorId(int contadorId) {
		Biblioteca.contadorId = contadorId;
	}
	
	public int quantidadeLivro() {
		return acervo.size();
	}
	
	public Livros getLivro(int indice) {
		return acervo.get(indice);
	}
	

}

