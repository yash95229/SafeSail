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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProductTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductTable
 * @generated
 */
public class ProductTableWrapper
	extends BaseModelWrapper<ProductTable>
	implements ModelWrapper<ProductTable>, ProductTable {

	public ProductTableWrapper(ProductTable productTable) {
		super(productTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productId", getProductId());
		attributes.put("productName", getProductName());
		attributes.put("premiumDiscount", getPremiumDiscount());
		attributes.put("totalDiscount", getTotalDiscount());
		attributes.put("yearPay", getYearPay());
		attributes.put("monthPay", getMonthPay());
		attributes.put("totalPremium", getTotalPremium());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		Integer premiumDiscount = (Integer)attributes.get("premiumDiscount");

		if (premiumDiscount != null) {
			setPremiumDiscount(premiumDiscount);
		}

		Integer totalDiscount = (Integer)attributes.get("totalDiscount");

		if (totalDiscount != null) {
			setTotalDiscount(totalDiscount);
		}

		Long yearPay = (Long)attributes.get("yearPay");

		if (yearPay != null) {
			setYearPay(yearPay);
		}

		Long monthPay = (Long)attributes.get("monthPay");

		if (monthPay != null) {
			setMonthPay(monthPay);
		}

		Long totalPremium = (Long)attributes.get("totalPremium");

		if (totalPremium != null) {
			setTotalPremium(totalPremium);
		}
	}

	@Override
	public ProductTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the month pay of this product table.
	 *
	 * @return the month pay of this product table
	 */
	@Override
	public long getMonthPay() {
		return model.getMonthPay();
	}

	/**
	 * Returns the premium discount of this product table.
	 *
	 * @return the premium discount of this product table
	 */
	@Override
	public int getPremiumDiscount() {
		return model.getPremiumDiscount();
	}

	/**
	 * Returns the primary key of this product table.
	 *
	 * @return the primary key of this product table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this product table.
	 *
	 * @return the product ID of this product table
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the product name of this product table.
	 *
	 * @return the product name of this product table
	 */
	@Override
	public String getProductName() {
		return model.getProductName();
	}

	/**
	 * Returns the total discount of this product table.
	 *
	 * @return the total discount of this product table
	 */
	@Override
	public int getTotalDiscount() {
		return model.getTotalDiscount();
	}

	/**
	 * Returns the total premium of this product table.
	 *
	 * @return the total premium of this product table
	 */
	@Override
	public long getTotalPremium() {
		return model.getTotalPremium();
	}

	/**
	 * Returns the uuid of this product table.
	 *
	 * @return the uuid of this product table
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the year pay of this product table.
	 *
	 * @return the year pay of this product table
	 */
	@Override
	public long getYearPay() {
		return model.getYearPay();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the month pay of this product table.
	 *
	 * @param monthPay the month pay of this product table
	 */
	@Override
	public void setMonthPay(long monthPay) {
		model.setMonthPay(monthPay);
	}

	/**
	 * Sets the premium discount of this product table.
	 *
	 * @param premiumDiscount the premium discount of this product table
	 */
	@Override
	public void setPremiumDiscount(int premiumDiscount) {
		model.setPremiumDiscount(premiumDiscount);
	}

	/**
	 * Sets the primary key of this product table.
	 *
	 * @param primaryKey the primary key of this product table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this product table.
	 *
	 * @param productId the product ID of this product table
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the product name of this product table.
	 *
	 * @param productName the product name of this product table
	 */
	@Override
	public void setProductName(String productName) {
		model.setProductName(productName);
	}

	/**
	 * Sets the total discount of this product table.
	 *
	 * @param totalDiscount the total discount of this product table
	 */
	@Override
	public void setTotalDiscount(int totalDiscount) {
		model.setTotalDiscount(totalDiscount);
	}

	/**
	 * Sets the total premium of this product table.
	 *
	 * @param totalPremium the total premium of this product table
	 */
	@Override
	public void setTotalPremium(long totalPremium) {
		model.setTotalPremium(totalPremium);
	}

	/**
	 * Sets the uuid of this product table.
	 *
	 * @param uuid the uuid of this product table
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the year pay of this product table.
	 *
	 * @param yearPay the year pay of this product table
	 */
	@Override
	public void setYearPay(long yearPay) {
		model.setYearPay(yearPay);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ProductTableWrapper wrap(ProductTable productTable) {
		return new ProductTableWrapper(productTable);
	}

}