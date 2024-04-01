package com.safesailweb.portlet;

import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.exception.NoSuchPolicyException;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.LifeInsurance;
import com.safesail.model.Policy;
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.FieldConfigurationLocalServiceUtil;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;
import com.safesail.service.PolicyLocalServiceUtil;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MainController", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		
		  "javax.portlet.init-param.add-process-action-success-action=false",
		  "com.liferay.portlet.action-url-redirect=true",
		 
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class MainControllerPortlet extends MVCPortlet {

	Log log = LogFactoryUtil.getLog(MainControllerPortlet.class);

	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;
	
	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		//While Coming First Time Render
		try {
			
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String gender="";
		String panNumber="";
		Date birthday;
		String number="";
		User user = null;
		long userId=0;
		
		if (themeDisplay.isSignedIn()) {
			
			user = themeDisplay.getUser();
			userId=user.getUserId();
			
			LifeInsurance registerReg = lifeInsuranceLocalService.getUser(userId);
			
			log.info("alldata_______________________________________"+registerReg);
			
			
			  String[] genderArr;
			
				genderArr = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),
				  User.class.getName(), "CUSTOM_FIELDS", "gender", themeDisplay.getUserId(),
				  new String[] {"none"});
			
			  gender=genderArr[0];
			  
			  log.info(gender);

				renderRequest.setAttribute("birthday", registerReg.getDob());
				renderRequest.setAttribute("fullName", registerReg.getFullname());
				renderRequest.setAttribute("gender",gender);
				renderRequest.setAttribute("email", registerReg.getEmailAddress());
				renderRequest.setAttribute("panNumber",registerReg.getPanNumber());
				renderRequest.setAttribute("aadharNumber",registerReg.getAadharNumber());
				renderRequest.setAttribute("phoneNumber", registerReg.getPhoneNo());
				/* renderRequest.setAttribute("annualIncome", registerReg.getAnnualIncome()); */
				renderRequest.setAttribute("quoteId", registerReg.getQuoteId());
				/* renderRequest.setAttribute("sumAssured",registerReg.getSumAssured()); */
				renderRequest.setAttribute("form", registerReg);
				
		}
			  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
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
	log.info("annualIncomeConfigData_______________________"+fieldConfiguration);
	
	
	
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
	

		super.doView(renderRequest, renderResponse);
	}
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		super.render(renderRequest, renderResponse);
	}
	/*
	 * @Override public void render(RenderRequest renderRequest, RenderResponse
	 * renderResponse) throws IOException, PortletException {
	 */
		// TODO Auto-generated method stub
/*	try {

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String panNumber = "";
			long annIncome = 0;
			long aadharNumber= 0;
			String[] genderArr;
			String fullName = "";
			String email = "";
			List<Phone> phoneList = null;
			Date dob = null;
			User user = null;
			String number="";
			
			String  gender="";
			long userId=0;

			if (themeDisplay.isSignedIn()) {
				
				log.info("maincontroller rendermethod__________________________________");
			
				user = themeDisplay.getUser();
				userId=user.getUserId();
				email = user.getEmailAddress();
	
				if(user.getFirstName().equals(user.getLastName())) {
					fullName = user.getFirstName();
				}else {
					fullName=user.getFullName();
				}
			
			
				List<Phone> phones = PhoneLocalServiceUtil.getPhones();
				
				
				for(Phone p : phones) {
					if(p.getUserId() == user.getUserId()) {
						number = p.getNumber();
						break;
					}
				}

		
				log.info("phoneNumber__________________"+number);
				
				
				dob = user.getBirthday();
				log.info("Birthday_________________________"+dob);

				
				 LifeInsurance form1 = null;
				
				 genderArr=ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), User.class.getName(),
						 "CUSTOM_FIELDS", "gender", themeDisplay.getUserId(), new String[] {"none"});
				 panNumber=ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), User.class.getName(),
						 "CUSTOM_FIELDS", "panNumber", themeDisplay.getUserId(), "");
				 
				 
				 gender=genderArr[0];
				 log.info("gender and pandNumber_________________________ "+gender+panNumber);
				 
				 
			}
			
		
			
		
			renderRequest.setAttribute("userId", userId);

			renderRequest.setAttribute("fullName", fullName);
			renderRequest.setAttribute("email", email);

			renderRequest.setAttribute("birthday", dob);
			renderRequest.setAttribute("phoneNumber", number);

			renderRequest.setAttribute("panNumber", panNumber);
			renderRequest.setAttribute("annIncome", annIncome);
			renderRequest.setAttribute("gender", gender);
		

		} catch (PortalException e) {
			e.printStackTrace();
		}*/
		
	/*	
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String gender="";
			String panNumber="";
			Date birthday;
			String number="";
			User user = null;
			long userId=0;
			
			if (themeDisplay.isSignedIn()) {
				
				user = themeDisplay.getUser();
				userId=user.getUserId();
				
				LifeInsurance registerReg = lifeInsuranceLocalService.getUser(userId);
				
				log.info("alldata_______________________________________"+registerReg);
				
				
				  String[]
				  genderArr=ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(),
				  User.class.getName(), "CUSTOM_FIELDS", "gender", themeDisplay.getUserId(),
				  new String[] {"none"}); 
				  gender=genderArr[0];*/
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
				
					
			/*
				renderRequest.setAttribute("birthday", registerReg.getDob());
				renderRequest.setAttribute("fullName", themeDisplay.getUser().getFirstName() +" "+ themeDisplay.getUser().getLastName());
				renderRequest.setAttribute("gender", gender);
				renderRequest.setAttribute("email", user.getEmailAddress());
				renderRequest.setAttribute("panNumber",registerReg.getPanNumber());
				renderRequest.setAttribute("aadharNumber",registerReg.getAadharNumber());
				renderRequest.setAttribute("phoneNumber", registerReg.getPhoneNo());
				renderRequest.setAttribute("annualIncome", registerReg.getAnnualIncome());
				renderRequest.setAttribute("quoteId", registerReg.getQuoteId());
				renderRequest.setAttribute("form", registerReg);
				
				
			} 
		}
		catch (Exception e) {
			log.error("Error PersonalDetails2MVCRenderCommand  " + e);
		}

		
		super.render(renderRequest, renderResponse);
	}*/
	
	
}