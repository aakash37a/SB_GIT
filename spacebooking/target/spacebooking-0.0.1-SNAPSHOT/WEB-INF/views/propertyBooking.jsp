<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Property Booking</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#getAvailability').click(function(e) {
			var data = {};
			data["propertyId"] = document.getElementById("propertyId").value;
			data["startDate"] = document.getElementById("datepicker1").value;
			data["endDate"] = document.getElementById("datepicker2").value;
			//alert(JSON.stringify(data));
			$.ajax({
				//contentType : 'application/json; charset=utf-8',
				type : 'GET',
				url : "getAvailability",
				//dataType : 'json',
				data : data,
				success : function(callback) {
					//alert(callback);
					$('#ava').html(callback);
					/*  $(this).html("Success!"); */
				},
				error : function() {
					/* $(this).html("Error!"); */
				}
			});
		});
	});
</script>



<script>
	$(function() {
		$("#datepicker1").datepicker({
			format : 'DD-MM-YYYY',
			minDate : new Date,
			showOn: "button",
			onSelect : function(dateStr) {

				var minimumDays = "${daysList[0]}";
				//alert("${daysRateMap}");
				var list = ${daysList};

				var maxDays = 0;
				$.each(list, function(index, value) {
					maxDays = value;
				});

				var d1 = $.datepicker.parseDate('mm/dd/yy', dateStr);
				d1.setDate(d1.getDate() + parseInt(minimumDays) - 1); // Add three days...

				var d2 = $.datepicker.parseDate('mm/dd/yy', dateStr);
				d2.setDate(d2.getDate() + parseInt(maxDays) - 1); // Add three days...

				$("#datepicker2").datepicker("option", "minDate", d1);
				$("#datepicker2").datepicker("option", "maxDate", d2);
			}

		});
		$("#datepicker2").datepicker({
			format : 'DD-MM-YYYY',
			showOn: "button"
		});

	});

	function doAjaxPost() {
		// get the form values
		var startDate = $('#datepicker1').val();
		var endDate = $('#datepicker2').val();
		//propertyid
		//send request to ajax function to get rate...
		
		
		/* $.ajax({
			type : "POST",
			url : "/AjaxWithSpringMVC2Annotations/AddUser.htm",
			data : "name=" + name + "&education=" + education,
			success : function(response) {
				// we have the response
				$('#info').html(response);
				$('#name').val('');
				$('#education').val('');
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		}); */
	}
</script>




<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<c:url var="bookProperty" value="/property/booking"></c:url>

	<form:form action="${bookProperty}/${propertyBooking.propertyId}"
		commandName="propertyBooking" method="post">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>PROPERTY NAME</td>
			</tr>
			<tr>
				<td><form:label path="startDate">
						<spring:message text="START DATE" />
					</form:label></td>
				<td><form:input id="datepicker1" path="startDate"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="endDate">
						<spring:message text="END DATE" />
					</form:label></td>
				<td><form:input id="datepicker2" path="endDate"
						readonly="true" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" id="getAvailability"
					value="Check Availability" /><br />
					<p id="ava" class="ava"></p></td>
			</tr>
			<tr>
				<td><form:label path="name">
						<spring:message text="NAME" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="emailID">
						<spring:message text="EMAIL" />
					</form:label></td>
				<td><form:input path="emailID" /></td>
			</tr>


			<tr>
				<td><form:label path="mobile">
						<spring:message text="MOBILE" />
					</form:label></td>
				<td><form:input path="mobile" /></td>
			</tr>

			<tr>
				<td><form:label path="panNo">
						<spring:message text="PAN NO" />
					</form:label></td>
				<td><form:input path="panNo" /></td>
			</tr>

			<tr>
				<!-- 	<td><form:label path="propertyId">
						<spring:message text="PROPERTY ID" />
				</form:label></td> 
				<td><form:input path="propertyId" readonly="true" size="8"
						disabled="true" />  -->
				<td>
				<form:hidden path="propertyId" />
				</td>
			</tr>

			<tr>
				<td><form:label path="aadhaarNo">
						<spring:message text="AADHAR NO" />
					</form:label></td>
				<td><form:input path="aadhaarNo" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message text="ADDRESS" />
					</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="pin">
						<spring:message text="PIN CODE" />
					</form:label></td>
				<td><form:input path="pin" /></td>
			</tr>

			<tr>
				<td><form:label path="state">
						<spring:message text="STATE" />
					</form:label></td>
				<td><form:input path="state" /></td>
			</tr>
			<!-- <tr>
				<td><form:label path="bookingID">
						<spring:message text="BOOKING ID" />
					</form:label></td>
				<td><form:input path="bookingID" /></td>
			</tr> -->
			<!--  <tr>
				<td><form:label path="categoryId">
						<spring:message text="Property Category" />
					</form:label></td>
				<td><form:select path="categoryId">
						<option value="Select" label="Select a card type"></option>
						<c:forEach var="category" items="${propertyCategories}">
							<option value="${category.categoryName}"
								label="${category.categoryName}" />
						</c:forEach>
					</form:select></td>
			</tr> 
			<tr>
				<td>Select no of Days</td>

				<td><form:select path="days" items="${daysList}">
					</form:select></td>
			</tr>
-->

			<!-- <tr>
				<td><form:label path="status">
						<spring:message text="STATUS" />
					</form:label></td>
				<td><form:input path="status" /></td>
			</tr>
			<tr>
				<td><form:label path="subcategoryId">
						<spring:message text="SUBCATEGORY ID" />
					</form:label></td>
				<td><form:input path="subcategoryId" /></td>
			</tr> -->
			<!-- <tr>
				<td><form:label path="totalAmt">
						<spring:message text="TOTAL AMOUNT" />
					</form:label></td>
				<td><form:input path="totalAmt" /></td>
			</tr>-->
			<tr>
				<td><input type="submit" value="BOOK PROPERTY" onclick="doAjaxPost()"/></td>
			</tr>
		</table>



	</form:form>
</body>
</html>