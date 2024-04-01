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

import com.safesail.exception.NoSuchUserTableException;
import com.safesail.model.UserTable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserTableUtil
 * @generated
 */
@ProviderType
public interface UserTablePersistence extends BasePersistence<UserTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserTableUtil} to access the user table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user tables
	 */
	public java.util.List<UserTable> findByUuid(String uuid);

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
	public java.util.List<UserTable> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<UserTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator);

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
	public java.util.List<UserTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public UserTable findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserTable>
				orderByComparator)
		throws NoSuchUserTableException;

	/**
	 * Returns the first user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public UserTable fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator);

	/**
	 * Returns the last user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public UserTable findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserTable>
				orderByComparator)
		throws NoSuchUserTableException;

	/**
	 * Returns the last user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public UserTable fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator);

	/**
	 * Returns the user tables before and after the current user table in the ordered set where uuid = &#63;.
	 *
	 * @param quoteId the primary key of the current user table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user table
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	public UserTable[] findByUuid_PrevAndNext(
			String quoteId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserTable>
				orderByComparator)
		throws NoSuchUserTableException;

	/**
	 * Removes all the user tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the user tables where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user tables
	 */
	public java.util.List<UserTable> findByuserId(long userId);

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
	public java.util.List<UserTable> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<UserTable> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator);

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
	public java.util.List<UserTable> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public UserTable findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserTable>
				orderByComparator)
		throws NoSuchUserTableException;

	/**
	 * Returns the first user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public UserTable fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator);

	/**
	 * Returns the last user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public UserTable findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserTable>
				orderByComparator)
		throws NoSuchUserTableException;

	/**
	 * Returns the last user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public UserTable fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator);

	/**
	 * Returns the user tables before and after the current user table in the ordered set where userId = &#63;.
	 *
	 * @param quoteId the primary key of the current user table
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user table
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	public UserTable[] findByuserId_PrevAndNext(
			String quoteId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserTable>
				orderByComparator)
		throws NoSuchUserTableException;

	/**
	 * Removes all the user tables where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of user tables where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user tables
	 */
	public int countByuserId(long userId);

	/**
	 * Returns the user table where quoteId = &#63; or throws a <code>NoSuchUserTableException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	public UserTable findByquoteId(String quoteId)
		throws NoSuchUserTableException;

	/**
	 * Returns the user table where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public UserTable fetchByquoteId(String quoteId);

	/**
	 * Returns the user table where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user table, or <code>null</code> if a matching user table could not be found
	 */
	public UserTable fetchByquoteId(String quoteId, boolean useFinderCache);

	/**
	 * Removes the user table where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the user table that was removed
	 */
	public UserTable removeByquoteId(String quoteId)
		throws NoSuchUserTableException;

	/**
	 * Returns the number of user tables where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching user tables
	 */
	public int countByquoteId(String quoteId);

	/**
	 * Caches the user table in the entity cache if it is enabled.
	 *
	 * @param userTable the user table
	 */
	public void cacheResult(UserTable userTable);

	/**
	 * Caches the user tables in the entity cache if it is enabled.
	 *
	 * @param userTables the user tables
	 */
	public void cacheResult(java.util.List<UserTable> userTables);

	/**
	 * Creates a new user table with the primary key. Does not add the user table to the database.
	 *
	 * @param quoteId the primary key for the new user table
	 * @return the new user table
	 */
	public UserTable create(String quoteId);

	/**
	 * Removes the user table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table that was removed
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	public UserTable remove(String quoteId) throws NoSuchUserTableException;

	public UserTable updateImpl(UserTable userTable);

	/**
	 * Returns the user table with the primary key or throws a <code>NoSuchUserTableException</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	public UserTable findByPrimaryKey(String quoteId)
		throws NoSuchUserTableException;

	/**
	 * Returns the user table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table, or <code>null</code> if a user table with the primary key could not be found
	 */
	public UserTable fetchByPrimaryKey(String quoteId);

	/**
	 * Returns all the user tables.
	 *
	 * @return the user tables
	 */
	public java.util.List<UserTable> findAll();

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
	public java.util.List<UserTable> findAll(int start, int end);

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
	public java.util.List<UserTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator);

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
	public java.util.List<UserTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user tables.
	 *
	 * @return the number of user tables
	 */
	public int countAll();

}