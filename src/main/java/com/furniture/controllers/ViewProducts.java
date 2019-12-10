/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furniture.controllers;

import com.furniture.controllers.exceptions.NonexistentEntityException;
import com.furniture.entities.Products;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.furniture.entities.Users;
import org.springframework.web.servlet.ModelAndView;
import zw.co.paynow.core.Payment;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.StatusResponse;
import zw.co.paynow.responses.WebInitResponse;
import com.furniture.entities.PaymentInfo;
import java.math.BigDecimal;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import org.springframework.web.bind.annotation.ResponseBody;
import com.furniture.entities.PaymentInfo;

//upload imports
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author gugulethu.ngwenya
 */
@Controller
public class ViewProducts {
   

 @RequestMapping(value="/viewProducts", method = RequestMethod.GET)  
 public ModelAndView ViewProducts(ModelAndView model){
        ProductsJpaController pj = new ProductsJpaController();
       
        List<Products> p = pj.selectAll();
        
        model.setViewName("shop.jsp");
        model.addObject( "products",p);
        model.addObject( "sizo",p.size());
        
    return model;
    
    }
 
  @RequestMapping(value="/editProducts", method = RequestMethod.GET)  
 public ModelAndView editProducts(ModelAndView model){
        ProductsJpaController pj = new ProductsJpaController();
       
        List<Products> p = pj.selectAll();
        model.setViewName("itemList.jsp");
        model.addObject( "products",p);
        model.addObject( "sizo",p.size());
        
    return model;
    
    }
 

  @RequestMapping(value="/viewItem", method = RequestMethod.POST)  
 public ModelAndView viewItem(ModelAndView model, HttpServletRequest request,HttpServletResponse response){

    System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    ProductsJpaController pj = new ProductsJpaController();
    System.out.println("id id"+request.getParameter("inputId"));
    int prodId = Integer.parseInt(request.getParameter("inputId"));
    Products prod = pj.findProducts(prodId);
        //pj.destroy(prodId);
       
        model.setViewName("editItem.jsp");
        model.addObject( "item",prod);
        
    return model;
    
    } 

  @RequestMapping(value="/addNew", method = RequestMethod.POST)  
 public ModelAndView addNew(ModelAndView model, HttpServletRequest request,HttpServletResponse response){

    System.out.println("adding item");
    ProductsJpaController pj = new ProductsJpaController();
    Products prod = new Products();
    
    prod.setProductName(request.getParameter("itemName"));
    prod.setPrice(Integer.parseInt(request.getParameter("itemPrice")));
    prod.setDescription(request.getParameter("itemDescr"));
    prod.setQuantity(Integer.parseInt(request.getParameter("itemQuantity")));
    prod.setRate(Float.parseFloat(request.getParameter("Rate")));
    
    pj.insertProduct(prod);
       
    List<Products> p = pj.selectAll();
    model.setViewName("shop_2.jsp");
    model.addObject( "products",p);
    model.addObject( "sizo",p.size());
        
    return model;
    
    } 
 
  @RequestMapping(value="/editItem", method = RequestMethod.POST)  
 public ModelAndView editItem(ModelAndView model, HttpServletRequest request,HttpServletResponse response){

    System.out.println("editing id");
    ProductsJpaController pj = new ProductsJpaController();
    System.out.println("edit id"+request.getParameter("inputId"));
    int prodId = Integer.parseInt(request.getParameter("inputId"));
    Products prod = pj.findProducts(prodId);
      //  pj.destroy(prodId);
       
     //   List<Products> p = pj.selectAll();
        model.setViewName("editItem.jsp");
        model.addObject( "products",prod);
//        model.addObject( "sizo",p.size());
        
    return model;
    
    } 
 
  @RequestMapping(value="/removeItem", method = RequestMethod.POST)  
 public ModelAndView removeItem(ModelAndView model,HttpServletRequest request,HttpServletResponse response) throws NonexistentEntityException{
   System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    ProductsJpaController pj = new ProductsJpaController();
      System.out.println("id id"+request.getParameter("inputId"));
        int prodId = Integer.parseInt(request.getParameter("inputId"));
        pj.destroy(prodId);
        List<Products> p = pj.selectAll();
        model.setViewName("itemList.jsp");
        model.addObject( "products",p);
        model.addObject( "sizo",p.size());
        
    return model;
    }
 
    
   ModelAndView AddProducts(List<Products>products, HttpServletRequest request,ModelAndView model){
       
       
       String [] quantity = request.getParameterValues("quantity");
        String [] name = request.getParameterValues("itemName");
        String [] price = request.getParameterValues("price");
       ProductsJpaController pj = new ProductsJpaController();
       List<Products>p = new ArrayList();
       Products a=new Products();
     //s  a.setPrice("price");
       a.setProductName("itemName");
       a.setQuantity(0);
       pj.create(products);
       
    return model;
    
    }
   
