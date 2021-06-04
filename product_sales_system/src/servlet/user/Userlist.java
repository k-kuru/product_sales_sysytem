package servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.UserDao;
import bean.User;

/**
 * Servlet implementation class Userlist
 */
@WebServlet("/Userlist")
public class Userlist extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userlist = UserDao.findAllUser();
		request.setAttribute("userList",userlist);
		request.setAttribute("page", 1);
		request.getRequestDispatcher("/jsp/user/list/user_list.jsp").forward(request,response);
	}

}
