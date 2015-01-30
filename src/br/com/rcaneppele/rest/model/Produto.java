package br.com.rcaneppele.rest.model;

import java.math.BigDecimal;

public class Produto {

	private String codigo;
	private String nome;
	private BigDecimal preco;
	
	public Produto(String codigo, String nome, BigDecimal preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	
}
