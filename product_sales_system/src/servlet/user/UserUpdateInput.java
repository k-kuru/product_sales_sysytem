package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.UserDao;
import bean.User;

/**
 * Servlet implementation class UserUpdateInput
 */
@WebServlet("/UserUpdateInput")
public class UserUpdateInput extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");

		User user = UserDao.showUserDetail(userId);

		request.setAttribute("user", user);
		request.getRequestDispatcher("/jsp/update/update/input.jsp").forward(request,response);
	}

}
