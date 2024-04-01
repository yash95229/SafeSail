package com.safesailweb.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.safesail.exception.NoSuchPolicyException;
import com.safesail.model.Policy;
import com.safesail.service.PolicyLocalServiceUtil;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		"mvc.command.name=/make/payment" }, service = MVCActionCommand.class)
public class Payment implements MVCActionCommand {

	Log log = LogFactoryUtil.getLog(Payment.class);

	public boolean processAction(ActionRequest arg0, ActionResponse arg1) throws PortletException {
		log.info("Inside payment method");

		 
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        // Get the current date
        Date currentDate = new Date();

        // Create a Calendar instance and set it to the current date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        Date bookingDate =calendar.getTime();
        // Add 6 years
        calendar.add(Calendar.YEAR, 6);
        calendar.add(Calendar.MONTH, 1);

        // Get the date 6 years ahead
        Date maturityDate = calendar.getTime();
        
        String applicationNo = ParamUtil.get(arg0, "applicationNo", "");
		long totalAddon= ParamUtil.getLong(arg0, "totalAddon", 0);
		System.out.println(totalAddon);

		log.info("Policy no: " + applicationNo);

		Policy policy=null;
		try {
			policy = PolicyLocalServiceUtil.getapplicationNumber(Long.parseLong(applicationNo));
		} catch (NoSuchPolicyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("policy info: " + policy);

		policy.setStatus(1);
		policy.setTotalPremium(totalAddon);
		policy.setBookingDate(bookingDate);
		policy.setMaturityDate(maturityDate);
		policy.setBookingDate(bookingDate);
		PolicyLocalServiceUtil.updatePolicy(policy);
		log.info("policy updated");
		return true;
	}

}
