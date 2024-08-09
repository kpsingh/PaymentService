package com.lld4.paymentservice.paymentgateways;

import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class RazorPayXPayOut {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        // Replace with your RazorpayX API key
        String apiKey = "rzp_test_EX3VKYvbIU2HEp";

        // Replace with your payout details
        String accountNumber = "12314";
        String accountHolderName = "Krishna";
        String ifscCode = "HDFC007715486";
        int amount = 10000; // Amount in paise

        JSONObject requestBody = new JSONObject();
        requestBody.put("account_number", accountNumber);
        requestBody.put("account_holder_name", accountHolderName);
        requestBody.put("ifsc", ifscCode);
        requestBody.put("amount", amount);

        RequestBody body = RequestBody.create(mediaType, requestBody.toString());

        Request request = new Request.Builder()
                .url("https://api.razorpay.com/v1/payouts")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic " + apiKey)
                .build();

        Response response = client.newCall(request).execute();

        String responseBody = response.body().string();
        System.out.println(responseBody);
    }
}
