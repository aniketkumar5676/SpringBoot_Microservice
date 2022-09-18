<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fee Status</title>
<style type="text/css">
.fee_status {
	font-family: "Roboto", sans-serif;
	margin: auto;
	border: 1px solid green;
	border-radius: 15px 30px 30px 15px;
	padding: 10px;
	position: absolute;
	top: 10%;
	left: 30%;
}
</style>
</head>
<body>

	<form class="fee_status" action="backToAdmin">
		<h4 style="color: green;">&emsp;Status of Collection :</h4>
		<%=request.getAttribute("status")%><br>
		<br> <input value="Back to Admin" type="submit">

	</form>


</body>
</html>