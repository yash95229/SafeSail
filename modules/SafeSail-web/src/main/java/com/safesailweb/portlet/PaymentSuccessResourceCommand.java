package com.safesailweb.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.safesail.model.LifeInsurance;
import com.safesail.model.Policy;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;
import com.safesail.service.PolicyLocalService;
import com.safesail.service.PolicyLocalServiceUtil;
import com.safesailweb.constants.MainControllerPortletKeys;

import javax.mail.internet.InternetAddress;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
"mvc.command.name=successfull" }, service = MVCResourceCommand.class)
public class PaymentSuccessResourceCommand extends BaseMVCResourceCommand {

	
	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;
	
	@Reference
	PolicyLocalService policyLocalService;
	
	Log log = LogFactoryUtil.getLog(PaymentSuccessResourceCommand.class);
	
	
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		log.info("inPaymentSuccessResource______________________________");
		 
		 String quoteId = ParamUtil.get(resourceRequest, "quoteId", "");
		log.info("quoteId______________________________________" + quoteId);
		
		String orderId = ParamUtil.get(resourceRequest, "orderId", "");
		log.info("orderId_____________________________________" + orderId);
		
		String paymentId = ParamUtil.get(resourceRequest, "paymentId", "");
		log.info("paymentId____________________________________" + paymentId);
		
		String signature = ParamUtil.get(resourceRequest, "signature", "");
		log.info("signature_____________________________________" + signature);
		
		long applicationNo = Long.parseLong(ParamUtil.get(resourceRequest, "applicationNo", ""));
		log.info("applicationNo_________________________________" + applicationNo);

		RazorpayClient razorpay = new RazorpayClient("rzp_test_BGKF66W3loTH0T", "hjxFddt2FzBOwo2gH8M8kpqn");

		LifeInsurance getData = null;

		getData = LifeInsuranceLocalServiceUtil.getQuoteId(quoteId);
		String email= getData.getEmailAddress();
		
		String from = "safesailteam@gmail.com";
		
		Order order = razorpay.Orders.fetch(orderId);
		String orderStatus= order.get("status");
		
		if(orderStatus.equalsIgnoreCase("paid")) {
			Policy policy = PolicyLocalServiceUtil.getapplicationNumber(applicationNo);
			policy.setStatus(1);
			policy = PolicyLocalServiceUtil.updatePolicy(policy);
			
			log.info("policyData______________________________"+policy);
			log.info("orderStauts______________________________"+orderStatus);
		}
		
		InternetAddress toAddress = new InternetAddress();
		
		toAddress.setAddress(email);
		
		MailMessage mailMessage = new MailMessage();
		mailMessage.setFrom(new InternetAddress(from));
		mailMessage.setTo(toAddress);
		mailMessage.setBody(getMailNotification(orderStatus));
		mailMessage.setSubject("Send mail by Using Tempelate");
	
		mailMessage.setHTMLFormat(true);
		
		log.info("mailReminder___________________________"+mailMessage.getBody().toString());
		
		
		MailServiceUtil.sendEmail(mailMessage);

	}
	
	public String getMailNotification(String orderStatus) {
			
			if(orderStatus.equalsIgnoreCase("paid")) {
				orderStatus="paid successfullly";
				log.info("Your Payment Successfully Completed");
			}else {
				orderStatus="Payment Failed";
				log.info("Payment Failed");
			}
			return orderStatus;
		}
	

}