    public int AddTotal(List<Products>products){


        int total=0;
        
        for(Products item: products){
        total+= item.getZwlprice()*item.getQuantity();
        }
        return total;
    }
    
    @RequestMapping(value="/loginUser", method = RequestMethod.POST)          
    public ModelAndView loginUser(HttpServletRequest request,HttpServletResponse response, ModelAndView model){
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    ProductsJpaController pj = new ProductsJpaController();       
    List<Users> p = pj.selectAllUsers();
    
    if(!p.isEmpty()){
        //login success
        model.setViewName("updateRate.jsp");
        
    }
    else
        model.setViewName("failed_login.jsp");
        //failed jsp
    return model;
        
    }
    
    
  ////////
        @RequestMapping(value="/update", method = RequestMethod.POST)          
    public ModelAndView update(HttpServletRequest request,HttpServletResponse response, ModelAndView model){        
      ProductsJpaController pj = new ProductsJpaController();       
      pj.updateRate(Float.parseFloat(request.getParameter("rate")));
      model.setViewName("success.jsp");
      return model;
    }
  ////////
    
    
 @RequestMapping(value="/checkOut", method = RequestMethod.POST)          
    public ModelAndView checkOut(HttpServletRequest request,HttpServletResponse response, ModelAndView model){
        List<Products> cart = new ArrayList<>();
      //  int total= AddTotal(request,response);
        System.out.println("eta from post");
        String[] names = request.getParameterValues("itemName");
        
        String[] quantities = request.getParameterValues("itemQuantity");
        int[] integerQuantities = new int[quantities.length];
        for(int x=0; x< quantities.length; x++){ 
            integerQuantities[x] = Integer.parseInt(quantities[x]);
        
        }
        
        String[] prices = request.getParameterValues("itemPrice");
        int[] integerPrices = new int[prices.length];
        for(int x=0; x< prices.length; x++){ 
            integerPrices[x] = Integer.parseInt(prices[x]);
        
        }
        
        String[] ids = request.getParameterValues("itemId");
        int[] integerIDs = new int[ids.length];
        for(int x=0; x< ids.length; x++){ 
            integerIDs[x] = Integer.parseInt(ids[x]);
        
        }        
        
   for(int x=0; x< names.length; x++){  
   Products prod=new Products();
  //To be set
  //prod.setProductId(productId);
   ProductsJpaController pj=new ProductsJpaController();
   Products a=pj.findProducts(integerIDs[x]);
   prod.setProductId(a.getProductId());
   prod.setDescription(a.getDescription());
   prod.setPrice(a.getPrice());
   prod.setZwlprice(a.getZwlprice());
   prod.setRate(a.getRate());
   prod.setProductName(a.getProductName());
   prod.setQuantity(integerQuantities[x]);
   cart.add(prod);
   }
   
        HttpSession session1 = request.getSession(false);
        System.out.println("GGGGGGGGGG"+session1);
        
        System.out.println("etagg from post"+names[0]);
        System.out.print("nazo"+names);

        return dispatch(cart, session1,model);
    
        
    //return model;
    
    }
    
  @RequestMapping(value="/addToCart", method = RequestMethod.POST) 
  @ResponseBody
   
    public ModelAndView addToCart(ModelAndView model,HttpServletRequest request,HttpServletResponse response){
   // int productn=request.getParameter("itemID");
       int productId=Integer.parseInt(request.getParameter("itemID"));
       int quantity=Integer.parseInt(request.getParameter("quantity"));
    
         HttpSession session1 = request.getSession(false);
         System.out.println("GGGGGGGGGG"+session1);
         List<Products> cart = (List<Products>) session1.getAttribute("cart");

//if cart is empty         
if (cart== null){
   //create product model
   
   List<Products> pa = new ArrayList();
   Products prod=new Products();
   prod.setProductId(productId);
   ProductsJpaController pj=new ProductsJpaController();
   Products a=pj.findProducts(productId);
   prod.setDescription(a.getDescription());
   prod.setZwlprice(a.getZwlprice());
   //prod.setPrice(a.getPrice());
   prod.setProductName(a.getProductName());
   prod.setQuantity(quantity);
   
    pa.add(prod);
    cart=pa;
}else{
   
        
 Products prod=new Products();
   prod.setProductId(productId);
   ProductsJpaController pj=new ProductsJpaController();
   Products a=pj.findProducts(productId);
   prod.setDescription(a.getDescription());
   prod.setZwlprice(a.getZwlprice());

//   prod.setPrice(a.getPrice());
   prod.setProductName(a.getProductName());
   prod.setQuantity(quantity);
   
   //to eliminate duplicates
   int x=0;
   for(Products aa: cart){
   if(aa.getProductId().equals(a.getProductId())){
return dispatch(cart,session1,model);   
   
   }
   else
    x=1;


}

 
   

if(x==1){
cart.add(prod);
}
    


    

    }
return dispatch(cart, session1,model);
    }
   

public ModelAndView dispatch(List<Products> cart, HttpSession session1,ModelAndView model){
int subTotal, delivery, Total;
    subTotal=AddTotal(cart);
    delivery=0;
    Total=delivery+subTotal;
    session1.setAttribute("cart", cart);
    model.setViewName("cart.jsp");
    model.addObject("cart", cart);
    model.addObject("subTotal", subTotal);
    model.addObject("delivery", delivery);
    model.addObject("Total", Total);
        return model;
}



