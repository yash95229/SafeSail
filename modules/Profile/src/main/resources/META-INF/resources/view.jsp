<%@page import="com.liferay.portal.kernel.model.Contact"%>
<%@page
	import="com.liferay.portal.kernel.service.ContactLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Phone"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="init.jsp"%>


<portlet:actionURL name="updateProfile" var="updateProfileURL" />

<style>

#Date {
  background:url("/documents/d/safe_sail/icon-feather-calendar");
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

#annualImage{
   background: url(/documents/d/safe_sail/drop-down) !important;
    appearance: none;
    background: transparent;
    background-repeat: no-repeat !important;
    background-position: center right 20px !important;
    background-size: 20px !important;
}
#Email{
  background:url("/documents/d/safe_sail/icon-feather-mail");
  background-position: 96% center;
  background-repeat: no-repeat;
  background-size: 38px;
  background-size: 25px 40px;
}
#number{
  background:url("/documents/d/safe_sail/icon-feather-phone-call");
  background-position: 96% center;
  background-repeat: no-repeat;
  background-size: 38px;
  background-size: 25px 40px;
}

#profile {
	width: 60px;
	height: 60px;
	border-radius: 50%;
}

.user-profile {
	padding: 0 100px;
}

input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}

input[type="date"]::-webkit-inner-spin-button, input[type="date"]::-webkit-calendar-picker-indicator
	{
	display: none;
	-webkit-appearance: none;
}

.user-profile form {
	background: #FFFFFF 0% 0% no-repeat padding-box;
	box-shadow: 0px 3px 6px #00000029;
	padding: 70px;
	margin: 70px 0px;
}

.user-profile__Img__wrapper {
	display: flex;
	align-items: center;
	gap: 30px;
	flex-wrap: wrap;
}

.user-profile__name__wrapper h1 {
	letter-spacing: 0px;
	color: #15658D;
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 5px;
}

.user-profile__completion {
	display: flex;
	align-items: center;
}

.user-profile__completion p {
	font-size: 16px;
	letter-spacing: 0px;
	color: #368BBA;
	margin-bottom: 0;
}

.user-profile__completion span {
	letter-spacing: 0px;
	color: #368BBA;
	font-size: 16px;
	font-weight: bold;
	margin-left: 4px;
}

.user-profile__tab__wrapper {
	margin-top: 40px;
}

.user-profile__tab__wrapper ul li a {
	padding: 0;
	background: transparent;
	letter-spacing: 0px;
	color: #368BBA;
	font-size: 16px;
}

.user-profile__tab__wrapper ul li .nav-link.active {
	background: transparent;
	letter-spacing: 0px;
	color: #15658D;
	font-size: 16px;
	font-weight: bold;
	border-bottom: 2px solid #15658D;
	border-radius: 0;
}

.user-profile__tab__wrapper ul {
	gap: 70px;
}

.personal-detail-wrapper {
	margin-top: 40px;
}

.personal-detail-wrapper label {
	letter-spacing: 0px;
	color: #15658D;
	font-size: 18px;
	margin-bottom: 15px;
}

.personal-detail-wrapper .form-control {
	height: 62px;
	border: 1px solid #EFEFEF;
	color: #368BBA;
}

.city-wrapper select {
	appearance: none;
	background: transparent;
	background-image: url(./images/Icon\ material-keyboard-arrow-down.svg);
	background-repeat: no-repeat;
	background-position: center right 20px;
}

.Marital-status-wrapper select {
	appearance: none;
	background: transparent;
	background-image: url(./images/Icon\ material-keyboard-arrow-down.svg);
	background-repeat: no-repeat;
	background-position: center right 20px;
}

.personal-detail-wrapper .form-control:focus {
	box-shadow: none;
	border: 1px solid #EFEFEF;
}

.gender-wrapper {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
	column-gap: 10px;
}

.gender-wrapper label {
	width: 100%;
}

.gender-wrapper label:before {
	display: none;
}

.gender-inner-wrapper {
	display: flex;
	gap: 10px;
	align-items: center;
	border: 1px solid #EFEFEF;
	border-radius: 10px;
	height: 62px;
	padding: 10px;
	cursor: pointer;
}

.gender-wrapper label:after {
	display: none;
}

.gender-inner-wrapper p {
	margin-bottom: 0;
}

.gender-wrapper .custom-radio {
	padding-left: 0;
}

@media only screen and (max-width: 991px) {
	section.user-profile {
		padding: 0 40px;
	}
	section.user-profile form {
		padding: 50px;
	}
}

@media only screen and (max-width: 767px) {
	section.user-profile {
		padding: 0 15px;
	}
	section.user-profile form {
		padding: 15px;
	}
	.user-profile .gender-wrapper {
		grid-template-columns: 1fr;
	}
	.user-profile__tab__wrapper ul {
		gap: 20px;
	}
}
</style>

