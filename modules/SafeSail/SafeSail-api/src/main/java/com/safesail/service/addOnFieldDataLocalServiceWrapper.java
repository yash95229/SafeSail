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
 * Provides a wrapper for {@link addOnFieldDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see addOnFieldDataLocalService
 * @generated
 */
public class addOnFieldDataLocalServiceWrapper
	implements addOnFieldDataLocalService,
			   ServiceWrapper<addOnFieldDataLocalService> {

	public addOnFieldDataLocalServiceWrapper() {
		this(null);
	}

	public addOnFieldDataLocalServiceWrapper(
		addOnFieldDataLocalService addOnFieldDataLocalService) {

		_addOnFieldDataLocalService = addOnFieldDataLocalService;
	}

	/**
	 * Adds the add on field data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect addOnFieldDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addOnFieldData the add on field data
	 * @return the add on field data that was added
	 */
	@Override
	public com.safesail.model.addOnFieldData addaddOnFieldData(
		com.safesail.model.addOnFieldData addOnFieldData) {

		return _addOnFieldDataLocalService.addaddOnFieldData(addOnFieldData);
	}

	/**
	 * Creates a new add on field data with the primary key. Does not add the add on field data to the database.
	 *
	 * @param addonId the primary key for the new add on field data
	 * @return the new add on field data
	 */
	@Override
	public com.safesail.model.addOnFieldData createaddOnFieldData(
		long addonId) {

		return _addOnFieldDataLocalService.createaddOnFieldData(addonId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addOnFieldDataLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the add on field data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect addOnFieldDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addOnFieldData the add on field data
	 * @return the add on field data that was removed
	 */
	@Override
	public com.safesail.model.addOnFieldData deleteaddOnFieldData(
		com.safesail.model.addOnFieldData addOnFieldData) {

		return _addOnFieldDataLocalService.deleteaddOnFieldData(addOnFieldData);
	}

	/**
	 * Deletes the add on field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect addOnFieldDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data that was removed
	 * @throws PortalException if a add on field data with the primary key could not be found
	 */
	@Override
	public com.safesail.model.addOnFieldData deleteaddOnFieldData(long addonId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addOnFieldDataLocalService.deleteaddOnFieldData(addonId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addOnFieldDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _addOnFieldDataLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _addOnFieldDataLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addOnFieldDataLocalService.dynamicQuery();
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

		return _addOnFieldDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.addOnFieldDataModelImpl</code>.
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

		return _addOnFieldDataLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.addOnFieldDataModelImpl</code>.
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

		return _addOnFieldDataLocalService.dynamicQuery(
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

		return _addOnFieldDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _addOnFieldDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.safesail.model.addOnFieldData fetchaddOnFieldData(long addonId) {
		return _addOnFieldDataLocalService.fetchaddOnFieldData(addonId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _addOnFieldDataLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the add on field data with the primary key.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data
	 * @throws PortalException if a add on field data with the primary key could not be found
	 */
	@Override
	public com.safesail.model.addOnFieldData getaddOnFieldData(long addonId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addOnFieldDataLocalService.getaddOnFieldData(addonId);
	}

	/**
	 * Returns a range of all the add on field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.addOnFieldDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of add on field datas
	 * @param end the upper bound of the range of add on field datas (not inclusive)
	 * @return the range of add on field datas
	 */
	@Override
	public java.util.List<com.safesail.model.addOnFieldData> getaddOnFieldDatas(
		int start, int end) {

		return _addOnFieldDataLocalService.getaddOnFieldDatas(start, end);
	}

	/**
	 * Returns the number of add on field datas.
	 *
	 * @return the number of add on field datas
	 */
	@Override
	public int getaddOnFieldDatasCount() {
		return _addOnFieldDataLocalService.getaddOnFieldDatasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _addOnFieldDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _addOnFieldDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addOnFieldDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the add on field data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect addOnFieldDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addOnFieldData the add on field data
	 * @return the add on field data that was updated
	 */
	@Override
	public com.safesail.model.addOnFieldData updateaddOnFieldData(
		com.safesail.model.addOnFieldData addOnFieldData) {

		return _addOnFieldDataLocalService.updateaddOnFieldData(addOnFieldData);
	}

	@Override
	public addOnFieldDataLocalService getWrappedService() {
		return _addOnFieldDataLocalService;
	}

	@Override
	public void setWrappedService(
		addOnFieldDataLocalService addOnFieldDataLocalService) {

		_addOnFieldDataLocalService = addOnFieldDataLocalService;
	}

	private addOnFieldDataLocalService _addOnFieldDataLocalService;

}