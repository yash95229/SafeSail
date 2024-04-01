
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.safesail.model.LifeInsurance"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<c:set var = "signedIn" scope = "session" value = "${themeDisplay.isSignedIn()}"/>
	
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
  

.custom-error-aadhar{
	color: red !important;
    font-size: 12px;
    font-weight: normal !important;
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

.symbol {
        margin-left: 5px;
        font-size: 20px;
    }

/* input[type=checkbox], input[type=radio] {
    display: BLOCK;
} */
.error {
	color: #15658D;
	font-weight: bold;
}

 /* .c-other-page-header a.c-continue-app {  
  display: none;
  }   */
#Date {
	background: url("/documents/d/safe_sail/icon-feather-calendar");
	background-position: 96% center;
	background-repeat: no-repeat;
	background-size: 38px;
	background-size: 25px 40px;
}
/* #annualImage{
  background:url("/documents/44045/0/Icon material-keyboard-arrow-down");
  background-position: 96% center;
  background-repeat: no-repeat;
  background-size: 38px;
  background-size: 16px 40px;
} */
#annualImage {
	background: url(/documents/d/safe_sail/drop-down) !important;
	appearance: none;
	background: transparent;
	background-repeat: no-repeat !important;
	background-position: center right 20px !important;
	background-size: 20px !important;
}

#exampleInputEmail1 {
	background: url("/documents/d/safe_sail/icon-feather-mail");
	background-position: 96% center;
	background-repeat: no-repeat;
	background-size: 38px;
	background-size: 25px 40px;
}

#number {
	background: url("/documents/d/safe_sail/icon-feather-phone-call");
	background-position: 96% center;
	background-repeat: no-repeat;
	background-size: 38px;
	background-size: 25px 40px;
}

.agree-terms-wrapper .form-group input:checked+div+label:after {
	content: '';
	display: block;
	position: absolute;
	top: 7px;
	left: 6px;
	width: 5px;
	height: 10px;
	border: 2px solid #ffffff;
	border-width: 0 2px 2px 0;
	transform: rotate(45deg);
}

.agree-terms-wrapper .form-group input:checked+div+label:before {
	background-color: #15658D;
	border: none;
}

.agree-terms-wrapper .error {
	position: absolute;
	bottom: -18px;
	left: 0;
}

.agree-terms-wrapper .form-group input {
	position: absolute;
	top: 0;
	left: 0;
}


.mobileNo91::before {justify-content: center;
    content: '+91 ';
    position: absolute;
    top: 42px;
    left: 0px;
    background: #ccd3df;
    width: 50px;
    height: 62px;
    display: flex;
    align-items: center;
    border-radius: 10px 0 0 10px;}
.mobileNo91 + input {padding-left: 65px;}
</style>

<!-- email validation for same eamil url -->
<portlet:resourceURL id="checkEmailValidation" var="checkEmailValidationURL"></portlet:resourceURL>
	
	

<!-- aadhar verification for same eamil url -->
<portlet:resourceURL id="checkAadharVerify" var="checkAadharVerifyURL"></portlet:resourceURL>

	
<!-- pan verification for same eamil url -->
<portlet:resourceURL id="checkPanVerify" var="checkPanVerifyURL"></portlet:resourceURL>


<!-- form submition url -->
<portlet:actionURL name="saveRegister" var="saveRegisterUrls" />

	
<section class="personal-detail">


