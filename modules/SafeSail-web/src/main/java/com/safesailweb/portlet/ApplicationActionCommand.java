package com.safesailweb.portlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayActionRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.model.LifeInsurance;
import com.safesail.model.LifeInsuranceTable;
import com.safesail.model.Policy;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.PolicyLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
"mvc.command.name=continueApplication" }, service = MVCActionCommand.class)


public class ApplicationActionCommand extends BaseMVCActionCommand{

	Log log = LogFactoryUtil.getLog(ApplicationActionCommand.class);
	
	@Reference
	protected Portal portal;


	@Reference
	LifeInsuranceLocalService lifeinsurancelocalservice;
	
	@Reference
	PolicyLocalService policylocalservice;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("in application action class____________________");
		
		String quoteString = ParamUtil.get(actionRequest, "quoteIds", "");
		String quoteId = "#"+quoteString;
		log.info("quoteId__________________________"+ quoteId);
		SimpleDateFormat datehere = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = (Date) ParamUtil.getDate(actionRequest, "dob", datehere);

		List<String> obj1=null;

	try {
		obj1= getByQuoteIdDate(quoteId, dob);
	
		
		LifeInsurance lifeinsurance = lifeinsurancelocalservice.getLifeInsurance(quoteId);
		
		log.info("getDate___________________________"+ obj1.get(0));
		actionResponse.setRenderParameter("quoteId", obj1.get(0));
		if(lifeinsurance.getPolicyTerm()== 0) {
		actionResponse.setRenderParameter("mvcRenderCommandName", "/incomeDetail");
		}else if(lifeinsurance.getAddOnBenefits().isEmpty()) {
			actionResponse.setRenderParameter("mvcRenderCommandName", "/termInsurance");	
		
		}else {
			Policy policy = policylocalservice.getByQuoteId(obj1.get(0));
			actionResponse.setRenderParameter("totalAddon", String.valueOf(lifeinsurance.getAddOnBenefits()));
			actionResponse.setRenderParameter("applicationNo", String.valueOf(policy.getApplicationNumber()));
			actionRequest.setAttribute("fullname", policy.getFullName());
			actionResponse.setRenderParameter("mvcRenderCommandName", "/SomeDetails");
		}
	}catch(Exception e) {
		log.info("Error: " + e.getMessage());
    if (e.getMessage().contains("Index: 0, Size: 0")) {
        actionResponse.getRenderParameters().setValue("dobErrorMessage", "Invalid Date of Birth.");
    } else if (e.getMessage().contains("No LifeInsurance exists with the primary key")) {
        actionResponse.getRenderParameters().setValue("quoteIdErrorMessage", "Invalid QuoteId.");
	}  else {
		actionResponse.getRenderParameters().setValue("errorMessage","Please Select a valid DOB and QuoteId");
	}
			 actionResponse.getRenderParameters().setValue("mvcRenderCommandName","/applicationRender");
			 
    
	/*actionRequest.setAttribute(WebKeys.REDIRECT,
			PortletURLBuilder.createRenderURL(portal.getLiferayPortletResponse(actionResponse))
					.setMVCRenderCommandName("/applicationRender"));*/

}
	
}
	

	public List<String> getByQuoteIdDate(String quoteId, Date dob) {
		DSLQuery query =DSLQueryFactoryUtil.selectDistinct(LifeInsuranceTable.INSTANCE.quoteId).from(LifeInsuranceTable.INSTANCE)
				.where(LifeInsuranceTable.INSTANCE.quoteId.eq(quoteId).and(LifeInsuranceTable.INSTANCE.dob.eq(dob)));

		
		List<String> quoteIds= lifeinsurancelocalservice.dslQuery(query);
		
		return quoteIds;
	}
	
	

}
