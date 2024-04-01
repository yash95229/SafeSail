package com.safesailweb.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.LifeInsurance;
import com.safesail.model.UserTable;
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.UserTableLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		"mvc.command.name=saveRegister" }, service = MVCActionCommand.class)
public class PersonalDetailActionMethod extends BaseMVCActionCommand {

	Log log = LogFactoryUtil.getLog(PersonalDetailActionMethod.class);

	@Reference
	protected Portal portal;
	
	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;

	@Reference
	UserTableLocalService userTableLocalService;

	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		log.info("in personal detail process action method_________________________________________________");

		String fullName = ParamUtil.get(actionRequest, "fullName", "");

		String[] nameParts = fullName.split("\\s+");
		String firstName = nameParts[0];
		String lastName = (nameParts.length > 1) ? nameParts[1] : firstName;
		
		log.info("NameParts_____________________________________firstName: "+firstName+" ,lastName: "+lastName);

		long phoneNumber = ParamUtil.getLong(actionRequest, "number", 0);
		String email = ParamUtil.get(actionRequest, "email", "");
		SimpleDateFormat datehere = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = (Date) ParamUtil.getDate(actionRequest, "dob", datehere);
		String visitorGender = ParamUtil.get(actionRequest, "gender", "");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String panNumber = ParamUtil.get(actionRequest, "panNumber", "");
		String aadharNumber = ParamUtil.get(actionRequest, "aadharNumber", "");
		log.info("aadhar_______________________"+aadharNumber);
		
		String annualIncome =ParamUtil.get(actionRequest, "annualIncomeFieldData", ""); 
		log.info("annualIncomeData_____________________"+annualIncome);
		
		String sumAssuredVal= ParamUtil.get(actionRequest, "annualIncome", ""); 
		sumAssuredVal = sumAssuredVal.replaceAll(",", ""); 
		long sumAssured = Long.parseLong(sumAssuredVal);
		log.info("sumAssured____________________________"+sumAssured);
		

		String[] check = ParamUtil.getParameterValues(actionRequest, "condition");
		Boolean condition = true;
		if (check.length == 0) {
			condition = false;
		}

		// creating a unique quote id long
		long id = CounterLocalServiceUtil.increment(LifeInsurance.class.getName());
		String quoteId = getNumberingFormat(id);

