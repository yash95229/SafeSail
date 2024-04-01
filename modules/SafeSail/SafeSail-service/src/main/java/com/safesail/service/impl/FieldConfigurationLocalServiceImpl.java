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
import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.exception.NoSuchLifeInsuranceException;
import com.safesail.model.AadhaarVerification;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.LifeInsurance;
import com.safesail.model.impl.FieldConfigurationImpl;
import com.safesail.model.impl.LifeInsuranceImpl;
import com.safesail.service.base.FieldConfigurationLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.safesail.model.FieldConfiguration",
	service = AopService.class
)
public class FieldConfigurationLocalServiceImpl
	extends FieldConfigurationLocalServiceBaseImpl {
	

	@Override
	public FieldConfiguration addFieldConfig(long configId, String fieldName, String fieldData, String fieldValue,
			String fieldSumAssured, Boolean fieldShow,String selectImage) {
		// TODO Auto-generated method stub
		FieldConfiguration addField = new FieldConfigurationImpl() ;
		
		addField.setConfigId(configId);
		addField.setFieldName(fieldName);
		addField.setFieldData(fieldData);
		addField.setFieldValue(fieldValue);
		addField.setFieldSumAssured(fieldSumAssured);
		addField.setFieldShow(fieldShow);
		addField.setSelectImage(selectImage);
		fieldConfigurationLocalService.addFieldConfiguration(addField);
		return addField;
	}

	
	
	 public List<FieldConfiguration> getByconfigId(long configId) throws NoSuchFieldConfigurationException {
		  
		  List<FieldConfiguration> getValue = fieldConfigurationPersistence.findByconfigId(configId);
		  
	  return getValue;
	  
	  }
			
	
	  public List<FieldConfiguration> getByfieldName(String fieldName) throws NoSuchFieldConfigurationException {
	  
	  List<FieldConfiguration> getValue = null;
	  
	  getValue = fieldConfigurationPersistence.findByfieldName(fieldName);
	  
	  return getValue;
	  
	  }
	 
	 public List<FieldConfiguration> getByfieldData(String fieldData) throws NoSuchFieldConfigurationException {
		  
		 List<FieldConfiguration> getValue = null;
	  
		  getValue = fieldConfigurationPersistence.findByfieldData(fieldData);
	  
	  return getValue;
	  
	  }
	 
	  public List<FieldConfiguration> getByfieldValue(String fieldValue) throws NoSuchFieldConfigurationException {
	  
		  List<FieldConfiguration> getValue = null;
	  
		  getValue = fieldConfigurationPersistence.findByfieldValue(fieldValue);
	  
	  return getValue;
	  
	  }
	  
	  public List<FieldConfiguration> getByfieldSumAssured(String fieldSumAssured) throws NoSuchFieldConfigurationException {
		  
		  List<FieldConfiguration> getValue = null;
	  
		  getValue = fieldConfigurationPersistence.findByfieldSumAssured(fieldSumAssured);
	  
	  return getValue;
	  
	  }
	 
 public FieldConfiguration getByfieldShow(Boolean fieldShow) throws NoSuchFieldConfigurationException {
		  
		  FieldConfiguration getValue = null;
	  
		  getValue = fieldConfigurationPersistence.findByfieldShow(fieldShow);
	  
	  return getValue;
	  
	  }



	 
	 
}