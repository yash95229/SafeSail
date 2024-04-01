package Policies.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.safesail.exception.NoSuchPolicyException;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.LifeInsurance;
import com.safesail.model.Policy;
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.FieldConfigurationLocalServiceUtil;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;
import com.safesail.service.PolicyLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Policies.constants.PoliciesPortletKeys;


@Component(immediate = true, property = { "javax.portlet.name=" + PoliciesPortletKeys.POLICIES,
"mvc.command.name=InsuranceList" }, service = MVCResourceCommand.class)
public class InsuranceResoruce extends BaseMVCResourceCommand{

	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	Log log = LogFactoryUtil.getLog(InsuranceResoruce.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
	
		try {
			
			log.info("In Insurance Serveresource________________________________________");
			 String quoteId = ParamUtil.get(resourceRequest, "quoteId", "");

		/*	 LifeInsurance insurance = LifeInsuranceLocalServiceUtil.getQuoteId(quoteId);
		
			 
			 List<FieldConfiguration> fieldConfigurationFieldName = fieldConfigurationLocalService.getByfieldName("policyAddOn");
			
			 JSONObject jsonObject = null;
			
			 JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

			 for (FieldConfiguration fieldData : fieldConfigurationFieldName) {
				 JSONObject addOnObj = JSONFactoryUtil.createJSONObject();
				 addOnObj.put("addonName", fieldData.getFieldData());
			     jsonArray.put(addOnObj);
			 }

			
				@SuppressWarnings("static-access")
				// adding the data to the jsonarray
				// To insert
				int totalvalues =(int)insurance.getTotalValues();
				
					jsonObject.put("aadharNumber", insurance.getAadharNumber());
					jsonObject.put("annualIncome", insurance.getAnnualIncome());
					jsonObject.put("addonBenefits", insurance.getAddOnBenefits());
					jsonObject.put("dob", insurance.getDob());
					jsonObject.put("gender", insurance.getGender());
					jsonObject.put("panNumber", insurance.getPanNumber());
					jsonObject.put("phoneno", insurance.getPhoneNo());
					jsonObject.put("totaladdon", insurance.getTotalAddon());
					jsonObject.put("totalamount", totalvalues);
					
					jsonArray.put(jsonObject);
					log.info("InsuranceList______________________________________________"+jsonArray);
					 resourceResponse.getWriter().print(jsonArray.toJSONString());*/
			/* resourceResponse.getWriter().print(jsonObject); */
			 
			 

			 	LifeInsurance insurance = LifeInsuranceLocalServiceUtil.getQuoteId(quoteId);

			 	int totalvalues =(int)insurance.getTotalValues();
				// JSON object for insurance details
				JSONObject insuranceObject = JSONFactoryUtil.createJSONObject();
				insuranceObject.put("aadharNumber", insurance.getAadharNumber());
				insuranceObject.put("annualIncome", insurance.getAnnualIncome());
				insuranceObject.put("addonBenefits", insurance.getAddOnBenefits());
				insuranceObject.put("dob", insurance.getDob());
				insuranceObject.put("gender", insurance.getGender());
				insuranceObject.put("panNumber", insurance.getPanNumber());
				insuranceObject.put("phoneno", insurance.getPhoneNo());
				insuranceObject.put("totaladdon", insurance.getTotalAddon());
				insuranceObject.put("totalamount", totalvalues);
				insuranceObject.put("paymentFrequency", insurance.getPaymentFrequency());

				// JSON array for add-on benefits
				JSONArray addOnArray = JSONFactoryUtil.createJSONArray();
				
				List<FieldConfiguration> fieldConfigurationFieldName = fieldConfigurationLocalService.getByfieldName("policyAddOn");
				for (FieldConfiguration fieldData : fieldConfigurationFieldName) {
				    JSONObject addOnObj = JSONFactoryUtil.createJSONObject();
				    addOnObj.put("addonName", fieldData.getFieldData());
				    addOnObj.put("addonValue",  fieldData.getFieldValue());
				    addOnArray.put(addOnObj);
				}
				
				// Combine insurance details and add-on benefits into a single JSON array
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
				jsonArray.put(insuranceObject);
				jsonArray.put(addOnArray);
				
				log.info("InsuranceList______________________________________________" + jsonArray);
				resourceResponse.getWriter().print(jsonArray.toJSONString());
			
		}catch(Exception e) {
			
		}
				
	}
}
