package edu.luc.lakezon.service.workflow.product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.Link;
import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.business.product.ProductOwner;
import edu.luc.lakezon.dao.product.ProductDAO;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.service.representation.product.ProductRepresentation;
import edu.luc.lakezon.service.representation.product.ProductRequest;

public class ProductActivity {

	private ProductDAO productDAO = new ProductDAO();
	private ProductOwnerDAO productOwnerDAO = new ProductOwnerDAO();

	public Set<ProductRepresentation> getProducts(String name, String productOwnerId) {
		
		Set<Product> products = null;
		Set<ProductRepresentation> productRepresentations = 
				new HashSet<ProductRepresentation>();
		
		if (!(name.equals(""))) {
			products = productDAO.getAllByString(name);
		} else {
			products = productDAO.getAllById(Integer.parseInt(productOwnerId));
		}
		
		Iterator<Product> it = products.iterator();

		while(it.hasNext()) {
			Product pd = (Product)it.next();
			ProductRepresentation productRepresentation = new ProductRepresentation();

			productRepresentation.setName(pd.getName());
			productRepresentation.setDescription(pd.getDescription());
			productRepresentation.setImg(pd.getImg());
			productRepresentation.setPrice(pd.getPrice());
			productRepresentation.setProductOwnerName(pd.getProductOwner().getName());
			
			Link self = new Link("self", "product/" + pd.getProductId());
			Link viewProductOwner = new Link("viewProductOwner", "productowner/" + pd.getProductOwner().getProductOwnerId());
			
			productRepresentation.setLinks(self, viewProductOwner);
          
			productRepresentations.add(productRepresentation);
        }
		
		return productRepresentations;
	}
	
	public ProductRepresentation getProduct(Integer id) {
		
		Product pd = productDAO.getById(id);
		ProductRepresentation productRepresentation = new ProductRepresentation();

		productRepresentation.setName(pd.getName());
		productRepresentation.setDescription(pd.getDescription());
		productRepresentation.setImg(pd.getImg());
		productRepresentation.setQuantity(pd.getQuantity());
		productRepresentation.setPrice(pd.getPrice());
		productRepresentation.setProductOwnerName(pd.getProductOwner().getName());

		Link viewProductOwner = new Link("viewProductOwner", "productowner/" + pd.getProductOwner().getProductOwnerId());
		Link viewReviews = new Link("viewReviews", "product/" + pd.getProductId() + "/review");
		Link addToCart = new Link("addToCart", "customer/302/order/131/product/" + pd.getProductId());

		productRepresentation.setLinks(viewProductOwner, viewReviews, addToCart);;

		return productRepresentation;
	}
	
	
	public ProductRepresentation createProduct(ProductRequest prodresq) {
		Product prod = new Product();
		ProductOwner po = new ProductOwner();
	
		po = productOwnerDAO.getById(prodresq.getProductOwnerId());

		prod.setName(prodresq.getName());
		prod.setImg(prodresq.getImg());
		prod.setDescription(prodresq.getDescription());
		prod.setPrice(prodresq.getPrice());
		prod.setQuantity(prodresq.getQuantity());
		prod.setProductOwner(po);

		productDAO.save(prod);

		ProductRepresentation pdRep = new ProductRepresentation();
		pdRep.setName(prod.getName());
		pdRep.setDescription(prod.getDescription());
		pdRep.setImg(prod.getImg());
		pdRep.setQuantity(prod.getQuantity());
		pdRep.setPrice(prod.getPrice());

		return pdRep;
	}
	
	
	public ProductRepresentation updateProduct(Integer id , ProductRequest productRequest) {
		Product pd = new Product();
		ProductOwner po = new ProductOwner();
		
		po = productOwnerDAO.getById(productRequest.getProductOwnerId());
		pd = productDAO.getById(id);

		pd.setName(productRequest.getName());
		pd.setDescription(productRequest.getDescription());
		pd.setImg(productRequest.getImg());
		pd.setPrice(productRequest.getPrice());
		pd.setQuantity(productRequest.getQuantity());
		pd.setProductOwner(po);

		productDAO.update(pd);

		ProductRepresentation poRep = new ProductRepresentation();

		poRep.setName(pd.getName());
		poRep.setDescription(pd.getDescription());
		poRep.setImg(pd.getImg());
		poRep.setQuantity(pd.getQuantity());
		poRep.setPrice(pd.getPrice());

		return poRep;
	}
	
	public Response deleteProduct(Integer id) {
		Product pd = productDAO.getById(id);

		productDAO.delete(pd);

		return Response.status(Status.OK).build();
	}
	
}
