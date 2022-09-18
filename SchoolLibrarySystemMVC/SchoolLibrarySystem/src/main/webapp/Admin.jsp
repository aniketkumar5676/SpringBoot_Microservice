<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>


<style type="text/css">
.admin-page {
	font-family: "Roboto", sans-serif;
	margin: auto;
	border: 1px solid grey;
	border-radius: 15px 30px 30px 15px;
	padding: 10px;
	position: absolute;
	top: 10%;
	left: 20%;
	border-spacing: 15px;
	
}

.padding {
	padding: 25px;

}

</style>

</head>
<body>

	<div class="admin-page">
		<form class="padding" action="addbook">
			<h3 style="color: #000000; text-align: center;">Student Library
				Management</h3>
			<h4 style="color: #000000; text-align: center">Admin Panel</h4>

			<label style="color: #ff0000;">&emsp;&emsp;Issue Book to
				Student </label><br> <br> 
				<label>Student ID:&emsp;<input required type="text" name="studentid"></label> <br> <br> 
				<label>Student Name:&emsp;<input required type="text" name="student"></label> <br> <br>
				<label>Class:&emsp;<input required type="text" name="class"></label><br><br> 
				<label>Choose a Book: &emsp;</label>
				
				<select id="book" name="book">
				<option value="House of Mirth, Edith Wharton">House of Mirth, Edith Wharton</option>
				<option value="East of Eden, John Steinbeck">East of Eden,John Steinbeck</option>
				<option value="The Sun Also Rises, Ernest Hemingway">The Sun Also Rises, Ernest Hemingway</option>
				<option value="Vile Bodies, Evelyn Waugh">Vile Bodies,Evelyn Waugh</option>
				<option value="A Scanner Darkly, Philip K">A Scanner Darkly, Philip K</option>
				<option value="Moab is my Washpot,Stephen Fry">Moab is my Washpot,Stephen Fry</option>
				<option value="Crimson Spring,Navtej Sarna s">Crimson Spring,Navtej Sarna s</option>
				<option value="Lion of the Skies,Stephen Barker">Lion of the Skies,Stephen Barker</option>
				<option value="Dangerous Earth,Ellen Prager">Dangerous Earth,Ellen Prager</option>
				<option value="Hear Yourself,Prem Rawat">Hear Yourself,Prem	Rawat</option>
				<option value="Operation Khatma,Ashwini&RC Ganjoo">Operation Khatma,Ashwini&RC Ganjoo</option>

			</select> <br> <br> <label>Issue Date:&emsp;
			<input required type="date" name="issuedate"></label> <br> <br> 
			<label>Return Date:&emsp;<input required type="date" name="returndate">
			</label><br> <br> <input value="Issue Book" type="submit">

		</form>
		<br>
		<br>


		<form class="padding" action="studentfee">
			<label style="color: #ff0000;">&emsp;&emsp;Student Fee Collection </label> <br> <br> 
				<label>Student ID:&emsp;<input required	type="text" name="studentid2"></label><br><br> 
				<input value="Submit" type="submit"><br>
			<br> Record Availability :
			<%= request.getAttribute("status") %>
		</form>
	</div>

</body>
</html>