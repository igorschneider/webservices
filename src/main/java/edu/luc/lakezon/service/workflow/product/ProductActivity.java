package edu.luc.lakezon.service.workflow.product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.business.product.ProductOwner;
import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.service.representation.product.ProductRepresentation;
import edu.luc.lakezon.service.representation.product.ProductRequest;

public class ProductActivity {

	
	private ProductDAO dao = new ProductDAO();
	private ProductOwnerDAO podao = new ProductOwnerDAO();
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
			productRepresentation.setPrice(po.getPrice());
          
          //now add this representation in the list
			productRepresentations.add(productRepresentation);
        }
		return productRepresentations;
		
	}
	
	
	public ProductRepresentation getProduct(Integer id) {
		
		Product po = dao.getById(id);
		ProductRepresentation productRepresentation = new ProductRepresentation();
		productRepresentation.setName(po.getName());
		productRepresentation.setDescription(po.getDescription());
		productRepresentation.setImg(po.getImg());
		productRepresentation.setQuantity(po.getQuantity());
		productRepresentation.setPrice(po.getPrice());
		
		return productRepresentation;
	}
	
	
	public ProductRepresentation createProduct(ProductRequest prodresq) {
		Product prod = new Product();
		ProductOwner po = new ProductOwner();
		po = podao.getById(prodresq.getProductOwnerId());
		prod.setName(prodresq.getName());
		prod.setDescription(prodresq.getDescription());
		prod.setPrice(prodresq.getPrice());
		prod.setQuantity(prodresq.getQuantity());
		prod.setProductOwner(po);
		dao.save(prod);
		ProductRepresentation pdRep = new ProductRepresentation();
		pdRep.setName(prod.getName());
		pdRep.setImg(prod.getImg());
		pdRep.setQuantity(prod.getQuantity());
		return pdRep;
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
	
	public Response deleteProduct(Integer id) {
		Product po = dao.getById(id);
		dao.delete(po);
		return Response.status(Status.OK).build();
	}
	
}
