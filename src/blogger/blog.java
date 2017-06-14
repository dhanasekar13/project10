package blogger;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ds.Bootstrap1Servlet;

public class blog extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession hs1 = req.getSession();
		String email=Bootstrap1Servlet.email;
		System.out.println(email);
		
	if(email!=null)
	{
		System.out.println("received in blog");
		resp.sendRedirect("blog.html");
	}
	else
	{
		resp.sendRedirect("check.html");
		
	}
	}
}
