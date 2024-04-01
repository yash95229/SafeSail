<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	      <%@ include file="/init.jsp" %>
	      <%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<c:set var = "signedIn" scope = "session" value = "${themeDisplay.isSignedIn()}"/>


<link rel="stylesheet" href="somedetails.css">
<style>

.c-other-page-header a.c-continue-app {  
  display: none;
  } 
  .changingSpan{

    font-weight: normal !important;
    display: inline;
    
}

.custom-error-pan{
color: red !important;
    font-size: 12px;
    font-weight: normal !important;
}
.custom-error-email{
color: red !important;
    font-size: 12px;
    font-weight: normal !important;
}
 .verification-success {
        color: green !important;
         font-size: 12px;
          font-weight: normal !important;
     
    }

</style>
</head>
<body>

	
<!-- pan verification for same eamil url -->
<portlet:resourceURL id="checkPanVerify" var="checkPanVerifyURL"></portlet:resourceURL>


<!-- email validation for same eamil url -->
<portlet:resourceURL id="checkEmailValidation" var="checkEmailValidationURL"></portlet:resourceURL>

	<section class="some-details-about">
		<div class="main-wrapper">
			
			<input type="hidden" name= "<portlet:namespace/>quoteId" class="form-control " id="quoteId"  value="${quoteId}">
			<input type="hidden" name="<portlet:namespace/>applicationNo" id="applicationNo"  value="${applicationNo}">
			<input type="hidden" name="<portlet:namespace/>totalAddon" id="totalAddon" value="${totalAddon}">
			<input type="hidden" name="<portlet:namespace/>fullname" id="fullname" value="${fullname}">
				
				
				<div class="page-heading">
					<h2>Some details about you</h2>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
						
						
							<label for="name">Name</label> <input type="text"
							onblur="submitFirstname()"	class="form-control " id="name" name="<portlet:namespace/>fullName"  value="${form.fullname}"
								placeholder="Sameer Jain" >
								<span style="display: none; color: red !important; font-size: 12px; font-weight: normal !important; " id="firstnameError">Full name required</span>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label for="panNumber">PAN Number</label> <input type="text"
							onblur="submitPan()"	class="form-control " name="<portlet:namespace/>panNumber" value="${form.panNumber }" id="panNumber"
								placeholder="ABCPA4848Q" >
						<span style="display: none; color: red !important; font-size: 12px; font-weight: normal !important; " id="panError">Please enter panNumber with valid format</span>
	
						</div>
					</div>
					
					<div class="col-lg-6">
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								onblur="submitEmail()" class="form-control " id="email" name="<portlet:namespace/>email" value="${form.emailAddress}"
								placeholder="test@test.com" >
							<span style="display: none; color: red !important; font-size: 12px; font-weight: normal !important; " id="emailError">Please enter email with valid format</span>
	
						</div>

					</div>
					
					<div class="col-lg-6">
						<div class="form-group">
							<label for="mobileNumber">Mobile Number</label> <input type="tel"
								class="form-control " id="mobileNumber" maxlength="10" name="<portlet:namespace/>number" value="${form.phoneNo}" onblur="submitPhone()" 
								placeholder="9898989898" >
							<span style="display: none; color: red !important; font-size: 12px; font-weight: normal !important; " id="phoneError">Mobile number is required</span>
						</div>
					</div>

				</div>
				
				
	<div class="agree-lines">
					<div class="instructions">
						<p>*You will not be able to edit mobile number and email after
							this page</p>
					</div>
					
		
		
				<div class="total-and-year">
					<!-- <h2>Final Premium</h2> -->
					<h2 >
					<span  class="changingSpan" style="text-indent: 10px;">Your Final Premium</span>
					<!-- <span style="text-indent: 10px;" class="p-0">&#8377;</span>  -->
							<fmt:formatNumber value = "${totalAddon}" type = "currency" currencySymbol="&#8377;"/> 
							<span  class="changingSpan" style="text-indent: 10px;">${paymentFreq}</span>
						</h2>					
				</div>
		
					
			<c:if test="${AgreementfieldShow == false}">
					<div class="agree-terms-wrapper">
						<div class="form-group">
		<!-- 							<input type="checkbox" id="javascript"> <label -->
		<!-- 								for="javascript">I agree to the terms and conditions.</label> -->
							<input type="checkbox" class="d-block invisible"  id="javascript" name="<portlet:namespace/>condition">
							<label for="javascript" class="form-label">I agree to the </label>
							<a class="errordata" role="button" data-target="#exampleModal" data-toggle="modal">Terms and Conditions.</a>
						
						</div>
						
					</div>
					
			</c:if>
	</div>
				
				<div class="buttons-row">
					<div class="buttons" id="rz-pay">
					<portlet:resourceURL id="saveOrderDetails" var="createOrder" ></portlet:resourceURL>
					<portlet:resourceURL id="successfull" var="createOrder1"></portlet:resourceURL>

