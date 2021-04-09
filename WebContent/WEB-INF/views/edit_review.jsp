<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form
		action="/caseStudy/drones/${droneId}/review/${reviewToEdit.rId}/edit"
		method="post" modelAttribute="reviewToEdit">
		<div>
			<form:textarea path="textBody" placeholder="Leave your review..." />
			<form:errors path="textBody" />
		</div>
		<div>
			<label>Rating</label>
			<form:input path="rating" />
			<form:errors path="rating" />
		</div>
		<div>
			<input type="submit" value="Submit" />
		</div>
	</form:form>

</body>
</html>