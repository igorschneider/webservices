package edu.luc.lakezon.service.product;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.product.*;

@WebService
public interface ProductOwnerService {

	public Set<ProductOwnerRepresentation> getProductOwners();
	public ProductOwnerRepresentation getProductOwner(Integer id);
	public ProductOwnerRepresentation createProductOwner(ProductOwnerRequest productOwnerRequest);
	public ProductOwnerRepresentation updateProductOwner(Integer prodOwnerid, ProductOwnerRequest productOwnerRequest);
	public Response deleteProductOwner(Integer prodOwnerid);
	public Response authenticateProductOwner(ProductOwnerRequest productOwnerRequest);
	
}
