package domain;

import java.math.BigDecimal;

/**
 * 管理项目的商品实体类
 * 
 */
import lombok.Data;
@Data
public class Product {

	private Long  id;
	private String productName; 
	private String brand;
	private String supplier;
	private BigDecimal salePrice;
	private BigDecimal costPrice;
	private Double cutoff;
	private Long dir_id;
	
	public Product() {
		super();
	}
	
	public Product(Long id, String productName, String brand, String supplier, BigDecimal salePrice,
			BigDecimal costPrice, Double cutoff, Long dir_id) {
		super();
		this.id = id;
		this.productName = productName;
		this.brand = brand;
		this.supplier = supplier;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.cutoff = cutoff;
		this.dir_id = dir_id;
	}

	public Product(String productName, String brand, String supplier, BigDecimal salePrice, BigDecimal costPrice,
			Double cutoff, Long dir_id) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.supplier = supplier;
		this.salePrice = salePrice;
		this.costPrice = costPrice;
		this.cutoff = cutoff;
		this.dir_id = dir_id;
	}


}
