package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.ImageIOToResponseOutputStream;
import myutil.RandomCodeUtils;
/**
 * 访问这个页面会产一个验证码
 */
@WebServlet("/randomcode")
public class RandomCode extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {

		ImageIOToResponseOutputStream.write(RandomCodeUtils.creatImage(requ), "jpg", resp);
	}

}
