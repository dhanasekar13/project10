


	package blogger;

	import javax.jdo.annotations.PersistenceCapable;
	import javax.jdo.annotations.Persistent;
	import javax.jdo.annotations.PrimaryKey;

	import com.google.appengine.api.blobstore.BlobKey;

	@PersistenceCapable
	public class blogcreate {
	@PrimaryKey
	@Persistent
	private String blobtitle;
	@Persistent
	private String blobinfo;
	@Persistent
	private String email;
	@Persistent
	private String blobcontent;
	@Persistent
	BlobKey image;
	public String getBlobtitle() {
		return blobtitle;
	}
	public void setBlobtitle(String blobtitle) {
		this.blobtitle = blobtitle;
	}
	public String getBlobinfo() {
		return blobinfo;
	}
	public void setBlobinfo(String blobinfo) {
		this.blobinfo = blobinfo;
	}
	public String getBlobcontent() {
		return blobcontent;
	}
	public void setBlobcontent(String blobcontent) {
		this.blobcontent = blobcontent;
	}
	public BlobKey getImage() {
		return image;
	}
	public void setImage(BlobKey image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "blogcreate [blobtitle=" + blobtitle + ", blobinfo=" + blobinfo + ", blobcontent=" + blobcontent
				+ ", image=" + image + "email="+email+"]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public blogcreate(String blobtitle, String blobinfo, String blobcontent, BlobKey image,String email) {
	
		this.blobtitle = blobtitle;
		this.blobinfo = blobinfo;
		this.blobcontent = blobcontent;
		this.image = image;
		this.email=email;
	}

	}
