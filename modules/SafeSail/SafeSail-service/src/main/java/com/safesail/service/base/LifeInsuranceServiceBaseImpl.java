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

package com.safesail.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.safesail.model.LifeInsurance;
import com.safesail.service.LifeInsuranceService;
import com.safesail.service.LifeInsuranceServiceUtil;
import com.safesail.service.persistence.AadhaarVerificationPersistence;
import com.safesail.service.persistence.FieldConfigurationPersistence;
import com.safesail.service.persistence.LifeInsurancePersistence;
import com.safesail.service.persistence.PanCardVerificationPersistence;
import com.safesail.service.persistence.PolicyPersistence;
import com.safesail.service.persistence.ProductTablePersistence;
import com.safesail.service.persistence.UserTablePersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the life insurance remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.safesail.service.impl.LifeInsuranceServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.safesail.service.impl.LifeInsuranceServiceImpl
 * @generated
 */
public abstract class LifeInsuranceServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, LifeInsuranceService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>LifeInsuranceService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>LifeInsuranceServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			LifeInsuranceService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		lifeInsuranceService = (LifeInsuranceService)aopProxy;

		_setServiceUtilService(lifeInsuranceService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LifeInsuranceService.class.getName();
	}

	protected Class<?> getModelClass() {
		return LifeInsurance.class;
	}

	protected String getModelClassName() {
		return LifeInsurance.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = lifeInsurancePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(
		LifeInsuranceService lifeInsuranceService) {

		try {
			Field field = LifeInsuranceServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, lifeInsuranceService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AadhaarVerificationPersistence aadhaarVerificationPersistence;

	@Reference
	protected FieldConfigurationPersistence fieldConfigurationPersistence;

	@Reference
	protected com.safesail.service.LifeInsuranceLocalService
		lifeInsuranceLocalService;

	protected LifeInsuranceService lifeInsuranceService;

	@Reference
	protected LifeInsurancePersistence lifeInsurancePersistence;

	@Reference
	protected PanCardVerificationPersistence panCardVerificationPersistence;

	@Reference
	protected PolicyPersistence policyPersistence;

	@Reference
	protected ProductTablePersistence productTablePersistence;

	@Reference
	protected UserTablePersistence userTablePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

	private static final Log _log = LogFactoryUtil.getLog(
		LifeInsuranceServiceBaseImpl.class);

}