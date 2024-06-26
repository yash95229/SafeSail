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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.safesail.model.FieldConfiguration;
import com.safesail.model.FieldConfigurationModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the FieldConfiguration service. Represents a row in the &quot;Safe_Sail_FieldConfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FieldConfigurationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FieldConfigurationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldConfigurationImpl
 * @generated
 */
@JSON(strict = true)
public class FieldConfigurationModelImpl
	extends BaseModelImpl<FieldConfiguration>
	implements FieldConfigurationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a field configuration model instance should use the <code>FieldConfiguration</code> interface instead.
	 */
	public static final String TABLE_NAME = "Safe_Sail_FieldConfiguration";

	public static final Object[][] TABLE_COLUMNS = {
		{"configId", Types.BIGINT}, {"fieldName", Types.VARCHAR},
		{"fieldData", Types.VARCHAR}, {"fieldValue", Types.VARCHAR},
		{"fieldSumAssured", Types.VARCHAR}, {"selectImage", Types.VARCHAR},
		{"fieldShow", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("configId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fieldName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fieldData", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fieldValue", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fieldSumAssured", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("selectImage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fieldShow", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Safe_Sail_FieldConfiguration (configId LONG not null primary key,fieldName VARCHAR(75) null,fieldData VARCHAR(75) null,fieldValue VARCHAR(75) null,fieldSumAssured VARCHAR(75) null,selectImage VARCHAR(75) null,fieldShow BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table Safe_Sail_FieldConfiguration";

	public static final String ORDER_BY_JPQL =
		" ORDER BY fieldConfiguration.configId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Safe_Sail_FieldConfiguration.configId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CONFIGID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIELDDATA_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIELDNAME_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIELDSHOW_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIELDSUMASSURED_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FIELDVALUE_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public FieldConfigurationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _configId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _configId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FieldConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return FieldConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FieldConfiguration, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FieldConfiguration, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FieldConfiguration, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FieldConfiguration)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FieldConfiguration, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FieldConfiguration, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FieldConfiguration)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FieldConfiguration, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FieldConfiguration, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<FieldConfiguration, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FieldConfiguration, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FieldConfiguration, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<FieldConfiguration, Object>>();
		Map<String, BiConsumer<FieldConfiguration, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<FieldConfiguration, ?>>();

		attributeGetterFunctions.put(
			"configId", FieldConfiguration::getConfigId);
		attributeSetterBiConsumers.put(
			"configId",
			(BiConsumer<FieldConfiguration, Long>)
				FieldConfiguration::setConfigId);
		attributeGetterFunctions.put(
			"fieldName", FieldConfiguration::getFieldName);
		attributeSetterBiConsumers.put(
			"fieldName",
			(BiConsumer<FieldConfiguration, String>)
				FieldConfiguration::setFieldName);
		attributeGetterFunctions.put(
			"fieldData", FieldConfiguration::getFieldData);
		attributeSetterBiConsumers.put(
			"fieldData",
			(BiConsumer<FieldConfiguration, String>)
				FieldConfiguration::setFieldData);
		attributeGetterFunctions.put(
			"fieldValue", FieldConfiguration::getFieldValue);
		attributeSetterBiConsumers.put(
			"fieldValue",
			(BiConsumer<FieldConfiguration, String>)
				FieldConfiguration::setFieldValue);
		attributeGetterFunctions.put(
			"fieldSumAssured", FieldConfiguration::getFieldSumAssured);
		attributeSetterBiConsumers.put(
			"fieldSumAssured",
			(BiConsumer<FieldConfiguration, String>)
				FieldConfiguration::setFieldSumAssured);
		attributeGetterFunctions.put(
			"selectImage", FieldConfiguration::getSelectImage);
		attributeSetterBiConsumers.put(
			"selectImage",
			(BiConsumer<FieldConfiguration, String>)
				FieldConfiguration::setSelectImage);
		attributeGetterFunctions.put(
			"fieldShow", FieldConfiguration::getFieldShow);
		attributeSetterBiConsumers.put(
			"fieldShow",
			(BiConsumer<FieldConfiguration, Boolean>)
				FieldConfiguration::setFieldShow);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getConfigId() {
		return _configId;
	}

	@Override
	public void setConfigId(long configId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_configId = configId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalConfigId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("configId"));
	}

	@JSON
	@Override
	public String getFieldName() {
		if (_fieldName == null) {
			return "";
		}
		else {
			return _fieldName;
		}
	}

	@Override
	public void setFieldName(String fieldName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fieldName = fieldName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFieldName() {
		return getColumnOriginalValue("fieldName");
	}

	@JSON
	@Override
	public String getFieldData() {
		if (_fieldData == null) {
			return "";
		}
		else {
			return _fieldData;
		}
	}

	@Override
	public void setFieldData(String fieldData) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fieldData = fieldData;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFieldData() {
		return getColumnOriginalValue("fieldData");
	}

	@JSON
	@Override
	public String getFieldValue() {
		if (_fieldValue == null) {
			return "";
		}
		else {
			return _fieldValue;
		}
	}

	@Override
	public void setFieldValue(String fieldValue) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fieldValue = fieldValue;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFieldValue() {
		return getColumnOriginalValue("fieldValue");
	}

	@JSON
	@Override
	public String getFieldSumAssured() {
		if (_fieldSumAssured == null) {
			return "";
		}
		else {
			return _fieldSumAssured;
		}
	}

	@Override
	public void setFieldSumAssured(String fieldSumAssured) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fieldSumAssured = fieldSumAssured;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalFieldSumAssured() {
		return getColumnOriginalValue("fieldSumAssured");
	}

	@JSON
	@Override
	public String getSelectImage() {
		if (_selectImage == null) {
			return "";
		}
		else {
			return _selectImage;
		}
	}

	@Override
	public void setSelectImage(String selectImage) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_selectImage = selectImage;
	}

	@JSON
	@Override
	public Boolean getFieldShow() {
		return _fieldShow;
	}

	@Override
	public void setFieldShow(Boolean fieldShow) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fieldShow = fieldShow;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Boolean getOriginalFieldShow() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("fieldShow"));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, FieldConfiguration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FieldConfiguration toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FieldConfiguration>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FieldConfigurationImpl fieldConfigurationImpl =
			new FieldConfigurationImpl();

		fieldConfigurationImpl.setConfigId(getConfigId());
		fieldConfigurationImpl.setFieldName(getFieldName());
		fieldConfigurationImpl.setFieldData(getFieldData());
		fieldConfigurationImpl.setFieldValue(getFieldValue());
		fieldConfigurationImpl.setFieldSumAssured(getFieldSumAssured());
		fieldConfigurationImpl.setSelectImage(getSelectImage());
		fieldConfigurationImpl.setFieldShow(getFieldShow());

		fieldConfigurationImpl.resetOriginalValues();

		return fieldConfigurationImpl;
	}

	@Override
	public FieldConfiguration cloneWithOriginalValues() {
		FieldConfigurationImpl fieldConfigurationImpl =
			new FieldConfigurationImpl();

		fieldConfigurationImpl.setConfigId(
			this.<Long>getColumnOriginalValue("configId"));
		fieldConfigurationImpl.setFieldName(
			this.<String>getColumnOriginalValue("fieldName"));
		fieldConfigurationImpl.setFieldData(
			this.<String>getColumnOriginalValue("fieldData"));
		fieldConfigurationImpl.setFieldValue(
			this.<String>getColumnOriginalValue("fieldValue"));
		fieldConfigurationImpl.setFieldSumAssured(
			this.<String>getColumnOriginalValue("fieldSumAssured"));
		fieldConfigurationImpl.setSelectImage(
			this.<String>getColumnOriginalValue("selectImage"));
		fieldConfigurationImpl.setFieldShow(
			this.<Boolean>getColumnOriginalValue("fieldShow"));

		return fieldConfigurationImpl;
	}

	@Override
	public int compareTo(FieldConfiguration fieldConfiguration) {
		long primaryKey = fieldConfiguration.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FieldConfiguration)) {
			return false;
		}

		FieldConfiguration fieldConfiguration = (FieldConfiguration)object;

		long primaryKey = fieldConfiguration.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<FieldConfiguration> toCacheModel() {
		FieldConfigurationCacheModel fieldConfigurationCacheModel =
			new FieldConfigurationCacheModel();

		fieldConfigurationCacheModel.configId = getConfigId();

		fieldConfigurationCacheModel.fieldName = getFieldName();

		String fieldName = fieldConfigurationCacheModel.fieldName;

		if ((fieldName != null) && (fieldName.length() == 0)) {
			fieldConfigurationCacheModel.fieldName = null;
		}

		fieldConfigurationCacheModel.fieldData = getFieldData();

		String fieldData = fieldConfigurationCacheModel.fieldData;

		if ((fieldData != null) && (fieldData.length() == 0)) {
			fieldConfigurationCacheModel.fieldData = null;
		}

		fieldConfigurationCacheModel.fieldValue = getFieldValue();

		String fieldValue = fieldConfigurationCacheModel.fieldValue;

		if ((fieldValue != null) && (fieldValue.length() == 0)) {
			fieldConfigurationCacheModel.fieldValue = null;
		}

		fieldConfigurationCacheModel.fieldSumAssured = getFieldSumAssured();

		String fieldSumAssured = fieldConfigurationCacheModel.fieldSumAssured;

		if ((fieldSumAssured != null) && (fieldSumAssured.length() == 0)) {
			fieldConfigurationCacheModel.fieldSumAssured = null;
		}

		fieldConfigurationCacheModel.selectImage = getSelectImage();

		String selectImage = fieldConfigurationCacheModel.selectImage;

		if ((selectImage != null) && (selectImage.length() == 0)) {
			fieldConfigurationCacheModel.selectImage = null;
		}

		Boolean fieldShow = getFieldShow();

		if (fieldShow != null) {
			fieldConfigurationCacheModel.fieldShow = fieldShow;
		}

		return fieldConfigurationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FieldConfiguration, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FieldConfiguration, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FieldConfiguration, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(FieldConfiguration)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, FieldConfiguration>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					FieldConfiguration.class, ModelWrapper.class);

	}

	private long _configId;
	private String _fieldName;
	private String _fieldData;
	private String _fieldValue;
	private String _fieldSumAssured;
	private String _selectImage;
	private Boolean _fieldShow;

	public <T> T getColumnValue(String columnName) {
		Function<FieldConfiguration, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FieldConfiguration)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("configId", _configId);
		_columnOriginalValues.put("fieldName", _fieldName);
		_columnOriginalValues.put("fieldData", _fieldData);
		_columnOriginalValues.put("fieldValue", _fieldValue);
		_columnOriginalValues.put("fieldSumAssured", _fieldSumAssured);
		_columnOriginalValues.put("selectImage", _selectImage);
		_columnOriginalValues.put("fieldShow", _fieldShow);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("configId", 1L);

		columnBitmasks.put("fieldName", 2L);

		columnBitmasks.put("fieldData", 4L);

		columnBitmasks.put("fieldValue", 8L);

		columnBitmasks.put("fieldSumAssured", 16L);

		columnBitmasks.put("selectImage", 32L);

		columnBitmasks.put("fieldShow", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FieldConfiguration _escapedModel;

}