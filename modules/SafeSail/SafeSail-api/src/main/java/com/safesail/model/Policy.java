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

package com.safesail.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Policy service. Represents a row in the &quot;Safe_Sail_Policy&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyModel
 * @generated
 */
@ImplementationClassName("com.safesail.model.impl.PolicyImpl")
@ProviderType
public interface Policy extends PersistedModel, PolicyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.safesail.model.impl.PolicyImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Policy, Long> BOOKING_ID_ACCESSOR =
		new Accessor<Policy, Long>() {

			@Override
			public Long get(Policy policy) {
				return policy.getBookingId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Policy> getTypeClass() {
				return Policy.class;
			}

		};
	public static final Accessor<Policy, Long> APPLICATION_NUMBER_ACCESSOR =
		new Accessor<Policy, Long>() {

			@Override
			public Long get(Policy policy) {
				return policy.getApplicationNumber();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Policy> getTypeClass() {
				return Policy.class;
			}

		};
	public static final Accessor<Policy, String> QUOTE_ID_ACCESSOR =
		new Accessor<Policy, String>() {

			@Override
			public String get(Policy policy) {
				return policy.getQuoteId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Policy> getTypeClass() {
				return Policy.class;
			}

		};

}