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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.safesail.exception.NoSuchProductTableException;
import com.safesail.model.ProductTable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductTableUtil
 * @generated
 */
@ProviderType
public interface ProductTablePersistence extends BasePersistence<ProductTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductTableUtil} to access the product table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product tables
	 */
	public java.util.List<ProductTable> findByUuid(String uuid);

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
	public java.util.List<ProductTable> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProductTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
			orderByComparator);

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
	public java.util.List<ProductTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	public ProductTable findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
				orderByComparator)
		throws NoSuchProductTableException;

	/**
	 * Returns the first product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public ProductTable fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
			orderByComparator);

	/**
	 * Returns the last product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	public ProductTable findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
				orderByComparator)
		throws NoSuchProductTableException;

	/**
	 * Returns the last product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public ProductTable fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
			orderByComparator);

	/**
	 * Returns the product tables before and after the current product table in the ordered set where uuid = &#63;.
	 *
	 * @param productId the primary key of the current product table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product table
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	public ProductTable[] findByUuid_PrevAndNext(
			long productId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
				orderByComparator)
		throws NoSuchProductTableException;

	/**
	 * Removes all the product tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of product tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the product table where productId = &#63; or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productId the product ID
	 * @return the matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	public ProductTable findByproductId(long productId)
		throws NoSuchProductTableException;

	/**
	 * Returns the product table where productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productId the product ID
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public ProductTable fetchByproductId(long productId);

	/**
	 * Returns the product table where productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public ProductTable fetchByproductId(
		long productId, boolean useFinderCache);

	/**
	 * Removes the product table where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @return the product table that was removed
	 */
	public ProductTable removeByproductId(long productId)
		throws NoSuchProductTableException;

	/**
	 * Returns the number of product tables where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching product tables
	 */
	public int countByproductId(long productId);

	/**
	 * Returns the product table where productName = &#63; or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productName the product name
	 * @return the matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	public ProductTable findByproductName(String productName)
		throws NoSuchProductTableException;

	/**
	 * Returns the product table where productName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productName the product name
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public ProductTable fetchByproductName(String productName);

	/**
	 * Returns the product table where productName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productName the product name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	public ProductTable fetchByproductName(
		String productName, boolean useFinderCache);

	/**
	 * Removes the product table where productName = &#63; from the database.
	 *
	 * @param productName the product name
	 * @return the product table that was removed
	 */
	public ProductTable removeByproductName(String productName)
		throws NoSuchProductTableException;

	/**
	 * Returns the number of product tables where productName = &#63;.
	 *
	 * @param productName the product name
	 * @return the number of matching product tables
	 */
	public int countByproductName(String productName);

	/**
	 * Caches the product table in the entity cache if it is enabled.
	 *
	 * @param productTable the product table
	 */
	public void cacheResult(ProductTable productTable);

	/**
	 * Caches the product tables in the entity cache if it is enabled.
	 *
	 * @param productTables the product tables
	 */
	public void cacheResult(java.util.List<ProductTable> productTables);

	/**
	 * Creates a new product table with the primary key. Does not add the product table to the database.
	 *
	 * @param productId the primary key for the new product table
	 * @return the new product table
	 */
	public ProductTable create(long productId);

	/**
	 * Removes the product table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table that was removed
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	public ProductTable remove(long productId)
		throws NoSuchProductTableException;

	public ProductTable updateImpl(ProductTable productTable);

	/**
	 * Returns the product table with the primary key or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	public ProductTable findByPrimaryKey(long productId)
		throws NoSuchProductTableException;

	/**
	 * Returns the product table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table, or <code>null</code> if a product table with the primary key could not be found
	 */
	public ProductTable fetchByPrimaryKey(long productId);

	/**
	 * Returns all the product tables.
	 *
	 * @return the product tables
	 */
	public java.util.List<ProductTable> findAll();

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
	public java.util.List<ProductTable> findAll(int start, int end);

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
	public java.util.List<ProductTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
			orderByComparator);

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
	public java.util.List<ProductTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product tables.
	 *
	 * @return the number of product tables
	 */
	public int countAll();

}