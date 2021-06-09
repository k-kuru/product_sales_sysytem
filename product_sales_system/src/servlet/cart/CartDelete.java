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
 * カートの中身を消すサーブレット
 * @author Nakanishi
 *
 */
@WebServlet("/CartDelete")
public class CartDelete extends HttpServlet {
	/** カートの中身を消したときの処理を行う */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッション情報の取得
		HttpSession session = request.getSession();
		//Cart型のリストを宣言しセッションスコープに格納されているCart型リストで初期化
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		//リストから指定されたカート番号のカート情報を取り除く
		cartList.remove(Integer.parseInt(request.getParameter("cartNum")));

		//合計金額用変数の初期化
		int sumPrice = 0;
		//カート内の商品の金額を足していく
		for (int i = 0; i < cartList.size(); i++) {
			sumPrice += Integer.parseInt(cartList.get(i).getProduct().getPrice()) * cartList.get(i).getQuantity();
		}

		//セッションスコープからリストを消去する
		session.removeAttribute("cartList");
		//セッションスコープにリストを登録する
		session.setAttribute("cartList", cartList);
		//リクエストスコープに合計金額とページ番号を格納
		request.setAttribute("sumPrice", sumPrice);
		//リクエストスコープにページ番号を登録する
		request.setAttribute("page", request.getParameter("pageNum"));

		//カート表示画面へ遷移する
		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);
	}

}
