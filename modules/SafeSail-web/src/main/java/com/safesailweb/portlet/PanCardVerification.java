package com.safesailweb.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.PanCardVerificationLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
"mvc.command.name=checkPanVerify" },
service = MVCResourceCommand.class)
public class PanCardVerification extends BaseMVCResourceCommand {

	Log log = LogFactoryUtil.getLog(PanCardVerification.class);
	
	@Reference
	PanCardVerificationLocalService panCardVerificationLocalService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		
		log.info("in panCard verification________________________________");
		
		String fullName = ParamUtil.get(resourceRequest, "fullName", "");
		String panNumber= ParamUtil.get(resourceRequest, "panNumber", "");
		
		log.info("fullName and Pan________________________"+fullName + panNumber);
		
		String userName = panCardVerificationLocalService.getUserByPanNumber(panNumber);
		
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
