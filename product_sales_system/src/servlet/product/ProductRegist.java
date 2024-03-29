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
 * 商品情報をデータベースに登録して完了画面に遷移するサーブレット
 * @author kuru
 */
@WebServlet("/ProductRegist")
public class ProductRegist extends HttpServlet {

	/** Getで受け取った場合Postへ処理を送る */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doPost(request, response);
	}

	/** 商品情報をデータベースに登録 */
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
		//商品の登録
		ProductDao.registProduct(product);
		request.getRequestDispatcher("jsp/product/regist/complete.jsp").forward(request, response);
	}

}
