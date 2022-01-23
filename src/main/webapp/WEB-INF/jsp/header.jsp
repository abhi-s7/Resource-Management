<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-expand-lg navbar-dark bg">

	<div class="container-fluid">

		<a class="navbar-brand" href="#">Resource Management Tool</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">

			<span class="navbar-toggler-icon"></span>

		</button>

	</div>

	<form class="d-flex" style="float: right" action="/logout"
		method="POST">

		<button class="btn btn-outline-light" type="submit">Logout</button>

	</form>

</nav>
