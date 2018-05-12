package web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import myutil.Handler;
import myutil.StaticProxydao_bat;
import myutil.StringUtils;
import myutil.TokenUtils;
import productDao.ProductDao;
import productDaoImpl.ProductDaoImpl;
import query.PageList;
import query.ProductObjectQuery;
import web.base.BaseServlet;

/**
 * 商品的列表,和CRUD
 * 
 */
@WebServlet("/productServlet")
public class ProductServlet extends BaseServlet {
	private ProductDao productDaoImpl;

	@Override
	public void init() throws ServletException {
		Handler<ProductDaoImpl> handler = new Handler<>();
		// 初始化DAO实现对象
		productDaoImpl = handler.createProductDAO(new ProductDaoImpl());
		// productDaoImpl = new ProductDaoImpl();

	}

	public static final long serialVersionUID = 1L;

	public void list(HttpServletRequest request, HttpServletResponse response) {

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
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
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

	public void createToken(HttpServletRequest request, HttpServletResponse response) {

		TokenUtils.creatToken(request, response);
		try {
			request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 更改
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Product product = new Product(request);
		try {
			productDaoImpl.update(product);
			response.sendRedirect(request.getContextPath() + "/productServlet?action=list");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 查询 
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long id = Long.valueOf(request.getParameter("id"));
		try {
			productDaoImpl.delete(id);
			response.sendRedirect(request.getContextPath() + "/productServlet?action=list");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 新增
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String token = request.getParameter("token");

		if (!TokenUtils.validate(token, request, response)) {
			return;
		}
		Product product = new Product(request);
		try {
			productDaoImpl.save(product);
			request.getSession().setAttribute("STATU_IN_SESSION", "增加成功!!!");
			response.sendRedirect(request.getContextPath() + "/productServlet?action=list");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
