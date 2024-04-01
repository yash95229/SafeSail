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
 * The base model interface for the FieldConfiguration service. Represents a row in the &quot;Safe_Sail_FieldConfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.safesail.model.impl.FieldConfigurationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.safesail.model.impl.FieldConfigurationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldConfiguration
 * @generated
 */
@ProviderType
public interface FieldConfigurationModel extends BaseModel<FieldConfiguration> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a field configuration model instance should use the {@link FieldConfiguration} interface instead.
	 */

	/**
	 * Returns the primary key of this field configuration.
	 *
	 * @return the primary key of this field configuration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this field configuration.
	 *
	 * @param primaryKey the primary key of this field configuration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the config ID of this field configuration.
	 *
	 * @return the config ID of this field configuration
	 */
	public long getConfigId();

	/**
	 * Sets the config ID of this field configuration.
	 *
	 * @param configId the config ID of this field configuration
	 */
	public void setConfigId(long configId);

	/**
	 * Returns the field name of this field configuration.
	 *
	 * @return the field name of this field configuration
	 */
	@AutoEscape
	public String getFieldName();

	/**
	 * Sets the field name of this field configuration.
	 *
	 * @param fieldName the field name of this field configuration
	 */
	public void setFieldName(String fieldName);

	/**
	 * Returns the field data of this field configuration.
	 *
	 * @return the field data of this field configuration
	 */
	@AutoEscape
	public String getFieldData();

	/**
	 * Sets the field data of this field configuration.
	 *
	 * @param fieldData the field data of this field configuration
	 */
	public void setFieldData(String fieldData);

	/**
	 * Returns the field value of this field configuration.
	 *
	 * @return the field value of this field configuration
	 */
	@AutoEscape
	public String getFieldValue();

	/**
	 * Sets the field value of this field configuration.
	 *
	 * @param fieldValue the field value of this field configuration
	 */
	public void setFieldValue(String fieldValue);

	/**
	 * Returns the field sum assured of this field configuration.
	 *
	 * @return the field sum assured of this field configuration
	 */
	@AutoEscape
	public String getFieldSumAssured();

	/**
	 * Sets the field sum assured of this field configuration.
	 *
	 * @param fieldSumAssured the field sum assured of this field configuration
	 */
	public void setFieldSumAssured(String fieldSumAssured);

	/**
	 * Returns the select image of this field configuration.
	 *
	 * @return the select image of this field configuration
	 */
	@AutoEscape
	public String getSelectImage();

	/**
	 * Sets the select image of this field configuration.
	 *
	 * @param selectImage the select image of this field configuration
	 */
	public void setSelectImage(String selectImage);

	/**
	 * Returns the field show of this field configuration.
	 *
	 * @return the field show of this field configuration
	 */
	public Boolean getFieldShow();

	/**
	 * Sets the field show of this field configuration.
	 *
	 * @param fieldShow the field show of this field configuration
	 */
	public void setFieldShow(Boolean fieldShow);

	@Override
	public FieldConfiguration cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}