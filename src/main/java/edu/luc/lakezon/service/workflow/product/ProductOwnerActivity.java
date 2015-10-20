package edu.luc.lakezon.service.workflow.product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import edu.luc.lakezon.business.product.ProductOwner;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.service.representation.product.ProductOwnerRepresentation;

public class ProductOwnerActivity {

	
	private static ProductOwnerDAO dao = new ProductOwnerDAO();
	
	public Set<ProductOwnerRepresentation> getProductOwners() {
		
		Set<ProductOwner> productOwners = new HashSet<ProductOwner>();
		Set<ProductOwnerRepresentation> productOwnerRepresentations = new HashSet<ProductOwnerRepresentation>();
		productOwners = dao.getAll();
		
		Iterator<ProductOwner> it = productOwners.iterator();
		while(it.hasNext()) {
			ProductOwner po = (ProductOwner)it.next();
			ProductOwnerRepresentation productOwnerRepresentation = new ProductOwnerRepresentation();
			productOwnerRepresentation.setName(po.getName());
			productOwnerRepresentation.setProductsList(po.getProductsList());
          
          //now add this representation in the list
			productOwnerRepresentations.add(productOwnerRepresentation);
        }
		return productOwnerRepresentations;
		
	}
	
	
	public ProductOwnerRepresentation getProductOwner(Integer id) {
		
		ProductOwner po = dao.getById(id);
		
		ProductOwnerRepresentation poRep = new ProductOwnerRepresentation();
		poRep.setName(po.getName());
		poRep.setProductsList(po.getProductsList());
		
		return poRep;
	}
	
	
	public ProductOwnerRepresentation createProductOwner(String name) {
		ProductOwner po = new ProductOwner();
		po.setName(name);
		dao.save(po);
		ProductOwnerRepresentation poRep = new ProductOwnerRepresentation();
		poRep.setName(po.getName());
		poRep.setProductOwnerId(po.getProductOwnerId());
		return poRep;
	}
	
	public Response deleteProductOwner(ProductOwner po) {
		dao.delete(po);
		return Response.status(Status.).build();
	}
	
}
