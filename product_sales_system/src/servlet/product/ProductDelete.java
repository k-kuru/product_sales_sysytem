package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ProductDao;

/**
 * 商品情報を論理削除して完了画面に遷移するサーブレット
 * @author kuru
 */
@WebServlet("/ProductDelete")
public class ProductDelete extends HttpServlet {

	/**
	 * Getで受け取った場合Postへ処理を送る
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 商品を論理削除
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productId = request.getParameter("productId");
		//商品を論理削除
		ProductDao.deleteProduct(productId);
		request.getRequestDispatcher("jsp/product/delete/complete.jsp").forward(request, response);
	}

}
