<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="oracle.jdbc.rowset.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Jobs</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
	<h1>Jobs</h1>

	<table border="1">
		<tr style="color: red">
			<th>Job Id</th>
			<th>Job Title</th>
			<th>Min. Salary</th>
			<th>Max. Salary</th>
		</tr>


		<%
		    String title = request.getParameter("title");
		
			try (OracleCachedRowSet crs = new OracleCachedRowSet()) {
				crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
				crs.setUsername("hr");
				crs.setPassword("hr");
				crs.setCommand("select * from jobs where job_title like ?");
				
				crs.setString(1, "%" + title + "%");
				crs.execute();
				while (crs.next()) {
		%>
		
		<tr>
			<td><%=crs.getString("job_id")%></td>
			<td><%=crs.getString("job_title")%></td>
			<td style="text-align:right"><%=crs.getString("min_salary")%></td>
			<td style="text-align:right"><%=crs.getString("max_salary")%></td>
		</tr>
		
		<%
			     } // while 
			} // try
		%>

	</table>

</body>
</html>