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
 * The table class for the &quot;Safe_Sail_addOnFieldData&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see addOnFieldData
 * @generated
 */
public class addOnFieldDataTable extends BaseTable<addOnFieldDataTable> {

	public static final addOnFieldDataTable INSTANCE =
		new addOnFieldDataTable();

	public final Column<addOnFieldDataTable, Long> addonId = createColumn(
		"addonId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<addOnFieldDataTable, String> addonName = createColumn(
		"addonName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<addOnFieldDataTable, String> addonValue = createColumn(
		"addonValue", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private addOnFieldDataTable() {
		super("Safe_Sail_addOnFieldData", addOnFieldDataTable::new);
	}

}