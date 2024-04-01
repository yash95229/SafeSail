package com.safesailweb.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.model.LifeInsurance;
import com.safesail.model.Policy;
import com.safesail.model.PolicyTable;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.PolicyLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		"mvc.command.name=saveInsurance" }, service = MVCActionCommand.class)

public class TermInsuranceActionMethod extends BaseMVCActionCommand {

	@Reference
	protected Portal portal;
	
	@Reference
	LifeInsuranceLocalService lifeinsuranceLocalService;
	
	@Reference
	PolicyLocalService policyLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Log log = LogFactoryUtil.getLog(TermInsuranceActionMethod.class);

		log.info("intermInsuranceAction________________________________");

		String quoteId = ParamUtil.get(actionRequest, "quoteId", "");
		String totalAddons = ParamUtil.get(actionRequest, "TotalAddon", ""); 
	
		/* long totalAddon = ParamUtil.getInteger(actionRequest, "TotalAddon"); */
		totalAddons = totalAddons.replaceAll(",", "");

		long totalAddon = Long.parseLong(totalAddons);
	
	log.info("totalAddon_____________"+totalAddon);
		String  selectedFieldValue ="";
		
		
		String[] selectedFields = ParamUtil.getParameterValues(actionRequest, "selectedField");
		
		//log.info(selectedFields[0]);
		if (selectedFields != null  ) {
		    // Convert each selected field to an integer and then join them into a space-separated string
		    String concatenatedValues = String.join(";", selectedFields);

		    // Process the entire space-separated string
		     selectedFieldValue  = concatenatedValues;
		    log.info("Retrieved Value________________________ " + selectedFieldValue);

		  
		}
		
	
	


		Policy policy = null;
		
		long applicationNo = 0L;
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

				
				LifeInsurance registerReg = lifeinsuranceLocalService.fetchLifeInsurance(quoteId);
			/* registerReg.getTotalValues(); */
				if (Validator.isNotNull(registerReg)) {
					String monthfinder = registerReg.getPaymentFrequency();
					if(findbyquoteId(quoteId) != true) {
						applicationNo= CounterLocalServiceUtil.increment(Policy.class.getName());
						policy = policyLocalService.addPolicy(generateBookingId(), applicationNo, themeDisplay.getUserId(),
								themeDisplay.getUser().getFullName(), "Safe Sail Term Health Booster Plus",
								registerReg.getAnnualIncome(), registerReg.getSumAssured(), registerReg.getPPTerm(),
								registerReg.getPaymentFrequency(), registerReg.getTotalAddon(), quoteId, 0,0);
						
					}else {
						

						policy =policyLocalService.getByQuoteId(quoteId);

						  policy.setQuoteId(quoteId);
						  policy.setPlanName("Safe Sail Term Health Booster Plus");
						  policy.setAnnualIncome(registerReg.getAnnualIncome());
						  policy.setSumAssured(registerReg.getSumAssured());
						  policy.setPolicyTerm(registerReg.getPPTerm());
						  policy.setPaymentFrequency(registerReg.getPaymentFrequency());
						  policy.setTotalPremium(registerReg.getTotalAddon());
						policy=  policyLocalService.updatePolicy(policy);
						applicationNo=policy.getApplicationNumber();
						log.info("Application No:_____________________________ "+ applicationNo);
					}
					
					registerReg.setAddOnBenefits(selectedFieldValue);
						
						registerReg.setTotalAddon(totalAddon);
						registerReg = lifeinsuranceLocalService.updateLifeInsurance(registerReg);
						
						log.info("termInsuranceAllData_______________________"+registerReg);
					
		
				}
				actionRequest.setAttribute(WebKeys.REDIRECT,
						PortletURLBuilder.createRenderURL(portal.getLiferayPortletResponse(actionResponse))
								.setMVCRenderCommandName("/SomeDetails").setParameter("quoteId", quoteId)
								.setParameter("fullname", registerReg.getFullname()).setParameter("applicationNo",  String.valueOf(applicationNo)).
								setParameter("totalAddon", String.valueOf(totalAddon))
								.buildString());
			
				
		} catch (Exception e) {

			log.error("Something Went Wrong " , e);

		}

		/* actionResponse.setRenderParameter("mvcRenderCommandName", "/SomeDetails"); */



	}
	
	
	public boolean findbyquoteId(String quoteId) {

		DSLQuery dslQuery = DSLQueryFactoryUtil.selectDistinct(PolicyTable.INSTANCE.quoteId)
				.from(PolicyTable.INSTANCE);
		List<String> quoteIds = policyLocalService.dslQuery(dslQuery);
		
		if (quoteIds.contains(quoteId)) {
			return true;
		}

		return false;
	}
	
	public Object getbyquoteId(String quoteId) {

		DSLQuery dslQuery = DSLQueryFactoryUtil.select(PolicyTable.INSTANCE.bookingDate,PolicyTable.INSTANCE.bookingDate,PolicyTable.INSTANCE.annualIncome,PolicyTable.INSTANCE.applicationNumber,PolicyTable.INSTANCE.fullName,PolicyTable.INSTANCE.maturityDate,PolicyTable.INSTANCE.paymentFrequency,
				PolicyTable.INSTANCE.planName,PolicyTable.INSTANCE.policyTerm,PolicyTable.INSTANCE.quoteId,PolicyTable.INSTANCE.sumAssured,PolicyTable.INSTANCE.totalPremium,PolicyTable.INSTANCE.userId,PolicyTable.INSTANCE.status)
				.from(PolicyTable.INSTANCE).where(PolicyTable.INSTANCE.quoteId.eq(quoteId));
		Object quoteIds = policyLocalService.dslQuery(dslQuery);
		return quoteIds;
	}
	
	
	
	public static int generateBookingId() {
		Random random = new Random();
		
		return random.ints(999, 99999).findFirst().getAsInt();
	}

	
}
