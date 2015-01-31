package br.com.rcaneppele.rest.security;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.rcaneppele.rest.repository.Usuarios;
import br.com.rcaneppele.rest.resource.Usuario;

public class ValidadorClienteCadastrado {

	private final Usuarios usuarios;
	
	@Inject
	public ValidadorClienteCadastrado(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	public boolean isValida(HttpServletRequest request) {
		String login = request.getHeader("login");
		Usuario cliente = usuarios.comLogin(login);
		
		return cliente != null;
	}
	
}
