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
 * Provides a wrapper for {@link PanCardVerificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PanCardVerificationLocalService
 * @generated
 */
public class PanCardVerificationLocalServiceWrapper
	implements PanCardVerificationLocalService,
			   ServiceWrapper<PanCardVerificationLocalService> {

	public PanCardVerificationLocalServiceWrapper() {
		this(null);
	}

	public PanCardVerificationLocalServiceWrapper(
		PanCardVerificationLocalService panCardVerificationLocalService) {

		_panCardVerificationLocalService = panCardVerificationLocalService;
	}

	@Override
	public com.safesail.model.PanCardVerification addPan(
		long panId, String panUserName, String panNumber) {

		return _panCardVerificationLocalService.addPan(
			panId, panUserName, panNumber);
	}

	/**
	 * Adds the pan card verification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PanCardVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param panCardVerification the pan card verification
	 * @return the pan card verification that was added
	 */
	@Override
	public com.safesail.model.PanCardVerification addPanCardVerification(
		com.safesail.model.PanCardVerification panCardVerification) {

		return _panCardVerificationLocalService.addPanCardVerification(
			panCardVerification);
	}

	/**
	 * Creates a new pan card verification with the primary key. Does not add the pan card verification to the database.
	 *
	 * @param panId the primary key for the new pan card verification
	 * @return the new pan card verification
	 */
	@Override
	public com.safesail.model.PanCardVerification createPanCardVerification(
		long panId) {

		return _panCardVerificationLocalService.createPanCardVerification(
			panId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _panCardVerificationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the pan card verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PanCardVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification that was removed
	 * @throws PortalException if a pan card verification with the primary key could not be found
	 */
	@Override
	public com.safesail.model.PanCardVerification deletePanCardVerification(
			long panId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _panCardVerificationLocalService.deletePanCardVerification(
			panId);
	}

	/**
	 * Deletes the pan card verification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PanCardVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param panCardVerification the pan card verification
	 * @return the pan card verification that was removed
	 */
	@Override
	public com.safesail.model.PanCardVerification deletePanCardVerification(
		com.safesail.model.PanCardVerification panCardVerification) {

		return _panCardVerificationLocalService.deletePanCardVerification(
			panCardVerification);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _panCardVerificationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _panCardVerificationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _panCardVerificationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _panCardVerificationLocalService.dynamicQuery();
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

		return _panCardVerificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.PanCardVerificationModelImpl</code>.
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

		return _panCardVerificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.PanCardVerificationModelImpl</code>.
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

		return _panCardVerificationLocalService.dynamicQuery(
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

		return _panCardVerificationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _panCardVerificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.safesail.model.PanCardVerification fetchPanCardVerification(
		long panId) {

		return _panCardVerificationLocalService.fetchPanCardVerification(panId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _panCardVerificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _panCardVerificationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _panCardVerificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pan card verification with the primary key.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification
	 * @throws PortalException if a pan card verification with the primary key could not be found
	 */
	@Override
	public com.safesail.model.PanCardVerification getPanCardVerification(
			long panId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _panCardVerificationLocalService.getPanCardVerification(panId);
	}

	/**
	 * Returns a range of all the pan card verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @return the range of pan card verifications
	 */
	@Override
	public java.util.List<com.safesail.model.PanCardVerification>
		getPanCardVerifications(int start, int end) {

		return _panCardVerificationLocalService.getPanCardVerifications(
			start, end);
	}

	/**
	 * Returns the number of pan card verifications.
	 *
	 * @return the number of pan card verifications
	 */
	@Override
	public int getPanCardVerificationsCount() {
		return _panCardVerificationLocalService.getPanCardVerificationsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _panCardVerificationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public String getUserByPanNumber(String PAN) {
		return _panCardVerificationLocalService.getUserByPanNumber(PAN);
	}

	/**
	 * Updates the pan card verification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PanCardVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param panCardVerification the pan card verification
	 * @return the pan card verification that was updated
	 */
	@Override
	public com.safesail.model.PanCardVerification updatePanCardVerification(
		com.safesail.model.PanCardVerification panCardVerification) {

		return _panCardVerificationLocalService.updatePanCardVerification(
			panCardVerification);
	}

	@Override
	public PanCardVerificationLocalService getWrappedService() {
		return _panCardVerificationLocalService;
	}

	@Override
	public void setWrappedService(
		PanCardVerificationLocalService panCardVerificationLocalService) {

		_panCardVerificationLocalService = panCardVerificationLocalService;
	}

	private PanCardVerificationLocalService _panCardVerificationLocalService;

}