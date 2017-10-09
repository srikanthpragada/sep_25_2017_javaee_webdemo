<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  
  String username = request.getParameter("username");
  // create a cookie
  
  Cookie c = new Cookie("username", username);
  c.setMaxAge(24 * 60 * 60);  // 1 day
  
  response.addCookie(c);
  
  response.sendRedirect("showdetails.jsp");
  

%>

</body>
</html>