<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>

	<h2>Update Salary</h2>
	<form action="updateSalary2.jsp" method="post">
		Employee Id <br /> <input type="text" name="id" value="${param.id}" />
		<p></p>
		New Salary <br /> <input type="text" name="salary"  value="${param.salary}" />
		<p></p>
		<input type="submit" value="Update Salary" />
	</form>

	<%
		if (request.getParameter("id") == null)
			return;
	%>

	<jsp:useBean id="empBean" class="beans.EmployeeBean" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="empBean" />

    <h3>
	<%
		boolean result = empBean.updateSalary();
		if (result)
			out.println("Updated Successfully!");
		else
			out.println("Due to error couldn't update salary!");
	%>
	</h3>

</body>
</html>