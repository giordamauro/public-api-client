package com.apigee;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.apigee.model.ApiProduct;
import com.apigee.model.configurationmanagement.EnvironmentDeployments;

@Path("/v1/organizations/{organization}")
public interface ConfigurationManagementAPI {

	// TODO NOT done yet -> test
	@POST
	@Path("/apis")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces(MediaType.APPLICATION_JSON)
	String importApiProxy(@QueryParam("action") String action, @QueryParam("name") String proxyName, @FormParam("payload") InputStream proxyZip);

	@GET
	@Path("/environments/{environment}/deployments")
	@Produces(MediaType.APPLICATION_JSON)
	EnvironmentDeployments getEnvironmentDeployments(@PathParam("environment") String environment);

	@POST
	@Path("/apiproducts")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	ApiProduct createApiProduct(ApiProduct apiProduct);

	@GET
	@Path("/apiproducts")
	@Produces(MediaType.APPLICATION_JSON)
	List<String> getApiProducts();

	@GET
	@Path("/apiproducts/{apiproduct}")
	@Produces(MediaType.APPLICATION_JSON)
	ApiProduct getApiProduct(@PathParam("apiproduct") String name);

	@PUT
	@Path("/apiproducts/{apiproduct}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	ApiProduct editApiProduct(ApiProduct apiProduct);

	@DELETE
	@Path("/apiproducts/{apiproduct}")
	@Produces(MediaType.APPLICATION_JSON)
	ApiProduct deleteApiProduct(@PathParam("apiproduct") String name);

	// TODO Agregar enum para los posibles entities y queries
	@GET
	@Path("/apiproducts/{apiproduct}")
	@Produces(MediaType.APPLICATION_JSON)
	String getEntitiesForApiProduct(@PathParam("apiproduct") String name, @QueryParam("query") String queryType, @QueryParam("entity") String entityName);

}
