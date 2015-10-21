package edu.luc.lakezon.service.product;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.CacheControl;


import edu.luc.lakezon.service.representation.product.ProductOwnerRepresentation;
import edu.luc.lakezon.service.representation.product.ProductOwnerRequest;
import edu.luc.lakezon.service.workflow.product.ProductOwnerActivity;


@Path("/productownerservice/")
public class ProductOwnerResource implements ProductOwnerService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/productowner")
	public Set<ProductOwnerRepresentation> getProductOwners() {
		System.out.println("GET METHOD Request for all productOwners .............");
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.getProductOwners();	
	}


	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/productowner/{productownerId}")
	@Override
	public ProductOwnerRepresentation getProductOwner(@PathParam("productownerId") Integer id) {
		System.out.println("GET METHOD Request from Client with productOwnerRequest String ............." + id);
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.getProductOwner(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/productOwner")
	@Override
	public ProductOwnerRepresentation createProductOwner(ProductOwnerRequest ProductOwnerRequest) {
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.createProductOwner(ProductOwnerRequest.getName());
	}


	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/productowner")
	@Override
	public Response deleteProductOwner(@PathParam("productownerId") Integer id) {
		System.out.println("DELETE METHOD Request from Client  ............." );
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return deleteProductOwner(poActivity.getProductOwner(id).getProductOwnerId());
	}


	@Override
	public ProductOwnerRepresentation updateProductOwner(@PathParam("productownerId") Integer id , ProductOwnerRequest productOwnerRequest) {
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.updateProductOwner(id ,productOwnerRequest);
	}

}
