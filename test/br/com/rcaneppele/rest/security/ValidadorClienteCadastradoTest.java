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

public class ValidadorClienteCadastradoTest {
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private Usuarios usuarios;
	
	private ValidadorClienteCadastrado validador;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		validador = new ValidadorClienteCadastrado(usuarios);
	}
	
	@Test
	public void deveriaInformarQueClienteNaoEstaCadastradoQuandoHeaderLoginNaoForInformado() {
		Mockito.when(request.getHeader("login")).thenReturn(null);
		Mockito.when(usuarios.comLogin(null)).thenReturn(null);
		
		boolean valida = validador.isValida(request);
		Assert.assertFalse(valida);
	}
	
	@Test
	public void deveriaInformarQueClienteNaoEstaCadastradoQuandoLoginForInvalido() {
		Mockito.when(request.getHeader("login")).thenReturn("teste");
		Mockito.when(usuarios.comLogin("teste")).thenReturn(null);
		
		boolean valida = validador.isValida(request);
		Assert.assertFalse(valida);
	}
	
	@Test
	public void deveriaInformarQueClienteEstaCadastradoQuandoLoginForValido() {
		Mockito.when(request.getHeader("login")).thenReturn("teste");
		Mockito.when(usuarios.comLogin("teste")).thenReturn(new Usuario("teste", "hash"));
		
		boolean valida = validador.isValida(request);
		Assert.assertTrue(valida);
	}

}
