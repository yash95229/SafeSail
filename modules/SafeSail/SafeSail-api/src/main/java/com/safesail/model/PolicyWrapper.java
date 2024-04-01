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
 * This class is a wrapper for {@link Policy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Policy
 * @generated
 */
public class PolicyWrapper
	extends BaseModelWrapper<Policy> implements ModelWrapper<Policy>, Policy {

	public PolicyWrapper(Policy policy) {
		super(policy);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bookingId", getBookingId());
		attributes.put("applicationNumber", getApplicationNumber());
		attributes.put("userId", getUserId());
		attributes.put("fullName", getFullName());
		attributes.put("planName", getPlanName());
		attributes.put("annualIncome", getAnnualIncome());
		attributes.put("bookingDate", getBookingDate());
		attributes.put("sumAssured", getSumAssured());
		attributes.put("policyTerm", getPolicyTerm());
		attributes.put("maturityDate", getMaturityDate());
		attributes.put("paymentFrequency", getPaymentFrequency());
		attributes.put("totalPremium", getTotalPremium());
		attributes.put("totalAddon", getTotalAddon());
		attributes.put("status", getStatus());
		attributes.put("quoteId", getQuoteId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Long applicationNumber = (Long)attributes.get("applicationNumber");

		if (applicationNumber != null) {
			setApplicationNumber(applicationNumber);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String planName = (String)attributes.get("planName");

		if (planName != null) {
			setPlanName(planName);
		}

		String annualIncome = (String)attributes.get("annualIncome");

		if (annualIncome != null) {
			setAnnualIncome(annualIncome);
		}

		Date bookingDate = (Date)attributes.get("bookingDate");

		if (bookingDate != null) {
			setBookingDate(bookingDate);
		}

		Long sumAssured = (Long)attributes.get("sumAssured");

		if (sumAssured != null) {
			setSumAssured(sumAssured);
		}

		Integer policyTerm = (Integer)attributes.get("policyTerm");

		if (policyTerm != null) {
			setPolicyTerm(policyTerm);
		}

		Date maturityDate = (Date)attributes.get("maturityDate");

		if (maturityDate != null) {
			setMaturityDate(maturityDate);
		}

		String paymentFrequency = (String)attributes.get("paymentFrequency");

		if (paymentFrequency != null) {
			setPaymentFrequency(paymentFrequency);
		}

		Long totalPremium = (Long)attributes.get("totalPremium");

		if (totalPremium != null) {
			setTotalPremium(totalPremium);
		}

		Long totalAddon = (Long)attributes.get("totalAddon");

		if (totalAddon != null) {
			setTotalAddon(totalAddon);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String quoteId = (String)attributes.get("quoteId");

		if (quoteId != null) {
			setQuoteId(quoteId);
		}
	}

	@Override
	public Policy cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the annual income of this policy.
	 *
	 * @return the annual income of this policy
	 */
	@Override
	public String getAnnualIncome() {
		return model.getAnnualIncome();
	}

	/**
	 * Returns the application number of this policy.
	 *
	 * @return the application number of this policy
	 */
	@Override
	public long getApplicationNumber() {
		return model.getApplicationNumber();
	}

	/**
	 * Returns the booking date of this policy.
	 *
	 * @return the booking date of this policy
	 */
	@Override
	public Date getBookingDate() {
		return model.getBookingDate();
	}

	/**
	 * Returns the booking ID of this policy.
	 *
	 * @return the booking ID of this policy
	 */
	@Override
	public long getBookingId() {
		return model.getBookingId();
	}

	/**
	 * Returns the full name of this policy.
	 *
	 * @return the full name of this policy
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the maturity date of this policy.
	 *
	 * @return the maturity date of this policy
	 */
	@Override
	public Date getMaturityDate() {
		return model.getMaturityDate();
	}

	/**
	 * Returns the payment frequency of this policy.
	 *
	 * @return the payment frequency of this policy
	 */
	@Override
	public String getPaymentFrequency() {
		return model.getPaymentFrequency();
	}

	/**
	 * Returns the plan name of this policy.
	 *
	 * @return the plan name of this policy
	 */
	@Override
	public String getPlanName() {
		return model.getPlanName();
	}

	/**
	 * Returns the policy term of this policy.
	 *
	 * @return the policy term of this policy
	 */
	@Override
	public int getPolicyTerm() {
		return model.getPolicyTerm();
	}

	/**
	 * Returns the primary key of this policy.
	 *
	 * @return the primary key of this policy
	 */
	@Override
	public com.safesail.service.persistence.PolicyPK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quote ID of this policy.
	 *
	 * @return the quote ID of this policy
	 */
	@Override
	public String getQuoteId() {
		return model.getQuoteId();
	}

	/**
	 * Returns the status of this policy.
	 *
	 * @return the status of this policy
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the sum assured of this policy.
	 *
	 * @return the sum assured of this policy
	 */
	@Override
	public long getSumAssured() {
		return model.getSumAssured();
	}

	/**
	 * Returns the total addon of this policy.
	 *
	 * @return the total addon of this policy
	 */
	@Override
	public long getTotalAddon() {
		return model.getTotalAddon();
	}

	/**
	 * Returns the total premium of this policy.
	 *
	 * @return the total premium of this policy
	 */
	@Override
	public long getTotalPremium() {
		return model.getTotalPremium();
	}

	/**
	 * Returns the user ID of this policy.
	 *
	 * @return the user ID of this policy
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this policy.
	 *
	 * @return the user uuid of this policy
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this policy.
	 *
	 * @return the uuid of this policy
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
	 * Sets the annual income of this policy.
	 *
	 * @param annualIncome the annual income of this policy
	 */
	@Override
	public void setAnnualIncome(String annualIncome) {
		model.setAnnualIncome(annualIncome);
	}

	/**
	 * Sets the application number of this policy.
	 *
	 * @param applicationNumber the application number of this policy
	 */
	@Override
	public void setApplicationNumber(long applicationNumber) {
		model.setApplicationNumber(applicationNumber);
	}

	/**
	 * Sets the booking date of this policy.
	 *
	 * @param bookingDate the booking date of this policy
	 */
	@Override
	public void setBookingDate(Date bookingDate) {
		model.setBookingDate(bookingDate);
	}

	/**
	 * Sets the booking ID of this policy.
	 *
	 * @param bookingId the booking ID of this policy
	 */
	@Override
	public void setBookingId(long bookingId) {
		model.setBookingId(bookingId);
	}

	/**
	 * Sets the full name of this policy.
	 *
	 * @param fullName the full name of this policy
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the maturity date of this policy.
	 *
	 * @param maturityDate the maturity date of this policy
	 */
	@Override
	public void setMaturityDate(Date maturityDate) {
		model.setMaturityDate(maturityDate);
	}

	/**
	 * Sets the payment frequency of this policy.
	 *
	 * @param paymentFrequency the payment frequency of this policy
	 */
	@Override
	public void setPaymentFrequency(String paymentFrequency) {
		model.setPaymentFrequency(paymentFrequency);
	}

	/**
	 * Sets the plan name of this policy.
	 *
	 * @param planName the plan name of this policy
	 */
	@Override
	public void setPlanName(String planName) {
		model.setPlanName(planName);
	}

	/**
	 * Sets the policy term of this policy.
	 *
	 * @param policyTerm the policy term of this policy
	 */
	@Override
	public void setPolicyTerm(int policyTerm) {
		model.setPolicyTerm(policyTerm);
	}

	/**
	 * Sets the primary key of this policy.
	 *
	 * @param primaryKey the primary key of this policy
	 */
	@Override
	public void setPrimaryKey(
		com.safesail.service.persistence.PolicyPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quote ID of this policy.
	 *
	 * @param quoteId the quote ID of this policy
	 */
	@Override
	public void setQuoteId(String quoteId) {
		model.setQuoteId(quoteId);
	}

	/**
	 * Sets the status of this policy.
	 *
	 * @param status the status of this policy
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the sum assured of this policy.
	 *
	 * @param sumAssured the sum assured of this policy
	 */
	@Override
	public void setSumAssured(long sumAssured) {
		model.setSumAssured(sumAssured);
	}

	/**
	 * Sets the total addon of this policy.
	 *
	 * @param totalAddon the total addon of this policy
	 */
	@Override
	public void setTotalAddon(long totalAddon) {
		model.setTotalAddon(totalAddon);
	}

	/**
	 * Sets the total premium of this policy.
	 *
	 * @param totalPremium the total premium of this policy
	 */
	@Override
	public void setTotalPremium(long totalPremium) {
		model.setTotalPremium(totalPremium);
	}

	/**
	 * Sets the user ID of this policy.
	 *
	 * @param userId the user ID of this policy
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this policy.
	 *
	 * @param userUuid the user uuid of this policy
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this policy.
	 *
	 * @param uuid the uuid of this policy
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
	protected PolicyWrapper wrap(Policy policy) {
		return new PolicyWrapper(policy);
	}

}