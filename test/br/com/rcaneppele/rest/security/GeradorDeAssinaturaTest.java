package br.com.rcaneppele.rest.security;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.rcaneppele.rest.resource.Usuario;

public class GeradorDeAssinaturaTest {

	@Mock
	private HttpServletRequest request;
	
	private Usuario cliente;
	
	private GeradorDeAssinatura gerador;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		
		this.gerador = new GeradorDeAssinatura();
		this.cliente = new Usuario("fulano@fulano.com", "9370132982a19cdda89e09d5c08659c5141c945be7759e5de8100d7757817f704eb189bcdf5cc15104e40d7ff8f3505d4d7d90e7695d1f2e393c679c2e157b1b");
	}
	
	@Test
	public void deveriaGerarAssinaturaParaRequisicaoDoCliente() {
		Mockito.when(request.getMethod()).thenReturn("GET");
		Mockito.when(request.getServletPath()).thenReturn("/rest");
		Mockito.when(request.getPathInfo()).thenReturn("/produtos");
		
		String assinaturaGerada = gerador.gera(request, cliente);
		Assert.assertEquals(assinaturaEsperada(), assinaturaGerada);
	}

	private String assinaturaEsperada() {
		return "bedf69e88e3afca0ddf37f2554d1fce3c0b6dd659167d17b7695205ec490dc6630c75cfee8684322c79f49b120aa5317c151c843b7a52cd8732776ae72146777";
	}
	
}
