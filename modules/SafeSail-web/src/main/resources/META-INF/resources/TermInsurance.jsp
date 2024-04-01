<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<style>

.term-insurance__donwload__brochure a {
    text-decoration: underline;
    color: #368BBA !important;
	font-size: 16px;
}	

.c-other-page-header a.c-continue-app {  
  display: none;
  } 

.changingSpan{

    font-weight: normal !important;
    display: inline;
}

.rsPrice span {display: inline; font-size: inherit;}

.term-insurance__premium__wrapper {align-items: flex-start;}
.term-insurance__premium__wrapper h2 {padding-top: 9px;}
</style>

<portlet:actionURL name="saveInsurance" var="saveInsuranceUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="terminsurance.css">
</head>
<body>


	<section class="term-insutance">
		<portlet:renderURL var="BackButtonsURl">
			<portlet:param name="mvcRenderCommandName" value="/incomeDetailBack" />

			<portlet:param name="quoteId" value="${quoteId}" />
		</portlet:renderURL>
		<form action="${saveInsuranceUrl}" method="post">
			<input type="hidden" name="<portlet:namespace/>quoteId"
				class="form-control " value="${quoteId}"> 
				
		    	
				<input type="hidden" name="<portlet:namespace/>totalValues"
				id="totalValues" class="form-control " value="${form.totalValues}">
			<div class="term-insutance__benefits">
				<div class="term-insurance__heading">
					<h2>Enhance your term insurance cover with add-on benefits</h2>
				</div>
				
				<div class="term-insurance__card__wrapper">
					
						
						<c:forEach var="entry" items ="${fieldConfigurationAddOnData}"> 	
					<div class="term-insurance__body">
						<div class="term-insurance__img__wrapper">
							<div class="term-insurance__img__inner__wrapper">
								<div class="term-insurance__img">
									<!-- <img src="/documents/d/safe_sail/icon-metro-user-md" alt=""> -->
									<img src="${entry.selectImage }" alt="">
								</div>
						
								<div class="term-insurance__name__wrapper">
									<h3><c:out value="${entry.fieldData}"/></h3>
									<%-- <p><c:out value="${entry.fieldValue    }"/>/Year</p> --%>
								<p><span class="p-0">&#8377;</span> <fmt:formatNumber type="number" groupingUsed="true" value="${entry.fieldValue}" /></p>
								
								</div>
							</div>
							<div class="term-insurance__toggle-btn">
								<label class="switch switch200">
								
   									 <input type="checkbox" 
           								value="<c:out value='${entry.fieldValue}'/>"
           								<c:if test="${entry.fieldValue != null && entry.fieldValue.equals(addOnField1) || entry.fieldValue.equals(addOnField2) || entry.fieldValue.equals(addOnField3) }">
   								 checked="checked"
										</c:if>

           								  class="selectedField" name="<portlet:namespace/>selectedField">
   									 <span class="slider slider200"></span>
								</label>

							</div>
						</div>
						<div class="term-insurance__quote">
							<p><c:out value="${entry.fieldSumAssured}"/></p>
						</div>
					</div> 
					</c:forEach>
		</div>
				<div class="term-insurance__premium">
					<div class="term-insurance__premium__wrapper">
						<h2>Total Premium</h2>
						<div class="term-insurance__amount">
						<div class="d-flex">
							<h3 class="rsPrice">
							<span class="p-0" id="totalAddonValueRs">&#8377;</span> <span id="totalAddonValue" class="p-0">${totalValues}</span> 
						
						<span class="p-0"  id="totalAddonValuesRs">&#8377;</span> <span id="totalAddonValues" class="p-0">${totalAddon}</span>
							<span class="changingSpan" style="text-indent: 10px;">  ${paymentFreq}</span>
							 </h3> 
						 
						</div>
							<input type="hidden" name="<portlet:namespace/>TotalAddon"
								value="" id="totalAddon"> 
								
								<span>(incl of taxes)</span>
						</div>
					</div>

				</div>
				<div class="term-insurance__btn__group__wrapper">
					<div class="buttons">
					<a class="c-btn secondary-btn-wrapper" href="${BackButtonsURl}">Back</a>
					<button class="c-btn primary-btn-wrapper" type="submit">Proceed</button>
						
					</div>
					<div class="term-insurance__donwload__brochure">
						<div class="product-download">
						
						<a href="/documents/d/safe_sail/standard-certificate-of-insurance-template-free-download-1" target="_blank"> 
						<img src="/documents/d/safe_sail/icon-ionic-md-download" alt="">Product
								brochure</a>
							<!-- <a href=""> <img src="images/Icon ionic-md-download.svg"
								alt=""> Product brochure
							</a> -->
						</div>
						<c:if test="${AgreementfieldShow == false}">
						<a  role="button" data-target="#exampleModal" data-toggle="modal">Terms and Conditions.</a>
</c:if>
					</div>
				</div>
			</div>
		</form>
	</section>
	
	
	
<!-- 	      <a class="btn btn-primary btn-lg ml-4"  role="button" data-target="#exampleModal" data-toggle="modal"><b>  Open modal</b></a> 
 -->
      <!-- The Modal -->
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
           <!--  <p>This website is designed, developed and maintained by Safe-Sail, wholly owned by Government of India.</p>
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
            <button type="button" class="button-same button-blue" data-dismiss="modal">Accept</button>
              <button type="button" class="button-same button-white" data-dismiss="modal">Cancel</button>
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

<script>
	
	var AllPrices = $("#totalAddonValue").text();
	var price = parseInt(AllPrices);

	
	
 	 $(document).ready(function() {
 		  
	 	$(".c-other-page-header").prepend('<p class="c-continue-app">Quote ID : ${form.quoteId}</p>');
		
		$("#totalAddonValues").attr("hidden", true);
		$("#totalAddonValuesRs").attr("hidden", true);
		
		var selectedFields = [];

		 $("input[name='<portlet:namespace/>selectedField']:checked").each(function() {
		      
		        price = price + parseInt($(this).val().replace(/,/g, ''));
		 });
		 
		 prices=price.toLocaleString(); 
			$("#totalAddonValue").text(prices);
			$("#totalAddon").val(prices); 

		
		/*  $("#totalAddonValue").text(price);
		$("#totalAddon").val(price);  */
 		
 	});
	
 	
 	 $(".selectedField").click(function() {
		
		$("#totalAddonValues").attr("hidden", false);
		$("#totalAddonValuesRs").attr("hidden", false);
		$("#totalAddonValue").attr("hidden", true);
		$("#totalAddonValueRs").attr("hidden",true);
		$("#totalAddon").val(0);
		$("#totalAddonValues").text(0);
	
		 var selectedField = $(this).val();
		selectedField = parseFloat(selectedField.replace(/,/g, ''));
		

		var totalAddonValues =0;
		if($(this).is(':checked')){
			totalAddonValues = selectedField + price;
		}
		if (!$(this).is(':checked')) {
			totalAddonValues = price - selectedField;
			
		} else {
			
			$("#totalAddonValue").attr("hidden", true);
			$("#totalAddonValueRs").attr("hidden",true);
		}

		price = totalAddonValues;

		
		 prices=totalAddonValues.toLocaleString(); 
		$("#totalAddon").val(prices);

		$("#totalAddonValues").text(prices);
		
		
		/* $("#totalAddon").val(totalAddonValues);

		$("#totalAddonValues").text(totalAddonValues);  */
	});
	
	
 
	
</script>