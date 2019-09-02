package com.pawar.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pawar.entity.PawarEmployee;
import com.pawar.service.PawarService;
import com.pawar.service.PawarServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String option = request.getParameter("ac");
		
		if (option.equals("register")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			String contact = request.getParameter("contact");
			
			PawarEmployee pe = new PawarEmployee();
			pe.setName(name);
			pe.setEmail(email);
			pe.setPass(pass);
			pe.setAddress(address);
			pe.setGender(gender);
			pe.setContact(contact);
			
			PawarServiceInterface ps = PawarService.createServiceObject();
			int i = ps.createProfile(pe);
			
			if (i>0) {
				out.println("Profile created");
			} 
			else {
				out.println("Profile not created");
			}
		}
		out.println("</body></html>");
		
		    
	}

}
