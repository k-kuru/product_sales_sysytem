package servlet.cart;

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

/**
 * カートの中身表示用サーブレット
 * @author Nakanaishi
 */
@WebServlet("/CartList")
public class CartList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Cart> cartList = new ArrayList<Cart>();
		for (int i = 0; i < 5; i++) {
			Cart cart = new Cart();

			cart.setQuantity(i);
			cartList.add(cart);
		}
		session.setAttribute("cartList", cartList);
		request.setAttribute("page", 1);
		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);

	}
}