  @RequestMapping(value="/continueShopping", method = RequestMethod.POST) 
  @ResponseBody
public ModelAndView continueShopping(ModelAndView model, HttpServletRequest request,HttpServletResponse response){

       
       String [] quantity = request.getParameterValues("quantity");
        String [] name = request.getParameterValues("itemID");
        String [] price = request.getParameterValues("price");

        
        return model;
}



//Payment information on checkout


@RequestMapping(value="/paymentInfo",method = RequestMethod.POST)

public ModelAndView paymentInfo(ModelAndView model, HttpServletRequest request,HttpServletResponse response) throws MessagingException, ServletException, IOException{
   //should we carry the session here as well
   String name, surname, companyName, email, phonenumber, comment, address;
   HttpSession session1 = request.getSession(false);
   session1.getAttribute("cart");
   PaymentInfoJpaController pic = new PaymentInfoJpaController();
   PaymentInfo p=pic.addInfo(request);
   ViewProducts pp = new ViewProducts();
   pp.makePaymnet(request, response,p.getEmail(), p.getId());
   
   model.setViewName("checkout.jsp");
   return model;
   
   
}
//Intergration with Paynow

//@RequestMapping(value="/integratePayment",method = RequestMethod.POST)
//
//public ModelAndView integratePayment(ModelAndView model, HttpServletRequest request) throws MessagingException{
//   //should we carry the session here as well
//   HttpSession session1 = request.getSession(false);
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
////dispatch website
//
//
// /* Get web application context path, this is the root path for web application in page url,
//
// * it's value is Dev2qaWebAppExample in this example.*/
//
// String contextPath = req.getServletContext().getContextPath();
//
//String targetUrl = "/pages/login/loginSuccess.jsp";
//
// RequestDispatcher rd = req.getRequestDispatcher(targetUrl);
//
// /* Set message value, the loginStatus.jsp will show this message on the web page.*/
//
// req.setAttribute("message", "Your username and password is correct.");
//
// /* Forward to the target jsp page.*/
//
// rd.forward(req, resp); 
//
//
///////////////////////////////
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
//        return model;
//    }


   
   




  @RequestMapping(value="/clearCart", method = RequestMethod.GET) 
  @ResponseBody
   
    public ModelAndView clearCart(ModelAndView model,HttpServletRequest request,HttpServletResponse response){
    
         HttpSession session1 = request.getSession(false);
         session1.invalidate();
         model.setViewName("cart.jsp");
         return model;
    }

    
    @RequestMapping(value="/updateCart",method = RequestMethod.GET)

public ModelAndView updateCart(ModelAndView model,HttpServletRequest request,HttpServletResponse response){
         HttpSession session1 = request.getSession(false);
         System.out.println("GGGGGGGGGG"+session1);
         List<Products> cart = (List<Products>) session1.getAttribute("cart");
 
    int subTotal, delivery, Total;
    subTotal=AddTotal(cart);
    delivery=0;
    Total=delivery+subTotal;
    session1.setAttribute("cart", cart);
    model.setViewName("updateCart.jsp");
    model.addObject("cart", cart);
    model.addObject("subTotal", subTotal);
    model.addObject("delivery", delivery);
    model.addObject("Total", Total);
        return model;
     //  String [] quantity = request.getParameterValues("quantity");
     //    return model;



}


/* public ModelAndView returnPage(ModelAndView model, HttpServletRequest req){
     System.out.println("now in return page ");
     String[] itemIds = req.getParameterValues("itemId");
     

     
        model.setViewName("return_page.jsp");
        
    return model;
    
    }*/





 @RequestMapping(value="/add", method = RequestMethod.POST)  
 public ModelAndView add(ModelAndView model, HttpServletRequest req){
     System.out.println("noe on add");
     String[] itemIds = req.getParameterValues("itemId");
     
     for (String itemId : itemIds) {
         System.out.println("items " + itemId);
     }
     
        model.setViewName("checkout.jsp");
        
    return model;
    
    }


