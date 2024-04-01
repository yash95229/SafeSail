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

import com.safesail.model.LifeInsurance;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the life insurance service. This utility wraps <code>com.safesail.service.persistence.impl.LifeInsurancePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LifeInsurancePersistence
 * @generated
 */
public class LifeInsuranceUtil {

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
	public static void clearCache(LifeInsurance lifeInsurance) {
		getPersistence().clearCache(lifeInsurance);
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
	public static Map<Serializable, LifeInsurance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LifeInsurance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LifeInsurance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LifeInsurance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LifeInsurance update(LifeInsurance lifeInsurance) {
		return getPersistence().update(lifeInsurance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LifeInsurance update(
		LifeInsurance lifeInsurance, ServiceContext serviceContext) {

		return getPersistence().update(lifeInsurance, serviceContext);
	}

	/**
	 * Returns all the life insurances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching life insurances
	 */
	public static List<LifeInsurance> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the life insurances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of matching life insurances
	 */
	public static List<LifeInsurance> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the life insurances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching life insurances
	 */
	public static List<LifeInsurance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the life insurances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching life insurances
	 */
	public static List<LifeInsurance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByUuid_First(
			String uuid, OrderByComparator<LifeInsurance> orderByComparator)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByUuid_First(
		String uuid, OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByUuid_Last(
			String uuid, OrderByComparator<LifeInsurance> orderByComparator)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByUuid_Last(
		String uuid, OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the life insurances before and after the current life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param quoteId the primary key of the current life insurance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next life insurance
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	public static LifeInsurance[] findByUuid_PrevAndNext(
			String quoteId, String uuid,
			OrderByComparator<LifeInsurance> orderByComparator)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByUuid_PrevAndNext(
			quoteId, uuid, orderByComparator);
	}

	/**
	 * Removes all the life insurances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of life insurances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching life insurances
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the life insurance where userId = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByuserId(long userId)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns the life insurance where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByuserId(long userId) {
		return getPersistence().fetchByuserId(userId);
	}

	/**
	 * Returns the life insurance where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByuserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByuserId(userId, useFinderCache);
	}

	/**
	 * Removes the life insurance where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the life insurance that was removed
	 */
	public static LifeInsurance removeByuserId(long userId)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of life insurances where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching life insurances
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns the life insurance where quoteId = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByquoteId(String quoteId)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByquoteId(quoteId);
	}

	/**
	 * Returns the life insurance where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByquoteId(String quoteId) {
		return getPersistence().fetchByquoteId(quoteId);
	}

	/**
	 * Returns the life insurance where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByquoteId(
		String quoteId, boolean useFinderCache) {

		return getPersistence().fetchByquoteId(quoteId, useFinderCache);
	}

	/**
	 * Removes the life insurance where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the life insurance that was removed
	 */
	public static LifeInsurance removeByquoteId(String quoteId)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().removeByquoteId(quoteId);
	}

	/**
	 * Returns the number of life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching life insurances
	 */
	public static int countByquoteId(String quoteId) {
		return getPersistence().countByquoteId(quoteId);
	}

	/**
	 * Returns all the life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurances
	 */
	public static List<LifeInsurance> findByquoteIds(String quoteId) {
		return getPersistence().findByquoteIds(quoteId);
	}

	/**
	 * Returns a range of all the life insurances where quoteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param quoteId the quote ID
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of matching life insurances
	 */
	public static List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end) {

		return getPersistence().findByquoteIds(quoteId, start, end);
	}

	/**
	 * Returns an ordered range of all the life insurances where quoteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param quoteId the quote ID
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching life insurances
	 */
	public static List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().findByquoteIds(
			quoteId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the life insurances where quoteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param quoteId the quote ID
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching life insurances
	 */
	public static List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByquoteIds(
			quoteId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByquoteIds_First(
			String quoteId, OrderByComparator<LifeInsurance> orderByComparator)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByquoteIds_First(
			quoteId, orderByComparator);
	}

	/**
	 * Returns the first life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByquoteIds_First(
		String quoteId, OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().fetchByquoteIds_First(
			quoteId, orderByComparator);
	}

	/**
	 * Returns the last life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByquoteIds_Last(
			String quoteId, OrderByComparator<LifeInsurance> orderByComparator)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByquoteIds_Last(quoteId, orderByComparator);
	}

	/**
	 * Returns the last life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByquoteIds_Last(
		String quoteId, OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().fetchByquoteIds_Last(
			quoteId, orderByComparator);
	}

	/**
	 * Removes all the life insurances where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 */
	public static void removeByquoteIds(String quoteId) {
		getPersistence().removeByquoteIds(quoteId);
	}

	/**
	 * Returns the number of life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching life insurances
	 */
	public static int countByquoteIds(String quoteId) {
		return getPersistence().countByquoteIds(quoteId);
	}

	/**
	 * Returns the life insurance where aadharNumber = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByaadharNumber(String aadharNumber)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByaadharNumber(aadharNumber);
	}

	/**
	 * Returns the life insurance where aadharNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByaadharNumber(String aadharNumber) {
		return getPersistence().fetchByaadharNumber(aadharNumber);
	}

	/**
	 * Returns the life insurance where aadharNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param aadharNumber the aadhar number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByaadharNumber(
		String aadharNumber, boolean useFinderCache) {

		return getPersistence().fetchByaadharNumber(
			aadharNumber, useFinderCache);
	}

	/**
	 * Removes the life insurance where aadharNumber = &#63; from the database.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the life insurance that was removed
	 */
	public static LifeInsurance removeByaadharNumber(String aadharNumber)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().removeByaadharNumber(aadharNumber);
	}

	/**
	 * Returns the number of life insurances where aadharNumber = &#63;.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the number of matching life insurances
	 */
	public static int countByaadharNumber(String aadharNumber) {
		return getPersistence().countByaadharNumber(aadharNumber);
	}

	/**
	 * Returns all the life insurances where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching life insurances
	 */
	public static List<LifeInsurance> findByemailAddress(String emailAddress) {
		return getPersistence().findByemailAddress(emailAddress);
	}

	/**
	 * Returns a range of all the life insurances where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of matching life insurances
	 */
	public static List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end) {

		return getPersistence().findByemailAddress(emailAddress, start, end);
	}

