package servlet.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;

/**
 * 商品登録確認画面から戻るときに動作するサーブレット
 * @author Nakanishi
 */
@WebServlet("/ProductRegistInput")
public class ProductRegistInput extends HttpServlet {
	/** 商品登録確認画面の値を入力画面へ送る */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.setAttribute("product", product);
		request.getRequestDispatcher("/jsp/product/regist/input.jsp").forward(request, response);
	}
	/** post送信を受け取った場合getに送る*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
