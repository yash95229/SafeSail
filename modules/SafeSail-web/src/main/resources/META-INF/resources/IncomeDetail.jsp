<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>






<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.c-other-page-header a.c-continue-app {  
  display: none;
  } 
  .income-details-wrappr .form-group select {
            background-image: url(/documents/d/safe_sail/drop-down) !important;
            appearance: none;
    background: transparent;
    background-repeat: no-repeat !important;
    background-position: center right 20px !important;
    background-size: 20px !important;
    }
      .discount-price h6 {
            font-size: 14px; 
            text-decoration:initial !important;
            margin: 0;
        } 
</style>
<!-- this linked style not working -->
<link rel="stylesheet" href="incomedetails.css">

</head>
<body>

<!-- to add data-->
<portlet:actionURL name="saveIncome" var="saveIncomeUrl" />
	
<!-- backbutton -->
	<portlet:renderURL var="BackButtonURl">
		<portlet:param name="mvcRenderCommandName" value="/personalDetail" />
		<portlet:param name="quoteId" value="${quoteId}" />
	</portlet:renderURL>




	<section class="income-details-wrappr">
		<div class="main-wrapper">
			<form action="${saveIncomeUrl}" method="post" id="IncomeDetail">
				<input type="hidden" name="<portlet:namespace/>quoteId"
					class="form-control " value="${quoteId}">

				<div class="income-detail-header">
					<h2>Income Details</h2>
					<ul>
					
						<li>${fullName}</li>
						<li><fmt:formatDate value="${birthday}" pattern="dd-MM-yyyy" /></li>
						<%-- <li><img src="/documents/d/safe_sail/icon-awesome-male-1-" alt="">&nbsp;&nbsp;${gender}</li> --%>
						<li>${gender}</li>
						<li><a href="${BackButtonURl}"><img
								src="/documents/d/safe_sail/edit" alt="">Edit</a></li>
					</ul>
				</div>


 				<input type="hidden" value="${sumAssured}" id="sumAssured"> 
			
				<div class="form-group income-details">
			<h3 id="sumAssured">Sum Assured
						<%--  <fmt:formatNumber  value = "${sumAssured}"  type = "currency" currencySymbol="&#8377;"/>  --%>
							<span class="p-0">&#8377;</span> <fmt:formatNumber type="number" groupingUsed="true" value="${sumAssured}" />
						<%-- <span class="p-0">&#8377; <span  id="sumAssured" class="p-0">
							 ${sumAssured}</span> --%>
				</h3>
						 <%-- <input type="number" name="<portlet:namespace/>sumAssured" disabled
								class="form-control" value="${sumAssured}" id="sumAssured"
								placeholder="50,00,000"> --%> 
			</div>
			
			
				<div class="row in income-details">
				
				
					
				
				<c:if test="${policyTermFieldShow == false}"> 
						<div class="col-lg-6 ">
							<div class="form-group">
								<label for="policyTerm">Policy term</label> <select
									id="policyTerm" name="<portlet:namespace/>policyTerm"
									class="form-control ">
									<!-- <option value="">Select Policy Term</option> -->
											<c:forEach var="entry" items ="${fieldConfigurationPolicyTermData}"> 
								 	<option value="${entry.fieldValue}"
								 	<c:if test="${entry.fieldValue eq policyTerm}">
                						selected="selected"
            							</c:if>
								 	><c:out value="${entry.fieldData}"/></option>
								</c:forEach>
								</select>
							</div>
						</div>
				</c:if>
				
				<c:if test="${PPTermFieldShow == false}"> 
						<div class="col-lg-6 ">
							<div class="form-group">
								<label for="premiumPayingTerm">Premium paying term (Years)</label>
								<input type="number" name="<portlet:namespace/>premiumPaying"
									class="form-control" value="${PPTterm}"
									id="premiumPayingTerm" placeholder="27">
							</div>
						</div>
				</c:if>
						
				<c:if test="${paymentFreqFieldShow == false}"> 	
						<div class="col-lg-6 ">
							<div class="form-group">
								<label for="paymentFrequency">Payment frequency</label> <select
									id="paymentFrequency" name="<portlet:namespace/>paymentFreq"
									class="form-control">
									
									<c:forEach var="entry" items ="${fieldConfigurationPaymentFreqData}"> 
								 	<option value="${entry.fieldValue}"
								 	<c:if test="${entry.fieldData eq paymentFreq}">
                						selected="selected"
            							</c:if>    >
								 	<c:out value="${entry.fieldData}"/></option>
								</c:forEach>
								</select>
							</div>
						</div>
				</c:if>
						
					<c:if test="${payOutFieldShow == false}"> 
						<div class="col-lg-6 ">
							<div class="form-group">
								<label for="payoutOption">Payout option</label> <select 
									id="payoutOption" name="<portlet:namespace/>payout"
									class="form-control">
									<option value="">Select Payout Option</option>
																		<c:forEach var="entry" items ="${fieldConfigurationPayoutData}"> 
								 	<option value="${entry.fieldData}"
								 	<c:if test="${entry.fieldData eq payOutOpt}">
                						selected="selected"
            							</c:if> 
								><c:out value="${entry.fieldData}"/></option>
								</c:forEach>
								</select>
							</div>
						</div>
					</c:if>
						
						
						
					<div class="col-lg-6 ">

						<div class="existing-customer">
							<h3>
								Premium Breakdown<!-- <span> (Get Discount)</span> -->
							</h3>
						</div>
						<div class="discount">
							<h5>Online Discount(${product.totalDiscount}%)</h5>
							<div class="discount-price">
							
							<h5 style="text-decoration:line-through 2px red;">
						        <span class="p-0" style="font-size: 16px;font-weight: normal;">&#8377;</span>
								<span id="cancelPrice" class="p-0" style=" font-size: 16px; font-weight: normal;">${totalValues * 0.8 }</span>	
    						</h5>	
								
								&nbsp;&nbsp;
							
							<h3> 
								<span class="p-0">&#8377;</span>
								<span class="p-0" id="discountPrice">${totalValues}</span>
							</h3>
							<span id="RemoveddiscountPrice">${totalValues}</span>
							
							<!-- <span style="font-size: 14px;font-weight: normal;">Saved</span>
							<span class="p-0" style="font-size: 14px;font-weight: normal;">&#8377;</span> <p class="saved"></p> -->
							
							<span style="font-size: 14px;font-weight: normal;">(Saved</span><h6>
						<span class="p-0" style="font-size: 14px;font-weight: normal;">&#8377;</span> <span class="saved p-0" style="font-size: 14px;font-weight: normal;"></span>
						</h6>
							
							
							</div>
						</div>
						<div class="total-premium">
							<h5>Total Premium</h5>
							<div class="discount-price">
							
								<input type="hidden" name="<portlet:namespace/>TotalPayment"
									value="" id="totalPayment">
								<h3 id="Removeprice">${totalValues}</h3>
					<h3> 
					<span class="p-0">&#8377;</span> <span id="price" class="p-0">${totalValues}</span>
					</h3>
							<span id="frequency"> </span>
								<input type="hidden" id="hiddenField" name="<portlet:namespace/>spanText" />
								
								<p>(incl of taxes)</p>
							</div>
						</div>
						
					</div>
					
			<div class="col-12">
				
				<div class="row">
					<div class="col-md-6">
							<div class="buttons mb-4">
						<a class="c-btn secondary-btn-wrapper" href="${BackButtonURl}">Back
							</a>
							<button class="c-btn primary-btn-wrapper" type="submit">Proceed</button>
							
					</div>
					</div>
					
					<div class="col-md-6 text-right d-flex flex-wrap">
					<div class="download-icon ml-auto mr-5">
							<a href="/documents/d/safe_sail/standard-certificate-of-insurance-template-free-download-1" target="_blank"><img
								src="/documents/d/safe_sail/icon-ionic-md-download" alt="">Product
								brochure</a>
						</div>
				
				<c:if test="${AgreementfieldShow == false}">
						<div class="terms-conditions">
													<a  role="button" data-target="#exampleModal" data-toggle="modal">Terms and Conditions.</a>

						</div>
					</c:if>
					
					</div>
				</div>
				
						
					
					
					
			</div>
					
					<!-- </div> -->

					
				</div>
			</form>
			
		</div>
	</section>
	
	
	
	 
	

	
	 <div class="modal" id="exampleModal">
        <div class="modal-dialog modal-dialog-scrollable">
          <div class="modal-content">

          
            <!-- Modal Header -->
            <div class="modal-header">
              <h5 class="modal-title">Terms and Conditions</h5>
              <button type="button" class="close" id="terms" data-dismiss="modal">×</button>
            </div>
            


            <!-- Modal body -->
            <div class="modal-body">
              <h3>Terms & Conditions</h3>
           <c:forEach var="entry" items ="${fieldConfigurationAgreement}"> 
           	<c:out value = " ${entry.fieldData}"/> 
             </c:forEach>
            </div>


            
            <!-- Modal footer -->
            <div class="modal-footer">
            <button type="button" class="c-btn primary-btn-wrapper" data-dismiss="modal">Accept</button>
              <button type="button" class="c-btn secondary-btn-wrapper" data-dismiss="modal">Cancel</button>
            </div>
            
          </div>
        </div>
      </div>
	
	
	
</body>
</html>
	   





<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"
	integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA=="
	crossorigin="anonymous" referrerpolicy="no-referrer">
	
</script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js">
	
</script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
	
<script>
	$('#policyTerm').change(function() {

		var policyTerm = $("#policyTerm").val();
		$("#premiumPayingTerm").val(policyTerm);

	});

	
	$("#policyTerm").change(
			function() {
				
				if($("#paymentFrequency").val() != null){		
					 var sumAssured = $("#sumAssured").val(); 
				var premiumPayingTerm = $("#policyTerm").val();
				var paymentFrequency = $("#paymentFrequency").val();
				var premium = sumAssured * (${product.premiumDiscount}/100);
				var premiumAfterFreq = premium/paymentFrequency;
				var totalPremium = Math.ceil(premiumAfterFreq
						/ premiumPayingTerm);
				
				totalPremium=totalPremium.toLocaleString();
				$("#cancelPrice").text(totalPremium);
				totalPremium = totalPremium.replace(/,/g, '');
				var premiumAfterDiscount = Math.ceil(totalPremium
										- ((${product.totalDiscount}/100) * totalPremium));
				$("#RemoveddiscountPrice").remove();
				
				premiumAfterDiscounts=premiumAfterDiscount.toLocaleString();
				
				$("#Removeprice").remove();
				$("#discountPrice").text(premiumAfterDiscounts);
				$("#price").text(premiumAfterDiscounts);
				
				$("#totalPayment").val(premiumAfterDiscounts);
				
				 totalPremium=Math.round(0.08*totalPremium)
					totalPremium=totalPremium.toLocaleString(); 
					
				 $(".saved").text(totalPremium+")");
				
				$("#frequency").text(" "+$("#paymentFrequency option:selected").text().trim());
				var spanText = document.getElementById('frequency').innerText;
			      document.getElementById('hiddenField').value = spanText;
				}
			});

	
	
	$("#paymentFrequency").change(
			function() {
				
				 var sumAssured = $("#sumAssured").val(); 
				var premiumPayingTerm = $("#policyTerm").val();
				var paymentFrequency = $("#paymentFrequency").val();

				var premium = sumAssured * (${product.premiumDiscount}/100);
				var premiumAfterFreq = 0;
				var premiumAfterFreq = premium/paymentFrequency;
				var totalPremium = Math.ceil(premiumAfterFreq
						/ premiumPayingTerm);
				totalPremium=totalPremium.toLocaleString();
				$("#cancelPrice").text(totalPremium);
				totalPremium = totalPremium.replace(/,/g, '');

				var premiumAfterDiscount = Math.ceil(totalPremium
										- ((${product.totalDiscount}/100) * totalPremium));
				$("#RemoveddiscountPrice").remove();
				
				$("#Removeprice").remove();
				
				premiumAfterDiscounts=premiumAfterDiscount.toLocaleString();
				
				$("#discountPrice").text(premiumAfterDiscounts);
				$("#price").text(premiumAfterDiscounts);
				
				$("#totalPayment").val(premiumAfterDiscounts);
				 totalPremium=Math.round(0.08*totalPremium)
				totalPremium=totalPremium.toLocaleString(); 
				
				 $(".saved").text(totalPremium+")");

				/* $("#frequency").text(" /"+$("#paymentFrequency option:selected").text().trim()); */
				$("#frequency").text(" "+$("#paymentFrequency option:selected").text().trim());
				var spanText = document.getElementById('frequency').innerText;
			      document.getElementById('hiddenField').value = spanText;
			});
	
	$( document).ready(function() {
		debugger;
		$(".c-other-page-header").prepend('<p class="c-continue-app">Quote ID : ${quoteId}</p>')
		$("#cancelPrice").text("0");
		$("#discountPrice").text("0");
		$("#price").text("0");
				 var sumAssured = $("#sumAssured").val(); 
				 /*   var sumAssuredVal= document.getElementById('sumAssured').innerText;    */
				/* var sumAssuredElement = document.querySelector('fmt\\:formatNumber');
				var formattedValue = sumAssuredElement.innerHTML;
				console.log("formattedValue"+formattedValue); */
				/*  var sumAssured = sumAssuredVal.replace(/[₹,\.]|Sum Assured/g, '');
				console.log("final sumassured"+ sumAssured); */
				console.log("sumAssured_________"+sumAssured);
				var premiumPayingTerm = $("#policyTerm option:selected").val();
				var paymentFrequency = $("#paymentFrequency").val();
				var premium = sumAssured * (${product.premiumDiscount}/100);
				var premiumAfterFreq = 0;
				var premiumAfterFreq = premium/paymentFrequency;
				
				var totalPremium = Math.ceil(premiumAfterFreq
						/ premiumPayingTerm);
				totalPremium=totalPremium.toLocaleString();
				
				$("#cancelPrice").text(totalPremium);
				totalPremium = totalPremium.replace(/,/g, '');

				var premiumAfterDiscount = Math.ceil(totalPremium
						- ((${product.totalDiscount}/100) * totalPremium));
				$("#RemoveddiscountPrice").remove();
				 $("#premiumPayingTerm").val(premiumPayingTerm); 
				$("#Removeprice").remove();
				
				premiumAfterDiscounts=premiumAfterDiscount.toLocaleString();
			

				$("#discountPrice").text(premiumAfterDiscounts);
				$("#price").text(premiumAfterDiscounts);
				
				$("#totalPayment").val(premiumAfterDiscounts);
				 totalPremium=Math.round(0.08*totalPremium)
					totalPremium=totalPremium.toLocaleString(); 
					$(".saved").text(totalPremium+")");
					
				
				$("#frequency").text(" "+$("#paymentFrequency option:selected").text().trim());
				var spanText = document.getElementById('frequency').innerText;
			      document.getElementById('hiddenField').value = spanText;
			});
	



	$("#IncomeDetail").validate({
		onfocusout : function(element) {
			this.element(element);
		},
		rules : {

			"<portlet:namespace/>payout" : {
				required : true,
			},
			"<portlet:namespace/>policyTerm" : {
				required : true,
			},
			"<portlet:namespace/>paymentFreq" : {
				required : true,
			}

		},
		messages : {
			
			"<portlet:namespace/>payout"  : {

				required : 'Please select the payout option',
				
			},
			"<portlet:namespace/>policyTerm" : {
				
				required : 'Please select the policyTerm'
			},

			"<portlet:namespace/>paymentFreq" : {
				required : "Please select the paymentFrequency"
			}
		},

		submitHandler : function(form) {
			form.submit();
		}

	});

	$(".	").on("keydown", function(e) {
		var invalidChars = [ "-", "+", "e", "." ]; //include "." if you only want integers
		if (invalidChars.includes(e.key)) {
			e.preventDefault();
		}
	});
</script>