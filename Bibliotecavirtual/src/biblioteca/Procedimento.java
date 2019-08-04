package biblioteca;

import usuario.Aluno;
import usuario.Usuarios;

public interface Procedimento { //essa interface possui como método todas as ações que podem ser feitas pelos usuários e será implementada por todos os usuários
	 
	void emprestimo(Livros livro, Usuarios aluno); //realiza o emprestimo de um livro
		
	void devolucao(Livros livro); //realiza a devolução do livro
	
	Livros busca(String titulo); //busca livro por titulo
	
	Livros verifica(Livros livro); //verifica se o livro está disponível ou não para emprestimo

	void emprestimo(Livros livro, Aluno usuario);
}
