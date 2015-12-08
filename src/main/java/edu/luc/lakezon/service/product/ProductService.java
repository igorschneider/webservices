package edu.luc.lakezon.service.product;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.product.ProductRepresentation;
import edu.luc.lakezon.service.representation.product.ProductRequest;

@WebService
public interface ProductService {

	public Set<ProductRepresentation> getProducts(String name, String productOwnerId);
	public ProductRepresentation getProduct(Integer id);
	public ProductRepresentation createProduct(String productOwnerId, ProductRequest prodRequest);
	public ProductRepresentation updateProduct(Integer prodId, ProductRequest prodRequest);
	public Response deleteProduct(Integer prodId);
	
}