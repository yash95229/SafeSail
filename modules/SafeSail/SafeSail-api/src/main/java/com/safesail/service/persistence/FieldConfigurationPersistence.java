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

import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.model.FieldConfiguration;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the field configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FieldConfigurationUtil
 * @generated
 */
@ProviderType
public interface FieldConfigurationPersistence
	extends BasePersistence<FieldConfiguration> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FieldConfigurationUtil} to access the field configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the field configurations where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @return the matching field configurations
	 */
	public java.util.List<FieldConfiguration> findByconfigId(long configId);

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
	public java.util.List<FieldConfiguration> findByconfigId(
		long configId, int start, int end);

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
	public java.util.List<FieldConfiguration> findByconfigId(
		long configId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

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
	public java.util.List<FieldConfiguration> findByconfigId(
		long configId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByconfigId_First(
			long configId,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the first field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByconfigId_First(
		long configId,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the last field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByconfigId_Last(
			long configId,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the last field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByconfigId_Last(
		long configId,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Removes all the field configurations where configId = &#63; from the database.
	 *
	 * @param configId the config ID
	 */
	public void removeByconfigId(long configId);

	/**
	 * Returns the number of field configurations where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @return the number of matching field configurations
	 */
	public int countByconfigId(long configId);

	/**
	 * Returns all the field configurations where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @return the matching field configurations
	 */
	public java.util.List<FieldConfiguration> findByfieldName(String fieldName);

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
	public java.util.List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end);

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
	public java.util.List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

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
	public java.util.List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldName_First(
			String fieldName,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the first field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldName_First(
		String fieldName,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the last field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldName_Last(
			String fieldName,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the last field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldName_Last(
		String fieldName,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public FieldConfiguration[] findByfieldName_PrevAndNext(
			long configId, String fieldName,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Removes all the field configurations where fieldName = &#63; from the database.
	 *
	 * @param fieldName the field name
	 */
	public void removeByfieldName(String fieldName);

	/**
	 * Returns the number of field configurations where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @return the number of matching field configurations
	 */
	public int countByfieldName(String fieldName);

	/**
	 * Returns all the field configurations where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @return the matching field configurations
	 */
	public java.util.List<FieldConfiguration> findByfieldData(String fieldData);

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
	public java.util.List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end);

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
	public java.util.List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

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
	public java.util.List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldData_First(
			String fieldData,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the first field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldData_First(
		String fieldData,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the last field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldData_Last(
			String fieldData,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the last field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldData_Last(
		String fieldData,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public FieldConfiguration[] findByfieldData_PrevAndNext(
			long configId, String fieldData,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Removes all the field configurations where fieldData = &#63; from the database.
	 *
	 * @param fieldData the field data
	 */
	public void removeByfieldData(String fieldData);

	/**
	 * Returns the number of field configurations where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @return the number of matching field configurations
	 */
	public int countByfieldData(String fieldData);

	/**
	 * Returns all the field configurations where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @return the matching field configurations
	 */
	public java.util.List<FieldConfiguration> findByfieldValue(
		String fieldValue);

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
	public java.util.List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end);

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
	public java.util.List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

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
	public java.util.List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldValue_First(
			String fieldValue,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the first field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldValue_First(
		String fieldValue,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the last field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldValue_Last(
			String fieldValue,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the last field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldValue_Last(
		String fieldValue,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public FieldConfiguration[] findByfieldValue_PrevAndNext(
			long configId, String fieldValue,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Removes all the field configurations where fieldValue = &#63; from the database.
	 *
	 * @param fieldValue the field value
	 */
	public void removeByfieldValue(String fieldValue);

	/**
	 * Returns the number of field configurations where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @return the number of matching field configurations
	 */
	public int countByfieldValue(String fieldValue);

	/**
	 * Returns all the field configurations where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @return the matching field configurations
	 */
	public java.util.List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured);

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
	public java.util.List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end);

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
	public java.util.List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

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
	public java.util.List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldSumAssured_First(
			String fieldSumAssured,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the first field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldSumAssured_First(
		String fieldSumAssured,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the last field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldSumAssured_Last(
			String fieldSumAssured,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the last field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldSumAssured_Last(
		String fieldSumAssured,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public FieldConfiguration[] findByfieldSumAssured_PrevAndNext(
			long configId, String fieldSumAssured,
			com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
				orderByComparator)
		throws NoSuchFieldConfigurationException;

	/**
	 * Removes all the field configurations where fieldSumAssured = &#63; from the database.
	 *
	 * @param fieldSumAssured the field sum assured
	 */
	public void removeByfieldSumAssured(String fieldSumAssured);

	/**
	 * Returns the number of field configurations where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @return the number of matching field configurations
	 */
	public int countByfieldSumAssured(String fieldSumAssured);

	/**
	 * Returns the field configuration where fieldShow = &#63; or throws a <code>NoSuchFieldConfigurationException</code> if it could not be found.
	 *
	 * @param fieldShow the field show
	 * @return the matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	public FieldConfiguration findByfieldShow(Boolean fieldShow)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the field configuration where fieldShow = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fieldShow the field show
	 * @return the matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldShow(Boolean fieldShow);

	/**
	 * Returns the field configuration where fieldShow = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldShow the field show
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	public FieldConfiguration fetchByfieldShow(
		Boolean fieldShow, boolean useFinderCache);

	/**
	 * Removes the field configuration where fieldShow = &#63; from the database.
	 *
	 * @param fieldShow the field show
	 * @return the field configuration that was removed
	 */
	public FieldConfiguration removeByfieldShow(Boolean fieldShow)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the number of field configurations where fieldShow = &#63;.
	 *
	 * @param fieldShow the field show
	 * @return the number of matching field configurations
	 */
	public int countByfieldShow(Boolean fieldShow);

	/**
	 * Caches the field configuration in the entity cache if it is enabled.
	 *
	 * @param fieldConfiguration the field configuration
	 */
	public void cacheResult(FieldConfiguration fieldConfiguration);

	/**
	 * Caches the field configurations in the entity cache if it is enabled.
	 *
	 * @param fieldConfigurations the field configurations
	 */
	public void cacheResult(
		java.util.List<FieldConfiguration> fieldConfigurations);

	/**
	 * Creates a new field configuration with the primary key. Does not add the field configuration to the database.
	 *
	 * @param configId the primary key for the new field configuration
	 * @return the new field configuration
	 */
	public FieldConfiguration create(long configId);

	/**
	 * Removes the field configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration that was removed
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public FieldConfiguration remove(long configId)
		throws NoSuchFieldConfigurationException;

	public FieldConfiguration updateImpl(FieldConfiguration fieldConfiguration);

	/**
	 * Returns the field configuration with the primary key or throws a <code>NoSuchFieldConfigurationException</code> if it could not be found.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	public FieldConfiguration findByPrimaryKey(long configId)
		throws NoSuchFieldConfigurationException;

	/**
	 * Returns the field configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration, or <code>null</code> if a field configuration with the primary key could not be found
	 */
	public FieldConfiguration fetchByPrimaryKey(long configId);

	/**
	 * Returns all the field configurations.
	 *
	 * @return the field configurations
	 */
	public java.util.List<FieldConfiguration> findAll();

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
	public java.util.List<FieldConfiguration> findAll(int start, int end);

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
	public java.util.List<FieldConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator);

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
	public java.util.List<FieldConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FieldConfiguration>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the field configurations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of field configurations.
	 *
	 * @return the number of field configurations
	 */
	public int countAll();

}