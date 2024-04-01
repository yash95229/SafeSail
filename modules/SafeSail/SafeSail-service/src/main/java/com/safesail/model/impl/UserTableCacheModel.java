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

import com.safesail.model.UserTable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserTableCacheModel
	implements CacheModel<UserTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserTableCacheModel)) {
			return false;
		}

		UserTableCacheModel userTableCacheModel = (UserTableCacheModel)object;

		if (quoteId.equals(userTableCacheModel.quoteId)) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", quoteId=");
		sb.append(quoteId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userType=");
		sb.append(userType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserTable toEntityModel() {
		UserTableImpl userTableImpl = new UserTableImpl();

		if (uuid == null) {
			userTableImpl.setUuid("");
		}
		else {
			userTableImpl.setUuid(uuid);
		}

		if (quoteId == null) {
			userTableImpl.setQuoteId("");
		}
		else {
			userTableImpl.setQuoteId(quoteId);
		}

		userTableImpl.setUserId(userId);

		if (userType == null) {
			userTableImpl.setUserType("");
		}
		else {
			userTableImpl.setUserType(userType);
		}

		userTableImpl.resetOriginalValues();

		return userTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		quoteId = objectInput.readUTF();

		userId = objectInput.readLong();
		userType = objectInput.readUTF();
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

		objectOutput.writeLong(userId);

		if (userType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userType);
		}
	}

	public String uuid;
	public String quoteId;
	public long userId;
	public String userType;

}