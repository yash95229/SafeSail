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

import com.safesail.model.FieldConfiguration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FieldConfiguration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FieldConfigurationCacheModel
	implements CacheModel<FieldConfiguration>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FieldConfigurationCacheModel)) {
			return false;
		}

		FieldConfigurationCacheModel fieldConfigurationCacheModel =
			(FieldConfigurationCacheModel)object;

		if (configId == fieldConfigurationCacheModel.configId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, configId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{configId=");
		sb.append(configId);
		sb.append(", fieldName=");
		sb.append(fieldName);
		sb.append(", fieldData=");
		sb.append(fieldData);
		sb.append(", fieldValue=");
		sb.append(fieldValue);
		sb.append(", fieldSumAssured=");
		sb.append(fieldSumAssured);
		sb.append(", selectImage=");
		sb.append(selectImage);
		sb.append(", fieldShow=");
		sb.append(fieldShow);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FieldConfiguration toEntityModel() {
		FieldConfigurationImpl fieldConfigurationImpl =
			new FieldConfigurationImpl();

		fieldConfigurationImpl.setConfigId(configId);

		if (fieldName == null) {
			fieldConfigurationImpl.setFieldName("");
		}
		else {
			fieldConfigurationImpl.setFieldName(fieldName);
		}

		if (fieldData == null) {
			fieldConfigurationImpl.setFieldData("");
		}
		else {
			fieldConfigurationImpl.setFieldData(fieldData);
		}

		if (fieldValue == null) {
			fieldConfigurationImpl.setFieldValue("");
		}
		else {
			fieldConfigurationImpl.setFieldValue(fieldValue);
		}

		if (fieldSumAssured == null) {
			fieldConfigurationImpl.setFieldSumAssured("");
		}
		else {
			fieldConfigurationImpl.setFieldSumAssured(fieldSumAssured);
		}

		if (selectImage == null) {
			fieldConfigurationImpl.setSelectImage("");
		}
		else {
			fieldConfigurationImpl.setSelectImage(selectImage);
		}

		fieldConfigurationImpl.setFieldShow(fieldShow);

		fieldConfigurationImpl.resetOriginalValues();

		return fieldConfigurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		configId = objectInput.readLong();
		fieldName = objectInput.readUTF();
		fieldData = objectInput.readUTF();
		fieldValue = objectInput.readUTF();
		fieldSumAssured = objectInput.readUTF();
		selectImage = objectInput.readUTF();

		fieldShow = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(configId);

		if (fieldName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldName);
		}

		if (fieldData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldData);
		}

		if (fieldValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldValue);
		}

		if (fieldSumAssured == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldSumAssured);
		}

		if (selectImage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(selectImage);
		}

		objectOutput.writeBoolean(fieldShow);
	}

	public long configId;
	public String fieldName;
	public String fieldData;
	public String fieldValue;
	public String fieldSumAssured;
	public String selectImage;
	public boolean fieldShow;

}