package com.safesailweb.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.safesail.model.LifeInsurance;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.UserTableLocalService;
import com.safesailweb.constants.MainControllerPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
		"mvc.command.name=saveIncome" }, service = MVCActionCommand.class)
public class IncomeDetailsActionMethod extends BaseMVCActionCommand {

	Log log = LogFactoryUtil.getLog(IncomeDetailsActionMethod.class);

	@Reference
	protected Portal portal;
	
	@Reference
	LifeInsuranceLocalService lifeInsuranceLocalService;
	
	@Reference
	UserTableLocalService userTableLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {
			
			log.info("in incomeDatailAction_____________________");
			String quoteId = ParamUtil.get(actionRequest, "quoteId", "");
			int premiumPaying = ParamUtil.getInteger(actionRequest, "premiumPaying", 0);
			String payout = ParamUtil.get(actionRequest, "payout", "");
			int policyTerm = ParamUtil.get(actionRequest, "policyTerm", 0);
			/* String paymentFreq = ParamUtil.get(actionRequest, "paymentFreq", ""); */
			/* long totalValues = ParamUtil.getLong(actionRequest, "TotalPayment"); */
			
			String totalValue = ParamUtil.get(actionRequest, "TotalPayment", ""); 
			
			
			totalValue = totalValue.replaceAll(",", "");

			long totalValues = Long.parseLong(totalValue);
		
		log.info("totalValues_______________"+totalValues);

		
		        String paymentFreq =ParamUtil.get(actionRequest,"spanText","");
		        log.info("paymentFreq_________________"+paymentFreq);
			/*
			 * // Extract id attribute value from the span element String idValue =
			 * extractIdAttributeValue(htmlContent, "frequency");
			 */
		        
			/* String QuoteId = */
			// insertion of data to db
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			
				
				LifeInsurance registerReg = lifeInsuranceLocalService.getQuoteId(quoteId);
				
				if (registerReg != null) {
					// fill update information

					registerReg.setPPTerm(premiumPaying);
					registerReg.setPayoutOption(payout);
					registerReg.setPolicyTerm(policyTerm);
					registerReg.setPaymentFrequency(paymentFreq);
					registerReg.setTotalValues(totalValues);
					registerReg = lifeInsuranceLocalService.updateLifeInsurance(registerReg);

				}

				log.info("incomeDatailData____________________________"+registerReg);
				

				
			/*
			 * actionResponse.setRenderParameter("mvcRenderCommandName", "/termInsurance");
			 */

				
				actionRequest.setAttribute(WebKeys.REDIRECT,
						PortletURLBuilder.createRenderURL(portal.getLiferayPortletResponse(actionResponse))
								.setMVCRenderCommandName("/termInsurance").setParameter("quoteId", quoteId).buildString());

				
				
		} catch (Exception e) {
			log.error("Something went Wrong ",e);
		}

	}
	

	/*
	 * private String extractIdAttributeValue(String htmlContent, String elementId)
	 * { String idAttribute = "id=\"" + elementId + "\""; int startIdx =
	 * htmlContent.indexOf(idAttribute);
	 * 
	 * if (startIdx != -1) { int endIdx = htmlContent.indexOf('"', startIdx +
	 * idAttribute.length()); if (endIdx != -1) { return
	 * htmlContent.substring(startIdx + idAttribute.length(), endIdx); } }
	 * 
	 * return null; // Return null if the id attribute is not found }
	 */

}
