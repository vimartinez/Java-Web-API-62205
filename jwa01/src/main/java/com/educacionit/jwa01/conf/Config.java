package com.educacionit.jwa01.conf;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/JWA")
public class Config extends ResourceConfig{
	
	public Config() {
		packages("com.educacionit.jwa01.web");
	}

}
