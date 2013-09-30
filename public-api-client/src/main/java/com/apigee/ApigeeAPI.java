package com.apigee;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.apigee.model.AccessToken;
import com.apigee.model.ApiProduct;
import com.apigee.model.ApiProxy;
import com.apigee.model.ApiRevision;
import com.apigee.model.Credential;
import com.apigee.model.Developer;
import com.apigee.model.DeveloperApp;

@Path("/v1/organizations/{organization}")
public interface ApigeeAPI {

	@GET
	@Path("/apps")
	@Produces(MediaType.APPLICATION_JSON)
	List<String> getApps();

	@GET
	@Path("/apps/{appId}")
	@Produces(MediaType.APPLICATION_JSON)
	DeveloperApp getApp(@PathParam("appId") String name);

	@GET
	@Path("/apiproducts")
	@Produces(MediaType.APPLICATION_JSON)
	List<String> getApiProducts();

	@GET
	@Path("/apiproducts/{apiproduct}")
	@Produces(MediaType.APPLICATION_JSON)
	ApiProduct getApiProduct(@PathParam("apiproduct") String name);

	@GET
	@Path("/developers")
	@Produces(MediaType.APPLICATION_JSON)
	List<String> getDevelopers();

	@GET
	@Path("/developers/{developer}")
	@Produces(MediaType.APPLICATION_JSON)
	Developer getDeveloper(@PathParam("developer") String name);

	@GET
	@Path("/developers/{developer}/apps/{app}")
	@Produces(MediaType.APPLICATION_JSON)
	DeveloperApp getDeveloperApp(@PathParam("developer") String developer, @PathParam("app") String app);

	@GET
	@Path("/developers/{developer}/apps/{app}/keys/{key}")
	@Produces(MediaType.APPLICATION_JSON)
	Credential getDeveloperAppKey(@PathParam("developer") String developer, @PathParam("app") String app, @PathParam("key") String key);

	@GET
	@Path("/apis")
	@Produces(MediaType.APPLICATION_JSON)
	List<String> getApiProxies();

	@GET
	@Path("/apis/{api}")
	@Produces(MediaType.APPLICATION_JSON)
	ApiRevision getApiRevisions(@PathParam("api") String api);

	@GET
	@Path("/apis/{api}/revisions/{revision}")
	@Produces(MediaType.APPLICATION_JSON)
	ApiProxy getApiProxyRevision(@PathParam("api") String api, @PathParam("revision") int revision);

	@GET
	@Path("/apis/{api}/revisions/{revision}/deployments")
	String getApiRevisionDeployments(@PathParam("api") String api, @PathParam("revision") int revision);

	@POST
	@Path("/apis/{api}/revisions/{revision}/deployments")
	String deployApiProxyRevision(@PathParam("api") String api, @PathParam("revision") int revision, @QueryParam("action") String action, @QueryParam("env") String environment);

	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	InputStream getApiBundle(@PathParam("api") String api, @PathParam("revision") int revision, @QueryParam("format") String format);

	@POST
	@Path("/developers/{developer}/apps/{app}/keys/{consumerKey}")
	@Produces(MediaType.APPLICATION_JSON)
	String editDeveloperAppKey(@PathParam("developer") String developer, @PathParam("app") String app, @PathParam("consumerKey") String consumerKey, @QueryParam("action") String action);

	@GET
	@Path("/oauth2/accesstokens/{access_token}")
	@Produces(MediaType.APPLICATION_JSON)
	AccessToken getAccessToken(@PathParam("access_token") String accessToken);

	// TODO NOT done yet -> test
	@POST
	@Path("/apis")
	@Consumes(MediaType.APPLICATION_OCTET_STREAM)
	@Produces(MediaType.APPLICATION_JSON)
	String importApiProxy(@QueryParam("action") String action, @QueryParam("name") String proxyName, @FormParam("payload") InputStream proxyZip);

}
