
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
	private static void adicionaLivro() {
		String titulo, autor;
		Biblioteca acervo;
		Livros livro;
		System.out.println("Título:");
		titulo = scan.next();
		System.out.println("Autor:");
		autor = scan.next();
		
		livro = new Livros(titulo, autor);
		acervo = new Biblioteca();
		
		acervo.adicionarLivro(livro);
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
	
	//Funcao remove aluno
	private static void removeAluno() {
		//Vou implementar
	}
	
	//Funcao remove Livro
	private static void removeLivro() {
		//Vou implementar
	}
	
	public static void main(String[] args) {
		
		//Declaracao
		registroAluno = new Registro();
		registroProfessor = new Registro();
		acervo = new Biblioteca();
		
		//Inserido alguns livros, alunos e usuarios pra nao ficar inserindo manual
		Livros l1 = new Livros("A", "A");
		Livros l2 = new Livros("B", "B");
		acervo.adicionarLivro(l1);
		acervo.adicionarLivro(l2);
		
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
					adicionaLivro();
					break;
				}
			break;
			
			//Funcao pra remover, ainda falta colocar remover aluno e livro
			case 2:
				System.out.println("1- Remover Aluno");
				System.out.println("2- Remover Professor");
				System.out.println("3- Remover Livro");
				int op = scan.nextInt();
				switch(op) {
				
				case 1:
					System.out.println("Remover aluno");
					break;
					
				case 2:
					System.out.println("Remover Professor");
					removeProfessor();
					break;
				}
				
			//Funcao pra listar livros ou todos usuarios cadastrados
				//Na hora de listar os usuarios ele separa por aluno e professor
			case 3:
				System.out.println("1- Listar livros");
				System.out.println("2- Listar usuários cadastrados");
				opcao = scan.nextInt();
				switch(opcao) {
				case 1: 
					System.out.println("Livros:");
					listarLivros();
					break;
				case 2:
					System.out.println("Usuários");
					listarUsuarios();
				}
			}
		}
		}while(opcao!=4);
	}

}
