
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
		
		professor = new Professor(nome, email, senha);
		
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
		
		aluno = new Aluno(nome, email, senha);
		
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
	}
	
	//Funcao listar usuarios
	private static void listarUsuarios() {
		System.out.println("\t\tAlunos");
		for(int i=0;i<registroAluno.quantidadeAluno();i++) {
			Aluno aluno = (Aluno) registroAluno.getAluno(i);
			//System.out.printf("%s;%s;%s\n", aluno.getNome(), aluno.getEmail(), aluno.getSenha());
			System.out.println("ID: " + aluno.getId() + " " + aluno.toString());
		}
		System.out.println("\t\tProfessores");
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
				System.out.println("Login efetuado com sucesso!");
				System.out.println("Seu ID é: '" + registroAluno.getIDAluno(aluno) + "'");
				System.out.println("==============================");
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
				System.out.println("Login efetuado com sucesso!");
				System.out.println("Seu ID é: '" + registroAluno.getIDProfessor(professor) + "'");
				System.out.println("==================================");
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
		Livros livro = acervo.getLivro(id);
		livro.removeExemplar(id);
	}
	
	private static void emprestarLivroAluno(int idAluno) {
		System.out.println("=============== Lista de Livros ==============");
		listarLivros();
		System.out.println("==============================================");
		System.out.println("\nInsira o ID do Livro que voce deseja pegar emprestado:");
		int idLivro = scan.nextInt();
		Livros livro = Biblioteca.getLivro(idLivro);
		Aluno aluno = (Aluno) registroAluno.getAluno(idAluno);
		System.out.println("---------------------------");
		aluno.emprestimo(livro, aluno);
		System.out.println("---------------------------");
	}
	
	private static void emprestarLivroProfessor(int idProfessor) {
		System.out.println("=============== Lista de Livros ==============");
		listarLivros();
		System.out.println("==============================================");
		System.out.println("\nInsira o ID do Livro que voce deseja pegar emprestado.");
		int idLivro = scan.nextInt();
		Livros livro = Biblioteca.getLivro(idLivro);
		Professor professor = (Professor) registroProfessor.getProfessor(idProfessor);
		System.out.println("---------------------------");
		professor.emprestimo(livro, professor);
		System.out.println("---------------------------");
	}
	
	private static void listarEmprestimosUsuario(int opcao, int id) {
		switch(opcao) {
		case 1:
			Aluno aluno = (Aluno) registroAluno.getAluno(id);
			System.out.println("Listar emprestimos do Aluno " + aluno.getNome() + ", ID: " + aluno.getId());
			System.out.println("---------------------------");
			if(aluno.getEmprestimo() == 0) {
				System.out.println("O aluno nao efetuou nenhum emprestimo!");
				System.out.println("---------------------------");
			}
			//System.out.println(aluno.getEmprestimo());
			for(int i=0;i<acervo.quantidadeLivro();i++) {
					Livros livro = Biblioteca.getLivro(i);
					if(livro.getDataEmprestimo()!=null && livro.getUsuarioEmprestadoID(aluno) == id) {
						System.out.println("ID: "+ livro.getId() + " Titulo: '" + livro.getTitulo() + "' Data: " + livro.getDataEmprestimo());
				}
			}
			System.out.println("---------------------------");
			break;
		case 2:
			Professor professor = (Professor) registroProfessor.getProfessor(id);
			System.out.println("Listar emprestimos do Professor " + professor.getNome() + ", ID: " + professor.getId());
			System.out.println("---------------------------");
			if(professor.getEmprestimo() == 0) {
				System.out.println("O professor nao efetuou nenhum emprestimo!");
				System.out.println("---------------------------");
			}
			for(int i=0;i<professor.getEmprestimo();i++) {
					Livros livro = Biblioteca.getLivro(i);
					if(livro.getDataEmprestimo()!=null && livro.getUsuarioEmprestadoID(professor) == id) {
						System.out.println("ID: "+ livro.getId() + " Titulo: '" + livro.getTitulo() + "' Data: " + livro.getDataEmprestimo());
				}
			}
			System.out.println("---------------------------");
		}
	}
	
	public static void livrosPrefixados() {
		Livros l1 = new Livros("java para burros", "ana", "3", "CJ001");
		try {
			Biblioteca.adicionaLivro(l1);
		} catch (LivroExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l1.adicionaExemplar();
		l1.adicionaExemplar();
		
		Livros l2 = new Livros("java", "Luiza", "3", "CJ002");
		try {
			Biblioteca.adicionaLivro(l2);
		} catch (LivroExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l2.adicionaExemplar();
		
		Livros l3 = new Livros("Intro A Prog Orientada A Objetos", "Rafael Santos", "1", "CJ003");
		try {
			Biblioteca.adicionaLivro(l3);
		} catch (LivroExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l3.adicionaExemplar();
		
		Livros l4 = new Livros("Exercicios Java", "Adelaide Carvalho", "1", "CJ004");
		try {
			Biblioteca.adicionaLivro(l4);
		} catch (LivroExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l4.adicionaExemplar();
		
		Livros l5 = new Livros("Calculo II", "James Stewart", "8", "M001");
		try {
			Biblioteca.adicionaLivro(l5);
		} catch (LivroExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l5.adicionaExemplar();
	}
	
	public static void usuariosPrefixados() {
		//Professor p1 = new Professor("Vera", "vera@ufabc.edu.br", "vera123");
		Professor p1 = new Professor("1", "1", "1");
		//p1.setNome("Teste");
		Professor p2 = new Professor("Marcos", "marcos@ufabc.edu.br", "marcos123");
		Professor p3 = new Professor("Carla", "carla@ufabc.edu.br", "carla123");
		Professor p4 = new Professor("Joao", "joao@ufabc.edu.br", "joao123");
		Professor p5 = new Professor("Silvia", "silvia@ufabc.edu.br", "silvia123");
		
		registroProfessor.adicionaProfessor(p1);
		registroProfessor.adicionaProfessor(p2);
		registroProfessor.adicionaProfessor(p3);
		registroProfessor.adicionaProfessor(p4);
		registroProfessor.adicionaProfessor(p5);
		
		//Aluno a1 = new Aluno("Guilherme", "guilherme@aluno.ufabc.edu.br", "guilherme123");
		Aluno a1 = new Aluno("2", "2", "2");
		//a1.setNome("Teste");
		Aluno a2 = new Aluno("Vinicius", "vinicius@aluno.ufabc.edu.br", "vinicius123");
		Aluno a3 = new Aluno("Beatriz", "beatriz@aluno.ufabc.edu.br", "beatriz123");
		Aluno a4 = new Aluno("Ana", "ana@aluno.ufabc.edu.br", "ana123");
		Aluno a5 = new Aluno("Julia", "julia@aluno.ufabc.edu.br", "julia123");
		
		registroAluno.adicionaAluno(a1);
		registroAluno.adicionaAluno(a2);
		registroAluno.adicionaAluno(a3);
		registroAluno.adicionaAluno(a4);
		registroAluno.adicionaAluno(a5);
	}
	
	public static void main(String[] args) {
		
		//Declaracao
		registroAluno = new Registro();
		registroProfessor = new Registro();
		acervo = new Biblioteca();
		int opcao;
		
		livrosPrefixados();
		usuariosPrefixados();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("                   Biblioteca Java");
		System.out.println("                   Seja bem-vindo!");
		System.out.println("-------------------------------------------------------");
		
		
		do {
			System.out.println("*** Menu Principal ***");
			System.out.println("1- Aluno");
			System.out.println("2- Professor");
			System.out.println("3- Bibliotecario");
			System.out.println("4- Sair");
			System.out.println("----------------------");
			opcao = scan.nextInt();
		
		
			switch(opcao) {
			
			case 1: 
				menuAluno();
				break;
		
			case 2:
				menuProfessor();
				break;
		
			case 3:
				menuBibliotecario();
				break;
			}
			
		}while(opcao!=4);
		
	}
	
	public static void menuListarOuBuscar() {
		System.out.println("---------------------------");
		System.out.println("1- Listar livros");
		System.out.println("2- Listar usuários cadastrados");
		System.out.println("3- Buscar livro");
		System.out.println("4- Listar emprestimos de Usuario");
		System.out.println("---------------------------");
		int opcao = scan.nextInt();
		switch(opcao) {
		case 1: 
			System.out.println("=============== Lista de Livros ==============");
			listarLivros();
			System.out.println("==============================================");
			break;
		case 2:
			System.out.println("============== Lista de Usuarios =============");
			listarUsuarios();
			System.out.println("==============================================");
			break;
		case 3:
			System.out.println("---------------------------");
			System.out.println("Insira o Nome ou o Autor do Livro desejado:");
			System.out.println("---------------------------");
			String informacao = scan.next();
			buscaLivro(informacao);
			break;
		case 4:
			System.out.println("---------------------------");
			System.out.println("1- Aluno");
			System.out.println("2- Professor");
			System.out.println("---------------------------");
			int opcao5 = scan.nextInt();
			System.out.println("---------------------------");
			System.out.println("Insira o ID do Usuario");
			System.out.println("---------------------------");
			int id = scan.nextInt();
			listarEmprestimosUsuario(opcao5, id);
			System.out.println("---------------------------");
			break;
		}
	}
	
	public static void menuRemove() {
		System.out.println("---------------------------");
		System.out.println("1- Remover Aluno");
		System.out.println("2- Remover Professor");
		System.out.println("3- Remover Livro");
		System.out.println("4- Remover Exemplares do Livro");
		System.out.println("---------------------------");
		int op1 = scan.nextInt();
		switch(op1) {
		
		case 1:
			System.out.println("Remover Aluno");
			removeAluno();
			break;
			
		case 2:
			System.out.println("Remover Professor");
			removeProfessor();
			break;
		case 3:
			System.out.println("------ Remover Livro ------");
			System.out.println("Insira o ID do Livro a ser removido.");
			System.out.println("Ao remover, todos os exemplares também serão removidos.");
			int id = scan.nextInt();
			removeLivro(id);
			System.out.println("Livro removido com sucesso!");
			System.out.println("---------------------------");
			break;
		case 4:
			System.out.println("---- Remover Exemplares ----");
			System.out.println("Insira o ID do Livro a ter Exemplares removidos:");
			id = scan.nextInt();
			System.out.println("Insira a quantidade de Exemplares a serem removidos:");
			int quantidade = scan.nextInt();
			for(int i=0;i<quantidade;i++) {
				removeExemplar(id);
			}
			System.out.println("---------------------------");
			break;
		}
	}
	
	public static void menuCadastroBibliotecario() {
		System.out.println("----- Cadastro -----");
		System.out.println("1- Cadastrar Aluno");
		System.out.println("2- Cadastrar Professor");
		System.out.println("3- Cadastrar Livro");
		System.out.println("--------------------");
		//System.out.println("4- Cadastrar Exemplar");
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
		case 4:
			System.out.println("Cadastro de Exemplar");
			break;
		}
	}
	
	public static void menuBibliotecario() {
		System.out.println("====== Login Bibliotecario ======");
		System.out.println("Email:");
		String email = scan.next();
		System.out.println("Senha:");
		String senha = scan.next();
		System.out.println("=================================");
		
		if(senha.equalsIgnoreCase("admin") && email.equalsIgnoreCase("admin")) {
			System.out.println("Login efetuado com sucesso!");
			
			System.out.println("---------------------------");
			System.out.println("Bem vindo, bibliotecario.");
			System.out.println("1- Cadastrar");
			System.out.println("2- Remover");
			System.out.println("3- Listar ou Buscar");
			System.out.println("4- Logout");
			System.out.println("---------------------------");
			int opcao2 = scan.nextInt();
			switch(opcao2) {
			case 1:
				menuCadastroBibliotecario();
				break;
			case 2:
				menuRemove();
				break;
			case 3:
				menuListarOuBuscar();
				break;
			}
		}
		else {
			System.out.println("Email ou senha inválidos.");
			System.out.println("---------------------------");
		}
	}
	
	public static void menuProfessor() {
		System.out.println("====== Login Professor ======");
		System.out.println("Insira seu Email:");
		String email = scan.next();	
		System.out.println("Insira sua Senha:");
		String senha = scan.next();
		System.out.println("=============================");
		
		if(loginProfessor(email, senha)) {
			System.out.println("Bem vindo, Professor.");
			System.out.println("---------------------------");
			System.out.println("1- Emprestar livro");
			System.out.println("2- Devolver livro");
			System.out.println("---------------------------");
			int opcao4 = scan.nextInt();
			switch(opcao4) {
			case 1: 
				System.out.println("--- Emprestimo de Livro ---");
				System.out.println("Insira o seu ID: ");
				System.out.println("---------------------------");
				int idProfessor = scan.nextInt();
				emprestarLivroProfessor(idProfessor);
				break;
			case 2:
				System.out.println("--- Registre-se Professor ---");
				adicionaProfessor();
				System.out.println("---------------------------");
				System.out.println("Cadastro realizado com sucesso!");
				System.out.println("---------------------------");
				break;
			}
		}
		else {
			System.out.println("Email ou senha invalidos.");
			System.out.println("---------------------------");
		}
	}	
	
	public static void menuAluno() {
		System.out.println("-------- Aluno --------");
		System.out.println("1- Login");
		System.out.println("2- Registre-se");
		System.out.println("3- Voltar");
		System.out.println("-----------------------");
		int op = scan.nextInt();
		
		switch(op) {
		case 1:
			System.out.println("====== Login Aluno ======");
			System.out.println("Insira seu Email:");
			String email = scan.next();	
			System.out.println("Insira sua Senha:");
			String senha = scan.next();
			System.out.println("=========================");
			
			if(loginAluno(email, senha)) {
				System.out.println("Bem vindo, Aluno.");
				System.out.println("---------------------------");
				System.out.println("1- Emprestar livro");
				System.out.println("2- Devolver livro");
				int opcao4 = scan.nextInt();
				switch(opcao4) {
				case 1: 
					System.out.println("==== Emprestimo de Livro ====");
					System.out.println("Insira o seu ID: ");
					int idAluno = scan.nextInt();
					emprestarLivroAluno(idAluno);
					break;
				case 2:
					System.out.println("Registro Aluno");
					adicionaAluno();
					System.out.println("Cadastro realizado com sucesso!");
					break;
				}
				break;
			}
			else {
				System.out.println("Email ou senha invalidos!");
			}
		}
	}
	
}
