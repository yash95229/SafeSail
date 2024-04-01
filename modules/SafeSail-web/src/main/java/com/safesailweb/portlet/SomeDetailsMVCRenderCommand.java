package com.safesailweb.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.LifeInsurance;
import com.safesail.model.Policy;
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.PolicyLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		"mvc.command.name=/SomeDetails" })

public class SomeDetailsMVCRenderCommand implements MVCRenderCommand {

	@Reference
	LifeInsuranceLocalService lifeinsuranceLocalService;
	
	@Reference
	PolicyLocalService policyLocalService;
	
	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Log log = LogFactoryUtil.getLog(SomeDetailsMVCRenderCommand.class);
		
		
		
		try {

		
			log.info("inSomeDetailRender______________________________");
			
			List<FieldConfiguration> fieldConfigurationPolicyAddOn=null;
			try {
				fieldConfigurationPolicyAddOn =fieldConfigurationLocalService.getByfieldName("policyAddOn");
			} catch (NoSuchFieldConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 renderRequest.setAttribute("fieldConfigurationAddOnData", fieldConfigurationPolicyAddOn);
			log.info("fieldConfigurationPolicyAddOn_______________________"+fieldConfigurationPolicyAddOn);
			
			//for agreement ConfigField
			List<FieldConfiguration> fieldConfigurationAgreement=null;
		try {
			
			fieldConfigurationAgreement =fieldConfigurationLocalService.getByfieldName("agreement");
			
			Boolean AgreementfieldShow = false;
			for(FieldConfiguration x : fieldConfigurationAgreement) {
				if(x.getFieldShow()) {
					AgreementfieldShow = true;
					break;
				}
			}
			
			renderRequest.setAttribute("AgreementfieldShow", AgreementfieldShow);
			
		} catch (NoSuchFieldConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 renderRequest.setAttribute("fieldConfigurationAgreement", fieldConfigurationAgreement);
		log.info("fieldConfigurationAgreementData_______________________"+fieldConfigurationAgreement);

			
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String quoteId = ParamUtil.get(renderRequest, "quoteId", "");
			String totalAddons = ParamUtil.get(renderRequest, "totalAddon", "");
			long totalAddon=Long.parseLong(totalAddons);
			String applicationNo= ParamUtil.get(renderRequest, "applicationNo", "");
			long applicationNumber = Long.parseLong(applicationNo);
			String fullname=ParamUtil.get(renderRequest,"fullname","");
			
			LifeInsurance registerReg = lifeinsuranceLocalService.getLifeInsurance(quoteId);
			renderRequest.setAttribute("fullname", fullname);
			renderRequest.setAttribute("form",lifeinsuranceLocalService.getQuoteId(quoteId));
			renderRequest.setAttribute("quoteId", quoteId);
			renderRequest.setAttribute("paymentFreq",registerReg.getPaymentFrequency());
			Policy policy = policyLocalService.getapplicationNumber(applicationNumber);
			
			policy.setTotalPremium(totalAddon);
		
			policyLocalService.updatePolicy(policy);
			
			log.info("policyData______________________________"+policy);
		
			renderRequest.setAttribute("applicationNo", applicationNo);
			renderRequest.setAttribute("totalAddon", totalAddon);

		} catch (Exception e) {
			log.error(e + "Something Went Wrong");
		}
		


		return "/SomeDetailsAboutYou.jsp";
	}

}
