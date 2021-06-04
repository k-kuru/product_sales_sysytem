package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.UserDao;

/**
 * ユーザ削除をしユーザ削除完了画面に遷移
 * @author matsuzaki
 *
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserDao.deleteUser(userId);

		HttpSession session = request.getSession();
		//セッションスコープに登録されているカート情報も削除
		session.removeAttribute("cartList");

		request.getRequestDispatcher("/jsp/user/delete/complete.jsp").forward(request, response);
	}

}