<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${currentDrone.model}</title>
</head>
<body>

<h1> Drone View </h1>

<p>${currentDrone.make}</p>
<p>${currentDrone.model}</p>
<p>${currentDrone.rating}</p>


<h3>Leave a <a href="./${currentDrone.droneId}/review/">review</a> on this drone</h3>

<div>

<c:forEach items="${reviewList}" var="review">
    <p>${review.textBody}</p><br/>
    <p>${review.rating}</p>
</c:forEach>

</div>

</body>
</html>