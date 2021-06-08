package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.User;
import db.UserDao;
import util.Constants;
import util.Validator;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ログイン画面からIDとパスワードを取得
		String id = request.getParameter("userId");
		String password = request.getParameter("pass");

		//ログインチェック
		List<String> errorMessageList = Validator.makeLoginErrorMessageList(id, password);
		//入力値が不正だった場合
		if (!errorMessageList.isEmpty()) {
			//ログイン画面へ遷移
			request.setAttribute("errorMessage", errorMessageList);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);

		} else {
			//入力されたID、パスワードでユーザー情報を検索
			List<User>user = UserDao.findAllUser();
			request.setAttribute("userList", user);
			boolean logined = false;
			for (int i =0; i < user.size(); i++) {
				if (user.get(i).getUserId().equals(id) && user.get(i).getPass().equals(password)){
					HttpSession session = request.getSession();
					session.setAttribute("loginuser", user.get(i));
					List<Cart> cartList = new ArrayList<Cart>();
					session.setAttribute("cartList", cartList);
					logined = true;
					break;
				}
			}
			//該当するユーザーが見つかった時
			if (logined) {
				//商品一覧画面へ遷移
				request.getRequestDispatcher("/ProductSearch").forward(request, response);
			} else {
				//ID、またはパスワードが間違っていた場合
				errorMessageList.add(Constants.USER_ID_OR_PASSWORD_MISMATCH);
				request.setAttribute("errorMessage", errorMessageList);
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);

			}
		}
	}
}
