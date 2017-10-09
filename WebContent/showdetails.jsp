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
		String user = null;

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("username")) {
					user = c.getValue();
					break;
				}
			}
		}
		
		if (user == null) {
			response.sendRedirect("takename.html");
		}
	%>

	<h1>
		<%=user%></h1>

</body>
</html>