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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.safesail.model.LifeInsurance;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for LifeInsurance. This utility wraps
 * <code>com.safesail.service.impl.LifeInsuranceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LifeInsuranceLocalService
 * @generated
 */
public class LifeInsuranceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.safesail.service.impl.LifeInsuranceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static LifeInsurance addLifeInsurance(LifeInsurance lifeInsurance) {
		return getService().addLifeInsurance(lifeInsurance);
	}

	public static LifeInsurance addReg(
		String quoteId, String fullname, String email, long phoneNumber,
		String AnnualIncome, String panNumber, java.util.Date dob,
		String gender, Boolean condition, long sumAssured, long userId,
		String aadharNumber) {

		return getService().addReg(
			quoteId, fullname, email, phoneNumber, AnnualIncome, panNumber, dob,
			gender, condition, sumAssured, userId, aadharNumber);
	}

	public static LifeInsurance addReg(
		String quoteId, String fullname, String email, long phoneNumber,
		String AnnualIncome, String panNumber, java.util.Date dob,
		String gender, Boolean condition, long sumAssured, long userId,
		String aadharNumber, int policyTerm, int ppterm,
		String paymentFrequency, String payoutOption, int lifeSecure,
		int lifeplus, int CIPBenifit, long totalValues, long totalAddons) {

		return getService().addReg(
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
	public static LifeInsurance createLifeInsurance(String quoteId) {
		return getService().createLifeInsurance(quoteId);
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
	 * Deletes the life insurance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LifeInsuranceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lifeInsurance the life insurance
	 * @return the life insurance that was removed
	 */
	public static LifeInsurance deleteLifeInsurance(
		LifeInsurance lifeInsurance) {

		return getService().deleteLifeInsurance(lifeInsurance);
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
	public static LifeInsurance deleteLifeInsurance(String quoteId)
		throws PortalException {

		return getService().deleteLifeInsurance(quoteId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.LifeInsuranceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.LifeInsuranceModelImpl</code>.
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

	public static LifeInsurance fetchLifeInsurance(String quoteId) {
		return getService().fetchLifeInsurance(quoteId);
	}

	public static LifeInsurance getAadharNumber(String aadharNumber) {
		return getService().getAadharNumber(aadharNumber);
	}

	/**
	 * Returns the life insurance with the primary key.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance
	 * @throws PortalException if a life insurance with the primary key could not be found
	 */
	public static LifeInsurance getLifeInsurance(String quoteId)
		throws PortalException {

		return getService().getLifeInsurance(quoteId);
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
	public static List<LifeInsurance> getLifeInsurances(int start, int end) {
		return getService().getLifeInsurances(start, end);
	}

	/**
	 * Returns the number of life insurances.
	 *
	 * @return the number of life insurances
	 */
	public static int getLifeInsurancesCount() {
		return getService().getLifeInsurancesCount();
	}

	public static List getList(String emailAddress) throws SystemException {
		return getService().getList(emailAddress);
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

	public static LifeInsurance getQuoteId(String quoteId) {
		return getService().getQuoteId(quoteId);
	}

	public static LifeInsurance getUser(long userId) {
		return getService().getUser(userId);
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
	public static LifeInsurance updateLifeInsurance(
		LifeInsurance lifeInsurance) {

		return getService().updateLifeInsurance(lifeInsurance);
	}

	public static LifeInsuranceLocalService getService() {
		return _service;
	}

	private static volatile LifeInsuranceLocalService _service;

}