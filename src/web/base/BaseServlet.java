/*
 * Copyright notice
 */
package web.base;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BaseServlet.java
 * @version
 * 2018年5月12日 下午7:21:40
 * @author jeesk
 * @since 1.0
 */
public class BaseServlet extends HttpServlet{


	private static final long serialVersionUID = 7428621008258946530L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		Object[] args = { request, response };
		Class[] types = { HttpServletRequest.class, HttpServletResponse.class };
		Class<? extends BaseServlet> thisClass = this.getClass();
		try {
			// 如果是子类执行的话当前的this表示 子类
			//  getMethod 获得是公共的方法,表示 (接口和继承的)
			Method method = thisClass.getMethod(action, types);
			System.out.println("执行了吗");
			method.invoke(this, args);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
