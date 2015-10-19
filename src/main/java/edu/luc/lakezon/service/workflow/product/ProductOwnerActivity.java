package edu.luc.lakezon.service.workflow.product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	
	
	public ProductOwnerRepresentation createEmployee(ProductOwner po) {
		
		dao.save(po);
		po.getProductOwnerId();
		ProductOwnerDAO poDAO= new ProductOwnerDAO();
		ProductOwnerRepresentation poRep = new ProductOwnerRepresentation();
		poRep.setName(poDAO.getById(po.getProductOwnerId()).getName());
		poRep.setProductsList(poDAO.getById(po.getProductOwnerId()).getProductsList());
		return poRep;
	}
	
	public String deleteProductOwner(ProductOwner po) {
		
		dao.delete(po);
		return "OK";
	}
	
}
