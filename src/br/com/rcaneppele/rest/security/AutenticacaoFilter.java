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

import br.com.rcaneppele.rest.repository.Usuarios;

@WebFilter("/rest/*")
public class AutenticacaoFilter implements Filter {

	@Inject
	private Usuarios usuarios;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) res;
		
		String cliente = httpRequest.getHeader("cliente");
		if (usuarios.isCadastrado(cliente)) {
			chain.doFilter(req, res);
		} else {
			httpResponse.setStatus(403);
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

}
