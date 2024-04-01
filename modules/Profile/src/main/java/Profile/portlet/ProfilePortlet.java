package Profile.portlet;

import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.model.LifeInsurance;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Profile.constants.ProfilePortletKeys;


@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Profile", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + ProfilePortletKeys.PROFILE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ProfilePortlet extends MVCPortlet {

	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;
	
	Log log = LogFactoryUtil.getLog(ProfilePortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {

			log.info("In Profile Render Method___________________________________________");

			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			long contactId = themeDisplay.getUser().getContactId();
			long companyId = themeDisplay.getUser().getCompanyId();

			 String address=""; 
			 String number="";
			 User user = themeDisplay.getUser();
			/*
			 * String fullName="";
			 * if(user.getFirstName().equals(user.getLastName())) { fullName =
			 * user.getFirstName(); }else { fullName=user.getFullName(); }
			 */
				
			
				log.info("userDetails_______________________________"+user.getUserId());
			 
			// phone expandoValue	
			  List<Phone> phones = PhoneLocalServiceUtil.getPhones();
			  
			  for(Phone p : phones) {
				  if(p.getUserId() == user.getUserId())
				  { 
					  number = p.getNumber().toString(); 
					  break; 
				  
				  }
			  }
			 log.info("phones_______________________________________"+number);
			 
			
			 // address expandoValue
			  List<Address> addresses =AddressLocalServiceUtil.getAddresses();
			  
			  for(Address p : addresses) { 
				  if(p.getUserId() == user.getUserId()) { 
					  address  = p.getStreet1() + ", " + p.getStreet2() + ", " + p.getCity()+" - "
			  +p.getZip(); break; 
			  } } 
			  log.info("address_______________________________"+address);
			 
			
			/* String className = User.class.getName(); */
			
			// gender expandoValue
			String[] gender = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), User.class.getName(),
					"CUSTOM_FIELDS", "gender", themeDisplay.getUserId(), new String[] { "none" });
			
			log.info("gender_______________________________"+ gender[0]);
			
			// city expandoValue
			  String[] city = ExpandoValueLocalServiceUtil.getData(companyId,
			  User.class.getName(), "CUSTOM_FIELDS", "City", themeDisplay.getUserId(), new
			  String[] { "none" }); log.info("city_______________________________"+ city);
			 
			// panCard expandoValue
			String panCardNumber = ExpandoValueLocalServiceUtil.getData(companyId, User.class.getName(),
					"CUSTOM_FIELDS", "panNumber", themeDisplay.getUserId(), "");
			log.info("panCardNumber_______________________________"+ panCardNumber);
			
			// marital expandoValue
			String[] maritalStatus = ExpandoValueLocalServiceUtil.getData(companyId, User.class.getName(),
					"CUSTOM_FIELDS", "Marital Status", themeDisplay.getUserId(), new String[] { "none" });
			log.info("maritalStatus_______________________________"+ maritalStatus[0]);
			
			//log.info(gender[0] + " c:-" + city[0] + " p :- " + panCardNumber + " m :-" + maritalStatus[0]);

			
			
			String fullName="";
			if(user.getFirstName().equals(user.getLastName())) {
				fullName = user.getFirstName();
			}else {
				fullName=user.getFullName();
			}
			
			log.info("First name :::::::::: "+user.getFirstName());
			log.info("Last name :::::::::: "+user.getLastName());
			log.info("fullName_______________________"+fullName);
			
			long userId=user.getUserId();
			
			LifeInsurance register= LifeInsuranceLocalServiceUtil.getUser(userId);
			Date birthday = user.getBirthday();

			renderRequest.setAttribute("gender", gender[0]);
			renderRequest.setAttribute("city", city[0]); 
			renderRequest.setAttribute("panCardNumber", panCardNumber);
			renderRequest.setAttribute("maritalStatus", maritalStatus[0]);
			renderRequest.setAttribute("user", user);
			renderRequest.setAttribute("fullName",fullName);
			renderRequest.setAttribute("birthday", birthday);
			 renderRequest.setAttribute("phoneList", number); 
			 renderRequest.setAttribute("address", address); 
			 renderRequest.setAttribute("annualIncome", register.getAnnualIncome()); 
			 log.info("all details________________________________"+register);
		} catch (PortalException e) {
			

			e.printStackTrace();
		}
		super.render(renderRequest, renderResponse);
	}

	
}