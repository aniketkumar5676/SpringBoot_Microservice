<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Confirmed</title>

<style type="text/css">
.booking-page {
	font-family: "Roboto", sans-serif;
	margin: auto;
	border: 1px solid grey;
	border-radius: 15px 30px 30px 15px;
	padding: 10px;
	position: absolute;
	top: 10%;
	left: 30%;
}
</style>


</head>
<body>



	<form class="booking-page" action="backToAdmin">
		<h3 style="color: Tomato; text-align: center">Student Library
			Management</h3>
		<h4 style="color: #ff0000; text-align: center">Book issued
			successfully</h4>
		Student Id =
		<%=request.getAttribute("id")%><br> Student Name =
		<%=request.getAttribute("name")%><br> Student Class=
		<%=request.getAttribute("classname")%><br> Issued Book =
		<%=request.getAttribute("book")%><br> Issue Date =
		<%=request.getAttribute("issuedate")%><br> Return Date =
		<%=request.getAttribute("returndate")%><br> <br> <input
			value="Back" type="submit">
	</form>


</body>
</html>