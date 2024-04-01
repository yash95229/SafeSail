package com.safesailweb.portlet;

import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.safesail.exception.NoSuchPolicyException;
import com.safesail.model.LifeInsurance;
import com.safesail.model.Policy;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;
import com.safesail.service.PolicyLocalServiceUtil;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		 "mvc.command.name=saveOrderDetails" 
		},
service = MVCResourceCommand.class)


public class PaymentOrderServeresource  extends BaseMVCResourceCommand{

	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;
	
	Log log = LogFactoryUtil.getLog(PaymentOrderServeresource.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		 
		log.info("In PaymentOrderServeResource_________________________");
		
		 String applicationNo = ParamUtil.get(resourceRequest, "applicationNo", "");
		 log.info("applicationNo____________________________________"+applicationNo);
			long totalAddon= ParamUtil.getLong(resourceRequest, "totalAddon", 0);
		log.info("totalAddon________________________________________"+totalAddon);
		
			 String quoteId = ParamUtil.get(resourceRequest, "quoteId", "");
			
			 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		
			 String fullName=ParamUtil.get(resourceRequest, "fullName", "");
			 String email=ParamUtil.get(resourceRequest, "email", "");
			 long phoneNumber = ParamUtil.getLong(resourceRequest, "number", 0);
			 String panNumber=ParamUtil.get(resourceRequest, "panNumber", "");
			 
			 log.info("all Data______________________"+ fullName +phoneNumber + email+
					 panNumber);
			 User user=themeDisplay.getUser();

			 user.setEmailAddress(email);
			 UserLocalServiceUtil.updateUser(user);
		 
try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_BGKF66W3loTH0T", "hjxFddt2FzBOwo2gH8M8kpqn");
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", totalAddon*100);
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_12");
			Order order=razorpay.Orders.create(orderRequest);
			
			log.info("orderID________________________________ "+ order.get("id"));
			
			log.info("order status___________________________ "+ order.get("status"));
			
			String orderId = order.get("id");
			String orderStatus = order.get("status");

			
			
			JSONObject data = new JSONObject();

			data.put("razorPayKey","rzp_test_BGKF66W3loTH0T");
			data.put("orderId", orderId);
			data.put("currency","INR");
			data.put("orderStatus",orderStatus);
		
			
			resourceResponse.getWriter().print(data);
				  
			} catch (RazorpayException e) {
				System.out.println(e);
			}
		
		 
		
			 LifeInsurance lifeInsurance=null;
			try {
				 lifeInsurance = LifeInsuranceLocalServiceUtil.getLifeInsurance(quoteId);
			} catch (PortalException e1) {
				e1.printStackTrace();
			}
			
			int planTerm= lifeInsurance.getPPTerm();
			
			lifeInsurance.setFullname(fullName);
			lifeInsurance.setEmailAddress(email);
			lifeInsurance.setPhoneNo(phoneNumber);
			lifeInsurance.setPanNumber(panNumber);
			
		     
			LifeInsuranceLocalServiceUtil.updateLifeInsurance(lifeInsurance);
			
			log.info("lifeinusrance updated_________________________"+lifeInsurance);
			
			long totalVal = lifeInsurance.getTotalValues();
			
			long totaldifference = totalAddon - totalVal;
		log.info("addon_________"+totaldifference);
		
			
			 SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
				
			 Date currentDate = new Date();
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTime(currentDate);
			 Date bookingDate =calendar.getTime();
			 calendar.add(Calendar.YEAR, planTerm);
			 calendar.add(Calendar.MONTH, 1);
			 Date maturityDate = calendar.getTime();
			
		
			Policy policy=null;
			try {
				policy = PolicyLocalServiceUtil.getapplicationNumber(Long.parseLong(applicationNo));
			} catch (NoSuchPolicyException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			log.info("policy info___________________ " + policy);
		
			
			policy.setStatus(0);
			
		
			policy.setFullName(fullName);
			policy.setTotalPremium(totalAddon);
			policy.setBookingDate(bookingDate);
			policy.setMaturityDate(maturityDate);
			policy.setBookingDate(bookingDate);
			policy.setTotalAddon(totaldifference);
			PolicyLocalServiceUtil.updatePolicy(policy);
			log.info("policy updated_________________________"+policy);
			
	
	}

}
