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
import com.liferay.portal.kernel.util.StringUtil;

import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.FieldConfigurationTable;
import com.safesail.model.impl.FieldConfigurationImpl;
import com.safesail.model.impl.FieldConfigurationModelImpl;
import com.safesail.service.persistence.FieldConfigurationPersistence;
import com.safesail.service.persistence.FieldConfigurationUtil;
import com.safesail.service.persistence.impl.constants.Safe_SailPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the field configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FieldConfigurationPersistence.class)
public class FieldConfigurationPersistenceImpl
	extends BasePersistenceImpl<FieldConfiguration>
	implements FieldConfigurationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FieldConfigurationUtil</code> to access the field configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FieldConfigurationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByconfigId;
	private FinderPath _finderPathWithoutPaginationFindByconfigId;
	private FinderPath _finderPathCountByconfigId;

	/**
	 * Returns all the field configurations where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @return the matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByconfigId(long configId) {
		return findByconfigId(
			configId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the field configurations where configId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param configId the config ID
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByconfigId(
		long configId, int start, int end) {

		return findByconfigId(configId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the field configurations where configId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param configId the config ID
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByconfigId(
		long configId, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return findByconfigId(configId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the field configurations where configId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param configId the config ID
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByconfigId(
		long configId, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByconfigId;
				finderArgs = new Object[] {configId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByconfigId;
			finderArgs = new Object[] {configId, start, end, orderByComparator};
		}

		List<FieldConfiguration> list = null;

		if (useFinderCache) {
			list = (List<FieldConfiguration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FieldConfiguration fieldConfiguration : list) {
					if (configId != fieldConfiguration.getConfigId()) {
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

			sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

			sb.append(_FINDER_COLUMN_CONFIGID_CONFIGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(configId);

				list = (List<FieldConfiguration>)QueryUtil.list(
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
	 * Returns the first field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByconfigId_First(
			long configId,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByconfigId_First(
			configId, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("configId=");
		sb.append(configId);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the first field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByconfigId_First(
		long configId,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		List<FieldConfiguration> list = findByconfigId(
			configId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByconfigId_Last(
			long configId,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByconfigId_Last(
			configId, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("configId=");
		sb.append(configId);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the last field configuration in the ordered set where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByconfigId_Last(
		long configId,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		int count = countByconfigId(configId);

		if (count == 0) {
			return null;
		}

		List<FieldConfiguration> list = findByconfigId(
			configId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the field configurations where configId = &#63; from the database.
	 *
	 * @param configId the config ID
	 */
	@Override
	public void removeByconfigId(long configId) {
		for (FieldConfiguration fieldConfiguration :
				findByconfigId(
					configId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fieldConfiguration);
		}
	}

	/**
	 * Returns the number of field configurations where configId = &#63;.
	 *
	 * @param configId the config ID
	 * @return the number of matching field configurations
	 */
	@Override
	public int countByconfigId(long configId) {
		FinderPath finderPath = _finderPathCountByconfigId;

		Object[] finderArgs = new Object[] {configId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FIELDCONFIGURATION_WHERE);

			sb.append(_FINDER_COLUMN_CONFIGID_CONFIGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(configId);

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

	private static final String _FINDER_COLUMN_CONFIGID_CONFIGID_2 =
		"fieldConfiguration.configId = ?";

	private FinderPath _finderPathWithPaginationFindByfieldName;
	private FinderPath _finderPathWithoutPaginationFindByfieldName;
	private FinderPath _finderPathCountByfieldName;

	/**
	 * Returns all the field configurations where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @return the matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldName(String fieldName) {
		return findByfieldName(
			fieldName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the field configurations where fieldName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldName the field name
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end) {

		return findByfieldName(fieldName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldName the field name
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return findByfieldName(fieldName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldName the field name
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldName(
		String fieldName, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		fieldName = Objects.toString(fieldName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfieldName;
				finderArgs = new Object[] {fieldName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfieldName;
			finderArgs = new Object[] {
				fieldName, start, end, orderByComparator
			};
		}

		List<FieldConfiguration> list = null;

		if (useFinderCache) {
			list = (List<FieldConfiguration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FieldConfiguration fieldConfiguration : list) {
					if (!fieldName.equals(fieldConfiguration.getFieldName())) {
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

			sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

			boolean bindFieldName = false;

			if (fieldName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIELDNAME_FIELDNAME_3);
			}
			else {
				bindFieldName = true;

				sb.append(_FINDER_COLUMN_FIELDNAME_FIELDNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFieldName) {
					queryPos.add(fieldName);
				}

				list = (List<FieldConfiguration>)QueryUtil.list(
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
	 * Returns the first field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldName_First(
			String fieldName,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldName_First(
			fieldName, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fieldName=");
		sb.append(fieldName);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldName_First(
		String fieldName,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		List<FieldConfiguration> list = findByfieldName(
			fieldName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldName_Last(
			String fieldName,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldName_Last(
			fieldName, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fieldName=");
		sb.append(fieldName);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldName_Last(
		String fieldName,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		int count = countByfieldName(fieldName);

		if (count == 0) {
			return null;
		}

		List<FieldConfiguration> list = findByfieldName(
			fieldName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldName = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldName the field name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration[] findByfieldName_PrevAndNext(
			long configId, String fieldName,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		fieldName = Objects.toString(fieldName, "");

		FieldConfiguration fieldConfiguration = findByPrimaryKey(configId);

		Session session = null;

		try {
			session = openSession();

			FieldConfiguration[] array = new FieldConfigurationImpl[3];

			array[0] = getByfieldName_PrevAndNext(
				session, fieldConfiguration, fieldName, orderByComparator,
				true);

			array[1] = fieldConfiguration;

			array[2] = getByfieldName_PrevAndNext(
				session, fieldConfiguration, fieldName, orderByComparator,
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

	protected FieldConfiguration getByfieldName_PrevAndNext(
		Session session, FieldConfiguration fieldConfiguration,
		String fieldName,
		OrderByComparator<FieldConfiguration> orderByComparator,
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

		sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

		boolean bindFieldName = false;

		if (fieldName.isEmpty()) {
			sb.append(_FINDER_COLUMN_FIELDNAME_FIELDNAME_3);
		}
		else {
			bindFieldName = true;

			sb.append(_FINDER_COLUMN_FIELDNAME_FIELDNAME_2);
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
			sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFieldName) {
			queryPos.add(fieldName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fieldConfiguration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FieldConfiguration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the field configurations where fieldName = &#63; from the database.
	 *
	 * @param fieldName the field name
	 */
	@Override
	public void removeByfieldName(String fieldName) {
		for (FieldConfiguration fieldConfiguration :
				findByfieldName(
					fieldName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fieldConfiguration);
		}
	}

	/**
	 * Returns the number of field configurations where fieldName = &#63;.
	 *
	 * @param fieldName the field name
	 * @return the number of matching field configurations
	 */
	@Override
	public int countByfieldName(String fieldName) {
		fieldName = Objects.toString(fieldName, "");

		FinderPath finderPath = _finderPathCountByfieldName;

		Object[] finderArgs = new Object[] {fieldName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FIELDCONFIGURATION_WHERE);

			boolean bindFieldName = false;

			if (fieldName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIELDNAME_FIELDNAME_3);
			}
			else {
				bindFieldName = true;

				sb.append(_FINDER_COLUMN_FIELDNAME_FIELDNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFieldName) {
					queryPos.add(fieldName);
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

	private static final String _FINDER_COLUMN_FIELDNAME_FIELDNAME_2 =
		"fieldConfiguration.fieldName = ?";

	private static final String _FINDER_COLUMN_FIELDNAME_FIELDNAME_3 =
		"(fieldConfiguration.fieldName IS NULL OR fieldConfiguration.fieldName = '')";

	private FinderPath _finderPathWithPaginationFindByfieldData;
	private FinderPath _finderPathWithoutPaginationFindByfieldData;
	private FinderPath _finderPathCountByfieldData;

	/**
	 * Returns all the field configurations where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @return the matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldData(String fieldData) {
		return findByfieldData(
			fieldData, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the field configurations where fieldData = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldData the field data
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end) {

		return findByfieldData(fieldData, start, end, null);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldData = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldData the field data
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return findByfieldData(fieldData, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldData = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldData the field data
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldData(
		String fieldData, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		fieldData = Objects.toString(fieldData, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfieldData;
				finderArgs = new Object[] {fieldData};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfieldData;
			finderArgs = new Object[] {
				fieldData, start, end, orderByComparator
			};
		}

		List<FieldConfiguration> list = null;

		if (useFinderCache) {
			list = (List<FieldConfiguration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FieldConfiguration fieldConfiguration : list) {
					if (!fieldData.equals(fieldConfiguration.getFieldData())) {
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

			sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

			boolean bindFieldData = false;

			if (fieldData.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIELDDATA_FIELDDATA_3);
			}
			else {
				bindFieldData = true;

				sb.append(_FINDER_COLUMN_FIELDDATA_FIELDDATA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFieldData) {
					queryPos.add(fieldData);
				}

				list = (List<FieldConfiguration>)QueryUtil.list(
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
	 * Returns the first field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldData_First(
			String fieldData,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldData_First(
			fieldData, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fieldData=");
		sb.append(fieldData);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldData_First(
		String fieldData,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		List<FieldConfiguration> list = findByfieldData(
			fieldData, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldData_Last(
			String fieldData,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldData_Last(
			fieldData, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fieldData=");
		sb.append(fieldData);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldData_Last(
		String fieldData,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		int count = countByfieldData(fieldData);

		if (count == 0) {
			return null;
		}

		List<FieldConfiguration> list = findByfieldData(
			fieldData, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldData = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldData the field data
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration[] findByfieldData_PrevAndNext(
			long configId, String fieldData,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		fieldData = Objects.toString(fieldData, "");

		FieldConfiguration fieldConfiguration = findByPrimaryKey(configId);

		Session session = null;

		try {
			session = openSession();

			FieldConfiguration[] array = new FieldConfigurationImpl[3];

			array[0] = getByfieldData_PrevAndNext(
				session, fieldConfiguration, fieldData, orderByComparator,
				true);

			array[1] = fieldConfiguration;

			array[2] = getByfieldData_PrevAndNext(
				session, fieldConfiguration, fieldData, orderByComparator,
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

	protected FieldConfiguration getByfieldData_PrevAndNext(
		Session session, FieldConfiguration fieldConfiguration,
		String fieldData,
		OrderByComparator<FieldConfiguration> orderByComparator,
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

		sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

		boolean bindFieldData = false;

		if (fieldData.isEmpty()) {
			sb.append(_FINDER_COLUMN_FIELDDATA_FIELDDATA_3);
		}
		else {
			bindFieldData = true;

			sb.append(_FINDER_COLUMN_FIELDDATA_FIELDDATA_2);
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
			sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFieldData) {
			queryPos.add(fieldData);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fieldConfiguration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FieldConfiguration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the field configurations where fieldData = &#63; from the database.
	 *
	 * @param fieldData the field data
	 */
	@Override
	public void removeByfieldData(String fieldData) {
		for (FieldConfiguration fieldConfiguration :
				findByfieldData(
					fieldData, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fieldConfiguration);
		}
	}

	/**
	 * Returns the number of field configurations where fieldData = &#63;.
	 *
	 * @param fieldData the field data
	 * @return the number of matching field configurations
	 */
	@Override
	public int countByfieldData(String fieldData) {
		fieldData = Objects.toString(fieldData, "");

		FinderPath finderPath = _finderPathCountByfieldData;

		Object[] finderArgs = new Object[] {fieldData};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FIELDCONFIGURATION_WHERE);

			boolean bindFieldData = false;

			if (fieldData.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIELDDATA_FIELDDATA_3);
			}
			else {
				bindFieldData = true;

				sb.append(_FINDER_COLUMN_FIELDDATA_FIELDDATA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFieldData) {
					queryPos.add(fieldData);
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

	private static final String _FINDER_COLUMN_FIELDDATA_FIELDDATA_2 =
		"fieldConfiguration.fieldData = ?";

	private static final String _FINDER_COLUMN_FIELDDATA_FIELDDATA_3 =
		"(fieldConfiguration.fieldData IS NULL OR fieldConfiguration.fieldData = '')";

	private FinderPath _finderPathWithPaginationFindByfieldValue;
	private FinderPath _finderPathWithoutPaginationFindByfieldValue;
	private FinderPath _finderPathCountByfieldValue;

	/**
	 * Returns all the field configurations where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @return the matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldValue(String fieldValue) {
		return findByfieldValue(
			fieldValue, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the field configurations where fieldValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldValue the field value
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end) {

		return findByfieldValue(fieldValue, start, end, null);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldValue the field value
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return findByfieldValue(
			fieldValue, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldValue = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldValue the field value
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldValue(
		String fieldValue, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		fieldValue = Objects.toString(fieldValue, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfieldValue;
				finderArgs = new Object[] {fieldValue};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfieldValue;
			finderArgs = new Object[] {
				fieldValue, start, end, orderByComparator
			};
		}

		List<FieldConfiguration> list = null;

		if (useFinderCache) {
			list = (List<FieldConfiguration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FieldConfiguration fieldConfiguration : list) {
					if (!fieldValue.equals(
							fieldConfiguration.getFieldValue())) {

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

			sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

			boolean bindFieldValue = false;

			if (fieldValue.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIELDVALUE_FIELDVALUE_3);
			}
			else {
				bindFieldValue = true;

				sb.append(_FINDER_COLUMN_FIELDVALUE_FIELDVALUE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFieldValue) {
					queryPos.add(fieldValue);
				}

				list = (List<FieldConfiguration>)QueryUtil.list(
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
	 * Returns the first field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldValue_First(
			String fieldValue,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldValue_First(
			fieldValue, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fieldValue=");
		sb.append(fieldValue);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldValue_First(
		String fieldValue,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		List<FieldConfiguration> list = findByfieldValue(
			fieldValue, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldValue_Last(
			String fieldValue,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldValue_Last(
			fieldValue, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fieldValue=");
		sb.append(fieldValue);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldValue_Last(
		String fieldValue,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		int count = countByfieldValue(fieldValue);

		if (count == 0) {
			return null;
		}

		List<FieldConfiguration> list = findByfieldValue(
			fieldValue, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldValue = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldValue the field value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration[] findByfieldValue_PrevAndNext(
			long configId, String fieldValue,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		fieldValue = Objects.toString(fieldValue, "");

		FieldConfiguration fieldConfiguration = findByPrimaryKey(configId);

		Session session = null;

		try {
			session = openSession();

			FieldConfiguration[] array = new FieldConfigurationImpl[3];

			array[0] = getByfieldValue_PrevAndNext(
				session, fieldConfiguration, fieldValue, orderByComparator,
				true);

			array[1] = fieldConfiguration;

			array[2] = getByfieldValue_PrevAndNext(
				session, fieldConfiguration, fieldValue, orderByComparator,
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

	protected FieldConfiguration getByfieldValue_PrevAndNext(
		Session session, FieldConfiguration fieldConfiguration,
		String fieldValue,
		OrderByComparator<FieldConfiguration> orderByComparator,
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

		sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

		boolean bindFieldValue = false;

		if (fieldValue.isEmpty()) {
			sb.append(_FINDER_COLUMN_FIELDVALUE_FIELDVALUE_3);
		}
		else {
			bindFieldValue = true;

			sb.append(_FINDER_COLUMN_FIELDVALUE_FIELDVALUE_2);
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
			sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFieldValue) {
			queryPos.add(fieldValue);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fieldConfiguration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FieldConfiguration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the field configurations where fieldValue = &#63; from the database.
	 *
	 * @param fieldValue the field value
	 */
	@Override
	public void removeByfieldValue(String fieldValue) {
		for (FieldConfiguration fieldConfiguration :
				findByfieldValue(
					fieldValue, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fieldConfiguration);
		}
	}

	/**
	 * Returns the number of field configurations where fieldValue = &#63;.
	 *
	 * @param fieldValue the field value
	 * @return the number of matching field configurations
	 */
	@Override
	public int countByfieldValue(String fieldValue) {
		fieldValue = Objects.toString(fieldValue, "");

		FinderPath finderPath = _finderPathCountByfieldValue;

		Object[] finderArgs = new Object[] {fieldValue};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FIELDCONFIGURATION_WHERE);

			boolean bindFieldValue = false;

			if (fieldValue.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIELDVALUE_FIELDVALUE_3);
			}
			else {
				bindFieldValue = true;

				sb.append(_FINDER_COLUMN_FIELDVALUE_FIELDVALUE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFieldValue) {
					queryPos.add(fieldValue);
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

	private static final String _FINDER_COLUMN_FIELDVALUE_FIELDVALUE_2 =
		"fieldConfiguration.fieldValue = ?";

	private static final String _FINDER_COLUMN_FIELDVALUE_FIELDVALUE_3 =
		"(fieldConfiguration.fieldValue IS NULL OR fieldConfiguration.fieldValue = '')";

	private FinderPath _finderPathWithPaginationFindByfieldSumAssured;
	private FinderPath _finderPathWithoutPaginationFindByfieldSumAssured;
	private FinderPath _finderPathCountByfieldSumAssured;

	/**
	 * Returns all the field configurations where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @return the matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured) {

		return findByfieldSumAssured(
			fieldSumAssured, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the field configurations where fieldSumAssured = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end) {

		return findByfieldSumAssured(fieldSumAssured, start, end, null);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldSumAssured = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return findByfieldSumAssured(
			fieldSumAssured, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the field configurations where fieldSumAssured = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching field configurations
	 */
	@Override
	public List<FieldConfiguration> findByfieldSumAssured(
		String fieldSumAssured, int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
		boolean useFinderCache) {

		fieldSumAssured = Objects.toString(fieldSumAssured, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByfieldSumAssured;
				finderArgs = new Object[] {fieldSumAssured};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByfieldSumAssured;
			finderArgs = new Object[] {
				fieldSumAssured, start, end, orderByComparator
			};
		}

		List<FieldConfiguration> list = null;

		if (useFinderCache) {
			list = (List<FieldConfiguration>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FieldConfiguration fieldConfiguration : list) {
					if (!fieldSumAssured.equals(
							fieldConfiguration.getFieldSumAssured())) {

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

			sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

			boolean bindFieldSumAssured = false;

			if (fieldSumAssured.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIELDSUMASSURED_FIELDSUMASSURED_3);
			}
			else {
				bindFieldSumAssured = true;

				sb.append(_FINDER_COLUMN_FIELDSUMASSURED_FIELDSUMASSURED_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFieldSumAssured) {
					queryPos.add(fieldSumAssured);
				}

				list = (List<FieldConfiguration>)QueryUtil.list(
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
	 * Returns the first field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldSumAssured_First(
			String fieldSumAssured,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldSumAssured_First(
			fieldSumAssured, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fieldSumAssured=");
		sb.append(fieldSumAssured);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the first field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldSumAssured_First(
		String fieldSumAssured,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		List<FieldConfiguration> list = findByfieldSumAssured(
			fieldSumAssured, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldSumAssured_Last(
			String fieldSumAssured,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldSumAssured_Last(
			fieldSumAssured, orderByComparator);

		if (fieldConfiguration != null) {
			return fieldConfiguration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fieldSumAssured=");
		sb.append(fieldSumAssured);

		sb.append("}");

		throw new NoSuchFieldConfigurationException(sb.toString());
	}

	/**
	 * Returns the last field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldSumAssured_Last(
		String fieldSumAssured,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		int count = countByfieldSumAssured(fieldSumAssured);

		if (count == 0) {
			return null;
		}

		List<FieldConfiguration> list = findByfieldSumAssured(
			fieldSumAssured, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the field configurations before and after the current field configuration in the ordered set where fieldSumAssured = &#63;.
	 *
	 * @param configId the primary key of the current field configuration
	 * @param fieldSumAssured the field sum assured
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration[] findByfieldSumAssured_PrevAndNext(
			long configId, String fieldSumAssured,
			OrderByComparator<FieldConfiguration> orderByComparator)
		throws NoSuchFieldConfigurationException {

		fieldSumAssured = Objects.toString(fieldSumAssured, "");

		FieldConfiguration fieldConfiguration = findByPrimaryKey(configId);

		Session session = null;

		try {
			session = openSession();

			FieldConfiguration[] array = new FieldConfigurationImpl[3];

			array[0] = getByfieldSumAssured_PrevAndNext(
				session, fieldConfiguration, fieldSumAssured, orderByComparator,
				true);

			array[1] = fieldConfiguration;

			array[2] = getByfieldSumAssured_PrevAndNext(
				session, fieldConfiguration, fieldSumAssured, orderByComparator,
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

	protected FieldConfiguration getByfieldSumAssured_PrevAndNext(
		Session session, FieldConfiguration fieldConfiguration,
		String fieldSumAssured,
		OrderByComparator<FieldConfiguration> orderByComparator,
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

		sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

		boolean bindFieldSumAssured = false;

		if (fieldSumAssured.isEmpty()) {
			sb.append(_FINDER_COLUMN_FIELDSUMASSURED_FIELDSUMASSURED_3);
		}
		else {
			bindFieldSumAssured = true;

			sb.append(_FINDER_COLUMN_FIELDSUMASSURED_FIELDSUMASSURED_2);
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
			sb.append(FieldConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFieldSumAssured) {
			queryPos.add(fieldSumAssured);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						fieldConfiguration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FieldConfiguration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the field configurations where fieldSumAssured = &#63; from the database.
	 *
	 * @param fieldSumAssured the field sum assured
	 */
	@Override
	public void removeByfieldSumAssured(String fieldSumAssured) {
		for (FieldConfiguration fieldConfiguration :
				findByfieldSumAssured(
					fieldSumAssured, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(fieldConfiguration);
		}
	}

	/**
	 * Returns the number of field configurations where fieldSumAssured = &#63;.
	 *
	 * @param fieldSumAssured the field sum assured
	 * @return the number of matching field configurations
	 */
	@Override
	public int countByfieldSumAssured(String fieldSumAssured) {
		fieldSumAssured = Objects.toString(fieldSumAssured, "");

		FinderPath finderPath = _finderPathCountByfieldSumAssured;

		Object[] finderArgs = new Object[] {fieldSumAssured};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FIELDCONFIGURATION_WHERE);

			boolean bindFieldSumAssured = false;

			if (fieldSumAssured.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIELDSUMASSURED_FIELDSUMASSURED_3);
			}
			else {
				bindFieldSumAssured = true;

				sb.append(_FINDER_COLUMN_FIELDSUMASSURED_FIELDSUMASSURED_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFieldSumAssured) {
					queryPos.add(fieldSumAssured);
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

	private static final String
		_FINDER_COLUMN_FIELDSUMASSURED_FIELDSUMASSURED_2 =
			"fieldConfiguration.fieldSumAssured = ?";

	private static final String
		_FINDER_COLUMN_FIELDSUMASSURED_FIELDSUMASSURED_3 =
			"(fieldConfiguration.fieldSumAssured IS NULL OR fieldConfiguration.fieldSumAssured = '')";

	private FinderPath _finderPathFetchByfieldShow;
	private FinderPath _finderPathCountByfieldShow;

	/**
	 * Returns the field configuration where fieldShow = &#63; or throws a <code>NoSuchFieldConfigurationException</code> if it could not be found.
	 *
	 * @param fieldShow the field show
	 * @return the matching field configuration
	 * @throws NoSuchFieldConfigurationException if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration findByfieldShow(Boolean fieldShow)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByfieldShow(fieldShow);

		if (fieldConfiguration == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("fieldShow=");
			sb.append(fieldShow);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFieldConfigurationException(sb.toString());
		}

		return fieldConfiguration;
	}

	/**
	 * Returns the field configuration where fieldShow = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fieldShow the field show
	 * @return the matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldShow(Boolean fieldShow) {
		return fetchByfieldShow(fieldShow, true);
	}

	/**
	 * Returns the field configuration where fieldShow = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldShow the field show
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching field configuration, or <code>null</code> if a matching field configuration could not be found
	 */
	@Override
	public FieldConfiguration fetchByfieldShow(
		Boolean fieldShow, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {fieldShow};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfieldShow, finderArgs, this);
		}

		if (result instanceof FieldConfiguration) {
			FieldConfiguration fieldConfiguration = (FieldConfiguration)result;

			if (!Objects.equals(fieldShow, fieldConfiguration.getFieldShow())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FIELDCONFIGURATION_WHERE);

			sb.append(_FINDER_COLUMN_FIELDSHOW_FIELDSHOW_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fieldShow.booleanValue());

				List<FieldConfiguration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfieldShow, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {fieldShow};
							}

							_log.warn(
								"FieldConfigurationPersistenceImpl.fetchByfieldShow(Boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FieldConfiguration fieldConfiguration = list.get(0);

					result = fieldConfiguration;

					cacheResult(fieldConfiguration);
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
			return (FieldConfiguration)result;
		}
	}

	/**
	 * Removes the field configuration where fieldShow = &#63; from the database.
	 *
	 * @param fieldShow the field show
	 * @return the field configuration that was removed
	 */
	@Override
	public FieldConfiguration removeByfieldShow(Boolean fieldShow)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = findByfieldShow(fieldShow);

		return remove(fieldConfiguration);
	}

	/**
	 * Returns the number of field configurations where fieldShow = &#63;.
	 *
	 * @param fieldShow the field show
	 * @return the number of matching field configurations
	 */
	@Override
	public int countByfieldShow(Boolean fieldShow) {
		FinderPath finderPath = _finderPathCountByfieldShow;

		Object[] finderArgs = new Object[] {fieldShow};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FIELDCONFIGURATION_WHERE);

			sb.append(_FINDER_COLUMN_FIELDSHOW_FIELDSHOW_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(fieldShow.booleanValue());

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

	private static final String _FINDER_COLUMN_FIELDSHOW_FIELDSHOW_2 =
		"fieldConfiguration.fieldShow = ?";

	public FieldConfigurationPersistenceImpl() {
		setModelClass(FieldConfiguration.class);

		setModelImplClass(FieldConfigurationImpl.class);
		setModelPKClass(long.class);

		setTable(FieldConfigurationTable.INSTANCE);
	}

	/**
	 * Caches the field configuration in the entity cache if it is enabled.
	 *
	 * @param fieldConfiguration the field configuration
	 */
	@Override
	public void cacheResult(FieldConfiguration fieldConfiguration) {
		entityCache.putResult(
			FieldConfigurationImpl.class, fieldConfiguration.getPrimaryKey(),
			fieldConfiguration);

		finderCache.putResult(
			_finderPathFetchByfieldShow,
			new Object[] {fieldConfiguration.getFieldShow()},
			fieldConfiguration);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the field configurations in the entity cache if it is enabled.
	 *
	 * @param fieldConfigurations the field configurations
	 */
	@Override
	public void cacheResult(List<FieldConfiguration> fieldConfigurations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fieldConfigurations.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FieldConfiguration fieldConfiguration : fieldConfigurations) {
			if (entityCache.getResult(
					FieldConfigurationImpl.class,
					fieldConfiguration.getPrimaryKey()) == null) {

				cacheResult(fieldConfiguration);
			}
		}
	}

	/**
	 * Clears the cache for all field configurations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FieldConfigurationImpl.class);

		finderCache.clearCache(FieldConfigurationImpl.class);
	}

	/**
	 * Clears the cache for the field configuration.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FieldConfiguration fieldConfiguration) {
		entityCache.removeResult(
			FieldConfigurationImpl.class, fieldConfiguration);
	}

	@Override
	public void clearCache(List<FieldConfiguration> fieldConfigurations) {
		for (FieldConfiguration fieldConfiguration : fieldConfigurations) {
			entityCache.removeResult(
				FieldConfigurationImpl.class, fieldConfiguration);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FieldConfigurationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FieldConfigurationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FieldConfigurationModelImpl fieldConfigurationModelImpl) {

		Object[] args = new Object[] {
			fieldConfigurationModelImpl.getFieldShow()
		};

		finderCache.putResult(
			_finderPathCountByfieldShow, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByfieldShow, args, fieldConfigurationModelImpl);
	}

	/**
	 * Creates a new field configuration with the primary key. Does not add the field configuration to the database.
	 *
	 * @param configId the primary key for the new field configuration
	 * @return the new field configuration
	 */
	@Override
	public FieldConfiguration create(long configId) {
		FieldConfiguration fieldConfiguration = new FieldConfigurationImpl();

		fieldConfiguration.setNew(true);
		fieldConfiguration.setPrimaryKey(configId);

		return fieldConfiguration;
	}

	/**
	 * Removes the field configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration that was removed
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration remove(long configId)
		throws NoSuchFieldConfigurationException {

		return remove((Serializable)configId);
	}

	/**
	 * Removes the field configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the field configuration
	 * @return the field configuration that was removed
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration remove(Serializable primaryKey)
		throws NoSuchFieldConfigurationException {

		Session session = null;

		try {
			session = openSession();

			FieldConfiguration fieldConfiguration =
				(FieldConfiguration)session.get(
					FieldConfigurationImpl.class, primaryKey);

			if (fieldConfiguration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFieldConfigurationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fieldConfiguration);
		}
		catch (NoSuchFieldConfigurationException noSuchEntityException) {
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
	protected FieldConfiguration removeImpl(
		FieldConfiguration fieldConfiguration) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fieldConfiguration)) {
				fieldConfiguration = (FieldConfiguration)session.get(
					FieldConfigurationImpl.class,
					fieldConfiguration.getPrimaryKeyObj());
			}

			if (fieldConfiguration != null) {
				session.delete(fieldConfiguration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fieldConfiguration != null) {
			clearCache(fieldConfiguration);
		}

		return fieldConfiguration;
	}

	@Override
	public FieldConfiguration updateImpl(
		FieldConfiguration fieldConfiguration) {

		boolean isNew = fieldConfiguration.isNew();

		if (!(fieldConfiguration instanceof FieldConfigurationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fieldConfiguration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					fieldConfiguration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fieldConfiguration proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FieldConfiguration implementation " +
					fieldConfiguration.getClass());
		}

		FieldConfigurationModelImpl fieldConfigurationModelImpl =
			(FieldConfigurationModelImpl)fieldConfiguration;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fieldConfiguration);
			}
			else {
				fieldConfiguration = (FieldConfiguration)session.merge(
					fieldConfiguration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FieldConfigurationImpl.class, fieldConfigurationModelImpl, false,
			true);

		cacheUniqueFindersCache(fieldConfigurationModelImpl);

		if (isNew) {
			fieldConfiguration.setNew(false);
		}

		fieldConfiguration.resetOriginalValues();

		return fieldConfiguration;
	}

	/**
	 * Returns the field configuration with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the field configuration
	 * @return the field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFieldConfigurationException {

		FieldConfiguration fieldConfiguration = fetchByPrimaryKey(primaryKey);

		if (fieldConfiguration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFieldConfigurationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fieldConfiguration;
	}

	/**
	 * Returns the field configuration with the primary key or throws a <code>NoSuchFieldConfigurationException</code> if it could not be found.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration
	 * @throws NoSuchFieldConfigurationException if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration findByPrimaryKey(long configId)
		throws NoSuchFieldConfigurationException {

		return findByPrimaryKey((Serializable)configId);
	}

	/**
	 * Returns the field configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configId the primary key of the field configuration
	 * @return the field configuration, or <code>null</code> if a field configuration with the primary key could not be found
	 */
	@Override
	public FieldConfiguration fetchByPrimaryKey(long configId) {
		return fetchByPrimaryKey((Serializable)configId);
	}

	/**
	 * Returns all the field configurations.
	 *
	 * @return the field configurations
	 */
	@Override
	public List<FieldConfiguration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the field configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @return the range of field configurations
	 */
	@Override
	public List<FieldConfiguration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the field configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of field configurations
	 */
	@Override
	public List<FieldConfiguration> findAll(
		int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the field configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FieldConfigurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of field configurations
	 * @param end the upper bound of the range of field configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of field configurations
	 */
	@Override
	public List<FieldConfiguration> findAll(
		int start, int end,
		OrderByComparator<FieldConfiguration> orderByComparator,
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

		List<FieldConfiguration> list = null;

		if (useFinderCache) {
			list = (List<FieldConfiguration>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FIELDCONFIGURATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FIELDCONFIGURATION;

				sql = sql.concat(FieldConfigurationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FieldConfiguration>)QueryUtil.list(
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
	 * Removes all the field configurations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FieldConfiguration fieldConfiguration : findAll()) {
			remove(fieldConfiguration);
		}
	}

	/**
	 * Returns the number of field configurations.
	 *
	 * @return the number of field configurations
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
					_SQL_COUNT_FIELDCONFIGURATION);

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
		return "configId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FIELDCONFIGURATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FieldConfigurationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the field configuration persistence.
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

		_finderPathWithPaginationFindByconfigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByconfigId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"configId"}, true);

		_finderPathWithoutPaginationFindByconfigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByconfigId",
			new String[] {Long.class.getName()}, new String[] {"configId"},
			true);

		_finderPathCountByconfigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByconfigId",
			new String[] {Long.class.getName()}, new String[] {"configId"},
			false);

		_finderPathWithPaginationFindByfieldName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfieldName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fieldName"}, true);

		_finderPathWithoutPaginationFindByfieldName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfieldName",
			new String[] {String.class.getName()}, new String[] {"fieldName"},
			true);

		_finderPathCountByfieldName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfieldName",
			new String[] {String.class.getName()}, new String[] {"fieldName"},
			false);

		_finderPathWithPaginationFindByfieldData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfieldData",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fieldData"}, true);

		_finderPathWithoutPaginationFindByfieldData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfieldData",
			new String[] {String.class.getName()}, new String[] {"fieldData"},
			true);

		_finderPathCountByfieldData = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfieldData",
			new String[] {String.class.getName()}, new String[] {"fieldData"},
			false);

		_finderPathWithPaginationFindByfieldValue = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfieldValue",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fieldValue"}, true);

		_finderPathWithoutPaginationFindByfieldValue = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfieldValue",
			new String[] {String.class.getName()}, new String[] {"fieldValue"},
			true);

		_finderPathCountByfieldValue = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfieldValue",
			new String[] {String.class.getName()}, new String[] {"fieldValue"},
			false);

		_finderPathWithPaginationFindByfieldSumAssured = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfieldSumAssured",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"fieldSumAssured"}, true);

		_finderPathWithoutPaginationFindByfieldSumAssured = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfieldSumAssured",
			new String[] {String.class.getName()},
			new String[] {"fieldSumAssured"}, true);

		_finderPathCountByfieldSumAssured = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfieldSumAssured",
			new String[] {String.class.getName()},
			new String[] {"fieldSumAssured"}, false);

		_finderPathFetchByfieldShow = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByfieldShow",
			new String[] {Boolean.class.getName()}, new String[] {"fieldShow"},
			true);

		_finderPathCountByfieldShow = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfieldShow",
			new String[] {Boolean.class.getName()}, new String[] {"fieldShow"},
			false);

		_setFieldConfigurationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFieldConfigurationUtilPersistence(null);

		entityCache.removeCache(FieldConfigurationImpl.class.getName());
	}

	private void _setFieldConfigurationUtilPersistence(
		FieldConfigurationPersistence fieldConfigurationPersistence) {

		try {
			Field field = FieldConfigurationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, fieldConfigurationPersistence);
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

	private static final String _SQL_SELECT_FIELDCONFIGURATION =
		"SELECT fieldConfiguration FROM FieldConfiguration fieldConfiguration";

	private static final String _SQL_SELECT_FIELDCONFIGURATION_WHERE =
		"SELECT fieldConfiguration FROM FieldConfiguration fieldConfiguration WHERE ";

	private static final String _SQL_COUNT_FIELDCONFIGURATION =
		"SELECT COUNT(fieldConfiguration) FROM FieldConfiguration fieldConfiguration";

	private static final String _SQL_COUNT_FIELDCONFIGURATION_WHERE =
		"SELECT COUNT(fieldConfiguration) FROM FieldConfiguration fieldConfiguration WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fieldConfiguration.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FieldConfiguration exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FieldConfiguration exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FieldConfigurationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}