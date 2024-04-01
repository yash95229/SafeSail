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

import com.safesail.exception.NoSuchLifeInsuranceException;
import com.safesail.model.LifeInsurance;
import com.safesail.model.LifeInsuranceTable;
import com.safesail.model.impl.LifeInsuranceImpl;
import com.safesail.model.impl.LifeInsuranceModelImpl;
import com.safesail.service.persistence.LifeInsurancePersistence;
import com.safesail.service.persistence.LifeInsuranceUtil;
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
 * The persistence implementation for the life insurance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LifeInsurancePersistence.class)
public class LifeInsurancePersistenceImpl
	extends BasePersistenceImpl<LifeInsurance>
	implements LifeInsurancePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LifeInsuranceUtil</code> to access the life insurance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LifeInsuranceImpl.class.getName();

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
	 * Returns all the life insurances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching life insurances
	 */
	@Override
	public List<LifeInsurance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LifeInsurance> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<LifeInsurance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<LifeInsurance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator,
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

		List<LifeInsurance> list = null;

		if (useFinderCache) {
			list = (List<LifeInsurance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LifeInsurance lifeInsurance : list) {
					if (!uuid.equals(lifeInsurance.getUuid())) {
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

			sb.append(_SQL_SELECT_LIFEINSURANCE_WHERE);

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
				sb.append(LifeInsuranceModelImpl.ORDER_BY_JPQL);
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

				list = (List<LifeInsurance>)QueryUtil.list(
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
	 * Returns the first life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByUuid_First(
			String uuid, OrderByComparator<LifeInsurance> orderByComparator)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByUuid_First(
			uuid, orderByComparator);

		if (lifeInsurance != null) {
			return lifeInsurance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLifeInsuranceException(sb.toString());
	}

	/**
	 * Returns the first life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByUuid_First(
		String uuid, OrderByComparator<LifeInsurance> orderByComparator) {

		List<LifeInsurance> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByUuid_Last(
			String uuid, OrderByComparator<LifeInsurance> orderByComparator)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByUuid_Last(uuid, orderByComparator);

		if (lifeInsurance != null) {
			return lifeInsurance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLifeInsuranceException(sb.toString());
	}

	/**
	 * Returns the last life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByUuid_Last(
		String uuid, OrderByComparator<LifeInsurance> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LifeInsurance> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LifeInsurance[] findByUuid_PrevAndNext(
			String quoteId, String uuid,
			OrderByComparator<LifeInsurance> orderByComparator)
		throws NoSuchLifeInsuranceException {

		uuid = Objects.toString(uuid, "");

		LifeInsurance lifeInsurance = findByPrimaryKey(quoteId);

		Session session = null;

		try {
			session = openSession();

			LifeInsurance[] array = new LifeInsuranceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, lifeInsurance, uuid, orderByComparator, true);

			array[1] = lifeInsurance;

			array[2] = getByUuid_PrevAndNext(
				session, lifeInsurance, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LifeInsurance getByUuid_PrevAndNext(
		Session session, LifeInsurance lifeInsurance, String uuid,
		OrderByComparator<LifeInsurance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIFEINSURANCE_WHERE);

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
			sb.append(LifeInsuranceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						lifeInsurance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LifeInsurance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the life insurances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LifeInsurance lifeInsurance :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lifeInsurance);
		}
	}

	/**
	 * Returns the number of life insurances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching life insurances
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIFEINSURANCE_WHERE);

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
		"lifeInsurance.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(lifeInsurance.uuid IS NULL OR lifeInsurance.uuid = '')";

	private FinderPath _finderPathFetchByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns the life insurance where userId = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByuserId(long userId)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByuserId(userId);

		if (lifeInsurance == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLifeInsuranceException(sb.toString());
		}

		return lifeInsurance;
	}

	/**
	 * Returns the life insurance where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByuserId(long userId) {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the life insurance where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByuserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserId, finderArgs, this);
		}

		if (result instanceof LifeInsurance) {
			LifeInsurance lifeInsurance = (LifeInsurance)result;

			if (userId != lifeInsurance.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LIFEINSURANCE_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<LifeInsurance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByuserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"LifeInsurancePersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LifeInsurance lifeInsurance = list.get(0);

					result = lifeInsurance;

					cacheResult(lifeInsurance);
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
			return (LifeInsurance)result;
		}
	}

	/**
	 * Removes the life insurance where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the life insurance that was removed
	 */
	@Override
	public LifeInsurance removeByuserId(long userId)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = findByuserId(userId);

		return remove(lifeInsurance);
	}

	/**
	 * Returns the number of life insurances where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching life insurances
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIFEINSURANCE_WHERE);

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
		"lifeInsurance.userId = ?";

	private FinderPath _finderPathFetchByquoteId;
	private FinderPath _finderPathCountByquoteId;

	/**
	 * Returns the life insurance where quoteId = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByquoteId(String quoteId)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByquoteId(quoteId);

		if (lifeInsurance == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("quoteId=");
			sb.append(quoteId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLifeInsuranceException(sb.toString());
		}

		return lifeInsurance;
	}

	/**
	 * Returns the life insurance where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByquoteId(String quoteId) {
		return fetchByquoteId(quoteId, true);
	}

	/**
	 * Returns the life insurance where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByquoteId(
		String quoteId, boolean useFinderCache) {

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

		if (result instanceof LifeInsurance) {
			LifeInsurance lifeInsurance = (LifeInsurance)result;

			if (!Objects.equals(quoteId, lifeInsurance.getQuoteId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LIFEINSURANCE_WHERE);

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

				List<LifeInsurance> list = query.list();

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
								"LifeInsurancePersistenceImpl.fetchByquoteId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LifeInsurance lifeInsurance = list.get(0);

					result = lifeInsurance;

					cacheResult(lifeInsurance);
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
			return (LifeInsurance)result;
		}
	}

	/**
	 * Removes the life insurance where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the life insurance that was removed
	 */
	@Override
	public LifeInsurance removeByquoteId(String quoteId)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = findByquoteId(quoteId);

		return remove(lifeInsurance);
	}

	/**
	 * Returns the number of life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching life insurances
	 */
	@Override
	public int countByquoteId(String quoteId) {
		quoteId = Objects.toString(quoteId, "");

		FinderPath finderPath = _finderPathCountByquoteId;

		Object[] finderArgs = new Object[] {quoteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIFEINSURANCE_WHERE);

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
		"lifeInsurance.quoteId = ?";

	private static final String _FINDER_COLUMN_QUOTEID_QUOTEID_3 =
		"(lifeInsurance.quoteId IS NULL OR lifeInsurance.quoteId = '')";

	private FinderPath _finderPathWithPaginationFindByquoteIds;
	private FinderPath _finderPathWithoutPaginationFindByquoteIds;
	private FinderPath _finderPathCountByquoteIds;

	/**
	 * Returns all the life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurances
	 */
	@Override
	public List<LifeInsurance> findByquoteIds(String quoteId) {
		return findByquoteIds(
			quoteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end) {

		return findByquoteIds(quoteId, start, end, null);
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
	@Override
	public List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return findByquoteIds(quoteId, start, end, orderByComparator, true);
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
	@Override
	public List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator,
		boolean useFinderCache) {

		quoteId = Objects.toString(quoteId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByquoteIds;
				finderArgs = new Object[] {quoteId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByquoteIds;
			finderArgs = new Object[] {quoteId, start, end, orderByComparator};
		}

		List<LifeInsurance> list = null;

		if (useFinderCache) {
			list = (List<LifeInsurance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LifeInsurance lifeInsurance : list) {
					if (!quoteId.equals(lifeInsurance.getQuoteId())) {
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

			sb.append(_SQL_SELECT_LIFEINSURANCE_WHERE);

			boolean bindQuoteId = false;

			if (quoteId.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTEIDS_QUOTEID_3);
			}
			else {
				bindQuoteId = true;

				sb.append(_FINDER_COLUMN_QUOTEIDS_QUOTEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LifeInsuranceModelImpl.ORDER_BY_JPQL);
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

				list = (List<LifeInsurance>)QueryUtil.list(
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
	 * Returns the first life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByquoteIds_First(
			String quoteId, OrderByComparator<LifeInsurance> orderByComparator)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByquoteIds_First(
			quoteId, orderByComparator);

		if (lifeInsurance != null) {
			return lifeInsurance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quoteId=");
		sb.append(quoteId);

		sb.append("}");

		throw new NoSuchLifeInsuranceException(sb.toString());
	}

	/**
	 * Returns the first life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByquoteIds_First(
		String quoteId, OrderByComparator<LifeInsurance> orderByComparator) {

		List<LifeInsurance> list = findByquoteIds(
			quoteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByquoteIds_Last(
			String quoteId, OrderByComparator<LifeInsurance> orderByComparator)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByquoteIds_Last(
			quoteId, orderByComparator);

		if (lifeInsurance != null) {
			return lifeInsurance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("quoteId=");
		sb.append(quoteId);

		sb.append("}");

		throw new NoSuchLifeInsuranceException(sb.toString());
	}

	/**
	 * Returns the last life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByquoteIds_Last(
		String quoteId, OrderByComparator<LifeInsurance> orderByComparator) {

		int count = countByquoteIds(quoteId);

		if (count == 0) {
			return null;
		}

		List<LifeInsurance> list = findByquoteIds(
			quoteId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the life insurances where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 */
	@Override
	public void removeByquoteIds(String quoteId) {
		for (LifeInsurance lifeInsurance :
				findByquoteIds(
					quoteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lifeInsurance);
		}
	}

	/**
	 * Returns the number of life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching life insurances
	 */
	@Override
	public int countByquoteIds(String quoteId) {
		quoteId = Objects.toString(quoteId, "");

		FinderPath finderPath = _finderPathCountByquoteIds;

		Object[] finderArgs = new Object[] {quoteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIFEINSURANCE_WHERE);

			boolean bindQuoteId = false;

			if (quoteId.isEmpty()) {
				sb.append(_FINDER_COLUMN_QUOTEIDS_QUOTEID_3);
			}
			else {
				bindQuoteId = true;

				sb.append(_FINDER_COLUMN_QUOTEIDS_QUOTEID_2);
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

	private static final String _FINDER_COLUMN_QUOTEIDS_QUOTEID_2 =
		"lifeInsurance.quoteId = ?";

	private static final String _FINDER_COLUMN_QUOTEIDS_QUOTEID_3 =
		"(lifeInsurance.quoteId IS NULL OR lifeInsurance.quoteId = '')";

	private FinderPath _finderPathFetchByaadharNumber;
	private FinderPath _finderPathCountByaadharNumber;

	/**
	 * Returns the life insurance where aadharNumber = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByaadharNumber(String aadharNumber)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByaadharNumber(aadharNumber);

		if (lifeInsurance == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("aadharNumber=");
			sb.append(aadharNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLifeInsuranceException(sb.toString());
		}

		return lifeInsurance;
	}

	/**
	 * Returns the life insurance where aadharNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByaadharNumber(String aadharNumber) {
		return fetchByaadharNumber(aadharNumber, true);
	}

	/**
	 * Returns the life insurance where aadharNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param aadharNumber the aadhar number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByaadharNumber(
		String aadharNumber, boolean useFinderCache) {

		aadharNumber = Objects.toString(aadharNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {aadharNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByaadharNumber, finderArgs, this);
		}

		if (result instanceof LifeInsurance) {
			LifeInsurance lifeInsurance = (LifeInsurance)result;

			if (!Objects.equals(
					aadharNumber, lifeInsurance.getAadharNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LIFEINSURANCE_WHERE);

			boolean bindAadharNumber = false;

			if (aadharNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_AADHARNUMBER_AADHARNUMBER_3);
			}
			else {
				bindAadharNumber = true;

				sb.append(_FINDER_COLUMN_AADHARNUMBER_AADHARNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAadharNumber) {
					queryPos.add(aadharNumber);
				}

				List<LifeInsurance> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByaadharNumber, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {aadharNumber};
							}

							_log.warn(
								"LifeInsurancePersistenceImpl.fetchByaadharNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LifeInsurance lifeInsurance = list.get(0);

					result = lifeInsurance;

					cacheResult(lifeInsurance);
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
			return (LifeInsurance)result;
		}
	}

	/**
	 * Removes the life insurance where aadharNumber = &#63; from the database.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the life insurance that was removed
	 */
	@Override
	public LifeInsurance removeByaadharNumber(String aadharNumber)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = findByaadharNumber(aadharNumber);

		return remove(lifeInsurance);
	}

	/**
	 * Returns the number of life insurances where aadharNumber = &#63;.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the number of matching life insurances
	 */
	@Override
	public int countByaadharNumber(String aadharNumber) {
		aadharNumber = Objects.toString(aadharNumber, "");

		FinderPath finderPath = _finderPathCountByaadharNumber;

		Object[] finderArgs = new Object[] {aadharNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIFEINSURANCE_WHERE);

			boolean bindAadharNumber = false;

			if (aadharNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_AADHARNUMBER_AADHARNUMBER_3);
			}
			else {
				bindAadharNumber = true;

				sb.append(_FINDER_COLUMN_AADHARNUMBER_AADHARNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAadharNumber) {
					queryPos.add(aadharNumber);
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

	private static final String _FINDER_COLUMN_AADHARNUMBER_AADHARNUMBER_2 =
		"lifeInsurance.aadharNumber = ?";

	private static final String _FINDER_COLUMN_AADHARNUMBER_AADHARNUMBER_3 =
		"(lifeInsurance.aadharNumber IS NULL OR lifeInsurance.aadharNumber = '')";

	private FinderPath _finderPathWithPaginationFindByemailAddress;
	private FinderPath _finderPathWithoutPaginationFindByemailAddress;
	private FinderPath _finderPathCountByemailAddress;

	/**
	 * Returns all the life insurances where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching life insurances
	 */
	@Override
	public List<LifeInsurance> findByemailAddress(String emailAddress) {
		return findByemailAddress(
			emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end) {

		return findByemailAddress(emailAddress, start, end, null);
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
	@Override
	public List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return findByemailAddress(
			emailAddress, start, end, orderByComparator, true);
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
	@Override
	public List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator,
		boolean useFinderCache) {

		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByemailAddress;
				finderArgs = new Object[] {emailAddress};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByemailAddress;
			finderArgs = new Object[] {
				emailAddress, start, end, orderByComparator
			};
		}

		List<LifeInsurance> list = null;

		if (useFinderCache) {
			list = (List<LifeInsurance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LifeInsurance lifeInsurance : list) {
					if (!emailAddress.equals(lifeInsurance.getEmailAddress())) {
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

			sb.append(_SQL_SELECT_LIFEINSURANCE_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LifeInsuranceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
				}

				list = (List<LifeInsurance>)QueryUtil.list(
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
	 * Returns the first life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByemailAddress_First(
			String emailAddress,
			OrderByComparator<LifeInsurance> orderByComparator)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByemailAddress_First(
			emailAddress, orderByComparator);

		if (lifeInsurance != null) {
			return lifeInsurance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailAddress=");
		sb.append(emailAddress);

		sb.append("}");

		throw new NoSuchLifeInsuranceException(sb.toString());
	}

	/**
	 * Returns the first life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByemailAddress_First(
		String emailAddress,
		OrderByComparator<LifeInsurance> orderByComparator) {

		List<LifeInsurance> list = findByemailAddress(
			emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance findByemailAddress_Last(
			String emailAddress,
			OrderByComparator<LifeInsurance> orderByComparator)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByemailAddress_Last(
			emailAddress, orderByComparator);

		if (lifeInsurance != null) {
			return lifeInsurance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("emailAddress=");
		sb.append(emailAddress);

		sb.append("}");

		throw new NoSuchLifeInsuranceException(sb.toString());
	}

	/**
	 * Returns the last life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	@Override
	public LifeInsurance fetchByemailAddress_Last(
		String emailAddress,
		OrderByComparator<LifeInsurance> orderByComparator) {

		int count = countByemailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<LifeInsurance> list = findByemailAddress(
			emailAddress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LifeInsurance[] findByemailAddress_PrevAndNext(
			String quoteId, String emailAddress,
			OrderByComparator<LifeInsurance> orderByComparator)
		throws NoSuchLifeInsuranceException {

		emailAddress = Objects.toString(emailAddress, "");

		LifeInsurance lifeInsurance = findByPrimaryKey(quoteId);

		Session session = null;

		try {
			session = openSession();

			LifeInsurance[] array = new LifeInsuranceImpl[3];

			array[0] = getByemailAddress_PrevAndNext(
				session, lifeInsurance, emailAddress, orderByComparator, true);

			array[1] = lifeInsurance;

			array[2] = getByemailAddress_PrevAndNext(
				session, lifeInsurance, emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LifeInsurance getByemailAddress_PrevAndNext(
		Session session, LifeInsurance lifeInsurance, String emailAddress,
		OrderByComparator<LifeInsurance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIFEINSURANCE_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
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
			sb.append(LifeInsuranceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmailAddress) {
			queryPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lifeInsurance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<LifeInsurance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the life insurances where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	@Override
	public void removeByemailAddress(String emailAddress) {
		for (LifeInsurance lifeInsurance :
				findByemailAddress(
					emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lifeInsurance);
		}
	}

	/**
	 * Returns the number of life insurances where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching life insurances
	 */
	@Override
	public int countByemailAddress(String emailAddress) {
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByemailAddress;

		Object[] finderArgs = new Object[] {emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIFEINSURANCE_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 =
		"lifeInsurance.emailAddress = ?";

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 =
		"(lifeInsurance.emailAddress IS NULL OR lifeInsurance.emailAddress = '')";

	public LifeInsurancePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(LifeInsurance.class);

		setModelImplClass(LifeInsuranceImpl.class);
		setModelPKClass(String.class);

		setTable(LifeInsuranceTable.INSTANCE);
	}

	/**
	 * Caches the life insurance in the entity cache if it is enabled.
	 *
	 * @param lifeInsurance the life insurance
	 */
	@Override
	public void cacheResult(LifeInsurance lifeInsurance) {
		entityCache.putResult(
			LifeInsuranceImpl.class, lifeInsurance.getPrimaryKey(),
			lifeInsurance);

		finderCache.putResult(
			_finderPathFetchByuserId, new Object[] {lifeInsurance.getUserId()},
			lifeInsurance);

		finderCache.putResult(
			_finderPathFetchByquoteId,
			new Object[] {lifeInsurance.getQuoteId()}, lifeInsurance);

		finderCache.putResult(
			_finderPathFetchByaadharNumber,
			new Object[] {lifeInsurance.getAadharNumber()}, lifeInsurance);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the life insurances in the entity cache if it is enabled.
	 *
	 * @param lifeInsurances the life insurances
	 */
	@Override
	public void cacheResult(List<LifeInsurance> lifeInsurances) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lifeInsurances.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (LifeInsurance lifeInsurance : lifeInsurances) {
			if (entityCache.getResult(
					LifeInsuranceImpl.class, lifeInsurance.getPrimaryKey()) ==
						null) {

				cacheResult(lifeInsurance);
			}
		}
	}

	/**
	 * Clears the cache for all life insurances.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LifeInsuranceImpl.class);

		finderCache.clearCache(LifeInsuranceImpl.class);
	}

	/**
	 * Clears the cache for the life insurance.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LifeInsurance lifeInsurance) {
		entityCache.removeResult(LifeInsuranceImpl.class, lifeInsurance);
	}

	@Override
	public void clearCache(List<LifeInsurance> lifeInsurances) {
		for (LifeInsurance lifeInsurance : lifeInsurances) {
			entityCache.removeResult(LifeInsuranceImpl.class, lifeInsurance);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LifeInsuranceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LifeInsuranceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LifeInsuranceModelImpl lifeInsuranceModelImpl) {

		Object[] args = new Object[] {lifeInsuranceModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByuserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByuserId, args, lifeInsuranceModelImpl);

		args = new Object[] {lifeInsuranceModelImpl.getQuoteId()};

		finderCache.putResult(_finderPathCountByquoteId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByquoteId, args, lifeInsuranceModelImpl);

		args = new Object[] {lifeInsuranceModelImpl.getAadharNumber()};

		finderCache.putResult(
			_finderPathCountByaadharNumber, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByaadharNumber, args, lifeInsuranceModelImpl);
	}

	/**
	 * Creates a new life insurance with the primary key. Does not add the life insurance to the database.
	 *
	 * @param quoteId the primary key for the new life insurance
	 * @return the new life insurance
	 */
	@Override
	public LifeInsurance create(String quoteId) {
		LifeInsurance lifeInsurance = new LifeInsuranceImpl();

		lifeInsurance.setNew(true);
		lifeInsurance.setPrimaryKey(quoteId);

		String uuid = _portalUUID.generate();

		lifeInsurance.setUuid(uuid);

		return lifeInsurance;
	}

	/**
	 * Removes the life insurance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance that was removed
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	@Override
	public LifeInsurance remove(String quoteId)
		throws NoSuchLifeInsuranceException {

		return remove((Serializable)quoteId);
	}

	/**
	 * Removes the life insurance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the life insurance
	 * @return the life insurance that was removed
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	@Override
	public LifeInsurance remove(Serializable primaryKey)
		throws NoSuchLifeInsuranceException {

		Session session = null;

		try {
			session = openSession();

			LifeInsurance lifeInsurance = (LifeInsurance)session.get(
				LifeInsuranceImpl.class, primaryKey);

			if (lifeInsurance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLifeInsuranceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lifeInsurance);
		}
		catch (NoSuchLifeInsuranceException noSuchEntityException) {
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
	protected LifeInsurance removeImpl(LifeInsurance lifeInsurance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lifeInsurance)) {
				lifeInsurance = (LifeInsurance)session.get(
					LifeInsuranceImpl.class, lifeInsurance.getPrimaryKeyObj());
			}

			if (lifeInsurance != null) {
				session.delete(lifeInsurance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lifeInsurance != null) {
			clearCache(lifeInsurance);
		}

		return lifeInsurance;
	}

	@Override
	public LifeInsurance updateImpl(LifeInsurance lifeInsurance) {
		boolean isNew = lifeInsurance.isNew();

		if (!(lifeInsurance instanceof LifeInsuranceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lifeInsurance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					lifeInsurance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lifeInsurance proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LifeInsurance implementation " +
					lifeInsurance.getClass());
		}

		LifeInsuranceModelImpl lifeInsuranceModelImpl =
			(LifeInsuranceModelImpl)lifeInsurance;

		if (Validator.isNull(lifeInsurance.getUuid())) {
			String uuid = _portalUUID.generate();

			lifeInsurance.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lifeInsurance);
			}
			else {
				lifeInsurance = (LifeInsurance)session.merge(lifeInsurance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			LifeInsuranceImpl.class, lifeInsuranceModelImpl, false, true);

		cacheUniqueFindersCache(lifeInsuranceModelImpl);

		if (isNew) {
			lifeInsurance.setNew(false);
		}

		lifeInsurance.resetOriginalValues();

		return lifeInsurance;
	}

	/**
	 * Returns the life insurance with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the life insurance
	 * @return the life insurance
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	@Override
	public LifeInsurance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLifeInsuranceException {

		LifeInsurance lifeInsurance = fetchByPrimaryKey(primaryKey);

		if (lifeInsurance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLifeInsuranceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lifeInsurance;
	}

	/**
	 * Returns the life insurance with the primary key or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	@Override
	public LifeInsurance findByPrimaryKey(String quoteId)
		throws NoSuchLifeInsuranceException {

		return findByPrimaryKey((Serializable)quoteId);
	}

	/**
	 * Returns the life insurance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance, or <code>null</code> if a life insurance with the primary key could not be found
	 */
	@Override
	public LifeInsurance fetchByPrimaryKey(String quoteId) {
		return fetchByPrimaryKey((Serializable)quoteId);
	}

	/**
	 * Returns all the life insurances.
	 *
	 * @return the life insurances
	 */
	@Override
	public List<LifeInsurance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LifeInsurance> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<LifeInsurance> findAll(
		int start, int end,
		OrderByComparator<LifeInsurance> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<LifeInsurance> findAll(
		int start, int end, OrderByComparator<LifeInsurance> orderByComparator,
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

		List<LifeInsurance> list = null;

		if (useFinderCache) {
			list = (List<LifeInsurance>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LIFEINSURANCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LIFEINSURANCE;

				sql = sql.concat(LifeInsuranceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LifeInsurance>)QueryUtil.list(
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
	 * Removes all the life insurances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LifeInsurance lifeInsurance : findAll()) {
			remove(lifeInsurance);
		}
	}

	/**
	 * Returns the number of life insurances.
	 *
	 * @return the number of life insurances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LIFEINSURANCE);

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
		return _SQL_SELECT_LIFEINSURANCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LifeInsuranceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the life insurance persistence.
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

		_finderPathFetchByuserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
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

		_finderPathWithPaginationFindByquoteIds = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByquoteIds",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"quoteId"}, true);

		_finderPathWithoutPaginationFindByquoteIds = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByquoteIds",
			new String[] {String.class.getName()}, new String[] {"quoteId"},
			true);

		_finderPathCountByquoteIds = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByquoteIds",
			new String[] {String.class.getName()}, new String[] {"quoteId"},
			false);

		_finderPathFetchByaadharNumber = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByaadharNumber",
			new String[] {String.class.getName()},
			new String[] {"aadharNumber"}, true);

		_finderPathCountByaadharNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByaadharNumber",
			new String[] {String.class.getName()},
			new String[] {"aadharNumber"}, false);

		_finderPathWithPaginationFindByemailAddress = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemailAddress",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"emailAddress"}, true);

		_finderPathWithoutPaginationFindByemailAddress = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemailAddress",
			new String[] {String.class.getName()},
			new String[] {"emailAddress"}, true);

		_finderPathCountByemailAddress = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailAddress",
			new String[] {String.class.getName()},
			new String[] {"emailAddress"}, false);

		_setLifeInsuranceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLifeInsuranceUtilPersistence(null);

		entityCache.removeCache(LifeInsuranceImpl.class.getName());
	}

	private void _setLifeInsuranceUtilPersistence(
		LifeInsurancePersistence lifeInsurancePersistence) {

		try {
			Field field = LifeInsuranceUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, lifeInsurancePersistence);
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

	private static final String _SQL_SELECT_LIFEINSURANCE =
		"SELECT lifeInsurance FROM LifeInsurance lifeInsurance";

	private static final String _SQL_SELECT_LIFEINSURANCE_WHERE =
		"SELECT lifeInsurance FROM LifeInsurance lifeInsurance WHERE ";

	private static final String _SQL_COUNT_LIFEINSURANCE =
		"SELECT COUNT(lifeInsurance) FROM LifeInsurance lifeInsurance";

	private static final String _SQL_COUNT_LIFEINSURANCE_WHERE =
		"SELECT COUNT(lifeInsurance) FROM LifeInsurance lifeInsurance WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lifeInsurance.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LifeInsurance exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LifeInsurance exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LifeInsurancePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}