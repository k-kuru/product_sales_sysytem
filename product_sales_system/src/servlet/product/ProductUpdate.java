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
 * 商品情報を更新して完了画面に遷移サーブレット
 * @author kuru
 */
@WebServlet("/ProductUpdate")
public class ProductUpdate extends HttpServlet {

	/**Getで受け取った場合Postへ処理を送る*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	/** 商品を更新  */
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
		//商品の更新
		ProductDao.updateProduct(product);
		request.setAttribute("product", product);
		request.getRequestDispatcher("jsp/product/update/complete.jsp").forward(request, response);
	}

}