<!-- addData -->

		<form action="${saveRegisterUrls}" method="post" id="Personaldetails">


	
		<div class="personal-detail-heading">
			<h1>Personal Details</h1>
		</div>
		<div class="row">
		 <c:if test="${fullNameFieldShow == false}"> 
			<div class="col-lg-6">

				<input type="hidden" name="<portlet:namespace/>userId"
					value="${userId}">
					<input type="hidden" name="<portlet:namespace/>quoteId" class="form-control " value="${quoteId}">
					
				<div class="form-group">
				
					<label for="name">Full Name</label> <input type="text"
						name="<portlet:namespace/>fullName" value="${fullName}"
						class="form-control" id="name" aria-describedby="emailHelp"
						placeholder="Name" 
						<c:if test="${fullName.length() gt 1}">readonly</c:if>>
				

				</div>
			</div>
			</c:if>
			
			<c:if test="${dateFieldShow == false}"> 
				<div class="col-lg-6">
				<div class="form-group">
					
					<label for="Date">Date of birth</label> <input type="date"
						class="form-control datePickerImg" id="Date" 
						name="<portlet:namespace/>dob" aria-describedby="Date"
						
						value="<fmt:formatDate value="${ birthday }" pattern="yyyy-MM-dd"  />"
						<c:if test="${birthday!=null}">readonly</c:if> 
					${empty birthday ? 'placeholder="Select your birth date"' : ''}
						onkeydown="javascript:preventInput(event);"   required>
				</div>
			</div>
			</c:if>
				
		<c:if test="${genderFieldShow == false}"> 
			<div class="col-lg-6">
				<div class="form-group">
				
			 	 <label for="Gender">Select Gender</label>

					<c:set var="inputIdCounter" value="2" />
			<div class="gender-wrapper">
			<c:forEach var="entry" items ="${fieldConfigurationGender}"> 
						<div class="custom-control custom-radio">
							<label for="image-check${inputIdCounter}"> <input type="radio"
								 id="image-check${inputIdCounter}" name="<portlet:namespace/>gender"
								value="${entry.fieldData}"
								 <c:if test="${entry.fieldData eq gender}">
                						checked="checked"
            							</c:if> 
								<%-- <c:if test="${gender.contains('Other')}">checked</c:if>--%>
								<c:if test="${gender.length() gt 0}">disabled</c:if> >
								<div class="gender-inner-wrapper">
									<img src="/documents/d/safe_sail/icon-awesome-genderless"
										alt="genderless">
									<p>${entry.fieldData}</p>
								</div>
							
							</label> 
							
						</div>
						  <c:set var="inputIdCounter" value="${inputIdCounter + 1}" />
						</c:forEach>
			</div>
				
					
				</div>
			</div>
		</c:if> 
			
		<c:if test="${phoneNoFieldShow == false}">
			<div class="col-lg-6">
				<div class="form-group">
				
					<label for="mobile number" class="form-label mobileNo91">Mobile Number</label>
					
					<input type="text" name="<portlet:namespace/>number"
						class="form-control " id="number" maxlength="10" value="${phoneNumber}"
						placeholder="Enter 10 digit valid mobile no"
						 <c:if test="${phoneNumber gt 0}">readonly</c:if> >
				</div>
			</div>
		</c:if>
		
		<c:if test="${emailFieldShow == false}">
			<div class="col-lg-6">
				<div class="form-group">
				
					<label for="exampleInputEmail1">Email</label> <input type="email" 
						class="form-control emailFinder" id="exampleInputEmail1" onblur="emailValidate()"
						name="<portlet:namespace/>email" aria-describedby="emailHelp"
						value="${email}" placeholder="Enter Email" 
						<c:if test="${email.length() gt 0}">readonly</c:if>>
				</div>
			</div>
		</c:if>
			
			<c:set var="flag" value="true" />
			 <c:if test="${fieldShow == false}"> 
			<div class="col-lg-6">
				<div class="form-group">
					<label for="Income" class="form-label">Annual Income*</label>
					<div class="annual-wrapper">
					
						<select class="form-control" id="annualImage"
							name="<portlet:namespace/>annualIncome">
							<option value="">Select Annual Income</option>
							
							 <c:forEach var="entry" items ="${fieldConfigurationData}"> 
							 	<c:set var="flag" value="false" />
							 	 <option value="${entry.fieldSumAssured}" 
           							 <c:if test="${entry.fieldSumAssured eq sumAssured}">
                						selected="selected"
            							</c:if>    >
           						 	<c:out value="${entry.fieldData}" />
           						 	
           				
        						</option>
        						
							</c:forEach>
							
						</select>
						
						<span style="display: none" id="hiddenAnnualData" ></span>
						<input type="hidden" id="hiddenField" name="<portlet:namespace/>annualIncomeFieldData" />

					</div>

				</div>
			</div>
			</c:if>
			
		<c:if test="${aadharFieldShow == false}">
			<div class="col-lg-6">
				<div class="form-group">
				
					<label for="pan number" class="form-label">Aadhaar Number</label> <input
						type="text" name="<portlet:namespace/>aadharNumber" maxlength="16" onblur="aadhaarVerification()"
						class="form-control" id="aadharNumber" oninput="validateAadhar(event)" 
						value="${aadharNumber}" placeholder="Enter Aadhaar Number"
						<c:if test="${aadharNumber.length() gt 0}">readonly</c:if>>
				
				</div>
			</div>	
		</c:if>
			
			
		<c:if test="${panCardFieldShow == false}">
			<div class="col-lg-6">
				<div class="form-group">
				
					<label for="pan number" class="form-label">Pan Number</label> <input
						type="text" name="<portlet:namespace/>panNumber" maxlength="10" onblur="panVerification()"
						class="form-control" id="panNumber" placeholder="Enter Pan Number"
						value="${panNumber}"
						<c:if test="${panNumber.length() gt 0}">readonly</c:if>>
				</div>
			</div> 
		</c:if>
			
	<c:if test="${AgreementfieldShow == false}">
		<div class="col-lg-12">
			<div class="agree-terms-wrapper">
				<div class="form-group">
	
					<input type="checkbox" class="d-block invisible" id="javascript"
						name="<portlet:namespace/>condition"> <label
						for="javascript" class="form-label">I agree to the &nbsp;<a
						role="button" data-target="#termPopup" data-toggle="modal">
							Terms and Conditions.</a></label>
				</div>
			</div>
		</div>
	</c:if>
		
		</div>
		
		<div class="form-btn-wrapper">
			<button type="submit" class="c-btn primary-btn-wrapper">Submit</button>
			
			<div class="product-download">
			
				<a
					href="/documents/d/safe_sail/standard-certificate-of-insurance-template-free-download-1"
					target="_blank"><img
					src="/documents/d/safe_sail/icon-ionic-md-download" alt="">Product
					brochure</a>
			</div>
		</div>

	</form>
