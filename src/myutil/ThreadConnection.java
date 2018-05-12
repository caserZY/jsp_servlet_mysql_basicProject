/*
 * Copyright notice
 */
package myutil;

import java.sql.Connection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ThreadConnection.java
 * @version
 * 2018年5月12日 下午9:49:48
 * @author jeesk
 * @since 1.0
 */
public class ThreadConnection {
	private static ThreadLocal<Connection> threadContext = new ThreadLocal();
	// hashtable 不行, 不能并发,可以使用ConcurrentHashMap
	// private static ConcurrentHashMap<String, Connection> map = new ConcurrentHashMap<>();

	public static void set() {
		Connection conn = null;

		try {
			conn = MyDBUtils.INSTANCE.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		threadContext.set(conn);

	}

	public static Connection getConnection() {
		return threadContext.get();
	}
}
