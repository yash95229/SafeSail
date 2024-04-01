package com.product.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.product.constants.ProductPortletKeys;
import com.safesail.model.ProductTable;
import com.safesail.service.ProductTableLocalService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + ProductPortletKeys.PRODUCT,
"mvc.command.name=deleteProduct" })
public class DeleteProduct implements MVCRenderCommand{


	@Reference
	ProductTableLocalService productTableLocalService;

	
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		Long productId =ParamUtil.getLong(renderRequest, "productId");

		try {
			productTableLocalService.deleteProductTable(productId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ProductTable> product = productTableLocalService.getProductTables(-1, -1);
		renderRequest.setAttribute("product", product);
		
		return "/view.jsp";
	}

}
