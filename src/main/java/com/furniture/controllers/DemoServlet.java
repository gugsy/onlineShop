/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furniture.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
  
public class DemoServlet extends HttpServlet{ 
    
@RequestMapping(value="/rd",method = RequestMethod.GET)
public void doGet(HttpServletRequest req,HttpServletResponse response)  
throws ServletException,IOException  
{  
response.setContentType("text/html");  
PrintWriter pw=response.getWriter();  
  
response.sendRedirect("http://www.google.com");  
  
pw.close();  
}}  
