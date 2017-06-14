package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import blogger.profile1;

public class profile extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	profile1 pf;
	static PersistenceManager pm = singldata.get().getPersistenceManager();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		List<BlobKey> blobKeys = blobs.get("resume");
		String name = req.getParameter("user");
		String quotes=req.getParameter("quotes");
		 BlobKey b2 = new BlobKey(blobKeys.get(0).getKeyString());
		  
		String email=Bootstrap1Servlet.emailfull;
		if (blobKeys == null || blobKeys.isEmpty()) {
			res.sendRedirect("/index.jsp");
		} else {
	pf=new profile1(email,name,quotes,b2);
	 try
     {
     pm.makePersistent(pf);
     }
     catch(Exception e)
     {
     	
     }
			res.sendRedirect("blog.html");
		}
	}

}