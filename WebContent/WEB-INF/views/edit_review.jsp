<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

.container {
	width: 100vw;
	height: 100vh;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

form {
	display: flex;
	flex-direction: column;
}

form div {
	margin: 10px 0;
}
</style>
</head>
<body>
	<div style="margin: 2rem auto; width: 900px;">
		<%@include file="nav.html"%>
	</div>

	<div class="container">

		<form:form
			action="/caseStudy/drones/${droneId}/review/${reviewToEdit.rId}/edit"
			method="post" modelAttribute="reviewToEdit">
			<div>
				<form:textarea path="textBody" placeholder="Leave your review..." cols="40" rows="10"/>
				<form:errors path="textBody" />
			</div>
			<div style="display: flex; justify-content: space-around;">
				<div>
					<label>Rating</label>
					<form:input path="rating" style="width: 30px;" />
					<form:errors path="rating" />
				</div>
				<div>
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form:form>

	</div>


</body>
</html>