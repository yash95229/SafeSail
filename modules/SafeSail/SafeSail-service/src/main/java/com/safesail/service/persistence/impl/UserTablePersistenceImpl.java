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

package com.safesail.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import com.safesail.exception.NoSuchUserTableException;
import com.safesail.model.UserTable;
import com.safesail.model.UserTableTable;
import com.safesail.model.impl.UserTableImpl;
import com.safesail.model.impl.UserTableModelImpl;
import com.safesail.service.persistence.UserTablePersistence;
import com.safesail.service.persistence.UserTableUtil;
import com.safesail.service.persistence.impl.constants.Safe_SailPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserTablePersistence.class)
public class UserTablePersistenceImpl
	extends BasePersistenceImpl<UserTable> implements UserTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserTableUtil</code> to access the user table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserTableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the user tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user tables
	 */
	@Override
	public List<UserTable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserTable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserTable> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserTable> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<UserTable> list = null;

		if (useFinderCache) {
			list = (List<UserTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserTable userTable : list) {
					if (!uuid.equals(userTable.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERTABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<UserTable>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	@Override
	public UserTable findByUuid_First(
			String uuid, OrderByComparator<UserTable> orderByComparator)
		throws NoSuchUserTableException {

		UserTable userTable = fetchByUuid_First(uuid, orderByComparator);

		if (userTable != null) {
			return userTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserTableException(sb.toString());
	}

	/**
	 * Returns the first user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table, or <code>null</code> if a matching user table could not be found
	 */
	@Override
	public UserTable fetchByUuid_First(
		String uuid, OrderByComparator<UserTable> orderByComparator) {

		List<UserTable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	@Override
	public UserTable findByUuid_Last(
			String uuid, OrderByComparator<UserTable> orderByComparator)
		throws NoSuchUserTableException {

		UserTable userTable = fetchByUuid_Last(uuid, orderByComparator);

		if (userTable != null) {
			return userTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserTableException(sb.toString());
	}

	/**
	 * Returns the last user table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table, or <code>null</code> if a matching user table could not be found
	 */
	@Override
	public UserTable fetchByUuid_Last(
		String uuid, OrderByComparator<UserTable> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserTable> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserTable[] findByUuid_PrevAndNext(
			String quoteId, String uuid,
			OrderByComparator<UserTable> orderByComparator)
		throws NoSuchUserTableException {

		uuid = Objects.toString(uuid, "");

		UserTable userTable = findByPrimaryKey(quoteId);

		Session session = null;

		try {
			session = openSession();

			UserTable[] array = new UserTableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userTable, uuid, orderByComparator, true);

			array[1] = userTable;

			array[2] = getByUuid_PrevAndNext(
				session, userTable, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserTable getByUuid_PrevAndNext(
		Session session, UserTable userTable, String uuid,
		OrderByComparator<UserTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERTABLE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserTable userTable :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userTable);
		}
	}

	/**
	 * Returns the number of user tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user tables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERTABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"userTable.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userTable.uuid IS NULL OR userTable.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the user tables where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user tables
	 */
	@Override
	public List<UserTable> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserTable> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
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
	@Override
	public List<UserTable> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserTable> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<UserTable> findByuserId(
		long userId, int start, int end,
		OrderByComparator<UserTable> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<UserTable> list = null;

		if (useFinderCache) {
			list = (List<UserTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserTable userTable : list) {
					if (userId != userTable.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERTABLE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<UserTable>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	@Override
	public UserTable findByuserId_First(
			long userId, OrderByComparator<UserTable> orderByComparator)
		throws NoSuchUserTableException {

		UserTable userTable = fetchByuserId_First(userId, orderByComparator);

		if (userTable != null) {
			return userTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchUserTableException(sb.toString());
	}

	/**
	 * Returns the first user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user table, or <code>null</code> if a matching user table could not be found
	 */
	@Override
	public UserTable fetchByuserId_First(
		long userId, OrderByComparator<UserTable> orderByComparator) {

		List<UserTable> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	@Override
	public UserTable findByuserId_Last(
			long userId, OrderByComparator<UserTable> orderByComparator)
		throws NoSuchUserTableException {

		UserTable userTable = fetchByuserId_Last(userId, orderByComparator);

		if (userTable != null) {
			return userTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchUserTableException(sb.toString());
	}

	/**
	 * Returns the last user table in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user table, or <code>null</code> if a matching user table could not be found
	 */
	@Override
	public UserTable fetchByuserId_Last(
		long userId, OrderByComparator<UserTable> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserTable> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserTable[] findByuserId_PrevAndNext(
			String quoteId, long userId,
			OrderByComparator<UserTable> orderByComparator)
		throws NoSuchUserTableException {

		UserTable userTable = findByPrimaryKey(quoteId);

		Session session = null;

		try {
			session = openSession();

			UserTable[] array = new UserTableImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, userTable, userId, orderByComparator, true);

			array[1] = userTable;

			array[2] = getByuserId_PrevAndNext(
				session, userTable, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserTable getByuserId_PrevAndNext(
		Session session, UserTable userTable, long userId,
		OrderByComparator<UserTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERTABLE_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user tables where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (UserTable userTable :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userTable);
		}
	}

	/**
	 * Returns the number of user tables where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user tables
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERTABLE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"userTable.userId = ?";

	private FinderPath _finderPathFetchByquoteId;
	private FinderPath _finderPathCountByquoteId;

	/**
	 * Returns the user table where quoteId = &#63; or throws a <code>NoSuchUserTableException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching user table
	 * @throws NoSuchUserTableException if a matching user table could not be found
	 */
	@Override
	public UserTable findByquoteId(String quoteId)
		throws NoSuchUserTableException {

		UserTable userTable = fetchByquoteId(quoteId);

		if (userTable == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("quoteId=");
			sb.append(quoteId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchUserTableException(sb.toString());
		}

		return userTable;
	}

	/**
	 * Returns the user table where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching user table, or <code>null</code> if a matching user table could not be found
	 */
	@Override
	public UserTable fetchByquoteId(String quoteId) {
		return fetchByquoteId(quoteId, true);
	}

	/**
	 * Returns the user table where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user table, or <code>null</code> if a matching user table could not be found
	 */
	@Override
	public UserTable fetchByquoteId(String quoteId, boolean useFinderCache) {
		quoteId = Objects.toString(quoteId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {quoteId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByquoteId, finderArgs, this);
		}

		if (result instanceof UserTable) {
			UserTable userTable = (UserTable)result;

			if (!Objects.equals(quoteId, userTable.getQuoteId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_USERTABLE_WHERE);

			boolean bindQuoteId = false;

			if (quoteId.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTEID_QUOTEID_3);
			}
			else {
				bindQuoteId = true;

				sb.append(_FINDER_COLUMN_QUOTEID_QUOTEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindQuoteId) {
					queryPos.add(quoteId);
				}

				List<UserTable> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByquoteId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {quoteId};
							}

							_log.warn(
								"UserTablePersistenceImpl.fetchByquoteId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserTable userTable = list.get(0);

					result = userTable;

					cacheResult(userTable);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserTable)result;
		}
	}

	/**
	 * Removes the user table where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the user table that was removed
	 */
	@Override
	public UserTable removeByquoteId(String quoteId)
		throws NoSuchUserTableException {

		UserTable userTable = findByquoteId(quoteId);

		return remove(userTable);
	}

	/**
	 * Returns the number of user tables where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching user tables
	 */
	@Override
	public int countByquoteId(String quoteId) {
		quoteId = Objects.toString(quoteId, "");

		FinderPath finderPath = _finderPathCountByquoteId;

		Object[] finderArgs = new Object[] {quoteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERTABLE_WHERE);

			boolean bindQuoteId = false;

			if (quoteId.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTEID_QUOTEID_3);
			}
			else {
				bindQuoteId = true;

				sb.append(_FINDER_COLUMN_QUOTEID_QUOTEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindQuoteId) {
					queryPos.add(quoteId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_QUOTEID_QUOTEID_2 =
		"userTable.quoteId = ?";

	private static final String _FINDER_COLUMN_QUOTEID_QUOTEID_3 =
		"(userTable.quoteId IS NULL OR userTable.quoteId = '')";

	public UserTablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UserTable.class);

		setModelImplClass(UserTableImpl.class);
		setModelPKClass(String.class);

		setTable(UserTableTable.INSTANCE);
	}

	/**
	 * Caches the user table in the entity cache if it is enabled.
	 *
	 * @param userTable the user table
	 */
	@Override
	public void cacheResult(UserTable userTable) {
		entityCache.putResult(
			UserTableImpl.class, userTable.getPrimaryKey(), userTable);

		finderCache.putResult(
			_finderPathFetchByquoteId, new Object[] {userTable.getQuoteId()},
			userTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user tables in the entity cache if it is enabled.
	 *
	 * @param userTables the user tables
	 */
	@Override
	public void cacheResult(List<UserTable> userTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserTable userTable : userTables) {
			if (entityCache.getResult(
					UserTableImpl.class, userTable.getPrimaryKey()) == null) {

				cacheResult(userTable);
			}
		}
	}

	/**
	 * Clears the cache for all user tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserTableImpl.class);

		finderCache.clearCache(UserTableImpl.class);
	}

	/**
	 * Clears the cache for the user table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserTable userTable) {
		entityCache.removeResult(UserTableImpl.class, userTable);
	}

	@Override
	public void clearCache(List<UserTable> userTables) {
		for (UserTable userTable : userTables) {
			entityCache.removeResult(UserTableImpl.class, userTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserTableImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UserTableModelImpl userTableModelImpl) {

		Object[] args = new Object[] {userTableModelImpl.getQuoteId()};

		finderCache.putResult(_finderPathCountByquoteId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByquoteId, args, userTableModelImpl);
	}

	/**
	 * Creates a new user table with the primary key. Does not add the user table to the database.
	 *
	 * @param quoteId the primary key for the new user table
	 * @return the new user table
	 */
	@Override
	public UserTable create(String quoteId) {
		UserTable userTable = new UserTableImpl();

		userTable.setNew(true);
		userTable.setPrimaryKey(quoteId);

		String uuid = _portalUUID.generate();

		userTable.setUuid(uuid);

		return userTable;
	}

	/**
	 * Removes the user table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table that was removed
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	@Override
	public UserTable remove(String quoteId) throws NoSuchUserTableException {
		return remove((Serializable)quoteId);
	}

	/**
	 * Removes the user table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user table
	 * @return the user table that was removed
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	@Override
	public UserTable remove(Serializable primaryKey)
		throws NoSuchUserTableException {

		Session session = null;

		try {
			session = openSession();

			UserTable userTable = (UserTable)session.get(
				UserTableImpl.class, primaryKey);

			if (userTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userTable);
		}
		catch (NoSuchUserTableException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserTable removeImpl(UserTable userTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userTable)) {
				userTable = (UserTable)session.get(
					UserTableImpl.class, userTable.getPrimaryKeyObj());
			}

			if (userTable != null) {
				session.delete(userTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userTable != null) {
			clearCache(userTable);
		}

		return userTable;
	}

	@Override
	public UserTable updateImpl(UserTable userTable) {
		boolean isNew = userTable.isNew();

		if (!(userTable instanceof UserTableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userTable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userTable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userTable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserTable implementation " +
					userTable.getClass());
		}

		UserTableModelImpl userTableModelImpl = (UserTableModelImpl)userTable;

		if (Validator.isNull(userTable.getUuid())) {
			String uuid = _portalUUID.generate();

			userTable.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userTable);
			}
			else {
				userTable = (UserTable)session.merge(userTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserTableImpl.class, userTableModelImpl, false, true);

		cacheUniqueFindersCache(userTableModelImpl);

		if (isNew) {
			userTable.setNew(false);
		}

		userTable.resetOriginalValues();

		return userTable;
	}

	/**
	 * Returns the user table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user table
	 * @return the user table
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	@Override
	public UserTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserTableException {

		UserTable userTable = fetchByPrimaryKey(primaryKey);

		if (userTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userTable;
	}

	/**
	 * Returns the user table with the primary key or throws a <code>NoSuchUserTableException</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table
	 * @throws NoSuchUserTableException if a user table with the primary key could not be found
	 */
	@Override
	public UserTable findByPrimaryKey(String quoteId)
		throws NoSuchUserTableException {

		return findByPrimaryKey((Serializable)quoteId);
	}

	/**
	 * Returns the user table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table, or <code>null</code> if a user table with the primary key could not be found
	 */
	@Override
	public UserTable fetchByPrimaryKey(String quoteId) {
		return fetchByPrimaryKey((Serializable)quoteId);
	}

	/**
	 * Returns all the user tables.
	 *
	 * @return the user tables
	 */
	@Override
	public List<UserTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserTable> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserTable> findAll(
		int start, int end, OrderByComparator<UserTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserTable> findAll(
		int start, int end, OrderByComparator<UserTable> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserTable> list = null;

		if (useFinderCache) {
			list = (List<UserTable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERTABLE;

				sql = sql.concat(UserTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserTable>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserTable userTable : findAll()) {
			remove(userTable);
		}
	}

	/**
	 * Returns the number of user tables.
	 *
	 * @return the number of user tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERTABLE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "quoteId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user table persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathFetchByquoteId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByquoteId",
			new String[] {String.class.getName()}, new String[] {"quoteId"},
			true);

		_finderPathCountByquoteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByquoteId",
			new String[] {String.class.getName()}, new String[] {"quoteId"},
			false);

		_setUserTableUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserTableUtilPersistence(null);

		entityCache.removeCache(UserTableImpl.class.getName());
	}

	private void _setUserTableUtilPersistence(
		UserTablePersistence userTablePersistence) {

		try {
			Field field = UserTableUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, userTablePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = Safe_SailPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = Safe_SailPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = Safe_SailPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERTABLE =
		"SELECT userTable FROM UserTable userTable";

	private static final String _SQL_SELECT_USERTABLE_WHERE =
		"SELECT userTable FROM UserTable userTable WHERE ";

	private static final String _SQL_COUNT_USERTABLE =
		"SELECT COUNT(userTable) FROM UserTable userTable";

	private static final String _SQL_COUNT_USERTABLE_WHERE =
		"SELECT COUNT(userTable) FROM UserTable userTable WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserTable exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserTable exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserTablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}