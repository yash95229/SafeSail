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

import com.safesail.model.addOnFieldData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing addOnFieldData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class addOnFieldDataCacheModel
	implements CacheModel<addOnFieldData>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof addOnFieldDataCacheModel)) {
			return false;
		}

		addOnFieldDataCacheModel addOnFieldDataCacheModel =
			(addOnFieldDataCacheModel)object;

		if (addonId == addOnFieldDataCacheModel.addonId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addonId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{addonId=");
		sb.append(addonId);
		sb.append(", addonName=");
		sb.append(addonName);
		sb.append(", addonValue=");
		sb.append(addonValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public addOnFieldData toEntityModel() {
		addOnFieldDataImpl addOnFieldDataImpl = new addOnFieldDataImpl();

		addOnFieldDataImpl.setAddonId(addonId);

		if (addonName == null) {
			addOnFieldDataImpl.setAddonName("");
		}
		else {
			addOnFieldDataImpl.setAddonName(addonName);
		}

		if (addonValue == null) {
			addOnFieldDataImpl.setAddonValue("");
		}
		else {
			addOnFieldDataImpl.setAddonValue(addonValue);
		}

		addOnFieldDataImpl.resetOriginalValues();

		return addOnFieldDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addonId = objectInput.readLong();
		addonName = objectInput.readUTF();
		addonValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(addonId);

		if (addonName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addonName);
		}

		if (addonValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addonValue);
		}
	}

	public long addonId;
	public String addonName;
	public String addonValue;

}