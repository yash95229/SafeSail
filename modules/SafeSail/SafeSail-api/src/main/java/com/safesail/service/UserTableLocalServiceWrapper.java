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

package com.safesail.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserTableLocalService
 * @generated
 */
public class UserTableLocalServiceWrapper
	implements ServiceWrapper<UserTableLocalService>, UserTableLocalService {

	public UserTableLocalServiceWrapper() {
		this(null);
	}

	public UserTableLocalServiceWrapper(
		UserTableLocalService userTableLocalService) {

		_userTableLocalService = userTableLocalService;
	}

	@Override
	public com.safesail.model.UserTable addUser(
		String quoteId, long userId, String userType) {

		return _userTableLocalService.addUser(quoteId, userId, userType);
	}

	/**
	 * Adds the user table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userTable the user table
	 * @return the user table that was added
	 */
	@Override
	public com.safesail.model.UserTable addUserTable(
		com.safesail.model.UserTable userTable) {

		return _userTableLocalService.addUserTable(userTable);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user table with the primary key. Does not add the user table to the database.
	 *
	 * @param quoteId the primary key for the new user table
	 * @return the new user table
	 */
	@Override
	public com.safesail.model.UserTable createUserTable(String quoteId) {
		return _userTableLocalService.createUserTable(quoteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTableLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table that was removed
	 * @throws PortalException if a user table with the primary key could not be found
	 */
	@Override
	public com.safesail.model.UserTable deleteUserTable(String quoteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTableLocalService.deleteUserTable(quoteId);
	}

	/**
	 * Deletes the user table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userTable the user table
	 * @return the user table that was removed
	 */
	@Override
	public com.safesail.model.UserTable deleteUserTable(
		com.safesail.model.UserTable userTable) {

		return _userTableLocalService.deleteUserTable(userTable);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userTableLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userTableLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userTableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.safesail.model.UserTable fetchUserTable(String quoteId) {
		return _userTableLocalService.fetchUserTable(quoteId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTableLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.safesail.model.UserTable getQuoteId(String quoteId) {
		return _userTableLocalService.getQuoteId(quoteId);
	}

	@Override
	public java.util.List<com.safesail.model.UserTable> getUser(long userId) {
		return _userTableLocalService.getUser(userId);
	}

	/**
	 * Returns the user table with the primary key.
	 *
	 * @param quoteId the primary key of the user table
	 * @return the user table
	 * @throws PortalException if a user table with the primary key could not be found
	 */
	@Override
	public com.safesail.model.UserTable getUserTable(String quoteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userTableLocalService.getUserTable(quoteId);
	}

	/**
	 * Returns a range of all the user tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.UserTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user tables
	 * @param end the upper bound of the range of user tables (not inclusive)
	 * @return the range of user tables
	 */
	@Override
	public java.util.List<com.safesail.model.UserTable> getUserTables(
		int start, int end) {

		return _userTableLocalService.getUserTables(start, end);
	}

	/**
	 * Returns the number of user tables.
	 *
	 * @return the number of user tables
	 */
	@Override
	public int getUserTablesCount() {
		return _userTableLocalService.getUserTablesCount();
	}

	/**
	 * Updates the user table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userTable the user table
	 * @return the user table that was updated
	 */
	@Override
	public com.safesail.model.UserTable updateUserTable(
		com.safesail.model.UserTable userTable) {

		return _userTableLocalService.updateUserTable(userTable);
	}

	@Override
	public UserTableLocalService getWrappedService() {
		return _userTableLocalService;
	}

	@Override
	public void setWrappedService(UserTableLocalService userTableLocalService) {
		_userTableLocalService = userTableLocalService;
	}

	private UserTableLocalService _userTableLocalService;

}