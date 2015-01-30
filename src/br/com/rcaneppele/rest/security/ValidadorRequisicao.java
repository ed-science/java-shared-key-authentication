package br.com.rcaneppele.rest.security;

import javax.servlet.http.HttpServletRequest;

public class ValidadorRequisicao {

	public boolean isValida(HttpServletRequest request) {
		String login = request.getHeader("login");
		String assinatura = request.getHeader("assinatura");
		
		if (login != null && assinatura != null) {
			return true;
		}
		
		return false;
	}
	
}
