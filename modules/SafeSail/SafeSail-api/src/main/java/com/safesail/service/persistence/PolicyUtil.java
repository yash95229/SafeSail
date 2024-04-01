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

import com.safesail.model.Policy;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the policy service. This utility wraps <code>com.safesail.service.persistence.impl.PolicyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyPersistence
 * @generated
 */
public class PolicyUtil {

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
	public static void clearCache(Policy policy) {
		getPersistence().clearCache(policy);
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
	public static Map<Serializable, Policy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Policy> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Policy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Policy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Policy update(Policy policy) {
		return getPersistence().update(policy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Policy update(Policy policy, ServiceContext serviceContext) {
		return getPersistence().update(policy, serviceContext);
	}

	/**
	 * Returns all the policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching policies
	 */
	public static List<Policy> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the policies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of matching policies
	 */
	public static List<Policy> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the policies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policies
	 */
	public static List<Policy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policies
	 */
	public static List<Policy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Policy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByUuid_First(
			String uuid, OrderByComparator<Policy> orderByComparator)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByUuid_First(
		String uuid, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByUuid_Last(
			String uuid, OrderByComparator<Policy> orderByComparator)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByUuid_Last(
		String uuid, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the policies before and after the current policy in the ordered set where uuid = &#63;.
	 *
	 * @param policyPK the primary key of the current policy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public static Policy[] findByUuid_PrevAndNext(
			PolicyPK policyPK, String uuid,
			OrderByComparator<Policy> orderByComparator)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByUuid_PrevAndNext(
			policyPK, uuid, orderByComparator);
	}

	/**
	 * Removes all the policies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching policies
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the policy where quoteId = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByquoteId(String quoteId)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByquoteId(quoteId);
	}

	/**
	 * Returns the policy where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByquoteId(String quoteId) {
		return getPersistence().fetchByquoteId(quoteId);
	}

	/**
	 * Returns the policy where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByquoteId(
		String quoteId, boolean useFinderCache) {

		return getPersistence().fetchByquoteId(quoteId, useFinderCache);
	}

	/**
	 * Removes the policy where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the policy that was removed
	 */
	public static Policy removeByquoteId(String quoteId)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().removeByquoteId(quoteId);
	}

	/**
	 * Returns the number of policies where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching policies
	 */
	public static int countByquoteId(String quoteId) {
		return getPersistence().countByquoteId(quoteId);
	}

	/**
	 * Returns the policy where applicationNumber = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByapplicationNumber(long applicationNumber)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByapplicationNumber(applicationNumber);
	}

	/**
	 * Returns the policy where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByapplicationNumber(long applicationNumber) {
		return getPersistence().fetchByapplicationNumber(applicationNumber);
	}

	/**
	 * Returns the policy where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByapplicationNumber(
		long applicationNumber, boolean useFinderCache) {

		return getPersistence().fetchByapplicationNumber(
			applicationNumber, useFinderCache);
	}

	/**
	 * Removes the policy where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the policy that was removed
	 */
	public static Policy removeByapplicationNumber(long applicationNumber)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().removeByapplicationNumber(applicationNumber);
	}

	/**
	 * Returns the number of policies where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching policies
	 */
	public static int countByapplicationNumber(long applicationNumber) {
		return getPersistence().countByapplicationNumber(applicationNumber);
	}

	/**
	 * Returns all the policies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching policies
	 */
	public static List<Policy> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the policies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of matching policies
	 */
	public static List<Policy> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the policies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching policies
	 */
	public static List<Policy> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policies where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching policies
	 */
	public static List<Policy> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Policy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByuserId_First(
			long userId, OrderByComparator<Policy> orderByComparator)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByuserId_First(
		long userId, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public static Policy findByuserId_Last(
			long userId, OrderByComparator<Policy> orderByComparator)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public static Policy fetchByuserId_Last(
		long userId, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the policies before and after the current policy in the ordered set where userId = &#63;.
	 *
	 * @param policyPK the primary key of the current policy
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public static Policy[] findByuserId_PrevAndNext(
			PolicyPK policyPK, long userId,
			OrderByComparator<Policy> orderByComparator)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByuserId_PrevAndNext(
			policyPK, userId, orderByComparator);
	}

	/**
	 * Removes all the policies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of policies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching policies
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the policy in the entity cache if it is enabled.
	 *
	 * @param policy the policy
	 */
	public static void cacheResult(Policy policy) {
		getPersistence().cacheResult(policy);
	}

	/**
	 * Caches the policies in the entity cache if it is enabled.
	 *
	 * @param policies the policies
	 */
	public static void cacheResult(List<Policy> policies) {
		getPersistence().cacheResult(policies);
	}

	/**
	 * Creates a new policy with the primary key. Does not add the policy to the database.
	 *
	 * @param policyPK the primary key for the new policy
	 * @return the new policy
	 */
	public static Policy create(PolicyPK policyPK) {
		return getPersistence().create(policyPK);
	}

	/**
	 * Removes the policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy that was removed
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public static Policy remove(PolicyPK policyPK)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().remove(policyPK);
	}

	public static Policy updateImpl(Policy policy) {
		return getPersistence().updateImpl(policy);
	}

	/**
	 * Returns the policy with the primary key or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public static Policy findByPrimaryKey(PolicyPK policyPK)
		throws com.safesail.exception.NoSuchPolicyException {

		return getPersistence().findByPrimaryKey(policyPK);
	}

	/**
	 * Returns the policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy, or <code>null</code> if a policy with the primary key could not be found
	 */
	public static Policy fetchByPrimaryKey(PolicyPK policyPK) {
		return getPersistence().fetchByPrimaryKey(policyPK);
	}

	/**
	 * Returns all the policies.
	 *
	 * @return the policies
	 */
	public static List<Policy> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of policies
	 */
	public static List<Policy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policies
	 */
	public static List<Policy> findAll(
		int start, int end, OrderByComparator<Policy> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policies
	 */
	public static List<Policy> findAll(
		int start, int end, OrderByComparator<Policy> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the policies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of policies.
	 *
	 * @return the number of policies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PolicyPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PolicyPersistence _persistence;

}