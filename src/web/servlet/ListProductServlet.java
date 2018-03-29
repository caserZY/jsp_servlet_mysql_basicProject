package web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import myutil.StringUtils;
import myutil.TokenUtils;
import productDaoImpl.ProductDaoImpl;
import query.PageList;
import query.ProductObjectQuery;

/**
 * 商品的列表,和CRUD
 * 
 */
@WebServlet("/product")
public class ListProductServlet extends HttpServlet {
	private ProductDaoImpl productDaoImpl;

	@Override
	public void init() throws ServletException {
		// 初始化DAO实现对象
		productDaoImpl = new ProductDaoImpl();

	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parameter = request.getParameter("method");
		// 获取表单的参数
		if ("add".equals(parameter)) {
			this.add(request, response);
		} else if ("delete".equals(parameter)) {
			this.delete(request, response);
		} else if ("find".equals(parameter)) {
			this.find(request, response);
		} else if ("update".equals(parameter)) {
			update(request, response);
		} else {
			try {

				//  如果不符合上述的条件,则显示商品列表

				// 传入一个高级查询的对象
				ProductObjectQuery po = new ProductObjectQuery();
				// 将用户的请求条件封装成一个对象
				requestToObject(request, po);
				// 查询
				PageList query = productDaoImpl.query(po);
				// 将对象存在的请求中
				request.setAttribute("po", po);
				request.setAttribute("products", query);

				// 跳转到列表的jsp页面
				request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 	将用户从表单里面提交的查询条件封装成一个对象  
	 * @param request
	 * @param po
	 */
	private void requestToObject(HttpServletRequest request, ProductObjectQuery po) {
		String productName = request.getParameter("productName");
		String minSalePrice = request.getParameter("minSalePrice");
		String maxSalePrice = request.getParameter("maxSalePrice");
		String currentPage = request.getParameter("currentPage");

		if (StringUtils.hasLength(currentPage)) {
			po.setCurrentPage(Integer.valueOf(currentPage));
		}
		if (StringUtils.hasLength(productName)) {
			po.setProductName(productName);
		}
		if (StringUtils.hasLength(minSalePrice)) {
			po.setMinSalePrice(new BigDecimal(minSalePrice));
		}
		if (StringUtils.hasLength(maxSalePrice)) {
			po.setMaxSalePrice(new BigDecimal(maxSalePrice));
		}

	}

	// 更改
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		String productName = request.getParameter("productName");
		String brand = request.getParameter("brand");
		String supplier = request.getParameter("supplier");
		BigDecimal salePrice = new BigDecimal(request.getParameter("salePrice"));
		BigDecimal costPrice = new BigDecimal(request.getParameter("costPrice"));
		Double cutoff = Double.valueOf(request.getParameter("cutoff"));
		Long dir_id = Long.valueOf(request.getParameter("dir_id"));
		Product product = new Product(id, productName, brand, supplier, salePrice, costPrice, cutoff, dir_id);
		try {
			productDaoImpl.update(product);
			response.sendRedirect(request.getContextPath() + "/product");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 查询 
	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("id");
		Long id = Long.valueOf(parameter);
		try {
			Product one = productDaoImpl.getOne(id);
			request.setAttribute("product", one);
			request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	/*// 
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
	}
	*/

	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long id = Long.valueOf(request.getParameter("id"));
		try {
			productDaoImpl.delete(id);
			response.sendRedirect(request.getContextPath() + "/product");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 新增
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String token = request.getParameter("token");

		if (!TokenUtils.validate(token, request, response)) {
			return;
		}
		String productName = request.getParameter("productName");
		String brand = request.getParameter("brand");
		String supplier = request.getParameter("supplier");
		BigDecimal salePrice = new BigDecimal(request.getParameter("salePrice"));
		BigDecimal costPrice = new BigDecimal(request.getParameter("costPrice"));
		Double cutoff = Double.valueOf(request.getParameter("cutoff"));
		Long dir_id = Long.valueOf(request.getParameter("dir_id"));
		Product product = new Product(productName, brand, supplier, salePrice, costPrice, cutoff, dir_id);
		try {
			productDaoImpl.save(product);
			request.getSession().setAttribute("STATU_IN_SESSION", "增加成功!!!");
			response.sendRedirect(request.getContextPath() + "/product");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
