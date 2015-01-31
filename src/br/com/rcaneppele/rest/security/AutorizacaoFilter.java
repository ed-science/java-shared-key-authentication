package br.com.rcaneppele.rest.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/rest/*")
public class AutorizacaoFilter implements Filter {

	@Inject
	private ValidadorAssinatura validadorAssinatura;
	
	@Inject
	private ValidadorRequisicao validadorRequisicao;
	
	@Inject
	private ValidadorClienteCadastrado validadorClienteCadastrado;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) res;
		
		if (!validadorRequisicao.isValida(httpRequest)) {
			httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Header's de autenticação faltando!");
		}
		
		if (!validadorClienteCadastrado.isValida(httpRequest)) {
			httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Cliente não cadastrado!");
		}
		
		if (!validadorAssinatura.isValida(httpRequest)) {
			httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Assinatura inválida!");
		}
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

}
