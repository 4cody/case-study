<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	font-size: 1.1rem;
	font-weight: bolder;
}

.container {
	width: 900px;
	height: auto;
	background-color: rgb(248, 248, 248);
	margin: 2rem auto;
	padding: 2rem;
	/* display: flex; */
}

header {
	height: 200px;
}

table {
	width: 100%;
	border-collapse: separate;
	border-spacing: .8em 1em;
	border: 1px solid rgb(0, 0, 0);
}

th {
	text-align: center;
	height: 2.2em;
	font-size: 1.6rem;
	border: 1px solid black;
}

td {
	padding-left: 1rem;
}
</style>
</head>
<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Drone</th>
					<th>Category</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${droneList}" var="drone">
					<tr>
						<td>${drone.make}</td>
						<td>${drone.category}</td>
						<td>${drone.rating}</td>
						<td style="text-align: center;"><a
							href="./drones/${drone.droneId}">Details</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>


</body>
</html>