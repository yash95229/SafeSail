package com.safesailweb.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.safesailweb.constants.MainControllerPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;


@Component(immediate = true, property = { "javax.portlet.name=" + MainControllerPortletKeys.MAINCONTROLLER,
"mvc.command.name=/applicationRender" })
public class AppilcationRenderMethod implements MVCRenderCommand{

	Log log = LogFactoryUtil.getLog(AppilcationRenderMethod.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		
		log.info("in application render____________________");
				
		String errorMessage =ParamUtil.get(renderRequest, "errorMessage", "");
		String quoteIdErrorMessage =ParamUtil.get(renderRequest, "quoteIdErrorMessage", "");
		String dobErrorMessage =ParamUtil.get(renderRequest, "dobErrorMessage", "");
		
		renderRequest.setAttribute("dobErrorMessage", dobErrorMessage);
		renderRequest.setAttribute("errorMessage", errorMessage);
		renderRequest.setAttribute("quoteIdErrorMessage", quoteIdErrorMessage);
		
		return "/continueApp.jsp";
	}

}

