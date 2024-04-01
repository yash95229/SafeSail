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
 * Provides a wrapper for {@link LifeInsuranceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LifeInsuranceLocalService
 * @generated
 */
public class LifeInsuranceLocalServiceWrapper
	implements LifeInsuranceLocalService,
			   ServiceWrapper<LifeInsuranceLocalService> {

	public LifeInsuranceLocalServiceWrapper() {
		this(null);
	}

	public LifeInsuranceLocalServiceWrapper(
		LifeInsuranceLocalService lifeInsuranceLocalService) {

		_lifeInsuranceLocalService = lifeInsuranceLocalService;
	}

	/**
	 * Adds the life insurance to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LifeInsuranceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lifeInsurance the life insurance
	 * @return the life insurance that was added
	 */
	@Override
	public com.safesail.model.LifeInsurance addLifeInsurance(
		com.safesail.model.LifeInsurance lifeInsurance) {

		return _lifeInsuranceLocalService.addLifeInsurance(lifeInsurance);
	}

	@Override
	public com.safesail.model.LifeInsurance addReg(
		String quoteId, String fullname, String email, long phoneNumber,
		String AnnualIncome, String panNumber, java.util.Date dob,
		String gender, Boolean condition, long sumAssured, long userId,
		String aadharNumber) {

		return _lifeInsuranceLocalService.addReg(
			quoteId, fullname, email, phoneNumber, AnnualIncome, panNumber, dob,
			gender, condition, sumAssured, userId, aadharNumber);
	}

	@Override
	public com.safesail.model.LifeInsurance addReg(
		String quoteId, String fullname, String email, long phoneNumber,
		String AnnualIncome, String panNumber, java.util.Date dob,
		String gender, Boolean condition, long sumAssured, long userId,
		String aadharNumber, int policyTerm, int ppterm,
		String paymentFrequency, String payoutOption, int lifeSecure,
		int lifeplus, int CIPBenifit, long totalValues, long totalAddons) {

		return _lifeInsuranceLocalService.addReg(
			quoteId, fullname, email, phoneNumber, AnnualIncome, panNumber, dob,
			gender, condition, sumAssured, userId, aadharNumber, policyTerm,
			ppterm, paymentFrequency, payoutOption, lifeSecure, lifeplus,
			CIPBenifit, totalValues, totalAddons);
	}

	/**
	 * Creates a new life insurance with the primary key. Does not add the life insurance to the database.
	 *
	 * @param quoteId the primary key for the new life insurance
	 * @return the new life insurance
	 */
	@Override
	public com.safesail.model.LifeInsurance createLifeInsurance(
		String quoteId) {

		return _lifeInsuranceLocalService.createLifeInsurance(quoteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lifeInsuranceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the life insurance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LifeInsuranceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lifeInsurance the life insurance
	 * @return the life insurance that was removed
	 */
	@Override
	public com.safesail.model.LifeInsurance deleteLifeInsurance(
		com.safesail.model.LifeInsurance lifeInsurance) {

		return _lifeInsuranceLocalService.deleteLifeInsurance(lifeInsurance);
	}

	/**
	 * Deletes the life insurance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LifeInsuranceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance that was removed
	 * @throws PortalException if a life insurance with the primary key could not be found
	 */
	@Override
	public com.safesail.model.LifeInsurance deleteLifeInsurance(String quoteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lifeInsuranceLocalService.deleteLifeInsurance(quoteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lifeInsuranceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _lifeInsuranceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _lifeInsuranceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lifeInsuranceLocalService.dynamicQuery();
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

		return _lifeInsuranceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.LifeInsuranceModelImpl</code>.
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

		return _lifeInsuranceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.LifeInsuranceModelImpl</code>.
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

		return _lifeInsuranceLocalService.dynamicQuery(
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

		return _lifeInsuranceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lifeInsuranceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.safesail.model.LifeInsurance fetchLifeInsurance(String quoteId) {
		return _lifeInsuranceLocalService.fetchLifeInsurance(quoteId);
	}

	@Override
	public com.safesail.model.LifeInsurance getAadharNumber(
		String aadharNumber) {

		return _lifeInsuranceLocalService.getAadharNumber(aadharNumber);
	}

	/**
	 * Returns the life insurance with the primary key.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance
	 * @throws PortalException if a life insurance with the primary key could not be found
	 */
	@Override
	public com.safesail.model.LifeInsurance getLifeInsurance(String quoteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lifeInsuranceLocalService.getLifeInsurance(quoteId);
	}

	/**
	 * Returns a range of all the life insurances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of life insurances
	 */
	@Override
	public java.util.List<com.safesail.model.LifeInsurance> getLifeInsurances(
		int start, int end) {

		return _lifeInsuranceLocalService.getLifeInsurances(start, end);
	}

	/**
	 * Returns the number of life insurances.
	 *
	 * @return the number of life insurances
	 */
	@Override
	public int getLifeInsurancesCount() {
		return _lifeInsuranceLocalService.getLifeInsurancesCount();
	}

	@Override
	public java.util.List getList(String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _lifeInsuranceLocalService.getList(emailAddress);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lifeInsuranceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lifeInsuranceLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.safesail.model.LifeInsurance getQuoteId(String quoteId) {
		return _lifeInsuranceLocalService.getQuoteId(quoteId);
	}

	@Override
	public com.safesail.model.LifeInsurance getUser(long userId) {
		return _lifeInsuranceLocalService.getUser(userId);
	}

	/**
	 * Updates the life insurance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LifeInsuranceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lifeInsurance the life insurance
	 * @return the life insurance that was updated
	 */
	@Override
	public com.safesail.model.LifeInsurance updateLifeInsurance(
		com.safesail.model.LifeInsurance lifeInsurance) {

		return _lifeInsuranceLocalService.updateLifeInsurance(lifeInsurance);
	}

	@Override
	public LifeInsuranceLocalService getWrappedService() {
		return _lifeInsuranceLocalService;
	}

	@Override
	public void setWrappedService(
		LifeInsuranceLocalService lifeInsuranceLocalService) {

		_lifeInsuranceLocalService = lifeInsuranceLocalService;
	}

	private LifeInsuranceLocalService _lifeInsuranceLocalService;

}