</section>

<div class="modal" id="termPopup">
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
         <!--    <p>This website is designed, developed and maintained by Safe-Sail, wholly owned by Government of India.</p>
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
				<button type="button" class="c-btn primary-btn-wrapper acceptBtn"
					data-dismiss="modal">Accept</button>
				<button type="button" class="c-btn secondary-btn-wrapper"
					data-dismiss="modal">Cancel</button>
			</div>

		</div>
	</div>
</div>



<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js">
	
</script>





<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>


<script>


//for annualIncome
 $("#annualImage").change(
      			function() {
          $("#hiddenAnnualData").text(" "+$("#annualImage option:selected").text().trim());
			var spanText = document.getElementById('hiddenAnnualData').innerText;
		      document.getElementById('hiddenField').value = spanText; 
       }); 
	

		

//for date
function preventInput(evnt) {
	
	 evnt.preventDefault();
	 evnt.removeAttr('placeholder');
	 }
	 
$('input[name="dob"]').removeProp('placeholder');

 /* $(".c-other-page-header").prepend('<p class="c-continue-app">Quote ID : ${quoteId}</p>')  */

 
 
 
 const signIn =${signedIn};
 
//aadhaarCard verification
var isaadhaarValid = false;

function aadhaarVerification(){
	
if (signIn) {
	isaadhaarValid = true;
		 console.log("User is logged in.");
	} else if($("#aadharNumber").val().trim().length == 14) {
	var aadharNumber = $("#aadharNumber").val();
	var fullName = $("#name").val();
	
	$.ajax({
		type: "GET",
		async: false,
		url: "${checkAadharVerifyURL}",
		data: {
		    '<portlet:namespace/>aadharNumber': aadharNumber,
		    '<portlet:namespace/>fullName' : fullName,
		},
		dataType: "json",
		success: function (data) {
		   console.log(data);
		   if (data.isExist) {
			   if (data.isValid) {
			   $(".custom-error-aadhar").remove();
				    var successMessage = '<div class="verification-success"> Verified Successfully</div>';
				    $("#aadharNumber").after(successMessage);
				    setTimeout(function () {
			        $(".verification-success").remove();
				    }, 2000);	
				    
				    isaadhaarValid = true;
			}
			else{
 				$(".verification-success").remove();
				 s= '<div class="custom-error-aadhar">Verification Failed</div>';
				 $("#aadharNumber").after(s);
				 isaadhaarValid = false;
			  }
		  
		   }else{
			   $(".verification-success").remove();
			   s= '<div class="custom-error-aadhar">Verification Failed</div>'; 
			  $("#aadharNumber").after(s);
			  isaadhaarValid = false;
		   }
		   
		},
		error: function (jqXHR, textStatus, errorThrown) {
		    console.log("try again " + textStatus);
		}
		
		});
	}
	
}



