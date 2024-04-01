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

import com.safesail.exception.NoSuchPanCardVerificationException;
import com.safesail.model.PanCardVerification;
import com.safesail.model.PanCardVerificationTable;
import com.safesail.model.impl.PanCardVerificationImpl;
import com.safesail.model.impl.PanCardVerificationModelImpl;
import com.safesail.service.persistence.PanCardVerificationPersistence;
import com.safesail.service.persistence.PanCardVerificationUtil;
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
 * The persistence implementation for the pan card verification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PanCardVerificationPersistence.class)
public class PanCardVerificationPersistenceImpl
	extends BasePersistenceImpl<PanCardVerification>
	implements PanCardVerificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PanCardVerificationUtil</code> to access the pan card verification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PanCardVerificationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBypanNumber;
	private FinderPath _finderPathWithoutPaginationFindBypanNumber;
	private FinderPath _finderPathCountBypanNumber;

	/**
	 * Returns all the pan card verifications where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @return the matching pan card verifications
	 */
	@Override
	public List<PanCardVerification> findBypanNumber(String panNumber) {
		return findBypanNumber(
			panNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pan card verifications where panNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param panNumber the pan number
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @return the range of matching pan card verifications
	 */
	@Override
	public List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end) {

		return findBypanNumber(panNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pan card verifications where panNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param panNumber the pan number
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pan card verifications
	 */
	@Override
	public List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator) {

		return findBypanNumber(panNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pan card verifications where panNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param panNumber the pan number
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching pan card verifications
	 */
	@Override
	public List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator,
		boolean useFinderCache) {

		panNumber = Objects.toString(panNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypanNumber;
				finderArgs = new Object[] {panNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypanNumber;
			finderArgs = new Object[] {
				panNumber, start, end, orderByComparator
			};
		}

		List<PanCardVerification> list = null;

		if (useFinderCache) {
			list = (List<PanCardVerification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PanCardVerification panCardVerification : list) {
					if (!panNumber.equals(panCardVerification.getPanNumber())) {
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

			sb.append(_SQL_SELECT_PANCARDVERIFICATION_WHERE);

			boolean bindPanNumber = false;

			if (panNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_PANNUMBER_PANNUMBER_3);
			}
			else {
				bindPanNumber = true;

				sb.append(_FINDER_COLUMN_PANNUMBER_PANNUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PanCardVerificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPanNumber) {
					queryPos.add(panNumber);
				}

				list = (List<PanCardVerification>)QueryUtil.list(
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
	 * Returns the first pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pan card verification
	 * @throws NoSuchPanCardVerificationException if a matching pan card verification could not be found
	 */
	@Override
	public PanCardVerification findBypanNumber_First(
			String panNumber,
			OrderByComparator<PanCardVerification> orderByComparator)
		throws NoSuchPanCardVerificationException {

		PanCardVerification panCardVerification = fetchBypanNumber_First(
			panNumber, orderByComparator);

		if (panCardVerification != null) {
			return panCardVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("panNumber=");
		sb.append(panNumber);

		sb.append("}");

		throw new NoSuchPanCardVerificationException(sb.toString());
	}

	/**
	 * Returns the first pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pan card verification, or <code>null</code> if a matching pan card verification could not be found
	 */
	@Override
	public PanCardVerification fetchBypanNumber_First(
		String panNumber,
		OrderByComparator<PanCardVerification> orderByComparator) {

		List<PanCardVerification> list = findBypanNumber(
			panNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pan card verification
	 * @throws NoSuchPanCardVerificationException if a matching pan card verification could not be found
	 */
	@Override
	public PanCardVerification findBypanNumber_Last(
			String panNumber,
			OrderByComparator<PanCardVerification> orderByComparator)
		throws NoSuchPanCardVerificationException {

		PanCardVerification panCardVerification = fetchBypanNumber_Last(
			panNumber, orderByComparator);

		if (panCardVerification != null) {
			return panCardVerification;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("panNumber=");
		sb.append(panNumber);

		sb.append("}");

		throw new NoSuchPanCardVerificationException(sb.toString());
	}

	/**
	 * Returns the last pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pan card verification, or <code>null</code> if a matching pan card verification could not be found
	 */
	@Override
	public PanCardVerification fetchBypanNumber_Last(
		String panNumber,
		OrderByComparator<PanCardVerification> orderByComparator) {

		int count = countBypanNumber(panNumber);

		if (count == 0) {
			return null;
		}

		List<PanCardVerification> list = findBypanNumber(
			panNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pan card verifications before and after the current pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panId the primary key of the current pan card verification
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pan card verification
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	@Override
	public PanCardVerification[] findBypanNumber_PrevAndNext(
			long panId, String panNumber,
			OrderByComparator<PanCardVerification> orderByComparator)
		throws NoSuchPanCardVerificationException {

		panNumber = Objects.toString(panNumber, "");

		PanCardVerification panCardVerification = findByPrimaryKey(panId);

		Session session = null;

		try {
			session = openSession();

			PanCardVerification[] array = new PanCardVerificationImpl[3];

			array[0] = getBypanNumber_PrevAndNext(
				session, panCardVerification, panNumber, orderByComparator,
				true);

			array[1] = panCardVerification;

			array[2] = getBypanNumber_PrevAndNext(
				session, panCardVerification, panNumber, orderByComparator,
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

	protected PanCardVerification getBypanNumber_PrevAndNext(
		Session session, PanCardVerification panCardVerification,
		String panNumber,
		OrderByComparator<PanCardVerification> orderByComparator,
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

		sb.append(_SQL_SELECT_PANCARDVERIFICATION_WHERE);

		boolean bindPanNumber = false;

		if (panNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_PANNUMBER_PANNUMBER_3);
		}
		else {
			bindPanNumber = true;

			sb.append(_FINDER_COLUMN_PANNUMBER_PANNUMBER_2);
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
			sb.append(PanCardVerificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPanNumber) {
			queryPos.add(panNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						panCardVerification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PanCardVerification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pan card verifications where panNumber = &#63; from the database.
	 *
	 * @param panNumber the pan number
	 */
	@Override
	public void removeBypanNumber(String panNumber) {
		for (PanCardVerification panCardVerification :
				findBypanNumber(
					panNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(panCardVerification);
		}
	}

	/**
	 * Returns the number of pan card verifications where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @return the number of matching pan card verifications
	 */
	@Override
	public int countBypanNumber(String panNumber) {
		panNumber = Objects.toString(panNumber, "");

		FinderPath finderPath = _finderPathCountBypanNumber;

		Object[] finderArgs = new Object[] {panNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PANCARDVERIFICATION_WHERE);

			boolean bindPanNumber = false;

			if (panNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_PANNUMBER_PANNUMBER_3);
			}
			else {
				bindPanNumber = true;

				sb.append(_FINDER_COLUMN_PANNUMBER_PANNUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPanNumber) {
					queryPos.add(panNumber);
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

	private static final String _FINDER_COLUMN_PANNUMBER_PANNUMBER_2 =
		"panCardVerification.panNumber = ?";

	private static final String _FINDER_COLUMN_PANNUMBER_PANNUMBER_3 =
		"(panCardVerification.panNumber IS NULL OR panCardVerification.panNumber = '')";

	public PanCardVerificationPersistenceImpl() {
		setModelClass(PanCardVerification.class);

		setModelImplClass(PanCardVerificationImpl.class);
		setModelPKClass(long.class);

		setTable(PanCardVerificationTable.INSTANCE);
	}

	/**
	 * Caches the pan card verification in the entity cache if it is enabled.
	 *
	 * @param panCardVerification the pan card verification
	 */
	@Override
	public void cacheResult(PanCardVerification panCardVerification) {
		entityCache.putResult(
			PanCardVerificationImpl.class, panCardVerification.getPrimaryKey(),
			panCardVerification);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the pan card verifications in the entity cache if it is enabled.
	 *
	 * @param panCardVerifications the pan card verifications
	 */
	@Override
	public void cacheResult(List<PanCardVerification> panCardVerifications) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (panCardVerifications.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PanCardVerification panCardVerification : panCardVerifications) {
			if (entityCache.getResult(
					PanCardVerificationImpl.class,
					panCardVerification.getPrimaryKey()) == null) {

				cacheResult(panCardVerification);
			}
		}
	}

	/**
	 * Clears the cache for all pan card verifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PanCardVerificationImpl.class);

		finderCache.clearCache(PanCardVerificationImpl.class);
	}

	/**
	 * Clears the cache for the pan card verification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PanCardVerification panCardVerification) {
		entityCache.removeResult(
			PanCardVerificationImpl.class, panCardVerification);
	}

	@Override
	public void clearCache(List<PanCardVerification> panCardVerifications) {
		for (PanCardVerification panCardVerification : panCardVerifications) {
			entityCache.removeResult(
				PanCardVerificationImpl.class, panCardVerification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PanCardVerificationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PanCardVerificationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pan card verification with the primary key. Does not add the pan card verification to the database.
	 *
	 * @param panId the primary key for the new pan card verification
	 * @return the new pan card verification
	 */
	@Override
	public PanCardVerification create(long panId) {
		PanCardVerification panCardVerification = new PanCardVerificationImpl();

		panCardVerification.setNew(true);
		panCardVerification.setPrimaryKey(panId);

		return panCardVerification;
	}

	/**
	 * Removes the pan card verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification that was removed
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	@Override
	public PanCardVerification remove(long panId)
		throws NoSuchPanCardVerificationException {

		return remove((Serializable)panId);
	}

	/**
	 * Removes the pan card verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pan card verification
	 * @return the pan card verification that was removed
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	@Override
	public PanCardVerification remove(Serializable primaryKey)
		throws NoSuchPanCardVerificationException {

		Session session = null;

		try {
			session = openSession();

			PanCardVerification panCardVerification =
				(PanCardVerification)session.get(
					PanCardVerificationImpl.class, primaryKey);

			if (panCardVerification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPanCardVerificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(panCardVerification);
		}
		catch (NoSuchPanCardVerificationException noSuchEntityException) {
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
	protected PanCardVerification removeImpl(
		PanCardVerification panCardVerification) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(panCardVerification)) {
				panCardVerification = (PanCardVerification)session.get(
					PanCardVerificationImpl.class,
					panCardVerification.getPrimaryKeyObj());
			}

			if (panCardVerification != null) {
				session.delete(panCardVerification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (panCardVerification != null) {
			clearCache(panCardVerification);
		}

		return panCardVerification;
	}

	@Override
	public PanCardVerification updateImpl(
		PanCardVerification panCardVerification) {

		boolean isNew = panCardVerification.isNew();

		if (!(panCardVerification instanceof PanCardVerificationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(panCardVerification.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					panCardVerification);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in panCardVerification proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PanCardVerification implementation " +
					panCardVerification.getClass());
		}

		PanCardVerificationModelImpl panCardVerificationModelImpl =
			(PanCardVerificationModelImpl)panCardVerification;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(panCardVerification);
			}
			else {
				panCardVerification = (PanCardVerification)session.merge(
					panCardVerification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PanCardVerificationImpl.class, panCardVerificationModelImpl, false,
			true);

		if (isNew) {
			panCardVerification.setNew(false);
		}

		panCardVerification.resetOriginalValues();

		return panCardVerification;
	}

	/**
	 * Returns the pan card verification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pan card verification
	 * @return the pan card verification
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	@Override
	public PanCardVerification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPanCardVerificationException {

		PanCardVerification panCardVerification = fetchByPrimaryKey(primaryKey);

		if (panCardVerification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPanCardVerificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return panCardVerification;
	}

	/**
	 * Returns the pan card verification with the primary key or throws a <code>NoSuchPanCardVerificationException</code> if it could not be found.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	@Override
	public PanCardVerification findByPrimaryKey(long panId)
		throws NoSuchPanCardVerificationException {

		return findByPrimaryKey((Serializable)panId);
	}

	/**
	 * Returns the pan card verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification, or <code>null</code> if a pan card verification with the primary key could not be found
	 */
	@Override
	public PanCardVerification fetchByPrimaryKey(long panId) {
		return fetchByPrimaryKey((Serializable)panId);
	}

	/**
	 * Returns all the pan card verifications.
	 *
	 * @return the pan card verifications
	 */
	@Override
	public List<PanCardVerification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pan card verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @return the range of pan card verifications
	 */
	@Override
	public List<PanCardVerification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pan card verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pan card verifications
	 */
	@Override
	public List<PanCardVerification> findAll(
		int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pan card verifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PanCardVerificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pan card verifications
	 * @param end the upper bound of the range of pan card verifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pan card verifications
	 */
	@Override
	public List<PanCardVerification> findAll(
		int start, int end,
		OrderByComparator<PanCardVerification> orderByComparator,
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

		List<PanCardVerification> list = null;

		if (useFinderCache) {
			list = (List<PanCardVerification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PANCARDVERIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PANCARDVERIFICATION;

				sql = sql.concat(PanCardVerificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PanCardVerification>)QueryUtil.list(
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
	 * Removes all the pan card verifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PanCardVerification panCardVerification : findAll()) {
			remove(panCardVerification);
		}
	}

	/**
	 * Returns the number of pan card verifications.
	 *
	 * @return the number of pan card verifications
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
					_SQL_COUNT_PANCARDVERIFICATION);

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
		return "panId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PANCARDVERIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PanCardVerificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pan card verification persistence.
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

		_finderPathWithPaginationFindBypanNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypanNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"panNumber"}, true);

		_finderPathWithoutPaginationFindBypanNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypanNumber",
			new String[] {String.class.getName()}, new String[] {"panNumber"},
			true);

		_finderPathCountBypanNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypanNumber",
			new String[] {String.class.getName()}, new String[] {"panNumber"},
			false);

		_setPanCardVerificationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPanCardVerificationUtilPersistence(null);

		entityCache.removeCache(PanCardVerificationImpl.class.getName());
	}

	private void _setPanCardVerificationUtilPersistence(
		PanCardVerificationPersistence panCardVerificationPersistence) {

		try {
			Field field = PanCardVerificationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, panCardVerificationPersistence);
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

	private static final String _SQL_SELECT_PANCARDVERIFICATION =
		"SELECT panCardVerification FROM PanCardVerification panCardVerification";

	private static final String _SQL_SELECT_PANCARDVERIFICATION_WHERE =
		"SELECT panCardVerification FROM PanCardVerification panCardVerification WHERE ";

	private static final String _SQL_COUNT_PANCARDVERIFICATION =
		"SELECT COUNT(panCardVerification) FROM PanCardVerification panCardVerification";

	private static final String _SQL_COUNT_PANCARDVERIFICATION_WHERE =
		"SELECT COUNT(panCardVerification) FROM PanCardVerification panCardVerification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "panCardVerification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PanCardVerification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PanCardVerification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PanCardVerificationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}