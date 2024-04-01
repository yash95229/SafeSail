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

import com.safesail.exception.NoSuchAadhaarVerificationException;
import com.safesail.model.AadhaarVerification;
import com.safesail.model.AadhaarVerificationTable;
import com.safesail.model.impl.AadhaarVerificationImpl;
import com.safesail.model.impl.AadhaarVerificationModelImpl;
import com.safesail.service.persistence.AadhaarVerificationPersistence;
import com.safesail.service.persistence.AadhaarVerificationUtil;
import com.safesail.service.persistence.impl.constants.Safe_SailPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the aadhaar verification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AadhaarVerificationPersistence.class)
public class AadhaarVerificationPersistenceImpl
	extends BasePersistenceImpl<AadhaarVerification>
	implements AadhaarVerificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AadhaarVerificationUtil</code> to access the aadhaar verification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AadhaarVerificationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByaadhaarNumber;
	private FinderPath _finderPathWithoutPaginationFindByaadhaarNumber;
	private FinderPath _finderPathCountByaadhaarNumber;

	/**
	 * Returns all the aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @return the matching aadhaar verifications
	 */
	@Override
	public List<AadhaarVerification> findByaadhaarNumber(String aadhaarNumber) {
		return findByaadhaarNumber(
			aadhaarNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end) {

		return findByaadhaarNumber(aadhaarNumber, start, end, null);
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
	@Override
	public List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		return findByaadhaarNumber(
			aadhaarNumber, start, end, orderByComparator, true);
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
	@Override
	public List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator,
		boolean useFinderCache) {

		aadhaarNumber = Objects.toString(aadhaarNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByaadhaarNumber;
				finderArgs = new Object[] {aadhaarNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByaadhaarNumber;
			finderArgs = new Object[] {
				aadhaarNumber, start, end, orderByComparator
			};
		}

		List<AadhaarVerification> list = null;

		if (useFinderCache) {
			list = (List<AadhaarVerification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AadhaarVerification aadhaarVerification : list) {
					if (!aadhaarNumber.equals(
							aadhaarVerification.getAadhaarNumber())) {

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

			sb.append(_SQL_SELECT_AADHAARVERIFICATION_WHERE);

			boolean bindAadhaarNumber = false;

			if (aadhaarNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_AADHAARNUMBER_AADHAARNUMBER_3);
			}
			else {
				bindAadhaarNumber = true;

				sb.append(_FINDER_COLUMN_AADHAARNUMBER_AADHAARNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AadhaarVerificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAadhaarNumber) {
					queryPos.add(aadhaarNumber);
				}

				list = (List<AadhaarVerification>)QueryUtil.list(
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
	 * Returns the first aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a matching aadhaar verification could not be found
	 */
	@Override
	public AadhaarVerification findByaadhaarNumber_First(
			String aadhaarNumber,
			OrderByComparator<AadhaarVerification> orderByComparator)
		throws NoSuchAadhaarVerificationException {

		AadhaarVerification aadhaarVerification = fetchByaadhaarNumber_First(
			aadhaarNumber, orderByComparator);

		if (aadhaarVerification != null) {
			return aadhaarVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("aadhaarNumber=");
		sb.append(aadhaarNumber);

		sb.append("}");

		throw new NoSuchAadhaarVerificationException(sb.toString());
	}

	/**
	 * Returns the first aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching aadhaar verification, or <code>null</code> if a matching aadhaar verification could not be found
	 */
	@Override
	public AadhaarVerification fetchByaadhaarNumber_First(
		String aadhaarNumber,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		List<AadhaarVerification> list = findByaadhaarNumber(
			aadhaarNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a matching aadhaar verification could not be found
	 */
	@Override
	public AadhaarVerification findByaadhaarNumber_Last(
			String aadhaarNumber,
			OrderByComparator<AadhaarVerification> orderByComparator)
		throws NoSuchAadhaarVerificationException {

		AadhaarVerification aadhaarVerification = fetchByaadhaarNumber_Last(
			aadhaarNumber, orderByComparator);

		if (aadhaarVerification != null) {
			return aadhaarVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("aadhaarNumber=");
		sb.append(aadhaarNumber);

		sb.append("}");

		throw new NoSuchAadhaarVerificationException(sb.toString());
	}

	/**
	 * Returns the last aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching aadhaar verification, or <code>null</code> if a matching aadhaar verification could not be found
	 */
	@Override
	public AadhaarVerification fetchByaadhaarNumber_Last(
		String aadhaarNumber,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		int count = countByaadhaarNumber(aadhaarNumber);

		if (count == 0) {
			return null;
		}

		List<AadhaarVerification> list = findByaadhaarNumber(
			aadhaarNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AadhaarVerification[] findByaadhaarNumber_PrevAndNext(
			long aadhaarId, String aadhaarNumber,
			OrderByComparator<AadhaarVerification> orderByComparator)
		throws NoSuchAadhaarVerificationException {

		aadhaarNumber = Objects.toString(aadhaarNumber, "");

		AadhaarVerification aadhaarVerification = findByPrimaryKey(aadhaarId);

		Session session = null;

		try {
			session = openSession();

			AadhaarVerification[] array = new AadhaarVerificationImpl[3];

			array[0] = getByaadhaarNumber_PrevAndNext(
				session, aadhaarVerification, aadhaarNumber, orderByComparator,
				true);

			array[1] = aadhaarVerification;

			array[2] = getByaadhaarNumber_PrevAndNext(
				session, aadhaarVerification, aadhaarNumber, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AadhaarVerification getByaadhaarNumber_PrevAndNext(
		Session session, AadhaarVerification aadhaarVerification,
		String aadhaarNumber,
		OrderByComparator<AadhaarVerification> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AADHAARVERIFICATION_WHERE);

		boolean bindAadhaarNumber = false;

		if (aadhaarNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_AADHAARNUMBER_AADHAARNUMBER_3);
		}
		else {
			bindAadhaarNumber = true;

			sb.append(_FINDER_COLUMN_AADHAARNUMBER_AADHAARNUMBER_2);
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
			sb.append(AadhaarVerificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAadhaarNumber) {
			queryPos.add(aadhaarNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						aadhaarVerification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AadhaarVerification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the aadhaar verifications where aadhaarNumber = &#63; from the database.
	 *
	 * @param aadhaarNumber the aadhaar number
	 */
	@Override
	public void removeByaadhaarNumber(String aadhaarNumber) {
		for (AadhaarVerification aadhaarVerification :
				findByaadhaarNumber(
					aadhaarNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(aadhaarVerification);
		}
	}

	/**
	 * Returns the number of aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @return the number of matching aadhaar verifications
	 */
	@Override
	public int countByaadhaarNumber(String aadhaarNumber) {
		aadhaarNumber = Objects.toString(aadhaarNumber, "");

		FinderPath finderPath = _finderPathCountByaadhaarNumber;

		Object[] finderArgs = new Object[] {aadhaarNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AADHAARVERIFICATION_WHERE);

			boolean bindAadhaarNumber = false;

			if (aadhaarNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_AADHAARNUMBER_AADHAARNUMBER_3);
			}
			else {
				bindAadhaarNumber = true;

				sb.append(_FINDER_COLUMN_AADHAARNUMBER_AADHAARNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAadhaarNumber) {
					queryPos.add(aadhaarNumber);
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

	private static final String _FINDER_COLUMN_AADHAARNUMBER_AADHAARNUMBER_2 =
		"aadhaarVerification.aadhaarNumber = ?";

	private static final String _FINDER_COLUMN_AADHAARNUMBER_AADHAARNUMBER_3 =
		"(aadhaarVerification.aadhaarNumber IS NULL OR aadhaarVerification.aadhaarNumber = '')";

	public AadhaarVerificationPersistenceImpl() {
		setModelClass(AadhaarVerification.class);

		setModelImplClass(AadhaarVerificationImpl.class);
		setModelPKClass(long.class);

		setTable(AadhaarVerificationTable.INSTANCE);
	}

	/**
	 * Caches the aadhaar verification in the entity cache if it is enabled.
	 *
	 * @param aadhaarVerification the aadhaar verification
	 */
	@Override
	public void cacheResult(AadhaarVerification aadhaarVerification) {
		entityCache.putResult(
			AadhaarVerificationImpl.class, aadhaarVerification.getPrimaryKey(),
			aadhaarVerification);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the aadhaar verifications in the entity cache if it is enabled.
	 *
	 * @param aadhaarVerifications the aadhaar verifications
	 */
	@Override
	public void cacheResult(List<AadhaarVerification> aadhaarVerifications) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (aadhaarVerifications.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AadhaarVerification aadhaarVerification : aadhaarVerifications) {
			if (entityCache.getResult(
					AadhaarVerificationImpl.class,
					aadhaarVerification.getPrimaryKey()) == null) {

				cacheResult(aadhaarVerification);
			}
		}
	}

	/**
	 * Clears the cache for all aadhaar verifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AadhaarVerificationImpl.class);

		finderCache.clearCache(AadhaarVerificationImpl.class);
	}

	/**
	 * Clears the cache for the aadhaar verification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AadhaarVerification aadhaarVerification) {
		entityCache.removeResult(
			AadhaarVerificationImpl.class, aadhaarVerification);
	}

	@Override
	public void clearCache(List<AadhaarVerification> aadhaarVerifications) {
		for (AadhaarVerification aadhaarVerification : aadhaarVerifications) {
			entityCache.removeResult(
				AadhaarVerificationImpl.class, aadhaarVerification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AadhaarVerificationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AadhaarVerificationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new aadhaar verification with the primary key. Does not add the aadhaar verification to the database.
	 *
	 * @param aadhaarId the primary key for the new aadhaar verification
	 * @return the new aadhaar verification
	 */
	@Override
	public AadhaarVerification create(long aadhaarId) {
		AadhaarVerification aadhaarVerification = new AadhaarVerificationImpl();

		aadhaarVerification.setNew(true);
		aadhaarVerification.setPrimaryKey(aadhaarId);

		return aadhaarVerification;
	}

	/**
	 * Removes the aadhaar verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification that was removed
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	@Override
	public AadhaarVerification remove(long aadhaarId)
		throws NoSuchAadhaarVerificationException {

		return remove((Serializable)aadhaarId);
	}

	/**
	 * Removes the aadhaar verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the aadhaar verification
	 * @return the aadhaar verification that was removed
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	@Override
	public AadhaarVerification remove(Serializable primaryKey)
		throws NoSuchAadhaarVerificationException {

		Session session = null;

		try {
			session = openSession();

			AadhaarVerification aadhaarVerification =
				(AadhaarVerification)session.get(
					AadhaarVerificationImpl.class, primaryKey);

			if (aadhaarVerification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAadhaarVerificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(aadhaarVerification);
		}
		catch (NoSuchAadhaarVerificationException noSuchEntityException) {
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
	protected AadhaarVerification removeImpl(
		AadhaarVerification aadhaarVerification) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(aadhaarVerification)) {
				aadhaarVerification = (AadhaarVerification)session.get(
					AadhaarVerificationImpl.class,
					aadhaarVerification.getPrimaryKeyObj());
			}

			if (aadhaarVerification != null) {
				session.delete(aadhaarVerification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (aadhaarVerification != null) {
			clearCache(aadhaarVerification);
		}

		return aadhaarVerification;
	}

	@Override
	public AadhaarVerification updateImpl(
		AadhaarVerification aadhaarVerification) {

		boolean isNew = aadhaarVerification.isNew();

		if (!(aadhaarVerification instanceof AadhaarVerificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(aadhaarVerification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					aadhaarVerification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in aadhaarVerification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AadhaarVerification implementation " +
					aadhaarVerification.getClass());
		}

		AadhaarVerificationModelImpl aadhaarVerificationModelImpl =
			(AadhaarVerificationModelImpl)aadhaarVerification;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(aadhaarVerification);
			}
			else {
				aadhaarVerification = (AadhaarVerification)session.merge(
					aadhaarVerification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AadhaarVerificationImpl.class, aadhaarVerificationModelImpl, false,
			true);

		if (isNew) {
			aadhaarVerification.setNew(false);
		}

		aadhaarVerification.resetOriginalValues();

		return aadhaarVerification;
	}

	/**
	 * Returns the aadhaar verification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the aadhaar verification
	 * @return the aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	@Override
	public AadhaarVerification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAadhaarVerificationException {

		AadhaarVerification aadhaarVerification = fetchByPrimaryKey(primaryKey);

		if (aadhaarVerification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAadhaarVerificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return aadhaarVerification;
	}

	/**
	 * Returns the aadhaar verification with the primary key or throws a <code>NoSuchAadhaarVerificationException</code> if it could not be found.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	@Override
	public AadhaarVerification findByPrimaryKey(long aadhaarId)
		throws NoSuchAadhaarVerificationException {

		return findByPrimaryKey((Serializable)aadhaarId);
	}

	/**
	 * Returns the aadhaar verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification, or <code>null</code> if a aadhaar verification with the primary key could not be found
	 */
	@Override
	public AadhaarVerification fetchByPrimaryKey(long aadhaarId) {
		return fetchByPrimaryKey((Serializable)aadhaarId);
	}

	/**
	 * Returns all the aadhaar verifications.
	 *
	 * @return the aadhaar verifications
	 */
	@Override
	public List<AadhaarVerification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AadhaarVerification> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AadhaarVerification> findAll(
		int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AadhaarVerification> findAll(
		int start, int end,
		OrderByComparator<AadhaarVerification> orderByComparator,
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

		List<AadhaarVerification> list = null;

		if (useFinderCache) {
			list = (List<AadhaarVerification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AADHAARVERIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AADHAARVERIFICATION;

				sql = sql.concat(AadhaarVerificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AadhaarVerification>)QueryUtil.list(
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
	 * Removes all the aadhaar verifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AadhaarVerification aadhaarVerification : findAll()) {
			remove(aadhaarVerification);
		}
	}

	/**
	 * Returns the number of aadhaar verifications.
	 *
	 * @return the number of aadhaar verifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_AADHAARVERIFICATION);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "aadhaarId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AADHAARVERIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AadhaarVerificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the aadhaar verification persistence.
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

		_finderPathWithPaginationFindByaadhaarNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByaadhaarNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"aadhaarNumber"}, true);

		_finderPathWithoutPaginationFindByaadhaarNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByaadhaarNumber",
			new String[] {String.class.getName()},
			new String[] {"aadhaarNumber"}, true);

		_finderPathCountByaadhaarNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByaadhaarNumber",
			new String[] {String.class.getName()},
			new String[] {"aadhaarNumber"}, false);

		_setAadhaarVerificationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAadhaarVerificationUtilPersistence(null);

		entityCache.removeCache(AadhaarVerificationImpl.class.getName());
	}

	private void _setAadhaarVerificationUtilPersistence(
		AadhaarVerificationPersistence aadhaarVerificationPersistence) {

		try {
			Field field = AadhaarVerificationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, aadhaarVerificationPersistence);
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

	private static final String _SQL_SELECT_AADHAARVERIFICATION =
		"SELECT aadhaarVerification FROM AadhaarVerification aadhaarVerification";

	private static final String _SQL_SELECT_AADHAARVERIFICATION_WHERE =
		"SELECT aadhaarVerification FROM AadhaarVerification aadhaarVerification WHERE ";

	private static final String _SQL_COUNT_AADHAARVERIFICATION =
		"SELECT COUNT(aadhaarVerification) FROM AadhaarVerification aadhaarVerification";

	private static final String _SQL_COUNT_AADHAARVERIFICATION_WHERE =
		"SELECT COUNT(aadhaarVerification) FROM AadhaarVerification aadhaarVerification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "aadhaarVerification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AadhaarVerification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AadhaarVerification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AadhaarVerificationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}