<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> Leave a drone review </h1>

	 <form:form action="./" method="post" modelAttribute="review">
		<div>
			<form:textarea path="textBody" placeholder="Leave your review..."/>
			<form:errors path="textBody" />
		</div>		
		<div>
			<label>Rating</label>
			<form:input path="rating"/>
			<form:errors path="rating" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form:form> 

</body>
</html>