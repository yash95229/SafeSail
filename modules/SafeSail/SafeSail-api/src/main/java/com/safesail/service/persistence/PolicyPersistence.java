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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.safesail.exception.NoSuchPolicyException;
import com.safesail.model.Policy;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the policy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyUtil
 * @generated
 */
@ProviderType
public interface PolicyPersistence extends BasePersistence<Policy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PolicyUtil} to access the policy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching policies
	 */
	public java.util.List<Policy> findByUuid(String uuid);

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
	public java.util.List<Policy> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Policy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

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
	public java.util.List<Policy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the policies before and after the current policy in the ordered set where uuid = &#63;.
	 *
	 * @param policyPK the primary key of the current policy
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy[] findByUuid_PrevAndNext(
			PolicyPK policyPK, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Removes all the policies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching policies
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the policy where quoteId = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByquoteId(String quoteId) throws NoSuchPolicyException;

	/**
	 * Returns the policy where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByquoteId(String quoteId);

	/**
	 * Returns the policy where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByquoteId(String quoteId, boolean useFinderCache);

	/**
	 * Removes the policy where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the policy that was removed
	 */
	public Policy removeByquoteId(String quoteId) throws NoSuchPolicyException;

	/**
	 * Returns the number of policies where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching policies
	 */
	public int countByquoteId(String quoteId);

	/**
	 * Returns the policy where applicationNumber = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByapplicationNumber(long applicationNumber)
		throws NoSuchPolicyException;

	/**
	 * Returns the policy where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByapplicationNumber(long applicationNumber);

	/**
	 * Returns the policy where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByapplicationNumber(
		long applicationNumber, boolean useFinderCache);

	/**
	 * Removes the policy where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the policy that was removed
	 */
	public Policy removeByapplicationNumber(long applicationNumber)
		throws NoSuchPolicyException;

	/**
	 * Returns the number of policies where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching policies
	 */
	public int countByapplicationNumber(long applicationNumber);

	/**
	 * Returns all the policies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching policies
	 */
	public java.util.List<Policy> findByuserId(long userId);

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
	public java.util.List<Policy> findByuserId(long userId, int start, int end);

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
	public java.util.List<Policy> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

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
	public java.util.List<Policy> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the first policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the last policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	public Policy findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Returns the last policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	public Policy fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

	/**
	 * Returns the policies before and after the current policy in the ordered set where userId = &#63;.
	 *
	 * @param policyPK the primary key of the current policy
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy[] findByuserId_PrevAndNext(
			PolicyPK policyPK, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Policy>
				orderByComparator)
		throws NoSuchPolicyException;

	/**
	 * Removes all the policies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of policies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching policies
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the policy in the entity cache if it is enabled.
	 *
	 * @param policy the policy
	 */
	public void cacheResult(Policy policy);

	/**
	 * Caches the policies in the entity cache if it is enabled.
	 *
	 * @param policies the policies
	 */
	public void cacheResult(java.util.List<Policy> policies);

	/**
	 * Creates a new policy with the primary key. Does not add the policy to the database.
	 *
	 * @param policyPK the primary key for the new policy
	 * @return the new policy
	 */
	public Policy create(PolicyPK policyPK);

	/**
	 * Removes the policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy that was removed
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy remove(PolicyPK policyPK) throws NoSuchPolicyException;

	public Policy updateImpl(Policy policy);

	/**
	 * Returns the policy with the primary key or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	public Policy findByPrimaryKey(PolicyPK policyPK)
		throws NoSuchPolicyException;

	/**
	 * Returns the policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy, or <code>null</code> if a policy with the primary key could not be found
	 */
	public Policy fetchByPrimaryKey(PolicyPK policyPK);

	/**
	 * Returns all the policies.
	 *
	 * @return the policies
	 */
	public java.util.List<Policy> findAll();

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
	public java.util.List<Policy> findAll(int start, int end);

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
	public java.util.List<Policy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator);

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
	public java.util.List<Policy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Policy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the policies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of policies.
	 *
	 * @return the number of policies
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}