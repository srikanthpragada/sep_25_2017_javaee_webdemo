<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Names</h2>
	<form action="names.jsp">
		Name <input type="text" name="name" /> <input type="submit"
			value="Add" />
	</form>

	<%
		String name = request.getParameter("name");

		if (name == null)
			return;

		// add name to session

		ArrayList<String> names;

		names = (ArrayList<String>) session.getAttribute("names");
		if (names == null) {
			names = new ArrayList<String>();
			session.setAttribute("names", names); // add to session 
		}

		names.add(name);
		
		// display names
		out.println("<p></p><ul>");
		for(String n : names)
			out.println( "<li>" + n + "</li>");
		
		out.println("</ul>");
	%>



</body>
</html>