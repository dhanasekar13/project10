package com.ds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter o = resp.getWriter();
		HttpSession s1 = req.getSession(false);
		if (s1 == null) {

			resp.sendRedirect("index.html");

		} else {
			
		resp.sendRedirect("b11");

		}

	}
}
