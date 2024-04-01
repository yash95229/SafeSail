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
 * Provides a wrapper for {@link ProductTableService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductTableService
 * @generated
 */
public class ProductTableServiceWrapper
	implements ProductTableService, ServiceWrapper<ProductTableService> {

	public ProductTableServiceWrapper() {
		this(null);
	}

	public ProductTableServiceWrapper(ProductTableService productTableService) {
		_productTableService = productTableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productTableService.getOSGiServiceIdentifier();
	}

	@Override
	public ProductTableService getWrappedService() {
		return _productTableService;
	}

	@Override
	public void setWrappedService(ProductTableService productTableService) {
		_productTableService = productTableService;
	}

	private ProductTableService _productTableService;

}