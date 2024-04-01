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

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.safesail.model.LifeInsurance;
import com.safesail.model.LifeInsuranceModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the LifeInsurance service. Represents a row in the &quot;Safe_Sail_LifeInsurance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>LifeInsuranceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LifeInsuranceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LifeInsuranceImpl
 * @generated
 */
@JSON(strict = true)
public class LifeInsuranceModelImpl
	extends BaseModelImpl<LifeInsurance> implements LifeInsuranceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a life insurance model instance should use the <code>LifeInsurance</code> interface instead.
	 */
	public static final String TABLE_NAME = "Safe_Sail_LifeInsurance";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"quoteId", Types.VARCHAR},
		{"fullname", Types.VARCHAR}, {"dob", Types.TIMESTAMP},
		{"gender", Types.VARCHAR}, {"phoneNo", Types.BIGINT},
		{"emailAddress", Types.VARCHAR}, {"aadharNumber", Types.VARCHAR},
		{"panNumber", Types.VARCHAR}, {"annualIncome", Types.VARCHAR},
		{"sumAssured", Types.BIGINT}, {"policyTerm", Types.INTEGER},
		{"PPTerm", Types.INTEGER}, {"paymentFrequency", Types.VARCHAR},
		{"PayoutOption", Types.VARCHAR}, {"lifeSecure", Types.INTEGER},
		{"lifePlus", Types.INTEGER}, {"CIPBenefit", Types.INTEGER},
		{"addOnBenefits", Types.VARCHAR}, {"totalValues", Types.BIGINT},
		{"totalAddon", Types.BIGINT}, {"agreement", Types.BOOLEAN},
		{"userId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("quoteId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fullname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dob", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("gender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("phoneNo", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("emailAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("aadharNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("panNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("annualIncome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sumAssured", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("policyTerm", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("PPTerm", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("paymentFrequency", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PayoutOption", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lifeSecure", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lifePlus", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("CIPBenefit", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("addOnBenefits", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("totalValues", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("totalAddon", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("agreement", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Safe_Sail_LifeInsurance (uuid_ VARCHAR(75) null,quoteId VARCHAR(75) not null primary key,fullname VARCHAR(75) null,dob DATE null,gender VARCHAR(75) null,phoneNo LONG,emailAddress VARCHAR(75) null,aadharNumber VARCHAR(75) null,panNumber VARCHAR(75) null,annualIncome VARCHAR(75) null,sumAssured LONG,policyTerm INTEGER,PPTerm INTEGER,paymentFrequency VARCHAR(75) null,PayoutOption VARCHAR(75) null,lifeSecure INTEGER,lifePlus INTEGER,CIPBenefit INTEGER,addOnBenefits VARCHAR(75) null,totalValues LONG,totalAddon LONG,agreement BOOLEAN,userId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table Safe_Sail_LifeInsurance";

	public static final String ORDER_BY_JPQL =
		" ORDER BY lifeInsurance.quoteId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Safe_Sail_LifeInsurance.quoteId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AADHARNUMBER_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMAILADDRESS_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long QUOTEID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public LifeInsuranceModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _quoteId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setQuoteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _quoteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return LifeInsurance.class;
	}

	@Override
	public String getModelClassName() {
		return LifeInsurance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LifeInsurance, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LifeInsurance, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LifeInsurance, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((LifeInsurance)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LifeInsurance, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LifeInsurance, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LifeInsurance)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LifeInsurance, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LifeInsurance, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<LifeInsurance, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LifeInsurance, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LifeInsurance, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<LifeInsurance, Object>>();
		Map<String, BiConsumer<LifeInsurance, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<LifeInsurance, ?>>();

		attributeGetterFunctions.put("uuid", LifeInsurance::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<LifeInsurance, String>)LifeInsurance::setUuid);
		attributeGetterFunctions.put("quoteId", LifeInsurance::getQuoteId);
		attributeSetterBiConsumers.put(
			"quoteId",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setQuoteId);
		attributeGetterFunctions.put("fullname", LifeInsurance::getFullname);
		attributeSetterBiConsumers.put(
			"fullname",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setFullname);
		attributeGetterFunctions.put("dob", LifeInsurance::getDob);
		attributeSetterBiConsumers.put(
			"dob", (BiConsumer<LifeInsurance, Date>)LifeInsurance::setDob);
		attributeGetterFunctions.put("gender", LifeInsurance::getGender);
		attributeSetterBiConsumers.put(
			"gender",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setGender);
		attributeGetterFunctions.put("phoneNo", LifeInsurance::getPhoneNo);
		attributeSetterBiConsumers.put(
			"phoneNo",
			(BiConsumer<LifeInsurance, Long>)LifeInsurance::setPhoneNo);
		attributeGetterFunctions.put(
			"emailAddress", LifeInsurance::getEmailAddress);
		attributeSetterBiConsumers.put(
			"emailAddress",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setEmailAddress);
		attributeGetterFunctions.put(
			"aadharNumber", LifeInsurance::getAadharNumber);
		attributeSetterBiConsumers.put(
			"aadharNumber",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setAadharNumber);
		attributeGetterFunctions.put("panNumber", LifeInsurance::getPanNumber);
		attributeSetterBiConsumers.put(
			"panNumber",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setPanNumber);
		attributeGetterFunctions.put(
			"annualIncome", LifeInsurance::getAnnualIncome);
		attributeSetterBiConsumers.put(
			"annualIncome",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setAnnualIncome);
		attributeGetterFunctions.put(
			"sumAssured", LifeInsurance::getSumAssured);
		attributeSetterBiConsumers.put(
			"sumAssured",
			(BiConsumer<LifeInsurance, Long>)LifeInsurance::setSumAssured);
		attributeGetterFunctions.put(
			"policyTerm", LifeInsurance::getPolicyTerm);
		attributeSetterBiConsumers.put(
			"policyTerm",
			(BiConsumer<LifeInsurance, Integer>)LifeInsurance::setPolicyTerm);
		attributeGetterFunctions.put("PPTerm", LifeInsurance::getPPTerm);
		attributeSetterBiConsumers.put(
			"PPTerm",
			(BiConsumer<LifeInsurance, Integer>)LifeInsurance::setPPTerm);
		attributeGetterFunctions.put(
			"paymentFrequency", LifeInsurance::getPaymentFrequency);
		attributeSetterBiConsumers.put(
			"paymentFrequency",
			(BiConsumer<LifeInsurance, String>)
				LifeInsurance::setPaymentFrequency);
		attributeGetterFunctions.put(
			"PayoutOption", LifeInsurance::getPayoutOption);
		attributeSetterBiConsumers.put(
			"PayoutOption",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setPayoutOption);
		attributeGetterFunctions.put(
			"lifeSecure", LifeInsurance::getLifeSecure);
		attributeSetterBiConsumers.put(
			"lifeSecure",
			(BiConsumer<LifeInsurance, Integer>)LifeInsurance::setLifeSecure);
		attributeGetterFunctions.put("lifePlus", LifeInsurance::getLifePlus);
		attributeSetterBiConsumers.put(
			"lifePlus",
			(BiConsumer<LifeInsurance, Integer>)LifeInsurance::setLifePlus);
		attributeGetterFunctions.put(
			"CIPBenefit", LifeInsurance::getCIPBenefit);
		attributeSetterBiConsumers.put(
			"CIPBenefit",
			(BiConsumer<LifeInsurance, Integer>)LifeInsurance::setCIPBenefit);
		attributeGetterFunctions.put(
			"addOnBenefits", LifeInsurance::getAddOnBenefits);
		attributeSetterBiConsumers.put(
			"addOnBenefits",
			(BiConsumer<LifeInsurance, String>)LifeInsurance::setAddOnBenefits);
		attributeGetterFunctions.put(
			"totalValues", LifeInsurance::getTotalValues);
		attributeSetterBiConsumers.put(
			"totalValues",
			(BiConsumer<LifeInsurance, Long>)LifeInsurance::setTotalValues);
		attributeGetterFunctions.put(
			"totalAddon", LifeInsurance::getTotalAddon);
		attributeSetterBiConsumers.put(
			"totalAddon",
			(BiConsumer<LifeInsurance, Long>)LifeInsurance::setTotalAddon);
		attributeGetterFunctions.put("agreement", LifeInsurance::getAgreement);
		attributeSetterBiConsumers.put(
			"agreement",
			(BiConsumer<LifeInsurance, Boolean>)LifeInsurance::setAgreement);
		attributeGetterFunctions.put("userId", LifeInsurance::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<LifeInsurance, Long>)LifeInsurance::setUserId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public String getQuoteId() {
		if (_quoteId == null) {
			return "";
		}
		else {
			return _quoteId;
		}
	}

	@Override
	public void setQuoteId(String quoteId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_quoteId = quoteId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalQuoteId() {
		return getColumnOriginalValue("quoteId");
	}

	@JSON
	@Override
	public String getFullname() {
		if (_fullname == null) {
			return "";
		}
		else {
			return _fullname;
		}
	}

	@Override
	public void setFullname(String fullname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_fullname = fullname;
	}

	@JSON
	@Override
	public Date getDob() {
		return _dob;
	}

	@Override
	public void setDob(Date dob) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dob = dob;
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return "";
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gender = gender;
	}

	@JSON
	@Override
	public long getPhoneNo() {
		return _phoneNo;
	}

	@Override
	public void setPhoneNo(long phoneNo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_phoneNo = phoneNo;
	}

	@JSON
	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return "";
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_emailAddress = emailAddress;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEmailAddress() {
		return getColumnOriginalValue("emailAddress");
	}

	@JSON
	@Override
	public String getAadharNumber() {
		if (_aadharNumber == null) {
			return "";
		}
		else {
			return _aadharNumber;
		}
	}

	@Override
	public void setAadharNumber(String aadharNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_aadharNumber = aadharNumber;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalAadharNumber() {
		return getColumnOriginalValue("aadharNumber");
	}

	@JSON
	@Override
	public String getPanNumber() {
		if (_panNumber == null) {
			return "";
		}
		else {
			return _panNumber;
		}
	}

	@Override
	public void setPanNumber(String panNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_panNumber = panNumber;
	}

	@JSON
	@Override
	public String getAnnualIncome() {
		if (_annualIncome == null) {
			return "";
		}
		else {
			return _annualIncome;
		}
	}

	@Override
	public void setAnnualIncome(String annualIncome) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_annualIncome = annualIncome;
	}

	@JSON
	@Override
	public long getSumAssured() {
		return _sumAssured;
	}

	@Override
	public void setSumAssured(long sumAssured) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sumAssured = sumAssured;
	}

	@JSON
	@Override
	public int getPolicyTerm() {
		return _policyTerm;
	}

	@Override
	public void setPolicyTerm(int policyTerm) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_policyTerm = policyTerm;
	}

	@JSON
	@Override
	public int getPPTerm() {
		return _PPTerm;
	}

	@Override
	public void setPPTerm(int PPTerm) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_PPTerm = PPTerm;
	}

	@JSON
	@Override
	public String getPaymentFrequency() {
		if (_paymentFrequency == null) {
			return "";
		}
		else {
			return _paymentFrequency;
		}
	}

	@Override
	public void setPaymentFrequency(String paymentFrequency) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_paymentFrequency = paymentFrequency;
	}

	@JSON
	@Override
	public String getPayoutOption() {
		if (_PayoutOption == null) {
			return "";
		}
		else {
			return _PayoutOption;
		}
	}

	@Override
	public void setPayoutOption(String PayoutOption) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_PayoutOption = PayoutOption;
	}

	@JSON
	@Override
	public int getLifeSecure() {
		return _lifeSecure;
	}

	@Override
	public void setLifeSecure(int lifeSecure) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lifeSecure = lifeSecure;
	}

	@JSON
	@Override
	public int getLifePlus() {
		return _lifePlus;
	}

	@Override
	public void setLifePlus(int lifePlus) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lifePlus = lifePlus;
	}

	@JSON
	@Override
	public int getCIPBenefit() {
		return _CIPBenefit;
	}

	@Override
	public void setCIPBenefit(int CIPBenefit) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_CIPBenefit = CIPBenefit;
	}

	@JSON
	@Override
	public String getAddOnBenefits() {
		if (_addOnBenefits == null) {
			return "";
		}
		else {
			return _addOnBenefits;
		}
	}

	@Override
	public void setAddOnBenefits(String addOnBenefits) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_addOnBenefits = addOnBenefits;
	}

	@JSON
	@Override
	public long getTotalValues() {
		return _totalValues;
	}

	@Override
	public void setTotalValues(long totalValues) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_totalValues = totalValues;
	}

	@JSON
	@Override
	public long getTotalAddon() {
		return _totalAddon;
	}

	@Override
	public void setTotalAddon(long totalAddon) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_totalAddon = totalAddon;
	}

	@JSON
	@Override
	public Boolean getAgreement() {
		return _agreement;
	}

	@Override
	public void setAgreement(Boolean agreement) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_agreement = agreement;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public LifeInsurance toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LifeInsurance>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LifeInsuranceImpl lifeInsuranceImpl = new LifeInsuranceImpl();

		lifeInsuranceImpl.setUuid(getUuid());
		lifeInsuranceImpl.setQuoteId(getQuoteId());
		lifeInsuranceImpl.setFullname(getFullname());
		lifeInsuranceImpl.setDob(getDob());
		lifeInsuranceImpl.setGender(getGender());
		lifeInsuranceImpl.setPhoneNo(getPhoneNo());
		lifeInsuranceImpl.setEmailAddress(getEmailAddress());
		lifeInsuranceImpl.setAadharNumber(getAadharNumber());
		lifeInsuranceImpl.setPanNumber(getPanNumber());
		lifeInsuranceImpl.setAnnualIncome(getAnnualIncome());
		lifeInsuranceImpl.setSumAssured(getSumAssured());
		lifeInsuranceImpl.setPolicyTerm(getPolicyTerm());
		lifeInsuranceImpl.setPPTerm(getPPTerm());
		lifeInsuranceImpl.setPaymentFrequency(getPaymentFrequency());
		lifeInsuranceImpl.setPayoutOption(getPayoutOption());
		lifeInsuranceImpl.setLifeSecure(getLifeSecure());
		lifeInsuranceImpl.setLifePlus(getLifePlus());
		lifeInsuranceImpl.setCIPBenefit(getCIPBenefit());
		lifeInsuranceImpl.setAddOnBenefits(getAddOnBenefits());
		lifeInsuranceImpl.setTotalValues(getTotalValues());
		lifeInsuranceImpl.setTotalAddon(getTotalAddon());
		lifeInsuranceImpl.setAgreement(getAgreement());
		lifeInsuranceImpl.setUserId(getUserId());

		lifeInsuranceImpl.resetOriginalValues();

		return lifeInsuranceImpl;
	}

	@Override
	public LifeInsurance cloneWithOriginalValues() {
		LifeInsuranceImpl lifeInsuranceImpl = new LifeInsuranceImpl();

		lifeInsuranceImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		lifeInsuranceImpl.setQuoteId(
			this.<String>getColumnOriginalValue("quoteId"));
		lifeInsuranceImpl.setFullname(
			this.<String>getColumnOriginalValue("fullname"));
		lifeInsuranceImpl.setDob(this.<Date>getColumnOriginalValue("dob"));
		lifeInsuranceImpl.setGender(
			this.<String>getColumnOriginalValue("gender"));
		lifeInsuranceImpl.setPhoneNo(
			this.<Long>getColumnOriginalValue("phoneNo"));
		lifeInsuranceImpl.setEmailAddress(
			this.<String>getColumnOriginalValue("emailAddress"));
		lifeInsuranceImpl.setAadharNumber(
			this.<String>getColumnOriginalValue("aadharNumber"));
		lifeInsuranceImpl.setPanNumber(
			this.<String>getColumnOriginalValue("panNumber"));
		lifeInsuranceImpl.setAnnualIncome(
			this.<String>getColumnOriginalValue("annualIncome"));
		lifeInsuranceImpl.setSumAssured(
			this.<Long>getColumnOriginalValue("sumAssured"));
		lifeInsuranceImpl.setPolicyTerm(
			this.<Integer>getColumnOriginalValue("policyTerm"));
		lifeInsuranceImpl.setPPTerm(
			this.<Integer>getColumnOriginalValue("PPTerm"));
		lifeInsuranceImpl.setPaymentFrequency(
			this.<String>getColumnOriginalValue("paymentFrequency"));
		lifeInsuranceImpl.setPayoutOption(
			this.<String>getColumnOriginalValue("PayoutOption"));
		lifeInsuranceImpl.setLifeSecure(
			this.<Integer>getColumnOriginalValue("lifeSecure"));
		lifeInsuranceImpl.setLifePlus(
			this.<Integer>getColumnOriginalValue("lifePlus"));
		lifeInsuranceImpl.setCIPBenefit(
			this.<Integer>getColumnOriginalValue("CIPBenefit"));
		lifeInsuranceImpl.setAddOnBenefits(
			this.<String>getColumnOriginalValue("addOnBenefits"));
		lifeInsuranceImpl.setTotalValues(
			this.<Long>getColumnOriginalValue("totalValues"));
		lifeInsuranceImpl.setTotalAddon(
			this.<Long>getColumnOriginalValue("totalAddon"));
		lifeInsuranceImpl.setAgreement(
			this.<Boolean>getColumnOriginalValue("agreement"));
		lifeInsuranceImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));

		return lifeInsuranceImpl;
	}

	@Override
	public int compareTo(LifeInsurance lifeInsurance) {
		String primaryKey = lifeInsurance.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LifeInsurance)) {
			return false;
		}

		LifeInsurance lifeInsurance = (LifeInsurance)object;

		String primaryKey = lifeInsurance.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<LifeInsurance> toCacheModel() {
		LifeInsuranceCacheModel lifeInsuranceCacheModel =
			new LifeInsuranceCacheModel();

		lifeInsuranceCacheModel.uuid = getUuid();

		String uuid = lifeInsuranceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			lifeInsuranceCacheModel.uuid = null;
		}

		lifeInsuranceCacheModel.quoteId = getQuoteId();

		String quoteId = lifeInsuranceCacheModel.quoteId;

		if ((quoteId != null) && (quoteId.length() == 0)) {
			lifeInsuranceCacheModel.quoteId = null;
		}

		lifeInsuranceCacheModel.fullname = getFullname();

		String fullname = lifeInsuranceCacheModel.fullname;

		if ((fullname != null) && (fullname.length() == 0)) {
			lifeInsuranceCacheModel.fullname = null;
		}

		Date dob = getDob();

		if (dob != null) {
			lifeInsuranceCacheModel.dob = dob.getTime();
		}
		else {
			lifeInsuranceCacheModel.dob = Long.MIN_VALUE;
		}

		lifeInsuranceCacheModel.gender = getGender();

		String gender = lifeInsuranceCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			lifeInsuranceCacheModel.gender = null;
		}

		lifeInsuranceCacheModel.phoneNo = getPhoneNo();

		lifeInsuranceCacheModel.emailAddress = getEmailAddress();

		String emailAddress = lifeInsuranceCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			lifeInsuranceCacheModel.emailAddress = null;
		}

		lifeInsuranceCacheModel.aadharNumber = getAadharNumber();

		String aadharNumber = lifeInsuranceCacheModel.aadharNumber;

		if ((aadharNumber != null) && (aadharNumber.length() == 0)) {
			lifeInsuranceCacheModel.aadharNumber = null;
		}

		lifeInsuranceCacheModel.panNumber = getPanNumber();

		String panNumber = lifeInsuranceCacheModel.panNumber;

		if ((panNumber != null) && (panNumber.length() == 0)) {
			lifeInsuranceCacheModel.panNumber = null;
		}

		lifeInsuranceCacheModel.annualIncome = getAnnualIncome();

		String annualIncome = lifeInsuranceCacheModel.annualIncome;

		if ((annualIncome != null) && (annualIncome.length() == 0)) {
			lifeInsuranceCacheModel.annualIncome = null;
		}

		lifeInsuranceCacheModel.sumAssured = getSumAssured();

		lifeInsuranceCacheModel.policyTerm = getPolicyTerm();

		lifeInsuranceCacheModel.PPTerm = getPPTerm();

		lifeInsuranceCacheModel.paymentFrequency = getPaymentFrequency();

		String paymentFrequency = lifeInsuranceCacheModel.paymentFrequency;

		if ((paymentFrequency != null) && (paymentFrequency.length() == 0)) {
			lifeInsuranceCacheModel.paymentFrequency = null;
		}

		lifeInsuranceCacheModel.PayoutOption = getPayoutOption();

		String PayoutOption = lifeInsuranceCacheModel.PayoutOption;

		if ((PayoutOption != null) && (PayoutOption.length() == 0)) {
			lifeInsuranceCacheModel.PayoutOption = null;
		}

		lifeInsuranceCacheModel.lifeSecure = getLifeSecure();

		lifeInsuranceCacheModel.lifePlus = getLifePlus();

		lifeInsuranceCacheModel.CIPBenefit = getCIPBenefit();

		lifeInsuranceCacheModel.addOnBenefits = getAddOnBenefits();

		String addOnBenefits = lifeInsuranceCacheModel.addOnBenefits;

		if ((addOnBenefits != null) && (addOnBenefits.length() == 0)) {
			lifeInsuranceCacheModel.addOnBenefits = null;
		}

		lifeInsuranceCacheModel.totalValues = getTotalValues();

		lifeInsuranceCacheModel.totalAddon = getTotalAddon();

		Boolean agreement = getAgreement();

		if (agreement != null) {
			lifeInsuranceCacheModel.agreement = agreement;
		}

		lifeInsuranceCacheModel.userId = getUserId();

		return lifeInsuranceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LifeInsurance, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LifeInsurance, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LifeInsurance, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((LifeInsurance)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, LifeInsurance>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					LifeInsurance.class, ModelWrapper.class);

	}

	private String _uuid;
	private String _quoteId;
	private String _fullname;
	private Date _dob;
	private String _gender;
	private long _phoneNo;
	private String _emailAddress;
	private String _aadharNumber;
	private String _panNumber;
	private String _annualIncome;
	private long _sumAssured;
	private int _policyTerm;
	private int _PPTerm;
	private String _paymentFrequency;
	private String _PayoutOption;
	private int _lifeSecure;
	private int _lifePlus;
	private int _CIPBenefit;
	private String _addOnBenefits;
	private long _totalValues;
	private long _totalAddon;
	private Boolean _agreement;
	private long _userId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<LifeInsurance, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((LifeInsurance)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("quoteId", _quoteId);
		_columnOriginalValues.put("fullname", _fullname);
		_columnOriginalValues.put("dob", _dob);
		_columnOriginalValues.put("gender", _gender);
		_columnOriginalValues.put("phoneNo", _phoneNo);
		_columnOriginalValues.put("emailAddress", _emailAddress);
		_columnOriginalValues.put("aadharNumber", _aadharNumber);
		_columnOriginalValues.put("panNumber", _panNumber);
		_columnOriginalValues.put("annualIncome", _annualIncome);
		_columnOriginalValues.put("sumAssured", _sumAssured);
		_columnOriginalValues.put("policyTerm", _policyTerm);
		_columnOriginalValues.put("PPTerm", _PPTerm);
		_columnOriginalValues.put("paymentFrequency", _paymentFrequency);
		_columnOriginalValues.put("PayoutOption", _PayoutOption);
		_columnOriginalValues.put("lifeSecure", _lifeSecure);
		_columnOriginalValues.put("lifePlus", _lifePlus);
		_columnOriginalValues.put("CIPBenefit", _CIPBenefit);
		_columnOriginalValues.put("addOnBenefits", _addOnBenefits);
		_columnOriginalValues.put("totalValues", _totalValues);
		_columnOriginalValues.put("totalAddon", _totalAddon);
		_columnOriginalValues.put("agreement", _agreement);
		_columnOriginalValues.put("userId", _userId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("quoteId", 2L);

		columnBitmasks.put("fullname", 4L);

		columnBitmasks.put("dob", 8L);

		columnBitmasks.put("gender", 16L);

		columnBitmasks.put("phoneNo", 32L);

		columnBitmasks.put("emailAddress", 64L);

		columnBitmasks.put("aadharNumber", 128L);

		columnBitmasks.put("panNumber", 256L);

		columnBitmasks.put("annualIncome", 512L);

		columnBitmasks.put("sumAssured", 1024L);

		columnBitmasks.put("policyTerm", 2048L);

		columnBitmasks.put("PPTerm", 4096L);

		columnBitmasks.put("paymentFrequency", 8192L);

		columnBitmasks.put("PayoutOption", 16384L);

		columnBitmasks.put("lifeSecure", 32768L);

		columnBitmasks.put("lifePlus", 65536L);

		columnBitmasks.put("CIPBenefit", 131072L);

		columnBitmasks.put("addOnBenefits", 262144L);

		columnBitmasks.put("totalValues", 524288L);

		columnBitmasks.put("totalAddon", 1048576L);

		columnBitmasks.put("agreement", 2097152L);

		columnBitmasks.put("userId", 4194304L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private LifeInsurance _escapedModel;

}