<portlet:renderURL var="BackFinalButtonURl">
		<portlet:param name="mvcRenderCommandName" value="/termInsurances" />
		<portlet:param name="quoteId" value="${quoteId}" />
	</portlet:renderURL>
						<a class="c-btn secondary-btn-wrapper"href="${BackFinalButtonURl}">Back
						</a>
 <button class="c-btn primary-btn-wrapper" onclick="submitForm()" >Make Payment </button> 
	<!--  onclick="saveOrderDetails(event)" -->					
							
	
					</div>
					<div class="procced-form">
					<portlet:renderURL var="NextJourney">
		<portlet:param name="mvcRenderCommandName" value="/termInsurances" />
		<portlet:param name="quoteId" value="${quoteId}" />
	</portlet:renderURL>
	<!-- <a href="/documents/d/safe_sail/standard-certificate-of-insurance-template-free-download-1" target="_blank">Proceed To Form
							</a> -->
					</div>
				</div>
		
		</div>
	</section>
	

	      <div class="modal" id="exampleModal">
        <div class="modal-dialog modal-dialog-scrollable">
          <div class="modal-content">


            <!-- Modal Header -->
            <div class="modal-header">
              <h5 class="modal-title">Terms and Conditions</h5>
              <button type="button" class="close" data-dismiss="modal">×</button>
            </div>



            <!-- Modal body -->
            <div class="modal-body">
             <h3>Terms & Conditions</h3>
          <!--   <p>This website is designed, developed and maintained by Safe-Sail, wholly owned by Government of India.</p>
             <p>Though all efforts have been made to ensure the accuracy and currency of the content on this website, the same should not be construed as a statement of law or used for any legal purposes. Incase of any ambiguity or doubts, users are advised to verify/check with the Company and/or other source(s), and to obtain appropriate professional advice.</p>
            <p>Under no circumstances will this Company be liable for any expense, loss or damage including, without limitation, indirect or consequential loss or damage, or any expense, loss or damage whatsoever arising from use, or loss of use, of data, arising out of or in connection with the use of this website.</p>
            <p>These terms and conditions shall be governed by and construed in accordance with the Indian Laws and terms and conditions which will be laid down from time to time. Any dispute arising under these terms and conditions shall be subject to the jurisdiction of the courts of India.</p>
           -->  
               <c:forEach var="entry" items ="${fieldConfigurationAgreement}"> 
           	<c:out value = " ${entry.fieldData}"/> 
             </c:forEach>
           
           </div>


            
            <!-- Modal footer -->
            <div class="modal-footer">
            <button type="button" class="button-same c-btn primary-btn-wrapper acceptBtn" data-dismiss="modal">Accept</button>
              <button type="button" class="button-same c-btn secondary-btn-wrapper" data-dismiss="modal">Cancel</button>
            </div>
            
          </div>
        </div>
      </div>
 
</body>
</html>





