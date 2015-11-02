package edu.luc.lakezon.service.product;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.product.ProductRepresentation;
import edu.luc.lakezon.service.representation.product.ProductRequest;
import edu.luc.lakezon.service.workflow.product.ProductActivity;



@Path("/product")
public class ProductResource implements ProductService {

	@GET
	@Produces({"application/xml" , "application/json"})
	public Set<ProductRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all products .............");
		ProductActivity prodActivity = new ProductActivity();
		return prodActivity.getProducts();	
	}


	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("{productId}")
	@Override
	public ProductRepresentation getProduct(@PathParam("productId") Integer id) {
		System.out.println("GET METHOD Request from product with productRequest String ............." + id);
		ProductActivity prodActivity = new ProductActivity();
		return prodActivity.getProduct(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Override
	public ProductRepresentation createProduct(ProductRequest pr) {
		ProductActivity prodActivity = new ProductActivity();
		return prodActivity.createProduct(pr.getName(),pr.getDescription(),pr.getPrice(),
				pr.getQuantity(),pr.getImg());
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
		System.out.println("DELETE METHOD Request from Product  ............." );
		ProductActivity poActivity = new ProductActivity();
		return deleteProduct(poActivity.getProduct(id).getId());
	}
}
