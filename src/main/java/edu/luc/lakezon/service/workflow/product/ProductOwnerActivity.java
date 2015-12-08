package edu.luc.lakezon.service.workflow.product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.Link;
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
			productOwnerRepresentation.setPassword(po.getPassword());
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
		
		Link updateProductOwner = new Link("updateProductOwner", "productowner/" + id);

		poRep.setLinks(updateProductOwner);
		
		return poRep;
	}
	
	
	public ProductOwnerRepresentation createProductOwner(ProductOwnerRequest productOwnerRequest) {

		ProductOwner po = new ProductOwner();

		po.setName(productOwnerRequest.getName());
		po.setPassword(productOwnerRequest.getPassword());

		dao.save(po);

		ProductOwnerRepresentation poRep = new ProductOwnerRepresentation();

		poRep.setName(po.getName());

		Link self = new Link("self", "productowner/" + po.getProductOwnerId());
		Link viewProducts = new Link("viewProducts", "product?productowner=" + 
				po.getProductOwnerId());
		Link addProduct = new Link("addProduct", "product?productowner=" + 
				po.getProductOwnerId());
		Link viewOrders = new Link("viewOrders", "order?productowner=" + 
				po.getProductOwnerId());
		
		poRep.setLinks(self, viewProducts, addProduct, viewOrders);

		return poRep;
	}
	
	
	public ProductOwnerRepresentation updateProductOwner(Integer id , ProductOwnerRequest productOwnerRequest) {
		
		ProductOwner po = new ProductOwner();
		po = dao.getById(id);
		po.setName(productOwnerRequest.getName());
		po.setPassword(productOwnerRequest.getPassword());
		dao.update(po);
		ProductOwnerRepresentation poRep = new ProductOwnerRepresentation();
		poRep.setName(po.getName());
		poRep.setPassword(po.getPassword());
		poRep.setProductOwnerId(po.getProductOwnerId());
		return poRep;
	}
	
	public Response deleteProductOwner(Integer id) {
		
		ProductOwner po = dao.getById(id);
		dao.delete(po);
		return Response.status(Status.OK).build();
	}
	
	public Response authenticateProductOwner(ProductOwnerRequest productOwnerRequest) {
		
		Set<ProductOwner> productOwners = dao.getAllByString(productOwnerRequest.getName());

		Iterator<ProductOwner> it = productOwners.iterator();
		
		while (it.hasNext()) {

			ProductOwner productOwner = (ProductOwner)it.next();
			
			if (productOwner.getPassword().equals(productOwnerRequest.getPassword())) {

				ProductOwnerRepresentation poRep = new ProductOwnerRepresentation();
				poRep.setName(productOwner.getName());

				Link self = new Link("self", "productowner/" + productOwner.getProductOwnerId());
				Link viewProducts = new Link("viewProducts", "product?productowner=" + 
						productOwner.getProductOwnerId());
				Link addProduct = new Link("addProduct", "product");
				Link viewOrders = new Link("viewOrders", "order?productowner=" + 
						productOwner.getProductOwnerId());
				
				poRep.setLinks(self, viewProducts, addProduct, viewOrders);
				
				return Response.ok(poRep).build();
			}

		}
		
		return Response.status(Status.UNAUTHORIZED).build();

	}
	
}
