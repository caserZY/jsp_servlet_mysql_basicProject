package query;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import myutil.StringUtils;

@Data
@EqualsAndHashCode(callSuper = false)
/**
 * 查询条件的对象封装
 * 
 *
 */
public class ProductObjectQuery extends BaseObjectQuery {
	
	// 查询的条件
	public String productName;
	private BigDecimal minSalePrice;

	private BigDecimal maxSalePrice;
	@Override
	public void costuomize() {
		
		// 如果从表单获取的条件不为空,则将sql语句拼接
		if (StringUtils.hasLength(productName)) {

			super.addQuery(" productName LIKE CONCAT('%',?,'%') ");

		}
		if (minSalePrice != null) {
			super.addQuery(" salePrice >= ? ");

		}
		if (maxSalePrice != null) {
			super.addQuery(" salePrice <= ? ");
		}
	}

	@Override
	public void costumoize1() {

		if (StringUtils.hasLength(productName)) {

			super.addQuery(" productName LIKE CONCAT('%',?,'%') ");

		}
		if (minSalePrice != null) {
			super.addQuery(" salePrice >= ? ");

		}
		if (maxSalePrice != null) {
			super.addQuery(" salePrice <= ? ");
		}
		if (super.getCurrentPage() != null && super.getPageSize() != null) {
			super.addQuery(" LIMIT ?,? ");
		}

	}

	@Override
	public String getProductName() {

		return productName;
	}

	@Override
	public BigDecimal getMinSalePrice() {
		// TODO Auto-generated method stub
		return minSalePrice;
	}

	@Override
	public BigDecimal getMaxSalePrice() {
		// TODO Auto-generated method stub
		return maxSalePrice;
	}

}
