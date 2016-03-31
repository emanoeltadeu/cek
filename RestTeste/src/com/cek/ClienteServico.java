package com.cek;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/clientes") 
public class ClienteServico { 
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8") 
	public String selectAll() { 
		String clientes = "{'nome': 'Cliente 1','endereco': 'Rua do Cliente 1','RG':3030030066}," + 
				"{'nome': 'Cliente 2','endereco': 'Rua do Cliente 2','RG':1010010011}"; 

		return clientes; 
	} 
}