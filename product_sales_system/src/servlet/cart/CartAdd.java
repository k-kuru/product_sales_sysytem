package servlet.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.ProductDao;
import bean.Cart;
import bean.Product;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/CartAdd")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product = ProductDao.showProductDetail(request.getParameter("productId"));
		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		HttpSession session = request.getSession();
		List<Cart> cartlist = (List<Cart>)session.getAttribute("cartList");
		cartlist.add(cart);
		session.setAttribute("cartList", cartlist);
		request.getRequestDispatcher("/jsp/product/display/product_list.jsp").forward(request, response);
	}

}
