<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
 <title>Core Tags</title>
</head>
<body>
  <c:out value="Hello!"></c:out>
  <c:set  var="country" value="India" scope="session"> </c:set>
  ${sessionScope.country}
  <p/>
  <c:forEach var="i" begin="1" end="10"  step="2">
       ${i} <br/>
  </c:forEach>
</body>
</html>