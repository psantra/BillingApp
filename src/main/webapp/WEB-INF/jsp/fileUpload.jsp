<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Form</title>
</head>
<body>
	<font color="green"><h2>Hello</h2></font>
	<h3>${msg}</h3> You have successfully logged in.
	<font color="green"><h3>Welcome to Billing Application !</h3></font>

<h1>browse to upload your file</h1>

<form method="POST" action="/fileUpload" enctype="multipart/form-data">
    <input type="file" name="file" />
    <div style="color: red">${errorMessage}</div>
    <br/><br/>
    <input type="submit" value="Submit" />
    
</form>

</body>
</html>
