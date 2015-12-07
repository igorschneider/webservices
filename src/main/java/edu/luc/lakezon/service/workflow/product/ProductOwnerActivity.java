package edu.luc.lakezon.service.workflow.product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.product.ProductOwner;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.service.representation.product.ProductOwnerRepresentation;
import edu.luc.lakezon.service.representation.product.ProductOwnerRequest;

public class ProductOwnerActivity {

	
	private ProductOwnerDAO dao = new ProductOwnerDAO();
	
	public Set<ProductOwnerRepresentation> getProductOwners() {
		
		Set<ProductOwner> productOwners = null;
		Set<ProductOwnerRepresentation> productOwnerRepresentations = new HashSet<ProductOwnerRepresentation>();
		productOwners = dao.getAll();
		
		Iterator<ProductOwner> it = productOwners.iterator();
		while(it.hasNext()) {
			ProductOwner po = (ProductOwner)it.next();
			ProductOwnerRepresentation productOwnerRepresentation = new ProductOwnerRepresentation();
			productOwnerRepresentation.setName(po.getName());
			productOwnerRepresentation.setProductOwnerId(po.getProductOwnerId());
          
          //now add this representation in the list
			productOwnerRepresentations.add(productOwnerRepresentation);
        }
		return productOwnerRepresentations;
		
	}
	
	
	public ProductOwnerRepresentation getProductOwner(Integer id) {
		
		ProductOwner po = dao.getById(id);
		
		ProductOwnerRepresentation poRep = new ProductOwnerRepresentation();
		poRep.setName(po.getName());
		
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
	
	
	public ProductOwnerRepresentation updateProductOwner(Integer id , ProductOwnerRequest productOwnerRequest) {
		
		ProductOwner po = new ProductOwner();
		po = dao.getById(id);
		po.setName(productOwnerRequest.getName());
		dao.update(po);
		ProductOwnerRepresentation poRep = new ProductOwnerRepresentation();
		poRep.setName(po.getName());
		poRep.setProductOwnerId(po.getProductOwnerId());
		return poRep;
	}
	
	public Response deleteProductOwner(Integer id) {
		
		ProductOwner po = dao.getById(id);
		dao.delete(po);
		return Response.status(Status.OK).build();
	}
	
}
