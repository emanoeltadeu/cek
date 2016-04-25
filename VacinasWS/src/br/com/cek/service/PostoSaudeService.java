package br.com.cek.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import com.cek.model.PostoSaudeModel;

import br.com.cek.EntityManager.JpaEntityManager;

@Path("/postos")
public class PostoSaudeService {
	private JpaEntityManager JPAEM = new JpaEntityManager();        
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/buscarpostos")
	@Produces("application/json")
	public List<PostoSaudeModel> listar(){                             

		try {
			String query = "select p from PostoSaudeModel p";
			List<PostoSaudeModel> postos = objEM.createQuery(query, PostoSaudeModel.class).getResultList();        
			objEM.close();                                  
			return postos;     
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	}

	/*
	@GET
	@Path("/buscar/{id_cliente}")
	@Produces("application/json") 
	public ClienteModel buscar(@PathParam("id_cliente") int id_cliente){                       
		try {    
			ClienteModel cliente = objEM.find(ClienteModel.class, id_cliente);
			objEM.close();                                        
			return cliente;     
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	}

	@POST
	@Path("/cadastrar")
	@Consumes("application/json") 
	public Response cadastrar(ClienteModel objClinte){                                  
		try {
			objEM.getTransaction().begin();
			objEM.persist(objClinte);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro realizado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	}

	@PUT
	@Path("/alterar")
	@Consumes("application/json") 
	public Response alterar(ClienteModel objClinte){                                    
		try {
			objEM.getTransaction().begin();
			objEM.merge(objClinte);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro alterado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	}

	@DELETE
	@Path("/excluir/{id_cliente}")
	public Response excluir(@PathParam("id_cliente") int id_cliente){      
		try {    
			ClienteModel objClinte = objEM.find(ClienteModel.class, id_cliente);

			objEM.getTransaction().begin();
			objEM.remove(objClinte);
			objEM.getTransaction().commit();
			objEM.close();

			return Response.status(200).entity("cadastro excluído.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}*/
}
