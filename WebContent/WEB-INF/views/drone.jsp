<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${currentDrone.model}</title>
<spring:url value="/resources/css/drone_view.css" var="dvCss" />
<link href="${dvCss}" rel="stylesheet" />
<spring:url value="/resources/images/${currentDrone.imageName}"
	var="imageSrc" />

<style>
.review_container {
	display: flex;
	border: 1px solid black;
	height: 150px;
	margin: 1rem 0;
}

.sub_container {
	flex: 1;
	display: flex;
	flex-direction: column;
	font-size: 2rem;
	font-weight: bolder;
}

.sub_container h5 {
	flex: 1;
	display: grid;
	place-content: center;
}

.sub_container p {
	flex: 1;
}

.review_container p {
	flex: 4;
	display: grid;
	place-content: center;
}

.review_container .edit_button_spacer {
	flex: 1;
	display: grid;
	place-content: center;
}

.edit_button_spacer a {

}

</style>

</head>
<body>
	<div style="margin: 2rem auto; width: 900px;">
		<%@include file="nav.html"%>
	</div>


	<div class="container" style="margin: 2rem auto;">


		<section class="drone_info_container">
			<div class="image_container">
				<img src="${imageSrc}" alt="">
			</div>

			<div class="drone_info" style="font-size: 1.4em;">
				<div>
					<h2>${currentDrone.make}</h2>
				</div>
				<div>
					<h2>${currentDrone.model}</h2>
				</div>
				<div>
					<h2>Cedar Rating:</h2>
					<h2>${currentDrone.rating}</h2>
				</div>
			</div>
		</section>

		<section class="drone_stats_container">
			<table>
				<tr>
					<th>Price:</th>
					<td>${currentDrone.price}</td>
				</tr>
				<tr>
					<th>Weight:</th>
					<td>${currentDrone.weight}</td>
				</tr>
				<tr>
					<th>Max Speed:</th>
					<td>${currentDrone.maxSpeed}</td>
				</tr>
				<tr>
					<th>Max Range:</th>
					<td>${currentDrone.maxRange}</td>
				</tr>
				<tr>
					<th>Camera Resolution:</th>
					<td>${currentDrone.cameraRes}</td>
				</tr>
			</table>
		</section>
	</div>
	<div style="margin: 2rem auto; width: 900px;">
		<h3 style="width: 900px;">
			Leave a <a href="./${currentDrone.droneId}/review/">review</a> on
			this drone
		</h3>

	</div>
	<div style="margin: 2rem auto; width: 900px;">

		<c:forEach items="${reviewList}" var="review">
			<div class="review_container">


				<div class="sub_container">
					<p>${review.rating}</p>
					<h5>${review.user.username}</h5>
				</div>

				<p>${review.textBody}</p>

				<div class="edit_button_spacer">
					<c:choose>
						<c:when test="${review.user.email == currentUser.email}">
							<a
								href="/caseStudy/drones/${currentDrone.droneId}/review/${review.rId}/edit">Edit</a>
						</c:when>
					</c:choose>
				</div>

			</div>
		</c:forEach>

	</div>

</body>
</html>