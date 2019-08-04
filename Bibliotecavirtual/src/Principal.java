
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.*;
import usuario.*;

public class Principal {

	
	private static Scanner scan = new Scanner(System.in);
	private static Registro registroAluno;
	private static Registro registroProfessor;
	private static Biblioteca acervo;
	
	ArrayList<Professor> professores;
	ArrayList<Aluno> alunos;
	ArrayList<Livros> livros;
	
	//Funcao adiciona professor
	private static void adicionaProfessor() {
		String email, senha, nome;
		Usuarios professor;
		System.out.println("Nome:");
		nome = scan.next();
		System.out.println("Email:");
		email = scan.next();
		System.out.println("Senha:");
		senha = scan.next();
		
		professor = new Professor(email, senha);
		professor.setNome(nome);
		//professor.setLogin(email, senha);
		//professor.setNome(nome);
		
		registroProfessor.adicionaProfessor(professor);
	}
	
	//Funcao adiciona aluno
	private static void adicionaAluno() {
		String email, senha, nome;
		Usuarios aluno;
		System.out.println("Nome:");
		nome = scan.next();
		System.out.println("Email:");
		email = scan.next();
		System.out.println("Senha:");
		senha = scan.next();
		
		aluno = new Aluno(email, senha);
		//aluno.setLogin(email, senha);
		aluno.setNome(nome);
		
		registroAluno.adicionaAluno(aluno);
	}
	
