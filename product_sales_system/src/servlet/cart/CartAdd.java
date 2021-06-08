package servlet.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.Product;
import db.ProductDao;

/**
 * カート追加の処理
 * @author Nakanishi
 */
@WebServlet("/CartAdd")
public class CartAdd extends HttpServlet {
	/** Get送信をPostへ送る */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/** 商品をカートに追加するときの処理を行う */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//前の画面の入力値である商品IDを、商品IDから商品情報を検索するDAOに送り、商品情報を取得する。
		Product product = ProductDao.showProductDetail(request.getParameter("productId"));
		//Cartオブジェクトの宣言と初期化
		Cart cart = new Cart();
		//セッション情報の取得
		HttpSession session = request.getSession();

		//cartに商品情報を格納
		cart.setProduct(product);
		//cartに購入個数を格納
		cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));

		//Cart型のリストを宣言しセッションスコープに格納されているCart型リストで初期化
		List<Cart> cartList = (List<Cart>)session.getAttribute("cartList");

		//リストにCartオブジェクトを追加
		cartList.add(cart);
		//セッションスコープにリストを登録
		session.setAttribute("cartList", cartList);

		//商品検索サーブレットへ遷移
		request.getRequestDispatcher("/ProductSearch").forward(request, response);
	}

}
