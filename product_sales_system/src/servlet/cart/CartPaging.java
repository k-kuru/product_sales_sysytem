package servlet.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ページング用サーブレット
 * @author NaSkanaishi
 */
@WebServlet("/CartPaging")
public class CartPaging extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", request.getParameter("page_num"));
		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);
	}
}
