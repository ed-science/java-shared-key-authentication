package br.com.rcaneppele.rest.security;

import org.apache.commons.codec.digest.DigestUtils;

public class GeradorDeHashDeCliente {

	public String geraHash(String login) {
		return DigestUtils.sha512Hex(login);
	}
	
}
