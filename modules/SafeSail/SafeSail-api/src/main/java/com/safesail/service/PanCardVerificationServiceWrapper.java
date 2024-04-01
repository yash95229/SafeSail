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
 * Provides a wrapper for {@link PanCardVerificationService}.
 *
 * @author Brian Wing Shun Chan
 * @see PanCardVerificationService
 * @generated
 */
public class PanCardVerificationServiceWrapper
	implements PanCardVerificationService,
			   ServiceWrapper<PanCardVerificationService> {

	public PanCardVerificationServiceWrapper() {
		this(null);
	}

	public PanCardVerificationServiceWrapper(
		PanCardVerificationService panCardVerificationService) {

		_panCardVerificationService = panCardVerificationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _panCardVerificationService.getOSGiServiceIdentifier();
	}

	@Override
	public PanCardVerificationService getWrappedService() {
		return _panCardVerificationService;
	}

	@Override
	public void setWrappedService(
		PanCardVerificationService panCardVerificationService) {

		_panCardVerificationService = panCardVerificationService;
	}

	private PanCardVerificationService _panCardVerificationService;

}