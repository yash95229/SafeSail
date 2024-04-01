<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.safesail.model.Policy"%>
<%@page import="com.safesail.service.PolicyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.liferay.portal.kernel.model.User"%>


	
<style>

.your-policies__card__header-wrapper {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    gap: 40px;
}

.logo-wrapper a {
    display: block;
    color: #368BBA;
    font-size: 16px;
}
.your-policies {
    padding: 0 100px;
}
.your-policies__content {
    background: #FFFFFF 0% 0% no-repeat padding-box;
   /*  box-shadow: 0px 3px 6px #00000029; */
    padding: 70px;
    margin: 0px;
}
.your-policies__head {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 40px;
}
.your-policies__head h2 {
    letter-spacing: 0px;
    color: #15658D;
    font-weight: bold;
    font-size: 30px;
}
.share-others a {
    color: #15658D;
    font-size: 16px;
    font-weight: bold;
}
.share-others a img{
    margin-right: 6px;
}
.share-others a:hover {
    text-decoration: none;
}

.plan-name-wrapper span,
.your-premium-wrapper span,
.your-status-wrapper span
{
    letter-spacing: 0px;
    color: #368BBA;
    font-size: 16px;
}
.plan-name-wrapper p,
.your-premium-wrapper p,
.your-status-wrapper p
{
    font-size: 16px;
    color: #15658D;
    font-weight: bold;
}
.your-policies__card {
    box-shadow: 0px 3px 6px #00000029;
    border-radius: 10px;
    padding: 24px 40px;
}
p.your-policies__read__btn {
    float: right;
}
.your-policies__read__btn .read__btn {
    background: transparent;
    border: none;
    color: #368BBA;
    text-decoration: underline;
    font-size: 16px;
    margin-top: 20px;
}
.your-policies__read__btn .read__btn:focus{
    box-shadow: none;
}
.your-policies__read__btn .read__btn:active,
.your-policies__read__btn .read__btn:not(:disabled):not(.disabled):active
{
    color: #368BBA;
    background-color: transparent;
    border-color: none;
    box-shadow: none;
}
.your-policies__card__body {
    padding: 0;
    border: none;
    border-top: 1px solid #D9D3CC;
    border-radius: 0;
    padding-top: 30px;
    margin-top: 10px;
}
.your-policies__card__body__detail ul li {
    list-style: none;
}
.your-policies__card__body__detail ul{
    padding: 0;
    display: grid;
    grid-template-columns: repeat(5,1fr);
    row-gap: 30px;
}
.your-policies__card__body__detail ul li span {
    color: #368BBA;
    font-size: 16px;
    display: block;
    margin-bottom: 8px;
}
.your-policies__card__body__detail ul li p{
    color: #15658D;
    font-size: 16px;
    font-weight: bold;
}
/* .chat-btn-wrapper {
    display: flex;
    align-items: center;
    justify-content: end;
    gap: 20px;
    flex-wrap: wrap;
} */
/* .chat-btn-wrapper a {
    font-size: 16px;
        color: white;

} */
a.btn.btn-primary-wrapper {
    background: #15658D 0% 0% no-repeat padding-box;
    border-radius: 25px;
    padding: 8px 32px;
    color: #FFFFFF;
    font-size: 18px;
}
.application-history__title h2 {
    color: #15658D;
    font-size: 20px;
    font-weight: bold;
    margin: 46px 0px 30px 0px;
}
.application-history__timeline ul{
    position: relative;
    padding-left: 0;
}
.application-history__timeline ul li p {
    color: #368BBA;
    font-size: 16px;
    margin-bottom: 10px;
}
.application-history__timeline ul li span {
    color: #A2A2A2;
    font-size: 14px;
    margin-bottom: 20px;
    display: block;
}
.application-history__timeline ul:after {
    content: '';
    position: absolute;
    left: 8px;
    width: 1px;
    background: #36B47D;
    height: calc(100% - 60px);
    top: 10px;
    z-index: 0;
}
.application-history__timeline ul li {
    list-style: none;
    position: relative;
    padding-left: 30px;
}

