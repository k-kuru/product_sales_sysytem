package servlet.buy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;

/**
 * 商品購入確認サーブレット
 * @author Nakanishi
 */
@WebServlet("/BuyCheck")
public class BuyCheck extends HttpServlet {
	/**
	 * 商品購入確認画面へ遷移する
	 * @param HttpServletRequest request, HttpServletResponse response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッション情報の取得
		HttpSession session=request.getSession();
		//Cart型のリストを宣言しセッションスコープに格納されているCart型リストで初期化
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		//合計金額用変数の初期化
		int sumPrice = 0;

		//カート内の商品の金額を足していく
		for (int i = 0; i < cartList.size(); i++) {
			sumPrice += Integer.parseInt(cartList.get(i).getProduct().getPrice()) * cartList.get(i).getQuantity();
		}

		//リクエストスコープに合計金額を格納
		request.setAttribute("sumPrice", sumPrice);
		//購入確認画面へ遷移
		request.getRequestDispatcher("jsp/buy/buy_check.jsp").forward(request, response);
	}
}
