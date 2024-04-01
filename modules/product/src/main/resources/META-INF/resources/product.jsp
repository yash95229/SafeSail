<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>





<portlet:actionURL name="saveProduct" var="saveProductUrl" />

<div class="container" >
	<form action="${saveProductUrl}" method="post" id="productDetail">
	 <input type="hidden" name="<portlet:namespace/>productId"
								class="form-control" id="productId" value="${product.productId }">
					<div class="col-md-12 income-details">
						<div class="form-group">
							<label for="productName">Product Name</label> <input type="text"
								name="<portlet:namespace/>productName"
								class="form-control" id="productName" value="${product.productName}"
								placeholder="Enter Product Name">
						</div>
						<div class="form-group">
							<label for="premiumDiscount">Premium Discount</label>
							<input type="number" name="<portlet:namespace/>premiumDiscount"
								class="form-control" value="${product.premiumDiscount }"
								id="premiumDiscount" placeholder="Enter Discount">
						</div>
						
						<div class="form-group">
							<label for="totalDiscount ">Total Discount</label>
							<input type="number" name="<portlet:namespace/>totalDiscount"
								class="form-control" value="${product.totalDiscount }"
								id="totalDiscount" placeholder="Enter Discount">
						</div>
					</div>	
						<div class="buttons">
							<button class="c-btn primary-btn-wrapper" type="submit">Proceed</button>
							
						</div>	
						
						</form>	
</div>