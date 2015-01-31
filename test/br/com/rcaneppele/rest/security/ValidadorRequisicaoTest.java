package br.com.rcaneppele.rest.security;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ValidadorRequisicaoTest {
	
	@Mock
	private HttpServletRequest request;
	
	private ValidadorRequisicao validador;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		validador = new ValidadorRequisicao();
	}
	
	@Test
	public void requisicaoDeveriaSerInvalidaSeNaoHouverHeaderDeLogin() {
		Mockito.when(request.getHeader("login")).thenReturn(null);
		
		boolean valida = validador.isValida(request);
		Assert.assertFalse(valida);
	}
	
	@Test
	public void requisicaoDeveriaSerInvalidaSeNaoHouverHeaderDeAssinatura() {
		Mockito.when(request.getHeader("assinatura")).thenReturn(null);
		
		boolean valida = validador.isValida(request);
		Assert.assertFalse(valida);
	}
	
	@Test
	public void requisicaoDeveriaSerInvalidaSeNaoHouveremHeadersDeAutenticacao() {
		Mockito.when(request.getHeader("login")).thenReturn(null);
		Mockito.when(request.getHeader("assinatura")).thenReturn(null);
		
		boolean valida = validador.isValida(request);
		Assert.assertFalse(valida);
	}
	
	@Test
	public void requisicaoDeveriaSerValidaSeHouveremHeadersDeAutenticacao() {
		Mockito.when(request.getHeader("login")).thenReturn("teste");
		Mockito.when(request.getHeader("assinatura")).thenReturn("teste");
		
		boolean valida = validador.isValida(request);
		Assert.assertTrue(valida);
	}

}
