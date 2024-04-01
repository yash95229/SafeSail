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

package com.safesail.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.safesail.model.PanCardVerification;

import com.safesail.model.impl.PanCardVerificationImpl;
import com.safesail.service.PanCardVerificationLocalService;
import com.safesail.service.base.PanCardVerificationLocalServiceBaseImpl;


import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.safesail.model.PanCardVerification",
	service = AopService.class
)
public class PanCardVerificationLocalServiceImpl extends PanCardVerificationLocalServiceBaseImpl {
	Log log = LogFactoryUtil.getLog(PanCardVerificationLocalServiceImpl.class);
	
	public String getUserByPanNumber(String PAN) {

		List<PanCardVerification> form1 = null;
		try {
			form1 = panCardVerificationPersistence.findBypanNumber(PAN);
		} catch (Exception e) {
			log.error("Error while finding PAN details from database");
		}

		if(form1.size() > 0) {
			return form1.get(0).getPanUserName();
		} else {
			return null;
		}
		
	}
	
	
public PanCardVerification addPan( long panId, String panUserName, String panNumber) {
		
	PanCardVerification addData = new PanCardVerificationImpl();
		
		addData.setPanId(panId);
		addData.setPanUserName(panUserName);
		addData.setPanNumber(panNumber);
		
		panCardVerificationLocalService.addPanCardVerification(addData);
		
		return addData;

	
	}
	
}