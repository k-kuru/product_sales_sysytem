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
		HttpSession session=request.getSession();
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		int sum_price = 0;

		for (int i = 0; i < cartList.size(); i++) {
			sum_price += Integer.parseInt(cartList.get(i).getProduct().getPrice()) * cartList.get(i).getQuantity();
		}

		request.setAttribute("sum_price", sum_price);
		request.getRequestDispatcher("jsp/buy/buy_check.jsp").forward(request, response);
	}
}
