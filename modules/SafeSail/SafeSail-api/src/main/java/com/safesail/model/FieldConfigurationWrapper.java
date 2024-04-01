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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FieldConfiguration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldConfiguration
 * @generated
 */
public class FieldConfigurationWrapper
	extends BaseModelWrapper<FieldConfiguration>
	implements FieldConfiguration, ModelWrapper<FieldConfiguration> {

	public FieldConfigurationWrapper(FieldConfiguration fieldConfiguration) {
		super(fieldConfiguration);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("configId", getConfigId());
		attributes.put("fieldName", getFieldName());
		attributes.put("fieldData", getFieldData());
		attributes.put("fieldValue", getFieldValue());
		attributes.put("fieldSumAssured", getFieldSumAssured());
		attributes.put("selectImage", getSelectImage());
		attributes.put("fieldShow", getFieldShow());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long configId = (Long)attributes.get("configId");

		if (configId != null) {
			setConfigId(configId);
		}

		String fieldName = (String)attributes.get("fieldName");

		if (fieldName != null) {
			setFieldName(fieldName);
		}

		String fieldData = (String)attributes.get("fieldData");

		if (fieldData != null) {
			setFieldData(fieldData);
		}

		String fieldValue = (String)attributes.get("fieldValue");

		if (fieldValue != null) {
			setFieldValue(fieldValue);
		}

		String fieldSumAssured = (String)attributes.get("fieldSumAssured");

		if (fieldSumAssured != null) {
			setFieldSumAssured(fieldSumAssured);
		}

		String selectImage = (String)attributes.get("selectImage");

		if (selectImage != null) {
			setSelectImage(selectImage);
		}

		Boolean fieldShow = (Boolean)attributes.get("fieldShow");

		if (fieldShow != null) {
			setFieldShow(fieldShow);
		}
	}

	@Override
	public FieldConfiguration cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the config ID of this field configuration.
	 *
	 * @return the config ID of this field configuration
	 */
	@Override
	public long getConfigId() {
		return model.getConfigId();
	}

	/**
	 * Returns the field data of this field configuration.
	 *
	 * @return the field data of this field configuration
	 */
	@Override
	public String getFieldData() {
		return model.getFieldData();
	}

	/**
	 * Returns the field name of this field configuration.
	 *
	 * @return the field name of this field configuration
	 */
	@Override
	public String getFieldName() {
		return model.getFieldName();
	}

	/**
	 * Returns the field show of this field configuration.
	 *
	 * @return the field show of this field configuration
	 */
	@Override
	public Boolean getFieldShow() {
		return model.getFieldShow();
	}

	/**
	 * Returns the field sum assured of this field configuration.
	 *
	 * @return the field sum assured of this field configuration
	 */
	@Override
	public String getFieldSumAssured() {
		return model.getFieldSumAssured();
	}

	/**
	 * Returns the field value of this field configuration.
	 *
	 * @return the field value of this field configuration
	 */
	@Override
	public String getFieldValue() {
		return model.getFieldValue();
	}

	/**
	 * Returns the primary key of this field configuration.
	 *
	 * @return the primary key of this field configuration
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the select image of this field configuration.
	 *
	 * @return the select image of this field configuration
	 */
	@Override
	public String getSelectImage() {
		return model.getSelectImage();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the config ID of this field configuration.
	 *
	 * @param configId the config ID of this field configuration
	 */
	@Override
	public void setConfigId(long configId) {
		model.setConfigId(configId);
	}

	/**
	 * Sets the field data of this field configuration.
	 *
	 * @param fieldData the field data of this field configuration
	 */
	@Override
	public void setFieldData(String fieldData) {
		model.setFieldData(fieldData);
	}

	/**
	 * Sets the field name of this field configuration.
	 *
	 * @param fieldName the field name of this field configuration
	 */
	@Override
	public void setFieldName(String fieldName) {
		model.setFieldName(fieldName);
	}

	/**
	 * Sets the field show of this field configuration.
	 *
	 * @param fieldShow the field show of this field configuration
	 */
	@Override
	public void setFieldShow(Boolean fieldShow) {
		model.setFieldShow(fieldShow);
	}

	/**
	 * Sets the field sum assured of this field configuration.
	 *
	 * @param fieldSumAssured the field sum assured of this field configuration
	 */
	@Override
	public void setFieldSumAssured(String fieldSumAssured) {
		model.setFieldSumAssured(fieldSumAssured);
	}

	/**
	 * Sets the field value of this field configuration.
	 *
	 * @param fieldValue the field value of this field configuration
	 */
	@Override
	public void setFieldValue(String fieldValue) {
		model.setFieldValue(fieldValue);
	}

	/**
	 * Sets the primary key of this field configuration.
	 *
	 * @param primaryKey the primary key of this field configuration
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the select image of this field configuration.
	 *
	 * @param selectImage the select image of this field configuration
	 */
	@Override
	public void setSelectImage(String selectImage) {
		model.setSelectImage(selectImage);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FieldConfigurationWrapper wrap(
		FieldConfiguration fieldConfiguration) {

		return new FieldConfigurationWrapper(fieldConfiguration);
	}

}