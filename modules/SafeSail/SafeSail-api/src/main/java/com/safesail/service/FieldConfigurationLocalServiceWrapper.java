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
 * Provides a wrapper for {@link FieldConfigurationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FieldConfigurationLocalService
 * @generated
 */
public class FieldConfigurationLocalServiceWrapper
	implements FieldConfigurationLocalService,
			   ServiceWrapper<FieldConfigurationLocalService> {

	public FieldConfigurationLocalServiceWrapper() {
		this(null);
	}

	public FieldConfigurationLocalServiceWrapper(
		FieldConfigurationLocalService fieldConfigurationLocalService) {

		_fieldConfigurationLocalService = fieldConfigurationLocalService;
	}

	@Override
	public com.safesail.model.FieldConfiguration addFieldConfig(
		long configId, String fieldName, String fieldData, String fieldValue,
		String fieldSumAssured, Boolean fieldShow, String selectImage) {

		return _fieldConfigurationLocalService.addFieldConfig(
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
	@Override
	public com.safesail.model.FieldConfiguration addFieldConfiguration(
		com.safesail.model.FieldConfiguration fieldConfiguration) {

		return _fieldConfigurationLocalService.addFieldConfiguration(
			fieldConfiguration);
	}

	/**
	 * Creates a new field configuration with the primary key. Does not add the field configuration to the database.
	 *
	 * @param configId the primary key for the new field configuration
	 * @return the new field configuration
	 */
	@Override
	public com.safesail.model.FieldConfiguration createFieldConfiguration(
		long configId) {

		return _fieldConfigurationLocalService.createFieldConfiguration(
			configId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldConfigurationLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.safesail.model.FieldConfiguration deleteFieldConfiguration(
		com.safesail.model.FieldConfiguration fieldConfiguration) {

		return _fieldConfigurationLocalService.deleteFieldConfiguration(
			fieldConfiguration);
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
	@Override
	public com.safesail.model.FieldConfiguration deleteFieldConfiguration(
			long configId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldConfigurationLocalService.deleteFieldConfiguration(
			configId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldConfigurationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fieldConfigurationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fieldConfigurationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fieldConfigurationLocalService.dynamicQuery();
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

		return _fieldConfigurationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _fieldConfigurationLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _fieldConfigurationLocalService.dynamicQuery(
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

		return _fieldConfigurationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fieldConfigurationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.safesail.model.FieldConfiguration fetchFieldConfiguration(
		long configId) {

		return _fieldConfigurationLocalService.fetchFieldConfiguration(
			configId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fieldConfigurationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.safesail.model.FieldConfiguration> getByconfigId(
			long configId)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return _fieldConfigurationLocalService.getByconfigId(configId);
	}

	@Override
	public java.util.List<com.safesail.model.FieldConfiguration> getByfieldData(
			String fieldData)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return _fieldConfigurationLocalService.getByfieldData(fieldData);
	}

	@Override
	public java.util.List<com.safesail.model.FieldConfiguration> getByfieldName(
			String fieldName)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return _fieldConfigurationLocalService.getByfieldName(fieldName);
	}

	@Override
	public com.safesail.model.FieldConfiguration getByfieldShow(
			Boolean fieldShow)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return _fieldConfigurationLocalService.getByfieldShow(fieldShow);
	}

	@Override
	public java.util.List<com.safesail.model.FieldConfiguration>
			getByfieldSumAssured(String fieldSumAssured)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return _fieldConfigurationLocalService.getByfieldSumAssured(
			fieldSumAssured);
	}

	@Override
	public java.util.List<com.safesail.model.FieldConfiguration>
			getByfieldValue(String fieldValue)
		throws com.safesail.exception.NoSuchFieldConfigurationException {

		return _fieldConfigurationLocalService.getByfieldValue(fieldValue);
	}

	/**
	 * Returns the field configuration with the primary key.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration
	 * @throws PortalException if a field configuration with the primary key could not be found
	 */
	@Override
	public com.safesail.model.FieldConfiguration getFieldConfiguration(
			long configId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldConfigurationLocalService.getFieldConfiguration(configId);
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
	@Override
	public java.util.List<com.safesail.model.FieldConfiguration>
		getFieldConfigurations(int start, int end) {

		return _fieldConfigurationLocalService.getFieldConfigurations(
			start, end);
	}

	/**
	 * Returns the number of field configurations.
	 *
	 * @return the number of field configurations
	 */
	@Override
	public int getFieldConfigurationsCount() {
		return _fieldConfigurationLocalService.getFieldConfigurationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fieldConfigurationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fieldConfigurationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fieldConfigurationLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.safesail.model.FieldConfiguration updateFieldConfiguration(
		com.safesail.model.FieldConfiguration fieldConfiguration) {

		return _fieldConfigurationLocalService.updateFieldConfiguration(
			fieldConfiguration);
	}

	@Override
	public FieldConfigurationLocalService getWrappedService() {
		return _fieldConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		FieldConfigurationLocalService fieldConfigurationLocalService) {

		_fieldConfigurationLocalService = fieldConfigurationLocalService;
	}

	private FieldConfigurationLocalService _fieldConfigurationLocalService;

}