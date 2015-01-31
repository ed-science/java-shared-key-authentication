package br.com.rcaneppele.rest.security;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.rcaneppele.rest.repository.Usuarios;
import br.com.rcaneppele.rest.resource.Usuario;

public class ValidadorAssinaturaTest {
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private Usuarios usuarios;
	
	@Mock
	private GeradorDeAssinatura gerador;
	
	private ValidadorAssinatura validador;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		
		this.validador = new ValidadorAssinatura(usuarios, gerador);
	}
	
	@Test
	public void deveriaIndicarQueAssinaturaNaoEhValida() {
		String login = "fulano@fulano.com";
		String assinatura = "xpto123";
		Usuario cliente = new Usuario(login, "hash");

		Mockito.when(request.getHeader("login")).thenReturn(login);
		Mockito.when(request.getHeader("assinatura")).thenReturn(assinatura);
		Mockito.when(usuarios.comLogin(login)).thenReturn(cliente);
		Mockito.when(gerador.gera(request, cliente)).thenReturn("invalida");
		
		boolean valida = validador.isValida(request);
		Assert.assertFalse(valida);
	}
	
	@Test
	public void deveriaIndicarQueAssinaturaEhValida() {
		String login = "fulano@fulano.com";
		String assinatura = "xpto123";
		Usuario cliente = new Usuario(login, "hash");

		Mockito.when(request.getHeader("login")).thenReturn(login);
		Mockito.when(request.getHeader("assinatura")).thenReturn(assinatura);
		Mockito.when(usuarios.comLogin(login)).thenReturn(cliente);
		Mockito.when(gerador.gera(request, cliente)).thenReturn(assinatura);
		
		boolean valida = validador.isValida(request);
		Assert.assertTrue(valida);
	}

}
