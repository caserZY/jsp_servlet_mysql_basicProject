package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用户注销页面
 *  当用户访问这个页面的时候移出SESSION中的用户信息,用户访问页面会经过登录过滤器,没有用户跳转到登录页面
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {

		//  移除
		//requ.getSession().removeAttribute("USER_IN_SESSION");
		// 销毁后转发
		requ.getSession().invalidate();
		resp.sendRedirect(requ.getContextPath() + "/login.jsp");

	}
}
