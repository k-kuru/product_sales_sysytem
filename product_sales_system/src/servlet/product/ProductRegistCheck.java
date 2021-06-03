package servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import util.Validator;

/**
 * Servlet implementation class ProductCheck
 */
@WebServlet("/ProductRegistCheck")
public class ProductRegistCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String productExplain = request.getParameter("productExplain");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");

		Product product = new Product();

		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductExplain(productExplain);
		product.setPrice(price);
		product.setStock(stock);

		List<String> errorMessageList = Validator.makeProductInputErrorMessageList(product);
		if (errorMessageList.size() != 0) {
			request.setAttribute("product", product);
			request.setAttribute("errorMessageList", errorMessageList);
			request.getRequestDispatcher("/jsp/product/regist/input.jsp").forward(request, response);
		}else {
		request.setAttribute("product", product);
		request.getRequestDispatcher("/jsp/product/regist/check.jsp").forward(request, response);
		}
	}

}
