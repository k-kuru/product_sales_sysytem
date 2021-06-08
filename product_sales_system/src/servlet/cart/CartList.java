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

/**
 * カートの中身表示用サーブレット
 * @author Nakanaishi
 */
@WebServlet("/CartList")
public class CartList extends HttpServlet {
	/**
	 * カートの中身を表示するときの処理を行う
	 * @param HttpServletRequest request, HttpServletResponse response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッション情報を取得する
		HttpSession session=request.getSession();
		//Cart型のリストを宣言しセッションスコープに格納されているCart型リストで初期化
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		//合計金額用変数の初期化
		int sumPrice = 0;

		//カート内の商品の金額を足していく
		for (int i = 0; i < cartList.size(); i++) {
			sumPrice += Integer.parseInt(cartList.get(i).getProduct().getPrice()) * cartList.get(i).getQuantity();
		}

		//リクエストスコープに合計金額とページ番号を格納
		request.setAttribute("sumPrice", sumPrice);
		request.setAttribute("page", 1);

		//カート一覧画面へ遷移する
		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);

	}
}
