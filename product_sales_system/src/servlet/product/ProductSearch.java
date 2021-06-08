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
 * 全件検索するサーブレット
 *  @author motegi
 */
@WebServlet("/ProductSearch")
public class ProductSearch extends HttpServlet {
	/**
	 * 商品情報を全件検索する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//商品情報を全件検索
		List<Product> productlist = ProductDao.findAllProduct();
		request.setAttribute("productList",productlist);
		//ページ番号がなければ1ページ目のみ表示
		if(request.getParameter("page_num")==null) {
			request.setAttribute("page", 1);
		}else {
			request.setAttribute("page", request.getParameter("page_num"));
		}

		request.getRequestDispatcher("/jsp/product/display/product_list.jsp").forward(request,response);
	}
	/**
	 * 処理をGetに送る
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
