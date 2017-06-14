package blogger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.ds.Bootstrap1Servlet;
import com.ds.singldata;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class getblog extends HttpServlet{
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	blogcreate bc1;
JSONObject jo=new JSONObject();
Collection<JSONObject> c1=new ArrayList<JSONObject>();
HashSet<String> hs=new HashSet<String>();	
	ObjectMapper map1=new ObjectMapper();
	static PersistenceManager pm = singldata.get().getPersistenceManager();

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		HttpSession s1 = req.getSession(false);
		
String Email=Bootstrap1Servlet.email;
s1.setAttribute("email", Email);
System.out.println(Email);
String ui;
Filter pf=new FilterPredicate("email",FilterOperator.EQUAL,Email);
javax.jdo.Query q = pm.newQuery(blogcreate.class, "(email =='"+Email+"')");


try {
  List<blogcreate> results = (List<blogcreate>) q.execute();
System.out.println(results);
  if (!results.isEmpty()) {
    for (blogcreate p : results) {
    	System.out.println(p);
    ui=map1.writeValueAsString(p);
    hs.add(ui);	
    }
  } else {
    // Handle "no results" case
  }
 out.println(hs);
} finally {
  q.closeAll();
}
}
}
