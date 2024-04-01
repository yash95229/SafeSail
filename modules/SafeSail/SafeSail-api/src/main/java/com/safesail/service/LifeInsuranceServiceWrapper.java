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
 * Provides a wrapper for {@link LifeInsuranceService}.
 *
 * @author Brian Wing Shun Chan
 * @see LifeInsuranceService
 * @generated
 */
public class LifeInsuranceServiceWrapper
	implements LifeInsuranceService, ServiceWrapper<LifeInsuranceService> {

	public LifeInsuranceServiceWrapper() {
		this(null);
	}

	public LifeInsuranceServiceWrapper(
		LifeInsuranceService lifeInsuranceService) {

		_lifeInsuranceService = lifeInsuranceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lifeInsuranceService.getOSGiServiceIdentifier();
	}

	@Override
	public LifeInsuranceService getWrappedService() {
		return _lifeInsuranceService;
	}

	@Override
	public void setWrappedService(LifeInsuranceService lifeInsuranceService) {
		_lifeInsuranceService = lifeInsuranceService;
	}

	private LifeInsuranceService _lifeInsuranceService;

}