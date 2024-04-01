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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Safe_Sail_Policy&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Policy
 * @generated
 */
public class PolicyTable extends BaseTable<PolicyTable> {

	public static final PolicyTable INSTANCE = new PolicyTable();

	public final Column<PolicyTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> bookingId = createColumn(
		"bookingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PolicyTable, Long> applicationNumber = createColumn(
		"applicationNumber", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PolicyTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, String> fullName = createColumn(
		"fullName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, String> planName = createColumn(
		"planName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, String> annualIncome = createColumn(
		"annualIncome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Date> bookingDate = createColumn(
		"bookingDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> sumAssured = createColumn(
		"sumAssured", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Integer> policyTerm = createColumn(
		"policyTerm", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Date> maturityDate = createColumn(
		"maturityDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, String> paymentFrequency = createColumn(
		"paymentFrequency", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> totalPremium = createColumn(
		"totalPremium", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Long> totalAddon = createColumn(
		"totalAddon", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PolicyTable, String> quoteId = createColumn(
		"quoteId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);

	private PolicyTable() {
		super("Safe_Sail_Policy", PolicyTable::new);
	}

}