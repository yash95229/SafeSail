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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.safesail.model.FieldConfiguration;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FieldConfiguration. This utility wraps
 * <code>com.safesail.service.impl.FieldConfigurationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FieldConfigurationLocalService
 * @generated
 */
public class FieldConfigurationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.safesail.service.impl.FieldConfigurationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static FieldConfiguration addFieldConfig(
		long configId, String fieldName, String fieldData, String fieldValue,
		String fieldSumAssured, Boolean fieldShow, String selectImage) {

		return getService().addFieldConfig(
			configId, fieldName, fieldData, fieldValue, fieldSumAssured,
			fieldShow, selectImage);
	}

	/**
	 * Adds the field configuration to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FieldConfigurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fieldConfiguration the field configuration
	 * @return the field configuration that was added
	 */
	public static FieldConfiguration addFieldConfiguration(
		FieldConfiguration fieldConfiguration) {

		return getService().addFieldConfiguration(fieldConfiguration);
	}

	/**
	 * Creates a new field configuration with the primary key. Does not add the field configuration to the database.
	 *
	 * @param configId the primary key for the new field configuration
	 * @return the new field configuration
	 */
	public static FieldConfiguration createFieldConfiguration(long configId) {
		return getService().createFieldConfiguration(configId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the field configuration from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FieldConfigurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fieldConfiguration the field configuration
	 * @return the field configuration that was removed
	 */
	public static FieldConfiguration deleteFieldConfiguration(
		FieldConfiguration fieldConfiguration) {

		return getService().deleteFieldConfiguration(fieldConfiguration);
	}

	/**
	 * Deletes the field configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FieldConfigurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration that was removed
	 * @throws PortalException if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration deleteFieldConfiguration(long configId)
		throws PortalException {

		return getService().deleteFieldConfiguration(configId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static FieldConfiguration fetchFieldConfiguration(long configId) {
		return getService().fetchFieldConfiguration(configId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<FieldConfiguration> getByconfigId(long configId)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getService().getByconfigId(configId);
	}

	public static List<FieldConfiguration> getByfieldData(String fieldData)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getService().getByfieldData(fieldData);
	}

	public static List<FieldConfiguration> getByfieldName(String fieldName)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getService().getByfieldName(fieldName);
	}

	public static FieldConfiguration getByfieldShow(Boolean fieldShow)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getService().getByfieldShow(fieldShow);
	}

	public static List<FieldConfiguration> getByfieldSumAssured(
			String fieldSumAssured)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getService().getByfieldSumAssured(fieldSumAssured);
	}

	public static List<FieldConfiguration> getByfieldValue(String fieldValue)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return getService().getByfieldValue(fieldValue);
	}

	/**
	 * Returns the field configuration with the primary key.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration
	 * @throws PortalException if a field configuration with the primary key could not be found
	 */
	public static FieldConfiguration getFieldConfiguration(long configId)
		throws PortalException {

		return getService().getFieldConfiguration(configId);
	}

	/**
	 * Returns a range of all the field configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of field configurations
	 */
	public static List<FieldConfiguration> getFieldConfigurations(
		int start, int end) {

		return getService().getFieldConfigurations(start, end);
	}

	/**
	 * Returns the number of field configurations.
	 *
	 * @return the number of field configurations
	 */
	public static int getFieldConfigurationsCount() {
		return getService().getFieldConfigurationsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the field configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FieldConfigurationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fieldConfiguration the field configuration
	 * @return the field configuration that was updated
	 */
	public static FieldConfiguration updateFieldConfiguration(
		FieldConfiguration fieldConfiguration) {

		return getService().updateFieldConfiguration(fieldConfiguration);
	}

	public static FieldConfigurationLocalService getService() {
		return _service;
	}

	private static volatile FieldConfigurationLocalService _service;

}