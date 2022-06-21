
public class GerenciarUsuario {

	public static void main(String[] args) {
		Usuario us = new Usuario();
		us.nomeUsuario = "admin";
		us.senha = "123";
		us.nivelAcesso = "Admin";
		us.criarUsuario();

	}

}
