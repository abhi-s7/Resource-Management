<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="bg-image shadow-2-strong">

	<div style="width: 40%; padding-left: 20px;">

		<br>

		<form action="/addCandidate" method="post">

			<!-- <div class="avatar"><i class="material-icons">&#xE7FF;</i></div> -->



			<h4>Enter Candidate Details</h4>

			<br>

			<div class="form-group">

				<label>Candidate Id</label> <input type="text" name="candidateId"
					id="candidateId" style="margin-top: 10px;"
					class="rounded-btn form-control"
					placeholder="Enter Candidate ID here" required="required">

			</div>

			<div class="form-group">

				<label>Candidate Name</label> <input type="text"
					name="candidateName" id="candidateName" style="margin-top: 10px;"
					class="rounded-btn form-control"
					placeholder="Enter Candidate Name here" required="required">

			</div>

			<div class="form-group">

				<label>Domain</label> <input type="text" name="domain"
					style="margin-top: 10px;" id="domain"
					class="rounded-btn form-control"
					placeholder="Enter Candidate Domain here" required="required">

			</div>

			<div class="form-group">

				<label>Experience</label> <input type="number"
					style="margin-top: 10px;" name="experience" id="experience"
					class="rounded-btn form-control" maxlength="4"
					placeholder="Enter Candidate Experience here" required="required">

			</div>

			<br> <input type="submit" name="submit" value="Submit"
				style="width: 30%;"
				class="btn rounded-btn btn-secondary btn-block btn-sm"> <br />

			<h6 style="color: red">${msg}</h6>

		</form>



	</div>

</div>

