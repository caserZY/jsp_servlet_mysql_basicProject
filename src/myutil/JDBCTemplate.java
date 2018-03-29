package myutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import productDaoImpl.ReHandler;
/**
 *  简单模拟dbutils的CRUD
 */
public interface JDBCTemplate {

	
	public static int update(String sql, Object... parms) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = MyDBUtils.INSTANCE.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parms.length; i++) {
				ps.setObject(i + 1, parms[i]);
			}

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyDBUtils.close(ps, conn, null);
		}
		return 0;
	}

	public static <T> T query(String sql, ReHandler<T> rsh, Object... parms) {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = MyDBUtils.INSTANCE.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parms.length; i++) {
				ps.setObject(i + 1, parms[i]);
			}

			rs = ps.executeQuery();
			return rsh.hanlder(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyDBUtils.close(ps, conn, rs);
		}
		return null;
	}

	public static <T> T query(String sql, ReHandler<T> rsh, List<?> list) {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = MyDBUtils.INSTANCE.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				ps.setObject(i + 1, list.get(i));
			}

			rs = ps.executeQuery();
			return rsh.hanlder(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyDBUtils.close(ps, conn, rs);
		}
		return null;
	}
	// 返回一个查询结果的条数
	public static Integer count(String sql,List<?> list) {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = MyDBUtils.INSTANCE.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				ps.setObject(i + 1, list.get(i));
			}
			
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyDBUtils.close(ps, conn, rs);
		}
		return null;
		
	}

}
