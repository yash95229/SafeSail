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
 * Provides a wrapper for {@link PolicyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyLocalService
 * @generated
 */
public class PolicyLocalServiceWrapper
	implements PolicyLocalService, ServiceWrapper<PolicyLocalService> {

	public PolicyLocalServiceWrapper() {
		this(null);
	}

	public PolicyLocalServiceWrapper(PolicyLocalService policyLocalService) {
		_policyLocalService = policyLocalService;
	}

	@Override
	public com.safesail.model.Policy addPolicy(
		long bookingId, long applicationNumber, long userId, String fullName,
		String planName, String annualIncome, long sumAssured, int ppterm,
		String frequency, long premium, String quoteId, int status,
		long totalAddon) {

		return _policyLocalService.addPolicy(
			bookingId, applicationNumber, userId, fullName, planName,
			annualIncome, sumAssured, ppterm, frequency, premium, quoteId,
			status, totalAddon);
	}

	/**
	 * Adds the policy to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policy the policy
	 * @return the policy that was added
	 */
	@Override
	public com.safesail.model.Policy addPolicy(
		com.safesail.model.Policy policy) {

		return _policyLocalService.addPolicy(policy);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new policy with the primary key. Does not add the policy to the database.
	 *
	 * @param policyPK the primary key for the new policy
	 * @return the new policy
	 */
	@Override
	public com.safesail.model.Policy createPolicy(
		com.safesail.service.persistence.PolicyPK policyPK) {

		return _policyLocalService.createPolicy(policyPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the policy from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policy the policy
	 * @return the policy that was removed
	 */
	@Override
	public com.safesail.model.Policy deletePolicy(
		com.safesail.model.Policy policy) {

		return _policyLocalService.deletePolicy(policy);
	}

	/**
	 * Deletes the policy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy that was removed
	 * @throws PortalException if a policy with the primary key could not be found
	 */
	@Override
	public com.safesail.model.Policy deletePolicy(
			com.safesail.service.persistence.PolicyPK policyPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.deletePolicy(policyPK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _policyLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _policyLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _policyLocalService.dynamicQuery();
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

		return _policyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.PolicyModelImpl</code>.
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

		return _policyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.PolicyModelImpl</code>.
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

		return _policyLocalService.dynamicQuery(
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

		return _policyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _policyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.safesail.model.Policy fetchPolicy(
		com.safesail.service.persistence.PolicyPK policyPK) {

		return _policyLocalService.fetchPolicy(policyPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _policyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.safesail.model.Policy getapplicationNumber(
			long applicationNumber)
		throws com.safesail.exception.NoSuchPolicyException {

		return _policyLocalService.getapplicationNumber(applicationNumber);
	}

	@Override
	public com.safesail.model.Policy getByQuoteId(String quoteId)
		throws com.safesail.exception.NoSuchPolicyException {

		return _policyLocalService.getByQuoteId(quoteId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _policyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _policyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the policies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.safesail.model.impl.PolicyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policies
	 * @param end the upper bound of the range of policies (not inclusive)
	 * @return the range of policies
	 */
	@Override
	public java.util.List<com.safesail.model.Policy> getPolicies(
		int start, int end) {

		return _policyLocalService.getPolicies(start, end);
	}

	/**
	 * Returns the number of policies.
	 *
	 * @return the number of policies
	 */
	@Override
	public int getPoliciesCount() {
		return _policyLocalService.getPoliciesCount();
	}

	/**
	 * Returns the policy with the primary key.
	 *
	 * @param policyPK the primary key of the policy
	 * @return the policy
	 * @throws PortalException if a policy with the primary key could not be found
	 */
	@Override
	public com.safesail.model.Policy getPolicy(
			com.safesail.service.persistence.PolicyPK policyPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _policyLocalService.getPolicy(policyPK);
	}

	@Override
	public java.util.List getUser(long userId) {
		return _policyLocalService.getUser(userId);
	}

	/**
	 * Updates the policy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policy the policy
	 * @return the policy that was updated
	 */
	@Override
	public com.safesail.model.Policy updatePolicy(
		com.safesail.model.Policy policy) {

		return _policyLocalService.updatePolicy(policy);
	}

	@Override
	public PolicyLocalService getWrappedService() {
		return _policyLocalService;
	}

	@Override
	public void setWrappedService(PolicyLocalService policyLocalService) {
		_policyLocalService = policyLocalService;
	}

	private PolicyLocalService _policyLocalService;

}