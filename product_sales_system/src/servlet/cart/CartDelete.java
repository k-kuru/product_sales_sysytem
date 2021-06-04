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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		cartList.remove(Integer.parseInt(request.getParameter("cart_num")));
		session.removeAttribute("cartList");
		session.setAttribute("cartList", cartList);
		request.setAttribute("page", request.getParameter("page_num"));
		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);
	}

}
