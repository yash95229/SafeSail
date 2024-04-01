package Profile.portlet;

import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.model.LifeInsurance;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Profile.constants.ProfilePortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + ProfilePortletKeys.PROFILE,
		"mvc.command.name=updateProfile" }, 
service = MVCActionCommand.class)

public class ProfileUpdateActionMethod extends BaseMVCActionCommand {

	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;
	
	Log log = LogFactoryUtil.getLog(ProfilePortlet.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			log.info("In ProfileUpdate_____________________________________________");

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			String fullName = ParamUtil.getString(actionRequest, "fullName");
			String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");
			String email = ParamUtil.getString(actionRequest, "email");
			String panNumber = ParamUtil.getString(actionRequest, "panNumber");
			String maratialStatus = ParamUtil.getString(actionRequest, "maratilStatus");
			String annualIncome =ParamUtil.getString(actionRequest, "annualIncome");
			String gender = ParamUtil.getString(actionRequest, "gender");
			String city = ParamUtil.getString(actionRequest, "city");
			Date date = ParamUtil.getDate(actionRequest, "dob", dateFormat);
			String address = ParamUtil.getString(actionRequest, "address");
			long userId = ParamUtil.getLong(actionRequest, "userId");

			log.info("FullName_________ : " + fullName + "Annualincome______________________ : " + annualIncome + "City________________________ : " + city
					+ "Email_____________ : " + email + "gender_____________________ " + gender
					+ maratialStatus + panNumber + phoneNo + date + address);

			// update User email and Name
			User user = UserLocalServiceUtil.getUser(userId);

			String parts[] = fullName.split(" ");
			user.setEmailAddress(email);
			user.setFirstName(parts[0]);
			user.setLastName(parts[1]);
			UserLocalServiceUtil.updateUser(user);
			log.info("USer Updated...");

			// Update Phone Number
			List<Phone> phoneList = user.getPhones();
			for (Phone phone1 : phoneList) {
				Phone phone = PhoneLocalServiceUtil.getPhone(phone1.getPhoneId());
				if (phone1.getUserId() == userId) {
					log.info("In Condition Match");
					phone.setNumber(phoneNo);
					PhoneLocalServiceUtil.updatePhone(phone);
					log.info("Phone Updated");
				}

			}

			// Update Birthday
			Contact contact = ContactLocalServiceUtil.getContact(user.getContactId());
			contact.setBirthday(date);
			ContactLocalServiceUtil.updateContact(contact);
			log.info("Update Birthday");

			// Update Annual Income
		
			LifeInsurance annualincome = LifeInsuranceLocalServiceUtil.getUser(userId);
			annualincome.setAnnualIncome(annualIncome);
			LifeInsuranceLocalServiceUtil.updateLifeInsurance(annualincome);
		

			log.info("Annual Income Updated");			
			// Update Gender
			ExpandoValue expandoValueGender = ExpandoValueLocalServiceUtil.getValue(themeDisplay.getCompanyId(),
					User.class.getName(), "CUSTOM_FIELDS", "gender", userId);
			expandoValueGender.setData(gender);

			ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValueGender);
			log.info("gender Updated");

			// update city value
			ExpandoValue expandoValueCity = ExpandoValueLocalServiceUtil.getValue(themeDisplay.getCompanyId(),
					User.class.getName(), "CUSTOM_FIELDS", "City", userId);
			expandoValueCity.setData(city);

			ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValueCity);
			log.info("city Updated");

			// update Pan card Number
			ExpandoValue expandoValuePanNumber = ExpandoValueLocalServiceUtil.getValue(themeDisplay.getCompanyId(),
					User.class.getName(), "CUSTOM_FIELDS", "panNumber", userId);
			expandoValuePanNumber.setData(panNumber);
			ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValuePanNumber);
			log.info("panNumber Updated");

			// update Maratial Status
			ExpandoValue expandoValueMaratial = ExpandoValueLocalServiceUtil.getValue(themeDisplay.getCompanyId(),
					User.class.getName(), "CUSTOM_FIELDS", "Marital Status", userId);
			expandoValueMaratial.setData(maratialStatus);
			ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValueMaratial);
			log.info("maratial  Updated");

			List<Address> addresses = AddressLocalServiceUtil.getAddresses(themeDisplay.getCompanyId(),
					Contact.class.getName(), user.getContactId());

			// update Address
			
			String[] addArr = null ;
			if(address.contains(",")) {
				addArr = address.split(",");
				
			}
			if(address.contains(" ")) {
				addArr = address.split(" ");
				
			}
			log.info(addArr[0]+addArr[1]+addArr[2]+addArr[3]+addArr[4]);
			
			log.info("Address 	--------  "+ address);
			
			for (Address address2 : addresses) {
				Address updateAddress = AddressLocalServiceUtil.getAddress(address2.getAddressId());
				updateAddress.setStreet1(addArr[0]);
				updateAddress.setStreet2(addArr[1]);
				updateAddress.setCity(addArr[2]+addArr[3]);
				updateAddress.setZip(addArr[4]);
				
				log.info(addArr[0]+addArr[1]+addArr[2]+addArr[3]+addArr[4]);
				AddressLocalServiceUtil.updateAddress(updateAddress);
				
			}

		} catch (Exception e) {
			
			log.info("Something went wrong "+e);

		}
	}

}
