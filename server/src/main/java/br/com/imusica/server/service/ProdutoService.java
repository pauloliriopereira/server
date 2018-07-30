package br.com.imusica.server.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.imusica.server.model.Produto;
import br.com.imusica.server.repository.ProdutoRepository;

@Component
@Path("/cadastro")
public class ProdutoService
{
	@Autowired
	ProdutoRepository repository;
	
	@POST
	@Path( "/salvar" )
	@Consumes( MediaType.APPLICATION_JSON )
	public Response salvar( Produto produto ) 
	{
		repository.save( produto );
		return Response.status( Response.Status.CREATED ).build();
	}
	
	@DELETE
	@Path( "/remover/{id}" )
	@Produces
	public Response remover( @PathParam( "id" ) String id  )
	{
		repository.deleteById( new Long( id ) );
		return  Response.ok().build();
	}
	
	@GET
	@Path( "/buscar/{id}" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response buscar( @PathParam( "id" ) String id  )
	{
		Produto produto = repository.findById(  Long.parseLong( id ) ).get();
		return Response.ok( produto ).build();
	}
	
	@PUT
	@Path( "/alterar" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response alterarProduto( Produto produtoNovo )
	{
		Produto produtoAntigo = repository.findById( produtoNovo.getId() ).get();
		produtoAntigo.setNome( produtoNovo.getNome() );
		produtoAntigo.setPreco( produtoNovo.getPreco() );
		produtoAntigo.setQuantidade( produtoNovo.getQuantidade() );
		repository.save( produtoAntigo );
		return Response.ok().build();
	}
	
	@GET
	@Path( "/listar" )
	@Produces( MediaType.APPLICATION_JSON )
	public Response listarProdutos()
	{
		Iterable<Produto> produtos = repository.findAll();
		return Response.ok( Lists.newArrayList( produtos ) ).build();
	}
}