package com.educacionit.jwa01.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/V1/users")
public class UserRestController {
	
	@GET
	@Path("/{id}")
	public String getUserById(@PathParam("id") Long id) {
		
		return "el id del usuario enviado es:" + id;
		
	}

}
