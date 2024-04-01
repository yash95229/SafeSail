<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>

.chooseDropdown{
    max-width: 350px;
    margin: 30px auto;
}

.toggleSwitch span span {
  display: none;
}

.toggleSwitchLable {display: flex;
    align-items: center;
        justify-content: center;
        
        margin-bottom:20px;}

#dynamicFieldName {text-transform: capitalize;}

@media only screen {
  .toggleSwitch {
    display: inline-block;
    height: 18px;
    position: relative;
    overflow: visible;
    padding: 0;
    cursor: pointer;
    margin-left:10px;
    margin-bottom:0 !important;
    width: 40px
  }
  .toggleSwitch * {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }
  .toggleSwitch label,
  .toggleSwitch > span {
    line-height: 20px;
    height: 20px;
    vertical-align: middle;
  }
  .toggleSwitch input:focus ~ a,
  .toggleSwitch input:focus ~ .dot,
  .toggleSwitch input:focus + label {
    outline: none;
  }
  .toggleSwitch label {
    position: relative;
    z-index: 3;
    display: block;
    width: 100%;
  }
  .toggleSwitch input {
    position: absolute;
    opacity: 0;
    z-index: 5;
  }
  .toggleSwitch > span {
    position: absolute;
    left: -50px;
    width: 100%;
    margin: 0;
    padding-right: 50px;
    text-align: left;
    white-space: nowrap;
  }
  .toggleSwitch > span span {
    position: absolute;
    top: 0;
    left: 0;
    z-index: 5;
    display: block;
    width: 50%;
    margin-left: 50px;
    text-align: left;
    font-size: 0.9em;
    width: 100%;
    left: 15%;
    top: -1px;
    opacity: 0;
  }
  .toggleSwitch a,
  .toggleSwitch .dot {
    position: absolute;
    right: 50%;
    z-index: 4;
    display: block;
    height: 100%;
    padding: 0;
    top:-1px;
    left: 1px;
    width: 18px;
    background-color: #fff;
    border: 1px solid #CCC;
    border-radius: 100%;
    -webkit-transition: all 0.2s ease-out;
    -moz-transition: all 0.2s ease-out;
    transition: all 0.2s ease-out;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
  }
  .toggleSwitch > span span:first-of-type {
    color: #ccc;
    opacity: 1;
    left: 45%;
  }
  .toggleSwitch > span:before {
    content: '';
    display: block;
    width: 100%;
    height: 100%;
    position: absolute;
    left: 50px;
    top: -2px;
    background-color: #fafafa;
    border: 1px solid #ccc;
    border-radius: 30px;
    -webkit-transition: all 0.2s ease-out;
    -moz-transition: all 0.2s ease-out;
    transition: all 0.2s ease-out;
  }
  .toggleSwitch input:checked ~ a,
  .toggleSwitch input:checked ~ .dot  {
    border-color: #fff;
    left: 100%;
    margin-left: -8px;
  }
  .toggleSwitch input:checked ~ span:before {
    border-color: #0097D1;
    box-shadow: inset 0 0 0 30px #0097D1;
  }
  .toggleSwitch input:checked ~ span span:first-of-type {
    opacity: 0;
  }
  .toggleSwitch input:checked ~ span span:last-of-type {
    opacity: 1;
    color: #fff;
  }
  /* Switch Sizes */
  .toggleSwitch.large {
    width: 60px;
    height: 27px;
  }
  .toggleSwitch.large a,
  .toggleSwitch.large .dot {
    width: 27px;
  }
  .toggleSwitch.large > span {
    height: 29px;
    line-height: 28px;
  }
  .toggleSwitch.large input:checked ~ a,
  .toggleSwitch.large input:checked ~ .dot {
    left: 41px;
  }
   .toggleSwitch.large > span span {
    font-size: 9px;
  }
  .toggleSwitch.large > span span:first-of-type {
    left: 50%;
  }
  .toggleSwitch.xlarge {
    width: 80px;
    height: 36px;
  }
  .toggleSwitch.xlarge a,
  .toggleSwitch.xlarge .dot {
    width: 36px;
  }
  .toggleSwitch.xlarge > span {
    height: 38px;
    line-height: 37px;
  }
  .toggleSwitch.xlarge input:checked ~ a,
  .toggleSwitch.xlarge input:checked ~ .dot {
    left: 52px;
  }
  .toggleSwitch.xlarge > span span {
    font-size: 1.4em;
  }
  .toggleSwitch.xlarge > span span:first-of-type {
    left: 50%;
  }
}


