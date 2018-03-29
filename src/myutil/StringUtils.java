/**
 * @author jesek
 * 2018年3月20日 下午2:51:34
 * @version
 *
 */
package myutil;

/**
 * 字符串工具
 *
 */
public interface StringUtils {
	/**
	 * 
	 * @param str  
	 * @return  传入 一个字符串判断是否为空,为空返回FALSE,不为空返回TRUE
	 */
	public static boolean hasLength(String str) {

		return str != null && !"".equals(str.trim());
	}

}
