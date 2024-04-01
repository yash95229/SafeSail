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

package com.safesail.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AadhaarVerificationService}.
 *
 * @author Brian Wing Shun Chan
 * @see AadhaarVerificationService
 * @generated
 */
public class AadhaarVerificationServiceWrapper
	implements AadhaarVerificationService,
			   ServiceWrapper<AadhaarVerificationService> {

	public AadhaarVerificationServiceWrapper() {
		this(null);
	}

	public AadhaarVerificationServiceWrapper(
		AadhaarVerificationService aadhaarVerificationService) {

		_aadhaarVerificationService = aadhaarVerificationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _aadhaarVerificationService.getOSGiServiceIdentifier();
	}

	@Override
	public AadhaarVerificationService getWrappedService() {
		return _aadhaarVerificationService;
	}

	@Override
	public void setWrappedService(
		AadhaarVerificationService aadhaarVerificationService) {

		_aadhaarVerificationService = aadhaarVerificationService;
	}

	private AadhaarVerificationService _aadhaarVerificationService;

}