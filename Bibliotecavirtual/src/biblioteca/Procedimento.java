package biblioteca;

public interface Procedimento { //essa interface possui como método todas as ações que podem ser feitas pelos usuários e será implementada por todos os usuários
	 
	void emprestimo(Livros livro); //realiza o emprestimo de um livro
		
	void devolucao(Livros livro); //realiza a devolução do livro
	
	Livros busca(String titulo); //busca livro por titulo
	
	Livros verifica(Livros livro); //verifica se o livro está disponível ou não para emprestimo
}
