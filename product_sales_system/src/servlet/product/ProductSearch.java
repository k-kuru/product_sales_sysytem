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
 * 全件検索
 * Servlet implementation class Search
 */
@WebServlet("/ProductSearch")
public class ProductSearch extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> productlist = ProductDao.findAllProduct();
		request.setAttribute("productList",productlist);
		if(request.getParameter("page_num")==null) {
			request.setAttribute("page", 1);
		}else {
			request.setAttribute("page", request.getParameter("page_num"));
		}

		request.getRequestDispatcher("/jsp/product/display/product_list.jsp").forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> productlist = ProductDao.findAllProduct();
		request.setAttribute("productList",productlist);
		request.setAttribute("page", 1);
		request.getRequestDispatcher("/jsp/product/display/product_list.jsp").forward(request,response);
	}

}
