package com.product.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.product.constants.ProductPortletKeys;
import com.safesail.model.ProductTable;
import com.safesail.service.ProductTableLocalService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + ProductPortletKeys.PRODUCT,

"mvc.command.name=/productmvc" })
public class ProductMVC implements MVCRenderCommand{

	
	@Reference
	ProductTableLocalService productTableLocalService;

	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		Long productId =ParamUtil.getLong(renderRequest, "productId");
		if(productId >0) {
		ProductTable product = productTableLocalService.fetchProductTable(productId);
		renderRequest.setAttribute("product", product);
		}
		return "/product.jsp";
	}

}
