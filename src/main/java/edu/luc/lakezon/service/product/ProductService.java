package edu.luc.lakezon.service.product;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.product.ProductRepresentation;
import edu.luc.lakezon.service.representation.product.ProductRequest;

@WebService
public interface ProductService {

	public Set<ProductRepresentation> getProducts(String name);
	public ProductRepresentation getProduct(Integer id);
	public ProductRepresentation createProduct(ProductRequest prodRequest);
	public ProductRepresentation updateProduct(Integer prodId, ProductRequest prodRequest);
	public Response deleteProduct(Integer prodId);
	
}