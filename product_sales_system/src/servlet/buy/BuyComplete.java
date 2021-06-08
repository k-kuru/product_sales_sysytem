package servlet.buy;

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
import bean.User;
import db.HistoryDao;

/**
 * Servlet implementation class Buy_complete
 */
@WebServlet("/BuyComplete")
public class BuyComplete extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		List<Cart> cartList = (List<Cart>)session.getAttribute("cartList");
		for (int i = 0; i < cartList.size(); i++) {
			HistoryDao.registHistory(cartList.get(i),(User)session.getAttribute("loginuser"));
		}
		session.removeAttribute("cartList");
		cartList = new ArrayList<Cart>();
		session.setAttribute("cartList", cartList);
		request.getRequestDispatcher("jsp/buy/buy_complete.jsp").forward(request, response);
	}

}