	/**
	 * Returns an ordered range of all the life insurances where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching life insurances
	 */
	public static List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().findByemailAddress(
			emailAddress, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the life insurances where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching life insurances
	 */
	public static List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByemailAddress(
			emailAddress, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByemailAddress_First(
			String emailAddress,
			OrderByComparator<LifeInsurance> orderByComparator)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByemailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the first life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByemailAddress_First(
		String emailAddress,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().fetchByemailAddress_First(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public static LifeInsurance findByemailAddress_Last(
			String emailAddress,
			OrderByComparator<LifeInsurance> orderByComparator)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByemailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the last life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public static LifeInsurance fetchByemailAddress_Last(
		String emailAddress,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().fetchByemailAddress_Last(
			emailAddress, orderByComparator);
	}

	/**
	 * Returns the life insurances before and after the current life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param quoteId the primary key of the current life insurance
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next life insurance
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	public static LifeInsurance[] findByemailAddress_PrevAndNext(
			String quoteId, String emailAddress,
			OrderByComparator<LifeInsurance> orderByComparator)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByemailAddress_PrevAndNext(
			quoteId, emailAddress, orderByComparator);
	}

	/**
	 * Removes all the life insurances where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public static void removeByemailAddress(String emailAddress) {
		getPersistence().removeByemailAddress(emailAddress);
	}

	/**
	 * Returns the number of life insurances where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching life insurances
	 */
	public static int countByemailAddress(String emailAddress) {
		return getPersistence().countByemailAddress(emailAddress);
	}

	/**
	 * Caches the life insurance in the entity cache if it is enabled.
	 *
	 * @param lifeInsurance the life insurance
	 */
	public static void cacheResult(LifeInsurance lifeInsurance) {
		getPersistence().cacheResult(lifeInsurance);
	}

	/**
	 * Caches the life insurances in the entity cache if it is enabled.
	 *
	 * @param lifeInsurances the life insurances
	 */
	public static void cacheResult(List<LifeInsurance> lifeInsurances) {
		getPersistence().cacheResult(lifeInsurances);
	}

	/**
	 * Creates a new life insurance with the primary key. Does not add the life insurance to the database.
	 *
	 * @param quoteId the primary key for the new life insurance
	 * @return the new life insurance
	 */
	public static LifeInsurance create(String quoteId) {
		return getPersistence().create(quoteId);
	}

	/**
	 * Removes the life insurance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance that was removed
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	public static LifeInsurance remove(String quoteId)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().remove(quoteId);
	}

	public static LifeInsurance updateImpl(LifeInsurance lifeInsurance) {
		return getPersistence().updateImpl(lifeInsurance);
	}

	/**
	 * Returns the life insurance with the primary key or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	public static LifeInsurance findByPrimaryKey(String quoteId)
		throws com.safesail.exception.NoSuchLifeInsuranceException {

		return getPersistence().findByPrimaryKey(quoteId);
	}

	/**
	 * Returns the life insurance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance, or <code>null</code> if a life insurance with the primary key could not be found
	 */
	public static LifeInsurance fetchByPrimaryKey(String quoteId) {
		return getPersistence().fetchByPrimaryKey(quoteId);
	}

	/**
	 * Returns all the life insurances.
	 *
	 * @return the life insurances
	 */
	public static List<LifeInsurance> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the life insurances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of life insurances
	 */
	public static List<LifeInsurance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the life insurances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of life insurances
	 */
	public static List<LifeInsurance> findAll(
		int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the life insurances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of life insurances
	 */
	public static List<LifeInsurance> findAll(
		int start, int end, OrderByComparator<LifeInsurance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the life insurances from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of life insurances.
	 *
	 * @return the number of life insurances
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LifeInsurancePersistence getPersistence() {
		return _persistence;
	}

	private static volatile LifeInsurancePersistence _persistence;

}