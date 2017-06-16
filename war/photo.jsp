<%@ page trimDirectiveWhitespaces="true" %>
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
<br><br><br><br>
upload the profile picture
	<form action="<%=blobstoreService.createUploadUrl("/profpic")%>"
		method="post" enctype="multipart/form-data">
		
			profile photo<input type="file" name="photo"><br>
	
		<input type="submit" value="Submit">
	</form>
	
</body>
</html>
