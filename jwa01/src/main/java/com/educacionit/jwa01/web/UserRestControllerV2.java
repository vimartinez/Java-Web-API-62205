package com.educacionit.jwa01.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.educacionit.jwa01.model.User;
import com.educacionit.jwa01.service.UserService;

@Path("/V2/users")
public class UserRestControllerV2 {
	
	UserService userService = new UserService();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") Long id) {
		
		User usuarioObtenido = userService.getUserById(id);
		if(usuarioObtenido != null) {
			return Response
					.status(Response.Status.OK)
					.entity(usuarioObtenido)
					.type(MediaType.APPLICATION_JSON)
					.build();
		} else {
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity("{\"mensaje\":\"No se encontró el usuario: "+id+"\"}")
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		if(userService.addUser(user)) {
			return Response
					.status(Response.Status.CREATED)
					.entity("{\"mensaje\":\"Se generó el usuario correctamente. \"}")
					.type(MediaType.APPLICATION_JSON)
					.build();
		} else {
			return Response
					.status(Response.Status.CONFLICT)
					.entity("{\"mensaje\":\"No se pudo generar el usuario. \"}")
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		
	}

}
