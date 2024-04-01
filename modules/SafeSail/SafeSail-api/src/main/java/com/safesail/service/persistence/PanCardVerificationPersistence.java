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

package com.safesail.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.safesail.exception.NoSuchPanCardVerificationException;
import com.safesail.model.PanCardVerification;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pan card verification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PanCardVerificationUtil
 * @generated
 */
@ProviderType
public interface PanCardVerificationPersistence
	extends BasePersistence<PanCardVerification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PanCardVerificationUtil} to access the pan card verification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the pan card verifications where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @return the matching pan card verifications
	 */
	public java.util.List<PanCardVerification> findBypanNumber(
		String panNumber);

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
	public java.util.List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end);

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
	public java.util.List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PanCardVerification>
			orderByComparator);

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
	public java.util.List<PanCardVerification> findBypanNumber(
		String panNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PanCardVerification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pan card verification
	 * @throws NoSuchPanCardVerificationException if a matching pan card verification could not be found
	 */
	public PanCardVerification findBypanNumber_First(
			String panNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<PanCardVerification> orderByComparator)
		throws NoSuchPanCardVerificationException;

	/**
	 * Returns the first pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pan card verification, or <code>null</code> if a matching pan card verification could not be found
	 */
	public PanCardVerification fetchBypanNumber_First(
		String panNumber,
		com.liferay.portal.kernel.util.OrderByComparator<PanCardVerification>
			orderByComparator);

	/**
	 * Returns the last pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pan card verification
	 * @throws NoSuchPanCardVerificationException if a matching pan card verification could not be found
	 */
	public PanCardVerification findBypanNumber_Last(
			String panNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<PanCardVerification> orderByComparator)
		throws NoSuchPanCardVerificationException;

	/**
	 * Returns the last pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pan card verification, or <code>null</code> if a matching pan card verification could not be found
	 */
	public PanCardVerification fetchBypanNumber_Last(
		String panNumber,
		com.liferay.portal.kernel.util.OrderByComparator<PanCardVerification>
			orderByComparator);

	/**
	 * Returns the pan card verifications before and after the current pan card verification in the ordered set where panNumber = &#63;.
	 *
	 * @param panId the primary key of the current pan card verification
	 * @param panNumber the pan number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pan card verification
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	public PanCardVerification[] findBypanNumber_PrevAndNext(
			long panId, String panNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<PanCardVerification> orderByComparator)
		throws NoSuchPanCardVerificationException;

	/**
	 * Removes all the pan card verifications where panNumber = &#63; from the database.
	 *
	 * @param panNumber the pan number
	 */
	public void removeBypanNumber(String panNumber);

	/**
	 * Returns the number of pan card verifications where panNumber = &#63;.
	 *
	 * @param panNumber the pan number
	 * @return the number of matching pan card verifications
	 */
	public int countBypanNumber(String panNumber);

	/**
	 * Caches the pan card verification in the entity cache if it is enabled.
	 *
	 * @param panCardVerification the pan card verification
	 */
	public void cacheResult(PanCardVerification panCardVerification);

	/**
	 * Caches the pan card verifications in the entity cache if it is enabled.
	 *
	 * @param panCardVerifications the pan card verifications
	 */
	public void cacheResult(
		java.util.List<PanCardVerification> panCardVerifications);

	/**
	 * Creates a new pan card verification with the primary key. Does not add the pan card verification to the database.
	 *
	 * @param panId the primary key for the new pan card verification
	 * @return the new pan card verification
	 */
	public PanCardVerification create(long panId);

	/**
	 * Removes the pan card verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification that was removed
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	public PanCardVerification remove(long panId)
		throws NoSuchPanCardVerificationException;

	public PanCardVerification updateImpl(
		PanCardVerification panCardVerification);

	/**
	 * Returns the pan card verification with the primary key or throws a <code>NoSuchPanCardVerificationException</code> if it could not be found.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification
	 * @throws NoSuchPanCardVerificationException if a pan card verification with the primary key could not be found
	 */
	public PanCardVerification findByPrimaryKey(long panId)
		throws NoSuchPanCardVerificationException;

	/**
	 * Returns the pan card verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param panId the primary key of the pan card verification
	 * @return the pan card verification, or <code>null</code> if a pan card verification with the primary key could not be found
	 */
	public PanCardVerification fetchByPrimaryKey(long panId);

	/**
	 * Returns all the pan card verifications.
	 *
	 * @return the pan card verifications
	 */
	public java.util.List<PanCardVerification> findAll();

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
	public java.util.List<PanCardVerification> findAll(int start, int end);

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
	public java.util.List<PanCardVerification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PanCardVerification>
			orderByComparator);

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
	public java.util.List<PanCardVerification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PanCardVerification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pan card verifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pan card verifications.
	 *
	 * @return the number of pan card verifications
	 */
	public int countAll();

}