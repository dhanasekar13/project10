package blogger;


import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.singldata;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class serve extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	static PersistenceManager pm =singldata.get().getPersistenceManager();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException {
    	
            BlobKey blobKey = new BlobKey(req.getParameter("image"));
        blobstoreService.serve(blobKey, res);
        
       
        }
}

