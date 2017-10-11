<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today</title>
</head>
<body>
    <h2>Current date and time</h2>
    <%
         out.println( new java.util.Date());
         
         out.println( application.getRealPath(""));
    %>
    
    <hr/>
   
</body>
</html>