.application-history__timeline ul li:before{
    content: '';
    position: absolute;
    left: 0;
    height: 19px;
    width: 17px;
    
    background-image: url(/documents/d/safe_sail/error);
		z-index:200;
    background-size: 100%;
    background-repeat: no-repeat;
    top: 2px;
}

.application-history__timeline .issued li:before{
    content: '';
    position: absolute;
    left: 0;
    height: 17px;
    width: 17px;
    background-image: url(/documents/d/safe_sail/checkmark-svg);
		
    background-size: 100%;
    background-repeat: no-repeat;
    top: 4px;
}

.your-policies__card__wrapper__body {
    margin-bottom: 60px;
}
@media only screen and (max-width: 1024px){

.your-policies .your-policies__content{
     padding: 50px;
 }
 .your-policies__card__header-wrapper {
 grid-template-columns: 1fr;
 gap: 20px;
 }
 .your-policies__card__body__detail ul{
     grid-template-columns: repeat(3,1fr);
 }
 .chat-btn-wrapper{
     gap: 10px;
 }
}
@media only screen and (max-width: 991px){
    .your-policies{
        padding: 0 40px;
    }
}
@media only screen and (max-width: 767px){
   section.your-policies{
        padding: 0 15px;
    }
   section.your-policies .your-policies__content{
        padding: 15px;
    }
   section.your-policies .your-policies__card__header-wrapper {
        grid-template-columns: 1fr;
        gap: 20px;
    }
   .your-policies .your-policies__card__body__detail ul{
        grid-template-columns: 1fr;
        row-gap: 20px;
    }
    .your-policies  .your-policies__card{
        padding: 24px 18px; 
    }
    .chat-btn-wrapper{
        justify-content: start;
    }
    a.btn.btn-primary-wrapper{
        margin-bottom: 0;
    }
}


/* //invoice styling  */

.invoice{
   background-color: #368BBA;
   padding: 30px;
}
        .invoiceSection .printLogo{
       		margin-left:auto;
            filter: brightness(0) invert(1);
		}
.invoiceSection h1{
   color: white;
   margin-top: 23px;
}

.invoiceSection .table{
   border-top: 3px solid #368BBA;
}
.invoiceSection th{
   color: #368BBA;
}

.invoiceSection span{
   color: #6C7072;
}

.invoiceSection .table .bordertop td{
   border: 0px;
}

.invoiceSection p{
   margin-top: 50px;
   font-size: 16px;
   font-weight: 400;
   margin-bottom: 50px;
}
.right{
   text-align: right;
}

@media print {
  * {
    color-adjust: exact !important;
    -webkit-print-color-adjust: exact !important;
    print-color-adjust: exact !important;
  }
}

/* .pagination .first{
	display:none;
	}
	.pagination .last{
	display:none;
	} */
.lfr-pagination-delta-selector{
display:none !important;
}



.chat-btn-wrapper a{
font-size: 16px;
    color: #368BBA;
text-decoration: none;
}

.chat-btn-wrapper .btn btn-primary-wrapper a:hover{
font-size: 16px;
    color: #368BBA;
text-decoration: underline;
}

.your-policies__content .lfr-search-container-wrapper a:not(.component-action):not(.btn) {
    color: #368BBA;
    font-weight: 400;
    font-size: 15px;
    text-decoration: underline;
    margin-left: 15px;
}

.application-history__timeline .issued li:before {
background-image: url(/documents/d/safe_sail/checkmark-svg);
    
}

.your-policies__content .table-bordered th, .your-policies__content .table-bordered td {
     border: none; 
}

.your-policies__content .table-bordered {
    border: none;
}

.your-policies__content .lfr-search-container {
margin-top: 1.5em;
overflow: visible;
}
</style>









<portlet:renderURL var="policyRenderURL">
			<portlet:param name="mvcRenderCommandName" value="/policyRender" />

</portlet:renderURL>

	
<liferay-ui:search-container total="${counter}" var="searchContainer" delta="10" emptyResultsMessage="no-entries-were-found"
 deltaConfigurable="true" >
	
	<liferay-ui:search-container-results results="${policyList}" />
	
