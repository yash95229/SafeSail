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
 * This class is a wrapper for {@link AadhaarVerification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AadhaarVerification
 * @generated
 */
public class AadhaarVerificationWrapper
	extends BaseModelWrapper<AadhaarVerification>
	implements AadhaarVerification, ModelWrapper<AadhaarVerification> {

	public AadhaarVerificationWrapper(AadhaarVerification aadhaarVerification) {
		super(aadhaarVerification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("aadhaarId", getAadhaarId());
		attributes.put("aadhaarUserName", getAadhaarUserName());
		attributes.put("aadhaarNumber", getAadhaarNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long aadhaarId = (Long)attributes.get("aadhaarId");

		if (aadhaarId != null) {
			setAadhaarId(aadhaarId);
		}

		String aadhaarUserName = (String)attributes.get("aadhaarUserName");

		if (aadhaarUserName != null) {
			setAadhaarUserName(aadhaarUserName);
		}

		String aadhaarNumber = (String)attributes.get("aadhaarNumber");

		if (aadhaarNumber != null) {
			setAadhaarNumber(aadhaarNumber);
		}
	}

	@Override
	public AadhaarVerification cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the aadhaar ID of this aadhaar verification.
	 *
	 * @return the aadhaar ID of this aadhaar verification
	 */
	@Override
	public long getAadhaarId() {
		return model.getAadhaarId();
	}

	/**
	 * Returns the aadhaar number of this aadhaar verification.
	 *
	 * @return the aadhaar number of this aadhaar verification
	 */
	@Override
	public String getAadhaarNumber() {
		return model.getAadhaarNumber();
	}

	/**
	 * Returns the aadhaar user name of this aadhaar verification.
	 *
	 * @return the aadhaar user name of this aadhaar verification
	 */
	@Override
	public String getAadhaarUserName() {
		return model.getAadhaarUserName();
	}

	/**
	 * Returns the primary key of this aadhaar verification.
	 *
	 * @return the primary key of this aadhaar verification
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
	 * Sets the aadhaar ID of this aadhaar verification.
	 *
	 * @param aadhaarId the aadhaar ID of this aadhaar verification
	 */
	@Override
	public void setAadhaarId(long aadhaarId) {
		model.setAadhaarId(aadhaarId);
	}

	/**
	 * Sets the aadhaar number of this aadhaar verification.
	 *
	 * @param aadhaarNumber the aadhaar number of this aadhaar verification
	 */
	@Override
	public void setAadhaarNumber(String aadhaarNumber) {
		model.setAadhaarNumber(aadhaarNumber);
	}

	/**
	 * Sets the aadhaar user name of this aadhaar verification.
	 *
	 * @param aadhaarUserName the aadhaar user name of this aadhaar verification
	 */
	@Override
	public void setAadhaarUserName(String aadhaarUserName) {
		model.setAadhaarUserName(aadhaarUserName);
	}

	/**
	 * Sets the primary key of this aadhaar verification.
	 *
	 * @param primaryKey the primary key of this aadhaar verification
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
	protected AadhaarVerificationWrapper wrap(
		AadhaarVerification aadhaarVerification) {

		return new AadhaarVerificationWrapper(aadhaarVerification);
	}

}