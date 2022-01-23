<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div id="intro" class="bg-image shadow-2-strong">

	<div style="width: 40%; padding-left: 20px;">

		<br>

		<form action="/register" method="post">

			<!-- <div class="avatar"><i class="material-icons">&#xE7FF;</i></div> -->



			<h4>Register to access CTS Resource Service</h4>

			<br>

			<div class="form-group">

				<label>Name</label> <input type="text" name="empName"
					style="margin-top: 10px;" id="empName"
					class="rounded-btn form-control" placeholder="Enter your name here"
					required="required">

			</div>

			<div class="form-group">

				<label>Employee Id</label> <input type="text" name="employeeId"
					style="margin-top: 10px;" id="employeeId"
					class="rounded-btn form-control"
					placeholder="Enter your Employee Id here" required="required">

			</div>

			<br>

			<div class="form-group">

				<label>Password</label> <input type="password"
					style="margin-top: 10px;" name="password" id="password"
					class="rounded-btn form-control"
					placeholder="Enter your password here" required="required">

			</div>

			<div class="form-group">

				<label>Confirm Password</label> <input type="password"
					style="margin-top: 10px;" name="confirmPassword"
					id="confirmPassword" class="rounded-btn form-control"
					placeholder="Enter your password again" required="required">

			</div>

			<br> <input type="submit" name="submit" value="Submit"
				style="width: 30%;"
				class="btn rounded-btn btn-secondary btn-block btn-sm"
				value="Register"> <br />

			<h6 style="color: red">${msg}</h6>

		</form>



	</div>

</div>
