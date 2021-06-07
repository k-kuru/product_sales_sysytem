package servlet.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * カートの中身表示用サーブレット
 * @author Nakanaishi
 */
@WebServlet("/CartList")
public class CartList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("page", 1);
		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);

	}
}
