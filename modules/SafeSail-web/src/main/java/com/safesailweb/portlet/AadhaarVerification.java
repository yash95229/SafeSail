package com.safesailweb.portlet;


import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.safesail.service.AadhaarVerificationLocalService;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.PanCardVerificationLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
"mvc.command.name=checkAadharVerify" },
service = MVCResourceCommand.class)
public class AadhaarVerification extends BaseMVCResourceCommand {

Log log = LogFactoryUtil.getLog(AadhaarVerification.class);
	
	@Reference
	AadhaarVerificationLocalService aadhaarVerificationLocalService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		
		log.info("in aadharcard verification________________________________");
		
		String fullName = ParamUtil.get(resourceRequest, "fullName", "");
		String aadharNumber= ParamUtil.get(resourceRequest, "aadharNumber", "");
		
		log.info("fullName and aadhaar________________________"+fullName + aadharNumber);
		
		String userName = aadhaarVerificationLocalService.getUserByAadhaarNumber(aadharNumber);
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		if(Validator.isNotNull(userName)) {
			jsonObject.put("isExist",true );
			if(fullName.equalsIgnoreCase(userName)) {
				jsonObject.put("isValid",true );
			} else {
				jsonObject.put("isValid",false );
			}
		} else {
			jsonObject.put("isExist",false );
		}
		
		resourceResponse.getWriter().print(jsonObject);
		
		
	}
	

}
