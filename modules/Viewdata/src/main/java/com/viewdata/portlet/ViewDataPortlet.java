package com.viewdata.portlet;

import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;

import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.petra.sql.dsl.spi.query.DefaultJoinStep;
import com.liferay.petra.sql.dsl.spi.query.Where;
import com.liferay.portal.dao.orm.hibernate.SQLQueryImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.safesail.model.LifeInsurance;
import com.safesail.model.LifeInsuranceTable;
import com.safesail.model.Policy;
import com.safesail.model.PolicyTable;
import com.safesail.model.UserTable;
import com.safesail.model.UserTableTable;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;
import com.safesail.service.PolicyLocalServiceUtil;
import com.safesail.service.UserTableLocalServiceUtil;

import com.viewdata.constants.ViewDataPortletKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Vinay Koppula
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ViewData",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ViewDataPortletKeys.VIEWDATA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ViewDataPortlet extends MVCPortlet {
	
	Log log = LogFactoryUtil.getLog(ViewDataPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<LifeInsurance> lifeInsurances =LifeInsuranceLocalServiceUtil.getLifeInsurances(-1,-1);
		List<Policy> policy = PolicyLocalServiceUtil.getPolicies(-1,-1);
		List<UserTable> usertable = UserTableLocalServiceUtil.getUserTables(-1, -1);
	
		renderRequest.setAttribute("lifeInsurances",lifeInsurances);
		renderRequest.setAttribute("policy",policy);
		renderRequest.setAttribute("usertable",usertable);
		
		 List<Object> data = getData();
		
		 List<Object> demo = demo();
		 
		 for (Object element : demo) {
			    log.info("quoteId and operator__________________________"+element);
			}
		 
		 List<Object> demo2 = demo2();
		
		 for (Object element : demo2) {
			    log.info("quoteId or operator__________________________"+element);
			}
		 
		 renderRequest.setAttribute("data", data);
		 
		super.doView(renderRequest, renderResponse);
	}

	@Reference
	LifeInsuranceLocalService lifeinsurancelocalservice;
	public List<Object> getData() {

		DSLQuery query = DSLQueryFactoryUtil.selectDistinct(
	    		  LifeInsuranceTable.INSTANCE.quoteId,LifeInsuranceTable.INSTANCE.fullname,
	    		  LifeInsuranceTable.INSTANCE.dob,
	    		  LifeInsuranceTable.INSTANCE.gender,LifeInsuranceTable.INSTANCE.phoneNo,
	    		  LifeInsuranceTable.INSTANCE.emailAddress,LifeInsuranceTable.INSTANCE.
	    		  aadharNumber,
	    		  LifeInsuranceTable.INSTANCE.panNumber,LifeInsuranceTable.INSTANCE.
	    		  annualIncome,LifeInsuranceTable.INSTANCE.sumAssured,LifeInsuranceTable.INSTANCE.PPTerm,
	    		  LifeInsuranceTable.INSTANCE.paymentFrequency,
	    		  LifeInsuranceTable.INSTANCE.PayoutOption,
	    		  LifeInsuranceTable.INSTANCE.totalValues,LifeInsuranceTable.INSTANCE.
	    		  totalAddon,
	    		  LifeInsuranceTable.INSTANCE.agreement,LifeInsuranceTable.INSTANCE.userId,
	    		  PolicyTable.INSTANCE.bookingId,PolicyTable.INSTANCE.applicationNumber,
	    		  PolicyTable.INSTANCE.planName,PolicyTable.INSTANCE.bookingDate,PolicyTable.
	    		  INSTANCE.maturityDate,PolicyTable.
	    		  INSTANCE.totalPremium,
	    		  PolicyTable.INSTANCE.status,UserTableTable.INSTANCE.userType).from(LifeInsuranceTable.INSTANCE).innerJoinON(PolicyTable.INSTANCE,
	    		 LifeInsuranceTable.INSTANCE.quoteId.eq(PolicyTable.INSTANCE.quoteId)).innerJoinON(UserTableTable.INSTANCE,LifeInsuranceTable.INSTANCE.userId.eq(UserTableTable.INSTANCE.userId));
	
	      return  lifeinsurancelocalservice.dslQuery(query);
	}
	
	public List<Object> demo() {

		DSLQuery query = DSLQueryFactoryUtil.select(LifeInsuranceTable.INSTANCE.quoteId).from(LifeInsuranceTable.INSTANCE)
				.where(LifeInsuranceTable.INSTANCE.fullname.eq("Armaan malik")
						.and(LifeInsuranceTable.INSTANCE.paymentFrequency.eq("Monthly"))
								.and(LifeInsuranceTable.INSTANCE.PayoutOption.eq("Immediate Payout"))
								);
				
				
	      return  lifeinsurancelocalservice.dslQuery(query);
	}

	public List<Object> demo2() {

		DSLQuery query = DSLQueryFactoryUtil.select(LifeInsuranceTable.INSTANCE.quoteId).from(LifeInsuranceTable.INSTANCE)
				.where(LifeInsuranceTable.INSTANCE.fullname.eq("Armaan malik")
						.or(LifeInsuranceTable.INSTANCE.aadharNumber.eq("2525 2525 2525"))
						.or(LifeInsuranceTable.INSTANCE.PayoutOption.eq("jnfjnw"))
					);
				
				
	      return  lifeinsurancelocalservice.dslQuery(query);
	}

	
}