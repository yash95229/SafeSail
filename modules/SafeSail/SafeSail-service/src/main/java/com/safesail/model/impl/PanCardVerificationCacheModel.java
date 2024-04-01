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

import com.safesail.model.PanCardVerification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PanCardVerification in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PanCardVerificationCacheModel
	implements CacheModel<PanCardVerification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PanCardVerificationCacheModel)) {
			return false;
		}

		PanCardVerificationCacheModel panCardVerificationCacheModel =
			(PanCardVerificationCacheModel)object;

		if (panId == panCardVerificationCacheModel.panId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, panId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{panId=");
		sb.append(panId);
		sb.append(", panUserName=");
		sb.append(panUserName);
		sb.append(", panNumber=");
		sb.append(panNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PanCardVerification toEntityModel() {
		PanCardVerificationImpl panCardVerificationImpl =
			new PanCardVerificationImpl();

		panCardVerificationImpl.setPanId(panId);

		if (panUserName == null) {
			panCardVerificationImpl.setPanUserName("");
		}
		else {
			panCardVerificationImpl.setPanUserName(panUserName);
		}

		if (panNumber == null) {
			panCardVerificationImpl.setPanNumber("");
		}
		else {
			panCardVerificationImpl.setPanNumber(panNumber);
		}

		panCardVerificationImpl.resetOriginalValues();

		return panCardVerificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		panId = objectInput.readLong();
		panUserName = objectInput.readUTF();
		panNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(panId);

		if (panUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panUserName);
		}

		if (panNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(panNumber);
		}
	}

	public long panId;
	public String panUserName;
	public String panNumber;

}