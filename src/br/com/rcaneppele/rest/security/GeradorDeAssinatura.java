package br.com.rcaneppele.rest.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.rcaneppele.rest.resource.Usuario;

public class GeradorDeAssinatura {
	
	private static final String DELIMITER = "||#||$";

	public String gera(HttpServletRequest request, Usuario cliente) {
		String method = request.getMethod();
		String resourceURI = request.getServletPath() + request.getPathInfo();
		String login = cliente.getLogin();
		
		String assinatura = method + DELIMITER + resourceURI + DELIMITER + login + DELIMITER;
		
		return DigestUtils.sha512Hex(cliente.getHash() + assinatura);
	}
	
}
