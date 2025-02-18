package org.siddarth.javabrains.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//@Path("test")
@Path("{pathParam}/test")
@Singleton
public class MyResource {

	/**
	 * If we have @PathParam and @QueryParam at instance level, it can be used by
	 * all the methods present in the class. If we use this as method parameters, it
	 * will be restricted only to that specific methods.
	 */
	@PathParam("pathParam")
	private String pathParamExample;
	@QueryParam("query")
	private String queryParamExample;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "It works!!!\n" + "Path Param - " + pathParamExample + "\nQuery Param - " + queryParamExample;
	}
}
