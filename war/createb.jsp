<%@ page trimDirectiveWhitespaces="true"%>
<%@ page
	import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>

<%
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>


<html>
<head>
<title>Upload Test</title>
</head>
<body>
	<form action="<%=blobstoreService.createUploadUrl("/c1")%>"
		method="post" enctype="multipart/form-data">
		<label>Blog Title</label><br> <input type="text" name="bt1"><br>
		<label>Blog Info</label><br> <input type="text" name="bi1"
			size="10"><br> <label>Blog Content</label><br>
		<textarea rows="100" cols="50" name="bc1"></textarea>
		<br> <label>Upload the image if you want</label> <input
			type="file" name="img1"><br> <br> <input
			type="submit" value="Submit">
	</form>

</body>
</html>
