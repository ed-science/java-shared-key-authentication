package br.com.rcaneppele.rest.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rcaneppele.rest.repository.Produtos;
import br.com.rcaneppele.rest.resource.Produto;

@Path("produtos")
public class ProdutoService {
	
	@Inject
	private Produtos produtos;

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Produto> todos() {
		return produtos.todos();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response comCodigo(@PathParam("codigo") Long codigo) {
		Produto buscado = produtos.comCodigo(codigo);
		
		if (buscado == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(buscado).build();
	}
	
}
