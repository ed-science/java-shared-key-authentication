package br.com.rcaneppele.rest.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.rcaneppele.rest.resource.Usuario;

public class Usuarios {

	private List<Usuario> cadastrados = new ArrayList<>();
	
	public Usuarios() {
		cadastrados.add(new Usuario("fulano@fulano.com", "Fulano"));
		cadastrados.add(new Usuario("beltrano@beltrano.com", "Beltrano"));
		cadastrados.add(new Usuario("ciclano@ciclano.com", "Ciclano"));
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
