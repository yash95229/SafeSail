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

import com.safesail.model.PanCardVerification;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the pan card verification service. This utility wraps <code>com.safesail.service.persistence.impl.PanCardVerificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PanCardVerificationPersistence
 * @generated
 */
public class PanCardVerificationUtil {

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
	public static void clearCache(PanCardVerification panCardVerification) {
		getPersistence().clearCache(panCardVerification);
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
	public static Map<Serializable, PanCardVerification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PanCardVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PanCardVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PanCardVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PanCardVerification update(
		PanCardVerification panCardVerification) {

		return getPersistence().update(panCardVerification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PanCardVerification update(
		PanCardVerification panCardVerification,
		ServiceContext serviceContext) {

		return getPersistence().update(panCardVerification, serviceContext);
	}

	/**
	 * Returns all the pan card verifications where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @return the matching pan card verifications
	 */
	public static List<PanCardVerification> findBypanNumber(String panNumber) {
		return getPersistence().findBypanNumber(panNumber);
	}

	/**
	 * Returns a range of all the pan card verifications where panNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param panNumber the pan number
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @return the range of matching pan card verifications
	 */
	public static List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end) {

		return getPersistence().findBypanNumber(panNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the pan card verifications where panNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param panNumber the pan number
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pan card verifications
	 */
	public static List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator) {

		return getPersistence().findBypanNumber(
			panNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pan card verifications where panNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param panNumber the pan number
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pan card verifications
	 */
	public static List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypanNumber(
			panNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pan card verification
	 * @throws NoSuchPanCardVerificationException if a matching pan card verification could not be found
	 */
	public static PanCardVerification findBypanNumber_First(
			String panNumber,
			OrderByComparator<PanCardVerification> orderByComparator)
		throws com.safesail.exception.NoSuchPanCardVerificationException {

		return getPersistence().findBypanNumber_First(
			panNumber, orderByComparator);
	}

	/**
	 * Returns the first pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pan card verification, or <code>null</code> if a matching pan card verification could not be found
	 */
	public static PanCardVerification fetchBypanNumber_First(
		String panNumber,
		OrderByComparator<PanCardVerification> orderByComparator) {

		return getPersistence().fetchBypanNumber_First(
			panNumber, orderByComparator);
	}

	/**
	 * Returns the last pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pan card verification
	 * @throws NoSuchPanCardVerificationException if a matching pan card verification could not be found
	 */
	public static PanCardVerification findBypanNumber_Last(
			String panNumber,
			OrderByComparator<PanCardVerification> orderByComparator)
		throws com.safesail.exception.NoSuchPanCardVerificationException {

		return getPersistence().findBypanNumber_Last(
			panNumber, orderByComparator);
	}

	/**
	 * Returns the last pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pan card verification, or <code>null</code> if a matching pan card verification could not be found
	 */
	public static PanCardVerification fetchBypanNumber_Last(
		String panNumber,
		OrderByComparator<PanCardVerification> orderByComparator) {

		return getPersistence().fetchBypanNumber_Last(
			panNumber, orderByComparator);
	}

	/**
	 * Returns the pan card verifications before and after the current pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panId the primary key of the current pan card verification
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pan card verification
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	public static PanCardVerification[] findBypanNumber_PrevAndNext(
			long panId, String panNumber,
			OrderByComparator<PanCardVerification> orderByComparator)
		throws com.safesail.exception.NoSuchPanCardVerificationException {

		return getPersistence().findBypanNumber_PrevAndNext(
			panId, panNumber, orderByComparator);
	}

	/**
	 * Removes all the pan card verifications where panNumber = &#63; from the database.
	 *
	 * @param panNumber the pan number
	 */
	public static void removeBypanNumber(String panNumber) {
		getPersistence().removeBypanNumber(panNumber);
	}

	/**
	 * Returns the number of pan card verifications where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @return the number of matching pan card verifications
	 */
	public static int countBypanNumber(String panNumber) {
		return getPersistence().countBypanNumber(panNumber);
	}

	/**
	 * Caches the pan card verification in the entity cache if it is enabled.
	 *
	 * @param panCardVerification the pan card verification
	 */
	public static void cacheResult(PanCardVerification panCardVerification) {
		getPersistence().cacheResult(panCardVerification);
	}

	/**
	 * Caches the pan card verifications in the entity cache if it is enabled.
	 *
	 * @param panCardVerifications the pan card verifications
	 */
	public static void cacheResult(
		List<PanCardVerification> panCardVerifications) {

		getPersistence().cacheResult(panCardVerifications);
	}

	/**
	 * Creates a new pan card verification with the primary key. Does not add the pan card verification to the database.
	 *
	 * @param panId the primary key for the new pan card verification
	 * @return the new pan card verification
	 */
	public static PanCardVerification create(long panId) {
		return getPersistence().create(panId);
	}

	/**
	 * Removes the pan card verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification that was removed
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	public static PanCardVerification remove(long panId)
		throws com.safesail.exception.NoSuchPanCardVerificationException {

		return getPersistence().remove(panId);
	}

	public static PanCardVerification updateImpl(
		PanCardVerification panCardVerification) {

		return getPersistence().updateImpl(panCardVerification);
	}

	/**
	 * Returns the pan card verification with the primary key or throws a <code>NoSuchPanCardVerificationException</code> if it could not be found.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	public static PanCardVerification findByPrimaryKey(long panId)
		throws com.safesail.exception.NoSuchPanCardVerificationException {

		return getPersistence().findByPrimaryKey(panId);
	}

	/**
	 * Returns the pan card verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification, or <code>null</code> if a pan card verification with the primary key could not be found
	 */
	public static PanCardVerification fetchByPrimaryKey(long panId) {
		return getPersistence().fetchByPrimaryKey(panId);
	}

	/**
	 * Returns all the pan card verifications.
	 *
	 * @return the pan card verifications
	 */
	public static List<PanCardVerification> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pan card verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @return the range of pan card verifications
	 */
	public static List<PanCardVerification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pan card verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pan card verifications
	 */
	public static List<PanCardVerification> findAll(
		int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pan card verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pan card verifications
	 */
	public static List<PanCardVerification> findAll(
		int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pan card verifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pan card verifications.
	 *
	 * @return the number of pan card verifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PanCardVerificationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PanCardVerificationPersistence _persistence;

}