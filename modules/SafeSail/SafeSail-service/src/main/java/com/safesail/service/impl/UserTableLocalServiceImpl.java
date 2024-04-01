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
import com.safesail.exception.NoSuchUserTableException;
import com.safesail.model.UserTable;
import com.safesail.model.impl.UserTableImpl;
import com.safesail.service.base.UserTableLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.safesail.model.UserTable",
	service = AopService.class
)
public class UserTableLocalServiceImpl extends UserTableLocalServiceBaseImpl {
	public UserTable getQuoteId(String quoteId) {
		UserTable form = null;
		
			
				try {
					form = userTablePersistence.findByquoteId(quoteId);
				} catch (NoSuchUserTableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		return form;

	}

	public UserTable addUser(String quoteId, long userId,String userType) {

		UserTable registerReg = new UserTableImpl();
		registerReg.setQuoteId(quoteId);
				registerReg.setUserId(userId);
				registerReg.setUserType(userType);
		userTableLocalService.addUserTable(registerReg);
		return registerReg;
	}
	
	
	

	public List<UserTable> getUser(long userId) {

		

		List<UserTable> form1 = null;
		try {
			
			form1 = userTablePersistence.findByuserId(userId);
			
		} catch (Exception e) {
		
		}

		return form1;

	}


}