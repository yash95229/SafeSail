<%@ include file="/init.jsp" %>






<style>	

.dataTables_filter label {
    font-size: 0 !important;
    margin-right: 15px;
}

.dataTables_filter input {
    background: #F1F2F5 url(/documents/d/safe_sail/icon-search-1-) no-repeat right 10px center !important;
    border: 1px solid #E7E7ED !important;
    padding: 8px 10px !important;
    width: 250px;
    font-size: 13px !important;
    border-radius: 4px !important;
}

.dataTables_wrapper .dataTables_filter {
   display: flex !important;
}
.dataTables_filter label {
    font-size: 0 !important;
	margin-right: 15px;
}
.dataTables_wrapper .dataTables_length {
    margin-top: 10px;
}

#categoryFilter {
    margin-right: 15px !important;
}
.dt-buttons{
	display: flex;
    float: right;
    margin-top: 0px;
      
}


.dt-buttons .dt-button{
	    color: #FFFFFF;
background: #15658D 0% 0% no-repeat padding-box;
  padding: 5px 25px;
    border-radius: 10px solid #4CAF50;
     font-weight: 400;
    text-align: center;
    border: 1px solid transparent;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    line-height: 1.5;
    border-radius: 0.25rem;
    
    
}

.dt-buttons .dt-button:hover{
	    color: #FFFFFF;
background: #15658D 0% 0% no-repeat padding-box;
 border: 1px solid #343a40;
}

.whiteBox {
    background-color: #fff;
    border-radius: 16px;
    padding: 16px 0;
    box-shadow: none;
    margin-bottom: 24px;
    

}
.tbdy{
font-size: 14px;
}
.c-other-page-header a.c-continue-app {  
  display: none;
  }
</style>
 
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.css" />
  <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.4.1/js/dataTables.buttons.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.4.1/js/buttons.html5.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.4.1/js/buttons.print.min.js"></script>
 
 <script>
   
$(document).ready( function() {
 $("#exportTable").DataTable({
	 
	 dom: '<Bflr"dt-buttons"><"table-responsive"t>ip',
	 buttons: [
         {
           extend: 'csv',          
           text: 'Download',
           filename: 'Safe_Sail',                     
         }
     ],
	
}); 
}); 


</script> 


<div class="container">
<div class="whiteBox d-flex justify-content-between align-items-center">
        <div class="pageTitle mb-0"><b>Reports</b></div>
    </div>
	<div class="table-responsive">
		<table id="exportTable" class="display table-bordered" style="overflow: auto;">
		
		    <thead>
		        <tr>
			       	<th>Quote ID</th>
					<th>Full Name</th>
					<th>Dob</th>
					<th>Gender</th>
					<th>Phone Number</th>
					<th>Email Address</th>
					<th>Aadhar Number</th>
					<th>Pan Number</th>
					<th>Annual Income</th>
					<th>Sum Assured</th>
					
					<th>Premium Paying Term</th>
					<th>Payment Frequency</th>
				 	<th>Payout Option</th>
					
					<th>Total Values</th>
					<th>Total Addon</th>
					<th>Agreement</th>
					<th>User ID</th>
					<th>Booking ID</th>
					<th>Application Number</th>
					<th>Plan Name</th>
					<th>Booking Date</th>
					<th>Maturity Date</th>
					<!-- <th>Payment Frequency</th> -->
					<th>Total Premium</th>
					<!-- <th>Status</th>  -->
				</tr>
		    </thead>
		   
		    <tbody class="tbdy">
		        <c:forEach items="${data}" var="j">
			        <tr>
			        <td>${j[0]} </td>
			       <td>${j[1]} </td>
			       <td>${j[2]} </td>
			       <td>${j[3]} </td>
			       <td>${j[4]} </td>
			       <td>${j[5]} </td>
			      <td>${j[6]} </td>
			      <td>${j[7]} </td>
			      <td>${j[8]} </td>
			       <td>${j[9]} </td>
			     
			       <td>${j[10]} </td>
			       <td>${j[11]} </td>
			       <td>${j[12]} </td>
			
			      <td>${j[13]} </td>
			      <td>${j[14]=j[22]-j[13]} </td>
			       <td>${j[15]} </td>
			       <td>${j[16]} </td>
			       <td>${j[17]} </td>
			       <td>${j[18]} </td>
			       <td>${j[19]} </td>
			      <td>${j[20]} </td>
			      <td>${j[21]} </td>
			      <%-- <td>${j[22]} </td> --%>
			       <td>${j[22]} </td>
			      <%--  <td>${j[24]}</td> --%>
				</tr>
		       </c:forEach>
		    </tbody>
		    
		</table>
	</div>


 
 
 
<div class="csv-file mb-3 mt-3">
<portlet:actionURL var="userCSVDataUploadURL" name="userCSVDataUpload"></portlet:actionURL>
<p>
<b>Add user to Liferay DB from CSV</b>
</p>
<form action="${userCSVDataUploadURL}" enctype="multipart/form-data" method="post" id="csvDataFileForm">
<div>
<label>Upload User Data CSV :</label>
<input type="file" name='<portlet:namespace/>csvDataFile' id="csvDataFile"></input>
</div>
<div>
<input type="submit" class="c-btn primary-btn-wrapper"></input>
</div>
</form>
</div>


</div>


