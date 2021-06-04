package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserPaging
 */
@WebServlet("/UserPaging")
public class UserPaging extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("page", request.getParameter("page num"));
		request.getRequestDispatcher("jsp/user/list/user_list.jsp").forward(request, response);
	}
}
