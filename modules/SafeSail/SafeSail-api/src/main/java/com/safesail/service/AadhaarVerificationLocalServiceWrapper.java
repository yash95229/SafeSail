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
 * Provides a wrapper for {@link AadhaarVerificationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AadhaarVerificationLocalService
 * @generated
 */
public class AadhaarVerificationLocalServiceWrapper
	implements AadhaarVerificationLocalService,
			   ServiceWrapper<AadhaarVerificationLocalService> {

	public AadhaarVerificationLocalServiceWrapper() {
		this(null);
	}

	public AadhaarVerificationLocalServiceWrapper(
		AadhaarVerificationLocalService aadhaarVerificationLocalService) {

		_aadhaarVerificationLocalService = aadhaarVerificationLocalService;
	}

	@Override
	public com.safesail.model.AadhaarVerification addAadhaar(
		long aadhaarId, String aadhaarUserName, String aadhaarNumber) {

		return _aadhaarVerificationLocalService.addAadhaar(
			aadhaarId, aadhaarUserName, aadhaarNumber);
	}

	/**
	 * Adds the aadhaar verification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AadhaarVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param aadhaarVerification the aadhaar verification
	 * @return the aadhaar verification that was added
	 */
	@Override
	public com.safesail.model.AadhaarVerification addAadhaarVerification(
		com.safesail.model.AadhaarVerification aadhaarVerification) {

		return _aadhaarVerificationLocalService.addAadhaarVerification(
			aadhaarVerification);
	}

	/**
	 * Creates a new aadhaar verification with the primary key. Does not add the aadhaar verification to the database.
	 *
	 * @param aadhaarId the primary key for the new aadhaar verification
	 * @return the new aadhaar verification
	 */
	@Override
	public com.safesail.model.AadhaarVerification createAadhaarVerification(
		long aadhaarId) {

		return _aadhaarVerificationLocalService.createAadhaarVerification(
			aadhaarId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _aadhaarVerificationLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the aadhaar verification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AadhaarVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param aadhaarVerification the aadhaar verification
	 * @return the aadhaar verification that was removed
	 */
	@Override
	public com.safesail.model.AadhaarVerification deleteAadhaarVerification(
		com.safesail.model.AadhaarVerification aadhaarVerification) {

		return _aadhaarVerificationLocalService.deleteAadhaarVerification(
			aadhaarVerification);
	}

	/**
	 * Deletes the aadhaar verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AadhaarVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification that was removed
	 * @throws PortalException if a aadhaar verification with the primary key could not be found
	 */
	@Override
	public com.safesail.model.AadhaarVerification deleteAadhaarVerification(
			long aadhaarId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _aadhaarVerificationLocalService.deleteAadhaarVerification(
			aadhaarId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _aadhaarVerificationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _aadhaarVerificationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _aadhaarVerificationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _aadhaarVerificationLocalService.dynamicQuery();
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

		return _aadhaarVerificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.AadhaarVerificationModelImpl</code>.
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

		return _aadhaarVerificationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.AadhaarVerificationModelImpl</code>.
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

		return _aadhaarVerificationLocalService.dynamicQuery(
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

		return _aadhaarVerificationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _aadhaarVerificationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.safesail.model.AadhaarVerification fetchAadhaarVerification(
		long aadhaarId) {

		return _aadhaarVerificationLocalService.fetchAadhaarVerification(
			aadhaarId);
	}

	/**
	 * Returns the aadhaar verification with the primary key.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification
	 * @throws PortalException if a aadhaar verification with the primary key could not be found
	 */
	@Override
	public com.safesail.model.AadhaarVerification getAadhaarVerification(
			long aadhaarId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _aadhaarVerificationLocalService.getAadhaarVerification(
			aadhaarId);
	}

	/**
	 * Returns a range of all the aadhaar verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.AadhaarVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of aadhaar verifications
	 * @param end the upper bound of the range of aadhaar verifications (not inclusive)
	 * @return the range of aadhaar verifications
	 */
	@Override
	public java.util.List<com.safesail.model.AadhaarVerification>
		getAadhaarVerifications(int start, int end) {

		return _aadhaarVerificationLocalService.getAadhaarVerifications(
			start, end);
	}

	/**
	 * Returns the number of aadhaar verifications.
	 *
	 * @return the number of aadhaar verifications
	 */
	@Override
	public int getAadhaarVerificationsCount() {
		return _aadhaarVerificationLocalService.getAadhaarVerificationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _aadhaarVerificationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _aadhaarVerificationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _aadhaarVerificationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _aadhaarVerificationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public String getUserByAadhaarNumber(String aadhaar) {
		return _aadhaarVerificationLocalService.getUserByAadhaarNumber(aadhaar);
	}

	/**
	 * Updates the aadhaar verification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AadhaarVerificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param aadhaarVerification the aadhaar verification
	 * @return the aadhaar verification that was updated
	 */
	@Override
	public com.safesail.model.AadhaarVerification updateAadhaarVerification(
		com.safesail.model.AadhaarVerification aadhaarVerification) {

		return _aadhaarVerificationLocalService.updateAadhaarVerification(
			aadhaarVerification);
	}

	@Override
	public AadhaarVerificationLocalService getWrappedService() {
		return _aadhaarVerificationLocalService;
	}

	@Override
	public void setWrappedService(
		AadhaarVerificationLocalService aadhaarVerificationLocalService) {

		_aadhaarVerificationLocalService = aadhaarVerificationLocalService;
	}

	private AadhaarVerificationLocalService _aadhaarVerificationLocalService;

}