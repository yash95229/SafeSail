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
 * Provides a wrapper for {@link UserTableService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserTableService
 * @generated
 */
public class UserTableServiceWrapper
	implements ServiceWrapper<UserTableService>, UserTableService {

	public UserTableServiceWrapper() {
		this(null);
	}

	public UserTableServiceWrapper(UserTableService userTableService) {
		_userTableService = userTableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userTableService.getOSGiServiceIdentifier();
	}

	@Override
	public UserTableService getWrappedService() {
		return _userTableService;
	}

	@Override
	public void setWrappedService(UserTableService userTableService) {
		_userTableService = userTableService;
	}

	private UserTableService _userTableService;

}