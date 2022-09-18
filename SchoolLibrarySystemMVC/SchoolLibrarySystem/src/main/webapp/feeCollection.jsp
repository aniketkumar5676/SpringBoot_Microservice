<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fee Collection</title>
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


	<form class="booking-page" action="fee_collection">
		<h3 style="color: Tomato; text-align: center">Student Library
			Management</h3>
		<h4 style="color: #ff0000; text-align: center">Fee Collection
			Center</h4>
		<%=request.getAttribute("id")%><br>
		<br> <label>Enter Fee:&emsp;<input required type="text"
			name="fee"></label> <br>
		<br> <input value="Pay Fee" type="submit"> <br>
		<br>
	</form>

</body>
</html>