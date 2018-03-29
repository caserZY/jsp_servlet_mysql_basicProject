package web.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 访问权限过滤,用户在登录后将自己的信息保存在SESSION中,在每次访问页面的时候将判断SESSION中的用户信息是否存在
 * 如果存在,将放行你的请求和响应
 * 
 *
 */
public class CheckLoginFilter implements javax.servlet.Filter {
	// 不受检查的资源
	private List<String> unCheckUrls = null;
	
	private String loginPage = "/login.jsp";
	private String userInSession = "USER_IN_SESSION";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//在初始化参数获得不受检查的资源的属性(web.xml文件中 )
		String[] split = filterConfig.getInitParameter("unCheckUrls").split(",");
		if (split.length >= 1) {
			unCheckUrls = Arrays.asList(split);
		}
		// 获得登录页面
		if (filterConfig.getInitParameter("loginPage") != null) {

			loginPage = filterConfig.getInitParameter("loginPage");
		}
		// 获得用户信息存入的SESSION名字
		if (filterConfig.getInitParameter("userInSession") != null) {
			userInSession = filterConfig.getInitParameter("userInSession");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 获得请求的uri
		String requestUri = requ.getRequestURI();
		
		Object user = requ.getSession().getAttribute(userInSession);
		// 如果不受检查的名单中没有请求的资源
		if (!unCheckUrls.contains(requestUri)) {
			// 如果用户的SESSION不存在,
			if (user == null) {
				// 跳转到登录页
				resp.sendRedirect(requ.getContextPath() + loginPage);
				return;
			}

		}
		// 不检查的集合中包含,则放行
		chain.doFilter(requ, resp);
	}



}
