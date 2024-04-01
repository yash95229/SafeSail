package com.safesailweb.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.AutoLoginException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.safesail.model.LifeInsurance;
import com.safesail.service.LifeInsuranceLocalServiceUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component
		(immediate = true,
		property = { 
			"auto.login.hooks=br.brandizzi.adam.liferay.insecure.InsecureAutoLogin,"
		},service = AutoLogin.class)
public class VisitorAutoLogin implements AutoLogin{

	@Override
	public String[] login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AutoLoginException {
		
		System.out.println("in autoLogin____________________________________");
		 HttpSession session = httpServletRequest.getSession();
		 String screenName = (String) session.getAttribute("screenName");
	    String quoteId = (String) session.getAttribute("quoteId");
        if (screenName == null || screenName.isEmpty())
            return null;
        try {
        	
			
			  long companyId = PortalUtil.getCompanyId(httpServletRequest); User user =
			  UserLocalServiceUtil.getUserByScreenName(companyId,screenName); 
			/*
			 * LifeInsurance lifeinsurance =
			 * LifeInsuranceLocalServiceUtil.getQuoteId(quoteId);
			 * 
			 * httpServletRequest.setAttribute("gender", lifeinsurance.getGender());
			 * httpServletRequest.setAttribute("fullName", lifeinsurance.getFullname());
			 * httpServletRequest.setAttribute("birthday", lifeinsurance.getDob());
			 * httpServletRequest.setAttribute("quoteId", lifeinsurance.getQuoteId());
			 * httpServletRequest.setAttribute("forms", lifeinsurance);
			 * httpServletRequest.setAttribute("totalValues",
			 * lifeinsurance.getTotalValues());
			 * 
			 * httpServletRequest.setAttribute("form", lifeinsurance);
			 */
			 
           
            
            return new String[] { 
            		String.valueOf(user.getUserId()),
                    user.getPassword(),
                    String.valueOf(user.isPasswordEncrypted()) 
            };
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;

	}
}