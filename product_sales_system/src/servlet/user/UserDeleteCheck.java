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
 * ユーザIDから詳細情報を検索しユーザ削除確認画面に遷移
 * @author matsuzaki
 *
 */
@WebServlet("/UserDeleteCheck")
public class UserDeleteCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User user = UserDao.showUserDetail(userId);

		request.setAttribute("emp", user);
		request.getRequestDispatcher("/jsp/user/delete/check.jsp").forward(request,
				response);
	}

}
