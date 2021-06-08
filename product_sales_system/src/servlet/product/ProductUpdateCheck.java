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
 * 商品更新入力画面で入力した値を確認画面へ送るサーブレット
 * @author kuru
 */
@WebServlet("/ProductUpdateCheck")
public class ProductUpdateCheck extends HttpServlet {

	/**
	 * Getで受け取った場合Postへ処理を送る
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 入力された情報を持って商品更新確認画面へ遷移
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		//入力チェック
		List<String> errorMessageList = Validator.makeProductInputErrorMessageList(product);
		// 一意制約チェック
		if (errorMessageList.size() != 0) {
			request.setAttribute("errorMessageList", errorMessageList);
			request.getRequestDispatcher("/jsp/product/update/input.jsp").forward(request, response);
		}else {
		request.setAttribute("product", product);
		request.getRequestDispatcher("/jsp/product/update/check.jsp").forward(request, response);
		}
	}

}
