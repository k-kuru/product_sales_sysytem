package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import db.ProductDao;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	/**
	 * 商品IDで商品を特定し情報をもってユーザ詳細画面へ遷移
	 *
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productid = request.getParameter("productId");
		Product product = ProductDao.showProductDetail(productid);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/jsp/product/display/product_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String productid = request.getParameter("productid");
//		Product product = ProductDao.showProductDetail(productid);
//		request.setAttribute("product", product);
//		request.getRequestDispatcher("/jsp/product/display/product_detail.jsp").forward(request, response);
//	}

}
