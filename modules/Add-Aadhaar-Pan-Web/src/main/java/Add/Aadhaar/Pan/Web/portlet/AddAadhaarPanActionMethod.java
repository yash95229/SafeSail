package Add.Aadhaar.Pan.Web.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.safesail.model.AadhaarVerification;
import com.safesail.model.PanCardVerification;
import com.safesail.service.AadhaarVerificationLocalService;
import com.safesail.service.PanCardVerificationLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Add.Aadhaar.Pan.Web.constants.AddAadhaarPanWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AddAadhaarPanWebPortletKeys.ADDAADHAARPANWEB,
		"mvc.command.name=saveDetails"
}, service = MVCActionCommand.class)

public class AddAadhaarPanActionMethod extends BaseMVCActionCommand {

	Log log = LogFactoryUtil.getLog(AddAadhaarPanActionMethod.class);

	@Reference
	AadhaarVerificationLocalService aadhaarVerificationLocalService;

	@Reference
	PanCardVerificationLocalService panCardVerificationLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("in addAadharPanCard method____________________________________");
		
		long id = CounterLocalServiceUtil.increment(AadhaarVerification.class.getName());
		
		String userName = ParamUtil.get(actionRequest, "userName", "");
		String aadhaarNumber = ParamUtil.get(actionRequest, "aadhaarNumber", "");
		String panNumber = ParamUtil.get(actionRequest, "panNumber", "");
		
		AadhaarVerification allAadhaarData = aadhaarVerificationLocalService.addAadhaar(id, userName, aadhaarNumber);
		
		log.info("AadhaarData_______________________"+allAadhaarData);

		PanCardVerification addPanCardData =   panCardVerificationLocalService.addPan(id, userName, panNumber);
		
		log.info("PanCardData______________________"+addPanCardData);
		
	}
}
