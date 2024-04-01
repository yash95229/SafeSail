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
import com.liferay.portal.kernel.exception.SystemException;
import com.safesail.exception.NoSuchLifeInsuranceException;
import com.safesail.model.LifeInsurance;
import com.safesail.model.impl.LifeInsuranceImpl;
import com.safesail.service.base.LifeInsuranceLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.safesail.model.LifeInsurance",
	service = AopService.class
)
public class LifeInsuranceLocalServiceImpl
	extends LifeInsuranceLocalServiceBaseImpl {
	
	
	public LifeInsurance addReg(String quoteId, String fullname, String email, long phoneNumber, String AnnualIncome,
			String panNumber, Date dob, String gender, Boolean condition, long sumAssured, long userId,String aadharNumber) {

		LifeInsurance registerReg = new LifeInsuranceImpl();
		registerReg.setQuoteId(quoteId);
		registerReg.setFullname(fullname);
		registerReg.setPhoneNo(phoneNumber);
		registerReg.setEmailAddress(email);
		registerReg.setDob(dob);
		registerReg.setGender(gender);
		
		registerReg.setPanNumber(panNumber);
		registerReg.setAnnualIncome(AnnualIncome);
		registerReg.setAgreement(condition);
		registerReg.setSumAssured(sumAssured);
		registerReg.setUserId(userId);
		registerReg.setAadharNumber(aadharNumber);
		lifeInsuranceLocalService.addLifeInsurance(registerReg);
		return registerReg;
	}
	
	public LifeInsurance addReg(String quoteId, String fullname, String email, long phoneNumber, String AnnualIncome,
			String panNumber, Date dob, String gender, Boolean condition, long sumAssured, long userId,String aadharNumber,
			int policyTerm,int ppterm,
			String paymentFrequency, String payoutOption,int lifeSecure, 
			int lifeplus, int CIPBenifit,long totalValues,long totalAddons) {

		LifeInsurance registerReg = new LifeInsuranceImpl();
		registerReg.setQuoteId(quoteId);
		registerReg.setFullname(fullname);
		registerReg.setPhoneNo(phoneNumber);
		registerReg.setEmailAddress(email);
		registerReg.setDob(dob);
		registerReg.setGender(gender);
		registerReg.setPanNumber(panNumber);
		registerReg.setAnnualIncome(AnnualIncome);
		registerReg.setAgreement(condition);
		registerReg.setSumAssured(sumAssured);
		registerReg.setUserId(userId);
		registerReg.setAadharNumber(aadharNumber);
		registerReg.setPolicyTerm(policyTerm);
		registerReg.setPPTerm(ppterm);
		registerReg.setPaymentFrequency(paymentFrequency);
		registerReg.setPayoutOption(payoutOption);
		registerReg.setLifeSecure(lifeSecure);
		registerReg.setLifePlus(lifeplus);
		registerReg.setCIPBenefit(CIPBenifit);
		registerReg.setTotalValues(totalValues);
		registerReg.setTotalAddon(totalAddons);
		
		
		lifeInsuranceLocalService.addLifeInsurance(registerReg);
		return registerReg;
	}
	
	
	
	
	
	public LifeInsurance getQuoteId(String quoteId) {
		LifeInsurance form = null;
	
			try {
				form = lifeInsurancePersistence.findByquoteId(quoteId);
			} catch (NoSuchLifeInsuranceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return form;

	}
	
	 public List getList(String emailAddress)throws SystemException{
		 return lifeInsurancePersistence.findByemailAddress(emailAddress);
		 
	 }
	
	
	
	
	public LifeInsurance getAadharNumber(String aadharNumber) {

		

		LifeInsurance form1 = null;
		try {
			
			form1 = lifeInsurancePersistence.findByaadharNumber(aadharNumber);
			
		} catch (Exception e) {
			
		}

		return form1;

	}
	

	public LifeInsurance getUser(long userId) {

		

		LifeInsurance form1 = null;
		try {
			
			form1 = lifeInsurancePersistence.findByuserId(userId);
			
		} catch (Exception e) {
		
		}

		return form1;

	}
}