input[type=checkbox], input[type=radio] {
    display: block;
}
</style>
<!-- <p>
	<b><liferay-ui:message key="fieldcustomization.caption"/></b>
</p> -->

<portlet:resourceURL id="/saveConfigField" var="saveConfigFieldURL" ></portlet:resourceURL>

<div class="form-group chooseDropdown">
	<label for="fieldCustomization">Choose a Field:</label>
	         <!--  <form name="add_data" id="add_data"> -->
	
		<select name="fieldName" id="fieldName" class="fieldName form-control">
		 <option value="">Please Select The FieldName</option>
		  <option id="0" value="fullName">Full Name</option>
		  <option id="0" value="dob">Dob</option>
		  <option id="1" value="gender">Gender</option>
		   <option id="0" value="phoneNo">Phone No</option>
		  <option id="0" value="emailAddress">Email Address</option>
		  <option  id="1"value="annualIncome">Annual Income</option>
		  <option id="0" value="aadharNumber">Aadhar Number</option>
		  <option id="0" value="panNumber">Pan Number</option>
		 <option id="1" value="agreement">Agreement</option>
		  <option id="1" value="policyTerm">Policy Term</option>
		  <option id="0" value="PPTerm">PPTerm</option>
		  <option id="1"  value="paymentFrequency">Payment Frequency</option>
		  <option id="1" value="PayoutOption">Payout Option</option>
		   <option id="1" value="policyAddOn">Policy AddOn</option>
		</select>
</div>

<div class="container">
  <div class="row">
    <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="form-group">
            <table class="table table-bordered table-hover mb-3" id="dynamic_field">
              <tr>
                <td><input type="text" name="fieldData" placeholder="Field Data"  class="form-control fieldData" /></td>
                <td><input type="text" name="fieldValue" placeholder="Field Value" class="form-control fieldValue"/></td>
				<td><input type="text" name="fieldSumAssured" placeholder="Field Extra" class="form-control fieldSumAssured"/></td>
				<td><input type="text" name="selectImage" placeholder="Select Image" class="form-control selectImage"/></td>
                <td><button type="button" name="add" id="add" class="btn btn-success fieldAdd">Add More</button></td>  
              </tr>
            </table>
          
			<div class="toggleSwitchLable text-center">
			<div id="dynamicFieldName"></div>
	 <label class="toggleSwitch large" onclick="">
			    <input type="checkbox"   name="fieldShow" value="${fieldShow}"  id="fieldShow"  />
			    <span>
			        <span>Hide</span>
			        <span>Show</span>
			     
			    </span>
			    <div class="dot"></div>
			</label> 
			</div>
			
			
           <div class="text-center"> 
           	 <input type="submit" class="c-btn primary-btn-wrapper" onclick="submitConfigField()" name="submit" id="submit" value="Submit">
           </div>
           
           
        </div>
      </div>
    <div class="col-md-1"></div>
  </div>
</div>

          <!-- </form> -->



  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
  
<script>
var i = 1;

	
/*$(document).ready(function(){

	var i = 1;
	var length;

	$("#add").click(function(){

	i++;
	  $('#dynamic_field').append('<tr id="row'+i+'"><td><input type="text" name="fieldData"  class="form-control fieldData"/></td><td><input type="text" name="fieldValue" class="form-control fieldValue"/></td><td><input type="text" name="fieldSumAssured"  class="form-control fieldSumAssured"/></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');  
	});

	$(document).on('click', '.btn_remove', function(){  
	  var button_id = $(this).attr("id");     
	  $('#row'+button_id+'').remove();  
	});

	
	
});*/




