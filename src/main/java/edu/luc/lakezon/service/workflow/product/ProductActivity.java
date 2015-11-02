package edu.luc.lakezon.service.workflow.product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.service.representation.product.ProductRepresentation;
import edu.luc.lakezon.service.representation.product.ProductRequest;

public class ProductActivity {

	
	private ProductDAO dao = new ProductDAO();
	
	public Set<ProductRepresentation> getProducts() {
		
		Set<Product> products = null;
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		products = dao.getAll();
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
			Product po = (Product)it.next();
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setName(po.getName());
			productRepresentation.setDescription(po.getDescription());
			productRepresentation.setImg(po.getImg());
			productRepresentation.setQuantity(po.getQuantity());
          
          //now add this representation in the list
			productRepresentations.add(productRepresentation);
        }
		return productRepresentations;
		
	}
	
	
	public ProductRepresentation getProduct(Integer id) {
		
		Product po = dao.getById(id);
		ProductRepresentation poRep = new ProductRepresentation();
		poRep.setName(po.getName());
		
		return poRep;
	}
	
	
	public ProductRepresentation createProduct(String name, String description ,Double price, Integer quantity, String img) {
		Product po = new Product();
		po.setName(name);
		po.setDescription(description);
		po.setPrice(price);
		po.setQuantity(quantity);
		dao.save(po);
		ProductRepresentation poRep = new ProductRepresentation();
		poRep.setName(po.getName());
		poRep.setImg(po.getImg());
		poRep.setQuantity(po.getQuantity());
		return poRep;
	}
	
	
	public ProductRepresentation updateProduct(Integer id , ProductRequest productRequest) {
		
		Product po = new Product();
		po = dao.getById(id);
		po.setName(productRequest.getName());
		dao.update(po);
		ProductRepresentation poRep = new ProductRepresentation();
		poRep.setName(po.getName());
		poRep.setDescription(po.getDescription());
		poRep.setImg(po.getImg());
		poRep.setQuantity(po.getQuantity());
		return poRep;
	}
	
	public Response deleteProduct(Product po) {
		dao.delete(po);
		return Response.status(Status.OK).build();
	}
	
}
