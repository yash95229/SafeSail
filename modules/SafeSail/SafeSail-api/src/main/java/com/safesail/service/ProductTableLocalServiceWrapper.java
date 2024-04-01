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
 * Provides a wrapper for {@link ProductTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductTableLocalService
 * @generated
 */
public class ProductTableLocalServiceWrapper
	implements ProductTableLocalService,
			   ServiceWrapper<ProductTableLocalService> {

	public ProductTableLocalServiceWrapper() {
		this(null);
	}

	public ProductTableLocalServiceWrapper(
		ProductTableLocalService productTableLocalService) {

		_productTableLocalService = productTableLocalService;
	}

	/**
	 * Adds the product table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productTable the product table
	 * @return the product table that was added
	 */
	@Override
	public com.safesail.model.ProductTable addProductTable(
		com.safesail.model.ProductTable productTable) {

		return _productTableLocalService.addProductTable(productTable);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new product table with the primary key. Does not add the product table to the database.
	 *
	 * @param productId the primary key for the new product table
	 * @return the new product table
	 */
	@Override
	public com.safesail.model.ProductTable createProductTable(long productId) {
		return _productTableLocalService.createProductTable(productId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTableLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productId the primary key of the product table
	 * @return the product table that was removed
	 * @throws PortalException if a product table with the primary key could not be found
	 */
	@Override
	public com.safesail.model.ProductTable deleteProductTable(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTableLocalService.deleteProductTable(productId);
	}

	/**
	 * Deletes the product table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productTable the product table
	 * @return the product table that was removed
	 */
	@Override
	public com.safesail.model.ProductTable deleteProductTable(
		com.safesail.model.ProductTable productTable) {

		return _productTableLocalService.deleteProductTable(productTable);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productTableLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productTableLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productTableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.safesail.model.ProductTable fetchByProductName(
		String productName) {

		return _productTableLocalService.fetchByProductName(productName);
	}

	@Override
	public com.safesail.model.ProductTable fetchProductTable(long productId) {
		return _productTableLocalService.fetchProductTable(productId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productTableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product table with the primary key.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table
	 * @throws PortalException if a product table with the primary key could not be found
	 */
	@Override
	public com.safesail.model.ProductTable getProductTable(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productTableLocalService.getProductTable(productId);
	}

	/**
	 * Returns a range of all the product tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @return the range of product tables
	 */
	@Override
	public java.util.List<com.safesail.model.ProductTable> getProductTables(
		int start, int end) {

		return _productTableLocalService.getProductTables(start, end);
	}

	/**
	 * Returns the number of product tables.
	 *
	 * @return the number of product tables
	 */
	@Override
	public int getProductTablesCount() {
		return _productTableLocalService.getProductTablesCount();
	}

	/**
	 * Updates the product table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productTable the product table
	 * @return the product table that was updated
	 */
	@Override
	public com.safesail.model.ProductTable updateProductTable(
		com.safesail.model.ProductTable productTable) {

		return _productTableLocalService.updateProductTable(productTable);
	}

	@Override
	public ProductTableLocalService getWrappedService() {
		return _productTableLocalService;
	}

	@Override
	public void setWrappedService(
		ProductTableLocalService productTableLocalService) {

		_productTableLocalService = productTableLocalService;
	}

	private ProductTableLocalService _productTableLocalService;

}