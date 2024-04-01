package com.payment.gateway.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.payment.gateway.constants.PaymentGatewayPortletKeys;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

/**
 * @author parthkadia
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PaymentGateway",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PaymentGatewayPortletKeys.PAYMENTGATEWAY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PaymentGatewayPortlet extends MVCPortlet {
	
	private static Log log = LogFactoryUtil.getLog(PaymentGatewayPortlet.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		

			
			
			super.render(renderRequest, renderResponse);
		}
	
		@Override
		public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
				throws IOException, PortletException {
		

		System.out.println("--------------------inside create order-----------------------------");
		 try {
			 
			 log.info("caaling......create order..........");
				
				RazorpayClient razorpay = new RazorpayClient("", "");
				JSONObject orderRequest = new JSONObject();
				orderRequest.put("amount", 100); // amount in the smallest currency unit
				orderRequest.put("currency", "INR");
				orderRequest.put("receipt", "order_rcptid_12");
				Order order = razorpay.Orders.create(orderRequest);
				
			log.info("order ID "+ order.get("id"));
			
			log.info("order Status "+ order.get("status"));
			
			String orderId = order.get("id");
			String orderStatus = order.get("status");

			
			JSONObject data = new JSONObject();

			data.put("razorPayKey","rzp_test_kCXHYZagLFqONi");
			data.put("orderId", orderId);
			data.put("currency","INR");
			data.put("orderStatus",orderStatus);
		
			
			resourceResponse.getWriter().print(data);
				  
			} catch (RazorpayException e) {
				System.out.println(e);
			}
	
	
			super.serveResource(resourceRequest, resourceResponse);
		}
	
		
	
}