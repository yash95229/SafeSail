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

import com.safesail.exception.NoSuchProductTableException;
import com.safesail.model.ProductTable;
import com.safesail.model.ProductTableTable;
import com.safesail.model.impl.ProductTableImpl;
import com.safesail.model.impl.ProductTableModelImpl;
import com.safesail.service.persistence.ProductTablePersistence;
import com.safesail.service.persistence.ProductTableUtil;
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
 * The persistence implementation for the product table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductTablePersistence.class)
public class ProductTablePersistenceImpl
	extends BasePersistenceImpl<ProductTable>
	implements ProductTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductTableUtil</code> to access the product table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductTableImpl.class.getName();

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
	 * Returns all the product tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching product tables
	 */
	@Override
	public List<ProductTable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @return the range of matching product tables
	 */
	@Override
	public List<ProductTable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product tables
	 */
	@Override
	public List<ProductTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductTable> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product tables
	 */
	@Override
	public List<ProductTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductTable> orderByComparator,
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

		List<ProductTable> list = null;

		if (useFinderCache) {
			list = (List<ProductTable>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductTable productTable : list) {
					if (!uuid.equals(productTable.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTTABLE_WHERE);

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
				sb.append(ProductTableModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductTable>)QueryUtil.list(
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
	 * Returns the first product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	@Override
	public ProductTable findByUuid_First(
			String uuid, OrderByComparator<ProductTable> orderByComparator)
		throws NoSuchProductTableException {

		ProductTable productTable = fetchByUuid_First(uuid, orderByComparator);

		if (productTable != null) {
			return productTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductTableException(sb.toString());
	}

	/**
	 * Returns the first product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product table, or <code>null</code> if a matching product table could not be found
	 */
	@Override
	public ProductTable fetchByUuid_First(
		String uuid, OrderByComparator<ProductTable> orderByComparator) {

		List<ProductTable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	@Override
	public ProductTable findByUuid_Last(
			String uuid, OrderByComparator<ProductTable> orderByComparator)
		throws NoSuchProductTableException {

		ProductTable productTable = fetchByUuid_Last(uuid, orderByComparator);

		if (productTable != null) {
			return productTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductTableException(sb.toString());
	}

	/**
	 * Returns the last product table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product table, or <code>null</code> if a matching product table could not be found
	 */
	@Override
	public ProductTable fetchByUuid_Last(
		String uuid, OrderByComparator<ProductTable> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductTable> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product tables before and after the current product table in the ordered set where uuid = &#63;.
	 *
	 * @param productId the primary key of the current product table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product table
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	@Override
	public ProductTable[] findByUuid_PrevAndNext(
			long productId, String uuid,
			OrderByComparator<ProductTable> orderByComparator)
		throws NoSuchProductTableException {

		uuid = Objects.toString(uuid, "");

		ProductTable productTable = findByPrimaryKey(productId);

		Session session = null;

		try {
			session = openSession();

			ProductTable[] array = new ProductTableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productTable, uuid, orderByComparator, true);

			array[1] = productTable;

			array[2] = getByUuid_PrevAndNext(
				session, productTable, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductTable getByUuid_PrevAndNext(
		Session session, ProductTable productTable, String uuid,
		OrderByComparator<ProductTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTTABLE_WHERE);

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
			sb.append(ProductTableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(productTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductTable productTable :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productTable);
		}
	}

	/**
	 * Returns the number of product tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching product tables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTTABLE_WHERE);

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
		"productTable.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productTable.uuid IS NULL OR productTable.uuid = '')";

	private FinderPath _finderPathFetchByproductId;
	private FinderPath _finderPathCountByproductId;

	/**
	 * Returns the product table where productId = &#63; or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productId the product ID
	 * @return the matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	@Override
	public ProductTable findByproductId(long productId)
		throws NoSuchProductTableException {

		ProductTable productTable = fetchByproductId(productId);

		if (productTable == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("productId=");
			sb.append(productId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductTableException(sb.toString());
		}

		return productTable;
	}

	/**
	 * Returns the product table where productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productId the product ID
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	@Override
	public ProductTable fetchByproductId(long productId) {
		return fetchByproductId(productId, true);
	}

	/**
	 * Returns the product table where productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productId the product ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	@Override
	public ProductTable fetchByproductId(
		long productId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {productId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByproductId, finderArgs, this);
		}

		if (result instanceof ProductTable) {
			ProductTable productTable = (ProductTable)result;

			if (productId != productTable.getProductId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PRODUCTTABLE_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productId);

				List<ProductTable> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByproductId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {productId};
							}

							_log.warn(
								"ProductTablePersistenceImpl.fetchByproductId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductTable productTable = list.get(0);

					result = productTable;

					cacheResult(productTable);
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
			return (ProductTable)result;
		}
	}

	/**
	 * Removes the product table where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @return the product table that was removed
	 */
	@Override
	public ProductTable removeByproductId(long productId)
		throws NoSuchProductTableException {

		ProductTable productTable = findByproductId(productId);

		return remove(productTable);
	}

	/**
	 * Returns the number of product tables where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching product tables
	 */
	@Override
	public int countByproductId(long productId) {
		FinderPath finderPath = _finderPathCountByproductId;

		Object[] finderArgs = new Object[] {productId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTTABLE_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTID_PRODUCTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productId);

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

	private static final String _FINDER_COLUMN_PRODUCTID_PRODUCTID_2 =
		"productTable.productId = ?";

	private FinderPath _finderPathFetchByproductName;
	private FinderPath _finderPathCountByproductName;

	/**
	 * Returns the product table where productName = &#63; or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productName the product name
	 * @return the matching product table
	 * @throws NoSuchProductTableException if a matching product table could not be found
	 */
	@Override
	public ProductTable findByproductName(String productName)
		throws NoSuchProductTableException {

		ProductTable productTable = fetchByproductName(productName);

		if (productTable == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("productName=");
			sb.append(productName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductTableException(sb.toString());
		}

		return productTable;
	}

	/**
	 * Returns the product table where productName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productName the product name
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	@Override
	public ProductTable fetchByproductName(String productName) {
		return fetchByproductName(productName, true);
	}

	/**
	 * Returns the product table where productName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productName the product name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product table, or <code>null</code> if a matching product table could not be found
	 */
	@Override
	public ProductTable fetchByproductName(
		String productName, boolean useFinderCache) {

		productName = Objects.toString(productName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {productName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByproductName, finderArgs, this);
		}

		if (result instanceof ProductTable) {
			ProductTable productTable = (ProductTable)result;

			if (!Objects.equals(productName, productTable.getProductName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PRODUCTTABLE_WHERE);

			boolean bindProductName = false;

			if (productName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3);
			}
			else {
				bindProductName = true;

				sb.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProductName) {
					queryPos.add(productName);
				}

				List<ProductTable> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByproductName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {productName};
							}

							_log.warn(
								"ProductTablePersistenceImpl.fetchByproductName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductTable productTable = list.get(0);

					result = productTable;

					cacheResult(productTable);
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
			return (ProductTable)result;
		}
	}

	/**
	 * Removes the product table where productName = &#63; from the database.
	 *
	 * @param productName the product name
	 * @return the product table that was removed
	 */
	@Override
	public ProductTable removeByproductName(String productName)
		throws NoSuchProductTableException {

		ProductTable productTable = findByproductName(productName);

		return remove(productTable);
	}

	/**
	 * Returns the number of product tables where productName = &#63;.
	 *
	 * @param productName the product name
	 * @return the number of matching product tables
	 */
	@Override
	public int countByproductName(String productName) {
		productName = Objects.toString(productName, "");

		FinderPath finderPath = _finderPathCountByproductName;

		Object[] finderArgs = new Object[] {productName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTTABLE_WHERE);

			boolean bindProductName = false;

			if (productName.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3);
			}
			else {
				bindProductName = true;

				sb.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProductName) {
					queryPos.add(productName);
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

	private static final String _FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2 =
		"productTable.productName = ?";

	private static final String _FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3 =
		"(productTable.productName IS NULL OR productTable.productName = '')";

	public ProductTablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductTable.class);

		setModelImplClass(ProductTableImpl.class);
		setModelPKClass(long.class);

		setTable(ProductTableTable.INSTANCE);
	}

	/**
	 * Caches the product table in the entity cache if it is enabled.
	 *
	 * @param productTable the product table
	 */
	@Override
	public void cacheResult(ProductTable productTable) {
		entityCache.putResult(
			ProductTableImpl.class, productTable.getPrimaryKey(), productTable);

		finderCache.putResult(
			_finderPathFetchByproductId,
			new Object[] {productTable.getProductId()}, productTable);

		finderCache.putResult(
			_finderPathFetchByproductName,
			new Object[] {productTable.getProductName()}, productTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the product tables in the entity cache if it is enabled.
	 *
	 * @param productTables the product tables
	 */
	@Override
	public void cacheResult(List<ProductTable> productTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductTable productTable : productTables) {
			if (entityCache.getResult(
					ProductTableImpl.class, productTable.getPrimaryKey()) ==
						null) {

				cacheResult(productTable);
			}
		}
	}

	/**
	 * Clears the cache for all product tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductTableImpl.class);

		finderCache.clearCache(ProductTableImpl.class);
	}

	/**
	 * Clears the cache for the product table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductTable productTable) {
		entityCache.removeResult(ProductTableImpl.class, productTable);
	}

	@Override
	public void clearCache(List<ProductTable> productTables) {
		for (ProductTable productTable : productTables) {
			entityCache.removeResult(ProductTableImpl.class, productTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProductTableImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductTableModelImpl productTableModelImpl) {

		Object[] args = new Object[] {productTableModelImpl.getProductId()};

		finderCache.putResult(
			_finderPathCountByproductId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByproductId, args, productTableModelImpl);

		args = new Object[] {productTableModelImpl.getProductName()};

		finderCache.putResult(
			_finderPathCountByproductName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByproductName, args, productTableModelImpl);
	}

	/**
	 * Creates a new product table with the primary key. Does not add the product table to the database.
	 *
	 * @param productId the primary key for the new product table
	 * @return the new product table
	 */
	@Override
	public ProductTable create(long productId) {
		ProductTable productTable = new ProductTableImpl();

		productTable.setNew(true);
		productTable.setPrimaryKey(productId);

		String uuid = _portalUUID.generate();

		productTable.setUuid(uuid);

		return productTable;
	}

	/**
	 * Removes the product table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table that was removed
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	@Override
	public ProductTable remove(long productId)
		throws NoSuchProductTableException {

		return remove((Serializable)productId);
	}

	/**
	 * Removes the product table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product table
	 * @return the product table that was removed
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	@Override
	public ProductTable remove(Serializable primaryKey)
		throws NoSuchProductTableException {

		Session session = null;

		try {
			session = openSession();

			ProductTable productTable = (ProductTable)session.get(
				ProductTableImpl.class, primaryKey);

			if (productTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productTable);
		}
		catch (NoSuchProductTableException noSuchEntityException) {
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
	protected ProductTable removeImpl(ProductTable productTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productTable)) {
				productTable = (ProductTable)session.get(
					ProductTableImpl.class, productTable.getPrimaryKeyObj());
			}

			if (productTable != null) {
				session.delete(productTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productTable != null) {
			clearCache(productTable);
		}

		return productTable;
	}

	@Override
	public ProductTable updateImpl(ProductTable productTable) {
		boolean isNew = productTable.isNew();

		if (!(productTable instanceof ProductTableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productTable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productTable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productTable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductTable implementation " +
					productTable.getClass());
		}

		ProductTableModelImpl productTableModelImpl =
			(ProductTableModelImpl)productTable;

		if (Validator.isNull(productTable.getUuid())) {
			String uuid = _portalUUID.generate();

			productTable.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productTable);
			}
			else {
				productTable = (ProductTable)session.merge(productTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductTableImpl.class, productTableModelImpl, false, true);

		cacheUniqueFindersCache(productTableModelImpl);

		if (isNew) {
			productTable.setNew(false);
		}

		productTable.resetOriginalValues();

		return productTable;
	}

	/**
	 * Returns the product table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product table
	 * @return the product table
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	@Override
	public ProductTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductTableException {

		ProductTable productTable = fetchByPrimaryKey(primaryKey);

		if (productTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productTable;
	}

	/**
	 * Returns the product table with the primary key or throws a <code>NoSuchProductTableException</code> if it could not be found.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table
	 * @throws NoSuchProductTableException if a product table with the primary key could not be found
	 */
	@Override
	public ProductTable findByPrimaryKey(long productId)
		throws NoSuchProductTableException {

		return findByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns the product table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productId the primary key of the product table
	 * @return the product table, or <code>null</code> if a product table with the primary key could not be found
	 */
	@Override
	public ProductTable fetchByPrimaryKey(long productId) {
		return fetchByPrimaryKey((Serializable)productId);
	}

	/**
	 * Returns all the product tables.
	 *
	 * @return the product tables
	 */
	@Override
	public List<ProductTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @return the range of product tables
	 */
	@Override
	public List<ProductTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product tables
	 */
	@Override
	public List<ProductTable> findAll(
		int start, int end, OrderByComparator<ProductTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product tables
	 * @param end the upper bound of the range of product tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product tables
	 */
	@Override
	public List<ProductTable> findAll(
		int start, int end, OrderByComparator<ProductTable> orderByComparator,
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

		List<ProductTable> list = null;

		if (useFinderCache) {
			list = (List<ProductTable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTTABLE;

				sql = sql.concat(ProductTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductTable>)QueryUtil.list(
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
	 * Removes all the product tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductTable productTable : findAll()) {
			remove(productTable);
		}
	}

	/**
	 * Returns the number of product tables.
	 *
	 * @return the number of product tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTTABLE);

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
		return "productId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product table persistence.
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

		_finderPathFetchByproductId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByproductId",
			new String[] {Long.class.getName()}, new String[] {"productId"},
			true);

		_finderPathCountByproductId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproductId",
			new String[] {Long.class.getName()}, new String[] {"productId"},
			false);

		_finderPathFetchByproductName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByproductName",
			new String[] {String.class.getName()}, new String[] {"productName"},
			true);

		_finderPathCountByproductName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproductName",
			new String[] {String.class.getName()}, new String[] {"productName"},
			false);

		_setProductTableUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProductTableUtilPersistence(null);

		entityCache.removeCache(ProductTableImpl.class.getName());
	}

	private void _setProductTableUtilPersistence(
		ProductTablePersistence productTablePersistence) {

		try {
			Field field = ProductTableUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, productTablePersistence);
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

	private static final String _SQL_SELECT_PRODUCTTABLE =
		"SELECT productTable FROM ProductTable productTable";

	private static final String _SQL_SELECT_PRODUCTTABLE_WHERE =
		"SELECT productTable FROM ProductTable productTable WHERE ";

	private static final String _SQL_COUNT_PRODUCTTABLE =
		"SELECT COUNT(productTable) FROM ProductTable productTable";

	private static final String _SQL_COUNT_PRODUCTTABLE_WHERE =
		"SELECT COUNT(productTable) FROM ProductTable productTable WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductTable exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductTable exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductTablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}