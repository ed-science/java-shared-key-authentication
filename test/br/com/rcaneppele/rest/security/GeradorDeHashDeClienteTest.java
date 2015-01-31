package br.com.rcaneppele.rest.security;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeradorDeHashDeClienteTest {

	private GeradorDeHashDeCliente gerador;
	
	@Before
	public void before() {
		this.gerador = new GeradorDeHashDeCliente();
	}
	
	@Test
	public void deveriaGerarHashEsperado() {
		String fulano = "fulano@fulano.com";
		String beltrano = "beltrano@beltrano.com";
		String ciclano = "ciclano@ciclano.com";
		
		String hashFulano = gerador.geraHash(fulano);
		String hashBeltrano = gerador.geraHash(beltrano);
		String hashCiclano = gerador.geraHash(ciclano);
		
		Assert.assertEquals(hashFulano(), hashFulano);
		Assert.assertEquals(hashBeltrano(), hashBeltrano);
		Assert.assertEquals(hashCiclano(), hashCiclano);
		
	}

	private String hashFulano() {
		return "9370132982a19cdda89e09d5c08659c5141c945be7759e5de8100d7757817f704eb189bcdf5cc15104e40d7ff8f3505d4d7d90e7695d1f2e393c679c2e157b1b";
	}

	private String hashBeltrano() {
		return "9a8121da49983411262a06e7e20e5197f3353ef14347744ffd0721837aedf36eba15e90fc1f7c667b77a400476666fd03d157198a21755040c76992f32220a37";
	}

	private String hashCiclano() {
		return "a2903ba4064a6bd5994ca6057730f435f1b0e2198a9c2856f72778aba0a7538f3383811aa1178998f664904fba1b5c16c46c7466cbd0f1c0f422da3069a19ace";
	}
	
}
