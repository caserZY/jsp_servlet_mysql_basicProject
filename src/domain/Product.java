package domain;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

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
	
	public  Product(HttpServletRequest request) {
		super();
		if(!(request.getParameter("id")==null)) {
			this.id = Long.valueOf(request.getParameter("id"));
		}
		
		this.productName = request.getParameter("productName");
		this.brand = request.getParameter("brand");
		this.supplier = request.getParameter("supplier");
		this.salePrice = new BigDecimal(request.getParameter("salePrice"));
		this.costPrice = new BigDecimal(request.getParameter("costPrice"));
		this.cutoff = Double.valueOf(request.getParameter("cutoff"));
		this.dir_id = Long.valueOf(request.getParameter("dir_id"));
	}

}
