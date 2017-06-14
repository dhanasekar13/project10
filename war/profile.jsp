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
	<form action="<%=blobstoreService.createUploadUrl("/profile1")%>"
		method="post" enctype="multipart/form-data">
		UserName<input type="text" name="user"><br>
			Resume<input type="file" name="resume"><br>
	<br>Quotes-	<input type="text" name="quotes">
		<input type="submit" value="Submit">
	</form>
	
</body>
</html>
