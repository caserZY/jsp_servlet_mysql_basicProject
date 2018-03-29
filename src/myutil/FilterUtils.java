package myutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *  这是一个过滤器工具类
 * 
 *
 */
public class FilterUtils {
	// 关键字集合
	private static List<String> words = new ArrayList<>();

	private FilterUtils() {
	}
	// 加载关键字到集合
	static {

		Scanner scanner = new Scanner(
				Thread.currentThread().getContextClassLoader().getResourceAsStream("keywords.txt"), "UTF-8");
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (StringUtils.hasLength(line)) {
				words.add(line);
			}

		}
		scanner.close();

	}
	/**
	 * 
	 * @param str 传入一个字符串, ex: 你是王八蛋
	 * @return   返回一个被过滤掉的字符串  ex: 你是***
	 */
	public static String filter(String str) {
		
		for (String s : words) {
			// 判断字符串中是否有关键字,如果有将其替换
			if (str.indexOf(s) >= 0) {
				//将字符串中的文字替换
				str = str.replaceAll(s, buildMask(str, "*"));
			}
		}
		return str;

	}
	
	
	/**
	 * 
	 * @param str  被替换的字符 串  ex: 王八蛋  
	 * @param mask  替换的样式 如果是:*   返回的是相同长度的***
	 * @return
	 */
	public static String buildMask(String str, String mask) {

		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			stringBuffer.append(mask);

		}
		return stringBuffer.toString();
	}

	
}
