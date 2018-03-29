package web.servlet.image;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.ImageIOToResponseOutputStream;
/**
 * 背题图片的SERVLET 
 * 访问/backImage 显示一张图片
 *
 */
@WebServlet("/backImage")
public class BackgroudServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获得资源名字
		String filename = req.getParameter("filename");
		// 获得资源的真实地址(全)
		String dir = super.getServletContext().getRealPath("/images");
		// 创建File对象 
		File file = new File(dir, filename);
		//	FileInputStream fileInputStream = new FileInputStream(file);
		// 向浏览器响应
		ImageIOToResponseOutputStream.write(file, resp, "jpg");
	}
}
