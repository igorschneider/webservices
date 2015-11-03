package edu.luc.lakezon.service.workflow.order;

import java.math.BigDecimal;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

import edu.luc.lakezon.service.representation.order.PaymentRequest;

public class PaymentActivity {

	private static BraintreeGateway gateway = new BraintreeGateway(
			Environment.SANDBOX,
		    "qhjpszdcwsny64xf",
		    "v3j9dv9bsjrznmzs",
		    "1c3421acfc2599e71691dd946ba19cba"
		);
	
	public String createToken() {
		return gateway.clientToken().generate();
	}
	
	public Result<Transaction> createTransaction(PaymentRequest paymentRequest) {
		
		TransactionRequest request = new TransactionRequest()
				.merchantAccountId(paymentRequest.getMerchantId())
				.amount(new BigDecimal(paymentRequest.getValue()))
				.paymentMethodNonce(paymentRequest.getNonce())
				.serviceFeeAmount(new BigDecimal("1.50"));

		Result<Transaction> result = gateway.transaction().sale(request);
		
		return result;
	}
	
}
