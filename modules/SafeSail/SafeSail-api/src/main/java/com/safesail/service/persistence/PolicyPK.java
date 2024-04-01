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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PolicyPK implements Comparable<PolicyPK>, Serializable {

	public long bookingId;
	public long applicationNumber;
	public String quoteId;

	public PolicyPK() {
	}

	public PolicyPK(long bookingId, long applicationNumber, String quoteId) {
		this.bookingId = bookingId;
		this.applicationNumber = applicationNumber;
		this.quoteId = quoteId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(long applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	@Override
	public int compareTo(PolicyPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (bookingId < pk.bookingId) {
			value = -1;
		}
		else if (bookingId > pk.bookingId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (applicationNumber < pk.applicationNumber) {
			value = -1;
		}
		else if (applicationNumber > pk.applicationNumber) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = quoteId.compareTo(pk.quoteId);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PolicyPK)) {
			return false;
		}

		PolicyPK pk = (PolicyPK)object;

		if ((bookingId == pk.bookingId) &&
			(applicationNumber == pk.applicationNumber) &&
			quoteId.equals(pk.quoteId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, bookingId);
		hashCode = HashUtil.hash(hashCode, applicationNumber);
		hashCode = HashUtil.hash(hashCode, quoteId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(8);

		sb.append("{");

		sb.append("bookingId=");

		sb.append(bookingId);
		sb.append(", applicationNumber=");

		sb.append(applicationNumber);
		sb.append(", quoteId=");

		sb.append(quoteId);

		sb.append("}");

		return sb.toString();
	}

}