<%int count=0; %>		
<c:set var="count" scope="page" value="0" />

	
				<div class="your-policies__content">
				<div class="your-policies__head">
				            <h2>Your Policies </h2>
				            <div class="share-others">
				                <a onclick="generatePDF(1)">
				
				                    <img src="${themeDisplay.getPathThemeImages()}/Icon ionic-md-download.svg" alt="Share">
				                    Share with others
				                </a>
				
				            </div>
				        </div>
		
		<liferay-ui:search-container-row className="com.safesail.model.Policy" modelVar="policy" keyProperty="policyId" >
	 <liferay-ui:search-container-column-text >
		<div id="pdfs<%=++count%>"class="your-policies__card__wrapper">
	            <div class="your-policies__card__wrapper__body">
	
	                <div class="your-policies__card">
	                    <div class="your-policies__card__header-wrapper">
	                        <div class="logo-wrapper">
	
	                            <img id="logo" src="${themeDisplay.getPathThemeImages()}/safe-sail-logo.png" alt="Logo">
	                            <a href="#" style="padding-top:10px">Term Insurance</a>
	                        </div>
	                        <div class="plan-name-wrapper">
	                            <span>Plan Name</span>
	                            <p id="planName">${policy.getPlanName()}</p>
	                        </div>
	                        <div class="your-premium-wrapper">
	                            <span>Your Premium</span>
	                            <p><fmt:formatNumber value = "${policy.getTotalPremium()}" type = "currency" currencySymbol="&#8377;"/> &nbsp; ${policy.getPaymentFrequency()}</p>
	                        </div>
	                        <div class="your-status-wrapper">
	                            <span>Status</span>
	                            <p>
	                      
	                            <c:choose>
	                            	<c:when test="${policy.getStatus() eq 0}">
	                            		Pending
	                            	</c:when>
	                            	
	                            	<c:otherwise>
	                            		Policy Issued
	                            	</c:otherwise>
	                            </c:choose>
	                            </p>
	                        </div>
	                    
	                    </div>
	                   
		
		
		<div class="collapse" id="collapseExample<%=count%>">
	
	                        <div class="card card-body your-policies__card__body">
	                            <div class="your-policies__card__body__detail">
	                                <ul>
	                                    <li>
	                                        <span>Proposer</span>
	                                        <p id="fullName">${policy.getFullName()}</p>
	                                    </li>
	                                    <li>
	                                        <span>Plan Term</span>
	                                        <p>${policy.getPolicyTerm()} Years</p>
	                                    </li>
	                                    <li>
	                                        <span>Sum Assured</span>
	                                        <p><fmt:formatNumber value = "${policy.getSumAssured()}" type = "currency" currencySymbol="&#8377;"/></p>
	                                    </li>
	                                    <li>
	                                        <span>Booking Date</span>
	                                        <p><fmt:formatDate value="${policy.getBookingDate()}"  pattern="dd-MM-yyyy" /></p>
	                                    </li>
	                                    <li>
	                                        <span>Booking ID</span>
	                                        <p id="bookingId">${policy.getBookingId()}</p>
	                                    </li>
	                                    <li>
	                                        <span>Application No.</span>
	                                        <p>${policy.getApplicationNumber()}</p>
	                                    </li>
	                                    <li>
	                                        <span>Maturity Date</span>
	                                        <p id="maturityDate"><fmt:formatDate value="${policy.getMaturityDate()}"  pattern="dd-MM-yyyy" /></p>
	                                    </li>
	                                      <li>
	                                        <span>Total Addon </span>
	                                       <%--  <p id="totalAddon">${policy.getTotalAddon() }</p> --%>
	                                        <p><fmt:formatNumber value = "${policy.getTotalAddon() }" type = "currency" currencySymbol="&#8377;"/> </p>
	                                    </li>
	                                </ul>
	                            </div>
	                        </div>
	                        <div class="application-history">
	                            <div class="application-history__title">
	                                <h2>Application history</h2>
	                                <div class="application-history__timeline">
	                                    <ul 
	                            	<c:if test="${policy.getStatus() eq 1}">
	                            	class="issued"
	                            	</c:if>
	                            >
	                                        <li>
	                                            <p>Payment Confirmed</p>
	                                            <span><fmt:formatDate value="${policy.getBookingDate()}"  pattern="dd-MM-yyyy hh-mm a" /></span>
	                                        </li>
	                                        <li>
	                                            <p>Proposal Form Submitted</p>
	                                            <span><fmt:formatDate value="${policy.getBookingDate()}"  pattern="dd-MM-yyyy hh-mm a" /></span>
	                                        </li>
	                                        <li>
	                                            <p>Documents Completed</p>
	                                            <span><fmt:formatDate value="${policy.getBookingDate()}"  pattern="dd-MM-yyyy hh-mm a" /></span>
	                                        </li>
	                                        <li>
	                                            <p>Information Submitted</p>
	                                            <span><fmt:formatDate value="${policy.getBookingDate()}"  pattern="dd-MM-yyyy hh-mm a" /></span>
	                                        </li>
	                                        <li>
	                                            <p>Policy Issued</p>
	                                            <span><fmt:formatDate value="${policy.getBookingDate()}"  pattern="dd-MM-yyyy hh-mm a" /></span>
	                                        </li>
	                                    </ul>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="chat-btn-wrapper">
	                            <a href="/web/safe_sail/support">Need help with this policy?</a>
	                            <a class="btn btn-primary-wrapper"  onclick="generatePopup(<%=count%>)">Chat</a>
	                            <portlet:resourceURL id="/createOrder1" var="createOrder"></portlet:resourceURL>
	                             <portlet:resourceURL id="/successData" var="createOrder1"></portlet:resourceURL>
	                             <portlet:resourceURL id="InsuranceList" var="insuranceList"></portlet:resourceURL>
	                             
	                            
	                            <c:choose>
	                            <c:when test="${policy.getStatus() eq 0}">
	                            <form>
	                            <input type="hidden" name= "<portlet:namespace/>quoteId<%=count%>" id="quoteId<%=count%>" class="form-control " value="${policy.getQuoteId()}">
								<input type="hidden" name="<portlet:namespace/>applicationNo<%=count%>" id="applicationNo<%=count%>" value="${policy.getApplicationNumber()}">
								<input type="hidden" name="<portlet:namespace/>totalAddon<%=count%>" id="totalAddon<%=count%>" value="${policy.getTotalPremium()}">
	                             <a id = "rzp-button<%=count%>" class="btn btn-primary-wrapper" onclick="saveOrderDetails(event,<%=count%>)">Make Payment </a> 
	                             </form>
	                            </c:when>
	                            <c:otherwise>
	                            <a class="btn btn-primary-wrapper" onclick="generatePDF(<%=count%>)">Get policy copy</a>
	                  
	                            </c:otherwise>
	                            </c:choose>
	                                  </div>
	                    </div>
	                </div>
	
	                <p class="your-policies__read__btn">
	                    <button class="btn btn-primary read__btn" type="button" data-toggle="collapse"
	                        data-target="#collapseExample<%=count %>"  aria-expanded="false" aria-controls="collapseExample">
	                        See More Details
	                    </button>
	                </p>
	            </div>
			</div>
	 


		<div id="pdf<%=count%>" style="display:none;">
			<p id="planName">${policy.getPlanName()}
			</p>
			<p id="fullName">${policy.getFullName()}
			</p>
			<p id="email">${user.getEmailAddress()}
			</p>
			<p id="applicationNo">${policy.getApplicationNumber()}
			</p>
			<p id="premiumamount">${policy.getTotalPremium()}
			</p>
			<p id="frequency">${policy.getPaymentFrequency()}
			</p>
			<p id="bookingId">${policy.getBookingId()}
			</p>
			<p id="quoteId">${policy.getQuoteId()}
			</p>
			<p id="bookingDate"><fmt:formatDate value="${policy.getBookingDate()}"  pattern="dd-MM-yyyy" />
			</p>
			
		</div>


			</liferay-ui:search-container-column-text>
		
				 
		</liferay-ui:search-container-row>
		

	 <liferay-ui:search-iterator />
