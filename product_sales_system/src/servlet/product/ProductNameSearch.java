package servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.ProductDao;
import bean.Product;

/**
 * Servlet implementation class Product_Name_Search
 */
@WebServlet("/ProductNameSearch")
public class ProductNameSearch extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		String productName = request.getParameter("productName");
		List<Product> productList = ProductDao.serchProductName(productName);
		System.out.println(productList.size());
=======
		request.setCharacterEncoding("UTF-8");
		String productName = request.getParameter("productName");
		List<Product> productList = ProductDao.serchProductName(productName);
		//System.out.println(productList.size());
>>>>>>> d2ab7213e9425fe8b4b0311f9bb3ce6c0c2960a1
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/jsp/product/display/product_list.jsp").forward(request, response);
	}

}
