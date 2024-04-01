package com.safesailweb.portlet;

import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.LifeInsurance;
import com.safesail.model.LifeInsuranceTable;
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.FieldConfigurationLocalServiceUtil;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.UserTableLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		"mvc.command.name=/personalDetail" })
public class PersonalDetails2MVCRenderCommand implements MVCRenderCommand {

	Log log = LogFactoryUtil.getLog(PersonalDetails2MVCRenderCommand.class);

	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;
	
	@Reference
	UserTableLocalService userTableLocalService;
	
	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		log.info(" InPersonalDetails2MVCRenderCommand________________________________");
		
		try {

			
			//for FullName ConfigField
			List<FieldConfiguration> fieldConfigurationFullName=null;
			try {
				fieldConfigurationFullName =fieldConfigurationLocalService.getByfieldName("fullName");
					
				Boolean fullNameFieldShow = false;
				for(FieldConfiguration x : fieldConfigurationFullName) {
						if(x.getFieldShow()) {
							fullNameFieldShow = true;
							break;
						}
					}
					
					renderRequest.setAttribute("fullNameFieldShow", fullNameFieldShow);
				} catch (NoSuchFieldConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			//for Date ConfigField
			List<FieldConfiguration> fieldConfigurationDate=null;
			try {
				fieldConfigurationDate =fieldConfigurationLocalService.getByfieldName("dob");
					
				Boolean dateFieldShow = false;
				for(FieldConfiguration x : fieldConfigurationDate) {
						if(x.getFieldShow()) {
							dateFieldShow = true;
							break;
						}
					}
					
					renderRequest.setAttribute("dateFieldShow", dateFieldShow);
				} catch (NoSuchFieldConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			//for Gender ConfigField
			List<FieldConfiguration> fieldConfigurationGender=null;
			try {
				fieldConfigurationGender =fieldConfigurationLocalService.getByfieldName("gender");
					
				Boolean genderFieldShow = false;
				for(FieldConfiguration x : fieldConfigurationGender) {
						if(x.getFieldShow()) {
							genderFieldShow = true;
							break;
						}
					}
					
					renderRequest.setAttribute("genderFieldShow", genderFieldShow);
				} catch (NoSuchFieldConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			log.info("Gender configuration :: "+fieldConfigurationGender);
			 renderRequest.setAttribute("fieldConfigurationGender", fieldConfigurationGender);
			
			//for PhoneNumber ConfigField
			List<FieldConfiguration> fieldConfigurationPhoneNo=null;
			try {
				fieldConfigurationPhoneNo =fieldConfigurationLocalService.getByfieldName("phoneNo");
					
				Boolean phoneNoFieldShow = false;
				for(FieldConfiguration x : fieldConfigurationPhoneNo) {
						if(x.getFieldShow()) {
							phoneNoFieldShow = true;
							break;
						}
					}
					
					renderRequest.setAttribute("phoneNoFieldShow", phoneNoFieldShow);
				} catch (NoSuchFieldConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			//for Email ConfigField
				List<FieldConfiguration> fieldConfigurationEmail=null;
				try {
					fieldConfigurationEmail =fieldConfigurationLocalService.getByfieldName("emailAddress");
						
					Boolean emailFieldShow = false;
					for(FieldConfiguration x : fieldConfigurationEmail) {
							if(x.getFieldShow()) {
								emailFieldShow = true;
								break;
							}
						}
						
						renderRequest.setAttribute("emailFieldShow", emailFieldShow);
					} catch (NoSuchFieldConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			
			
			//for AnnualIncome ConfigField
				List<FieldConfiguration> fieldConfiguration=null;
			try {
				
				fieldConfiguration =fieldConfigurationLocalService.getByfieldName("annualIncome");
				
				Boolean fieldShow = false;
				for(FieldConfiguration x : fieldConfiguration) {
					if(x.getFieldShow()) {
						fieldShow = true;
						break;
					}
				}
				
				renderRequest.setAttribute("fieldShow", fieldShow);
				
			} catch (NoSuchFieldConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 renderRequest.setAttribute("fieldConfigurationData", fieldConfiguration);
			log.info("annualIncomeData_______________________"+fieldConfiguration);
			
			
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

		
			
			//for AadharCard ConfigField
					List<FieldConfiguration> fieldConfigurationAadhar=null;
					try {
						fieldConfigurationAadhar =fieldConfigurationLocalService.getByfieldName("aadharNumber");
							
						Boolean aadharFieldShow = false;
						for(FieldConfiguration x : fieldConfigurationAadhar) {
								if(x.getFieldShow()) {
									aadharFieldShow = true;
									break;
								}
							}
							
							renderRequest.setAttribute("aadharFieldShow", aadharFieldShow);
						} catch (NoSuchFieldConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
			//for PanCard ConfigField
			List<FieldConfiguration> fieldConfigurationPanCard=null;
			try {
				fieldConfigurationPanCard =fieldConfigurationLocalService.getByfieldName("panNumber");
							
				Boolean panCardFieldShow = false;
				for(FieldConfiguration x : fieldConfigurationPanCard) {
						if(x.getFieldShow()) {
							panCardFieldShow = true;
								break;
								}
							}
							
				renderRequest.setAttribute("panCardFieldShow", panCardFieldShow);
						} catch (NoSuchFieldConfigurationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
			
			
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String gender="";
			String panNumber="";
			Date birthday;
			String number="";

			if (themeDisplay.isSignedIn()) {
				
				
				String quoteId = ParamUtil.get(renderRequest, "quoteId", "");
				
				LifeInsurance registerReg = lifeInsuranceLocalService.getQuoteId(quoteId);
				
				log.info("alldata_______________________________________"+registerReg);
				
				
				  String[]
				  genderArr=ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),
				  User.class.getName(), "CUSTOM_FIELDS", "gender", themeDisplay.getUserId(),
				  new String[] {"none"}); 
				  gender=genderArr[0];
				/* 
				 * panNumber=ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),
				 * User.class.getName(), "CUSTOM_FIELDS", "panNumber", themeDisplay.getUserId(),
				 * ""); User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
				 * 
				 * log.info("gender_______________________________________"+gender);
				 * log.info("panNumber_______________________________________"+panNumber);
				 * 
				 * String email = user.getEmailAddress();
				 * 
				 * List<Phone> phones = PhoneLocalServiceUtil.getPhones();
				 * 
				 * 
				 * for(Phone p : phones) { if(p.getUserId() == user.getUserId()) { number =
				 * p.getNumber(); break; } }
				 */
				
				/* Contact contact = ContactLocalServiceUtil.getContact(user.getContactId()); */
				/* birthday = user.getBirthday(); */
				
			
				renderRequest.setAttribute("birthday", registerReg.getDob());
				renderRequest.setAttribute("fullName", themeDisplay.getUser().getFirstName() +" "+ themeDisplay.getUser().getLastName());
				renderRequest.setAttribute("gender", gender);
				renderRequest.setAttribute("email", registerReg.getEmailAddress());
				renderRequest.setAttribute("panNumber",registerReg.getPanNumber());
				renderRequest.setAttribute("aadharNumber",registerReg.getAadharNumber());
				renderRequest.setAttribute("phoneNumber", registerReg.getPhoneNo());
				renderRequest.setAttribute("annualIncome", registerReg.getAnnualIncome());
				renderRequest.setAttribute("quoteId", quoteId);
				renderRequest.setAttribute("form", registerReg);
				renderRequest.setAttribute("sumAssured",registerReg.getSumAssured());
			} 
		}

		catch (Exception e) {
			log.error("Error PersonalDetails2MVCRenderCommand  " + e);
		}

		return "/view.jsp";
	}
	

}
