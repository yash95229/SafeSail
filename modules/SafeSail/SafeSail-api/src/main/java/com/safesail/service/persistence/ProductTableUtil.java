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

package com.safesail.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.safesail.model.ProductTable;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the product table service. This utility wraps <code>com.safesail.service.persistence.impl.ProductTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductTablePersistence
 * @generated
 */
public class ProductTableUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProductTable productTable) {
		getPersistence().clearCache(productTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProductTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductTable update(ProductTable productTable) {
		return getPersistence().update(productTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductTable update(
		ProductTable productTable, ServiceContext serviceContext) {

		return getPersistence().update(productTable, serviceContext);
	}

	/**
	 * Returns all the product tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product tables
	 */
	public static List<ProductTable> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the product tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @return the range of matching product tables
	 */
	public static List<ProductTable> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the product tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product tables
	 */
	public static List<ProductTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductTable> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product tables
	 */
	public static List<ProductTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	public static ProductTable findByUuid_First(
			String uuid, OrderByComparator<ProductTable> orderByComparator)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public static ProductTable fetchByUuid_First(
		String uuid, OrderByComparator<ProductTable> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	public static ProductTable findByUuid_Last(
			String uuid, OrderByComparator<ProductTable> orderByComparator)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public static ProductTable fetchByUuid_Last(
		String uuid, OrderByComparator<ProductTable> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the product tables before and after the current product table in the ordered set where uuid = &#63;.
	 *
	 * @param productId the primary key of the current product table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product table
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	public static ProductTable[] findByUuid_PrevAndNext(
			long productId, String uuid,
			OrderByComparator<ProductTable> orderByComparator)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().findByUuid_PrevAndNext(
			productId, uuid, orderByComparator);
	}

	/**
	 * Removes all the product tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of product tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product tables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the product table where productId = &#63; or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productId the product ID
	 * @return the matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	public static ProductTable findByproductId(long productId)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().findByproductId(productId);
	}

	/**
	 * Returns the product table where productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productId the product ID
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public static ProductTable fetchByproductId(long productId) {
		return getPersistence().fetchByproductId(productId);
	}

	/**
	 * Returns the product table where productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public static ProductTable fetchByproductId(
		long productId, boolean useFinderCache) {

		return getPersistence().fetchByproductId(productId, useFinderCache);
	}

	/**
	 * Removes the product table where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @return the product table that was removed
	 */
	public static ProductTable removeByproductId(long productId)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().removeByproductId(productId);
	}

	/**
	 * Returns the number of product tables where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching product tables
	 */
	public static int countByproductId(long productId) {
		return getPersistence().countByproductId(productId);
	}

	/**
	 * Returns the product table where productName = &#63; or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productName the product name
	 * @return the matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	public static ProductTable findByproductName(String productName)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().findByproductName(productName);
	}

	/**
	 * Returns the product table where productName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productName the product name
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public static ProductTable fetchByproductName(String productName) {
		return getPersistence().fetchByproductName(productName);
	}

	/**
	 * Returns the product table where productName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productName the product name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public static ProductTable fetchByproductName(
		String productName, boolean useFinderCache) {

		return getPersistence().fetchByproductName(productName, useFinderCache);
	}

	/**
	 * Removes the product table where productName = &#63; from the database.
	 *
	 * @param productName the product name
	 * @return the product table that was removed
	 */
	public static ProductTable removeByproductName(String productName)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().removeByproductName(productName);
	}

	/**
	 * Returns the number of product tables where productName = &#63;.
	 *
	 * @param productName the product name
	 * @return the number of matching product tables
	 */
	public static int countByproductName(String productName) {
		return getPersistence().countByproductName(productName);
	}

	/**
	 * Caches the product table in the entity cache if it is enabled.
	 *
	 * @param productTable the product table
	 */
	public static void cacheResult(ProductTable productTable) {
		getPersistence().cacheResult(productTable);
	}

	/**
	 * Caches the product tables in the entity cache if it is enabled.
	 *
	 * @param productTables the product tables
	 */
	public static void cacheResult(List<ProductTable> productTables) {
		getPersistence().cacheResult(productTables);
	}

	/**
	 * Creates a new product table with the primary key. Does not add the product table to the database.
	 *
	 * @param productId the primary key for the new product table
	 * @return the new product table
	 */
	public static ProductTable create(long productId) {
		return getPersistence().create(productId);
	}

	/**
	 * Removes the product table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table that was removed
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	public static ProductTable remove(long productId)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().remove(productId);
	}

	public static ProductTable updateImpl(ProductTable productTable) {
		return getPersistence().updateImpl(productTable);
	}

	/**
	 * Returns the product table with the primary key or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	public static ProductTable findByPrimaryKey(long productId)
		throws com.safesail.exception.NoSuchProductTableException {

		return getPersistence().findByPrimaryKey(productId);
	}

	/**
	 * Returns the product table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table, or <code>null</code> if a product table with the primary key could not be found
	 */
	public static ProductTable fetchByPrimaryKey(long productId) {
		return getPersistence().fetchByPrimaryKey(productId);
	}

	/**
	 * Returns all the product tables.
	 *
	 * @return the product tables
	 */
	public static List<ProductTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the product tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @return the range of product tables
	 */
	public static List<ProductTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the product tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product tables
	 */
	public static List<ProductTable> findAll(
		int start, int end, OrderByComparator<ProductTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the product tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product tables
	 */
	public static List<ProductTable> findAll(
		int start, int end, OrderByComparator<ProductTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the product tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of product tables.
	 *
	 * @return the number of product tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductTablePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProductTablePersistence _persistence;

}