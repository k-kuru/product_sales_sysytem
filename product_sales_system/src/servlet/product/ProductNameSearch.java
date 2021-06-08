package servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import db.ProductDao;

/**
 * 商品を特定しその情報を持ち商品リストへ遷移
 * Servlet implementation class Product_Name_Search
 *  @author motegi
 */
@WebServlet("/ProductNameSearch")
public class ProductNameSearch extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String productName = request.getParameter("productName");
		List<Product> productList = ProductDao.serchProductName(productName);

		request.setAttribute("productList", productList);
		request.setAttribute("page", 1);
		request.getRequestDispatcher("/jsp/product/display/product_list.jsp").forward(request, response);
	}

}
