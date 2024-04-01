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

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.safesail.model.UserTable;
import com.safesail.model.UserTableModel;

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
 * The base model implementation for the UserTable service. Represents a row in the &quot;Safe_Sail_UserTable&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>UserTableModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserTableImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTableImpl
 * @generated
 */
@JSON(strict = true)
public class UserTableModelImpl
	extends BaseModelImpl<UserTable> implements UserTableModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user table model instance should use the <code>UserTable</code> interface instead.
	 */
	public static final String TABLE_NAME = "Safe_Sail_UserTable";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"quoteId", Types.VARCHAR},
		{"userId", Types.BIGINT}, {"userType", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("quoteId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userType", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Safe_Sail_UserTable (uuid_ VARCHAR(75) null,quoteId VARCHAR(75) not null primary key,userId LONG,userType VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Safe_Sail_UserTable";

	public static final String ORDER_BY_JPQL =
		" ORDER BY userTable.quoteId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Safe_Sail_UserTable.quoteId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long QUOTEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

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

	public UserTableModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _quoteId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setQuoteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _quoteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UserTable.class;
	}

	@Override
	public String getModelClassName() {
		return UserTable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UserTable, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UserTable, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserTable, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((UserTable)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UserTable, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UserTable, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UserTable)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UserTable, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UserTable, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<UserTable, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UserTable, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UserTable, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<UserTable, Object>>();
		Map<String, BiConsumer<UserTable, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<UserTable, ?>>();

		attributeGetterFunctions.put("uuid", UserTable::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<UserTable, String>)UserTable::setUuid);
		attributeGetterFunctions.put("quoteId", UserTable::getQuoteId);
		attributeSetterBiConsumers.put(
			"quoteId", (BiConsumer<UserTable, String>)UserTable::setQuoteId);
		attributeGetterFunctions.put("userId", UserTable::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<UserTable, Long>)UserTable::setUserId);
		attributeGetterFunctions.put("userType", UserTable::getUserType);
		attributeSetterBiConsumers.put(
			"userType", (BiConsumer<UserTable, String>)UserTable::setUserType);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public String getQuoteId() {
		if (_quoteId == null) {
			return "";
		}
		else {
			return _quoteId;
		}
	}

	@Override
	public void setQuoteId(String quoteId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_quoteId = quoteId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalQuoteId() {
		return getColumnOriginalValue("quoteId");
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getUserType() {
		if (_userType == null) {
			return "";
		}
		else {
			return _userType;
		}
	}

	@Override
	public void setUserType(String userType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userType = userType;
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
	public UserTable toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UserTable>
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
		UserTableImpl userTableImpl = new UserTableImpl();

		userTableImpl.setUuid(getUuid());
		userTableImpl.setQuoteId(getQuoteId());
		userTableImpl.setUserId(getUserId());
		userTableImpl.setUserType(getUserType());

		userTableImpl.resetOriginalValues();

		return userTableImpl;
	}

	@Override
	public UserTable cloneWithOriginalValues() {
		UserTableImpl userTableImpl = new UserTableImpl();

		userTableImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		userTableImpl.setQuoteId(
			this.<String>getColumnOriginalValue("quoteId"));
		userTableImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		userTableImpl.setUserType(
			this.<String>getColumnOriginalValue("userType"));

		return userTableImpl;
	}

	@Override
	public int compareTo(UserTable userTable) {
		String primaryKey = userTable.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserTable)) {
			return false;
		}

		UserTable userTable = (UserTable)object;

		String primaryKey = userTable.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
	public CacheModel<UserTable> toCacheModel() {
		UserTableCacheModel userTableCacheModel = new UserTableCacheModel();

		userTableCacheModel.uuid = getUuid();

		String uuid = userTableCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			userTableCacheModel.uuid = null;
		}

		userTableCacheModel.quoteId = getQuoteId();

		String quoteId = userTableCacheModel.quoteId;

		if ((quoteId != null) && (quoteId.length() == 0)) {
			userTableCacheModel.quoteId = null;
		}

		userTableCacheModel.userId = getUserId();

		userTableCacheModel.userType = getUserType();

		String userType = userTableCacheModel.userType;

		if ((userType != null) && (userType.length() == 0)) {
			userTableCacheModel.userType = null;
		}

		return userTableCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UserTable, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UserTable, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserTable, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((UserTable)this);

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

		private static final Function<InvocationHandler, UserTable>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					UserTable.class, ModelWrapper.class);

	}

	private String _uuid;
	private String _quoteId;
	private long _userId;
	private String _userType;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<UserTable, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((UserTable)this);
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

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("quoteId", _quoteId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userType", _userType);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("quoteId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("userType", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private UserTable _escapedModel;

}