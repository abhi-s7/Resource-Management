<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<style>
body {
	color: #999;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
}

#intro {
	/*         background-image: url("https://ppg-prelaunch.customer-self-service.com/images/Orders%20&%20Returns%20Image.jpg?u=2YhL"); */
	background: -webkit-linear-gradient(left, #023145, #04e07a);

	/* height: 150vh; */
}

.rounded {
	border-radius: .50rem !important;

	/* border-radius: 25px; */
}

.box {
	width: 60%;
	padding: 10% 0;
	color: #434343;
	border-radius: 1px;
	background: whitesmoke;
	border: 1px solid #f3f3f3;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
</style>

<div>

	<div style="margin-top: 50%; margin-left: 20%;">

		<a href="/addCandidate">

			<div class="box rounded" style="text-align: center;">



				<h6 style="margin-bottom: 0%;">

					<b>Add</b>

				</h6>

			</div>

		</a> <br> <a href="/fetchCandidate">

			<div class="box rounded" style="text-align: center;">



				<h6 style="margin-bottom: 0%;">

					<b>Update</b>

				</h6>

			</div>

		</a> <br> <a href="/viewAll">

			<div class="box rounded" style="text-align: center;">



				<h6 style="margin-bottom: 0%;">

					<b>View All</b>

				</h6>

			</div>

		</a>

	</div>

</div>
