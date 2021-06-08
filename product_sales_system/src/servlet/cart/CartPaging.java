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
 * ページング用サーブレット
 * @author NaSkanaishi
 */
@WebServlet("/CartPaging")
public class CartPaging extends HttpServlet {
	/**
	 * カートの中身を表示する画面でページリンクをクリックし、遷移するときの処理を行う
	 * @param HttpServletRequest request, HttpServletResponse response
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		int sumPrice = 0;

		for (int i = 0; i < cartList.size(); i++) {
			sumPrice += Integer.parseInt(cartList.get(i).getProduct().getPrice()) * cartList.get(i).getQuantity();
		}

		request.setAttribute("sumPrice", sumPrice);
		request.setAttribute("page", request.getParameter("pageNum"));

		request.getRequestDispatcher("jsp/cart/cart_list.jsp").forward(request, response);
	}
}
