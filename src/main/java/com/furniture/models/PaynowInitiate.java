///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.furniture.models;
//
//import com.furniture.controllers.PaymentInfoJpaController;
//import com.furniture.entities.PaymentInfo;
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;
//import static java.lang.System.out;
//import java.net.URL;
//import java.net.URLDecoder;
//import java.nio.charset.Charset;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.net.ssl.HttpsURLConnection;
//import static org.springframework.http.HttpHeaders.USER_AGENT;
//import org.springframework.util.StringUtils;
//
///**
// *
// * @author mariona
// */
//public class PaynowInitiate {
//    
//    
//          
//    public String sendPost1(String appID2,Double Amount,String MobileNumber, String Email) throws Exception {
//        
//        String Id = "3270";// LIVE ID FOR NUST FEES
//        
//        String Status = "Message";
//         String Key = "7b57815a-b2e7-47ae-a57a-cb3044d5850d"; // LIVE ID FOR NUST FEES environment
//         String postUrl = "http://apply.nust.ac.zw/Listener?id="; // Live environment
//       String url = "https://www.paynow.co.zw/interface/initiatetransaction";
//        
//        try{
//            
//            String hashCode;
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//            LocalDate dateTime = LocalDate.now();
//            System.out.println(dtf.format(dateTime)); //2016/11/16
//                        System.out.println("Database connection established");
//             
//             
//            /**
//             * proposed place to input into database and obtain the record ID
//             * 
//             * Replace with named query
//             */
//           PaymentInfoJpaController pij = new PaymentInfoJpaController();
//            pij.create();
//            
//            //If no recordId has been assigned the transaction doesnt go through an error page is exhibited and email sent
//            if (recordID == 0){
//                //send an email sent to us.
//                PaymentEmail ms = new PaymentEmail();
//                ms.senderror("software@nust.ac.zw", Amount, MobileNumber, appID2);
//                //sendreceipt(String email, String amount, String reference, String stud_id);
//                
//                return "https://apply.nust.ac.zw/internalError.jsp";//return error page. do not proceed.   
//            }
//            /**
//             * set up http:// post connection
//             */
//            
//            //recordID = 109;
//            
//            URL obj = new URL(url);
//            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//            System.out.println("IM NOW IN SEND POST ONE .... kkkk");
//            //add reuqest header
//            con.setRequestMethod("POST");
//            con.setRequestProperty("User-Agent", USER_AGENT);
//            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//            SHA512 sh = new SHA512();
//            hashCode = sh.getPaymentInfo(Amount, appID2, Email, MobileNumber ,(returnUrl+recordID), Id, Key, (postUrl+recordID), Status); 
//            String urlParameters = "id=3270&reference="+appID2+"&amount="+Amount+"&additionalinfo="+appID2+"&returnurl=http%3a%2f%2fapply.nust.ac.zw%2fPaynowPoller%3fid%3d"+recordID+"&authemail="+Email+"&resulturl=http%3a%2f%2fapply.nust.ac.zw%2fListener%3fid%3d"+recordID
//                    + "&status=Message&"
//                    + "hash="+hashCode+"";
//
//
//
//            con.setDoOutput(true);
//            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//            //con.setRequestProperty("charset","utf-8");
//            wr.writeBytes(urlParameters.trim());
//            wr.flush();
//            wr.close();
//            /**
//             * the posting to paynow is done.
//             * Below we get the reponse from paynow
//             */
//
//            int responseCode = con.getResponseCode();
//            String responseValidator = con.getResponseMessage();
//            String responseValidator1 = con.getRequestMethod();
//            System.out.println(con.getResponseMessage());
//            System.out.println("\nSending 'POST' request to URL jjjjj : " +responseValidator1 );
//            System.out.println("\nSending 'POST' request to URL : " + url);
//            System.out.println("Post parameters : " + urlParameters);
//            System.out.println("Response Code : " + responseCode);
//            System.out.println("Our Response from paynow is : " + responseValidator);
//            StringBuilder content = new StringBuilder();
//
//            // code for validating the response form paynow
//            if (responseValidator.equals("OK") && responseCode==200){
//             System.out.println("OUR RESPONSE CODE FOR VALIDATION FROM PAYNOW: " + responseValidator+"... STATUS..:"+responseCode);
//             CloseableHttpClient httpclient = HttpClients.createDefault();
//            //HttpGet httpGet = new HttpGet("http://targethost/homepage");
//            //CloseableHttpResponse response1 = httpclient.execute(httpGet);
//             
//            }
//            else {
//            System.out.println("OOPS THERE IS AN ERROR :: OUR RESPONSE CODE FOR VALIDATION FROM PAYNOW: " + responseValidator+"... STATUS..:"+responseCode);
//            }
//
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//                
//            while ((inputLine = in.readLine()) != null) {
//                content.append(inputLine);
//            }
//                
//            /**
//             * Decoding the response from paynow.
//             */    
//                
//            Object obj1;
//            obj1 = JSONValue.parse(content.toString());
//            JSONArray finalResult=(JSONArray)obj1;
//            //data = response.split("&");
// 
//            System.out.println("THIS IS THE RESPONSE FROM PAYNOW"+content);
//            String  converted = content.toString();
//            String zie1 =         URLDecoder.decode(converted);
//            //zie1= zie1.split("&");
//            System.out.println("PAYNOW RESPONSE  \n "+converted+'\n');
//            String [] zzzz = converted.split("&");
//
//
//            System.out.println("THE PARAMETERS ARE FINAL ZIBUSISO"+Arrays.toString(zzzz));
//            String dddd = Arrays.toString(zzzz);
//            //zzzz.toString();
//
//            System.out.println("DREADMAN EDWIN"+zzzz);
//
//            System.out.println("THE PARAMETERS ARE FINAL ZIBUSISO EDWIN"+dddd);
//               
//            String [] paynow = dddd.split("=");
//            System.out.println("WHY NOT THESE PARAMETERS ARE FINAL ZIBUSISO EDWIN"+Arrays.toString(paynow));
//            HashMap<String, String> parameters = new HashMap<String, String>();
//
//            String query = converted;
//            List<NameValuePair> params = URLEncodedUtils.parse(query, Charset.defaultCharset());
//            for (NameValuePair nameValuePair : params) {
//                parameters.put(nameValuePair.getName(), nameValuePair.getValue());
//            }
//               
//            System.out.println("THE PARAMETERS ARE"+params);
//       
//            String arraylistToString = StringUtils.collectionToCommaDelimitedString(params);
//        
//            System.out.println("THE PARAMETERS ARE FINAL ::"+arraylistToString);
//          
//            String [] paynow3 = arraylistToString.split("=");
//            String paynow4 = Arrays.toString(paynow3);
//         
//            String [] paynow5 = paynow4.split(",");
//     // String [] stockArr = params.toArray((T[]) new NameValuePair[0]);
//            System.out.println("THE PARAMETERS ARE FINAL 55 ::"+Arrays.toString(paynow5));
//      
//            String status = paynow5[0];
//            String statusValue = paynow5[1];
//            String browseUrl = paynow5[2];
//            String browseUrlValue = paynow5[3];
//            String pollUrlValue = paynow5[5];
//            String pollUrl = paynow5[4];
//            
//            String intergrationKey = paynow5[6];
//            String hash = paynow5[7];
//            String hashValue = paynow5[8];
//      
//            System.out.println("THE STATUS IS  ::"+status);
//            System.out.println("THE STATUS VALUE IS  ::"+statusValue);
//            System.out.println("THE BROWSE URL  IS  ::"+browseUrl);
//            System.out.println("THE BROWSEALUE URL  IS  ::"+browseUrlValue);
//            System.out.println("THE POLL URL    ::"+pollUrl);
//            System.out.println("THE POLL URL VALUE IS   ::"+pollUrlValue);
//            System.out.println("THE INT KEY  IS  ::"+intergrationKey);
//            System.out.println("THE HASH IS   ::"+hash);
//            System.out.println("THE HASH VALUE IS   ::"+hashValue);
//            System.out.println("THE  STUDENT ID IS HASH VALUE IS   ::"+appID2);
//            System.out.println("THE INITIAL AMOUNT ON THE    ::"+Amount);
//            System.out.println("THE  STUDENT Telephone IS HASH VALUE IS   ::"+MobileNumber);
//            System.out.println("THE Email is     ::"+Email);
//
//
//            System.out.println("THE HASH VALUE    ::"+hashValue);
//            System.out.println("THE HASH VALUE IS   ::\n"+hashValue);
//               
//             String [] browseUrlSplit = browseUrlValue.split("/");
//               
//            System.out.println("SPLIT BROWSE URL ::.."+Arrays.toString(browseUrlSplit));
//            String payNowRef = browseUrlSplit[5];
//            System.out.println("REFERENCE VALUE CAN BE FOUND ::.."+payNowRef);
//               
//               
//            
//            String hashValue1 = hashValue.replaceAll("]", "");
//            String hashValue2 = hashValue1.replaceAll(" ", "");
//            SHA512 mimie = new SHA512();
//            String validHash = (mimie.getValidHash(statusValue,pollUrl, browseUrl, browseUrlValue, pollUrlValue, intergrationKey, hashValue));
//            String validHashZ = validHash.replaceAll(" ", "");
//            System.out.println(validHashZ);
//            System.out.println(hashValue2);
//            
//            if ( validHashZ.equals(hashValue)){
//                
//                //System.out.println(" DATE AND TIME IS ::.. " + DateFormat.getInstance().format(now));
//                /**
//                 * This is where we write to the database
//                 */
//                /**
//                 * New code for writing to the database with and update query
//                 */
//                String updateQuery = "UPDATE transactions SET browser_url = '" + browseUrlValue.trim() + "', poll_url = '" + pollUrlValue.trim() + "=" + intergrationKey.trim() + "', paynow_reference = '" + payNowRef.trim() + "', status = '" + statusValue.trim() + "'"
//                     + "WHERE id =" + recordID + "; ";
//                writeToDatabase(updateQuery);
//                //********//
//                //HT edited 24/02/2018
//                //we should not proceed if we fail to write to the database at this stage
//                // done step by step to really follow the sql statements. remove later!!
//                //tried to combine the sql statements into one but failed for now.
//                String checkUpdateQuery = "SELECT * FROM transactions WHERE id =" + recordID + ";";
//                String paynowRef = writeToDatabase2(checkUpdateQuery);
//                //If paynowRef has no value transaction stops
//                if (paynowRef.equalsIgnoreCase("")){
//                AdmissionsMail ms = new AdmissionsMail();
//                ms.senderror("software@nust.ac.zw", Amount, MobileNumber, appID2);
//                return "https://apply.nust.ac.zw/internalError.jsp"; //return error page. do not proceed.
//                }                       
//
//                System.out.println("DB CONNECTION SHED ON PAYNOW INITIATE ");
//                //return browseUrlValue;
//             
//                System.out.println("THIS IS JUST THE BEGINNING .......???"+validHash);
//                System.out.println("THIS CODE FOR STORING IN TO DATABASE JUST THE BEGINNING .......???");
//                return browseUrlValue;
//                }
//                System.out.println("THIS IS JUST THE BEGINNING  zie.......???");
//       
//            //System.out.println("THE PARAMETERS ARE"+Arrays.toString(stockArr));
//            //String [] dd = params.spliterator("&");
//            String[] details;
//            String s20="";
//            //boolean sInArray = Arrays.stream(details).anyMatch("s"::equals); 
//            details = zie1.split("&");
//            System.out.println("THE NNNNN NNNNNN NNNNN "+details);
//            for (int x=0;x<details.length;x++){
//                String s="s";
//                String[] d = details[x].split("=");
//                System.out.println(d );
//                //if(d.length == 2)
//                for (int i=0; i< d.length ; i++) {
//                    System.out.println("String s :"+x+i+" = "+d[i]);         
//                    System.out.println("AND THE VALUE IS : "+status);
//                }  
//            }
//       
//            while ((inputLine = in.readLine()) != null) {
//               if (inputLine.matches("OK"))
//               {
//               System.out.println("contains ok ssss"+response);
//               }
//               String response_text = null;
//
//            HttpEntity entity = null;
//            //entity = response//.getEntity();
//
//            StringBuilder sb = new StringBuilder();
//            String output;
//            while ((output = in.readLine()) != null) {
//            sb.append(output);
//            System.out.println("hambe shwa"+output);
//            //return sb.toString();}
//            }
//                   
//            System.out.println("contains ok bbbbb");
//            response.append(inputLine +"\n");
//
//            System.out.println(inputLine);
//            System.out.println("contains ok" + response);
//
//            //String zie =         URLDecoder.decode(inputLine);
//            String zie =         URLDecoder.decode(converted);
//               
//            System.out.println("Hope it decoded "+zie);
//            String valid = "OK";
//            System.out.println("Hope it decoded "+zie);
//            //String valid = "OK";
//            if (responseValidator.equals(valid)) {
//
//               System.out.println("\nSTATUS IS OK WE ARE NOW WRITING TO DATABASE: " + responseValidator);
//               
//               JSONObject myObject = new JSONObject(response);
//               
//               
//               System.out.println(myObject);
//               
//               System.out.println("\nSTATUS IS OK WE ARE NOW WRITING TO DATABASE: " + responseValidator);
//               }
//                        
//                   
//            }
//            in.close();
//
//		//print result
//            System.out.println(response.toString());
//             
//                //System.out.println("blalalalalalalal "+o);
//            List<String> response1 = new ArrayList<String>();
//  
//            Map<String, List<String>> map = con.getHeaderFields();
//            System.out.println("Printing Response Header...\n");
//            //String responseBody = httpclient.execute(httpget, responseHandler);
//        
//            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//		System.out.println("Key : " + entry.getKey()
//                           + " ,Value : " + entry.getValue());
//            }
//
//            System.out.println("\nGet Response Header By Key ...\n");
//            String server = con.getHeaderField("Server");
//
//            if (server == null) {
//                    System.out.println("Key 'Server' is not found!");
//            } else {
//                    System.out.println("Server - " + server);
//            }
//
//            System.out.println("\n Done");
//                
//                /****/
//            return null;
//            }
//            finally {
//            out.close();
//            }
//            }    
//   
//    
//}
