package usuario;
import biblioteca.*;

public class Bibliotecario extends Usuarios {

	String nome = "Bibliotecário";
	String email = "admin@biblioteca.com";
	String senha = "admin";
	
	Registro bibliotecario;
	
	public Bibliotecario(String nome, String email, String senha) {
		super(nome, email, senha);
	}
}
