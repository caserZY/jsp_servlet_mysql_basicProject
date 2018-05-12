package web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Person;
import myutil.MyDBUtils;
import myutil.RandomCodeUtils;
/**
 *  登录请求处理Servlet
 */
@WebServlet("/login")
public class LogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		// 用户名
		String username=null;
		// 密码
		String password= null;
		// 验证码
		String randomcode = null;
		try {
			System.out.println("验证码错误");
			username = requ.getParameter("username");
			password = requ.getParameter("password");
			randomcode = requ.getParameter("randomcode");
			if (!hasLength(username)) {
				// 如果用户名为空,这跳转到登录页面
				System.out.println("不能获取用户名");
				requ.getRequestDispatcher("/login.jsp").forward(requ, resp);
				return ;
			}

			
			if (!RandomCodeUtils.validate(requ, randomcode)) {
				// 验证码错误,请求转发到登录页面,并且显示: 验证码错误
			
				requ.setAttribute("ErrorMsg", "验证码错误");
				requ.setAttribute("USERNAME_IN_SESSION", username);
				requ.setAttribute("PASSWORD_IN_SESSION", password);
				requ.getRequestDispatcher("/login.jsp").forward(requ, resp);
				return;
			}
			// 验证码正确 移除 SESSION中的验证码
			requ.getSession().removeAttribute(RandomCodeUtils.RANDOMCODE_IN_SESSION);

			
//____________________________________________________________________________________			
			
			//数据库中查询登录用户是否存在,并且验证账号密码是否正确
			Person person = null;
			conn = MyDBUtils.INSTANCE.getConnection();
			String sql = "select * from person where name=? && password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				person = new Person();
				person.setName(rs.getString("name"));
				person.setPassword(rs.getString("password"));
			}
			if (person == null) {
				requ.setAttribute("ErrorMsg", "用户不存在");
				requ.getRequestDispatcher("/login.jsp").forward(requ, resp);
				return;
			}
			
			//_________________________________________________________________________________
			// 登录成功,将用户信息存在SESSION中
			HttpSession session = requ.getSession();
			session.setAttribute("USER_IN_SESSION", person);
			resp.sendRedirect("/productServlet?action=list");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			MyDBUtils.close(ps,rs,conn);
		}

	}

	boolean hasLength(String str) {
		return str != "" && str != null;
	}

}
