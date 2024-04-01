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
import com.safesail.model.AadhaarVerification;
import com.safesail.model.impl.AadhaarVerificationImpl;
import com.safesail.service.AadhaarVerificationLocalService;
import com.safesail.service.base.AadhaarVerificationLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.safesail.model.AadhaarVerification",
	service = AopService.class
)
public class AadhaarVerificationLocalServiceImpl
	extends AadhaarVerificationLocalServiceBaseImpl {
	
Log log = LogFactoryUtil.getLog(AadhaarVerificationLocalServiceImpl.class);
	
	public String getUserByAadhaarNumber(String aadhaar) {

		List<AadhaarVerification> form1 = null;
		try {
			form1 =aadhaarVerificationPersistence.findByaadhaarNumber(aadhaar);
					
		} catch (Exception e) {
			log.error("Error while finding aadhar details from database");
		}

		if(form1.size() > 0) {
			return form1.get(0).getAadhaarUserName();
		} else {
			return null;
		}
		
	}
	
	public AadhaarVerification addAadhaar( long aadhaarId, String aadhaarUserName, String aadhaarNumber) {
		
		AadhaarVerification addData = new AadhaarVerificationImpl();
		
		addData.setAadhaarId(aadhaarId);
		addData.setAadhaarUserName(aadhaarUserName);
		addData.setAadhaarNumber(aadhaarNumber);
		
		aadhaarVerificationLocalService.addAadhaarVerification(addData);
		return addData;

	
	}
	
}