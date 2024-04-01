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

package com.safesail.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.safesail.model.ProductTable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProductTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductTableCacheModel
	implements CacheModel<ProductTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductTableCacheModel)) {
			return false;
		}

		ProductTableCacheModel productTableCacheModel =
			(ProductTableCacheModel)object;

		if (productId == productTableCacheModel.productId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", premiumDiscount=");
		sb.append(premiumDiscount);
		sb.append(", totalDiscount=");
		sb.append(totalDiscount);
		sb.append(", yearPay=");
		sb.append(yearPay);
		sb.append(", monthPay=");
		sb.append(monthPay);
		sb.append(", totalPremium=");
		sb.append(totalPremium);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductTable toEntityModel() {
		ProductTableImpl productTableImpl = new ProductTableImpl();

		if (uuid == null) {
			productTableImpl.setUuid("");
		}
		else {
			productTableImpl.setUuid(uuid);
		}

		productTableImpl.setProductId(productId);

		if (productName == null) {
			productTableImpl.setProductName("");
		}
		else {
			productTableImpl.setProductName(productName);
		}

		productTableImpl.setPremiumDiscount(premiumDiscount);
		productTableImpl.setTotalDiscount(totalDiscount);
		productTableImpl.setYearPay(yearPay);
		productTableImpl.setMonthPay(monthPay);
		productTableImpl.setTotalPremium(totalPremium);

		productTableImpl.resetOriginalValues();

		return productTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productId = objectInput.readLong();
		productName = objectInput.readUTF();

		premiumDiscount = objectInput.readInt();

		totalDiscount = objectInput.readInt();

		yearPay = objectInput.readLong();

		monthPay = objectInput.readLong();

		totalPremium = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(productId);

		if (productName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(productName);
		}

		objectOutput.writeInt(premiumDiscount);

		objectOutput.writeInt(totalDiscount);

		objectOutput.writeLong(yearPay);

		objectOutput.writeLong(monthPay);

		objectOutput.writeLong(totalPremium);
	}

	public String uuid;
	public long productId;
	public String productName;
	public int premiumDiscount;
	public int totalDiscount;
	public long yearPay;
	public long monthPay;
	public long totalPremium;

}