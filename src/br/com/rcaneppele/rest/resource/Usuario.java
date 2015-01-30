package br.com.rcaneppele.rest.resource;

public class Usuario {

	private String login;
	private String hash;
	
	public Usuario(String login, String hash) {
		this.login = login;
		this.hash = hash;
	}

	public String getLogin() {
		return login;
	}
	public String getHash() {
		return hash;
	}
	
}
