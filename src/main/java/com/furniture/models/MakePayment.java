//package com.furniture.models;
//
//import com.furniture.entities.Products;
//import java.util.List;
//import javax.servlet.http.HttpSession;
//import zw.co.paynow.core.Payment;
//import zw.co.paynow.core.Paynow;
//import zw.co.paynow.responses.StatusResponse;
//import zw.co.paynow.responses.WebInitResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import org.springframework.http.HttpRequest;
//
//public class MakePayment{
//
//
// HttpSession session1 = request.getSession(false);
//   session1.getAttribute("cart");
//   List<Products> cart = (List<Products>) session1.getAttribute("cart");
//   
//   String INTEGRATION_ID="3303";
//   String INTEGRATION_KEY="1747d3b9-27ad-4ae3-ba1c-13557544b62f";
//   
//    Paynow paynow = new Paynow(INTEGRATION_ID, INTEGRATION_KEY);
//
//        Payment payment = paynow.createPayment("Invoice 35");
//
//        // Passing in the name of the item and the price of the item
//        payment.add("Bananas", 2.5);
//        payment.add("Apples", 3.4);
//        
//
//        //Initiating the transaction
//        WebInitResponse response = paynow.send(payment);
//        
//        //If a mobile transaction,
//        //MobileInitResponse response = paynow.sendMobile(payment, "0771234567", MobileMoneyMethod.ECOCASH);
//
//        if (response.isRequestSuccess()) {
//            // Get the url to redirect the user to so they can make payment
//            String redirectURL = response.redirectURL();
//
//            // Get the poll url of the transaction
//            String pollUrl = response.pollUrl();
//
//            //checking if the payment has been paid
//            StatusResponse status = paynow.pollTransaction(pollUrl);
//
//            if (status.paid()) {
//                // Yay! Transaction was paid for
//            } else {
//                System.out.println("Why you no pay?");
//            }
//
//        } else {
//            // Something went wrong
//            System.out.println(response.errors());
//        }
//        
//        
//
//}