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

<title>Enter Grades</title>
</head>
<body>
<div class="container">
  <div class="jumbotron">
    <h1>Enter Grades</h1> 
    <p>Please enter your assignment and grades below and then press submit</p> 
  </div>
</div>

	<div class="container">
		<form class="form-horizontal" action = "EnterGrades" method = "post" srole="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="assignment">Assignment:</label>
				 <div class ="col-sm-3">
				 <input type="text" class="form-control col-sm-2" name="assignment" placeholder = "Enter Assignment">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="grade">Grade:</label> 
				<div class ="col-sm-3">
				<input type="number" min="0" max="100" class="form-control col-sm-2" name="grade" placeholder = "Enter Grade">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-20 col-sm-10">
					<button type="submit" value = "submit" class="btn btn-default" name="submit">Submit </button>
				</div>
			</div>
		</form>
		<form action = "History">
			<button  type= "submit" ref class="btn btn-default" name="history">History </button>
		</form>
	</div>
</body>
</html>