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
 *  商品IDで商品を特定し情報をもってユーザ詳細画面へ遷移するサーブレット
 *  @author motegi
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	/**商品IDから商品の詳細情報を検索する */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("productId");
		//商品IDをもとに詳細情報を表示
		Product product = ProductDao.showProductDetail(productId);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/jsp/product/display/product_detail.jsp").forward(request, response);
	}

	/**処理をGetに送る */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
