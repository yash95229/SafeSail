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
		"mvc.command.name=/termInsurances" })

public class TermInsuranceupdateMVCRenderCommand implements MVCRenderCommand {

	Log log = LogFactoryUtil.getLog(TermInsuranceupdateMVCRenderCommand.class);

	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	@Reference
	LifeInsuranceLocalService lifeinsuranceLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);


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

			
			
			
				String quoteId = ParamUtil.get(renderRequest, "quoteId","");
				System.out.println(quoteId);
				LifeInsurance registerReg = lifeinsuranceLocalService.getLifeInsurance(quoteId);
				renderRequest.setAttribute("quoteId", quoteId);
				renderRequest.setAttribute("form", registerReg);
				renderRequest.setAttribute("totalValues", registerReg.getTotalValues());
				renderRequest.setAttribute("paymentFreq",registerReg.getPaymentFrequency());
				renderRequest.setAttribute("totalAddon", registerReg.getTotalAddon());
			
				String[] addOnBenefitsArray = registerReg.getAddOnBenefits().split(";");
				
			
				int i=1;
				 for (String addOnField : addOnBenefitsArray) {
					  
					 renderRequest.setAttribute("addOnField"+i, addOnField);
					 log.info("addonField____________________________"+addOnField);
					 i++;
					}
				 
				
				
		} catch (Exception e) {
			log.error("Somthing Went Wrong "+e);
		}

		return "/TermInsurance.jsp";
	}

}
