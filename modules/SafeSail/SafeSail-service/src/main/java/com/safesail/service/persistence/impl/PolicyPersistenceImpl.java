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

import com.safesail.exception.NoSuchPolicyException;
import com.safesail.model.Policy;
import com.safesail.model.PolicyTable;
import com.safesail.model.impl.PolicyImpl;
import com.safesail.model.impl.PolicyModelImpl;
import com.safesail.service.persistence.PolicyPK;
import com.safesail.service.persistence.PolicyPersistence;
import com.safesail.service.persistence.PolicyUtil;
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
 * The persistence implementation for the policy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyPersistence.class)
public class PolicyPersistenceImpl
	extends BasePersistenceImpl<Policy> implements PolicyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyUtil</code> to access the policy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyImpl.class.getName();

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
	 * Returns all the policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching policies
	 */
	@Override
	public List<Policy> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Policy> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Policy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Policy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Policy> orderByComparator, boolean useFinderCache) {

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

		List<Policy> list = null;

		if (useFinderCache) {
			list = (List<Policy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Policy policy : list) {
					if (!uuid.equals(policy.getUuid())) {
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

			sb.append(_SQL_SELECT_POLICY_WHERE);

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
				sb.append(PolicyModelImpl.ORDER_BY_JPQL);
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

				list = (List<Policy>)QueryUtil.list(
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
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	@Override
	public Policy findByUuid_First(
			String uuid, OrderByComparator<Policy> orderByComparator)
		throws NoSuchPolicyException {

		Policy policy = fetchByUuid_First(uuid, orderByComparator);

		if (policy != null) {
			return policy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPolicyException(sb.toString());
	}

	/**
	 * Returns the first policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public Policy fetchByUuid_First(
		String uuid, OrderByComparator<Policy> orderByComparator) {

		List<Policy> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	@Override
	public Policy findByUuid_Last(
			String uuid, OrderByComparator<Policy> orderByComparator)
		throws NoSuchPolicyException {

		Policy policy = fetchByUuid_Last(uuid, orderByComparator);

		if (policy != null) {
			return policy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPolicyException(sb.toString());
	}

	/**
	 * Returns the last policy in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public Policy fetchByUuid_Last(
		String uuid, OrderByComparator<Policy> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Policy> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Policy[] findByUuid_PrevAndNext(
			PolicyPK policyPK, String uuid,
			OrderByComparator<Policy> orderByComparator)
		throws NoSuchPolicyException {

		uuid = Objects.toString(uuid, "");

		Policy policy = findByPrimaryKey(policyPK);

		Session session = null;

		try {
			session = openSession();

			Policy[] array = new PolicyImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, policy, uuid, orderByComparator, true);

			array[1] = policy;

			array[2] = getByUuid_PrevAndNext(
				session, policy, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Policy getByUuid_PrevAndNext(
		Session session, Policy policy, String uuid,
		OrderByComparator<Policy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICY_WHERE);

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
			sb.append(PolicyModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(policy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Policy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Policy policy :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policy);
		}
	}

	/**
	 * Returns the number of policies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching policies
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "policy.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(policy.uuid IS NULL OR policy.uuid = '')";

	private FinderPath _finderPathFetchByquoteId;
	private FinderPath _finderPathCountByquoteId;

	/**
	 * Returns the policy where quoteId = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	@Override
	public Policy findByquoteId(String quoteId) throws NoSuchPolicyException {
		Policy policy = fetchByquoteId(quoteId);

		if (policy == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("quoteId=");
			sb.append(quoteId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPolicyException(sb.toString());
		}

		return policy;
	}

	/**
	 * Returns the policy where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public Policy fetchByquoteId(String quoteId) {
		return fetchByquoteId(quoteId, true);
	}

	/**
	 * Returns the policy where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public Policy fetchByquoteId(String quoteId, boolean useFinderCache) {
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

		if (result instanceof Policy) {
			Policy policy = (Policy)result;

			if (!Objects.equals(quoteId, policy.getQuoteId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_POLICY_WHERE);

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

				List<Policy> list = query.list();

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
								"PolicyPersistenceImpl.fetchByquoteId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Policy policy = list.get(0);

					result = policy;

					cacheResult(policy);
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
			return (Policy)result;
		}
	}

	/**
	 * Removes the policy where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the policy that was removed
	 */
	@Override
	public Policy removeByquoteId(String quoteId) throws NoSuchPolicyException {
		Policy policy = findByquoteId(quoteId);

		return remove(policy);
	}

	/**
	 * Returns the number of policies where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching policies
	 */
	@Override
	public int countByquoteId(String quoteId) {
		quoteId = Objects.toString(quoteId, "");

		FinderPath finderPath = _finderPathCountByquoteId;

		Object[] finderArgs = new Object[] {quoteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICY_WHERE);

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
		"policy.id.quoteId = ?";

	private static final String _FINDER_COLUMN_QUOTEID_QUOTEID_3 =
		"(policy.id.quoteId IS NULL OR policy.id.quoteId = '')";

	private FinderPath _finderPathFetchByapplicationNumber;
	private FinderPath _finderPathCountByapplicationNumber;

	/**
	 * Returns the policy where applicationNumber = &#63; or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param applicationNumber the application number
	 * @return the matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	@Override
	public Policy findByapplicationNumber(long applicationNumber)
		throws NoSuchPolicyException {

		Policy policy = fetchByapplicationNumber(applicationNumber);

		if (policy == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("applicationNumber=");
			sb.append(applicationNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPolicyException(sb.toString());
		}

		return policy;
	}

	/**
	 * Returns the policy where applicationNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public Policy fetchByapplicationNumber(long applicationNumber) {
		return fetchByapplicationNumber(applicationNumber, true);
	}

	/**
	 * Returns the policy where applicationNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNumber the application number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public Policy fetchByapplicationNumber(
		long applicationNumber, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {applicationNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByapplicationNumber, finderArgs, this);
		}

		if (result instanceof Policy) {
			Policy policy = (Policy)result;

			if (applicationNumber != policy.getApplicationNumber()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_POLICY_WHERE);

			sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(applicationNumber);

				List<Policy> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByapplicationNumber, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {applicationNumber};
							}

							_log.warn(
								"PolicyPersistenceImpl.fetchByapplicationNumber(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Policy policy = list.get(0);

					result = policy;

					cacheResult(policy);
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
			return (Policy)result;
		}
	}

	/**
	 * Removes the policy where applicationNumber = &#63; from the database.
	 *
	 * @param applicationNumber the application number
	 * @return the policy that was removed
	 */
	@Override
	public Policy removeByapplicationNumber(long applicationNumber)
		throws NoSuchPolicyException {

		Policy policy = findByapplicationNumber(applicationNumber);

		return remove(policy);
	}

	/**
	 * Returns the number of policies where applicationNumber = &#63;.
	 *
	 * @param applicationNumber the application number
	 * @return the number of matching policies
	 */
	@Override
	public int countByapplicationNumber(long applicationNumber) {
		FinderPath finderPath = _finderPathCountByapplicationNumber;

		Object[] finderArgs = new Object[] {applicationNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICY_WHERE);

			sb.append(_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(applicationNumber);

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

	private static final String
		_FINDER_COLUMN_APPLICATIONNUMBER_APPLICATIONNUMBER_2 =
			"policy.id.applicationNumber = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the policies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching policies
	 */
	@Override
	public List<Policy> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Policy> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
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
	@Override
	public List<Policy> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Policy> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Policy> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Policy> orderByComparator, boolean useFinderCache) {

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

		List<Policy> list = null;

		if (useFinderCache) {
			list = (List<Policy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Policy policy : list) {
					if (userId != policy.getUserId()) {
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

			sb.append(_SQL_SELECT_POLICY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PolicyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Policy>)QueryUtil.list(
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
	 * Returns the first policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	@Override
	public Policy findByuserId_First(
			long userId, OrderByComparator<Policy> orderByComparator)
		throws NoSuchPolicyException {

		Policy policy = fetchByuserId_First(userId, orderByComparator);

		if (policy != null) {
			return policy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchPolicyException(sb.toString());
	}

	/**
	 * Returns the first policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public Policy fetchByuserId_First(
		long userId, OrderByComparator<Policy> orderByComparator) {

		List<Policy> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy
	 * @throws NoSuchPolicyException if a matching policy could not be found
	 */
	@Override
	public Policy findByuserId_Last(
			long userId, OrderByComparator<Policy> orderByComparator)
		throws NoSuchPolicyException {

		Policy policy = fetchByuserId_Last(userId, orderByComparator);

		if (policy != null) {
			return policy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchPolicyException(sb.toString());
	}

	/**
	 * Returns the last policy in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching policy, or <code>null</code> if a matching policy could not be found
	 */
	@Override
	public Policy fetchByuserId_Last(
		long userId, OrderByComparator<Policy> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Policy> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Policy[] findByuserId_PrevAndNext(
			PolicyPK policyPK, long userId,
			OrderByComparator<Policy> orderByComparator)
		throws NoSuchPolicyException {

		Policy policy = findByPrimaryKey(policyPK);

		Session session = null;

		try {
			session = openSession();

			Policy[] array = new PolicyImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, policy, userId, orderByComparator, true);

			array[1] = policy;

			array[2] = getByuserId_PrevAndNext(
				session, policy, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Policy getByuserId_PrevAndNext(
		Session session, Policy policy, long userId,
		OrderByComparator<Policy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_POLICY_WHERE);

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
			sb.append(PolicyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(policy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Policy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the policies where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Policy policy :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(policy);
		}
	}

	/**
	 * Returns the number of policies where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching policies
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_POLICY_WHERE);

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
		"policy.userId = ?";

	public PolicyPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Policy.class);

		setModelImplClass(PolicyImpl.class);
		setModelPKClass(PolicyPK.class);

		setTable(PolicyTable.INSTANCE);
	}

	/**
	 * Caches the policy in the entity cache if it is enabled.
	 *
	 * @param policy the policy
	 */
	@Override
	public void cacheResult(Policy policy) {
		entityCache.putResult(PolicyImpl.class, policy.getPrimaryKey(), policy);

		finderCache.putResult(
			_finderPathFetchByquoteId, new Object[] {policy.getQuoteId()},
			policy);

		finderCache.putResult(
			_finderPathFetchByapplicationNumber,
			new Object[] {policy.getApplicationNumber()}, policy);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the policies in the entity cache if it is enabled.
	 *
	 * @param policies the policies
	 */
	@Override
	public void cacheResult(List<Policy> policies) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (policies.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Policy policy : policies) {
			if (entityCache.getResult(
					PolicyImpl.class, policy.getPrimaryKey()) == null) {

				cacheResult(policy);
			}
		}
	}

	/**
	 * Clears the cache for all policies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PolicyImpl.class);

		finderCache.clearCache(PolicyImpl.class);
	}

	/**
	 * Clears the cache for the policy.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Policy policy) {
		entityCache.removeResult(PolicyImpl.class, policy);
	}

	@Override
	public void clearCache(List<Policy> policies) {
		for (Policy policy : policies) {
			entityCache.removeResult(PolicyImpl.class, policy);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PolicyImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PolicyImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(PolicyModelImpl policyModelImpl) {
		Object[] args = new Object[] {policyModelImpl.getQuoteId()};

		finderCache.putResult(_finderPathCountByquoteId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByquoteId, args, policyModelImpl);

		args = new Object[] {policyModelImpl.getApplicationNumber()};

		finderCache.putResult(
			_finderPathCountByapplicationNumber, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByapplicationNumber, args, policyModelImpl);
	}

	/**
	 * Creates a new policy with the primary key. Does not add the policy to the database.
	 *
	 * @param policyPK the primary key for the new policy
	 * @return the new policy
	 */
	@Override
	public Policy create(PolicyPK policyPK) {
		Policy policy = new PolicyImpl();

		policy.setNew(true);
		policy.setPrimaryKey(policyPK);

		String uuid = _portalUUID.generate();

		policy.setUuid(uuid);

		return policy;
	}

	/**
	 * Removes the policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy that was removed
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	@Override
	public Policy remove(PolicyPK policyPK) throws NoSuchPolicyException {
		return remove((Serializable)policyPK);
	}

	/**
	 * Removes the policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy
	 * @return the policy that was removed
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	@Override
	public Policy remove(Serializable primaryKey) throws NoSuchPolicyException {
		Session session = null;

		try {
			session = openSession();

			Policy policy = (Policy)session.get(PolicyImpl.class, primaryKey);

			if (policy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policy);
		}
		catch (NoSuchPolicyException noSuchEntityException) {
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
	protected Policy removeImpl(Policy policy) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policy)) {
				policy = (Policy)session.get(
					PolicyImpl.class, policy.getPrimaryKeyObj());
			}

			if (policy != null) {
				session.delete(policy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policy != null) {
			clearCache(policy);
		}

		return policy;
	}

	@Override
	public Policy updateImpl(Policy policy) {
		boolean isNew = policy.isNew();

		if (!(policy instanceof PolicyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(policy.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(policy);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in policy proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Policy implementation " +
					policy.getClass());
		}

		PolicyModelImpl policyModelImpl = (PolicyModelImpl)policy;

		if (Validator.isNull(policy.getUuid())) {
			String uuid = _portalUUID.generate();

			policy.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policy);
			}
			else {
				policy = (Policy)session.merge(policy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PolicyImpl.class, policyModelImpl, false, true);

		cacheUniqueFindersCache(policyModelImpl);

		if (isNew) {
			policy.setNew(false);
		}

		policy.resetOriginalValues();

		return policy;
	}

	/**
	 * Returns the policy with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy
	 * @return the policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	@Override
	public Policy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyException {

		Policy policy = fetchByPrimaryKey(primaryKey);

		if (policy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policy;
	}

	/**
	 * Returns the policy with the primary key or throws a <code>NoSuchPolicyException</code> if it could not be found.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy
	 * @throws NoSuchPolicyException if a policy with the primary key could not be found
	 */
	@Override
	public Policy findByPrimaryKey(PolicyPK policyPK)
		throws NoSuchPolicyException {

		return findByPrimaryKey((Serializable)policyPK);
	}

	/**
	 * Returns the policy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy, or <code>null</code> if a policy with the primary key could not be found
	 */
	@Override
	public Policy fetchByPrimaryKey(PolicyPK policyPK) {
		return fetchByPrimaryKey((Serializable)policyPK);
	}

	/**
	 * Returns all the policies.
	 *
	 * @return the policies
	 */
	@Override
	public List<Policy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Policy> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Policy> findAll(
		int start, int end, OrderByComparator<Policy> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Policy> findAll(
		int start, int end, OrderByComparator<Policy> orderByComparator,
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

		List<Policy> list = null;

		if (useFinderCache) {
			list = (List<Policy>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICY;

				sql = sql.concat(PolicyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Policy>)QueryUtil.list(
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
	 * Removes all the policies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Policy policy : findAll()) {
			remove(policy);
		}
	}

	/**
	 * Returns the number of policies.
	 *
	 * @return the number of policies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICY);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "policyPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy persistence.
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

		_finderPathFetchByquoteId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByquoteId",
			new String[] {String.class.getName()}, new String[] {"quoteId"},
			true);

		_finderPathCountByquoteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByquoteId",
			new String[] {String.class.getName()}, new String[] {"quoteId"},
			false);

		_finderPathFetchByapplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByapplicationNumber",
			new String[] {Long.class.getName()},
			new String[] {"applicationNumber"}, true);

		_finderPathCountByapplicationNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByapplicationNumber", new String[] {Long.class.getName()},
			new String[] {"applicationNumber"}, false);

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

		_setPolicyUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPolicyUtilPersistence(null);

		entityCache.removeCache(PolicyImpl.class.getName());
	}

	private void _setPolicyUtilPersistence(
		PolicyPersistence policyPersistence) {

		try {
			Field field = PolicyUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, policyPersistence);
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

	private static final String _SQL_SELECT_POLICY =
		"SELECT policy FROM Policy policy";

	private static final String _SQL_SELECT_POLICY_WHERE =
		"SELECT policy FROM Policy policy WHERE ";

	private static final String _SQL_COUNT_POLICY =
		"SELECT COUNT(policy) FROM Policy policy";

	private static final String _SQL_COUNT_POLICY_WHERE =
		"SELECT COUNT(policy) FROM Policy policy WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policy.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Policy exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Policy exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"bookingId", "applicationNumber", "quoteId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}