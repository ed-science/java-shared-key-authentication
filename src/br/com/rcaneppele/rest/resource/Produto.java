package br.com.rcaneppele.rest.resource;

import java.math.BigDecimal;

public class Produto {

	private Long codigo;
	private String nome;
	private BigDecimal preco;
	
	public Produto(Long codigo, String nome, BigDecimal preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	
}
