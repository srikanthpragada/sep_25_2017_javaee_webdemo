<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Salary</title>
</head>
<body>
	 
	 <jsp:useBean id="empBean" class="beans.EmployeeBean" scope="page"></jsp:useBean>
	 <jsp:setProperty property="*" name="empBean"/>
	 
	 <%
	     boolean result = empBean.updateSalary();
	     if ( result )
	    	 out.println("Updated Successfully!");
	     else
	    	 out.println("Due to error couldn't update salary!");
	 %>

</body>
</html>