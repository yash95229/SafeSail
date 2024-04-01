<%@ include file="/init.jsp"%>

<portlet:resourceURL var="createOrder"></portlet:resourceURL>

<a id = "rzp-button1" class="btn btn-primary" onclick="saveOrderDetails()">Pay </a>

<script src = "https://checkout.razorpay.com/v1/checkout.js"> </script>
	<script>

function saveOrderDetails(){
	  $.ajax({
            type: "POST",
            url: "${createOrder}",
            dataType: "json",
            success: function(data) {
            	console.log(data);
            	var options = razorPayPaymentProcess(data.orderId);
            	var rzp1 = new Razorpay(options);
            	rzp1.open();
				e.preventDefault();
          
            },error: function(jqXHR, textStatus, errorThrown){
                 console.log("Something thing went wrong please try again " + textStatus);
            }
            
          });
}

function razorPayPaymentProcess(orderId){
	var options = {
			"key": "",
			 "amount": 1,
			  "currency": "INR",
			"name": "avan golakiya",
			   "description": "test payment testtttt",
			"order_id": orderId,
			   "handler": function (response) {
				   window.location.href="/leasing/web/orix-lease-plus"
			},
			   "prefill": {       
				"name": "avan golakiya",
				       "email": "golakiaa111@gmail.com",
				"contact": "7878001939"   
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


</script>