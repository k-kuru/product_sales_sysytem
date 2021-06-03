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
 * Servlet implementation class cart_list
 */
@WebServlet("/Cart_list")
public class Cart_list extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Cart> cartList = new ArrayList<Cart>();
		for (int i = 0; i < 5; i++) {
			Cart cart = new Cart();
			cart.setProduct_name("product"+i);
			cart.setProduct_price(i*100);
			cart.setQuantity(i);
			cartList.add(cart);
		}
		session.setAttribute("cartList", cartList);
		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);

	}
}
