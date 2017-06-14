package blogger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.ds.Bootstrap1Servlet;
import com.ds.singldata;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Query;

public class createblog extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	blogcreate bc1;
	ObjectMapper map1=new ObjectMapper();
	static PersistenceManager pm = singldata.get().getPersistenceManager();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		List<BlobKey> blobKeys = blobs.get("img1");
		String blogtitile = req.getParameter("bt1");
		String bloginfo=req.getParameter("bi1");
		String blogcontent=req.getParameter("bc1");
		 BlobKey b2 = new BlobKey(blobKeys.get(0).getKeyString());
		  System.out.println();
		String email=Bootstrap1Servlet.email;
		if (blobKeys == null || blobKeys.isEmpty()) {
			res.sendRedirect("/index.jsp");
		} else {
	bc1=new blogcreate(blogtitile,bloginfo,blogcontent,b2,email);

	 try
     {
     pm.makePersistent(bc1);
    res.sendRedirect("/b11");
		
     }
     catch(Exception e)
     {
     	
     }
		}		
	}
}
