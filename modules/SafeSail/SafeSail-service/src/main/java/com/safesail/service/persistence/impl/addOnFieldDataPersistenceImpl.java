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

import com.safesail.exception.NoSuchaddOnFieldDataException;
import com.safesail.model.addOnFieldData;
import com.safesail.model.addOnFieldDataTable;
import com.safesail.model.impl.addOnFieldDataImpl;
import com.safesail.model.impl.addOnFieldDataModelImpl;
import com.safesail.service.persistence.addOnFieldDataPersistence;
import com.safesail.service.persistence.addOnFieldDataUtil;
import com.safesail.service.persistence.impl.constants.Safe_SailPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the add on field data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = addOnFieldDataPersistence.class)
public class addOnFieldDataPersistenceImpl
	extends BasePersistenceImpl<addOnFieldData>
	implements addOnFieldDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>addOnFieldDataUtil</code> to access the add on field data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		addOnFieldDataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public addOnFieldDataPersistenceImpl() {
		setModelClass(addOnFieldData.class);

		setModelImplClass(addOnFieldDataImpl.class);
		setModelPKClass(long.class);

		setTable(addOnFieldDataTable.INSTANCE);
	}

	/**
	 * Caches the add on field data in the entity cache if it is enabled.
	 *
	 * @param addOnFieldData the add on field data
	 */
	@Override
	public void cacheResult(addOnFieldData addOnFieldData) {
		entityCache.putResult(
			addOnFieldDataImpl.class, addOnFieldData.getPrimaryKey(),
			addOnFieldData);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the add on field datas in the entity cache if it is enabled.
	 *
	 * @param addOnFieldDatas the add on field datas
	 */
	@Override
	public void cacheResult(List<addOnFieldData> addOnFieldDatas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (addOnFieldDatas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (addOnFieldData addOnFieldData : addOnFieldDatas) {
			if (entityCache.getResult(
					addOnFieldDataImpl.class, addOnFieldData.getPrimaryKey()) ==
						null) {

				cacheResult(addOnFieldData);
			}
		}
	}

	/**
	 * Clears the cache for all add on field datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(addOnFieldDataImpl.class);

		finderCache.clearCache(addOnFieldDataImpl.class);
	}

	/**
	 * Clears the cache for the add on field data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(addOnFieldData addOnFieldData) {
		entityCache.removeResult(addOnFieldDataImpl.class, addOnFieldData);
	}

	@Override
	public void clearCache(List<addOnFieldData> addOnFieldDatas) {
		for (addOnFieldData addOnFieldData : addOnFieldDatas) {
			entityCache.removeResult(addOnFieldDataImpl.class, addOnFieldData);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(addOnFieldDataImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(addOnFieldDataImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new add on field data with the primary key. Does not add the add on field data to the database.
	 *
	 * @param addonId the primary key for the new add on field data
	 * @return the new add on field data
	 */
	@Override
	public addOnFieldData create(long addonId) {
		addOnFieldData addOnFieldData = new addOnFieldDataImpl();

		addOnFieldData.setNew(true);
		addOnFieldData.setPrimaryKey(addonId);

		return addOnFieldData;
	}

	/**
	 * Removes the add on field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data that was removed
	 * @throws NoSuchaddOnFieldDataException if a add on field data with the primary key could not be found
	 */
	@Override
	public addOnFieldData remove(long addonId)
		throws NoSuchaddOnFieldDataException {

		return remove((Serializable)addonId);
	}

	/**
	 * Removes the add on field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the add on field data
	 * @return the add on field data that was removed
	 * @throws NoSuchaddOnFieldDataException if a add on field data with the primary key could not be found
	 */
	@Override
	public addOnFieldData remove(Serializable primaryKey)
		throws NoSuchaddOnFieldDataException {

		Session session = null;

		try {
			session = openSession();

			addOnFieldData addOnFieldData = (addOnFieldData)session.get(
				addOnFieldDataImpl.class, primaryKey);

			if (addOnFieldData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchaddOnFieldDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(addOnFieldData);
		}
		catch (NoSuchaddOnFieldDataException noSuchEntityException) {
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
	protected addOnFieldData removeImpl(addOnFieldData addOnFieldData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addOnFieldData)) {
				addOnFieldData = (addOnFieldData)session.get(
					addOnFieldDataImpl.class,
					addOnFieldData.getPrimaryKeyObj());
			}

			if (addOnFieldData != null) {
				session.delete(addOnFieldData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (addOnFieldData != null) {
			clearCache(addOnFieldData);
		}

		return addOnFieldData;
	}

	@Override
	public addOnFieldData updateImpl(addOnFieldData addOnFieldData) {
		boolean isNew = addOnFieldData.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(addOnFieldData);
			}
			else {
				addOnFieldData = (addOnFieldData)session.merge(addOnFieldData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			addOnFieldDataImpl.class, addOnFieldData, false, true);

		if (isNew) {
			addOnFieldData.setNew(false);
		}

		addOnFieldData.resetOriginalValues();

		return addOnFieldData;
	}

	/**
	 * Returns the add on field data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the add on field data
	 * @return the add on field data
	 * @throws NoSuchaddOnFieldDataException if a add on field data with the primary key could not be found
	 */
	@Override
	public addOnFieldData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchaddOnFieldDataException {

		addOnFieldData addOnFieldData = fetchByPrimaryKey(primaryKey);

		if (addOnFieldData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchaddOnFieldDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return addOnFieldData;
	}

	/**
	 * Returns the add on field data with the primary key or throws a <code>NoSuchaddOnFieldDataException</code> if it could not be found.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data
	 * @throws NoSuchaddOnFieldDataException if a add on field data with the primary key could not be found
	 */
	@Override
	public addOnFieldData findByPrimaryKey(long addonId)
		throws NoSuchaddOnFieldDataException {

		return findByPrimaryKey((Serializable)addonId);
	}

	/**
	 * Returns the add on field data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addonId the primary key of the add on field data
	 * @return the add on field data, or <code>null</code> if a add on field data with the primary key could not be found
	 */
	@Override
	public addOnFieldData fetchByPrimaryKey(long addonId) {
		return fetchByPrimaryKey((Serializable)addonId);
	}

	/**
	 * Returns all the add on field datas.
	 *
	 * @return the add on field datas
	 */
	@Override
	public List<addOnFieldData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the add on field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>addOnFieldDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of add on field datas
	 * @param end the upper bound of the range of add on field datas (not inclusive)
	 * @return the range of add on field datas
	 */
	@Override
	public List<addOnFieldData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the add on field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>addOnFieldDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of add on field datas
	 * @param end the upper bound of the range of add on field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of add on field datas
	 */
	@Override
	public List<addOnFieldData> findAll(
		int start, int end,
		OrderByComparator<addOnFieldData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the add on field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>addOnFieldDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of add on field datas
	 * @param end the upper bound of the range of add on field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of add on field datas
	 */
	@Override
	public List<addOnFieldData> findAll(
		int start, int end, OrderByComparator<addOnFieldData> orderByComparator,
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

		List<addOnFieldData> list = null;

		if (useFinderCache) {
			list = (List<addOnFieldData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ADDONFIELDDATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ADDONFIELDDATA;

				sql = sql.concat(addOnFieldDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<addOnFieldData>)QueryUtil.list(
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
	 * Removes all the add on field datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (addOnFieldData addOnFieldData : findAll()) {
			remove(addOnFieldData);
		}
	}

	/**
	 * Returns the number of add on field datas.
	 *
	 * @return the number of add on field datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ADDONFIELDDATA);

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
		return "addonId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ADDONFIELDDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return addOnFieldDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the add on field data persistence.
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

		_setaddOnFieldDataUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setaddOnFieldDataUtilPersistence(null);

		entityCache.removeCache(addOnFieldDataImpl.class.getName());
	}

	private void _setaddOnFieldDataUtilPersistence(
		addOnFieldDataPersistence addOnFieldDataPersistence) {

		try {
			Field field = addOnFieldDataUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, addOnFieldDataPersistence);
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

	private static final String _SQL_SELECT_ADDONFIELDDATA =
		"SELECT addOnFieldData FROM addOnFieldData addOnFieldData";

	private static final String _SQL_COUNT_ADDONFIELDDATA =
		"SELECT COUNT(addOnFieldData) FROM addOnFieldData addOnFieldData";

	private static final String _ORDER_BY_ENTITY_ALIAS = "addOnFieldData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No addOnFieldData exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		addOnFieldDataPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}