function addRow(fieldName) {
	console.log(fieldName);
	i++;
	if(fieldName=="policyAddOn"){ 
		$('#dynamic_field').append('<tr id="row'+i+'"><td><input type="text" name="fieldData"  class="form-control fieldData"/></td><td><input type="text" name="fieldValue" class="form-control fieldValue"/></td><td><input type="text" name="fieldSumAssured"  class="form-control fieldSumAssured"/></td><td><input type="text" name="selectFile"  class="form-control selectFile"/></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');
	 }if(fieldName=="annualIncome")  {
		$('#dynamic_field').append('<tr id="row'+i+'"><td><input type="text" name="fieldData"  class="form-control fieldData"/></td><td><input type="text" name="fieldSumAssured"  class="form-control fieldSumAssured"/></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');

	 }if(fieldName === 'policyTerm' || fieldName === 'paymentFrequency'){
		$('#dynamic_field').append('<tr id="row'+i+'"><td><input type="text" name="fieldData"  class="form-control fieldData"/></td><td><input type="text" name="fieldValue" class="form-control fieldValue"/></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');
			
	}if(fieldName === 'PayoutOption' || fieldName === 'gender' || fieldName== 'agreement'){
		$('#dynamic_field').append('<tr id="row'+i+'"><td><input type="text" name="fieldData"  class="form-control fieldData"/></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');
			
	}
	 
}




$('.fieldData, .fieldValue, .fieldSumAssured, .fieldAdd, .table, .selectImage').hide();
$('#fieldName').change(function(){
	  var selectedField = $(this).val();

	  document.getElementById("dynamicFieldName").innerHTML =  selectedField;
	  
	  $('.fieldData, .fieldValue, .fieldSumAssured, .selectImage, .fieldAdd, .table').hide();
	  
	  if (selectedField === 'fullName' || selectedField === 'dob' || selectedField === 'phoneNo' || selectedField === 'emailAddress' || selectedField === 'aadharNumber' || selectedField === 'panNumber' || selectedField ==='PPTerm') {
	     
		  $('.table').hide();
	  } 
	 else  {
		
	      $('.fieldData, .fieldValue, .fieldSumAssured, .selectImage, .fieldAdd, .table').show();
	    
	  }
	});
	