</liferay-ui:search-container> 
 
<div class="pdf"></div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.debug.js" ></script>
    <script src="https://cdn.bootcss.com/html2pdf.js/0.9.1/html2pdf.bundle.js"></script>

<script src = "https://checkout.razorpay.com/v1/checkout.js"> </script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">



<script>

$(document).ready(function(){ 
$('.read__btn').click(function () {
			
	        if ($(this).attr('aria-expanded') === "false") {
	            $(this).text("See Less Details");
	        } else {
	            $(this).text("See More Details");
	        }
});

});

function saveOrderDetails(e,count){
		const quoteId=$("#quoteId"+count).val();
		const applicationNo=$("#applicationNo"+count).val();
		const totalAddon=$("#totalAddon"+count).val();
		console.log(quoteId);
		console.log(applicationNo);
		console.log(totalAddon);
		  $.ajax({
	         type: "POST",
	         url: "${createOrder}",
	         data:{
	         	<portlet:namespace/>quoteId:quoteId,
	         	<portlet:namespace/>applicationNo:applicationNo,
	         	<portlet:namespace/>totalAddon:totalAddon,
	 	       },
	         dataType: "json",
	         success: function(data) {
	         	console.log("saveOrder function data________________"+data);
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
		
		console.log("this is inside the razorpayment function_________________________________ "+totalAddon);
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
					       "email": "yashmtridhyatech@gmail.com",
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
	              console.log("Something thing went wrong please try again " + textStatus);
	         }
	         
	       }) ;
	}

	function insurancelist(quoteId){
		var response = null;
		  $.ajax({
	            type: "POST",
	            url: "${insuranceList}",
	            async:false,
	            data:{
	            	<portlet:namespace/>quoteId:quoteId,
	    	       },
	            dataType: "json",
	            success: function(data) {
	            	console.log("in insurace list function data________"+data);
	            response = data;
	            
	            },error: function(jqXHR, textStatus, errorThrown){
	                 console.log("Something thing went wrong please try again " + textStatus);
	            }

	          }) ;
		  return response; 
	}
	
	
