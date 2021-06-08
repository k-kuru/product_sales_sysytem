package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import db.UserDao;

/**
 * ユーザIDからユーザ情報を検索するサーブレット
 * @author motegi
 */
@WebServlet("/UserDetail")
public class UserDetail extends HttpServlet {

	/** ユーザIDから取得したユーザ情報を持ってユーザ詳細画面へ遷移 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId;
		//ユーザIDの指定がなければログインユーザのIDを取得
		if(request.getParameter("userId") == null) {
			HttpSession session = request.getSession();
			userId=((User)session.getAttribute("loginuser")).getUserId();
		}else {
			userId = request.getParameter("userId");
		}
		//ユーザIDからユーザ情報を検索
		User user = UserDao.showUserDetail(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/jsp/user/display/user_detail.jsp").forward(request, response);
	}

	/** 処理をGetに送る */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
