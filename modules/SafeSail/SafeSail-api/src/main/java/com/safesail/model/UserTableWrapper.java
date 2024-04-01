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
 * This class is a wrapper for {@link UserTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTable
 * @generated
 */
public class UserTableWrapper
	extends BaseModelWrapper<UserTable>
	implements ModelWrapper<UserTable>, UserTable {

	public UserTableWrapper(UserTable userTable) {
		super(userTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("quoteId", getQuoteId());
		attributes.put("userId", getUserId());
		attributes.put("userType", getUserType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String quoteId = (String)attributes.get("quoteId");

		if (quoteId != null) {
			setQuoteId(quoteId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userType = (String)attributes.get("userType");

		if (userType != null) {
			setUserType(userType);
		}
	}

	@Override
	public UserTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this user table.
	 *
	 * @return the primary key of this user table
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quote ID of this user table.
	 *
	 * @return the quote ID of this user table
	 */
	@Override
	public String getQuoteId() {
		return model.getQuoteId();
	}

	/**
	 * Returns the user ID of this user table.
	 *
	 * @return the user ID of this user table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user type of this user table.
	 *
	 * @return the user type of this user table
	 */
	@Override
	public String getUserType() {
		return model.getUserType();
	}

	/**
	 * Returns the user uuid of this user table.
	 *
	 * @return the user uuid of this user table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this user table.
	 *
	 * @return the uuid of this user table
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this user table.
	 *
	 * @param primaryKey the primary key of this user table
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quote ID of this user table.
	 *
	 * @param quoteId the quote ID of this user table
	 */
	@Override
	public void setQuoteId(String quoteId) {
		model.setQuoteId(quoteId);
	}

	/**
	 * Sets the user ID of this user table.
	 *
	 * @param userId the user ID of this user table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user type of this user table.
	 *
	 * @param userType the user type of this user table
	 */
	@Override
	public void setUserType(String userType) {
		model.setUserType(userType);
	}

	/**
	 * Sets the user uuid of this user table.
	 *
	 * @param userUuid the user uuid of this user table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this user table.
	 *
	 * @param uuid the uuid of this user table
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UserTableWrapper wrap(UserTable userTable) {
		return new UserTableWrapper(userTable);
	}

}