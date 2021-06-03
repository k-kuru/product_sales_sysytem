package servlet.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cart_paging
 */
@WebServlet("/Cart_paging")
public class Cart_paging extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", request.getParameter("page_num"));
		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);
	}
}
