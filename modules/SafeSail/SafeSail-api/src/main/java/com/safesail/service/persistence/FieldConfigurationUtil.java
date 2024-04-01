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

import com.safesail.model.FieldConfiguration;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the field configuration service. This utility wraps <code>com.safesail.service.persistence.impl.FieldConfigurationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldConfigurationPersistence
 * @generated
 */
public class FieldConfigurationUtil {

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
	public static void clearCache(FieldConfiguration fieldConfiguration) {
		getPersistence().clearCache(fieldConfiguration);
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
	public static Map<Serializable, FieldConfiguration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FieldConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FieldConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FieldConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FieldConfiguration update(
		FieldConfiguration fieldConfiguration) {

		return getPersistence().update(fieldConfiguration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FieldConfiguration update(
		FieldConfiguration fieldConfiguration, ServiceContext serviceContext) {

		return getPersistence().update(fieldConfiguration, serviceContext);
	}

	/**
	 * Returns all the field configurations where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @return the matching field configurations
	 */
	public static List<FieldConfiguration> findByconfigId(long configId) {
		return getPersistence().findByconfigId(configId);
	}

	/**
	 * Returns a range of all the field configurations where configId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param configId the config ID
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	public static List<FieldConfiguration> findByconfigId(
		long configId, int start, int end) {

		return getPersistence().findByconfigId(configId, start, end);
	}

	/**
	 * Returns an ordered range of all the field configurations where configId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param configId the config ID
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByconfigId(
		long configId, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().findByconfigId(
			configId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the field configurations where configId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param configId the config ID
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByconfigId(
		long configId, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByconfigId(
			configId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByconfigId_First(
			long configId,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByconfigId_First(
			configId, orderByComparator);
	}

	/**
	 * Returns the first field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByconfigId_First(
		long configId,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByconfigId_First(
			configId, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByconfigId_Last(
			long configId,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByconfigId_Last(
			configId, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByconfigId_Last(
		long configId,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByconfigId_Last(
			configId, orderByComparator);
	}

	/**
	 * Removes all the field configurations where configId = &#63; from the database.
	 *
	 * @param configId the config ID
	 */
	public static void removeByconfigId(long configId) {
		getPersistence().removeByconfigId(configId);
	}

	/**
	 * Returns the number of field configurations where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @return the number of matching field configurations
	 */
	public static int countByconfigId(long configId) {
		return getPersistence().countByconfigId(configId);
	}

	/**
	 * Returns all the field configurations where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @return the matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldName(String fieldName) {
		return getPersistence().findByfieldName(fieldName);
	}

	/**
	 * Returns a range of all the field configurations where fieldName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldName the field name
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end) {

		return getPersistence().findByfieldName(fieldName, start, end);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldName the field name
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().findByfieldName(
			fieldName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldName the field name
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfieldName(
			fieldName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldName_First(
			String fieldName,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldName_First(
			fieldName, orderByComparator);
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldName_First(
		String fieldName,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByfieldName_First(
			fieldName, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldName_Last(
			String fieldName,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldName_Last(
			fieldName, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldName_Last(
		String fieldName,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByfieldName_Last(
			fieldName, orderByComparator);
	}

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration[] findByfieldName_PrevAndNext(
			long configId, String fieldName,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldName_PrevAndNext(
			configId, fieldName, orderByComparator);
	}

	/**
	 * Removes all the field configurations where fieldName = &#63; from the database.
	 *
	 * @param fieldName the field name
	 */
	public static void removeByfieldName(String fieldName) {
		getPersistence().removeByfieldName(fieldName);
	}

	/**
	 * Returns the number of field configurations where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @return the number of matching field configurations
	 */
	public static int countByfieldName(String fieldName) {
		return getPersistence().countByfieldName(fieldName);
	}

	/**
	 * Returns all the field configurations where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @return the matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldData(String fieldData) {
		return getPersistence().findByfieldData(fieldData);
	}

	/**
	 * Returns a range of all the field configurations where fieldData = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldData the field data
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end) {

		return getPersistence().findByfieldData(fieldData, start, end);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldData = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldData the field data
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().findByfieldData(
			fieldData, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldData = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldData the field data
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfieldData(
			fieldData, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldData_First(
			String fieldData,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldData_First(
			fieldData, orderByComparator);
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldData_First(
		String fieldData,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByfieldData_First(
			fieldData, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldData_Last(
			String fieldData,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldData_Last(
			fieldData, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldData_Last(
		String fieldData,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByfieldData_Last(
			fieldData, orderByComparator);
	}

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration[] findByfieldData_PrevAndNext(
			long configId, String fieldData,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldData_PrevAndNext(
			configId, fieldData, orderByComparator);
	}

	/**
	 * Removes all the field configurations where fieldData = &#63; from the database.
	 *
	 * @param fieldData the field data
	 */
	public static void removeByfieldData(String fieldData) {
		getPersistence().removeByfieldData(fieldData);
	}

	/**
	 * Returns the number of field configurations where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @return the number of matching field configurations
	 */
	public static int countByfieldData(String fieldData) {
		return getPersistence().countByfieldData(fieldData);
	}

	/**
	 * Returns all the field configurations where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @return the matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldValue(String fieldValue) {
		return getPersistence().findByfieldValue(fieldValue);
	}

	/**
	 * Returns a range of all the field configurations where fieldValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldValue the field value
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end) {

		return getPersistence().findByfieldValue(fieldValue, start, end);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldValue the field value
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().findByfieldValue(
			fieldValue, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldValue the field value
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfieldValue(
			fieldValue, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldValue_First(
			String fieldValue,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldValue_First(
			fieldValue, orderByComparator);
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldValue_First(
		String fieldValue,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByfieldValue_First(
			fieldValue, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldValue_Last(
			String fieldValue,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldValue_Last(
			fieldValue, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldValue_Last(
		String fieldValue,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByfieldValue_Last(
			fieldValue, orderByComparator);
	}

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration[] findByfieldValue_PrevAndNext(
			long configId, String fieldValue,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldValue_PrevAndNext(
			configId, fieldValue, orderByComparator);
	}

	/**
	 * Removes all the field configurations where fieldValue = &#63; from the database.
	 *
	 * @param fieldValue the field value
	 */
	public static void removeByfieldValue(String fieldValue) {
		getPersistence().removeByfieldValue(fieldValue);
	}

	/**
	 * Returns the number of field configurations where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @return the number of matching field configurations
	 */
	public static int countByfieldValue(String fieldValue) {
		return getPersistence().countByfieldValue(fieldValue);
	}

	/**
	 * Returns all the field configurations where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @return the matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured) {

		return getPersistence().findByfieldSumAssured(fieldSumAssured);
	}

	/**
	 * Returns a range of all the field configurations where fieldSumAssured = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end) {

		return getPersistence().findByfieldSumAssured(
			fieldSumAssured, start, end);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldSumAssured = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().findByfieldSumAssured(
			fieldSumAssured, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldSumAssured = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	public static List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByfieldSumAssured(
			fieldSumAssured, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldSumAssured_First(
			String fieldSumAssured,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldSumAssured_First(
			fieldSumAssured, orderByComparator);
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldSumAssured_First(
		String fieldSumAssured,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByfieldSumAssured_First(
			fieldSumAssured, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldSumAssured_Last(
			String fieldSumAssured,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldSumAssured_Last(
			fieldSumAssured, orderByComparator);
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldSumAssured_Last(
		String fieldSumAssured,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().fetchByfieldSumAssured_Last(
			fieldSumAssured, orderByComparator);
	}

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration[] findByfieldSumAssured_PrevAndNext(
			long configId, String fieldSumAssured,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldSumAssured_PrevAndNext(
			configId, fieldSumAssured, orderByComparator);
	}

	/**
	 * Removes all the field configurations where fieldSumAssured = &#63; from the database.
	 *
	 * @param fieldSumAssured the field sum assured
	 */
	public static void removeByfieldSumAssured(String fieldSumAssured) {
		getPersistence().removeByfieldSumAssured(fieldSumAssured);
	}

	/**
	 * Returns the number of field configurations where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @return the number of matching field configurations
	 */
	public static int countByfieldSumAssured(String fieldSumAssured) {
		return getPersistence().countByfieldSumAssured(fieldSumAssured);
	}

	/**
	 * Returns the field configuration where fieldShow = &#63; or throws a <code>NoSuchFieldConfigurationException</code> if it could not be found.
	 *
	 * @param fieldShow the field show
	 * @return the matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public static FieldConfiguration findByfieldShow(Boolean fieldShow)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByfieldShow(fieldShow);
	}

	/**
	 * Returns the field configuration where fieldShow = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fieldShow the field show
	 * @return the matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldShow(Boolean fieldShow) {
		return getPersistence().fetchByfieldShow(fieldShow);
	}

	/**
	 * Returns the field configuration where fieldShow = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldShow the field show
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public static FieldConfiguration fetchByfieldShow(
		Boolean fieldShow, boolean useFinderCache) {

		return getPersistence().fetchByfieldShow(fieldShow, useFinderCache);
	}

	/**
	 * Removes the field configuration where fieldShow = &#63; from the database.
	 *
	 * @param fieldShow the field show
	 * @return the field configuration that was removed
	 */
	public static FieldConfiguration removeByfieldShow(Boolean fieldShow)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().removeByfieldShow(fieldShow);
	}

	/**
	 * Returns the number of field configurations where fieldShow = &#63;.
	 *
	 * @param fieldShow the field show
	 * @return the number of matching field configurations
	 */
	public static int countByfieldShow(Boolean fieldShow) {
		return getPersistence().countByfieldShow(fieldShow);
	}

	/**
	 * Caches the field configuration in the entity cache if it is enabled.
	 *
	 * @param fieldConfiguration the field configuration
	 */
	public static void cacheResult(FieldConfiguration fieldConfiguration) {
		getPersistence().cacheResult(fieldConfiguration);
	}

	/**
	 * Caches the field configurations in the entity cache if it is enabled.
	 *
	 * @param fieldConfigurations the field configurations
	 */
	public static void cacheResult(
		List<FieldConfiguration> fieldConfigurations) {

		getPersistence().cacheResult(fieldConfigurations);
	}

	/**
	 * Creates a new field configuration with the primary key. Does not add the field configuration to the database.
	 *
	 * @param configId the primary key for the new field configuration
	 * @return the new field configuration
	 */
	public static FieldConfiguration create(long configId) {
		return getPersistence().create(configId);
	}

	/**
	 * Removes the field configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration that was removed
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration remove(long configId)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().remove(configId);
	}

	public static FieldConfiguration updateImpl(
		FieldConfiguration fieldConfiguration) {

		return getPersistence().updateImpl(fieldConfiguration);
	}

	/**
	 * Returns the field configuration with the primary key or throws a <code>NoSuchFieldConfigurationException</code> if it could not be found.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration findByPrimaryKey(long configId)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getPersistence().findByPrimaryKey(configId);
	}

	/**
	 * Returns the field configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration, or <code>null</code> if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration fetchByPrimaryKey(long configId) {
		return getPersistence().fetchByPrimaryKey(configId);
	}

	/**
	 * Returns all the field configurations.
	 *
	 * @return the field configurations
	 */
	public static List<FieldConfiguration> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the field configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of field configurations
	 */
	public static List<FieldConfiguration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the field configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of field configurations
	 */
	public static List<FieldConfiguration> findAll(
		int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the field configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of field configurations
	 */
	public static List<FieldConfiguration> findAll(
		int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the field configurations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of field configurations.
	 *
	 * @return the number of field configurations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FieldConfigurationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FieldConfigurationPersistence _persistence;

}