<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="imagedemo.caption"/></b>
</p>
 
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
 <portlet:actionURL name="itemActionURL" var="itemActionURL" />
<%-- 
<aui:form action="<%= itemActionURL %>" method="post" name="fm" >
<aui:button name="chooseImage" id="chooseImage" value="Choose"/><br/>
<aui:input name="fileName"  type="text" value=""/><br/>
<aui:input name="submit" type="submit" value="Submit"/>
</aui:form> --%>
 
 
 <form action="${itemActionURL}"  method="post" id="csvDataFileForm">

<input type="file" name='<portlet:namespace/>fileName' id="fileName"></input>
<input type="submit" ></input>

</form>
<%
String itemSelectorURL =(String)request.getAttribute("itemSelectorURL");
%>

<%-- <aui:script use="aui-base,liferay-item-selector-dialog">

     $('#<portlet:namespace />chooseImage').on(
          'click', 
         function(event) {
             var itemSelectorDialog = new A.LiferayItemSelectorDialog(
                 {
                     eventName: 'sampleTestSelectItem',
                     on: {
                             selectedItemChange: function(event) {
                                 var selectedItem = event.newVal;

                                 if (selectedItem) {
                                     var itemValue = selectedItem.value;
                                     itemSrc = itemValue.url;
                                     document.getElementById("<portlet:namespace/>fileName").value=itemValue;
                                     
                                 }
                            }
                    },
                     title: '<liferay-ui:message key="select-image" />',
                         url: '<%= itemSelectorURL.toString() %>'
                }
            );
            itemSelectorDialog.open();
        }
    );
    
    

</aui:script> --%>

<%-- <script>
$('#<portlet:namespace />chooseImage').on(
	      'click',
	      function(event) {
	         Liferay.Util.openSelectionModal(
	            {
	            	 
	               onSelect: function (event) {
	            	   var selectedItem = event.value;
	            	   if (selectedItem) {
                           document.getElementById("<portlet:namespace/>fileName").value=selectedItem;   
                       }
	               }, 
	               selectEventName: 'sampleTestSelectItem', 
	               title: '<liferay-ui:message key="select-image" />',
	               url: '<%= itemSelectorURL.toString() %>'
	            }
	         );
	      }
	   );
</script> --%>

<c:if test = "${recievedMessage !=null}">
         <img src="data:image/png;base64,${recievedMessage}" width="240" height="300"/>
      </c:if> 