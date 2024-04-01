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
 * The table class for the &quot;Safe_Sail_LifeInsurance&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see LifeInsurance
 * @generated
 */
public class LifeInsuranceTable extends BaseTable<LifeInsuranceTable> {

	public static final LifeInsuranceTable INSTANCE = new LifeInsuranceTable();

	public final Column<LifeInsuranceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> quoteId = createColumn(
		"quoteId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<LifeInsuranceTable, String> fullname = createColumn(
		"fullname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Date> dob = createColumn(
		"dob", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Long> phoneNo = createColumn(
		"phoneNo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> emailAddress = createColumn(
		"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> aadharNumber = createColumn(
		"aadharNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> panNumber = createColumn(
		"panNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> annualIncome = createColumn(
		"annualIncome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Long> sumAssured = createColumn(
		"sumAssured", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Integer> policyTerm = createColumn(
		"policyTerm", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Integer> PPTerm = createColumn(
		"PPTerm", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> paymentFrequency =
		createColumn(
			"paymentFrequency", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> PayoutOption = createColumn(
		"PayoutOption", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Integer> lifeSecure = createColumn(
		"lifeSecure", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Integer> lifePlus = createColumn(
		"lifePlus", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Integer> CIPBenefit = createColumn(
		"CIPBenefit", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, String> addOnBenefits =
		createColumn(
			"addOnBenefits", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Long> totalValues = createColumn(
		"totalValues", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Long> totalAddon = createColumn(
		"totalAddon", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Boolean> agreement = createColumn(
		"agreement", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<LifeInsuranceTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LifeInsuranceTable() {
		super("Safe_Sail_LifeInsurance", LifeInsuranceTable::new);
	}

}