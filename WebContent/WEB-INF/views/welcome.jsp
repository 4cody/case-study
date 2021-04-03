<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
 <h1>Welcome Page</h1>
 
 
 
<c:forEach items="${droneList}" var="drone">
    <p>${drone.make}</p><br/>
    <p>${drone.model}</p><br/>
	<p>${drone.weight}</p>
	<a href="./drones/${drone.droneId}">Review</a>
</c:forEach>
 
</body>
</html>