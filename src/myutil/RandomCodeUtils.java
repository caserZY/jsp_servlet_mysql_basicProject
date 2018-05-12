package myutil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *  验证码工具类(创建,验证)
 *
 */
public interface RandomCodeUtils {
	public static final String RANDOMCODE_IN_SESSION = "RANDOMCODE_IN_SESSION";

	/**
	 * 
	 * @param requ 传入一个request
	 * @return 一个BufferedImage类型的对象
	 */
	public static BufferedImage creatImage(HttpServletRequest requ) {

		String letter = new String("");
		for (int i = 0; i < 26; i++) {
			char c = 'A';
			c += i;
			letter += c;
		}
		letter += letter.toLowerCase();
		letter += "0123456789";
		String code = new String("");
		for (int i = 0; i < 5; i++) {
			char c = letter.charAt(new Random().nextInt(letter.length()));
			code += c;
		}
		// 这儿的验证码是a_z,A_Z,0_9; 比uuid更安全

		// 将验证码存储在Session中
		requ.getSession().setAttribute(RANDOMCODE_IN_SESSION, code);

		// 下面的代码 ,请忽略
		//创建图片对象 100,46
		int width = 105;
		int height = 45;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(width, height, imageType);
		//画板
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		// 绘制一个实心 人矩形
		g.fillRect(1, 1, width - 2, height - 2);
		// 把随机数画入图片中
		g.setColor(Color.BLACK);
		// 干设置随机数的字体和大小
		Font font = new Font("宋体", Font.BOLD + Font.ITALIC, 20);
		g.setFont(font);
		g.drawString(code, 10, 28);
		//干扰线
		g.setColor(Color.gray);
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			g.fillRect(random.nextInt(width), random.nextInt(height), 2, 2);
		}
		// 关闭
		g.dispose();
		return image;
	}

	/**
	 * 这个方法中加入线程同步, 防止多用户的访问存在SESSION的令牌被修改
	 * @param requ
	 * @param randomcode  用户在表单输入入的验证码
	 * @return   如果用户在表单输入的验证码和SESSION中的验证码忽略大小写一样,返回TRUE,否则返回FALSE
	 * @throws ServletException
	 * @throws IOException
	 */
	public static boolean validate(HttpServletRequest requ, String randomcode) throws ServletException, IOException {

		String random_in_session = (String) requ.getSession().getAttribute(RANDOMCODE_IN_SESSION);
		// 获得SESSION中的令牌,判断是否和浏览器中请求的令牌相同  ,相同则返回true,不同返回false

		if (StringUtils.hasLength(random_in_session) && StringUtils.hasLength(randomcode)) {
			if (random_in_session.equalsIgnoreCase(randomcode)) {

				return true;

			}

		}
		return false;
	}

}
