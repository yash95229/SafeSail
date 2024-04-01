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

package com.safesail.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LifeInsurance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LifeInsurance
 * @generated
 */
public class LifeInsuranceWrapper
	extends BaseModelWrapper<LifeInsurance>
	implements LifeInsurance, ModelWrapper<LifeInsurance> {

	public LifeInsuranceWrapper(LifeInsurance lifeInsurance) {
		super(lifeInsurance);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("quoteId", getQuoteId());
		attributes.put("fullname", getFullname());
		attributes.put("dob", getDob());
		attributes.put("gender", getGender());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("aadharNumber", getAadharNumber());
		attributes.put("panNumber", getPanNumber());
		attributes.put("annualIncome", getAnnualIncome());
		attributes.put("sumAssured", getSumAssured());
		attributes.put("policyTerm", getPolicyTerm());
		attributes.put("PPTerm", getPPTerm());
		attributes.put("paymentFrequency", getPaymentFrequency());
		attributes.put("PayoutOption", getPayoutOption());
		attributes.put("lifeSecure", getLifeSecure());
		attributes.put("lifePlus", getLifePlus());
		attributes.put("CIPBenefit", getCIPBenefit());
		attributes.put("addOnBenefits", getAddOnBenefits());
		attributes.put("totalValues", getTotalValues());
		attributes.put("totalAddon", getTotalAddon());
		attributes.put("agreement", getAgreement());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String quoteId = (String)attributes.get("quoteId");

		if (quoteId != null) {
			setQuoteId(quoteId);
		}

		String fullname = (String)attributes.get("fullname");

		if (fullname != null) {
			setFullname(fullname);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Long phoneNo = (Long)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String aadharNumber = (String)attributes.get("aadharNumber");

		if (aadharNumber != null) {
			setAadharNumber(aadharNumber);
		}

		String panNumber = (String)attributes.get("panNumber");

		if (panNumber != null) {
			setPanNumber(panNumber);
		}

		String annualIncome = (String)attributes.get("annualIncome");

		if (annualIncome != null) {
			setAnnualIncome(annualIncome);
		}

		Long sumAssured = (Long)attributes.get("sumAssured");

		if (sumAssured != null) {
			setSumAssured(sumAssured);
		}

		Integer policyTerm = (Integer)attributes.get("policyTerm");

		if (policyTerm != null) {
			setPolicyTerm(policyTerm);
		}

		Integer PPTerm = (Integer)attributes.get("PPTerm");

		if (PPTerm != null) {
			setPPTerm(PPTerm);
		}

		String paymentFrequency = (String)attributes.get("paymentFrequency");

		if (paymentFrequency != null) {
			setPaymentFrequency(paymentFrequency);
		}

		String PayoutOption = (String)attributes.get("PayoutOption");

		if (PayoutOption != null) {
			setPayoutOption(PayoutOption);
		}

		Integer lifeSecure = (Integer)attributes.get("lifeSecure");

		if (lifeSecure != null) {
			setLifeSecure(lifeSecure);
		}

		Integer lifePlus = (Integer)attributes.get("lifePlus");

		if (lifePlus != null) {
			setLifePlus(lifePlus);
		}

		Integer CIPBenefit = (Integer)attributes.get("CIPBenefit");

		if (CIPBenefit != null) {
			setCIPBenefit(CIPBenefit);
		}

		String addOnBenefits = (String)attributes.get("addOnBenefits");

		if (addOnBenefits != null) {
			setAddOnBenefits(addOnBenefits);
		}

		Long totalValues = (Long)attributes.get("totalValues");

		if (totalValues != null) {
			setTotalValues(totalValues);
		}

		Long totalAddon = (Long)attributes.get("totalAddon");

		if (totalAddon != null) {
			setTotalAddon(totalAddon);
		}

		Boolean agreement = (Boolean)attributes.get("agreement");

		if (agreement != null) {
			setAgreement(agreement);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public LifeInsurance cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the aadhar number of this life insurance.
	 *
	 * @return the aadhar number of this life insurance
	 */
	@Override
	public String getAadharNumber() {
		return model.getAadharNumber();
	}

	/**
	 * Returns the add on benefits of this life insurance.
	 *
	 * @return the add on benefits of this life insurance
	 */
	@Override
	public String getAddOnBenefits() {
		return model.getAddOnBenefits();
	}

	/**
	 * Returns the agreement of this life insurance.
	 *
	 * @return the agreement of this life insurance
	 */
	@Override
	public Boolean getAgreement() {
		return model.getAgreement();
	}

	/**
	 * Returns the annual income of this life insurance.
	 *
	 * @return the annual income of this life insurance
	 */
	@Override
	public String getAnnualIncome() {
		return model.getAnnualIncome();
	}

	/**
	 * Returns the cip benefit of this life insurance.
	 *
	 * @return the cip benefit of this life insurance
	 */
	@Override
	public int getCIPBenefit() {
		return model.getCIPBenefit();
	}

	/**
	 * Returns the dob of this life insurance.
	 *
	 * @return the dob of this life insurance
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the email address of this life insurance.
	 *
	 * @return the email address of this life insurance
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the fullname of this life insurance.
	 *
	 * @return the fullname of this life insurance
	 */
	@Override
	public String getFullname() {
		return model.getFullname();
	}

	/**
	 * Returns the gender of this life insurance.
	 *
	 * @return the gender of this life insurance
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the life plus of this life insurance.
	 *
	 * @return the life plus of this life insurance
	 */
	@Override
	public int getLifePlus() {
		return model.getLifePlus();
	}

	/**
	 * Returns the life secure of this life insurance.
	 *
	 * @return the life secure of this life insurance
	 */
	@Override
	public int getLifeSecure() {
		return model.getLifeSecure();
	}

	/**
	 * Returns the pan number of this life insurance.
	 *
	 * @return the pan number of this life insurance
	 */
	@Override
	public String getPanNumber() {
		return model.getPanNumber();
	}

	/**
	 * Returns the payment frequency of this life insurance.
	 *
	 * @return the payment frequency of this life insurance
	 */
	@Override
	public String getPaymentFrequency() {
		return model.getPaymentFrequency();
	}

	/**
	 * Returns the payout option of this life insurance.
	 *
	 * @return the payout option of this life insurance
	 */
	@Override
	public String getPayoutOption() {
		return model.getPayoutOption();
	}

	/**
	 * Returns the phone no of this life insurance.
	 *
	 * @return the phone no of this life insurance
	 */
	@Override
	public long getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the policy term of this life insurance.
	 *
	 * @return the policy term of this life insurance
	 */
	@Override
	public int getPolicyTerm() {
		return model.getPolicyTerm();
	}

	/**
	 * Returns the pp term of this life insurance.
	 *
	 * @return the pp term of this life insurance
	 */
	@Override
	public int getPPTerm() {
		return model.getPPTerm();
	}

	/**
	 * Returns the primary key of this life insurance.
	 *
	 * @return the primary key of this life insurance
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quote ID of this life insurance.
	 *
	 * @return the quote ID of this life insurance
	 */
	@Override
	public String getQuoteId() {
		return model.getQuoteId();
	}

	/**
	 * Returns the sum assured of this life insurance.
	 *
	 * @return the sum assured of this life insurance
	 */
	@Override
	public long getSumAssured() {
		return model.getSumAssured();
	}

	/**
	 * Returns the total addon of this life insurance.
	 *
	 * @return the total addon of this life insurance
	 */
	@Override
	public long getTotalAddon() {
		return model.getTotalAddon();
	}

	/**
	 * Returns the total values of this life insurance.
	 *
	 * @return the total values of this life insurance
	 */
	@Override
	public long getTotalValues() {
		return model.getTotalValues();
	}

	/**
	 * Returns the user ID of this life insurance.
	 *
	 * @return the user ID of this life insurance
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this life insurance.
	 *
	 * @return the user uuid of this life insurance
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this life insurance.
	 *
	 * @return the uuid of this life insurance
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the aadhar number of this life insurance.
	 *
	 * @param aadharNumber the aadhar number of this life insurance
	 */
	@Override
	public void setAadharNumber(String aadharNumber) {
		model.setAadharNumber(aadharNumber);
	}

	/**
	 * Sets the add on benefits of this life insurance.
	 *
	 * @param addOnBenefits the add on benefits of this life insurance
	 */
	@Override
	public void setAddOnBenefits(String addOnBenefits) {
		model.setAddOnBenefits(addOnBenefits);
	}

	/**
	 * Sets the agreement of this life insurance.
	 *
	 * @param agreement the agreement of this life insurance
	 */
	@Override
	public void setAgreement(Boolean agreement) {
		model.setAgreement(agreement);
	}

	/**
	 * Sets the annual income of this life insurance.
	 *
	 * @param annualIncome the annual income of this life insurance
	 */
	@Override
	public void setAnnualIncome(String annualIncome) {
		model.setAnnualIncome(annualIncome);
	}

	/**
	 * Sets the cip benefit of this life insurance.
	 *
	 * @param CIPBenefit the cip benefit of this life insurance
	 */
	@Override
	public void setCIPBenefit(int CIPBenefit) {
		model.setCIPBenefit(CIPBenefit);
	}

	/**
	 * Sets the dob of this life insurance.
	 *
	 * @param dob the dob of this life insurance
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the email address of this life insurance.
	 *
	 * @param emailAddress the email address of this life insurance
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the fullname of this life insurance.
	 *
	 * @param fullname the fullname of this life insurance
	 */
	@Override
	public void setFullname(String fullname) {
		model.setFullname(fullname);
	}

	/**
	 * Sets the gender of this life insurance.
	 *
	 * @param gender the gender of this life insurance
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the life plus of this life insurance.
	 *
	 * @param lifePlus the life plus of this life insurance
	 */
	@Override
	public void setLifePlus(int lifePlus) {
		model.setLifePlus(lifePlus);
	}

	/**
	 * Sets the life secure of this life insurance.
	 *
	 * @param lifeSecure the life secure of this life insurance
	 */
	@Override
	public void setLifeSecure(int lifeSecure) {
		model.setLifeSecure(lifeSecure);
	}

	/**
	 * Sets the pan number of this life insurance.
	 *
	 * @param panNumber the pan number of this life insurance
	 */
	@Override
	public void setPanNumber(String panNumber) {
		model.setPanNumber(panNumber);
	}

	/**
	 * Sets the payment frequency of this life insurance.
	 *
	 * @param paymentFrequency the payment frequency of this life insurance
	 */
	@Override
	public void setPaymentFrequency(String paymentFrequency) {
		model.setPaymentFrequency(paymentFrequency);
	}

	/**
	 * Sets the payout option of this life insurance.
	 *
	 * @param PayoutOption the payout option of this life insurance
	 */
	@Override
	public void setPayoutOption(String PayoutOption) {
		model.setPayoutOption(PayoutOption);
	}

	/**
	 * Sets the phone no of this life insurance.
	 *
	 * @param phoneNo the phone no of this life insurance
	 */
	@Override
	public void setPhoneNo(long phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the policy term of this life insurance.
	 *
	 * @param policyTerm the policy term of this life insurance
	 */
	@Override
	public void setPolicyTerm(int policyTerm) {
		model.setPolicyTerm(policyTerm);
	}

	/**
	 * Sets the pp term of this life insurance.
	 *
	 * @param PPTerm the pp term of this life insurance
	 */
	@Override
	public void setPPTerm(int PPTerm) {
		model.setPPTerm(PPTerm);
	}

	/**
	 * Sets the primary key of this life insurance.
	 *
	 * @param primaryKey the primary key of this life insurance
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quote ID of this life insurance.
	 *
	 * @param quoteId the quote ID of this life insurance
	 */
	@Override
	public void setQuoteId(String quoteId) {
		model.setQuoteId(quoteId);
	}

	/**
	 * Sets the sum assured of this life insurance.
	 *
	 * @param sumAssured the sum assured of this life insurance
	 */
	@Override
	public void setSumAssured(long sumAssured) {
		model.setSumAssured(sumAssured);
	}

	/**
	 * Sets the total addon of this life insurance.
	 *
	 * @param totalAddon the total addon of this life insurance
	 */
	@Override
	public void setTotalAddon(long totalAddon) {
		model.setTotalAddon(totalAddon);
	}

	/**
	 * Sets the total values of this life insurance.
	 *
	 * @param totalValues the total values of this life insurance
	 */
	@Override
	public void setTotalValues(long totalValues) {
		model.setTotalValues(totalValues);
	}

	/**
	 * Sets the user ID of this life insurance.
	 *
	 * @param userId the user ID of this life insurance
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this life insurance.
	 *
	 * @param userUuid the user uuid of this life insurance
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this life insurance.
	 *
	 * @param uuid the uuid of this life insurance
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LifeInsuranceWrapper wrap(LifeInsurance lifeInsurance) {
		return new LifeInsuranceWrapper(lifeInsurance);
	}

}