package com.lld4.paymentservice.paymentgateways;

import com.razorpay.PaymentLink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@Component
@Primary
public class RazorPayPaymentGateway implements PaymentGateway {

    private RazorpayClient razorpay;

    public RazorPayPaymentGateway(RazorpayClient razorpay) {
        this.razorpay = razorpay;
    }

    @Override
    public String createPaymentLink(Long orderId) {
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", 1000);
        paymentLinkRequest.put("currency", "INR");
        //paymentLinkRequest.put("accept_partial", true);
        // paymentLinkRequest.put("first_min_partial_amount", 100);
        paymentLinkRequest.put("expire_by", 1754570598); // epoch time
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description", "Payment for order id : " + orderId);
        JSONObject customer = new JSONObject();
        customer.put("name", "+917458785548");
        customer.put("contact", "Krishna Singh");
        customer.put("email", "krishna@gmail.com");
        paymentLinkRequest.put("customer", customer);
        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable", true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name", "Stocks");
        paymentLinkRequest.put("notes", notes);
        paymentLinkRequest.put("callback_url", "https://www.scaler.com/academy/mentee-dashboard/todos");
        paymentLinkRequest.put("callback_method", "get");

        try {
            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
            return payment.toString();

        } catch (RazorpayException ex) {
            throw new RuntimeException(ex);
        }
    }
}
