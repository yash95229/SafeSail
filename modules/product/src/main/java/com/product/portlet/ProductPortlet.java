package com.product.portlet;

import com.product.constants.ProductPortletKeys;
import com.safesail.model.ProductTable;
import com.safesail.service.ProductTableLocalService;

import java.io.IOException;
import java.util.List;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

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
		"javax.portlet.display-name=Product",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProductPortletKeys.PRODUCT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProductPortlet extends MVCPortlet {
	
	@Reference
	ProductTableLocalService productTableLocalService;

	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		List<ProductTable> product = productTableLocalService.getProductTables(-1, -1);
		renderRequest.setAttribute("product", product);
		super.doView(renderRequest, renderResponse);
	}
}







