package edu.luc.lakezon.service.product;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import edu.luc.lakezon.service.representation.product.ProductRepresentation;
import edu.luc.lakezon.service.representation.product.ProductRequest;
import edu.luc.lakezon.service.workflow.product.ProductActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)
@Path("/product")
public class ProductResource implements ProductService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Override
	public Set<ProductRepresentation> getProducts(@DefaultValue("") @QueryParam("name") String name,
			@DefaultValue("") @QueryParam("productOwnerId") String productOwnerId) {
		System.out.println("GET METHOD Request to search for products .......");
		ProductActivity prodActivity = new ProductActivity();
		return prodActivity.getProducts(name, productOwnerId);	
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("{productId}")
	@Override
	public ProductRepresentation getProduct(@PathParam("productId") Integer id) {
		System.out.println("GET METHOD Request from product with ID ........." + id);
		ProductActivity prodActivity = new ProductActivity();
		return prodActivity.getProduct(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Override
	public ProductRepresentation createProduct(
			@DefaultValue("") @QueryParam("productOwnerId") String productOwnerId, 
			ProductRequest pr) {
		ProductActivity prodActivity = new ProductActivity();
		return prodActivity.createProduct(productOwnerId, pr);
	}


	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("{productId}")
	@Override
	public ProductRepresentation updateProduct(@PathParam("productId") Integer id , ProductRequest productRequest) {
		ProductActivity prodActivity = new ProductActivity();
		return prodActivity.updateProduct(id ,productRequest);
	}

	
	@DELETE
	@Path("{productId}")
	@Override
	public Response deleteProduct(@PathParam("productId") Integer id) {
		try {
			System.out.println("DELETE METHOD Request from Product  ............." );
			ProductActivity poActivity = new ProductActivity();
			return poActivity.deleteProduct(id);
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}
