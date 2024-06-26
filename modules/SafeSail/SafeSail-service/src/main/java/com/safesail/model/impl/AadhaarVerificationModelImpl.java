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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.safesail.model.AadhaarVerification;
import com.safesail.model.AadhaarVerificationModel;

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
 * The base model implementation for the AadhaarVerification service. Represents a row in the &quot;Safe_Sail_AadhaarVerification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AadhaarVerificationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AadhaarVerificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AadhaarVerificationImpl
 * @generated
 */
@JSON(strict = true)
public class AadhaarVerificationModelImpl
	extends BaseModelImpl<AadhaarVerification>
	implements AadhaarVerificationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a aadhaar verification model instance should use the <code>AadhaarVerification</code> interface instead.
	 */
	public static final String TABLE_NAME = "Safe_Sail_AadhaarVerification";

	public static final Object[][] TABLE_COLUMNS = {
		{"aadhaarId", Types.BIGINT}, {"aadhaarUserName", Types.VARCHAR},
		{"aadhaarNumber", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("aadhaarId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("aadhaarUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("aadhaarNumber", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Safe_Sail_AadhaarVerification (aadhaarId LONG not null primary key,aadhaarUserName VARCHAR(75) null,aadhaarNumber VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Safe_Sail_AadhaarVerification";

	public static final String ORDER_BY_JPQL =
		" ORDER BY aadhaarVerification.aadhaarId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Safe_Sail_AadhaarVerification.aadhaarId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AADHAARNUMBER_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AADHAARID_COLUMN_BITMASK = 2L;

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

	public AadhaarVerificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _aadhaarId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAadhaarId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _aadhaarId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AadhaarVerification.class;
	}

	@Override
	public String getModelClassName() {
		return AadhaarVerification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AadhaarVerification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AadhaarVerification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AadhaarVerification, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AadhaarVerification)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AadhaarVerification, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AadhaarVerification, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AadhaarVerification)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AadhaarVerification, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AadhaarVerification, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<AadhaarVerification, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AadhaarVerification, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AadhaarVerification, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<AadhaarVerification, Object>>();
		Map<String, BiConsumer<AadhaarVerification, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<AadhaarVerification, ?>>();

		attributeGetterFunctions.put(
			"aadhaarId", AadhaarVerification::getAadhaarId);
		attributeSetterBiConsumers.put(
			"aadhaarId",
			(BiConsumer<AadhaarVerification, Long>)
				AadhaarVerification::setAadhaarId);
		attributeGetterFunctions.put(
			"aadhaarUserName", AadhaarVerification::getAadhaarUserName);
		attributeSetterBiConsumers.put(
			"aadhaarUserName",
			(BiConsumer<AadhaarVerification, String>)
				AadhaarVerification::setAadhaarUserName);
		attributeGetterFunctions.put(
			"aadhaarNumber", AadhaarVerification::getAadhaarNumber);
		attributeSetterBiConsumers.put(
			"aadhaarNumber",
			(BiConsumer<AadhaarVerification, String>)
				AadhaarVerification::setAadhaarNumber);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getAadhaarId() {
		return _aadhaarId;
	}

	@Override
	public void setAadhaarId(long aadhaarId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_aadhaarId = aadhaarId;
	}

	@JSON
	@Override
	public String getAadhaarUserName() {
		if (_aadhaarUserName == null) {
			return "";
		}
		else {
			return _aadhaarUserName;
		}
	}

	@Override
	public void setAadhaarUserName(String aadhaarUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_aadhaarUserName = aadhaarUserName;
	}

	@JSON
	@Override
	public String getAadhaarNumber() {
		if (_aadhaarNumber == null) {
			return "";
		}
		else {
			return _aadhaarNumber;
		}
	}

	@Override
	public void setAadhaarNumber(String aadhaarNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_aadhaarNumber = aadhaarNumber;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalAadhaarNumber() {
		return getColumnOriginalValue("aadhaarNumber");
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
			0, AadhaarVerification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AadhaarVerification toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AadhaarVerification>
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
		AadhaarVerificationImpl aadhaarVerificationImpl =
			new AadhaarVerificationImpl();

		aadhaarVerificationImpl.setAadhaarId(getAadhaarId());
		aadhaarVerificationImpl.setAadhaarUserName(getAadhaarUserName());
		aadhaarVerificationImpl.setAadhaarNumber(getAadhaarNumber());

		aadhaarVerificationImpl.resetOriginalValues();

		return aadhaarVerificationImpl;
	}

	@Override
	public AadhaarVerification cloneWithOriginalValues() {
		AadhaarVerificationImpl aadhaarVerificationImpl =
			new AadhaarVerificationImpl();

		aadhaarVerificationImpl.setAadhaarId(
			this.<Long>getColumnOriginalValue("aadhaarId"));
		aadhaarVerificationImpl.setAadhaarUserName(
			this.<String>getColumnOriginalValue("aadhaarUserName"));
		aadhaarVerificationImpl.setAadhaarNumber(
			this.<String>getColumnOriginalValue("aadhaarNumber"));

		return aadhaarVerificationImpl;
	}

	@Override
	public int compareTo(AadhaarVerification aadhaarVerification) {
		long primaryKey = aadhaarVerification.getPrimaryKey();

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

		if (!(object instanceof AadhaarVerification)) {
			return false;
		}

		AadhaarVerification aadhaarVerification = (AadhaarVerification)object;

		long primaryKey = aadhaarVerification.getPrimaryKey();

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
	public CacheModel<AadhaarVerification> toCacheModel() {
		AadhaarVerificationCacheModel aadhaarVerificationCacheModel =
			new AadhaarVerificationCacheModel();

		aadhaarVerificationCacheModel.aadhaarId = getAadhaarId();

		aadhaarVerificationCacheModel.aadhaarUserName = getAadhaarUserName();

		String aadhaarUserName = aadhaarVerificationCacheModel.aadhaarUserName;

		if ((aadhaarUserName != null) && (aadhaarUserName.length() == 0)) {
			aadhaarVerificationCacheModel.aadhaarUserName = null;
		}

		aadhaarVerificationCacheModel.aadhaarNumber = getAadhaarNumber();

		String aadhaarNumber = aadhaarVerificationCacheModel.aadhaarNumber;

		if ((aadhaarNumber != null) && (aadhaarNumber.length() == 0)) {
			aadhaarVerificationCacheModel.aadhaarNumber = null;
		}

		return aadhaarVerificationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AadhaarVerification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AadhaarVerification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AadhaarVerification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(AadhaarVerification)this);

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

		private static final Function<InvocationHandler, AadhaarVerification>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					AadhaarVerification.class, ModelWrapper.class);

	}

	private long _aadhaarId;
	private String _aadhaarUserName;
	private String _aadhaarNumber;

	public <T> T getColumnValue(String columnName) {
		Function<AadhaarVerification, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((AadhaarVerification)this);
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

		_columnOriginalValues.put("aadhaarId", _aadhaarId);
		_columnOriginalValues.put("aadhaarUserName", _aadhaarUserName);
		_columnOriginalValues.put("aadhaarNumber", _aadhaarNumber);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("aadhaarId", 1L);

		columnBitmasks.put("aadhaarUserName", 2L);

		columnBitmasks.put("aadhaarNumber", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private AadhaarVerification _escapedModel;

}