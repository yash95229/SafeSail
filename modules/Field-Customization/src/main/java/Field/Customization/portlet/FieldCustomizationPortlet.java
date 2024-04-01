package Field.Customization.portlet;

import Field.Customization.constants.FieldCustomizationPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.safesail.exception.NoSuchFieldConfigurationException;
import com.safesail.model.FieldConfiguration;
import com.safesail.model.LifeInsurance;
import com.safesail.service.FieldConfigurationLocalService;
import com.safesail.service.FieldConfigurationLocalServiceUtil;
import com.safesail.service.LifeInsuranceLocalService;
import com.safesail.service.LifeInsuranceLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Yash
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FieldCustomization",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/field_customization.jsp",
		"javax.portlet.name=" + FieldCustomizationPortletKeys.FIELDCUSTOMIZATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FieldCustomizationPortlet extends MVCPortlet {
	
	@Reference
	FieldConfigurationLocalService fieldConfigurationLocalService;
	
	@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			// TODO Auto-generated method stub
		
		
		  List<FieldConfiguration> fieldConfigData = FieldConfigurationLocalServiceUtil.getFieldConfigurations(-1,-1);
		  
		  renderRequest.setAttribute("fieldConfigData",fieldConfigData);
		  
		  
		 
			super.doView(renderRequest, renderResponse);
		}
	
	
	
	
}