    @RequestMapping(value="/processUpdate",method = RequestMethod.GET)

public ModelAndView processUpdate(ModelAndView model,HttpServletRequest request,HttpServletResponse response){
         HttpSession session1 = request.getSession(false);
         System.out.println("GGGGGGGGGG"+session1);
         List<Products> cart = (List<Products>) session1.getAttribute("cart");
        String [] quantity = request.getParameterValues("quantity");

        for(int i=0; i<cart.size(); i++){
        Products d=cart.get(i);
        d.setQuantity(Integer.parseInt(quantity[i]));
        
        }
        
    int subTotal, delivery, Total;
    subTotal=AddTotal(cart);
    delivery=0;
    Total=delivery+subTotal;
    session1.setAttribute("cart", cart);
    model.setViewName("cart.jsp");
    model.addObject("cart", cart);
    model.addObject("subTotal", subTotal);
    model.addObject("delivery", delivery);
    model.addObject("Total", Total);
        return model;
     //  String [] quantity = request.getParameterValues("quantity");
     //    return model;



}        
  

        String INTEGRATION_ID="8362";
    String INTEGRATION_KEY="617b8c55-9ec9-4e58-ad3e-a0702612f52d";
   
    Paynow paynow = new Paynow(INTEGRATION_ID, INTEGRATION_KEY);
    String pollUrl= new String();
    String aa = new String();
    HttpSession session = null;
//save message in session

public ModelAndView makePaymnet (HttpServletRequest request, HttpServletResponse response1, String email,int id) throws ServletException, IOException{
ModelAndView model = new ModelAndView();
HttpSession session1 = request.getSession(false);
   session1.getAttribute("cart");
   List<Products> cart = (List<Products>) session1.getAttribute("cart");
   
 /*  String INTEGRATION_ID="8106";
   String INTEGRATION_KEY="aa22a573-95ff-4c04-a277-4e3895161203";*/



        Payment payment = paynow.createPayment("Invoice 35",email);
        paynow.setResultUrl("http://localhost:8084/onlineShop/returnPage?id="+id); //post on merchant website
        paynow.setReturnUrl("http://localhost:8084/onlineShop/returnPage?id="+id); //result page for customer

        // Passing in the name of the item and the price of the item
        for(Products item: cart){
            
        double itemTotalPrice=item.getZwlprice()*item.getQuantity();
        payment.add(item.getProductName(), itemTotalPrice);
      //  payment
        }
        WebInitResponse response = null;
        
        //Initiating the transaction
        try{
        response = paynow.send(payment);
        
        System.out.println("response is: "+response.isRequestSuccess());
        //If a mobile transaction,
        //MobileInitResponse response = paynow.sendMobile(payment, "0771234567", MobileMoneyMethod.ECOCASH);

//save message in session
        
        
        
        
        if (response.isRequestSuccess()) {
            // Get the url to redirect the user to so they can make payment
            String redirectURL = response.redirectURL();
System.out.println("redirectURL is: "+response.redirectURL());

            // Get the poll url of the transaction
            pollUrl = response.pollUrl();  

System.out.println("pollUrl is: "+response.pollUrl());

// find by id and update pollurll
  PaymentInfoJpaController abc = new PaymentInfoJpaController();
PaymentInfo prod =  abc.findPaymentInfo(id);
prod.setPollurl(pollUrl);
abc.edit(prod);
            
            //////////
           String targetURL = redirectURL;
System.out.println("targetURL is: "+redirectURL);


response1.sendRedirect(targetURL);
            
            
            //////////
  


        } else {
            // Something went wrong
            System.out.println(response.errors());
        }
        
        }
        catch(Exception ex){
            System.out.println("Something went wrong: "+ex);
            model.setViewName("error.jsp");              

        
        }
        
        return model;

}


 @RequestMapping(value="/returnPage", method = RequestMethod.GET)  
public ModelAndView checkTransaction(ModelAndView model, HttpServletRequest req,@RequestParam int id){
/*
    private final String merchantReference;
    private final String paynowReference;
    private final BigDecimal amount;
    private final boolean paid;*/
            id= Integer.parseInt(req.getParameter("id"));
            
            //find transaction by id
            PaymentInfoJpaController cc = new PaymentInfoJpaController();
            PaymentInfo aa= cc.findPaymentInfo(id);
            String poller= aa.getPollurl();
            //checking if the payment has been paid
            StatusResponse status = paynow.pollTransaction(poller);

            if (status.paid()) {
                System.out.println("Payment Succeeded");
                int amount=0;
                String paynowref="";
                amount=status.getAmount().intValue();
                paynowref=status.getPaynowReference();
                model.addObject("amount",amount);
                model.addObject("paynowref",paynowref);
                model.addObject("state", status.paid());
                model.setViewName("return_page.jsp");              
                
                // Yay! Transaction was paid for
            } else {
                System.out.println("Payment Failed. Why you no pay?");            
                model.setViewName("payment_failed.jsp");
            }
            
            return model;


}



}

