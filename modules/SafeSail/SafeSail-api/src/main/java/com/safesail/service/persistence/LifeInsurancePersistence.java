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

import com.safesail.exception.NoSuchLifeInsuranceException;
import com.safesail.model.LifeInsurance;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the life insurance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LifeInsuranceUtil
 * @generated
 */
@ProviderType
public interface LifeInsurancePersistence
	extends BasePersistence<LifeInsurance> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LifeInsuranceUtil} to access the life insurance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the life insurances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching life insurances
	 */
	public java.util.List<LifeInsurance> findByUuid(String uuid);

	/**
	 * Returns a range of all the life insurances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the life insurances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the life insurances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
				orderByComparator)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the first life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns the last life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
				orderByComparator)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the last life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns the life insurances before and after the current life insurance in the ordered set where uuid = &#63;.
	 *
	 * @param quoteId the primary key of the current life insurance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next life insurance
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	public LifeInsurance[] findByUuid_PrevAndNext(
			String quoteId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
				orderByComparator)
		throws NoSuchLifeInsuranceException;

	/**
	 * Removes all the life insurances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of life insurances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching life insurances
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the life insurance where userId = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByuserId(long userId)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the life insurance where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByuserId(long userId);

	/**
	 * Returns the life insurance where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByuserId(long userId, boolean useFinderCache);

	/**
	 * Removes the life insurance where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the life insurance that was removed
	 */
	public LifeInsurance removeByuserId(long userId)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the number of life insurances where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching life insurances
	 */
	public int countByuserId(long userId);

	/**
	 * Returns the life insurance where quoteId = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByquoteId(String quoteId)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the life insurance where quoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByquoteId(String quoteId);

	/**
	 * Returns the life insurance where quoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quoteId the quote ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByquoteId(String quoteId, boolean useFinderCache);

	/**
	 * Removes the life insurance where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 * @return the life insurance that was removed
	 */
	public LifeInsurance removeByquoteId(String quoteId)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the number of life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching life insurances
	 */
	public int countByquoteId(String quoteId);

	/**
	 * Returns all the life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the matching life insurances
	 */
	public java.util.List<LifeInsurance> findByquoteIds(String quoteId);

	/**
	 * Returns a range of all the life insurances where quoteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param quoteId the quote ID
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end);

	/**
	 * Returns an ordered range of all the life insurances where quoteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param quoteId the quote ID
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the life insurances where quoteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param quoteId the quote ID
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByquoteIds(
		String quoteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByquoteIds_First(
			String quoteId,
			com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
				orderByComparator)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the first life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByquoteIds_First(
		String quoteId,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns the last life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByquoteIds_Last(
			String quoteId,
			com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
				orderByComparator)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the last life insurance in the ordered set where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByquoteIds_Last(
		String quoteId,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Removes all the life insurances where quoteId = &#63; from the database.
	 *
	 * @param quoteId the quote ID
	 */
	public void removeByquoteIds(String quoteId);

	/**
	 * Returns the number of life insurances where quoteId = &#63;.
	 *
	 * @param quoteId the quote ID
	 * @return the number of matching life insurances
	 */
	public int countByquoteIds(String quoteId);

	/**
	 * Returns the life insurance where aadharNumber = &#63; or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByaadharNumber(String aadharNumber)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the life insurance where aadharNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByaadharNumber(String aadharNumber);

	/**
	 * Returns the life insurance where aadharNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param aadharNumber the aadhar number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByaadharNumber(
		String aadharNumber, boolean useFinderCache);

	/**
	 * Removes the life insurance where aadharNumber = &#63; from the database.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the life insurance that was removed
	 */
	public LifeInsurance removeByaadharNumber(String aadharNumber)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the number of life insurances where aadharNumber = &#63;.
	 *
	 * @param aadharNumber the aadhar number
	 * @return the number of matching life insurances
	 */
	public int countByaadharNumber(String aadharNumber);

	/**
	 * Returns all the life insurances where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching life insurances
	 */
	public java.util.List<LifeInsurance> findByemailAddress(
		String emailAddress);

	/**
	 * Returns a range of all the life insurances where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end);

	/**
	 * Returns an ordered range of all the life insurances where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the life insurances where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching life insurances
	 */
	public java.util.List<LifeInsurance> findByemailAddress(
		String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByemailAddress_First(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
				orderByComparator)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the first life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByemailAddress_First(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns the last life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance
	 * @throws NoSuchLifeInsuranceException if a matching life insurance could not be found
	 */
	public LifeInsurance findByemailAddress_Last(
			String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
				orderByComparator)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the last life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching life insurance, or <code>null</code> if a matching life insurance could not be found
	 */
	public LifeInsurance fetchByemailAddress_Last(
		String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns the life insurances before and after the current life insurance in the ordered set where emailAddress = &#63;.
	 *
	 * @param quoteId the primary key of the current life insurance
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next life insurance
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	public LifeInsurance[] findByemailAddress_PrevAndNext(
			String quoteId, String emailAddress,
			com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
				orderByComparator)
		throws NoSuchLifeInsuranceException;

	/**
	 * Removes all the life insurances where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 */
	public void removeByemailAddress(String emailAddress);

	/**
	 * Returns the number of life insurances where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching life insurances
	 */
	public int countByemailAddress(String emailAddress);

	/**
	 * Caches the life insurance in the entity cache if it is enabled.
	 *
	 * @param lifeInsurance the life insurance
	 */
	public void cacheResult(LifeInsurance lifeInsurance);

	/**
	 * Caches the life insurances in the entity cache if it is enabled.
	 *
	 * @param lifeInsurances the life insurances
	 */
	public void cacheResult(java.util.List<LifeInsurance> lifeInsurances);

	/**
	 * Creates a new life insurance with the primary key. Does not add the life insurance to the database.
	 *
	 * @param quoteId the primary key for the new life insurance
	 * @return the new life insurance
	 */
	public LifeInsurance create(String quoteId);

	/**
	 * Removes the life insurance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance that was removed
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	public LifeInsurance remove(String quoteId)
		throws NoSuchLifeInsuranceException;

	public LifeInsurance updateImpl(LifeInsurance lifeInsurance);

	/**
	 * Returns the life insurance with the primary key or throws a <code>NoSuchLifeInsuranceException</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance
	 * @throws NoSuchLifeInsuranceException if a life insurance with the primary key could not be found
	 */
	public LifeInsurance findByPrimaryKey(String quoteId)
		throws NoSuchLifeInsuranceException;

	/**
	 * Returns the life insurance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quoteId the primary key of the life insurance
	 * @return the life insurance, or <code>null</code> if a life insurance with the primary key could not be found
	 */
	public LifeInsurance fetchByPrimaryKey(String quoteId);

	/**
	 * Returns all the life insurances.
	 *
	 * @return the life insurances
	 */
	public java.util.List<LifeInsurance> findAll();

	/**
	 * Returns a range of all the life insurances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @return the range of life insurances
	 */
	public java.util.List<LifeInsurance> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the life insurances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of life insurances
	 */
	public java.util.List<LifeInsurance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the life insurances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LifeInsuranceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of life insurances
	 * @param end the upper bound of the range of life insurances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of life insurances
	 */
	public java.util.List<LifeInsurance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LifeInsurance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the life insurances from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of life insurances.
	 *
	 * @return the number of life insurances
	 */
	public int countAll();

}