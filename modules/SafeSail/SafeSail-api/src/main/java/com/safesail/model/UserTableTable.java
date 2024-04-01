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
 * The table class for the &quot;Safe_Sail_UserTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserTable
 * @generated
 */
public class UserTableTable extends BaseTable<UserTableTable> {

	public static final UserTableTable INSTANCE = new UserTableTable();

	public final Column<UserTableTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserTableTable, String> quoteId = createColumn(
		"quoteId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<UserTableTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserTableTable, String> userType = createColumn(
		"userType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private UserTableTable() {
		super("Safe_Sail_UserTable", UserTableTable::new);
	}

}