package com.himtube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.himtube.entity.HimTubeUser;
import com.himtube.service.HimTubeService;
import com.himtube.service.HimTubeServieInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String option = request.getParameter("ac");
		
		if(option.equals("register")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String dob = request.getParameter("dob");
			String contact = request.getParameter("contact");
			
			HimTubeUser htu = new HimTubeUser();
			htu.setName(name);
			htu.setEmail(email);
			htu.setPass(pass);
			htu.setDob(dob);
			htu.setContact(contact);
			
			HimTubeServieInterface hsi = HimTubeService.createServiceObject("htu");
			
			int i = hsi.createProfile(htu);
			
			if(i>0) {
				out.println("<h1 style=text-align:center>Profile Created and Data Inserted</h1>");
			}
			else {
				out.println("<h1 style=text-align:center>Profile couldn't be  created</h1>");
			}
		}
		
		
		out.println("</body></html>");
	}
	
	
}
