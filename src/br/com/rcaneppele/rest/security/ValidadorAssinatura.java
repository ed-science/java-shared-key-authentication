package br.com.rcaneppele.rest.security;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.rcaneppele.rest.repository.Usuarios;
import br.com.rcaneppele.rest.resource.Usuario;

public class ValidadorAssinatura {

	@Inject
	private Usuarios usuarios;
	
	@Inject
	private GeradorDeAssinatura geradorDeAssinatura;

	public boolean isValida(HttpServletRequest request) {
		Usuario cliente = usuarios.comLogin(request.getHeader("login"));

		String assinaturaRequisicao = request.getHeader("assinatura");
		String assinaturaGerada = geradorDeAssinatura.gera(request, cliente);
		
		return assinaturaRequisicao.equals(assinaturaGerada);
	}
	
}
