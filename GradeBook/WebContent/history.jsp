<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>History</title>
</head>
<body>
	<div class="container">
		<h2>Assignment History</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Assignment</th>
					<th>Grade</th>
				</tr>
			</thead>
			<tbody>${history}
			</tbody>
		</table>
		<form action="Average">
			<button type="submit" ref class="btn btn-default" name="average">Average
			</button>
		</form>
	</div>
</body>
</html>