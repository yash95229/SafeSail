package com.safesailweb.portlet;

import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.LifeInsurance;
import com.safesail.model.ProductTable;
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.ProductTableLocalService;
import com.safesail.service.UserTableLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
"mvc.command.name=/incomeDetailBack" })

public class IncomeDetailsBackRender  implements MVCRenderCommand{

	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;
	
	@Reference
	UserTableLocalService userTableLocalService;
	
	@Reference
	ProductTableLocalService productTableLocalService;

	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	Log log = LogFactoryUtil.getLog(IncomeDetailsMVCRenderCommand.class);
	
	

		@Override
		public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

			try {
				
				log.info("IncomedetailBackRender______________________________________________ ");
				
				//fieldConfiguration policyterm
				log.info("fieldConfigurationPolicyTerm____________________________");
				List<FieldConfiguration> fieldConfigurationPolicyTerm=null;
				try {
					fieldConfigurationPolicyTerm =fieldConfigurationLocalService.getByfieldName("policyTerm");
					
					Boolean policyTermFieldShow = false;
					for(FieldConfiguration x : fieldConfigurationPolicyTerm) {
							if(x.getFieldShow()) {
								policyTermFieldShow = true;
								break;
							}
						}
						
						renderRequest.setAttribute("policyTermFieldShow", policyTermFieldShow);
					
				} catch (NoSuchFieldConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 renderRequest.setAttribute("fieldConfigurationPolicyTermData", fieldConfigurationPolicyTerm);
				log.info("policyTermData_______________________"+fieldConfigurationPolicyTerm);
				
				
				
				//fieldConfiguration paymentfrequency
				log.info("fieldConfigurationPaymentFrequency____________________________");
				List<FieldConfiguration> fieldConfigurationPaymentFrequency=null;
				try {
					fieldConfigurationPaymentFrequency =fieldConfigurationLocalService.getByfieldName("paymentFrequency");
					
					Boolean paymentFreqFieldShow = false;
					for(FieldConfiguration x : fieldConfigurationPaymentFrequency) {
							if(x.getFieldShow()) {
								paymentFreqFieldShow = true;
								break;
							}
						}
						
						renderRequest.setAttribute("paymentFreqFieldShow", paymentFreqFieldShow);
					
				} catch (NoSuchFieldConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				renderRequest.setAttribute("fieldConfigurationPaymentFreqData", fieldConfigurationPaymentFrequency);
				log.info("paymentFrequencyData_______________________"+fieldConfigurationPaymentFrequency);
				
				
				
				//fieldConfiguration payoutoption
				log.info("fieldConfigurationPayoutOption____________________________");
				List<FieldConfiguration> fieldConfigurationPayoutOption=null;
				try {
					fieldConfigurationPayoutOption =fieldConfigurationLocalService.getByfieldName("PayoutOption");
					
					Boolean payOutFieldShow = false;
					for(FieldConfiguration x : fieldConfigurationPayoutOption) {
							if(x.getFieldShow()) {
								payOutFieldShow = true;
								break;
							}
						}
						
						renderRequest.setAttribute("payOutFieldShow", payOutFieldShow);
					
				} catch (NoSuchFieldConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				renderRequest.setAttribute("fieldConfigurationPayoutData", fieldConfigurationPayoutOption);
				log.info("paymentFrequencyData_______________________"+fieldConfigurationPayoutOption);
				
				
				//fieldConfiguration PPTTerm
				log.info("fieldConfigurationPayoutOption____________________________");
				List<FieldConfiguration> fieldConfigurationPPTTerm=null;
				try {
					fieldConfigurationPPTTerm =fieldConfigurationLocalService.getByfieldName("PPTerm");
					
					Boolean PPTermFieldShow = false;
					for(FieldConfiguration x : fieldConfigurationPPTTerm) {
							if(x.getFieldShow()) {
								PPTermFieldShow = true;
								break;
							}
						}
						
						renderRequest.setAttribute("PPTermFieldShow", PPTermFieldShow);
					
				} catch (NoSuchFieldConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
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

				
				
				
				
				String quoteId = ParamUtil.get(renderRequest, "quoteId", "");
				
				log.info("quoteid_____________________________________________________"+quoteId);
				
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

				if (themeDisplay.isSignedIn()) {
					
					LifeInsurance registerReg = lifeInsuranceLocalService.getLifeInsurance(quoteId);

					log.info("alldata____________________________________"+registerReg);
					/*
					 * LifeInsurance lastData = (LifeInsurance) renderRequest.getAttribute("forms");
					 */
					/*
					 * log.info("IncomedetailRender______________________________________________ "
					 * +lastData);
					 */
					 
					String[] genderArr=ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), User.class.getName(), "CUSTOM_FIELDS", "gender", themeDisplay.getUserId(), new String[] {"none"});
					 String gender=genderArr[0];

					renderRequest.setAttribute("gender", gender);
					renderRequest.setAttribute("fullName", themeDisplay.getUser().getFullName());
					renderRequest.setAttribute("birthday", themeDisplay.getUser().getBirthday());
					renderRequest.setAttribute("quoteId", quoteId);
					renderRequest.setAttribute("totalValues", registerReg.getTotalValues());
				
					renderRequest.setAttribute("sumAssured", registerReg.getSumAssured());
					renderRequest.setAttribute("policyTerm", registerReg.getPolicyTerm());
					renderRequest.setAttribute("PPTterm",registerReg.getPPTerm());
					renderRequest.setAttribute("paymentFreq",registerReg.getPaymentFrequency());
					renderRequest.setAttribute("payOutOpt",registerReg.getPayoutOption());
					
				} 

				ProductTable product = productTableLocalService.fetchByProductName("Safe Sail Term Health Booster Plus");
				log.info("product______________________________" + product);
				renderRequest.setAttribute("product", product);
			} catch (Exception e) {
				// TODO: handle exception
			}

			
		return  "/IncomeDetail.jsp";
	}

}
