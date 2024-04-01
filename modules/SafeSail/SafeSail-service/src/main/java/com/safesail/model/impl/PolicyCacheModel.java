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

package com.safesail.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.safesail.model.Policy;
import com.safesail.service.persistence.PolicyPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Policy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyCacheModel implements CacheModel<Policy>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyCacheModel)) {
			return false;
		}

		PolicyCacheModel policyCacheModel = (PolicyCacheModel)object;

		if (policyPK.equals(policyCacheModel.policyPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, policyPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append(", applicationNumber=");
		sb.append(applicationNumber);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", planName=");
		sb.append(planName);
		sb.append(", annualIncome=");
		sb.append(annualIncome);
		sb.append(", bookingDate=");
		sb.append(bookingDate);
		sb.append(", sumAssured=");
		sb.append(sumAssured);
		sb.append(", policyTerm=");
		sb.append(policyTerm);
		sb.append(", maturityDate=");
		sb.append(maturityDate);
		sb.append(", paymentFrequency=");
		sb.append(paymentFrequency);
		sb.append(", totalPremium=");
		sb.append(totalPremium);
		sb.append(", totalAddon=");
		sb.append(totalAddon);
		sb.append(", status=");
		sb.append(status);
		sb.append(", quoteId=");
		sb.append(quoteId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Policy toEntityModel() {
		PolicyImpl policyImpl = new PolicyImpl();

		if (uuid == null) {
			policyImpl.setUuid("");
		}
		else {
			policyImpl.setUuid(uuid);
		}

		policyImpl.setBookingId(bookingId);
		policyImpl.setApplicationNumber(applicationNumber);
		policyImpl.setUserId(userId);

		if (fullName == null) {
			policyImpl.setFullName("");
		}
		else {
			policyImpl.setFullName(fullName);
		}

		if (planName == null) {
			policyImpl.setPlanName("");
		}
		else {
			policyImpl.setPlanName(planName);
		}

		if (annualIncome == null) {
			policyImpl.setAnnualIncome("");
		}
		else {
			policyImpl.setAnnualIncome(annualIncome);
		}

		if (bookingDate == Long.MIN_VALUE) {
			policyImpl.setBookingDate(null);
		}
		else {
			policyImpl.setBookingDate(new Date(bookingDate));
		}

		policyImpl.setSumAssured(sumAssured);
		policyImpl.setPolicyTerm(policyTerm);

		if (maturityDate == Long.MIN_VALUE) {
			policyImpl.setMaturityDate(null);
		}
		else {
			policyImpl.setMaturityDate(new Date(maturityDate));
		}

		if (paymentFrequency == null) {
			policyImpl.setPaymentFrequency("");
		}
		else {
			policyImpl.setPaymentFrequency(paymentFrequency);
		}

		policyImpl.setTotalPremium(totalPremium);
		policyImpl.setTotalAddon(totalAddon);
		policyImpl.setStatus(status);

		if (quoteId == null) {
			policyImpl.setQuoteId("");
		}
		else {
			policyImpl.setQuoteId(quoteId);
		}

		policyImpl.resetOriginalValues();

		return policyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bookingId = objectInput.readLong();

		applicationNumber = objectInput.readLong();

		userId = objectInput.readLong();
		fullName = objectInput.readUTF();
		planName = objectInput.readUTF();
		annualIncome = objectInput.readUTF();
		bookingDate = objectInput.readLong();

		sumAssured = objectInput.readLong();

		policyTerm = objectInput.readInt();
		maturityDate = objectInput.readLong();
		paymentFrequency = objectInput.readUTF();

		totalPremium = objectInput.readLong();

		totalAddon = objectInput.readLong();

		status = objectInput.readInt();
		quoteId = objectInput.readUTF();

		policyPK = new PolicyPK(bookingId, applicationNumber, quoteId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bookingId);

		objectOutput.writeLong(applicationNumber);

		objectOutput.writeLong(userId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (planName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(planName);
		}

		if (annualIncome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(annualIncome);
		}

		objectOutput.writeLong(bookingDate);

		objectOutput.writeLong(sumAssured);

		objectOutput.writeInt(policyTerm);
		objectOutput.writeLong(maturityDate);

		if (paymentFrequency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentFrequency);
		}

		objectOutput.writeLong(totalPremium);

		objectOutput.writeLong(totalAddon);

		objectOutput.writeInt(status);

		if (quoteId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quoteId);
		}
	}

	public String uuid;
	public long bookingId;
	public long applicationNumber;
	public long userId;
	public String fullName;
	public String planName;
	public String annualIncome;
	public long bookingDate;
	public long sumAssured;
	public int policyTerm;
	public long maturityDate;
	public String paymentFrequency;
	public long totalPremium;
	public long totalAddon;
	public int status;
	public String quoteId;
	public transient PolicyPK policyPK;

}