$('#fieldName').on('change', function () {
	
	 var fieldName = $('#fieldName').val();
	 var flag ="forGetData";
 $.ajax({
	 type: "GET",
     async: false,
     url: "${saveConfigFieldURL}",
     data: { 
    	 <portlet:namespace/>fieldName: fieldName,
    	 <portlet:namespace/>flag:flag,
    	 },
     dataType:'json', 
     success: function (data) {
    	
         console.log(data);
    	 
          $('#dynamic_field').empty(); 
         
       if(fieldName=="agreement"){
    	   $('#dynamic_field').append('<tr>' +
                   '<td><input type="text" name="fieldData" placeholder="Terms and Conditions" class="form-control fieldData" /></td>' +
                   '<td><button type="button" name="add" id="add" onclick="addRow(\'' + fieldName + '\')" class="btn btn-success fieldAdd">Add More</button></td>' +
                   '</tr>');
       }
       if(fieldName=="gender"){
       	   $('#dynamic_field').append('<tr>' +
                      '<td><input type="text" name="fieldData" placeholder="Add Gender" class="form-control fieldData" /></td>' +
                      '<td><button type="button" name="add" id="add" onclick="addRow(\'' + fieldName + '\')" class="btn btn-success fieldAdd">Add More</button></td>' +
                      '</tr>');
       }if(fieldName=="annualIncome")  {
         $('#dynamic_field').append('<tr>' +
                 '<td><input type="text" name="fieldData" placeholder="Dropdown Data" class="form-control fieldData" /></td>' +
                 '<td><input type="text" name="fieldSumAssured" placeholder="SumAssured Value" class="form-control fieldSumAssured"/></td>' +
                 '<td><button type="button" name="add" id="add" onclick="addRow(\'' + fieldName + '\')" class="btn btn-success fieldAdd">Add More</button></td>' +
                 '</tr>');
       }if(fieldName=="policyTerm"){
    	   $('#dynamic_field').append('<tr>' +
                   '<td><input type="text" name="fieldData" placeholder="Dropdown Data" class="form-control fieldData" /></td>' +
                   '<td><input type="text" name="fieldValue" placeholder="Dropdown Value" class="form-control fieldValue"/></td>' +
                   '<td><button type="button" name="add" id="add" onclick="addRow(\'' + fieldName + '\')" class="btn btn-success fieldAdd">Add More</button></td>' +
                   '</tr>');
       }if(fieldName=="paymentFrequency"){
    	   $('#dynamic_field').append('<tr>' +
                   '<td><input type="text" name="fieldData" placeholder="Dropdown Data" class="form-control fieldData" /></td>' +
                   '<td><input type="text" name="fieldValue" placeholder="Divided Value" class="form-control fieldValue"/></td>' +
                   '<td><button type="button" name="add" id="add" onclick="addRow(\'' + fieldName + '\')" class="btn btn-success fieldAdd">Add More</button></td>' +
                   '</tr>');
       }if(fieldName=="PayoutOption"){
    	   $('#dynamic_field').append('<tr>' +
                   '<td><input type="text" name="fieldData" placeholder="Payout Option" class="form-control fieldData" /></td>' +
                   '<td><button type="button" name="add" id="add" onclick="addRow(\'' + fieldName + '\')" class="btn btn-success fieldAdd">Add More</button></td>' +
                   '</tr>');
       }if(fieldName=="policyAddOn"){
    	   $('#dynamic_field').append('<tr>' +
                   '<td><input type="text" name="fieldData" placeholder="AddOn Name" class="form-control fieldData" /></td>' +
                   '<td><input type="text" name="fieldValue" placeholder="AddOn Value" class="form-control fieldValue"/></td>' +
                   '<td><input type="text" name="fieldSumAssured" placeholder="Description" class="form-control fieldSumAssured"/></td>' +
                   '<td><input type="text" name="selectImage" placeholder="Select Image" class="form-control selectImage"/></td>' +
                   '<td><button type="button" name="add" id="add" onclick="addRow(\'' + fieldName + '\')" class="btn btn-success fieldAdd">Add More</button></td>' +
                   '</tr>');
       }
       
         for (var i = 0; i < data.length; i++) {
             var rowData = data[i];
             
             if(fieldName=="annualIncome")  {
                 $('#dynamic_field').append('<tr id="row' + i + '">' +
                         '<input type="hidden" name="id" value="' + rowData.id + '" class="form-control id"/>' +
                     '<td><input type="text" name="fieldData" value="' + rowData.fieldData + '" class="form-control fieldData"/></td>' +
                     '<td><input type="text" name="fieldSumAssured" value="' + rowData.fieldSumAssured + '" class="form-control fieldSumAssured"/></td>' +
                     '<td><button type="button" name="remove"  value="' + rowData.id + '"  id="' + i + '" class="btn btn-danger btn_remove">X</button></td>' +
                     '</tr>');
            }if(fieldName=="policyAddOn")  {
             $('#dynamic_field').append('<tr id="row' + i + '">' +
                     '<input type="hidden" name="id" value="' + rowData.id + '" class="form-control id"/>' +
                 '<td><input type="text" name="fieldData" value="' + rowData.fieldData + '" class="form-control fieldData"/></td>' +
                 '<td><input type="text" name="fieldValue" value="' + rowData.fieldValue + '" class="form-control fieldValue"/></td>' +
                 '<td><input type="text" name="fieldSumAssured" value="' + rowData.fieldSumAssured + '" class="form-control fieldSumAssured"/></td>' +
                 '<td><input type="text" name="selectImage"  value="' + rowData.selectImage + '" class="form-control selectImage"/></td>' +
                 '<td><button type="button" name="remove"  value="' + rowData.id + '" id="' + i + '" class="btn btn-danger btn_remove">X</button></td>' +
                 '</tr>');
             }if(fieldName === 'policyTerm' || fieldName === 'paymentFrequency'){
            	 
            	 $('#dynamic_field').append('<tr id="row' + i + '">' +
                         '<input type="hidden" name="id" value="' + rowData.id + '" class="form-control id"/>' +
                     '<td><input type="text" name="fieldData" value="' + rowData.fieldData + '" class="form-control fieldData"/></td>' +
                     '<td><input type="text" name="fieldValue" value="' + rowData.fieldValue + '" class="form-control fieldValue"/></td>' +
                     '<td><button type="button" name="remove"  value="' + rowData.id + '" id="' + i + '" class="btn btn-danger btn_remove">X</button></td>' +
                     '</tr>');
             }if(fieldName === 'PayoutOption' || fieldName === 'gender' || fieldName ==='agreement'){
            	 $('#dynamic_field').append('<tr id="row' + i + '">' +
                         '<input type="hidden" name="id" value="' + rowData.id + '" class="form-control id"/>' +
                     '<td><input type="text" name="fieldData" value="' + rowData.fieldData + '" class="form-control fieldData"/></td>' +
                     '<td><button type="button" name="remove" value="' + rowData.id + '" id="' + i + '" class="btn btn-danger btn_remove">X</button></td>' +
                     '</tr>');
             }
              if (rowData.fieldShow) {
                 $('#fieldShow').prop('checked', true);
             } 
         }
     
        
     },
     error: function (xhr, textStatus, errorThrown) {
         console.error('Error fetching data:', errorThrown);
     }
 });
});