<section class="user-profile">
	<form action="${updateProfileURL}" method="post" id="profileForm">
		<div class="user-profile__detail-wrapper">
			<div class="user-profile__Img__wrapper">

				<%-- <img src="${themeDisplay.getPathThemeImages()}/user-img.png" alt=""> --%>
				<img id="profile"
					src="<%=themeDisplay.getUser().getPortraitURL(themeDisplay)%>"
					alt="">
				<div class="user-profile__name__wrapper">
					<h1>${fullName}</h1>
					<div class="user-profile__completion">
						<p>Profile completion :</p>
						<span> 60%</span>
					</div>
				</div>
			</div>
		</div>
		<div class="user-profile__tab__wrapper">
			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				<li class="nav-item"><a class="nav-link active"
					id="pills-home-tab" data-toggle="pill" href="#pills-home"
					role="tab" aria-controls="pills-home" aria-selected="true">Personal
						Details</a></li>
				<li class="nav-item"><a class="nav-link" id="pills-profile-tab"
					data-toggle="pill" href="#pills-profile" role="tab"
					aria-controls="pills-profile" aria-selected="false">Contact
						Details</a></li>
				<li class="nav-item"><a class="nav-link" id="pills-contact-tab"
					data-toggle="pill" href="#pills-contact" role="tab"
					aria-controls="pills-contact" aria-selected="false">Family
						Details</a></li>
				<li class="nav-item"><a class="nav-link" id="pills-contact-tab"
					data-toggle="pill" href="#pills-Assets" role="tab"
					aria-controls="pills-contact" aria-selected="false">Assets</a></li>
			</ul>
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-home"
					role="tabpanel" aria-labelledby="pills-home-tab">

					<div class="personal-detail-wrapper">
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<input type="hidden" name="<portlet:namespace/>userId" value="${user.getUserId() }"> <label
										for="fname">Full Name</label> <input
										value="${ fullName}" type="text" name="<portlet:namespace/>fullName"
										class="form-control" id="fname" aria-describedby="name"
										placeholder="Sameer Jain">
								</div>
								<div class="form-group">
									<label for="Email">Email</label> <input
										value="${ user.getEmailAddress()}" type="email" name="<portlet:namespace/>email"
										class="form-control" id="Email" aria-describedby="Email"
										placeholder="test@test.com" readonly="readonly">
								</div>
								<div class="form-group">
									<label for="PAN">PAN Number</label> <input type="text"
										name="<portlet:namespace/>panNumber" class="form-control" id="PAN" maxlength="10"
										aria-describedby="PAN" value="${ panCardNumber}">
								</div>
								<div class="form-group">
									<label for="Income" class="form-label">Annual Income</label>
									<div class="annual-wrapper">
										<select class="form-control" id="annualImage"
											name="<portlet:namespace/>annualIncome">
											<option value="">Select Annual Income</option>
											<option value="3"
												<c:if test="${annualIncome==3}">selected</c:if>>1-3
												lacs</option>
											<option value="5"
												<c:if test="${annualIncome==5}">selected</c:if>>3-5
												lacs</option>
											<option value="7"
												<c:if test="${annualIncome==7}">selected</c:if>>5-7
												lacs</option>
											<option value="10"
												<c:if test="${annualIncome==10}">selected</c:if>>>10
												lacs</option>


										</select>
									</div>


								</div>
								<div class="form-group">
									<label for="city" class="form-label">City</label>
									<div class="city-wrapper">
										<select class="form-control" id="annualImage" name="<portlet:namespace/>city">
											<option value="Ahmedabad"
												<c:if test="${city.contains('Ahmedabad')}">selected</c:if>>Ahmedabad</option>
											<option value="Surat"
												<c:if test="${city.contains('Surat')}">selected</c:if>>Surat</option>
											<option value="Vadodra"
												<c:if test="${city.contains('Vadodara')}">selected</c:if>>Vadodra</option>

											<!-- <option value="2">Default select4</option>
                                                <option value="3">Default select5</option> -->
										</select>
									</div>

								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label for="mobile number" class="form-label">Mobile
										Number</label> <input type="text" value="${ phoneList }"
										 class="form-control" id="number" maxlength="10" name="<portlet:namespace/>phoneNo"
										placeholder="Enter 10 digit valid mobile no">
								</div>
								<div class="form-group">
									<label for="DateBirth">Date of birth</label> <input type="date"
										class="form-control" id="Date" aria-describedby="Date"
										placeholder="Select your birth date" name="<portlet:namespace/>dob"
										value="<fmt:formatDate value="${birthday}"  pattern="yyyy-MM-dd" />">
								</div>
								<div class="form-group">
									<label for="Marital-status" class="form-label">Marital
										Status</label>
									<div class="Marital-status-wrapper">
										<select class="form-control" id="annualImage" name="<portlet:namespace/>maratilStatus">
											<option value="Married"
												<c:if test="${maritalStatus.contains('Married')}">selected</c:if>>Married</option>
											<option value="UnMarried"
												<c:if test="${maritalStatus.contains('UnMarried')}">selected</c:if>>UnMarried</option>
											<option value="Divorced"
												<c:if test="${maritalStatus.contains('Divorced')}">selected</c:if>>Divorced</option>

										</select>
									</div>

								</div>
								<div class="form-group">
									<label for="Gender">Select Gender</label>
									<div class="gender-wrapper">
										<div class="custom-control custom-radio">
											<label for="image-check3"> <input type="radio"
												id="image-check3" name="<portlet:namespace/>gender" value="Male"
												<c:if test="${gender.contains('Male')}">checked</c:if>>
												<div class="gender-inner-wrapper">
													<img
														src="${themeDisplay.getPathThemeImages()}/Icon awesome-male.svg"
														alt="Male">
													<p>Male</p>
												</div>
											</label>
										</div>
										<div class="custom-control custom-radio">
											<label for="image-check4"> <input type="radio"
												id="image-check4" name="<portlet:namespace/>gender" value="Female"
												<c:if test="${gender.contains('Female')}">checked</c:if>>
												<div class="gender-inner-wrapper">
													<img
														src="${themeDisplay.getPathThemeImages()}/Icon awesome-female.svg"
														alt="female">
													<p>Female</p>
												</div>
											</label>
										</div>
										<div class="custom-control custom-radio">
											<label for="image-check5"> <input type="radio"
												id="image-check5" name="<portlet:namespace/>gender" value="Other"
												<c:if test="${gender.contains('Other')}">checked</c:if>>
												<div class="gender-inner-wrapper">
													<img
														src="${themeDisplay.getPathThemeImages()}/Icon awesome-genderless.svg"
														alt="genderless">
													<p>Other</p>
												</div>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="buttons">
							<!-- <div class="">
                                    
                                </div> -->
							<button class="button-same button-blue">Save Details</button>
						</div>
					</div>

				</div>
				<div class="tab-pane fade" id="pills-profile" role="tabpanel"
					aria-labelledby="pills-profile-tab">

					<div class="form-group">
						<label for="Address">Address</label>
						<textarea class="form-control" id="Address" name="<portlet:namespace/>address"
							aria-describedby="Address" style="height: 150px; width: 400px;" placeholder=" Street1  Street2  City Stat pinCode">${address}</textarea>
					</div>

				</div>
				<div class="tab-pane fade" id="pills-contact" role="tabpanel"
					aria-labelledby="pills-contact-tab">Family Details</div>
				<div class="tab-pane fade" id="pills-Assets" role="tabpanel"
					aria-labelledby="pills-Assets-tab">Assets</div>

			</div>
		</div>
	</form>
