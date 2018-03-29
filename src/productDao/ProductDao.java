package productDao;

import java.sql.SQLException;
import java.util.List;

import domain.Product;
import query.IQuery;
import query.PageList;
/**
 * 商品管理的DAO
 * 
 * @param <T>
 */
public interface ProductDao<T> {
	public void save(Product product) throws SQLException;

	public void delete(Long id) throws SQLException;

	public void update(Product product) throws SQLException;

	public Product getOne(Long id) throws SQLException;

	public List<Product> getAll() throws SQLException;
	
	
	public PageList query(IQuery po) throws SQLException;
}
