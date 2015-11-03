package edu.luc.lakezon.service.order;

import javax.jws.WebService;

import com.braintreegateway.Result;
import com.braintreegateway.Transaction;

import edu.luc.lakezon.service.representation.order.PaymentRequest;

@WebService
public interface PaymentService {
	
	public String getToken();
	public Result<Transaction> createTransaction(PaymentRequest paymentRequest);

}
