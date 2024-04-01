package com.product.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.sql.dsl.DSLQueryFactoryUtil;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.product.constants.ProductPortletKeys;
import com.safesail.model.LifeInsurance;
import com.safesail.model.LifeInsuranceTable;
import com.safesail.model.ProductTable;
import com.safesail.model.ProductTableTable;
import com.safesail.service.ProductTableLocalService;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ProductPortletKeys.PRODUCT,
"mvc.command.name=saveProduct" }, service = MVCActionCommand.class)
public class ProductActionMethod extends BaseMVCActionCommand {

	@Reference
	ProductTableLocalService productTableLocalService;

	
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		Long productId =ParamUtil.getLong(actionRequest, "productId",0);
		System.out.println(productId);
		String productName = ParamUtil.get(actionRequest, "productName", "");
		int premiumDiscount = ParamUtil.getInteger(actionRequest, "premiumDiscount", 0);
		int totalDiscount  = ParamUtil.get(actionRequest, "totalDiscount", 0);
		System.out.println("total discount >>>>>>>>>>>>>>>>> "+totalDiscount);
		if(productId>0) {
			
			ProductTable product = productTableLocalService.fetchProductTable(productId);
			product.setProductName(productName);
			product.setPremiumDiscount(premiumDiscount);
			product.setTotalDiscount(totalDiscount);
			System.out.println("done");
			productTableLocalService.updateProductTable(product);
		 		}else {

			productId = CounterLocalServiceUtil.increment(ProductTable.class.getName());
			ProductTable product = productTableLocalService.createProductTable(productId);
			product.setProductName(productName);
			product.setPremiumDiscount(premiumDiscount);
			product.setTotalDiscount(totalDiscount);
			productTableLocalService.addProductTable(product);

		}
	}
	
	public boolean findbyproductName(String productName) {

		DSLQuery dslQuery = DSLQueryFactoryUtil.select(ProductTableTable.INSTANCE.productName)
				.from(ProductTableTable.INSTANCE);
		List<String> productNames = productTableLocalService.dslQuery(dslQuery);
		if (productNames.contains(productName)) {
			return true;
		}

		return false;
	}

}
