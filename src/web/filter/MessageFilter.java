package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.request.MyHttpServletRequestWapper;
/**
 *  关键字过滤器,可以在xml文件中,制定过滤器的资源范围
 * 
 */
public class MessageFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest requ = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		// 处理请求中的request.paramter对应属性的关键词
		// 重写请求的getParameter方法
		MyHttpServletRequestWapper myHttpServletRequestWapper = new MyHttpServletRequestWapper(requ);
		// 放行
		chain.doFilter(myHttpServletRequestWapper, resp);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {

	}
}
