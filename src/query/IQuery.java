package query;

import java.math.BigDecimal;
/**
 * 高级查询接口
 * 
 *
 */
public interface IQuery {

	Integer getCurrentPage();

	Integer getPageSize();

	Integer getBeginIndex();

	String getQuerySql();

	String getCountSql();

	String getProductName();

	BigDecimal getMinSalePrice();

	BigDecimal getMaxSalePrice();
}
