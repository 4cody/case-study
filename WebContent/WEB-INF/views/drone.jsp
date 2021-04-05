<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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


<h3>Leave a <a href="./${currentDrone.droneId}/review">review</a> on this drone</h3>

</body>
</html>