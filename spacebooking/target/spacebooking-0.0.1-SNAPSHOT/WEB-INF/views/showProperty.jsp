<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Properties List</title>
</head>
<body>
	<h3>Properties List</h3>
	<c:url var="bookProperty" value="/property/booking"></c:url>
	<c:url var="listProperty" value="/listProperty"></c:url>
	<c:url var="showProperty" value="/showProperty"></c:url>
<c:url var="image" value="/resources/Desert.jpg"></c:url>
	
	<c:if test="${!empty propertyList}">
		<table class="tg" border="1">

			<c:forEach items="${propertyList}" var="property">
				<tr>
					<!-- <td>${property.id}</td> -->
					<td><h2>${property.propertyName}</h2></td>
					<td>${property.accomodationSize}</td>
				</tr>
				<tr>
					<!-- <td>${property.categoryId}</td> -->
					<td>${property.contactEmail}</td>
				</tr>
				<tr>
					<td>${property.contactName}</td>
					<td>${property.contactNo}</td>
				</tr>
				<tr>
					<!-- <td>${property.imageFolder}</td> -->
					<td>${property.location}</td>
				</tr>
				<tr>
					<td>${property.propertyArea}</td>
					<td>${property.propertyDesc}</td>
				</tr>
				<tr>
					<!--	<td>${property.propertyId}</td>
					<td>${property.propertyName}</td>-->
				</tr>
				<tr>
					<td><img src="${image}" /></td>
					<td><a href="${bookProperty}/${property.propertyId}">Book
							Now</a></td>
				</tr> 
				
			</c:forEach>
		</table>
	</c:if>
</body>
</html>