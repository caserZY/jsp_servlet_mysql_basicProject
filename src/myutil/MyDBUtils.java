package myutil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
/**
 * 数据库的工具类
 */
public enum MyDBUtils {
	INSTANCE;
	private static DataSource dataSource = null;
	// 在第一次使用的时候创建数据资源池,以后不再加载 
	static {
		Properties p = new Properties();
		try {
			// 这儿使用的是dbcp连接池
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbcp.properties");
			p.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/**
 * 创建一个实例{@link com.mysql.jdbc.Connection}
 * @return
 * @throws Exception
 */
	public Connection getConnection() throws Exception {
		Connection connection = dataSource.getConnection();
		return connection;

	}
	// ,每次查询后,必须关闭数据库的连接
	/**
	 * 
	 * @param ps
	 * @param conn
	 * @param rs
	 */
	public  static void close(PreparedStatement ps, Connection conn, ResultSet rs) {

		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

	}
	




}
