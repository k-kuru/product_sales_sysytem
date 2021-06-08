package servlet.buy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.User;
import db.HistoryDao;

/**
 * 商品購入完了サーブレット
 * @author Nakanishi
 */
@WebServlet("/BuyComplete")
public class BuyComplete extends HttpServlet {
	/**
	 * 商品購入完了時の処理を行う
	 * @param HttpServletRequest request, HttpServletResponse response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッション情報の取得
		HttpSession session=request.getSession();
		//Cart型のリストを宣言しセッションスコープに格納されているCart型リストで初期化
		List<Cart> cartList = (List<Cart>)session.getAttribute("cartList");

		//カート内の商品の金額を足していく
		for (int i = 0; i < cartList.size(); i++) {
			HistoryDao.registHistory(cartList.get(i),(User)session.getAttribute("loginuser"));
		}

		//セッションスコープからカーとリストを除去
		session.removeAttribute("cartList");

		//リストの初期化
		cartList = new ArrayList<Cart>();
		//セッションスコープにリストを登録する
		session.setAttribute("cartList", cartList);

		//購入完了画面へ遷移
		request.getRequestDispatcher("jsp/buy/buy_complete.jsp").forward(request, response);
	}

}
