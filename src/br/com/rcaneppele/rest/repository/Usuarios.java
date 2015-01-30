package br.com.rcaneppele.rest.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.rcaneppele.rest.resource.Usuario;
import br.com.rcaneppele.rest.security.GeradorDeHash;

public class Usuarios {

	@Inject
	private GeradorDeHash gerador;
	
	private List<Usuario> cadastrados = new ArrayList<>();
	
	public Usuarios() {
		cadastrados.add(criaUsuario("fulano@fulano.com"));
		cadastrados.add(criaUsuario("beltrano@beltrano.com"));
		cadastrados.add(criaUsuario("ciclano@ciclano.com"));
	}

	private Usuario criaUsuario(String login) {
		return new Usuario(login, gerador.geraHash(login));
	}
	
	public boolean isCadastrado(String login) {
		Usuario cadastrado = comLogin(login);
		return cadastrado != null;
	}

	public Usuario comLogin(String login) {
		for (Usuario cadastrado : cadastrados) {
			if (cadastrado.getLogin().equals(login)) {
				return cadastrado;
			}
		}
		
		return null;
	}
	
}
