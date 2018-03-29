package web.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import myutil.FilterUtils;

public class MyHttpServletRequestWapper extends HttpServletRequestWrapper {

	public MyHttpServletRequestWapper(HttpServletRequest request) {
			super(request);

	}
	
	@Override
	public String getParameter(String name) {
		
		String parameter = super.getParameter(name);
		if(parameter!=null) {
		if("productName".equals(name) || "brand".equals(name)){
			parameter  = FilterUtils.filter(parameter);
		}}
		return parameter;
	}

}
