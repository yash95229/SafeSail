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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the addOnFieldData service. Represents a row in the &quot;Safe_Sail_addOnFieldData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.safesail.model.impl.addOnFieldDataModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.safesail.model.impl.addOnFieldDataImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see addOnFieldData
 * @generated
 */
@ProviderType
public interface addOnFieldDataModel extends BaseModel<addOnFieldData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a add on field data model instance should use the {@link addOnFieldData} interface instead.
	 */

	/**
	 * Returns the primary key of this add on field data.
	 *
	 * @return the primary key of this add on field data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this add on field data.
	 *
	 * @param primaryKey the primary key of this add on field data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the addon ID of this add on field data.
	 *
	 * @return the addon ID of this add on field data
	 */
	public long getAddonId();

	/**
	 * Sets the addon ID of this add on field data.
	 *
	 * @param addonId the addon ID of this add on field data
	 */
	public void setAddonId(long addonId);

	/**
	 * Returns the addon name of this add on field data.
	 *
	 * @return the addon name of this add on field data
	 */
	@AutoEscape
	public String getAddonName();

	/**
	 * Sets the addon name of this add on field data.
	 *
	 * @param addonName the addon name of this add on field data
	 */
	public void setAddonName(String addonName);

	/**
	 * Returns the addon value of this add on field data.
	 *
	 * @return the addon value of this add on field data
	 */
	@AutoEscape
	public String getAddonValue();

	/**
	 * Sets the addon value of this add on field data.
	 *
	 * @param addonValue the addon value of this add on field data
	 */
	public void setAddonValue(String addonValue);

	@Override
	public addOnFieldData cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}