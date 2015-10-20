package edu.luc.lakezon.service.product;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.product.*;

@WebService
public interface ProductOwnerService {

	public Set<ProductOwnerRepresentation> getProductOwners();
	public ProductOwnerRepresentation getProductOwner(Integer id);
	public ProductOwnerRepresentation createProductOwner(ProductOwnerRequest ProductOwnerRequest);
	public Response deleteProductOwner(Integer employeeId);
}
