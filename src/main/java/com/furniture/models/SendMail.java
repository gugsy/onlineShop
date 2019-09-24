/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furniture.models;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Owen
 */
public class SendMail  {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public static void main(String args[]) throws AddressException, MessagingException {
            
            //String a = "";
           // String b = "";
		//generateAndSendEmail(a,b);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
 
	public String generateAndSendEmail(String name, String surname, String timestamp) throws AddressException, MessagingException {
           
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");//to change to port for .238 server
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		//generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress());
		 generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("gugulethu.ngwenya@nust.ac.zw"));
		generateMailMessage.setSubject("NOTICE :: Account Creation STATUS");
		String emailBody = "Your mail has been received with the following details. First name is \n" + name + "\n. Surname is \n" + surname + "\n.  Date of receipt is \n" + timestamp + "\n.";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail with a aaaa :"+timestamp);
		Transport transport = getMailSession.getTransport("smtp");
 System.out.println("\n\n 3rd ===> Get Session and Send mail test 1");
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "mariona.ngwenya@gmail.com", "nonhlanhla1996");//relay.nust.ac.zw
                System.out.println("\n\n 3rd ===> Get Session and Send mail");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
                 System.out.println("\n\n 3rd ===> Get Session and Send mail zxzzz");
		transport.close();
                return null;
	}
}
