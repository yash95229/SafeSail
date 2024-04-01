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

import com.safesail.model.UserTable;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user table service. This utility wraps <code>com.safesail.service.persistence.impl.UserTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTablePersistence
 * @generated
 */
public class UserTableUtil {

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
	public static void clearCache(UserTable userTable) {
		getPersistence().clearCache(userTable);
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
	public static Map<Serializable, UserTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserTable update(UserTable userTable) {
		return getPersistence().update(userTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserTable update(
		UserTable userTable, ServiceContext serviceContext) {

		return getPersistence().update(userTable, serviceContext);
	}

	/**
	 * Returns all the user tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user tables
	 */
	public static List<UserTable> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @return the range of matching user tables
	 */
	public static List<UserTable> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user tables
	 */
	public static List<UserTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserTable> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user tables
	 */
	public static List<UserTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public static UserTable findByUuid_First(
			String uuid, OrderByComparator<UserTable> orderByComparator)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public static UserTable fetchByUuid_First(
		String uuid, OrderByComparator<UserTable> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public static UserTable findByUuid_Last(
			String uuid, OrderByComparator<UserTable> orderByComparator)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public static UserTable fetchByUuid_Last(
		String uuid, OrderByComparator<UserTable> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user tables before and after the current user table in the ordered set where uuid = &#63;.
	 *
	 * @param quoteId the primary key of the current user table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user table
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	public static UserTable[] findByUuid_PrevAndNext(
			String quoteId, String uuid,
			OrderByComparator<UserTable> orderByComparator)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().findByUuid_PrevAndNext(
			quoteId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user tables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the user tables where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user tables
	 */
	public static List<UserTable> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the user tables where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @return the range of matching user tables
	 */
	public static List<UserTable> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the user tables where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user tables
	 */
	public static List<UserTable> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserTable> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user tables where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user tables
	 */
	public static List<UserTable> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public static UserTable findByuserId_First(
			long userId, OrderByComparator<UserTable> orderByComparator)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public static UserTable fetchByuserId_First(
		long userId, OrderByComparator<UserTable> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public static UserTable findByuserId_Last(
			long userId, OrderByComparator<UserTable> orderByComparator)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public static UserTable fetchByuserId_Last(
		long userId, OrderByComparator<UserTable> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the user tables before and after the current user table in the ordered set where userId = &#63;.
	 *
	 * @param quoteId the primary key of the current user table
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user table
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	public static UserTable[] findByuserId_PrevAndNext(
			String quoteId, long userId,
			OrderByComparator<UserTable> orderByComparator)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().findByuserId_PrevAndNext(
			quoteId, userId, orderByComparator);
	}

	/**
	 * Removes all the user tables where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of user tables where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user tables
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns the user table where quoteId = &#63; or throws a <code>NoSuchUserTableException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public static UserTable findByquoteId(String quoteId)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().findByquoteId(quoteId);
	}

	/**
	 * Returns the user table where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public static UserTable fetchByquoteId(String quoteId) {
		return getPersistence().fetchByquoteId(quoteId);
	}

	/**
	 * Returns the user table where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public static UserTable fetchByquoteId(
		String quoteId, boolean useFinderCache) {

		return getPersistence().fetchByquoteId(quoteId, useFinderCache);
	}

	/**
	 * Removes the user table where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the user table that was removed
	 */
	public static UserTable removeByquoteId(String quoteId)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().removeByquoteId(quoteId);
	}

	/**
	 * Returns the number of user tables where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching user tables
	 */
	public static int countByquoteId(String quoteId) {
		return getPersistence().countByquoteId(quoteId);
	}

	/**
	 * Caches the user table in the entity cache if it is enabled.
	 *
	 * @param userTable the user table
	 */
	public static void cacheResult(UserTable userTable) {
		getPersistence().cacheResult(userTable);
	}

	/**
	 * Caches the user tables in the entity cache if it is enabled.
	 *
	 * @param userTables the user tables
	 */
	public static void cacheResult(List<UserTable> userTables) {
		getPersistence().cacheResult(userTables);
	}

	/**
	 * Creates a new user table with the primary key. Does not add the user table to the database.
	 *
	 * @param quoteId the primary key for the new user table
	 * @return the new user table
	 */
	public static UserTable create(String quoteId) {
		return getPersistence().create(quoteId);
	}

	/**
	 * Removes the user table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table that was removed
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	public static UserTable remove(String quoteId)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().remove(quoteId);
	}

	public static UserTable updateImpl(UserTable userTable) {
		return getPersistence().updateImpl(userTable);
	}

	/**
	 * Returns the user table with the primary key or throws a <code>NoSuchUserTableException</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	public static UserTable findByPrimaryKey(String quoteId)
		throws com.safesail.exception.NoSuchUserTableException {

		return getPersistence().findByPrimaryKey(quoteId);
	}

	/**
	 * Returns the user table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table, or <code>null</code> if a user table with the primary key could not be found
	 */
	public static UserTable fetchByPrimaryKey(String quoteId) {
		return getPersistence().fetchByPrimaryKey(quoteId);
	}

	/**
	 * Returns all the user tables.
	 *
	 * @return the user tables
	 */
	public static List<UserTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @return the range of user tables
	 */
	public static List<UserTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user tables
	 */
	public static List<UserTable> findAll(
		int start, int end, OrderByComparator<UserTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user tables
	 */
	public static List<UserTable> findAll(
		int start, int end, OrderByComparator<UserTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user tables.
	 *
	 * @return the number of user tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserTablePersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserTablePersistence _persistence;

}