	//Funcao adiciona livro
	private static void adicionaLivro() throws LivroExiste {
		String titulo, autor, edicao, code;
		Biblioteca acervo;
		Livros livro;
		int quantidade;
		System.out.println("Título:");
		titulo = scan.next();
		System.out.println("Autor:");
		autor = scan.next();
		
		System.out.println("Edição:");
		edicao = scan.next();
		
		System.out.println("Codigo:");
		code = scan.next();
		
		System.out.println("Quantidade de Exemplares a serem adicionados:");
		quantidade = scan.nextInt();
		
		livro = new Livros(titulo, autor, edicao, code);
		try {
			Biblioteca.adicionaLivro(livro);
			for(int i=0;i<quantidade;i++) {
				livro.adicionaExemplar();
			}
		} catch (LivroExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//acervo = new Biblioteca();
	}
	
	//Funcao listar usuarios
	private static void listarUsuarios() {
		System.out.println("Alunos");
		for(int i=0;i<registroAluno.quantidadeAluno();i++) {
			Aluno aluno = (Aluno) registroAluno.getAluno(i);
			//System.out.printf("%s;%s;%s\n", aluno.getNome(), aluno.getEmail(), aluno.getSenha());
			System.out.println("ID: " + aluno.getId() + " " + aluno.toString());
		}
		System.out.println("Professores");
		for(int i=0;i<registroProfessor.quantidadeProfessor();i++) {
			Professor professor = (Professor) registroProfessor.getProfessor(i);
			//System.out.printf("%s;%s;%s\n", professor.getNome(), professor.getEmail(), professor.getSenha());
			System.out.println("ID: " + professor.getId() + " " + professor.toString());
		}
	}
	
	//Funcao listar livros
	private static void listarLivros() {
		for(int i=0;i<acervo.quantidadeLivro();i++) {
			Livros livro = acervo.getLivro(i);
			//System.out.printf("%i;%s;%s\n", livro.getId(), livro.getTitulo(), livro.getAutor());
			System.out.println(livro.toString());
		}
	}
	
	//Funcao remove professor
	private static void removeProfessor() {
		System.out.println("Insira o ID do Professor a ser removido");
		int id = scan.nextInt();
		System.out.println("Deseja remover o Professor ID " + id + "?");
		System.out.println("1- Sim // 2- Não");
		int op = scan.nextInt();
		if(op==1) {
			registroProfessor.removeProfessor(id);
			System.out.println("Professor removido com sucesso.");
		}
		else {
			return;
		}
	}
	
	//@Parametro informacao recebe o Titulo ou o Autor p realizar a busca
	private static void buscaLivro(String informacao) {
		/*
		Livros livro;
		boolean encontrado = false;
		int i;
		int indiceEncontrado;
		for(i=0;i<acervo.quantidadeLivro();i++) {
			livro = acervo.getLivro(i); 
			if(livro.getTitulo().equalsIgnoreCase(informacao)) {
				System.out.println("Livro encontrado!");
				System.out.println(livro.toString());
				encontrado = true;
				break;
			}
			else if(livro.getAutor().equalsIgnoreCase(informacao)) {
				System.out.println("Livro encontrado!");
				System.out.println(livro.toString());
				encontrado = true;
				break;
			}
		}
		if(encontrado == false) {
			System.out.println("Livro não encontrado!");
		}
		*/
		Biblioteca.buscaLivro(informacao);
	}
	
	private static boolean loginAluno(String email, String senha) {
		Aluno aluno;
		boolean login = false;
		for(int i=0;i<registroAluno.quantidadeAluno();i++) {
			aluno = (Aluno) registroAluno.getAluno(i);
			if(email.equalsIgnoreCase(registroAluno.getEmailAluno(aluno))) {
				if(senha.equalsIgnoreCase(registroAluno.getSenhaAluno(aluno))) {
				login = true;
				System.out.println("Login efetuado com sucesso");
				return login;
				}
			}
		}
		return login;
	}
	
	private static boolean loginProfessor(String email, String senha) {
		Professor professor;
		boolean login = false;
		for(int i=0;i<registroProfessor.quantidadeProfessor();i++) {
			professor = (Professor) registroProfessor.getProfessor(i);
			if(email.equalsIgnoreCase(registroProfessor.getEmailProfessor(professor))) {
				if(senha.equalsIgnoreCase(registroProfessor.getSenhaProfessor(professor))) {
				login = true;
				System.out.println("Login efetuado com sucesso");
				return login;
				}
			}
		}
		return login;
	}
	
	//Funcao remove aluno
	private static void removeAluno() {
		System.out.println("Insira o ID do Aluno a ser removido");
		int id = scan.nextInt();
		System.out.println("Deseja remover o Aluno ID " + id + "?");
		System.out.println("1- Sim // 2- Não");
		int op = scan.nextInt();
		if(op==1) {
			registroAluno.removeAluno(id);
			System.out.println("Aluno removido com sucesso.");
		}
		else {
			return;
		}
	}
	
	//Funcao remove Livro
	private static void removeLivro(int id) {
		Biblioteca.removeLivro(id);
	}
	
	private static void removeExemplar(int id) {
		//Livros.
	}
	
	public static void main(String[] args) {
		
		//Declaracao
		registroAluno = new Registro();
		registroProfessor = new Registro();
		acervo = new Biblioteca();
		
		//Inserido alguns livros, alunos e usuarios pra nao ficar inserindo manual
		Livros l1 = new Livros("java para burros", "ana", "3", "j567");
		try {
			Biblioteca.adicionaLivro(l1);
		} catch (LivroExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l1.adicionaExemplar();
		l1.adicionaExemplar();
		
		Livros l2 = new Livros("java", "Luiza", "3", "J332.1");
		try {
			Biblioteca.adicionaLivro(l2);
		} catch (LivroExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l2.adicionaExemplar();
		
		
		/*Livros l1 = new Livros("A", "A", "A");
		Livros l2 = new Livros("B", "B", "A");
		acervo.adicionaLivro(l1);
		acervo.adicionaLivro(l2);*/
		
		
		Professor p1 = new Professor("C", "C");
		p1.setNome("Teste");
		Professor p2 = new Professor("D", "D");
		p2.setNome("Teste");
		registroProfessor.adicionaProfessor(p1);
		registroProfessor.adicionaProfessor(p2);
		
		Aluno a1 = new Aluno("S", "S");
		a1.setNome("Teste");
		Aluno a2 = new Aluno("F", "F");
		a2.setNome("Teste");
		registroAluno.adicionaAluno(a1);
		registroAluno.adicionaAluno(a2);
		
		//Primeiro menu
		//Ainda vou fazer um comando  menu1() por exemplo pra nao ficar aparecendo tudo isso aqui
		//Os switchs tao absurdamentes todos jogados
		//Soh pra poder usar e ver a funcionalidade
		
		int opcao;
		do {
			System.out.println("1- Aluno");
			System.out.println("2- Professor");
			System.out.println("3- Bibliotecario");
			System.out.println("4- Sair");
			opcao = scan.nextInt();
		
		
		switch(opcao) {
		case 1: 
			System.out.println("1- Login");
			System.out.println("2- Registre-se");
			int op = scan.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("Insira seu Email:");
				String email = scan.next();	
				System.out.println("Insira sua Senha:");
				String senha = scan.next();
				
				if(loginAluno(email, senha)) {
					System.out.println("1- Emprestar livro");
					System.out.println("2- Devolver livro");
					int opcao4 = scan.nextInt();
					break;
				}
				else {
					System.out.println("Email ou senha incorreta.");
				}
			break;
			
			case 2:
				System.out.println("Registro Aluno");
				adicionaAluno();
				System.out.println("Cadastro realizado com sucesso!");
				break;
			}
		break;
		
		case 2:
			System.out.println("1- Login");
			System.out.println("2- Registre-se");
			op = scan.nextInt();
			
			switch(op) {
			case 1:
				System.out.println("Professor,");
				System.out.println("Insira seu Email:");
				String email = scan.next();	
				System.out.println("Insira sua Senha:");
				String senha = scan.next();
				
				if(loginProfessor(email, senha)) {
					System.out.println("1- Emprestar livro");
					System.out.println("2- Devolver livro");
					int opcao4 = scan.nextInt();
					break;
				}
				else {
					System.out.println("Email ou senha incorreta.");
				}
				
			break;
			case 2:
				System.out.println("Registro Professor");
				adicionaProfessor();
				System.out.println("Cadastro realizado com sucesso!");
				break;
			}
			break;
		case 3:
			
			//Aqui ta comentado so pra facilitar na hora de ficar inserindo
			//Se tirar o comentado ele comeca a pedir email e senha = admin admin p dar acesso
			
			/*
			System.out.println("Email:");
			String email = scan.next();
			System.out.println("Senha:");
			String senha = scan.next();
			
			if(senha.equalsIgnoreCase("admin") && email.equalsIgnoreCase("admin")) {
				System.out.println("Login efetuado com sucesso!");
			}
			else {
				System.out.println("Email ou senha incorretos.");
				break;
			}*/
			
			//Funcoes exclusivas quando logado em bibliotecario
			System.out.println("Bem vindo, bibliotecario.");
			System.out.println("1- Cadastrar");
			System.out.println("2- Remover");
			System.out.println("3- Listar ou Buscar");
			System.out.println("4- Logout");
			int opcao2 = scan.nextInt();
			switch(opcao2) {
			//Funcao pra cadastrar
			case 1:
				System.out.println("Cadastro");
				System.out.println("1- Cadastrar Aluno");
				System.out.println("2- Cadastrar Professor");
				System.out.println("3- Cadastrar Livro");
				int opcao3 = scan.nextInt();
				switch(opcao3) {
				case 1:
					System.out.println("Cadastro de Aluno");
					adicionaAluno();
					break;
				case 2:
					System.out.println("Cadastro de Professor");
					adicionaProfessor();
					break;
				case 3:
					System.out.println("Cadastro de Livros");
					try {
						adicionaLivro();
					} catch (LivroExiste e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				}
			break;
			
			//Funcao pra remover, ainda falta colocar remover aluno e livro
			case 2:
				System.out.println("1- Remover Aluno");
				System.out.println("2- Remover Professor");
				System.out.println("3- Remover Livro");
				int op1 = scan.nextInt();
				switch(op1) {
				
				case 1:
					System.out.println("Remover Aluno");
					break;
					
				case 2:
					System.out.println("Remover Professor");
					removeProfessor();
					break;
				case 3:
					System.out.println("Remover Livro");
					System.out.println("Insira o ID do Livro a ser removido.");
					System.out.println("Ao remover, todos os exemplares também serão removidos.");
					int id = scan.nextInt();
					removeLivro(id);
					System.out.println("Livro removido com sucesso!");
				}
				
			//Funcao pra listar livros ou todos usuarios cadastrados
				//Na hora de listar os usuarios ele separa por aluno e professor
			case 3:
				System.out.println("1- Listar livros");
				System.out.println("2- Listar usuários cadastrados");
				System.out.println("3- Buscar livro");
				opcao = scan.nextInt();
				switch(opcao) {
				case 1: 
					System.out.println("Livros:");
					listarLivros();
					break;
				case 2:
					System.out.println("Usuários");
					listarUsuarios();
					break;
				case 3:
					System.out.println("Insira o Nome ou o Autor do Livro desejado:");
					String informacao = scan.next();
					buscaLivro(informacao);
				}
			}
		}
		}while(opcao!=4);
	}

}
