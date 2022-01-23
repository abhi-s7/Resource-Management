<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div>

	<div class="ml-4 mr-4 pt-4 pl-2 pr-2 pb-2" style="height: 100%;">

		<div class="row mb-4">

			<div class="mx-auto text-center">

				<h1 class="display-6">Candidate Details</h1>

			</div>

		</div>

		<div class="mx-auto text-center active pt-3 pl-4 pr-4">

			<h1 style="color: red">${msg}</h1>



			<form role="form" method="POST" action="/fetchCandidate">

				<div class="form-group">

					<div class="col-7 mx-auto text-center">

						<input type="text" name="candidateId" id="candidateId"
							placeholder="Enter Candidate Id here" required
							class="form-control form-control-sm">

					</div>

				</div>

				<button type="submit" class="subscribe btn btn-secondary"
					style="background-color: #5cb85c;">Submit</button>

			</form>

		</div>

	</div>

</div>
