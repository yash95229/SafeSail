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

import com.safesail.exception.NoSuchAadhaarVerificationException;
import com.safesail.model.AadhaarVerification;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the aadhaar verification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AadhaarVerificationUtil
 * @generated
 */
@ProviderType
public interface AadhaarVerificationPersistence
	extends BasePersistence<AadhaarVerification> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AadhaarVerificationUtil} to access the aadhaar verification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @return the matching aadhaar verifications
	 */
	public java.util.List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber);

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
	public java.util.List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end);

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
	public java.util.List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AadhaarVerification>
			orderByComparator);

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
	public java.util.List<AadhaarVerification> findByaadhaarNumber(
		String aadhaarNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AadhaarVerification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a matching aadhaar verification could not be found
	 */
	public AadhaarVerification findByaadhaarNumber_First(
			String aadhaarNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<AadhaarVerification> orderByComparator)
		throws NoSuchAadhaarVerificationException;

	/**
	 * Returns the first aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching aadhaar verification, or <code>null</code> if a matching aadhaar verification could not be found
	 */
	public AadhaarVerification fetchByaadhaarNumber_First(
		String aadhaarNumber,
		com.liferay.portal.kernel.util.OrderByComparator<AadhaarVerification>
			orderByComparator);

	/**
	 * Returns the last aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a matching aadhaar verification could not be found
	 */
	public AadhaarVerification findByaadhaarNumber_Last(
			String aadhaarNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<AadhaarVerification> orderByComparator)
		throws NoSuchAadhaarVerificationException;

	/**
	 * Returns the last aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching aadhaar verification, or <code>null</code> if a matching aadhaar verification could not be found
	 */
	public AadhaarVerification fetchByaadhaarNumber_Last(
		String aadhaarNumber,
		com.liferay.portal.kernel.util.OrderByComparator<AadhaarVerification>
			orderByComparator);

	/**
	 * Returns the aadhaar verifications before and after the current aadhaar verification in the ordered set where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarId the primary key of the current aadhaar verification
	 * @param aadhaarNumber the aadhaar number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	public AadhaarVerification[] findByaadhaarNumber_PrevAndNext(
			long aadhaarId, String aadhaarNumber,
			com.liferay.portal.kernel.util.OrderByComparator
				<AadhaarVerification> orderByComparator)
		throws NoSuchAadhaarVerificationException;

	/**
	 * Removes all the aadhaar verifications where aadhaarNumber = &#63; from the database.
	 *
	 * @param aadhaarNumber the aadhaar number
	 */
	public void removeByaadhaarNumber(String aadhaarNumber);

	/**
	 * Returns the number of aadhaar verifications where aadhaarNumber = &#63;.
	 *
	 * @param aadhaarNumber the aadhaar number
	 * @return the number of matching aadhaar verifications
	 */
	public int countByaadhaarNumber(String aadhaarNumber);

	/**
	 * Caches the aadhaar verification in the entity cache if it is enabled.
	 *
	 * @param aadhaarVerification the aadhaar verification
	 */
	public void cacheResult(AadhaarVerification aadhaarVerification);

	/**
	 * Caches the aadhaar verifications in the entity cache if it is enabled.
	 *
	 * @param aadhaarVerifications the aadhaar verifications
	 */
	public void cacheResult(
		java.util.List<AadhaarVerification> aadhaarVerifications);

	/**
	 * Creates a new aadhaar verification with the primary key. Does not add the aadhaar verification to the database.
	 *
	 * @param aadhaarId the primary key for the new aadhaar verification
	 * @return the new aadhaar verification
	 */
	public AadhaarVerification create(long aadhaarId);

	/**
	 * Removes the aadhaar verification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification that was removed
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	public AadhaarVerification remove(long aadhaarId)
		throws NoSuchAadhaarVerificationException;

	public AadhaarVerification updateImpl(
		AadhaarVerification aadhaarVerification);

	/**
	 * Returns the aadhaar verification with the primary key or throws a <code>NoSuchAadhaarVerificationException</code> if it could not be found.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification
	 * @throws NoSuchAadhaarVerificationException if a aadhaar verification with the primary key could not be found
	 */
	public AadhaarVerification findByPrimaryKey(long aadhaarId)
		throws NoSuchAadhaarVerificationException;

	/**
	 * Returns the aadhaar verification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param aadhaarId the primary key of the aadhaar verification
	 * @return the aadhaar verification, or <code>null</code> if a aadhaar verification with the primary key could not be found
	 */
	public AadhaarVerification fetchByPrimaryKey(long aadhaarId);

	/**
	 * Returns all the aadhaar verifications.
	 *
	 * @return the aadhaar verifications
	 */
	public java.util.List<AadhaarVerification> findAll();

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
	public java.util.List<AadhaarVerification> findAll(int start, int end);

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
	public java.util.List<AadhaarVerification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AadhaarVerification>
			orderByComparator);

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
	public java.util.List<AadhaarVerification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AadhaarVerification>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the aadhaar verifications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of aadhaar verifications.
	 *
	 * @return the number of aadhaar verifications
	 */
	public int countAll();

}