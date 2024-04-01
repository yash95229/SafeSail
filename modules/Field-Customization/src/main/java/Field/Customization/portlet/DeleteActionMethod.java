package Field.Customization.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.safesail.model.FieldConfiguration;
import com.safesail.service.FieldConfigurationLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Field.Customization.constants.FieldCustomizationPortletKeys;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + FieldCustomizationPortletKeys.FIELDCUSTOMIZATION,
		"mvc.command.name=deleteData"
		}, 
service = MVCActionCommand.class)

public class DeleteActionMethod extends BaseMVCActionCommand{

	Log log = LogFactoryUtil.getLog(DeleteActionMethod.class);
	
	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("In fieldconfig delete action method__________________________");
		Long configId=ParamUtil.getLong(actionRequest,"id");
		log.info("configId____________________"+configId);
		
		try {
			FieldConfiguration deleteData =  fieldConfigurationLocalService.deleteFieldConfiguration(configId);
		} catch (PortalException e) {
			System.out.println("delete id "+e.getMessage());
		}
	}

}
