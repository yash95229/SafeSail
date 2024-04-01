package imagedemo.portlet;

import imagedemo.constants.ImagedemoPortletKeys;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
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
		"javax.portlet.version=3.0",
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Imagedemo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ImagedemoPortletKeys.IMAGEDEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ImagedemoPortlet extends MVCPortlet {
	
	@Reference
	private ItemSelector _itemSelector;
	
	@Reference(unbind = "-")
	public void setItemSelector(ItemSelector itemSelector) {
	   _itemSelector = itemSelector;
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<ItemSelectorReturnType> itemSelectorReturnTypes = new ArrayList<>();
		itemSelectorReturnTypes.add(new URLItemSelectorReturnType());
		
		ImageItemSelectorCriterion imageItemSelectorCriterion = new ImageItemSelectorCriterion();
		imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(itemSelectorReturnTypes );
		
		RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil.create(renderRequest);
		PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(requestBackedPortletURLFactory, "sampleTestSelectItem",imageItemSelectorCriterion);
		
		 renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
		 		
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}
	
	
	  public void itemActionURL(ActionRequest request,ActionResponse response)
	  throws IOException,PortletException{
	  
		/*
		 * String fileName = ParamUtil.getString(request, "fileName");
		 * System.out.println("Selected image__________________________ : "+fileName);
		 */
		 	 
		UploadRequest uploadRequest =PortalUtil.getUploadPortletRequest(request);
		  File imag =uploadRequest.getFile("fileName");
		 
		  System.out.println("file______________"+imag);
		  
		  FileInputStream fileInputStream = new FileInputStream(imag);
		  byte[] imageData = new byte[(int) imag.length()]; 
		  
		  fileInputStream.read(imageData);
		  
		  System.out.println("imageData___________________"+imageData);
		  
		  String base64String =  Base64.encode(imageData);
		  System.out.println("after converting String___________________________"+base64String);
		  request.setAttribute("recievedMessage",base64String);
		 
		 
		  
	  }
	 
}