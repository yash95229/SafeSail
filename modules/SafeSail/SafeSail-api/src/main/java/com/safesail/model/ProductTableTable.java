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
 * The table class for the &quot;Safe_Sail_ProductTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductTable
 * @generated
 */
public class ProductTableTable extends BaseTable<ProductTableTable> {

	public static final ProductTableTable INSTANCE = new ProductTableTable();

	public final Column<ProductTableTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTableTable, Long> productId = createColumn(
		"productId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductTableTable, String> productName = createColumn(
		"productName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductTableTable, Integer> premiumDiscount =
		createColumn(
			"premiumDiscount", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<ProductTableTable, Integer> totalDiscount =
		createColumn(
			"totalDiscount", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProductTableTable, Long> yearPay = createColumn(
		"yearPay", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTableTable, Long> monthPay = createColumn(
		"monthPay", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductTableTable, Long> totalPremium = createColumn(
		"totalPremium", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProductTableTable() {
		super("Safe_Sail_ProductTable", ProductTableTable::new);
	}

}