		log.info("quoteId________________________"+quoteId);
		// this condition is whether user is sign in or not
		if (themeDisplay.isSignedIn()) {

			log.info("user is signed in___________________");

			String[] genderArr = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), User.class.getName(),
					"CUSTOM_FIELDS", "gender", themeDisplay.getUserId(), new String[] { "none" });
			String gender = genderArr[0];

			long userId = themeDisplay.getUserId();
			
			LifeInsurance lastData = lifeInsuranceLocalService.getUser(userId);


			lastData = lifeInsuranceLocalService.addReg(quoteId, fullName, email, phoneNumber, annualIncome, panNumber,
					dob, gender, condition, sumAssured, userId, aadharNumber);

			UserTable user = userTableLocalService.addUser(quoteId, userId, "user");

			log.info("In Signin UserData___________________" + lastData);

			// these are few required data for next page
			/* actionResponse.setRenderParameter("quoteId", quoteId); */
			actionRequest.setAttribute("forms", lastData);
			
			actionRequest.setAttribute(WebKeys.REDIRECT,
					PortletURLBuilder.createRenderURL(portal.getLiferayPortletResponse(actionResponse))
							.setMVCRenderCommandName("/incomeDetail").setParameter("quoteId", quoteId).buildString());

			
			/*
			 * actionResponse.setRenderParameter("mvcRenderCommandName", "/incomeDetail");
			 */

		} else {
			// fresh visitor page this is data is coming from visitor table
			log.info("for visitor signin______________________");

			log.info("before user created____________________________________");

			LifeInsurance lastData =null;
			try {

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dob);
				
				ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
				
				String password = firstName + String.valueOf(phoneNumber);
				
				
				log.info("Password created_________________________"+password); 

				
				User visitorUser =null;
				try {
					
				
					visitorUser = UserLocalServiceUtil.addUserWithWorkflow(0, themeDisplay.getCompanyId(), false,
						password, password, false,firstName+String.valueOf(CounterLocalServiceUtil.increment(User.class.getName())), email, themeDisplay.getLocale(), firstName, "",lastName, 0,
						0, true, calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH) , calendar.get(Calendar.YEAR), "", new long[0], new long[0], new long[0],
						new long[0], false, serviceContext);
				
				}catch(Exception e) {
					log.error("something went wrong while creating user",e);
				}
				log.info("after user created______________________________________ " + visitorUser);
				
				lastData = lifeInsuranceLocalService.addReg(quoteId, fullName, email, phoneNumber,
						annualIncome, panNumber, dob, visitorGender, condition, sumAssured,visitorUser.getUserId() , aadharNumber);
				log.info("visitorData____________________________________________" + lastData);
				
				UserTable user = userTableLocalService.addUser(quoteId,visitorUser.getUserId() , "visitor");

			
				/* actionResponse.setRenderParameter("quoteId", quoteId); */
				

				
				
				  // autoLogin visitor
				  
				  HttpServletRequest httpServletRequest = PortalUtil
				  .getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
				  HttpServletResponse httpServletResponse =
				  PortalUtil.getHttpServletResponse(actionResponse);
				  
				  String screenName = visitorUser.getScreenName();
				  
				  HttpSession session = httpServletRequest.getSession();
				  session.setAttribute("screenName", screenName);
				  
				  VisitorAutoLogin visitorlogin = new VisitorAutoLogin();
				  
				  visitorlogin.login(httpServletRequest, httpServletResponse);
				 
				 //email notification
				  
				  String from = "safesailteam@gmail.com";

					
					InternetAddress toAddress = new InternetAddress();
					
					toAddress.setAddress(email);
					
					MailMessage mailMessage = new MailMessage();
					mailMessage.setFrom(new InternetAddress(from));
					mailMessage.setTo(toAddress);
					mailMessage.setBody("User Created Successfully");
					mailMessage.setSubject("Send mail by Using Tempelate");
					mailMessage.setHTMLFormat(true);
					
					log.info("mailReminder___________________________"+mailMessage.getBody().toString());
										
					MailServiceUtil.sendEmail(mailMessage);
					
					
				// custom field
				
				ExpandoValue genderValue = ExpandoValueLocalServiceUtil.addValue(themeDisplay.getCompanyId(), User.class.getName(),
						"CUSTOM_FIELDS", "gender", visitorUser.getUserId(), new String[] { visitorGender });
				ExpandoValue city = ExpandoValueLocalServiceUtil.addValue(themeDisplay.getCompanyId(), User.class.getName(),
						"CUSTOM_FIELDS", "City", visitorUser.getUserId(), new String[] { "Ahmedabad" });
				ExpandoValue maritalStatus = ExpandoValueLocalServiceUtil.addValue(themeDisplay.getCompanyId(), User.class.getName(),
						"CUSTOM_FIELDS", "Marital Status", visitorUser.getUserId(), new String[] { "Un-married" });
				log.info("User id fetched :::::::::::::::::::: "+visitorUser.getUserId());
				
				ExpandoValue panCardNumber = ExpandoValueLocalServiceUtil.addValue(themeDisplay.getCompanyId(), User.class.getName(),
						"CUSTOM_FIELDS", "panNumber", visitorUser.getUserId(), panNumber);
				
				ExpandoValueLocalServiceUtil.updateExpandoValue(genderValue);
				 ExpandoValueLocalServiceUtil.updateExpandoValue(panCardNumber);
				 ExpandoValueLocalServiceUtil.updateExpandoValue(maritalStatus);
				 ExpandoValueLocalServiceUtil.updateExpandoValue(city);
				

					
			Phone phone=PhoneLocalServiceUtil.addPhone(visitorUser.getUserId(),
					  User.class.getName(), visitorUser.getUserId(), phoneNumber+"", "", 11008,
					  true, serviceContext);
					 
			PhoneLocalServiceUtil.updatePhone(phone);
			
				log.info("phone_____________________________________"+phone);
				
				log.info("expandoValue________________________"+genderValue+panCardNumber+maritalStatus+city);
				
				
				Address address=AddressLocalServiceUtil.addAddress(null, visitorUser.getUserId(), User.class.getName(),  visitorUser.getUserId(), visitorUser.getFirstName(), "description", 
						"Ahmedabad", "Ahmedabad", "Ahmedabad", "Ahmedabad", "4122332", 12345, 20575, 11002, false, true,
						phoneNumber+"", serviceContext);
				AddressLocalServiceUtil.updateAddress(address);
				
			} catch (Exception e) {
				log.info(e);
			}
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String strDate = dateFormat.format(date);
			
			log.info(lastData.getQuoteId());
			
			
			/* actionResponse.setRenderParameter("quoteId", lastData.getQuoteId()); */
			actionRequest.setAttribute("forms", lastData);
			
			/*
			 * actionResponse.setRenderParameter("mvcRenderCommandName", "/incomeDetail");
			 */
			
			actionRequest.setAttribute(WebKeys.REDIRECT,
					PortletURLBuilder.createRenderURL(portal.getLiferayPortletResponse(actionResponse))
							.setMVCRenderCommandName("/incomeDetail").setParameter("quoteId", quoteId).buildString());

		}

		
	}
	
	

	// for creating quoteid this function is used
	public String getNumberingFormat(long id) {

		String numberData = "#";
		/*
		 * String numberData1 = "0";
		 */
		String numberData2 = alpha();
		numberData = numberData + id + numberData2;

		return numberData;
	}

	// for randow aplhabet we use this function in quoteid creation
	public String alpha() {

		// create a string of all characters
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 5;

		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphabet.length());

			// get character specified by index
			// from the string
			char randomChar = alphabet.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		return randomString;
	}

}
