<%@ include file="/init.jsp" %>

<style>
.centerThisForm {
    max-width: 350px;
    margin: 30px auto;
}
</style>

<!-- form submition url -->
<portlet:actionURL name="saveDetails" var="saveDetailsUrls" />

<form action ="${saveDetailsUrls}" method="post" class="centerThisForm" id="verificationDetails">
<div class="row">
		 
	<div class="col-lg-6">
		<div class="form-group ">
			<label for="name">User Name</label>
				<input type="text" name="<portlet:namespace/>userName" id="name">
		</div>
		<div class="form-group ">
			<label for="name">Aadhaar Number</label>
				<input type="text" name="<portlet:namespace/>aadhaarNumber" id="aadhaarNumber" oninput="validateAadhar(event)">
		</div>	
		<div class="form-group ">
			<label for="name">Pan Number</label>
		 		<input type="text" name="<portlet:namespace/>panNumber" id="panNumber">
		</div>
		<div class="form-group ">
			<button type="submit" class="c-btn primary-btn-wrapper">Submit</button>
		</div>
	</div>
	
</div>

</form>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
	
<script>



//validation part

// name validation
 $('#name').on('keypress', function (e) {
       
     var name = $(this).val();
     name = name.charAt(0).toUpperCase()+name.slice(1);
     $(this).val(name);
     
     if (name.length === 0 && e.key === ' ') {
         e.preventDefault();
     }if (/^[0-9.!@?#"$%&:';()*\+,\/;\-=[\\\]\^_{|}<>~`]+$/.test(e.key)) {
         e.preventDefault();
     }
});

//pannumber validation
 $('#panNumber').on('input', function (e) {
	    var panNumber = $(this).val().toUpperCase();
	    
	    panNumber = panNumber.replace(/[^A-Z0-9]/g, '');

	    var firstFiveAlphabets = panNumber.substring(0, 5).replace(/[^A-Z]/g, '');
	    var nextFourNumbers = panNumber.substring(5, 9).replace(/[^0-9]/g, '');
	    var lastAlphabet = panNumber.charAt(9).replace(/[^A-Z]/g, '');

	    var formattedPanNumber = firstFiveAlphabets + nextFourNumbers + lastAlphabet;

	    $(this).val(formattedPanNumber);
});

//aadhaar validation
 function validateAadhar(event) {
      var cleanedValue = event.target.value.replace(/\s/g, '');
      cleanedValue = cleanedValue.replace(/\D/g, '');
      cleanedValue = cleanedValue.replace(/(\d{4})(?=\d)/g, '$1 ');
      cleanedValue = cleanedValue.substring(0, 14);

      event.target.value = cleanedValue;
 }
 $('#aadhaarNumber').keypress(function(e) {
     var currentLength = $('#aadhaarNumber').val().replace(/\s/g, '').length;

     // Allow spaces only after every 4 numeric characters
     if (currentLength > 0 && currentLength % 4 === 0 && (e.which >= 48 && e.which <= 57)) {
         $('#aadhaarNumber').val($('#aadhaarNumber').val() + " ");
     }

     // Allow only numeric characters and spaces
     var allowedChars = [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 32];
     if (!(allowedChars.indexOf(e.which) >= 0)) {
         e.preventDefault();
     }
 }); 
	
   
jQuery.validator.addMethod("aadhaar_rule", function (value, element) {
	   var cleanedValue = value.replace(/\s/g, '');
	    return this.optional(element) || /^\d{12}$/.test(cleanedValue);
}, ); 

jQuery.validator.addMethod('name_rule',
            function(value, element) {
                if (/^[a-zA-Z][a-zA-Z ]*$/.test(value)) {
                    return true;
                } else {
                    return false;
                }
                ;
});
jQuery.validator.addMethod('panNumber_rule', function(value,
        element) {
    if (/[A-Z]{5}[0-9]{4}[A-Z]{1}$/.test(value)) {
        return true;
    } else {
        return false;
    }
});


 $('#verificationDetails').validate({
	 
     onfocusout : function(element) {
         this.element(element);
     },
     rules : {
         "<portlet:namespace />userName" : {
             required : true,
             name_rule : true
         },
         
        "<portlet:namespace/>aadhaarNumber": {
             required: true,
              aadhaar_rule: true 
         },
         
       
         "<portlet:namespace/>panNumber" : {
             required : true,
             panNumber_rule : true
         }
        
     },
     messages : {
         "<portlet:namespace />userName" : {
             required : "User Name required",
             name_rule : "Only letters are required"

         },
       
         "<portlet:namespace/>aadhaarNumber": {
       	  required: "Aadhaar Number required",
       	 aadhaar_rule:"Please enter a valid aadhaar format" 
         },
         
 
         "<portlet:namespace />panNumber" : {

             required : 'Pan Number required',
             panNumber_rule : 'Please enter a valid pancard number'
         }
     },
     submitHandler : function(form) {
   		  form.submit();
   	  }
     
 });


</script>