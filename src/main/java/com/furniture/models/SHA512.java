/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furniture.models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author mariona
 */
public class SHA512 {
    
    
          
      
       public String getPaymentInfo(Double Amount, String appID2, String Email, String MobileNumber, String returnUrl, String Id, String Key, String postUrl, String Status) throws Exception
    {
        
        System.out.println("DATA FROM OUR CONTOLLER :: AMOUNT ::"+Amount);
        System.out.println("DATA FROM OUR CONTOLLER :: EMAIL ::"+Email);
        System.out.println("DATA FROM OUR CONTOLLER :: ID ::"+appID2);
        System.out.println("DATA FROM OUR CONTOLLER :: cell ::"+MobileNumber);


        System.out.println("IM ABOUT TO PRINT THE HASH ZIE \n ");
        //
        //String password1 =  resultUrlX + returnUrlValueX + paynowReferenceX + referenceX + amountX + idX + additionalinfoX + authemailX + statusX + merchant_keyX;
            
        String password1 = Id +  appID2 + Amount +  appID2 + returnUrl  + Email + postUrl  + Status + Key;
        
        System.out.println("VALUES FOR CREATING THE HASH key \n:"+password1);
        //return hexData.toString().toUpperCase();
        //PaynowInitiate pay = new PaynowInitiate();
        System.out.println("THIS IS OUR 512 SHA  \n"+hashText(password1));  
        //pay.sendPost1(stud_id, Amount, password1);
        String stambo1 = hashText(password1);
        return stambo1;
         //PaynowInitiate pay = new PaynowInitiate();
        
        //System.out.println(password1);
    }
       
       public String getValidHash(String statusValue,String browseUrl, String pollUrl,  String browseUrlValue, String pollUrlValue, String intergrationKey, String hashValue) throws Exception
    {
        //String password1 = resultUrlX + returnUrlValueX + referenceX + amountX + idX + additionalinfoX + authemailX + statusX + merchant_keyX;
        //StringBuffer hexData = new StringBuffer();
        //for (int byteIndex = 0; byteIndex < data.length; byteIndex++)
        //hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));
        // String Id = "3303";
        String Id = "4931";
        String Status = "Message";
        //String Key = "6f7b96b8-60a5-4e6c-827e-e2c87e3c552a";
        //String Key = "1747d3b9-27ad-4ae3-ba1c-13557544b62f";//TEST ENVIRONMENT KEY
        String Key = "7b57815a-b2e7-47ae-a57a-cb3044d5850d";//LIVE KEY FOR NUST FEES
        String returnUrl ="http://196.220.96.82:8080/WebApplication2/applicationSubmitted";
        //String postUrl ="http://196.220.96.95:8081";
        String postUrl ="http://196.220.96.82:8080/WebApplication2/listener.jsp";
        String authemail ="kitso.noko@hotmail.com";
        String simo = "=";
        String stat = "status";
        System.out.println("IM ABOUT TO PRINT THE HASH ZIE \n ");
        String password2 = stat+statusValue+browseUrl+browseUrlValue+pollUrl+pollUrlValue+intergrationKey;
        String password3 = stat+statusValue+browseUrl+browseUrlValue+pollUrl+pollUrlValue+simo+intergrationKey;
       
        String password1 = statusValue+browseUrlValue+pollUrlValue+simo+intergrationKey+Key;
        String password4 = statusValue+browseUrlValue+pollUrlValue+simo+intergrationKey+Key;
        String strWithoutSpace = password4.replaceAll("\\s", "");
         System.out.println("TESTING FILE MARSHALLING AFTER THIS LINE \n");

//JAXBExample test7 = new JAXBExample();
//ObjectToXml test8 = new ObjectToXml();
//test7;
//System.out.println(test8);

System.out.println("TESTING FILE MARSHALLING ABOVE THIS LINE \n");
        System.out.println("THIS IS valuue for has generatiom  \n"+strWithoutSpace);
         System.out.println("THIS IS THE GENERATED HAS status  \n"+statusValue);
          System.out.println("THIS IS THE GENERATED HASH browse  \n"+browseUrlValue);
           System.out.println("THIS IS THE GENERATED HASH  pollva \n"+pollUrlValue);
            System.out.println("THIS IS THE GENERATED HASH  keey \n"+intergrationKey);
        //return hexData.toString().toUpperCase();
            //PaynowInitiate pay = new PaynowInitiate();
            System.out.println("THIS IS THE GENERATED HASH  \n"+hashText(password1));  
              System.out.println("THIS IS THE GENERATED HASH 2 \n"+hashText(password2));  
                System.out.println("THIS IS THE GENERATED HASH 4 \n"+hashText(strWithoutSpace));  
             System.out.println("THIS IS THE CURRENT HASH WITH SIMO"+hashValue); 
               String [] browseUrlSplit = browseUrlValue.split("/");
               
                System.out.println("SPLIT BROWSE URL ::.."+Arrays.toString(browseUrlSplit));
                String payNowRef = browseUrlSplit[5];
                System.out.println("REFERENCE VALUE CAN BE FOUND ::.."+payNowRef);
            //pay.sendPost1(stud_id, Amount, pawsessword1);
            String stambo2 = hashText(strWithoutSpace);
        return stambo2;
         //PaynowInitiate pay = new PaynowInitiate();
        
        //System.out.println(password1);
    }
       
    public String passHash(String password1){
         String hashT = null;  
        try {
               hashT = hashText2(password1);
     } catch (Exception ex) {
              Logger.getLogger(SHA512.class.getName()).log(Level.SEVERE, null, ex);
          }
return hashT;
    }
      //method to convert from byte to uppercase hexadecimal
    public static String convertByteToHex(byte data[])
    {
        //mark this
        StringBuffer hexData = new StringBuffer();
        for (int byteIndex = 0; byteIndex < data.length; byteIndex++)
            hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));
        
        return hexData.toString().toUpperCase();
    }
    
    public static String toHexadecimal(String text) throws UnsupportedEncodingException
{
    byte[] myBytes = text.getBytes("UTF-8");

    return DatatypeConverter.printHexBinary(myBytes);
}
    
    
    //method to use UFT8 to encode
    public static String hashText(String textToHash) throws Exception
    {
        final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
        sha512.update(textToHash.getBytes("UTF-8"));
        //sha.update(saltPlusPlainTextPassword.getBytes("UTF-8")
        return convertByteToHex(sha512.digest());
        
        //System.out.println(convertByteToHex(sha512.digest()));
    }
    public static String hashText2(String textToHash) throws Exception
    {
        final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
        sha512.update(textToHash.getBytes("UTF-8"));
        //byte [] bty = System.out.println(textToHash.getBytes());
        
        //print hex string version of HELLO WORLD
 
        return DatatypeConverter.printHexBinary(sha512.digest());
        //sha.update(saltPlusPlainTextPassword.getBytes("UTF-8")
        //return convertByteToHex(sha512.digest());
        
        //System.out.println(convertByteToHex(sha512.digest()));
    } 

    
}