function submitConfigField(){
	 
	 var requestDataArray = [];
	 var flag ="forDataSave";
	 var selectedFieldName = $('#fieldName').val();
	 var showFieldValue=$('#fieldShow').is(":checked");
	
	 var selectedOption = $('#fieldName option[value="' + selectedFieldName + '"]');
	    var selectedOptionId = selectedOption.attr('id');
	    
	    var formData = new FormData();
	   $('[id^="row"]').each(function(index, element) {
		   var rowElement = $(this);

	        var fieldDataValue = rowElement.find('.fieldData').val();
	        var fieldValueValue = rowElement.find('.fieldValue').val();
	        var fieldSumAssuredValue = rowElement.find('.fieldSumAssured').val();
	       	var selectImage = rowElement.find('.selectImage').val();
	       
	        var id = rowElement.find('.id').val();
	        
	        console.log("type of image is ::: "+typeof selectImage);
	       
	        console.log('fieldDataValue:', fieldDataValue);
	        console.log('fieldValueValue:', fieldValueValue);
	        console.log('fieldSumAssuredValue:', fieldSumAssuredValue);
	       	console.log('selectImage:', selectImage); 
	   
	        var rowData = {
	        		fieldData: fieldDataValue,
	        		fieldValue: fieldValueValue,
	        		fieldSumAssured: fieldSumAssuredValue,
	        		selectImage: selectImage,
	        		id: id,

	  			};
	        
	        
	        console.log("Selected image is :: "+rowData.selectImage);
	        
	        requestDataArray.push(rowData);
	       
	    });
	 
	 $.ajax({
	         type: "POST",
	         async: false,
	         url: "${saveConfigFieldURL}",
	        data: {
	        	 <portlet:namespace/>flag:flag,
	        	<portlet:namespace/>fieldName: selectedFieldName,
	        	<portlet:namespace/>showFieldValue: showFieldValue,
	        	<portlet:namespace/>selectedOptionId: selectedOptionId,
	        	<portlet:namespace/>allDataArray: JSON.stringify(requestDataArray) 
	        },
	        
	         dataType: "json",
	         success: function(data) {
	         	console.log(data);
	        
	         },error: function(jqXHR, textStatus, errorThrown){
	              console.log("Something thing went wrong please try again " + textStatus);
	         }
	         
	       }) ;
	} 
	
	
$(document).on('click', '.btn_remove', function(){  
	
	var rowIndex =  $(this).attr("id");  
	var selectedRow = $('#row' + rowIndex);
	var idInput = selectedRow.find('input[name="id"]');
	var rowDataId = idInput.val();

	console.log('rowData.id for row ' + rowIndex + ': ' + rowDataId);
  
	  var flag ="delete";
	 $.ajax({
	  type: "GET",
	  url: "${saveConfigFieldURL}",
	  data:{
		  <portlet:namespace/>id:rowDataId , 
		  <portlet:namespace/>flag:flag,  
	  },
	  success: function(data) {
		  console.log("Successfully Deleted____");
		  $('#row'+rowIndex+'').remove();  
		
	 },
	
	  error: function(jqXHR, textStatus, errorThrown){
		  console.log(" failed " + textStatus);
	  }
	  
	});	 

}); 

  </script>