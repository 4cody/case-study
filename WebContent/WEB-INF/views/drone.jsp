<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${currentDrone.model}</title>
<spring:url value="/resources/css/drone_view.css" var="dvCss"/>
<link href="${dvCss}" rel="stylesheet" />
<spring:url value="/resources/images/${currentDrone.imageName}" var="imageSrc"/>

</head>
<body>

<%@include file="nav.html" %>
<div class="container">

   		<section class="drone_info_container">
            <div class="image_container">
               <img src="${imageSrc}" alt=""> 
            </div>

            <div class="drone_info" style="font-size: 1.4em;">
                <div>
                    <h2>Make:</h2>
                    <h2>${currentDrone.make}</h2>
                </div>
                <div>
                    <h2>Model:</h2>
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



<h3>Leave a <a href="./${currentDrone.droneId}/review/">review</a> on this drone</h3>

<div>

<c:forEach items="${reviewList}" var="review">
    <p>${review.textBody}</p><br/>
    <p>${review.rating}</p>
</c:forEach>

</div>

</body>
</html>