package Policies.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.safesail.model.Policy;
import com.safesail.service.PolicyLocalServiceUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import Policies.constants.PoliciesPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + PoliciesPortletKeys.POLICIES,
"mvc.command.name=/successData" }, service = MVCResourceCommand.class)
public class PaymentSuccessResource extends BaseMVCResourceCommand{

	Log log = LogFactoryUtil.getLog(PaymentSuccessResource.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		log.info("In PoliciesPortlet PaymentSuccessResource_____________________");
		
				String orderId = ParamUtil.get(resourceRequest, "orderId", "");
				log.info("orderId_________________________________" + orderId);
				String paymentId = ParamUtil.get(resourceRequest, "paymentId", "");
				log.info("paymentId_________________________________" + paymentId);
				String signature = ParamUtil.get(resourceRequest, "signature", "");
				log.info("signature_________________________________"  + signature);
				long applicationNo = Long.parseLong(ParamUtil.get(resourceRequest, "applicationNo", ""));
				log.info("applicationNumber_________________________________"  + applicationNo);

				RazorpayClient razorpay = new RazorpayClient("rzp_test_BGKF66W3loTH0T", "hjxFddt2FzBOwo2gH8M8kpqn");

				Order order = razorpay.Orders.fetch(orderId);
				
				String orderStatus = order.get("status");
				
				if(orderStatus.equalsIgnoreCase("paid")) {
					
					Policy policy = PolicyLocalServiceUtil.getapplicationNumber(applicationNo);
					log.info("policyDataBeforeUpdate___________________________________"+policy);
					
					policy.setStatus(1);
					policy = PolicyLocalServiceUtil.updatePolicy(policy);
					
					log.info("policyDataAfterUpdate___________________________________"+policy);
					log.info("orderStatus___________________________________"+orderStatus);
				}
		
	}

}
