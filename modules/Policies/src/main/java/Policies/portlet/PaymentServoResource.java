package Policies.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.safesail.exception.NoSuchPolicyException;
import com.safesail.model.LifeInsurance;
import com.safesail.model.Policy;
import com.safesail.service.LifeInsuranceLocalServiceUtil;
import com.safesail.service.PolicyLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import Policies.constants.PoliciesPortletKeys;


@Component(immediate = true, property = { "javax.portlet.name=" + PoliciesPortletKeys.POLICIES,
"mvc.command.name=/createOrder1" }, service = MVCResourceCommand.class)
public class PaymentServoResource extends BaseMVCResourceCommand{

	Log log = LogFactoryUtil.getLog(PaymentServoResource.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		// TODO Auto-generated method stub
	
		log.info("In PoliciesPortlet PaymentResource_____________________");
		 
		long totalAddon= ParamUtil.getLong(resourceRequest, "totalAddon", 0);
		
		try {
			
			 RazorpayClient razorpay = new RazorpayClient("rzp_test_BGKF66W3loTH0T", "hjxFddt2FzBOwo2gH8M8kpqn");
			JSONObject orderRequest = new JSONObject();
			
			log.info("totaladdon________________________________________"+totalAddon);
			
			orderRequest.put("amount",totalAddon*100 ); 
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_12");
			
			Order order=razorpay.Orders.create(orderRequest);
			String orderId = order.get("id");
			String orderStatus = order.get("status");
			log.info("orderId_________________________ "+ orderId);
			log.info("orderStatus______________________ "+ orderStatus);
			
			JSONObject data = new JSONObject();
			data.put("razorPayKey","rzp_test_BGKF66W3loTH0T");
			data.put("orderId", orderId);
			data.put("currency","INR");
			data.put("orderStatus",orderStatus);			
			resourceResponse.getWriter().print(data);
			} catch (RazorpayException e) {
				System.out.println(e);
			}
		
		 
		 	String applicationNo = ParamUtil.get(resourceRequest, "applicationNo", "");
		 	String quoteId = ParamUtil.get(resourceRequest, "quoteId", "");
		 	
			 log.info("applicationNo_________________________________"  + applicationNo);
			 log.info("quoteId_________________________________" + quoteId);
			 
			 LifeInsurance lifeInsurance=null;
			try {
				 lifeInsurance = LifeInsuranceLocalServiceUtil.getLifeInsurance(quoteId);
			} catch (PortalException e1) {
				e1.printStackTrace();
			}
			 
			int planTerm= lifeInsurance.getPPTerm();
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
			
			log.info("policyDataBeforeUpdate___________________________________"+policy);
			
			policy.setStatus(0);
			policy.setTotalAddon(totaldifference);
			policy.setTotalPremium(totalAddon);
			policy.setBookingDate(bookingDate);
			policy.setMaturityDate(maturityDate);
			policy.setBookingDate(bookingDate);
			PolicyLocalServiceUtil.updatePolicy(policy);
		
			log.info("policyDataAfterUpdate___________________________________"+policy);
	
	}
}
