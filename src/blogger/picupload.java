package blogger;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.blobstore.BlobKey;
@PersistenceCapable
public class picupload {

@PrimaryKey
@Persistent
private String email;

@Persistent
BlobKey image1;

@Override
public String toString() {
	return "picupload [email=" + email + ", image1=" + image1 + "]";
}

public picupload(String email, BlobKey image) {
	
	this.email = email;
	this.image1 = image;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public BlobKey getImage() {
	return image1;
}

public void setImage(BlobKey image) {
	this.image1 = image;
}


}
