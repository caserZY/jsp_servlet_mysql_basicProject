package web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author s3296
 *	这是一个字符集过滤器,在每次请求的时候,request和response和通过这个过滤器,默认将字符集设置成UTF-8
 *  已经在web.xml文件中定义所有请求都要过滤
 */
public class CharacterEncodingFilter implements javax.servlet.Filter {

	private String encoding = null;
	private boolean force = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		force = Boolean.valueOf(filterConfig.getInitParameter("force"));
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		final boolean existed = (req.getCharacterEncoding() == null || force) && hasLength(encoding);
		if (existed) {
			req.setCharacterEncoding(encoding);
			resp.setCharacterEncoding(encoding);
		}
		chain.doFilter(req, resp);
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

	@Override
	public void destroy() {
	}
}
