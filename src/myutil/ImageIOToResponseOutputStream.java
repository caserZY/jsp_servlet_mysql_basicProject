/**
 * @author jesek
 * 2018年3月20日 下午2:27:52
 * @version
 *
 */
package myutil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

/**
 * 	这是一个图片输出到(响应)浏览器的工具类
 *
 */
public class ImageIOToResponseOutputStream {
	private ImageIOToResponseOutputStream() {
	}

	/**
	 * @param iamge    BufferedImage类的对象   可以使用RandomCodeUtils.creatImage返回的是些类型
	 * @param formatName  图片的格式 
	 * @param response   浏览器的响应
	 */
	public static void write(BufferedImage iamge, String formatName, HttpServletResponse response) {
		try {
			ImageIO.write(iamge, formatName, response.getOutputStream());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @param file   传入一个图片File类型
	 * @param response  浏览器的响应
	 * @param formatName   图片的格式
	 */
	public static void write(File file, HttpServletResponse response, String formatName) {

		try {
			BufferedImage read = ImageIO.read(file);
			ImageIO.write(read, formatName, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
