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
		Connection conn = ThreadConnection.getConnection();
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
			MyDBUtils.close(ps, null, null);
		}
		return 0;
	}

	public static <T> T query(String sql, ReHandler<T> rsh, Object... parms) {
		PreparedStatement ps = null;
		Connection conn = ThreadConnection.getConnection();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parms.length; i++) {
				ps.setObject(i + 1, parms[i]);
			}

			rs = ps.executeQuery();
			return rsh.hanlder(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyDBUtils.close(ps, rs, null);
		}
		return null;
	}

	public static <T> T query(String sql, ReHandler<T> rsh, List<?> list) {
		PreparedStatement ps = null;
		Connection conn = ThreadConnection.getConnection();
		ResultSet rs = null;
		T t = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				ps.setObject(i + 1, list.get(i));
			}

			rs = ps.executeQuery();
			return rsh.hanlder(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyDBUtils.close(ps, rs, null);
		}
		return null;
	}

	// 返回一个查询结果的条数
	public static Integer getCount(String sql, List<?> list) {
		PreparedStatement ps = null;
		Connection conn = ThreadConnection.getConnection();
		ResultSet rs = null;
		Integer count = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < list.size(); i++) {
				ps.setObject(i + 1, list.get(i));
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyDBUtils.close(ps, rs, null);
		}
		return count;

	}

}
