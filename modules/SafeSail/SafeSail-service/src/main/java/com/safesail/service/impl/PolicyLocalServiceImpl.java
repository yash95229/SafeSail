/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.safesail.service.impl;

import com.liferay.portal.aop.AopService;
import com.safesail.exception.NoSuchPolicyException;
import com.safesail.model.Policy;
import com.safesail.model.impl.PolicyImpl;
import com.safesail.service.base.PolicyLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.safesail.model.Policy",
	service = AopService.class
)
public class PolicyLocalServiceImpl extends PolicyLocalServiceBaseImpl {
	
	public Policy addPolicy(long bookingId,long applicationNumber,long userId,String fullName,String planName,String annualIncome,long sumAssured,
			int ppterm,String frequency,long premium,String quoteId,int status,long totalAddon ) {

		Policy register=new PolicyImpl();
		
		register.setBookingId(bookingId);
		register.setApplicationNumber(applicationNumber);
		register.setUserId(userId);
		register.setFullName(fullName);
		register.setPlanName(planName);
		register.setAnnualIncome(annualIncome);
		register.setSumAssured(sumAssured);
		register.setQuoteId(quoteId);
		register.setStatus(status);
		register.setPolicyTerm(ppterm);
		register.setPaymentFrequency(frequency);
		register.setTotalPremium(premium);
		register.setTotalAddon(totalAddon);
		policyLocalService.addPolicy(register);
		
		return null;
	}
	
	
	
	public Policy getByQuoteId(String quoteId) throws NoSuchPolicyException {
		
		Policy quoteid = null;
		quoteid = policyPersistence.findByquoteId(quoteId);
			
		return quoteid;
	}
	
	public Policy getapplicationNumber(long applicationNumber) throws NoSuchPolicyException {
		
		Policy applicationnumber = null;
		applicationnumber = policyPersistence.findByapplicationNumber(applicationNumber);
			
		return applicationnumber;
	}
	
	public List getUser(long userId) {

		List userid = null;
		userid = policyPersistence.findByuserId(userId);
			
		return userid;
	}
	
}