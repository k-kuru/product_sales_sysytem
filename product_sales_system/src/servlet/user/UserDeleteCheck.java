package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import db.UserDao;

/**
 * ユーザIDから詳細情報を検索しユーザ削除確認画面に遷移するサーブレット
 * @author matsuzaki
 */
@WebServlet("/UserDeleteCheck")
public class UserDeleteCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		//ユーザ情報を返すメソッドを呼び出す
		User user = UserDao.showUserDetail(userId);

		request.setAttribute("user", user);
		request.getRequestDispatcher("/jsp/user/delete/check.jsp").forward(request,
				response);
	}

}
