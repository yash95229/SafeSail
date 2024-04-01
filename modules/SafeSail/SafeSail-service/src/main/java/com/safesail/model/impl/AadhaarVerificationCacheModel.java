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

import com.safesail.model.AadhaarVerification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AadhaarVerification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AadhaarVerificationCacheModel
	implements CacheModel<AadhaarVerification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AadhaarVerificationCacheModel)) {
			return false;
		}

		AadhaarVerificationCacheModel aadhaarVerificationCacheModel =
			(AadhaarVerificationCacheModel)object;

		if (aadhaarId == aadhaarVerificationCacheModel.aadhaarId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, aadhaarId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{aadhaarId=");
		sb.append(aadhaarId);
		sb.append(", aadhaarUserName=");
		sb.append(aadhaarUserName);
		sb.append(", aadhaarNumber=");
		sb.append(aadhaarNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AadhaarVerification toEntityModel() {
		AadhaarVerificationImpl aadhaarVerificationImpl =
			new AadhaarVerificationImpl();

		aadhaarVerificationImpl.setAadhaarId(aadhaarId);

		if (aadhaarUserName == null) {
			aadhaarVerificationImpl.setAadhaarUserName("");
		}
		else {
			aadhaarVerificationImpl.setAadhaarUserName(aadhaarUserName);
		}

		if (aadhaarNumber == null) {
			aadhaarVerificationImpl.setAadhaarNumber("");
		}
		else {
			aadhaarVerificationImpl.setAadhaarNumber(aadhaarNumber);
		}

		aadhaarVerificationImpl.resetOriginalValues();

		return aadhaarVerificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		aadhaarId = objectInput.readLong();
		aadhaarUserName = objectInput.readUTF();
		aadhaarNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(aadhaarId);

		if (aadhaarUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadhaarUserName);
		}

		if (aadhaarNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadhaarNumber);
		}
	}

	public long aadhaarId;
	public String aadhaarUserName;
	public String aadhaarNumber;

}