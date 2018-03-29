package myutil;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 表单令牌机制,防止表单重复提交,每次访问增加表单页面都会生成一个令牌,
 * 然后存储在SESSION中,在提交表单的时候判断请求中(request)中的令牌是否和SESSION中的一样.
 * 
 *
 */
public class TokenUtils {
	private TokenUtils() {}

	public static final String TOKEN_IN_SESSION = "TOKEN_IN_SESSION";
/**
 * 创建令牌
 * @param request
 * @param response
 * @function  
 */
	public static  synchronized void creatToken(HttpServletRequest request, HttpServletResponse response) {
		// 获得随机的UUID
		String token = java.util.UUID.randomUUID().toString();
		// 将UUID存在SESSION和请求中
		request.getSession().setAttribute("TOKEN_IN_SESSION", token);
		request.setAttribute("token", token);
	}
	/**
	 * 
	 * @param token   从请求中获得令牌
	 * @param request  
	 * @param response
	 * @return
	 * @throws IOException
	 */
	
	
	
	 public static synchronized  boolean validate(String token, HttpServletRequest request, HttpServletResponse response) throws IOException
			{

		String token_in_session = (String) request.getSession().getAttribute("TOKEN_IN_SESSION");
		if (!token.equals(token_in_session)) {
			request.getSession().setAttribute("STATU_IN_SESSION", "失效了!!!");
			response.sendRedirect(request.getContextPath() + "/product");
			return false;
		}
		request.getSession().removeAttribute("TOKEN_IN_SESSION");
		return true;	
	}
	 
}
