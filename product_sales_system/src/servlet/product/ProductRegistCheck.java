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
import util.Constants;
import util.Validator;

/**
 * 商品登録入力画面で入力した値を確認画面へ送るサーブレット
 * @author kuru
 */
@WebServlet("/ProductRegistCheck")
public class ProductRegistCheck extends HttpServlet {

	/** Getで受け取った場合Postへ処理を送る */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/** 商品登録入力画面で入力した値を確認画面へ送る */
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
		if (!(ProductDao.showProductDetail(product.getProductId()) == null)) {
			errorMessageList.add(Constants.PRODUCT_ID_REGISTERED);
		}
		//エラーメッセージがあればエラーメッセージを持って入力画面へ遷移
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
