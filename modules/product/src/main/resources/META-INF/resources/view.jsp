<%@ include file="/init.jsp" %>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.css" />
  <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.4.1/js/dataTables.buttons.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.4.1/js/buttons.html5.min.js"></script>
 <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/2.4.1/js/buttons.print.min.js"></script>
 
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
	#exportTable th, #exportTable td {
		font-size: 14px; padding: 5px;
	}
	#exportTable td .c-btn {
		font-size: 14px; padding: 3px 12px;
	}
</style>
	
<script>
$(document).ready( function() {
	 $("#exportTable").DataTable({
		
	}); 
}); 


</script>

<portlet:renderURL var="productUrl">
	<portlet:param name="mvcRenderCommandName" value="/productmvc" />
</portlet:renderURL>
<div class="container text-right">
		
<a href="${productUrl}" class="c-btn primary-btn-wrapper add-btn">Add Product</a>

	</div>					
				<div class="container">
	<div class="table-responsive mt-4">
		<table id="exportTable" class="display table-bordered" style="overflow: auto;">
		
		    <thead>
		        <tr>
			       <th>Product Name</th>
			       <th>Premium Discount</th>	
			       <th>Total Discount</th>
			       	<th>Action</th>
			       
				</tr>
		    </thead>
		   
		    <tbody>
		        <c:forEach items="${product}" var="product">
			        <tr>
			        <td>${product.productName}</td>
			        <td>${product.premiumDiscount}</td>
			        <td>${product.totalDiscount}</td>
			        
			        <td>
				<portlet:renderURL var="updateUrl">
					<portlet:param name="mvcRenderCommandName" value="/productmvc" />
					<portlet:param name="productId" value="${product.productId}" />
						
				</portlet:renderURL>
				<a href="${updateUrl}" class="c-btn primary-btn-wrapper"> Edit </a>
				
				<portlet:renderURL var="deleteUrl">
					<portlet:param name="mvcRenderCommandName" value="deleteProduct" />
					<portlet:param name="productId" value="${product.productId}" />
				</portlet:renderURL>
				<a href="${deleteUrl}" class="c-btn primary-btn-wrapper"> Delete </a>
				
				
				</td>
				</tr>
		       </c:forEach>
		    </tbody>
		    
		</table>
	</div>
	
