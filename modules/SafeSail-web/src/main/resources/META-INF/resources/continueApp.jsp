<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<portlet:actionURL name="continueApplication" var="continueApplicationURL" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.input-container input {
    border: none;
    box-sizing: border-box;
    outline: 0;
    padding: .75rem;
    position: relative;
    width: 100%;
}

input[type="date"]::-webkit-calendar-picker-indicator {
    background: transparent;
    bottom: 0;
    color: transparent;
    cursor: pointer;
    height: auto;
    left: 0;
    position: absolute;
    right: 0;
    top: 0;
    width: auto;
}

 input[type="date"]:not(:placeholder-shown):before {
    content: attr(placeholder);
    margin-right: 0.5em;
}

input[type="date"]:before,
input[type="date"]:valid:before {
    content: ""; 
}
   
  
.custom-error{
    color: red !important;
    font-size: 12px;
    font-weight: normal !important;
}

#Date {
    background: url(/documents/d/safe_sail/icon-feather-calendar);
    background-position: 96% center;
    background-repeat: no-repeat;
    background-size: 38px;
    background-size: 25px 40px;
}


.c-other-page-header a.c-continue-app {  
  display: none;
  } 

</style>
</head>
<body>
<section class="personal-detail">
	<form action="${continueApplicationURL}" method="post" id="Personaldetails">
		<div class="personal-detail-heading">
			<h1>Continue Application</h1>
		</div>
		
			<div class="col-lg-6">

				<input type="hidden" name="<portlet:namespace/>userId"
					value="${userId}">
				<div class="form-group">
					<label for="name">Quote ID</label> <input type="text"
						name="<portlet:namespace/>quoteIds"
						class="form-control" id="quoteId" 
						placeholder="Quote ID">
				<c:if test="${not empty quoteIdErrorMessage}">
            		<span class="custom-error" role="alert">
                		${quoteIdErrorMessage}
           			 </span>
           	
       			</c:if> 
						
				</div>
							
				<div class="form-group">
					<label for="Date">Date Of Birth</label> <input type="date"
						class="form-control datePickerImg" id="Date" 
						name="<portlet:namespace/>dob" aria-describedby="Date"
						placeholder="Please select the birthdate"
						onkeydown="javascript:preventInput(event);" >
						  <c:if test="${not empty dobErrorMessage}">
				            <span class="custom-error" role="alert">
				                ${dobErrorMessage}
				            </span>
        				</c:if>
				</div>
				
				<%--  <c:if test="${not empty errorMessage}">
					<div class="custom-error" role="alert">
			  				${errorMessage}
					</div>
					
				</c:if>  --%>
				

		
</div>
		
		<div class="form-btn-wrapper">
			<button type="submit" id="submitBtn" class="c-btn primary-btn-wrapper">Submit</button>
			<div class="product-download">

			</div>
		</div>

	</form>
</section>

<script>


$('#Date').click(function() {
    var todayDate = new Date();
    var month = todayDate.getMonth() + 1; //04 - current month
    var year = todayDate.getUTCFullYear(); //2023 - current year
    var day = todayDate.getDate(); // 27 - current date 
    if (month < 10) {
        month = "0" + month.toString() //'0' + 4 = 04
    }

    if (day < 10) {
        day = "0" + day.toString();
    }
    var maxDate = year + "-" + month + "-" + day;

    $('#Date').attr('max', maxDate);
});

function preventInput(evnt) {
	evnt.preventDefault();
	}
	 
document.addEventListener("DOMContentLoaded", function() {
    var submitBtn = document.getElementById('submitBtn');
    
    submitBtn.addEventListener('click', function(event) {
       
        var errorElement = document.querySelector('.custom-error');

        if (errorElement) {
            event.preventDefault();
            console.log('Form submission blocked due to error.');
        } else {
            console.log('Form submitted successfully.');
            
        }
    });
});

setTimeout(function () {
    $(".custom-error").remove();
    }, 2000);



</script>
</body>
</html>