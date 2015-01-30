package br.com.rcaneppele.rest.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.rcaneppele.rest.resource.Produto;

public class Produtos {

	private List<Produto> todos = new ArrayList<>();
	
	public Produtos() {
		todos.add(new Produto(1L, "IPad", new BigDecimal("1400")));
		todos.add(new Produto(2L, "IPhone", new BigDecimal("1900")));
		todos.add(new Produto(3L, "Mochila", new BigDecimal("285.89")));
		todos.add(new Produto(4L, "IPad", new BigDecimal("1400")));
		todos.add(new Produto(5L, "IPad", new BigDecimal("1400")));
	}
	
	public List<Produto> todos() {
		return todos;
	}
	
	public Produto comCodigo(Long codigo) {
		for (Produto produto : todos) {
			if (produto.getCodigo().equals(codigo)) {
				return produto;
			}
		}
		
		return null;
	}
	
}
