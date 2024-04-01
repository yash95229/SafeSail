package com.safesailweb.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.safesail.model.LifeInsurance;
import com.safesail.service.LifeInsuranceLocalServiceUtil;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
"mvc.command.name=checkEmailValidation" },
service = MVCResourceCommand.class)

public class EmailAddressServeresourse extends BaseMVCResourceCommand {

	Log log = LogFactoryUtil.getLog(PaymentOrderServeresource.class);
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
				
		log.info("in email validation_________________________________");
		
			String emailAddress = ParamUtil.get(resourceRequest, "email", "");
			List<LifeInsurance> emailList = LifeInsuranceLocalServiceUtil.getList(emailAddress);
			JSONArray jsonArray = new JSONFactoryUtil().createJSONArray();
			for (LifeInsurance listOfEmail : emailList) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("email", listOfEmail.getEmailAddress());
				jsonArray.put(jsonObject);
			}
	
			resourceResponse.getWriter().print(jsonArray);
	}
	
}
