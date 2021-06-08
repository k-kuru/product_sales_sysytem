package servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import db.ProductDao;

/**
 * 商品名をあいまい検索するサーブレット
 *  @author motegi
 */
@WebServlet("/ProductNameSearch")
public class ProductNameSearch extends HttpServlet {
	/**
	 * 商品名をあいまい検索し情報を持って商品リストへ遷移する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String productName = request.getParameter("productName");
		//商品名をあいまい検索し情報を取得
		List<Product> productList = ProductDao.serchProductName(productName);

		request.setAttribute("productList", productList);
		request.setAttribute("page", 1);
		request.getRequestDispatcher("/jsp/product/display/product_list.jsp").forward(request, response);
	}

}