</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js" integrity="sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"> </script>

<script>
	$(document).ready(function() {

		
		 $('#number').keypress(function(e) {
			 debugger
				var arr = [];
				var n = e.which;

				for (i = 48; i < 58; i++)
					arr.push(i);

				if (!(arr.indexOf(n) >= 0))
					e.preventDefault();
			});
		 
		 jQuery.validator.addMethod('panNumber_rule', function (value, element) {
	            if (/[A-Z]{5}[0-9]{4}[A-Z]{1}$/.test(value)) {
	                return true;
	            } else {
	                return false;
	            };
	        });
		 
		 jQuery.validator.addMethod('name_rule', function (value, element) {
             if (/^[a-zA-Z][a-zA-Z ]*$/.test(value)) {
                 return true;
             } else {
                 return false;
             };
         });

		$('#profileForm').validate({
			onfocusout : function(element) {
				this.element(element);
			},
			rules : {
				"<portlet:namespace />fullName" : {
					required : true,
					name_rule:true
				},
				"<portlet:namespace />Gender" : {
					required : true
				},
				"<portlet:namespace />email" : {
					required : true,
					email : true
				},
				"<portlet:namespace />dob" : {
					required : true
				},
				"<portlet:namespace />phoneNo" : {
					required : true,
					minlength : 10,
					maxlength : 10,
					digits:true,
				},
				"<portlet:namespace />panNumber" : {
					required : true,
					panNumber_rule:true
				},
				"<portlet:namespace />annualIncome" : {
					required : true
				}
			},
			messages : {
				"<portlet:namespace />fullName" : {
					required : "Full name Required",
					name_rule :"only Letters are Required"

				},
				"<portlet:namespace />email" : {
					email : "Enter a valid email"
				},
				"<portlet:namespace />dob" : {
					required : "birth date is required",
					date : "Please enter a valid date format."
				},
				"<portlet:namespace />phoneNo" : {
					minlength : 'enter atleast 10 digit',
					maxlength : 'enter atleast 10 digit',
					required : 'mobile number is required',
					digits : 'enter only Digits'
				},

				"<portlet:namespace />panNumber" : {
					required : 'pan card Number is required',
					panNumber_rule:'enter valid pan card Number'
				},
				"<portlet:namespace />annualIncome" : {
					required : 'please select anual income'
				}
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
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
</script>

