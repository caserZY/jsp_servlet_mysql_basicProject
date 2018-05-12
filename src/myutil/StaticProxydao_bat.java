/*
 * Copyright notice
 */
package myutil;

import java.sql.SQLException;
import java.util.List;

import domain.Product;
import productDao.ProductDao;
import query.IQuery;
import query.PageList;

/**
 * StaticProxydao.java
 * @version
 * 2018年5月12日 下午11:59:06
 * @author jeesk
 * @param <T>
 * @since 1.0
 */
public class StaticProxydao_bat implements ProductDao {

	private ProductDao productImpl = null;

	public StaticProxydao_bat(ProductDao productImpl) {
		this.productImpl = productImpl;
	}

	/* (non-Javadoc)
	 * @see productDao.ProductDao#save(domain.Product)
	 */
	@Override
	public void save(Product product) throws SQLException {
		ThreadConnection.set();
		productImpl.save(product);
		MyDBUtils.close(null, null, ThreadConnection.getConnection());
	}

	/* (non-Javadoc)
	 * @see productDao.ProductDao#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) throws SQLException {
		ThreadConnection.set();
		productImpl.delete(id);
		MyDBUtils.close(null, null, ThreadConnection.getConnection());

	}

	/* (non-Javadoc)
	 * @see productDao.ProductDao#update(domain.Product)
	 */
	@Override
	public void update(Product product) throws SQLException {
		ThreadConnection.set();
		productImpl.update(product);
		MyDBUtils.close(null, null, ThreadConnection.getConnection());

	}

	/* (non-Javadoc)
	 * @see productDao.ProductDao#getOne(java.lang.Long)
	 */
	@Override
	public Product getOne(Long id) throws SQLException {
		ThreadConnection.set();
		Product one = productImpl.getOne(id);
		MyDBUtils.close(null, null, ThreadConnection.getConnection());
		return one;
	}

	/* (non-Javadoc)
	 * @see productDao.ProductDao#getAll()
	 */
	@Override
	public List<Product> getAll() throws SQLException {
		ThreadConnection.set();
		List all = productImpl.getAll();
		MyDBUtils.close(null, null, ThreadConnection.getConnection());
		return all;
	}

	/* (non-Javadoc)
	 * @see productDao.ProductDao#query(query.IQuery)
	 */
	@Override
	public PageList query(IQuery po) throws SQLException {
		ThreadConnection.set();
		PageList query = productImpl.query(po);
		MyDBUtils.close(null, null, ThreadConnection.getConnection());
		return query;
	}

	/* (non-Javadoc)
	 * @see productDao.ProductDao#doWork()
	 */
	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		
	}

}
