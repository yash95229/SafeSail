package Field.Customization.portlet;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.model.FieldConfiguration;
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.FieldConfigurationLocalServiceUtil;
import com.safesail.service.LifeInsuranceLocalService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Field.Customization.constants.FieldCustomizationPortletKeys;


@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FieldCustomizationPortletKeys.FIELDCUSTOMIZATION,
		"mvc.command.name=/saveConfigField"
	},
	 service = MVCResourceCommand.class
)
public class AddConfigFieldServeResource  extends BaseMVCResourceCommand{

	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	Log log = LogFactoryUtil.getLog(AddConfigFieldServeResource.class);
	
	  	 
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		
		log.info("inAddConfigFieldServeResource___________________________________________");
		
		String operation = ParamUtil.getString(resourceRequest, "flag");

		if (StringUtil.equalsIgnoreCase(operation, "forGetData")) {
			forGetData(resourceRequest, resourceResponse);
		} else if (StringUtil.equalsIgnoreCase(operation, "forDataSave")) {
			forDataSave(resourceRequest, resourceResponse);
		} else if (StringUtil.equalsIgnoreCase(operation, "delete")) {
			deleteFieldConfig(resourceRequest, resourceResponse);
		}

	     
	}
	
	public void deleteFieldConfig(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		log.info("In fieldconfig delete resource method__________________________");
		Long configId=ParamUtil.getLong(resourceRequest,"id");
		
		log.info("configId____________________"+configId);
		
		try {
			FieldConfiguration deleteData =  fieldConfigurationLocalService.deleteFieldConfiguration(configId);
		} catch (PortalException e) {
			System.out.println("delete id "+e.getMessage());
		}
	}
	
	public void forGetData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		String fieldName = ParamUtil.get(resourceRequest, "fieldName", "");
		
		log.info("In fieldconfig getData resource method___________________________________________");
		
		log.info("fieldName_________________________________"+fieldName);
		
		List<FieldConfiguration> fieldConfigurationFieldName=null;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		 try {
			fieldConfigurationFieldName =fieldConfigurationLocalService.getByfieldName(fieldName);
			
			
			  for (FieldConfiguration x : fieldConfigurationFieldName) { 
				  JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				  
				  jsonObject.put("id",x.getConfigId()); 
				  jsonObject.put("fieldData",x.getFieldData()); 
				  jsonObject.put("fieldValue",x.getFieldValue()); 
				  jsonObject.put("fieldSumAssured",x.getFieldSumAssured()); 
				 jsonObject.put("fieldShow",x.getFieldShow()); 
				 jsonObject.put("fieldName",x.getFieldName()); 
				 jsonObject.put("selectImage",x.getSelectImage());
				 
				  jsonArray.put(jsonObject); 
			  }
			  resourceResponse.getWriter().print(jsonArray.toJSONString());
			log.info("jsonObject___________________"+jsonArray);
			
		} catch (NoSuchFieldConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		
	}
	
	public void forDataSave(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortalException, FileNotFoundException {

		log.info("In fieldconfig saveData resource method___________________________________________");
		
		String fieldName = ParamUtil.get(resourceRequest, "fieldName", "");
		log.info("fieldName_________________________________"+fieldName);
		
		Boolean fieldShow = ParamUtil.getBoolean(resourceRequest, "showFieldValue");
        log.info("fieldShow_________________________________"+fieldShow);
        
        String  status = ParamUtil.get(resourceRequest, "selectedOptionId", "");
        log.info("status_______________"+status);
  
	 
		String allDataArrayString = ParamUtil.getString(resourceRequest, "allDataArray");

			log.info("allDataArray_________________________________"+allDataArrayString);
			
	        JSONArray allDataArray = JSONFactoryUtil.createJSONArray(allDataArrayString);

	        
	        
	      if(status.equalsIgnoreCase("1")) {
	        for (int i = 0; i < allDataArray.length(); i++) {

	        	
	            JSONObject rowData = allDataArray.getJSONObject(i);
	            String id = rowData.getString("id");
	            
				String selectImage = rowData.getString("selectImage"); 
				log.info("selected Image___________________" +selectImage);
	            String fieldData = rowData.getString("fieldData");
	            log.info("fieldData_________________________________"+fieldData);
	            String fieldValue = rowData.getString("fieldValue").replace(",", "");
	            log.info("fieldValue_________________________________"+fieldValue);
	            String fieldSumAssured = rowData.getString("fieldSumAssured");
	            log.info("fieldSumAssured_________________________________"+fieldSumAssured);
	            
	            
			
	            FieldConfiguration addData;
	            if(id.isEmpty() || id == null) {
	            	long idAdd = CounterLocalServiceUtil.increment(FieldConfiguration.class.getName());
		            	log.info("nowImAddingData_______________________________________");
		            	 addData = fieldConfigurationLocalService.addFieldConfig(idAdd, fieldName, fieldData, fieldValue, fieldSumAssured, fieldShow,selectImage);	
	            } 
	            else {
		            FieldConfiguration data =fieldConfigurationLocalService.getFieldConfiguration(Long.parseLong(id));

	            	log.info("nowImUpdatatingData__________________________________");
	            	data = fieldConfigurationLocalService.getFieldConfiguration(Long.parseLong(id));
	            	data.setFieldName(fieldName);
	            		data.setFieldData(fieldData);
	            		data.setFieldValue(fieldValue);
	            		data.setFieldSumAssured(fieldSumAssured);
	            		data.setFieldShow(fieldShow);
	            		data.setSelectImage(selectImage);
	            		data = FieldConfigurationLocalServiceUtil.updateFieldConfiguration(data);	
	            }
	       
	        }
	        
	        }else {
	        	List<FieldConfiguration> fieldValues = fieldConfigurationLocalService.getByfieldName(fieldName);
	        	
	        	if(fieldValues.size() > 0) {
	        		FieldConfiguration data = fieldConfigurationLocalService.getFieldConfiguration(fieldValues.get(0).getConfigId());
	        		data.setFieldShow(fieldShow);
	        		fieldConfigurationLocalService.updateFieldConfiguration(data);
	        	} else {
	        		long idAdd = CounterLocalServiceUtil.increment(FieldConfiguration.class.getName());
	        		fieldConfigurationLocalService.addFieldConfig(idAdd, fieldName, "", "", "", fieldShow,"");	
	        	}
	        }
	}
}
