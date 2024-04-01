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

import com.safesail.model.addOnFieldData;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the add on field data service. This utility wraps <code>com.safesail.service.persistence.impl.addOnFieldDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see addOnFieldDataPersistence
 * @generated
 */
public class addOnFieldDataUtil {

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
	public static void clearCache(addOnFieldData addOnFieldData) {
		getPersistence().clearCache(addOnFieldData);
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
	public static Map<Serializable, addOnFieldData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<addOnFieldData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<addOnFieldData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<addOnFieldData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<addOnFieldData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static addOnFieldData update(addOnFieldData addOnFieldData) {
		return getPersistence().update(addOnFieldData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static addOnFieldData update(
		addOnFieldData addOnFieldData, ServiceContext serviceContext) {

		return getPersistence().update(addOnFieldData, serviceContext);
	}

	/**
	 * Caches the add on field data in the entity cache if it is enabled.
	 *
	 * @param addOnFieldData the add on field data
	 */
	public static void cacheResult(addOnFieldData addOnFieldData) {
		getPersistence().cacheResult(addOnFieldData);
	}

	/**
	 * Caches the add on field datas in the entity cache if it is enabled.
	 *
	 * @param addOnFieldDatas the add on field datas
	 */
	public static void cacheResult(List<addOnFieldData> addOnFieldDatas) {
		getPersistence().cacheResult(addOnFieldDatas);
	}

	/**
	 * Creates a new add on field data with the primary key. Does not add the add on field data to the database.
	 *
	 * @param addonId the primary key for the new add on field data
	 * @return the new add on field data
	 */
	public static addOnFieldData create(long addonId) {
		return getPersistence().create(addonId);
	}

	/**
	 * Removes the add on field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data that was removed
	 * @throws NoSuchaddOnFieldDataException if a add on field data with the primary key could not be found
	 */
	public static addOnFieldData remove(long addonId)
		throws com.safesail.exception.NoSuchaddOnFieldDataException {

		return getPersistence().remove(addonId);
	}

	public static addOnFieldData updateImpl(addOnFieldData addOnFieldData) {
		return getPersistence().updateImpl(addOnFieldData);
	}

	/**
	 * Returns the add on field data with the primary key or throws a <code>NoSuchaddOnFieldDataException</code> if it could not be found.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data
	 * @throws NoSuchaddOnFieldDataException if a add on field data with the primary key could not be found
	 */
	public static addOnFieldData findByPrimaryKey(long addonId)
		throws com.safesail.exception.NoSuchaddOnFieldDataException {

		return getPersistence().findByPrimaryKey(addonId);
	}

	/**
	 * Returns the add on field data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data, or <code>null</code> if a add on field data with the primary key could not be found
	 */
	public static addOnFieldData fetchByPrimaryKey(long addonId) {
		return getPersistence().fetchByPrimaryKey(addonId);
	}

	/**
	 * Returns all the add on field datas.
	 *
	 * @return the add on field datas
	 */
	public static List<addOnFieldData> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<addOnFieldData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<addOnFieldData> findAll(
		int start, int end,
		OrderByComparator<addOnFieldData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<addOnFieldData> findAll(
		int start, int end, OrderByComparator<addOnFieldData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the add on field datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of add on field datas.
	 *
	 * @return the number of add on field datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static addOnFieldDataPersistence getPersistence() {
		return _persistence;
	}

	private static volatile addOnFieldDataPersistence _persistence;

}