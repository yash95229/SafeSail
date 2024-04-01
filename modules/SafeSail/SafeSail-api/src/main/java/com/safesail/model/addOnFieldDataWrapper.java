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
 * This class is a wrapper for {@link addOnFieldData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see addOnFieldData
 * @generated
 */
public class addOnFieldDataWrapper
	extends BaseModelWrapper<addOnFieldData>
	implements addOnFieldData, ModelWrapper<addOnFieldData> {

	public addOnFieldDataWrapper(addOnFieldData addOnFieldData) {
		super(addOnFieldData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addonId", getAddonId());
		attributes.put("addonName", getAddonName());
		attributes.put("addonValue", getAddonValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addonId = (Long)attributes.get("addonId");

		if (addonId != null) {
			setAddonId(addonId);
		}

		String addonName = (String)attributes.get("addonName");

		if (addonName != null) {
			setAddonName(addonName);
		}

		String addonValue = (String)attributes.get("addonValue");

		if (addonValue != null) {
			setAddonValue(addonValue);
		}
	}

	@Override
	public addOnFieldData cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the addon ID of this add on field data.
	 *
	 * @return the addon ID of this add on field data
	 */
	@Override
	public long getAddonId() {
		return model.getAddonId();
	}

	/**
	 * Returns the addon name of this add on field data.
	 *
	 * @return the addon name of this add on field data
	 */
	@Override
	public String getAddonName() {
		return model.getAddonName();
	}

	/**
	 * Returns the addon value of this add on field data.
	 *
	 * @return the addon value of this add on field data
	 */
	@Override
	public String getAddonValue() {
		return model.getAddonValue();
	}

	/**
	 * Returns the primary key of this add on field data.
	 *
	 * @return the primary key of this add on field data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the addon ID of this add on field data.
	 *
	 * @param addonId the addon ID of this add on field data
	 */
	@Override
	public void setAddonId(long addonId) {
		model.setAddonId(addonId);
	}

	/**
	 * Sets the addon name of this add on field data.
	 *
	 * @param addonName the addon name of this add on field data
	 */
	@Override
	public void setAddonName(String addonName) {
		model.setAddonName(addonName);
	}

	/**
	 * Sets the addon value of this add on field data.
	 *
	 * @param addonValue the addon value of this add on field data
	 */
	@Override
	public void setAddonValue(String addonValue) {
		model.setAddonValue(addonValue);
	}

	/**
	 * Sets the primary key of this add on field data.
	 *
	 * @param primaryKey the primary key of this add on field data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected addOnFieldDataWrapper wrap(addOnFieldData addOnFieldData) {
		return new addOnFieldDataWrapper(addOnFieldData);
	}

}