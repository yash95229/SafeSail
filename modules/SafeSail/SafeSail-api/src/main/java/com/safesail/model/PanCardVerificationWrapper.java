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
 * This class is a wrapper for {@link PanCardVerification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PanCardVerification
 * @generated
 */
public class PanCardVerificationWrapper
	extends BaseModelWrapper<PanCardVerification>
	implements ModelWrapper<PanCardVerification>, PanCardVerification {

	public PanCardVerificationWrapper(PanCardVerification panCardVerification) {
		super(panCardVerification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("panId", getPanId());
		attributes.put("panUserName", getPanUserName());
		attributes.put("panNumber", getPanNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long panId = (Long)attributes.get("panId");

		if (panId != null) {
			setPanId(panId);
		}

		String panUserName = (String)attributes.get("panUserName");

		if (panUserName != null) {
			setPanUserName(panUserName);
		}

		String panNumber = (String)attributes.get("panNumber");

		if (panNumber != null) {
			setPanNumber(panNumber);
		}
	}

	@Override
	public PanCardVerification cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the pan ID of this pan card verification.
	 *
	 * @return the pan ID of this pan card verification
	 */
	@Override
	public long getPanId() {
		return model.getPanId();
	}

	/**
	 * Returns the pan number of this pan card verification.
	 *
	 * @return the pan number of this pan card verification
	 */
	@Override
	public String getPanNumber() {
		return model.getPanNumber();
	}

	/**
	 * Returns the pan user name of this pan card verification.
	 *
	 * @return the pan user name of this pan card verification
	 */
	@Override
	public String getPanUserName() {
		return model.getPanUserName();
	}

	/**
	 * Returns the primary key of this pan card verification.
	 *
	 * @return the primary key of this pan card verification
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
	 * Sets the pan ID of this pan card verification.
	 *
	 * @param panId the pan ID of this pan card verification
	 */
	@Override
	public void setPanId(long panId) {
		model.setPanId(panId);
	}

	/**
	 * Sets the pan number of this pan card verification.
	 *
	 * @param panNumber the pan number of this pan card verification
	 */
	@Override
	public void setPanNumber(String panNumber) {
		model.setPanNumber(panNumber);
	}

	/**
	 * Sets the pan user name of this pan card verification.
	 *
	 * @param panUserName the pan user name of this pan card verification
	 */
	@Override
	public void setPanUserName(String panUserName) {
		model.setPanUserName(panUserName);
	}

	/**
	 * Sets the primary key of this pan card verification.
	 *
	 * @param primaryKey the primary key of this pan card verification
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
	protected PanCardVerificationWrapper wrap(
		PanCardVerification panCardVerification) {

		return new PanCardVerificationWrapper(panCardVerification);
	}

}