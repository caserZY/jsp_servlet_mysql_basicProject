package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.TokenUtils;
/**
 * 增加商品的Sevlet,在增加表单之前访问可以产生一个令牌
 * ex:      /add               → /add.jsp  →       /product?method=add
 *   产生令牌(存在SESSION和请求中)    					在提交表单的时候会对比请求中的令牌和SESSION中的令牌是否相同
 *   如果相同,则删除SESSION中的令牌
 *
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TokenUtils.creatToken(request, response);
		request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
	}
}


