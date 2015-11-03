package edu.luc.lakezon.service.order;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.braintreegateway.Result;
import com.braintreegateway.Transaction;

import edu.luc.lakezon.service.representation.order.PaymentRequest;
import edu.luc.lakezon.service.workflow.order.PaymentActivity;

@Path("/payment")
public class PaymentResource implements PaymentService {

	@GET
	@Path("/token")
	@Override
	public String getToken() {
		PaymentActivity paymentActivity = new PaymentActivity();
		return paymentActivity.createToken();
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/transaction")
	@Override
	public Result<Transaction> createTransaction(PaymentRequest paymentRequest) {
		PaymentActivity paymentActivity = new PaymentActivity();
		return paymentActivity.createTransaction(paymentRequest);
	}

}
