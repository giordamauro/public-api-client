package com.apigee;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/v1/organizations/{organization}")
public interface ConfigurationManagamentAPI {

	// TODO NOT done yet -> test
	@POST
	@Path("/apis")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces(MediaType.APPLICATION_JSON)
	String importApiProxy(@QueryParam("action") String action, @QueryParam("name") String proxyName, @FormParam("payload") InputStream proxyZip);

}
