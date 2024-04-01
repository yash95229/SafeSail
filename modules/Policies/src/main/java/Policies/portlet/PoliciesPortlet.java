package Policies.portlet;


import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.segments.criteria.Criteria;
import com.razorpay.PaymentClient;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.safesail.model.LifeInsurance;
import com.safesail.model.Policy;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;
import com.safesail.service.PolicyLocalService;
import com.safesail.service.PolicyLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Policies.constants.PoliciesPortletKeys;


@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Policies",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/policy_view.jsp",
		"javax.portlet.name=" + PoliciesPortletKeys.POLICIES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PoliciesPortlet extends MVCPortlet {
	
Log log = LogFactoryUtil.getLog(PoliciesPortlet.class);
	
@Reference
PolicyLocalService policyLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		log.info("In PoliciesPortlets_____________________");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		//delta code
		
		int delta = ParamUtil.getInteger(renderRequest, "delta");
		int cur = ParamUtil.getInteger(renderRequest, "cur");
		int from = delta * (cur - 1);
		int to = delta == 0 ? 10 : delta * cur;
		
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_BGKF66W3loTH0T", "hjxFddt2FzBOwo2gH8M8kpqn");
			PaymentClient payment = razorpay.Payments;
			
		} catch (RazorpayException e) {
		
			e.printStackTrace();
		}
		
		//fetching admin
		
		
		Role adminRole=null;
		try {
			adminRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Administrator");
		} catch (PortalException e1) {
			
			e1.printStackTrace();
		}
		
		
		  User user= themeDisplay.getUser(); 
		  List<Role> roles = user.getRoles();
		
		  Boolean Administrator =false; 
		  for(Role role : roles ){ 
			  if(role.getRoleId() ==adminRole.getRoleId()) {
				  Administrator=true; 
				  }
			 }
		 
		List<Policy> policies =new ArrayList<>();
		List<Policy> counter=null;
		
		
	
		DynamicQuery dynamicQuery = PolicyLocalServiceUtil.dynamicQuery();
		
		log.info("adminRole____________________________"+adminRole);
		
		if(!Administrator){
		  dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(themeDisplay.getUserId())); 
		  }
		 
		  counter = PolicyLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		  
		  List<Policy>
		  result=counter.stream().sorted((o1,o2)->(int)(o2.getApplicationNumber()-o1.
		  getApplicationNumber())).collect(Collectors.toList());
		 
		  if(to>counter.size()) {
			  to = counter.size();
		  }
		  for(int i=from; i<to;i++) {
			 
				  policies.add(result.get(i));
			  
		  }
		  
	
		 renderRequest.setAttribute("counter",counter.size());

		 renderRequest.setAttribute("policyList",policies);
			
		 log.info("policyList________________________________"+policies);

		try {
			super.render(renderRequest, renderResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

	
	
}