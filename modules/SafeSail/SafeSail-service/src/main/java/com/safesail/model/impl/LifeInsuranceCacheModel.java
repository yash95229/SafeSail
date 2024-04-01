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

import com.safesail.model.LifeInsurance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LifeInsurance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LifeInsuranceCacheModel
	implements CacheModel<LifeInsurance>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LifeInsuranceCacheModel)) {
			return false;
		}

		LifeInsuranceCacheModel lifeInsuranceCacheModel =
			(LifeInsuranceCacheModel)object;

		if (quoteId.equals(lifeInsuranceCacheModel.quoteId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quoteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", quoteId=");
		sb.append(quoteId);
		sb.append(", fullname=");
		sb.append(fullname);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", phoneNo=");
		sb.append(phoneNo);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", aadharNumber=");
		sb.append(aadharNumber);
		sb.append(", panNumber=");
		sb.append(panNumber);
		sb.append(", annualIncome=");
		sb.append(annualIncome);
		sb.append(", sumAssured=");
		sb.append(sumAssured);
		sb.append(", policyTerm=");
		sb.append(policyTerm);
		sb.append(", PPTerm=");
		sb.append(PPTerm);
		sb.append(", paymentFrequency=");
		sb.append(paymentFrequency);
		sb.append(", PayoutOption=");
		sb.append(PayoutOption);
		sb.append(", lifeSecure=");
		sb.append(lifeSecure);
		sb.append(", lifePlus=");
		sb.append(lifePlus);
		sb.append(", CIPBenefit=");
		sb.append(CIPBenefit);
		sb.append(", addOnBenefits=");
		sb.append(addOnBenefits);
		sb.append(", totalValues=");
		sb.append(totalValues);
		sb.append(", totalAddon=");
		sb.append(totalAddon);
		sb.append(", agreement=");
		sb.append(agreement);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LifeInsurance toEntityModel() {
		LifeInsuranceImpl lifeInsuranceImpl = new LifeInsuranceImpl();

		if (uuid == null) {
			lifeInsuranceImpl.setUuid("");
		}
		else {
			lifeInsuranceImpl.setUuid(uuid);
		}

		if (quoteId == null) {
			lifeInsuranceImpl.setQuoteId("");
		}
		else {
			lifeInsuranceImpl.setQuoteId(quoteId);
		}

		if (fullname == null) {
			lifeInsuranceImpl.setFullname("");
		}
		else {
			lifeInsuranceImpl.setFullname(fullname);
		}

		if (dob == Long.MIN_VALUE) {
			lifeInsuranceImpl.setDob(null);
		}
		else {
			lifeInsuranceImpl.setDob(new Date(dob));
		}

		if (gender == null) {
			lifeInsuranceImpl.setGender("");
		}
		else {
			lifeInsuranceImpl.setGender(gender);
		}

		lifeInsuranceImpl.setPhoneNo(phoneNo);

		if (emailAddress == null) {
			lifeInsuranceImpl.setEmailAddress("");
		}
		else {
			lifeInsuranceImpl.setEmailAddress(emailAddress);
		}

		if (aadharNumber == null) {
			lifeInsuranceImpl.setAadharNumber("");
		}
		else {
			lifeInsuranceImpl.setAadharNumber(aadharNumber);
		}

		if (panNumber == null) {
			lifeInsuranceImpl.setPanNumber("");
		}
		else {
			lifeInsuranceImpl.setPanNumber(panNumber);
		}

		if (annualIncome == null) {
			lifeInsuranceImpl.setAnnualIncome("");
		}
		else {
			lifeInsuranceImpl.setAnnualIncome(annualIncome);
		}

		lifeInsuranceImpl.setSumAssured(sumAssured);
		lifeInsuranceImpl.setPolicyTerm(policyTerm);
		lifeInsuranceImpl.setPPTerm(PPTerm);

		if (paymentFrequency == null) {
			lifeInsuranceImpl.setPaymentFrequency("");
		}
		else {
			lifeInsuranceImpl.setPaymentFrequency(paymentFrequency);
		}

		if (PayoutOption == null) {
			lifeInsuranceImpl.setPayoutOption("");
		}
		else {
			lifeInsuranceImpl.setPayoutOption(PayoutOption);
		}

		lifeInsuranceImpl.setLifeSecure(lifeSecure);
		lifeInsuranceImpl.setLifePlus(lifePlus);
		lifeInsuranceImpl.setCIPBenefit(CIPBenefit);

		if (addOnBenefits == null) {
			lifeInsuranceImpl.setAddOnBenefits("");
		}
		else {
			lifeInsuranceImpl.setAddOnBenefits(addOnBenefits);
		}

		lifeInsuranceImpl.setTotalValues(totalValues);
		lifeInsuranceImpl.setTotalAddon(totalAddon);
		lifeInsuranceImpl.setAgreement(agreement);
		lifeInsuranceImpl.setUserId(userId);

		lifeInsuranceImpl.resetOriginalValues();

		return lifeInsuranceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		quoteId = objectInput.readUTF();
		fullname = objectInput.readUTF();
		dob = objectInput.readLong();
		gender = objectInput.readUTF();

		phoneNo = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		aadharNumber = objectInput.readUTF();
		panNumber = objectInput.readUTF();
		annualIncome = objectInput.readUTF();

		sumAssured = objectInput.readLong();

		policyTerm = objectInput.readInt();

		PPTerm = objectInput.readInt();
		paymentFrequency = objectInput.readUTF();
		PayoutOption = objectInput.readUTF();

		lifeSecure = objectInput.readInt();

		lifePlus = objectInput.readInt();

		CIPBenefit = objectInput.readInt();
		addOnBenefits = objectInput.readUTF();

		totalValues = objectInput.readLong();

		totalAddon = objectInput.readLong();

		agreement = objectInput.readBoolean();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (quoteId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quoteId);
		}

		if (fullname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullname);
		}

		objectOutput.writeLong(dob);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(phoneNo);

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (aadharNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadharNumber);
		}

		if (panNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panNumber);
		}

		if (annualIncome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(annualIncome);
		}

		objectOutput.writeLong(sumAssured);

		objectOutput.writeInt(policyTerm);

		objectOutput.writeInt(PPTerm);

		if (paymentFrequency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(paymentFrequency);
		}

		if (PayoutOption == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PayoutOption);
		}

		objectOutput.writeInt(lifeSecure);

		objectOutput.writeInt(lifePlus);

		objectOutput.writeInt(CIPBenefit);

		if (addOnBenefits == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addOnBenefits);
		}

		objectOutput.writeLong(totalValues);

		objectOutput.writeLong(totalAddon);

		objectOutput.writeBoolean(agreement);

		objectOutput.writeLong(userId);
	}

	public String uuid;
	public String quoteId;
	public String fullname;
	public long dob;
	public String gender;
	public long phoneNo;
	public String emailAddress;
	public String aadharNumber;
	public String panNumber;
	public String annualIncome;
	public long sumAssured;
	public int policyTerm;
	public int PPTerm;
	public String paymentFrequency;
	public String PayoutOption;
	public int lifeSecure;
	public int lifePlus;
	public int CIPBenefit;
	public String addOnBenefits;
	public long totalValues;
	public long totalAddon;
	public boolean agreement;
	public long userId;

}