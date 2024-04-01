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

/**
 * The table class for the &quot;Safe_Sail_FieldConfiguration&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FieldConfiguration
 * @generated
 */
public class FieldConfigurationTable
	extends BaseTable<FieldConfigurationTable> {

	public static final FieldConfigurationTable INSTANCE =
		new FieldConfigurationTable();

	public final Column<FieldConfigurationTable, Long> configId = createColumn(
		"configId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FieldConfigurationTable, String> fieldName =
		createColumn(
			"fieldName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FieldConfigurationTable, String> fieldData =
		createColumn(
			"fieldData", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FieldConfigurationTable, String> fieldValue =
		createColumn(
			"fieldValue", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FieldConfigurationTable, String> fieldSumAssured =
		createColumn(
			"fieldSumAssured", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FieldConfigurationTable, String> selectImage =
		createColumn(
			"selectImage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FieldConfigurationTable, Boolean> fieldShow =
		createColumn(
			"fieldShow", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private FieldConfigurationTable() {
		super("Safe_Sail_FieldConfiguration", FieldConfigurationTable::new);
	}

}