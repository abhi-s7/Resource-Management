<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Need to add the JSTL library -->

<%@taglib prefix="tile" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<!-- name="title" should be the same in tiles.xml -->

<title><tile:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/buttons/2.1.0/css/buttons.dataTables.min.css">
	
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Merienda+One">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
	
<script type="text/javascript" language="javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script type="text/javascript" language="javascript"
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	
	<script type="text/javascript" language="javascript"
	src="https://cdn.datatables.net/buttons/2.1.0/js/buttons.print.min.js"></script>

<script type="text/javascript" language="javascript"
	src="https://cdn.datatables.net/buttons/2.1.0/js/dataTables.buttons.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> 

	
<style>
body {
	color: rgb(37, 37, 37);
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
}

#intro {
	/* 	background: -webkit-linear-gradient(left, #023145, #04e07a); 

   height: 150vh; */
	
}

.rounded {
	border-radius: .50rem !important;

	/* border-radius: 25px; */
}

.rounded-btn {
	border-radius: .25rem !important;

	/* border-radius: 25px; */
}

.form-control {
	box-shadow: none;
	border-color: #ddd;
}

.form-control:focus {
	border-color: #4869d6;
}
</style>
	

</head>

<body>

	<div>

		<!-- this should be same as that of name used for header in tiles.xml -->

		<div style="background-color: #0cafa9">

			<tile:insertAttribute name="header" />

		</div>

		<div
			style="float: left; width: 15%; height: 780px; background-color: #bed8cf;">

			<tile:insertAttribute name="menu" />

		</div>

		<!-- body in "base" doesn't have value. It comes from home and contact -->

		<div
			style="float: left; width: 85%; height: 780px; background-color: #fff2f2;">

			<tile:insertAttribute name="body" />

		</div>

		<div style="clear: both">

			<tile:insertAttribute name="footer" />

		</div>

	</div>

</body>

</html>

