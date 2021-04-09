<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register-Cedar Drone</title>

<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	background-color: rgb(184, 184, 181);
}

.container {
	width: 400px;
	height: 400px;
	border: 1px solid rgb(0, 0, 0);
	background-color: white;
	margin: 2rem auto;
	padding: 2rem;
	border-radius: 8px;
	display: grid;
	place-content: center;
}

.form div {
	height: 80px;
	display: flex;
	flex-direction: column;
}

.form div span {
	color: red;
	font-weight: bold;
}

.form div input {
	background-color: rgb(184, 184, 181);
}
</style>

</head>
<body>

	<div class="container">

		<form:form class="form" action="./register" method="post" modelAttribute="user">
			<div>
				<label>Name</label>
				<form:input path="username" />
				<form:errors path="username" />
			</div>
			<div>
				<label>Email</label>
				<form:input path="email" />
				<form:errors path="email" />
			</div>
			<div>
				<label>Password</label>
				<form:input path="password" />
				<form:errors path="password" />
			</div>
			<div>
				<input type="submit" value="Register" />
			</div>
		</form:form>

	</div>
</body>
</html>