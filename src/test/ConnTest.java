/*
 * Copyright notice
 */
package test;

import org.junit.Test;

import domain.Product;
import myutil.Handler;
import productDao.ProductDao;
import productDaoImpl.ProductDaoImpl;

/**
 * ConnTest.java
 * @version
 * 2018年5月12日 下午11:27:43
 * @author jeesk
 * @since 1.0
 */
public class ConnTest {
	@Test
	public void testName() throws Exception {
			Handler handler = new Handler();
			ProductDao dao = (ProductDao)handler.createProductDAO(new ProductDaoImpl());
			Product one = dao.getOne(20L);
			System.out.println(one);
			
			
			
	}
}
