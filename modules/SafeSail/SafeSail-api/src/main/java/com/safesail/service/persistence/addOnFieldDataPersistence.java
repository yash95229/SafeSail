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

import com.safesail.exception.NoSuchaddOnFieldDataException;
import com.safesail.model.addOnFieldData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the add on field data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see addOnFieldDataUtil
 * @generated
 */
@ProviderType
public interface addOnFieldDataPersistence
	extends BasePersistence<addOnFieldData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link addOnFieldDataUtil} to access the add on field data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the add on field data in the entity cache if it is enabled.
	 *
	 * @param addOnFieldData the add on field data
	 */
	public void cacheResult(addOnFieldData addOnFieldData);

	/**
	 * Caches the add on field datas in the entity cache if it is enabled.
	 *
	 * @param addOnFieldDatas the add on field datas
	 */
	public void cacheResult(java.util.List<addOnFieldData> addOnFieldDatas);

	/**
	 * Creates a new add on field data with the primary key. Does not add the add on field data to the database.
	 *
	 * @param addonId the primary key for the new add on field data
	 * @return the new add on field data
	 */
	public addOnFieldData create(long addonId);

	/**
	 * Removes the add on field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data that was removed
	 * @throws NoSuchaddOnFieldDataException if a add on field data with the primary key could not be found
	 */
	public addOnFieldData remove(long addonId)
		throws NoSuchaddOnFieldDataException;

	public addOnFieldData updateImpl(addOnFieldData addOnFieldData);

	/**
	 * Returns the add on field data with the primary key or throws a <code>NoSuchaddOnFieldDataException</code> if it could not be found.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data
	 * @throws NoSuchaddOnFieldDataException if a add on field data with the primary key could not be found
	 */
	public addOnFieldData findByPrimaryKey(long addonId)
		throws NoSuchaddOnFieldDataException;

	/**
	 * Returns the add on field data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data, or <code>null</code> if a add on field data with the primary key could not be found
	 */
	public addOnFieldData fetchByPrimaryKey(long addonId);

	/**
	 * Returns all the add on field datas.
	 *
	 * @return the add on field datas
	 */
	public java.util.List<addOnFieldData> findAll();

	/**
	 * Returns a range of all the add on field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>addOnFieldDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of add on field datas
	 * @param end the upper bound of the range of add on field datas (not inclusive)
	 * @return the range of add on field datas
	 */
	public java.util.List<addOnFieldData> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the add on field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>addOnFieldDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of add on field datas
	 * @param end the upper bound of the range of add on field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of add on field datas
	 */
	public java.util.List<addOnFieldData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<addOnFieldData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the add on field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>addOnFieldDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of add on field datas
	 * @param end the upper bound of the range of add on field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of add on field datas
	 */
	public java.util.List<addOnFieldData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<addOnFieldData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the add on field datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of add on field datas.
	 *
	 * @return the number of add on field datas
	 */
	public int countAll();

}