//pan card verification
var isPanValid = false;

function panVerification(){
	
	if (signIn) {
		isPanValid = true;
	console.log("User is logged in.");
	} else if($("#panNumber").val().trim().length == 10) {
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
}



//email already exists
var isEmailValid = false;
 

function emailValidate(){
	

if (signIn) {
	
	isEmailValid = true;
    console.log("User is logged in.");
} else {

		var email = $("#exampleInputEmail1").val();
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
		        $("#exampleInputEmail1").after(s); 
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
		
	}

}
    
  $(".modal-footer .btn-primary").click(function() {
          $("#javascript").prop("checked", true);
  
  });
      
  function validateAadhar(event) {
      var cleanedValue = event.target.value.replace(/\s/g, '');

      cleanedValue = cleanedValue.replace(/\D/g, '');

      cleanedValue = cleanedValue.replace(/(\d{4})(?=\d)/g, '$1 ');

      cleanedValue = cleanedValue.substring(0, 14);


      event.target.value = cleanedValue;
  }
	
      
  $(document).ready(function(){ 
    	
    	
//aadharcard validataion
    
       $('#aadharNumber').keypress(function(e) {
              var currentLength = $('#aadharNumber').val().replace(/\s/g, '').length;

              // Allow spaces only after every 4 numeric characters
              if (currentLength > 0 && currentLength % 4 === 0 && (e.which >= 48 && e.which <= 57)) {
                  $('#aadharNumber').val($('#aadharNumber').val() + " ");
              }

              // Allow only numeric characters and spaces
              var allowedChars = [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 32];
              if (!(allowedChars.indexOf(e.which) >= 0)) {
                  e.preventDefault();
              }
          }); 
          
      
    	//phonenumber validation
    	 $('#number').keypress(function(e) {
              
              var arr = [];
              var n = e.which;
  
              for (i = 48; i < 58; i++)
                  arr.push(i);
  
              if (!(arr.indexOf(n) >= 0))
                  e.preventDefault();
          });
  
    	
          //name validate    
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
         
         
         
        
         
     /*   $('#panNumber').on('input', function (e) {
           var panNumber = $(this).val();
           panNumber = panNumber.toUpperCase(); 
           $(this).val(panNumber);
       });*/
       
       $('#panNumber').on('input', function (e) {
    	    var panNumber = $(this).val().toUpperCase();
    	    
    	    panNumber = panNumber.replace(/[^A-Z0-9]/g, '');

    	    var firstFiveAlphabets = panNumber.substring(0, 5).replace(/[^A-Z]/g, '');
    	    var nextFourNumbers = panNumber.substring(5, 9).replace(/[^0-9]/g, '');
    	    var lastAlphabet = panNumber.charAt(9).replace(/[^A-Z]/g, '');

    	    var formattedPanNumber = firstFiveAlphabets + nextFourNumbers + lastAlphabet;

    	    $(this).val(formattedPanNumber);
    	});

  
      
      jQuery.validator.addMethod('email_rule', function(value,
                  element) {
              if (/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/
                      .test(value)) {
            		return true;
              } else {
                  return false;
              }
          });
          
       jQuery.validator.addMethod("aadhar_rule", function (value, element) {
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
          
          jQuery.validator.addMethod('phoneNumber_rule', function(value,
                  element) {
              if (/[^0-9]/g.test(value)) {
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
                  $('#Personaldetails').validate({
                	  
                      errorElement : 'div',
                      onfocusout : function(element) {
                          this.element(element);
                      },
                      rules : {
                          "<portlet:namespace />fullName" : {
                              required : true,
                              name_rule : true
                          },
                          "<portlet:namespace />gender" : {
                              required : true
                          },
                          "<portlet:namespace/>email" : {
                              required : true,
                              email_rule : true
                          },
                         "<portlet:namespace/>aadharNumber": {
                              required: true,
                               aadhar_rule: true 
                          },
                          
                          "<portlet:namespace/>dob" : {
                              required : true
                          },
                          "<portlet:namespace/>number" : {
                              required : true,
                              minlength : 10,
                              maxlength : 10,
                              digits : true
                          },
                          "<portlet:namespace/>panNumber" : {
                              required : true,
                              panNumber_rule : true
                          },
                          "<portlet:namespace/>annualIncome" : {
                              required : true
                          },
                          "<portlet:namespace/>condition" : {
                              required : true
                          }
                      },
                      messages : {
                          "<portlet:namespace />fullName" : {
                              required : "Full name required",
                              name_rule : "Only letters are required"
  
                          },
                          "<portlet:namespace />gender" : {
                              required : "Gender required"
  
                          },
                          "<portlet:namespace />email" : {
                              required : "Email is required",
                              email_rule : "Please enter a valid email format"
                           
                          },
                          "<portlet:namespace/>aadharNumber": {
                        	  required: "Aadharnumber required",
                        	 aadhar_rule:"Please enter a valid aadhar format" 
                          },
                          
                          
                          "<portlet:namespace />dob" : {
                              required : "Birthdate is required",
                              date : "Please enter a valid date format"
                          },
                          "<portlet:namespace />number" : {
                              minlength : 'Enter atleast 10 digits',
                              maxlength : 'Enter atleast 10 digits',
                              required : 'Mobile number is required',
                              digits : 'Enter only digits'
                          },
  
                          "<portlet:namespace />panNumber" : {
  
                              required : 'Pannumber is required',
                              panNumber_rule : 'Please enter a valid pancard number'
                          },
                          "<portlet:namespace />annualIncome" : {
                              required : 'Please select annual income'
                          },
  
                          "<portlet:namespace />condition" : {
                              required : "Terms and Condition are Required"
                          }
                      },
                      submitHandler : function(form) {
                    	  if(signIn || isEmailValid && isPanValid && isaadhaarValid) {
                    		  form.submit();
                    	  }
                      }
                  });
              
  
      //for mobile number
      $("#number").on("keydown", function(e) {
          var invalidChars = [ "-", "+", "e", "." ]; //include "." if you only want integers
          if (invalidChars.includes(e.key)) {
              e.preventDefault();
          }
      });
  
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
  
      
  
          $('.agree-terms-wrapper input:checkbox').change(function() {
              if ($(this).is(":checked")) {
                  $('.acceptBtn').addClass("d-none");
              } else {
                  $('.acceptBtn').removeClass("d-none");
              }
          });
  
          $(".acceptBtn").on('click', function() {
            /*   $(".agree-terms-wrapper input:checkbox").prop("checked", true); */
             $(".agree-terms-wrapper input").click();
              if ($('.agree-terms-wrapper input:checkbox').is(":checked")) {
                  $('.acceptBtn').addClass("d-none");
              } else {
                  $('.acceptBtn').removeClass("d-none");
              }
          });
  
         
          $("#hiddenAnnualData").text(" "+$("#annualImage option:selected").text().trim());
			var spanText = document.getElementById('hiddenAnnualData').innerText;
		      document.getElementById('hiddenField').value = spanText; 
      			
      });
    
  </script>
  