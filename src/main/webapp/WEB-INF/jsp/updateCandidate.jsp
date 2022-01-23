<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<script type="text/javascript">
	$(document).ready(function() {

		if ('${modelAttribute.asm1}' === 'true') {

			$('#checkbox1').attr('checked', 'checked');

		}

		if ('${modelAttribute.asm2}' === 'true') {

			$('#checkbox2').attr('checked', 'checked');

		}

		if ('${modelAttribute.asm3}' === 'true') {

			$('#checkbox3').attr('checked', 'checked');

		}

	});
</script>

<!--  

 <script> 

        let inputCandidateId = $("candidateId"); 

        let inputCandidateName = $("candidateName"); 

        let inputDomain = $("domain"); 

        let inputExperience = $("experience"); 

         

/*         let inputCandidateId = ${candidateId}; 

        let inputCandidateName =  ${candidateName}; 

        let inputDomain = ${domain}; 

        let inputExperience = ${experience}; */ 

   

        function setVal() { 

        	inputCandidateId.value = ${candidateId}; 

            inputCandidateName.value = '${candidateName}'; 

            inputDomain.value = '${domain}'; 

            inputExperience.value = '${experience}'; 

 			console.log("Candidate Id is ", '${candidateId}'); 

        } 

       /*  setVal(); */ 

    </script> 

 -->



<script>
	function myFun() {

		console.log('My fun is called');

		let inputCandidateId = $("candidateId").val();

		let inputCandidateName = $("candidateName").val();

		let inputDomain = $("domain").val();

		let inputExperience = $("experience").val();

		let check1 = false;

		let check2 = false;

		let check3 = false;

		if ($('#check1').is(":checked")) {

			check1 = true;

		}

		if ($('#check2').is(":checked")) {

			check2 = true;

		}

		if ($('#check3').is(":checked")) {

			check3 = true;

		}

		const params = {

			'candidateId' : inputCandidateId,

			'candidateName' : inputCandidateName,

			'domain' : inputDomain,

			'experience' : inputExperience,

			'asm1' : check1,

			'asm2' : check2,

			'asm3' : check3

		};

		/* 		const map = new Map(Object.entries(params)); 

		 */

		return $.ajax({

			'headers' : {

				'Accept' : 'application/json',

				'Content-Type' : 'application/json'

			},

			'url' : '/updateCandidate',

			'data' : JSON.stringify(params),

			'type' : "post",

			'dataType' : 'json'

		});

	}
</script>


<div class="bg-image shadow-2-strong">

	<div style="width: 40%; padding-left: 20px;">
	
		<!-- to get the value of model attribute in jQuery -->
		<input type="hidden" id="modelAttr" name="modelAttr" value="${modelAttribute}"/>
		
		<br>

		<form action="/updateCandidate" method="post">

			<h4>Enter Candidate Details</h4>

			<br>

			<div class="form-group">

				<label>Candidate Id</label> <input type="text" name="candidateId"
					id="candidateId" style="margin-top: 10px;"
					class="rounded-btn form-control" readonly
					placeholder="Enter Candidate ID here" value="${modelAttribute.candidateId}"
					required="required">

			</div>

			<div class="form-group">

				<label>Candidate Name</label> <input type="text"
					name="candidateName" id="candidateName" style="margin-top: 10px;"
					class="rounded-btn form-control" readonly
					placeholder="Enter Candidate Name here" value="${modelAttribute.candidateName}"
					required="required">

			</div>

			<div class="form-group">

				<label>Domain</label> <input type="text" name="domain"
					style="margin-top: 10px;" id="domain"
					class="rounded-btn form-control" readonly
					placeholder="Enter Candidate Domain here" value="${modelAttribute.domain}"
					required="required">

			</div>

			<div class="form-group">

				<label>Experience</label> <input type="number"
					style="margin-top: 10px;" name="experience" id="experience"
					class="rounded-btn form-control" readonly maxlength="4"
					value="${modelAttribute.experience}" placeholder="Enter Candidate Experience here"
					required="required">

			</div>

			<div class="form-group">

				<label class="container"><input id="checkbox1"
					name="asm1" type="checkbox"><span class="checkmark"></span>
					   Assessment One 
				</label>

			</div>

			<div class="form-group">

				<label class="container"><input id="checkbox2"
					name="asm2" type="checkbox"> <span class="checkmark"></span>
					   Assessment Two
				</label>

			</div>

			<div class="form-group">

				<label class="container"><input id="checkbox3"
					name="asm3" type="checkbox"> <span class="checkmark"></span>
					 Assessment Three
				</label>

			</div>

			<br> <input type="submit" name="submit" value="Submit"
				style="width: 30%;"
				class="btn rounded-btn btn-secondary btn-block btn-sm"> <br />

			<h6 style="color: red">${msg}</h6>

		</form>

	</div>

</div>
