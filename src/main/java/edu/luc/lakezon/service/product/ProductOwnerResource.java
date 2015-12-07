package edu.luc.lakezon.service.product;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import javax.ws.rs.core.CacheControl;


import edu.luc.lakezon.service.representation.product.ProductOwnerRepresentation;
import edu.luc.lakezon.service.representation.product.ProductOwnerRequest;
import edu.luc.lakezon.service.workflow.customer.CustomerActivity;
import edu.luc.lakezon.service.workflow.product.ProductOwnerActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/productowner")
public class ProductOwnerResource implements ProductOwnerService {

	@GET
	@Produces({"application/xml" , "application/json"})
	public Set<ProductOwnerRepresentation> getProductOwners() {
		System.out.println("GET METHOD Request for all productOwners .............");
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.getProductOwners();	
	}


	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("{productownerId}")
	@Override
	public ProductOwnerRepresentation getProductOwner(@PathParam("productownerId") Integer id) {
		System.out.println("GET METHOD Request from Client with productOwnerRequest String ............." + id);
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.getProductOwner(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Override
	public ProductOwnerRepresentation createProductOwner(ProductOwnerRequest ProductOwnerRequest) {
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.createProductOwner(ProductOwnerRequest.getName());
	}


	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("{productownerId}")
	@Override
	public ProductOwnerRepresentation updateProductOwner(@PathParam("productownerId") Integer id , ProductOwnerRequest productOwnerRequest) {
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.updateProductOwner(id ,productOwnerRequest);
	}

	
	@DELETE
	@Path("{productownerId}")
	@Override
	public Response deleteProductOwner(@PathParam("productownerId") Integer id) {
		System.out.println("DELETE METHOD Request from product owner  ............." );
		ProductOwnerActivity poActivity = new ProductOwnerActivity();
		return poActivity.deleteProductOwner(id);
	}
	
}
