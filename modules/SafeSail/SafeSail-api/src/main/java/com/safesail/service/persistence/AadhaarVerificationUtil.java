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

import com.safesail.model.AadhaarVerification;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the aadhaar verification service. This utility wraps <code>com.safesail.service.persistence.impl.AadhaarVerificationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AadhaarVerificationPersistence
 * @generated
 */
public class AadhaarVerificationUtil {

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
	public static void clearCache(AadhaarVerification aadhaarVerification) {
		getPersistence().clearCache(aadhaarVerification);
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
	public static Map<Serializable, AadhaarVerification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AadhaarVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AadhaarVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AadhaarVerification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AadhaarVerification update(
		AadhaarVerification aadhaarVerification) {

		return getPersistence().update(aadhaarVerification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AadhaarVerification update(
		AadhaarVerification aadhaarVerification,
		ServiceContext serviceContext) {

		return getPersistence().update(aadhaarVerification, serviceContext);
	}

	/**
	 * Returns all the aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @return the matching aadhaar verifications
	 */
	public static List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber) {

		return getPersistence().findByaadhaarNumber(aadhaarNumber);
	}

	/**
	 * Returns a range of all the aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AadhaarVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param start the lower bound of the range of aadhaar verifications
	 * @param end the upper bound of the range of aadhaar verifications (not inclusive)
	 * @return the range of matching aadhaar verifications
	 */
	public static List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end) {

		return getPersistence().findByaadhaarNumber(aadhaarNumber, start, end);
	}

	/**
	 * Returns an ordered range of all the aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AadhaarVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param start the lower bound of the range of aadhaar verifications
	 * @param end the upper bound of the range of aadhaar verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching aadhaar verifications
	 */
	public static List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		return getPersistence().findByaadhaarNumber(
			aadhaarNumber, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AadhaarVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param start the lower bound of the range of aadhaar verifications
	 * @param end the upper bound of the range of aadhaar verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching aadhaar verifications
	 */
	public static List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByaadhaarNumber(
			aadhaarNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a matching aadhaar verification could not be found
	 */
	public static AadhaarVerification findByaadhaarNumber_First(
			String aadhaarNumber,
			OrderByComparator<AadhaarVerification> orderByComparator)
		throws com.safesail.exception.NoSuchAadhaarVerificationException {

		return getPersistence().findByaadhaarNumber_First(
			aadhaarNumber, orderByComparator);
	}

	/**
	 * Returns the first aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching aadhaar verification, or <code>null</code> if a matching aadhaar verification could not be found
	 */
	public static AadhaarVerification fetchByaadhaarNumber_First(
		String aadhaarNumber,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		return getPersistence().fetchByaadhaarNumber_First(
			aadhaarNumber, orderByComparator);
	}

	/**
	 * Returns the last aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a matching aadhaar verification could not be found
	 */
	public static AadhaarVerification findByaadhaarNumber_Last(
			String aadhaarNumber,
			OrderByComparator<AadhaarVerification> orderByComparator)
		throws com.safesail.exception.NoSuchAadhaarVerificationException {

		return getPersistence().findByaadhaarNumber_Last(
			aadhaarNumber, orderByComparator);
	}

	/**
	 * Returns the last aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching aadhaar verification, or <code>null</code> if a matching aadhaar verification could not be found
	 */
	public static AadhaarVerification fetchByaadhaarNumber_Last(
		String aadhaarNumber,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		return getPersistence().fetchByaadhaarNumber_Last(
			aadhaarNumber, orderByComparator);
	}

	/**
	 * Returns the aadhaar verifications before and after the current aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarId the primary key of the current aadhaar verification
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	public static AadhaarVerification[] findByaadhaarNumber_PrevAndNext(
			long aadhaarId, String aadhaarNumber,
			OrderByComparator<AadhaarVerification> orderByComparator)
		throws com.safesail.exception.NoSuchAadhaarVerificationException {

		return getPersistence().findByaadhaarNumber_PrevAndNext(
			aadhaarId, aadhaarNumber, orderByComparator);
	}

	/**
	 * Removes all the aadhaar verifications where aadhaarNumber = &#63; from the database.
	 *
	 * @param aadhaarNumber the aadhaar number
	 */
	public static void removeByaadhaarNumber(String aadhaarNumber) {
		getPersistence().removeByaadhaarNumber(aadhaarNumber);
	}

	/**
	 * Returns the number of aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @return the number of matching aadhaar verifications
	 */
	public static int countByaadhaarNumber(String aadhaarNumber) {
		return getPersistence().countByaadhaarNumber(aadhaarNumber);
	}

	/**
	 * Caches the aadhaar verification in the entity cache if it is enabled.
	 *
	 * @param aadhaarVerification the aadhaar verification
	 */
	public static void cacheResult(AadhaarVerification aadhaarVerification) {
		getPersistence().cacheResult(aadhaarVerification);
	}

	/**
	 * Caches the aadhaar verifications in the entity cache if it is enabled.
	 *
	 * @param aadhaarVerifications the aadhaar verifications
	 */
	public static void cacheResult(
		List<AadhaarVerification> aadhaarVerifications) {

		getPersistence().cacheResult(aadhaarVerifications);
	}

	/**
	 * Creates a new aadhaar verification with the primary key. Does not add the aadhaar verification to the database.
	 *
	 * @param aadhaarId the primary key for the new aadhaar verification
	 * @return the new aadhaar verification
	 */
	public static AadhaarVerification create(long aadhaarId) {
		return getPersistence().create(aadhaarId);
	}

	/**
	 * Removes the aadhaar verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification that was removed
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	public static AadhaarVerification remove(long aadhaarId)
		throws com.safesail.exception.NoSuchAadhaarVerificationException {

		return getPersistence().remove(aadhaarId);
	}

	public static AadhaarVerification updateImpl(
		AadhaarVerification aadhaarVerification) {

		return getPersistence().updateImpl(aadhaarVerification);
	}

	/**
	 * Returns the aadhaar verification with the primary key or throws a <code>NoSuchAadhaarVerificationException</code> if it could not be found.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	public static AadhaarVerification findByPrimaryKey(long aadhaarId)
		throws com.safesail.exception.NoSuchAadhaarVerificationException {

		return getPersistence().findByPrimaryKey(aadhaarId);
	}

	/**
	 * Returns the aadhaar verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification, or <code>null</code> if a aadhaar verification with the primary key could not be found
	 */
	public static AadhaarVerification fetchByPrimaryKey(long aadhaarId) {
		return getPersistence().fetchByPrimaryKey(aadhaarId);
	}

	/**
	 * Returns all the aadhaar verifications.
	 *
	 * @return the aadhaar verifications
	 */
	public static List<AadhaarVerification> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the aadhaar verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AadhaarVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of aadhaar verifications
	 * @param end the upper bound of the range of aadhaar verifications (not inclusive)
	 * @return the range of aadhaar verifications
	 */
	public static List<AadhaarVerification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the aadhaar verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AadhaarVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of aadhaar verifications
	 * @param end the upper bound of the range of aadhaar verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of aadhaar verifications
	 */
	public static List<AadhaarVerification> findAll(
		int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the aadhaar verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AadhaarVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of aadhaar verifications
	 * @param end the upper bound of the range of aadhaar verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of aadhaar verifications
	 */
	public static List<AadhaarVerification> findAll(
		int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the aadhaar verifications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of aadhaar verifications.
	 *
	 * @return the number of aadhaar verifications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AadhaarVerificationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AadhaarVerificationPersistence _persistence;

}