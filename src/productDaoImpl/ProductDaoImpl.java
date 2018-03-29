package productDaoImpl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Product;
import myutil.JDBCTemplate;
import myutil.StringUtils;
import productDao.ProductDao;
import query.IQuery;
import query.PageList;

public class ProductDaoImpl implements ProductDao<Product> {
	// 增加
	@Override
	public void save(Product product) throws SQLException {
		String sql = new String(
				"INSERT INTO product(productName,dir_id,salePrice,supplier,brand,cutoff,costPrice)value(?,?,?,?,?,?,?)");

		Object[] parms = { product.getProductName(), product.getDir_id(), product.getSalePrice(), product.getSupplier(),
				product.getBrand(), product.getCutoff(), product.getCostPrice() };
		JDBCTemplate.update(sql, parms);

	}
	// 删除
	@Override
	public void delete(Long id) throws SQLException {

		String sql = new String("DELETE FROM product WHERE id=?");
		Object[] parms = { id };
		JDBCTemplate.update(sql, parms);

	}
	// 修改
	@Override
	public void update(Product product) throws SQLException {

		String sql = new String(
				"UPDATE product set productName=?,dir_id=?,salePrice=?,supplier=?,brand=?,cutoff=?,costPrice=? WHERE id = ?");
		Object[] parms = { product.getProductName(), product.getDir_id(), product.getSalePrice(), product.getSupplier(),
				product.getBrand(), product.getCutoff(), product.getCostPrice(), product.getId() };
		JDBCTemplate.update(sql, parms);
	}
	// 获得制定ID的商品信息
	@Override
	public Product getOne(Long id) throws SQLException {

		String sql = new String("SELECT * FROM product WHERE id = ?");
		Object[] parms = { id };
		List<Product> query = JDBCTemplate.query(sql, new ProductResultSetHandler(), parms);
		return query.size() != 0 ? query.get(0) : null;

	}
	// 获得所有商品的信息
	@Override
	public List<Product> getAll() throws SQLException {

		String sql = new String("SELECT * FROM product");
		return JDBCTemplate.query(sql, new ProductResultSetHandler());

	}

	class ProductResultSetHandler implements ReHandler<List<Product>> {
		/**
		 * 
		 *  这是一个查询结果的处理器,将结果封装成对象,然后添加到List中作为返回
		 */
		@Override
		public List<Product> hanlder(ResultSet rs) throws SQLException {

			List<Product> list = new ArrayList<>();
			while (rs.next()) {
				Product product = new Product();
				product = new Product();
				product.setId(rs.getLong("id"));
				product.setProductName(rs.getString("productName"));
				product.setSupplier(rs.getString("supplier"));
				product.setBrand(rs.getString("brand"));
				product.setCostPrice(rs.getBigDecimal("costPrice"));
				product.setCutoff(rs.getDouble("cutoff"));
				product.setSalePrice(rs.getBigDecimal("salePrice"));
				product.setDir_id(rs.getLong("dir_id"));
				list.add(product);
			}

			return list;
		}

	}
	/**
	 *  高级查询 (查询+分类信息),传入一个高级查询的接口实现类
	 * 	这种方法不太好, 是我从龙哥的MYBATIES教程中强行抽取的,有一点比别扭
	 */
	@Override
	public PageList query(IQuery po) throws SQLException {
		// 获得对象的查询语句
		String querySql = po.getQuerySql(); 
		// 获得高级查询条件的记录数的语句
		String countSql = po.getCountSql();
		// 获得查询的商品关键字
		String productName = po.getProductName();
		// 获得商品的最低价格
		BigDecimal minSalePrice = po.getMinSalePrice();
		// 获得商品的最高价格
		BigDecimal maxSalePrice = po.getMaxSalePrice();

			//  这是用来放入的是条件,用来添加在sql语句中的条件
		List<Object> parms1 = new ArrayList<>();
		// 将对对象的productName,minSalePrice,maxSalePrice,如果不为空,则加入集合中
		if (StringUtils.hasLength(productName)) {
			parms1.add(productName);
		}
		if (minSalePrice != null) {
			parms1.add(minSalePrice);
		}
		if (maxSalePrice != null) {
			
			parms1.add(maxSalePrice);
		}
		// 获得高级查询的记录数, 比如;  SELECT * FROM product WHERE productName LIKE "%M%" AND salePrice<= ? AND salePrice >= ?
		// 获得满足如上条件的数目
		Integer count = JDBCTemplate.count(countSql, parms1);
		// 分布功能实现    ex: SELECT * FROM product LIMIT ?,?
		// 第一个问号:   [currentPage(当前页)-1] * pageSize(一页显示多少条)
		// 第二个问号表示 :  pageSize(一页显示多少条)
		if (po.getCurrentPage() != null) {
			parms1.add(po.getBeginIndex());
		}
		if (po.getPageSize() != null) {
			parms1.add(po.getPageSize());
		}
		
		List<Product> pageList = JDBCTemplate.query(querySql, new ProductResultSetHandler(), parms1);
		//   返回的 是一个(满足结果和翻页后的对象集pageList的集合)的对象  ,将结果封装在对象中
		return new PageList(pageList,count,po.getCurrentPage(),po.getPageSize());

	}

}
