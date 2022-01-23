<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<style>
div.dataTables_wrapper {
	padding-left: 15%;
	padding-right: 15%;
}

th {
	background-color: #343a40;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

#radiusOfBox {
	border-radius: 10px;
}
</style>



<script type="text/javascript">
	$(document).ready(function() {

		console.log('inside viewAll2');

		var data = eval('${candidateList}');

		var table = $('#table').DataTable({

			"aaData" : data,

			"dom" : 'Bfrtip',

			buttons : [
				'print', 'excel', 'pdf'
			],

			"aoColumns" : [ {

				"mData" : "candidateId"

			}, {

				"mData" : "candidateName"

			}, {

				"mData" : "domain"

			}, {

				"mData" : "experience"

			}, {

				"mData" : "asm1",
				"render": function(data) {
					if(data){
						return "Completed";
					} else {
						return "-";
					}
				}

			}, {

				"mData" : "asm2",
				"render": function(data) {
					if(data){
						return "Completed";
					} else {
						return "-";
					}
				}

			}, {

				"mData" : "asm3",
				"render": function(data) {
					if(data){
						return "Completed";
					} else {
						return "-";
					}
				}

			} ]

		});

	});
</script>

<div>

	<div class="ml-4 mr-4 pt-4 pl-2 pr-2 pb-2" style="height: 100%;">

		<div class="row mb-4">

			<div class="mx-auto text-center">

				<h1 class="display-6">Transaction History</h1>

			</div>

		</div>

		<div class="mx-auto text-center active pt-3 pl-4 pr-4">

			<h1 style="color: red">${msg}</h1>

			<table id="table" class="table display" cellspacing="0" style="width: 100%">

				<thead>

					<tr>

						<th>Candidate Id</th>

						<th>Candidate Name</th>

						<th>Domain</th>

						<th>Experience</th>

						<th>Assessment 1</th>

						<th>Assessment 2</th>

						<th>Assessment 3</th>

					</tr>

				</thead>

			</table>

		</div>

	</div>

</div>