<script src = "https://checkout.razorpay.com/v1/checkout.js"> </script>
	<script>
	
	
	
	$(".c-other-page-header").prepend('<p class="c-continue-app">Quote ID : ${quoteId}</p>')


		/* let quoteId=$("<portlet:namespace/>quoteId").val();
		let applicationNo=$("<portlet:namespace/>applicationNo").val(); */
		
		let quoteId=$("#quoteId").val();
		let applicationNo = $("#applicationNo").val();
		let totalAddon=$("#totalAddon").val();
		
	
		
		    let email = $("#email").val();
		    let mobileNumber = $("#mobileNumber").val();
		    let panNumber = $("#panNumber").val();
		    let fullName = $("#name").val();

		    
		    $("#name").on("blur", function() {
		        fullName = $(this).val();
		        console.log("Name changed to: " + fullName);
		        
		    });

		    
		    $("#email").on("blur", function() {
		        email = $(this).val();
		        console.log("Email changed to: " + email);
		    
		    });

		    
		    $("#panNumber").on("blur", function() {
		        panNumber = $(this).val();
		        console.log("PAN Number changed to: " + panNumber);
		        // You can perform additional actions or validations here
		    });

		    // Event listener for blur on the "Mobile Number" input
		    $("#mobileNumber").on("blur", function() {
		        mobileNumber = $(this).val();
		        console.log("Mobile Number changed to: " + mobileNumber);
		        // You can perform additional actions or validations here
		    });

		  

		
		
		$(".modal-footer .btn-primary").click(function(){
			$("#javascript").prop("checked", true);

		});
		
		 $("#javascript").change(function(){
			if($("#javascript").prop("checked")){
				 $("#remove-error").remove();
			}else{
				 
				 $(".agree-terms-wrapper .form-group").append('<div id="remove-error" class="error">Terms and Condition are Required*</div>');
				}
		});
		 
		 $("#rz-pay button").click(function(e) {
			 $("#remove-error").remove();
			 if($("#javascript").prop("checked")){
				
				 saveOrderDetails(e);
			 }else{
				 
				 $(".agree-terms-wrapper .form-group").append('<div id="remove-error" class="error">Terms and Condition are Required*</div>');
			 		
				 e.preventDefault();
				
			 }
			 
 		
		}); 
		function saveOrderDetails(e){
			
			  $.ajax({
		            type: "POST",
		            async: false,
		            url: "${createOrder}",
		            data:{
		            	quoteId:quoteId,
		            	applicationNo:applicationNo,
		            	totalAddon:totalAddon,
		            	<portlet:namespace/>fullName:fullName,
		            	<portlet:namespace/>email:email,
		            	<portlet:namespace/>number:mobileNumber,
		            	<portlet:namespace/>panNumber:panNumber,
		    	       },
		            dataType: "json",
		            success: function(data) {
		            	console.log(data);
		            	var options = razorPayPaymentProcess(data.orderId,applicationNo,totalAddon);
		            	var rzp1 = new Razorpay(options);
		            	rzp1.open();
						e.preventDefault();
		          
		            },error: function(jqXHR, textStatus, errorThrown){
		                 console.log("Something thing went wrong please try again " + textStatus);
		            }
		            
		          });
		}

		function razorPayPaymentProcess(orderId,applicationNo,totalAddon){
			console.log("this is inside razorPayPaymentProcess function method totalAddon___________________________________________ "+totalAddon);
			var options = {
					"key": "rzp_test_BGKF66W3loTH0T",
					 "amount": totalAddon*100,
					  "currency": "INR",
					"name": "SafeSail",
					   "description": "test payment testtttt",
					"order_id": orderId,
					   "handler": function (response) {
						   console.log(response);
						   succesMethod(response,applicationNo);
						
						   window.location.href="/web/safe_sail/my-policies" 
					},
					   "prefill": {       
						"name": "SafeSail",
						"email": "safesailteam@gmail.com",
						"contact": "9662662355"   
					},
					   "notes": {       
						"address": "Phase-III, C-35A B DEF, Eldeco Sidcul Industrial Park, Sitarganj, Udham Singh Nagar, Uttarakhand, 262405"   
					},
					   "theme": {       
						"color": "#3399cc"   
					}
				};
			return options;
		}

		function succesMethod(response,applicationNo){
			let orderId=response.razorpay_order_id;
			let paymentId=response.razorpay_payment_id;

			let signature=response.razorpay_signature;

			  $.ajax({
		            type: "POST",
		            async: false,
		            url: "${createOrder1}",
		            data:{
		            	<portlet:namespace/>orderId:orderId,
		            	<portlet:namespace/>paymentId:paymentId,
		            	<portlet:namespace/>signature:signature,
		            	<portlet:namespace/>applicationNo:applicationNo,
		    	       },
		            dataType: "json",
		            success: function(data) {
		            	console.log(data);
		            	
		          
		            },error: function(jqXHR, textStatus, errorThrown){
		                 console.log("Something went wrong please try again " + textStatus);
		            }
		            
		          });
		}

		
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
		
		 function submitFirstname() {

			var firstName = document.getElementById("name");
			var firstnameError = document.getElementById("firstnameError");

			if (firstName.value == "") {
					firstnameError.style.display = "";
					return false;
				} else {
					firstnameError.style.display = "none";
					return true;
				}

			}
		 
		 
		// email validation
		
		 function submitEmail() {

		
			 var email = $("#email").val();
	  			var flag = "email";
	  			
	  			
	  			$.ajax({
	  			type: "GET",
	  			async: false,
	  			url: "${checkEmailValidationURL}",
	  			data: {
	  			    '<portlet:namespace/>email': email,
	  			    '<portlet:namespace/>flag': flag,
	  			},
	  			dataType: "json",
	  			success: function (data) {
	  			    if (data.length != 0) {
	  			        $(".checkemail").remove();
	  			        $(".checkemailsuccess").remove();
	  			        s = '<div class="custom-error-email">Email already there</div>';
	  			        $("#email").after(s); 
	  			        isEmailValid = false;
	  			    } else {
	  			         $(".checkemail").remove();
	  			        $(".checkemailsuccess").remove();
	  	 		        $(".custom-error-email").remove();
	  			        
	  			        isEmailValid = true;
	  			    }
	  			},
	  			error: function (jqXHR, textStatus, errorThrown) {
	  			    console.log("try again " + textStatus);
	  			}
	  			
	  			});
	  			
	  			
	  			
  			
  			
		 	var email = document.getElementById("email");
		 	var emailError = document.getElementById("emailError");
		 	const regex =
		 		/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

		 	if (!email.value.match(regex)) {
		 		emailError.style.display = "";
		 		return false;
		 	} else {
		 		emailError.style.display = "none";
		 		return true;
		 	}

		 }
		
	
  
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
    	 function submitPan() {
    		 
    	
    		  if($("#panNumber").val().trim().length == 10) {
    		 	var panNumber = $("#panNumber").val();
    		 	var fullName = $("#name").val();

    		 	$.ajax({
    		 		type: "GET",
    		 		async: false,
    		 		url: "${checkPanVerifyURL}",
    		 		data: {
    		 		    '<portlet:namespace/>panNumber': panNumber,
    		 		    '<portlet:namespace/>fullName' : fullName,
    		 		},
    		 		dataType: "json",
    		 		success: function (data) {
    		 		   console.log(data);
    		 		   if (data.isExist) {
    		 			  if(data.isValid){
    		  				  $(".custom-error-pan").remove();
    		 				  var successMessage ='<div class="verification-success"> Verified Successfully</div>';
    		 				  $("#panNumber").after(successMessage);
    		 				  setTimeout(function () {
    		 			        $(".verification-success").remove();
    		 				    }, 2000);	
    		 				  isPanValid = true;
    		 				  
    		 			  }else{
    		 			        $(".verification-success").remove();
    		 			        s= '<div class="custom-error-pan">Verification Failed</div>';
    		 				 $("#panNumber").after(s);
    		 				 isPanValid = false;
    		 			  }
    		 		  
    		 		   }else{
    		 			   $(".verification-success").remove();
    		 			  s= '<div class="custom-error-pan">Verification Failed</div>';  
    		 			  $("#panNumber").after(s);
    		 			  isPanValid = false;
    		 		   }
    		 		   
    		 		},
    		 		error: function (jqXHR, textStatus, errorThrown) {
    		 		    console.log("try again " + textStatus);
    		 		}
    		 		
    		 		});
    		 	}
    		 
    		 
      	 	var pan = document.getElementById("panNumber");
      	 	var panError = document.getElementById("panError");

			const regex = /[A-Z]{5}[0-9]{4}[A-Z]{1}$/;
      	 	
      	 	if (!pan.value.match(regex)) {
      	 		panError.style.display = "";
      	 		return false;
      	 	} else {
      	 		panError.style.display = "none";
      	 		return true;
      	 	}

      	 	
      	 }
  		
        
		
    		
 		//phonenumber validation
     	 $('#mobileNumber').keypress(function(e) {
               
               var arr = [];
               var n = e.which;
   
               for (i = 48; i < 58; i++)
                   arr.push(i);
   
               if (!(arr.indexOf(n) >= 0))
                   e.preventDefault();
           });
 		

     	 function submitPhone() {

     	 	var phone = document.getElementById("mobileNumber");
     	 	var phoneError = document.getElementById("phoneError");


     	 	if (phone.value.length < 10 || phone.value.length > 10) {
     	 		phoneError.style.display = "";
     	 		return false;
     	 	} else {
     	 		phoneError.style.display = "none";
     	 		return true;
     	 	}

     	 }
 		
		
		
    	 function submitForm() {

    			var returnval = true;

    			returnval &= submitFirstname();
    			returnval &= submitEmail();
    			returnval &= submitPhone();
    			returnval &= submitPan();
    			
    			return returnval ? true : false;

    		}
		
		
		
		$(document).ready(function(){

			$('.agree-terms-wrapper input:checkbox').change(function(){
			    if($(this).is(":checked")) {
			        $('.acceptBtn').addClass("d-none");
			    } else {
			        $('.acceptBtn').removeClass("d-none");
			    }
			});
			  

			$(".acceptBtn").on('click', function() {
			/* $(".agree-terms-wrapper input:checkbox").prop("checked", true);  */
			 $(".agree-terms-wrapper input").click();
			  if($('.agree-terms-wrapper input:checkbox').is(":checked")) {
			        $('.acceptBtn').addClass("d-none");
			    } else {
			        $('.acceptBtn').removeClass("d-none");
			    }
			});



			});
</script>