function generatePopup(count){
		
			 Swal.fire({
				  title: "Call Me",
				text: "Phone Number : 9638992877",
				  icon: "success"
				});  
	}
	
	
	
function generatePDF(count) {
		
		let planName = $('#pdf'+count+' #planName').text();
		let logo =$('#pdfs'+count+' #logo img').attr('src');
		let fullname=$('#pdf'+count+' #fullName').text();
		let email=$('#pdf'+count+' #email').text();
		let applicationNo=$('#pdf'+count+' #applicationNo').text();
		let premiumAmount=$('#pdf'+count+' #premiumamount').text();
		let frequency =$('#pdf'+count+' #frequency').text();
		let bookingdate = $('#pdf'+count+' #bookingDate').text();
		let bookingId = $('#pdf'+count+' #bookingId').text();
		console.log("bookingId________"+bookingId);

		let quoteId = $('#pdf'+count+' #quoteId').text();
		const today = new Date();
		const yyyy = today.getFullYear();
		let mm = today.getMonth() + 1; // Months start at 0!
		let dd = today.getDate();

		if (dd < 10) dd = '0' + dd;
		if (mm < 10) mm = '0' + mm;
		
		const currentdate = dd + '-' + mm + '-' + yyyy;
		
		let data = insurancelist(quoteId);
		console.log(" in generate pdf function data___________________________"+data[0]);

		let pdfs= '<header class="clearfix" style="padding: 10px 0;margin-bottom: 30px;"> <div id="logo" style="text-align: center;margin-bottom: 10px;"> <img src="/o/safe-sails-themes/images/safe-sail-logo.png" style="width: 300px;style=" filter:brightness(0) invert(1);"> </div> <h1 style="border-top: 1px solid #5D6975;border-bottom: 1px solid #5D6975;color: #5D6975;font-size: 2.4em;line-height: 1.4em;font-weight: normal;text-align: center;margin: 0 0 20px 0;background: url(dimension.png);">INVOICE</h1> <div id="company" class="clearfix" style="float: right;text-align: right;"> <div style="white-space: nowrap;">Company Name</div> <div style="white-space: nowrap;">455 Foggy Heights,<br> AZ 85004, US</div> <div style="white-space: nowrap;">(602) 519-0450</div> <div style="white-space: nowrap;"><a href="mailto:company@example.com" style="color: #5D6975;">company@example.com</a></div> </div> <div id="project" style="float: left;"> <div style="white-space: nowrap;"><span style="color: #5D6975;text-align: right;width: 52px;margin-right: 10px;display: inline-block;font-size: 0.8em;">CLIENT</span> '+fullname+'</div> <div style="white-space: nowrap;"><span style="color: #5D6975;text-align: right;width: 52px;margin-right: 10px;display: inline-block;font-size: 0.8em;">EMAIL</span> <a href="mailto:'+email+'" style="color: #5D6975;text-decoration: underline;">'+email+'</a></div><div style="white-space: nowrap;"><span style="color: #5D6975;text-align: right;width: 52px;margin-right: 10px;display: inline-block;font-size: 0.8em;">Billing Date</span> '+bookingdate+'</div> <div style="white-space: nowrap;"><span style="color: #5D6975;text-align: right;width: 52px;margin-right: 10px;display: inline-block;font-size: 0.8em;">Date</span> '+currentdate+'</div>  </div> </header> <main> <table style="width: 100%;border-collapse: collapse;border-spacing: 0;margin-bottom: 20px;"> <thead> <tr> <th class="service" style="text-align: left;padding: 5px 20px;color: #5D6975;border-bottom: 1px solid #C1CED9;white-space: nowrap;font-weight: normal;">Application No</th> <th class="desc" style="text-align: left;padding: 5px 20px;color: #5D6975;border-bottom: 1px solid #C1CED9;white-space: nowrap;font-weight: normal;">Plan Name</th> <th style="text-align: center;padding: 5px 20px;color: #5D6975;border-bottom: 1px solid #C1CED9;white-space: nowrap;font-weight: normal;">Premium Annually</th> <th style="text-align: center;padding: 5px 20px;color: #5D6975;border-bottom: 1px solid #C1CED9;white-space: nowrap;font-weight: normal;">Premium Monthly</th> <th style="text-align: center;padding: 5px 20px;color: #5D6975;border-bottom: 1px solid #C1CED9;white-space: nowrap;font-weight: normal;">TOTAL</th> </tr> </thead> <tbody> <tr> <td class="service" style="text-align: left;padding: 20px;vertical-align: top;">'+applicationNo+'</td> <td class="desc" style="text-align: left;padding: 20px;vertical-align: top;">'+planName+'</td> <td class="unit" style="text-align: right;padding: 20px;font-size: 1.2em;">'+premiumAmount+'</td> <td class="qty" style="text-align: right;padding: 20px;font-size: 1.2em;">-</td> <td class="total" style="text-align: right;padding: 20px;font-size: 1.2em;">'+premiumAmount+'</td> </tr> <tr> <td colspan="4" class="grand total" style="text-align: right;padding: 20px;font-size: 1.2em;border-top: 1px solid #5D6975;background: #F5F5F5;">GRAND TOTAL</td> <td class="grand total" style="text-align: right;padding: 20px;font-size: 1.2em;border-top: 1px solid #5D6975;background: #F5F5F5;">'+premiumAmount+'</td> </tr> </tbody> </table> </main> <footer style="color: #5D6975;width: 100%;height: 30px;position: absolute;bottom: 0;border-top: 1px solid #C1CED9;padding: 8px 0;text-align: center;"> Invoice was created on a computer and is valid without the signature and seal. </footer>'
		
		
		var pdfmanual ='';
				var addonConfigArray= data[1];
		
				var addonBenefitsArray = data[0];
				 var addonBenefits =addonBenefitsArray.addonBenefits.split(';').map(function (a) { return a.split(','); });
				 var headTable='';
				   var bodyTable='';
				
				 pdfmanual = '<section class="invoiceSection"> ' +'<div class="invoice"> <div class="container"> <div class="row"> <div class="col-6"> <h1>Policy Details</h1> </div> <div class="col-6 d-flex align-items-center"> <img src="/o/safe-sails-theme/images/safe-sail-logo-white.png" style="width: 300px; margin-left: 260px;"> </div> </div> </div> </div> <div class="billed"> <div class="container"> <div class="row"> <div class="col-6"> <p><strong>Name</strong> : '+fullname+' <br> <strong>Email</strong> : '+email+' <br> <strong>Booking Date</strong> : '+bookingdate+' <br> <strong>Date</strong> : '+currentdate+'<br> <strong>Pan Number</strong> : '+data[0].panNumber+' <br> <strong>Aadhar Number</strong> : '+data[0].aadharNumber+' <br> <strong>Gender</strong> : '+data[0].gender+' <br> <strong>Phone Number</strong> : '+data[0].phoneno+' </p> </div> <div class="col-6 text-right"> <p class="right d-inline-block text-left"> <strong>Name of the Insurer</strong> : Safe Sail <br> <strong>Email</strong> : customer@safesail.com <br> <strong>Address</strong> : Ahmedabad, Gujarat, India<br> <strong>Zip Code</strong> : 380058 </p> </div> </div> </div> </div> <div class="container"><table class="table">'

			
				 headTable += ' <th width="150"><strong>Total Amount</strong></th> <th width="150"><strong>Plan Addon</strong></th>';

				 for (var i = 0; i < addonConfigArray.length; i++) {
					    var addonNames = addonConfigArray[i].addonName;
					    var addonValues = addonConfigArray[i].addonValue;

					    console.log("Addon Names_______", addonNames);
					    console.log("Addon Value_______", addonValues);
					    headTable += '<th width="150"><strong>' + addonNames+ '</strong></th>';
						var matchFound = false;
					
						for (var j = 0; j < addonBenefits.length; j++) {
							 
					        var addonBenefitsVal = addonBenefits[j][0];

					        console.log("Addon Benefits______", addonBenefitsVal);

					        if (addonValues == addonBenefitsVal) {
					        	
					            var matchingAddonValues= addonValues;
					            console.log("Matching Addon Value_______", matchingAddonValues);
					            var matchingAddonNames=addonNames;
					            console.log("Matching Addon Name_______", matchingAddonNames);
					            bodyTable += '<td width="150">' + matchingAddonValues+ '</td>';
					            matchFound = true;
					        }
					 	}
					 	
						if (!matchFound) {
							bodyTable += '<td width="150">NA</td>';
					    }
					}
				 pdfmanual += '<tr>' + headTable + '</tr>';
				 pdfmanual += '<tr class="bordertop"> <td>' + data[0].totalamount + ' </td> <td>' + (data[0].totaladdon - data[0].totalamount) + '</td>' + bodyTable + '</tr>';
				
				pdfmanual += '</table><table class="table"> <tr> <th width="150"><strong>Application Id</strong></th> <th width="150"><strong>Booking Id</strong></th> <th width="150"><strong>Plan Name</strong></th><th width="150"><strong>' + 'Premium'+' '+data[0].paymentFrequency+'</strong></th> <th width="150"><strong>Total</strong></th> </tr> <tr class="bordertop"> <td>'+applicationNo+' </td> <td>'+bookingId+' </td><td>'+planName+'</td> <td>'+premiumAmount+'</td> <td>'+premiumAmount+'</td> </tr></table> <p class="text-center"> Thank You For Buying Insurance From Safe Sail.</p></div> </section>';	
				
				
			/* 	$(".pdf").html(pdfmanual); */
				
				html2pdf(pdfmanual, {
				    margin: 1,
				    padding: 0,
				    filename: 'policyfile.pdf',
				    image: { type: 'jpeg', quality: 1 },
				    html2canvas: { scale: 2, logging: true },
				    jsPDF: { unit: 'in', format: 'A2', orientation: 'P' },
				    class: generatePDF
				});	
	}
	



	
			
</script>