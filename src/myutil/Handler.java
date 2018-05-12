/*
 * Copyright notice
 */
package myutil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import domain.Product;
import productDao.ProductDao;

/**
 * Handler.java
 * @version
 * 2018年5月12日 下午10:31:21
 * @author jeesk
 * @since 1.0
 */
public class Handler<T> implements InvocationHandler {
	private T t = null;

	@SuppressWarnings("unchecked")
	public T createProductDAO(T t) {

		this.t = t;
		return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(),
				t.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object o = null;
		ThreadConnection.set();
		System.out.println("first");
		o = method.invoke(t, args);
		System.out.println("after");
		MyDBUtils.close(null, null, ThreadConnection.getConnection());
		return o;
	}

}
