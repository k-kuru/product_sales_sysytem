package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.ProductDao;
import bean.Product;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productid = request.getParameter("productid");
		Product product = ProductDao.showProductDetail(productid);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/jsp/product/display/product_detail.jsp").forward(request, response);
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