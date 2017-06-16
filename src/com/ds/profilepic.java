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

import blogger.picupload;

public class profilepic extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	picupload pf,pf1;
	static PersistenceManager pm = singldata.get().getPersistenceManager();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		System.out.println("received here profile pic");
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		List<BlobKey> blobKeys = blobs.get("photo");
		 BlobKey b2 = new BlobKey(blobKeys.get(0).getKeyString());
		  
		String email=Bootstrap1Servlet.email;
	try{
		pf1 = pm.getObjectById(picupload.class, email);
		pf1.setImage(b2);
		 try
	     {
	     pm.makePersistent(pf1);
	    System.out.println("uploaded successfully --after update"+pm);
	     }
	     catch(Exception e1)
	     {
	    	 System.out.println("Error code is--"+e1);
	     }
		 res.sendRedirect("/blog.html");	
	}catch(Exception et)
		{			
		System.out.println("the email inside the profile upload is"+email);
		if (blobKeys == null || blobKeys.isEmpty()) {
			res.sendRedirect("/index.jsp");
		} else {
	//now create a datastore to upload the blob
			pf=new picupload(email,b2);
	 try
     {
     pm.makePersistent(pf);
    System.out.println("uploaded successfully  --after creation"+pm);
     }
     catch(Exception e1)
     {
    	 System.out.println("Error code is--"+e1);
     }
	 res.sendRedirect("/blog.html");	
		}
		}
	}
	
	}
	

