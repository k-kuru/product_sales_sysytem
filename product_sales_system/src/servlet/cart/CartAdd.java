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
import bean.Product;
import db.ProductDao;

/**
 * カート追加の処理
 * @author Nakanishi
 */
@WebServlet("/CartAdd")
public class CartAdd extends HttpServlet {
	/**
	 * Get送信をPostへ送る
	 * @param HttpServletRequest request, HttpServletResponse response
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * 商品をカートに追加するときの処理を行う
	 * @param HttpServletRequest request, HttpServletResponse response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Product product = ProductDao.showProductDetail(request.getParameter("productId"));
		Cart cart = new Cart();
		HttpSession session = request.getSession();

		cart.setProduct(product);
		cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));

		List<Cart> cartlist = (List<Cart>)session.getAttribute("cartList");

		cartlist.add(cart);
		session.setAttribute("cartList", cartlist);

		request.getRequestDispatcher("/ProductSearch").forward(request, response);
	}

}
