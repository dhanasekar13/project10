package blogger;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;

@PersistenceCapable
public class profile1 {
@PrimaryKey
@Persistent
private String email;
@Persistent
private String name;
@Persistent
private String quotes;
@Persistent
BlobKey image;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getQuotes() {
	return quotes;
}
public void setQuotes(String quotes) {
	this.quotes = quotes;
}
public BlobKey getImage() {
	return image;
}
public void setImage(BlobKey image) {
	this.image = image;
}
@Override
public String toString() {
	return "profile [email=" + email + ", name=" + name + ", quotes=" + quotes + ", image=" + image + "]";
}
public profile1(String email, String name, String quotes, BlobKey image) {
	super();
	this.email = email;
	this.name = name;
	this.quotes = quotes;
	this.image = image;
}

}
