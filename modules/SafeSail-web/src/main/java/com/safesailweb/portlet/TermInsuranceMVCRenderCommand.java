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
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		"mvc.command.name=/termInsurance" })

public class TermInsuranceMVCRenderCommand implements MVCRenderCommand {

	@Reference
	LifeInsuranceLocalService lifeinsuranceLocalService;
	
	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	Log log = LogFactoryUtil.getLog(TermInsuranceMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub


		try {
			log.info("in terminsurancerender__________________________________");

			
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
			
		
			LifeInsurance registerReg = lifeinsuranceLocalService.getLifeInsurance(quoteId);
		
			renderRequest.setAttribute("quoteId", quoteId);
			renderRequest.setAttribute("totalValues", registerReg.getTotalValues());
			renderRequest.setAttribute("totalAddon", registerReg.getTotalAddon());
			renderRequest.setAttribute("paymentFreq",registerReg.getPaymentFrequency());
			renderRequest.setAttribute("form", registerReg);
			/* renderRequest.setAttribute("addOnField", registerReg.getLifePlus()); */
		

		} catch (Exception e) {
			log.info("Somthing went wrong " + e);
		}

		return "/TermInsurance.jsp";
	}

}
