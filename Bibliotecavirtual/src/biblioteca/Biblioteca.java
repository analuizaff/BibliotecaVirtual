package biblioteca;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import biblioteca.Livros;
import usuario.Aluno;
import usuario.Professor;
import usuario.Usuarios;


public class Biblioteca {
	public static List <Livros> acervo = new ArrayList <Livros>();;
	static List <String> titulosExistentes = new ArrayList <String> (); //só guarda o titulo do meu livro apenas para verificações futuras
	private static int contadorId = -1; //todos os livros terão um um id de 0 a n. esse id será incrementado toda vez que for criado um novo livro, assim o id tbm é a posicao que o livro esta guardado no array
	
	public static void adicionaLivro(Livros livro) throws LivroExiste{ //esse metodo adiciona um livro a minha biblioteca. esse livro n será um obj de biblioteca.
		// a exceção livroexiste n permite adicionar um livro já existente
		if (titulosExistentes.contains(livro.getTitulo())) {
			for(int i=0; i < acervo.size(); i++) {
				if(((Livros) acervo.get(i)).getEdicao() == livro.getEdicao()) {
					throw new LivroExiste();
				}
			}	
		}	
		contadorId++;
		acervo.add(livro); 
		titulosExistentes.add(livro.getTitulo());
	}

	public static void removeLivro(int id) {//remove livro por id
		acervo.remove(id);	
	}
	
	public static void ListaLivros() {//imprime todos os livro da biblioteca
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
	
	public static int quantidadeLivro() {
		return acervo.size();
	}
	
	public static Livros getLivro(int indice) {
		return acervo.get(indice);
	}
	
	public static void buscaLivro(String informacao) {
		Livros livro;
		boolean encontrado = false;
		int i;
		int indiceEncontrado;
		for(i=0;i<Biblioteca.quantidadeLivro();i++) {
			livro = Biblioteca.getLivro(i); 
			if(livro.getTitulo().equalsIgnoreCase(informacao)) {
				System.out.println("Livro encontrado!");
				System.out.println(livro.toString());
				System.out.println("------------------------");
				encontrado = true;
				break;
			}
			else if(livro.getAutor().equalsIgnoreCase(informacao)) {
				System.out.println("Livro encontrado!");
				System.out.println(livro.toString());
				System.out.println("------------------------");
				encontrado = true;
				break;
			}
		}
		if(encontrado == false) {
			System.out.println("Livro nao encontrado ou indisponivel!");
			System.out.println("---------------------------");
		}
	}
	
	public static void emprestimoLivroA(Livros livro, Aluno aluno) {
		LocalDateTime datadehoje = LocalDateTime.now();
		livro.setDataEmprestimo(datadehoje);
		livro.setUsuarioEmprestado(aluno);
		livro.setUsuarioEmprestadoID(aluno.getId());
	}
	
	public static void emprestimoLivroP(Livros livro, Professor professor) {
		LocalDateTime datadehoje = LocalDateTime.now();
		livro.setDataEmprestimo(datadehoje);
		livro.setUsuarioEmprestado(professor);
		livro.setUsuarioEmprestadoID(professor.getId());
	}

	public static void emprestimoLivroA(Livros livroEmprestimo, Professor professor) {	
	}

}

