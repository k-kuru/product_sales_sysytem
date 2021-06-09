package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

/**
 * ユーザ新規登録確認画面から入力画面へ戻る時に動作するサーブレット
 */
@WebServlet("/UserRegistInput")
public class UserRegistInput extends HttpServlet {
	/** ユーザ新規登録確認画面の値を入力画面へ送る */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPass(pass);
		user.setBirthDay(birthday);
		user.setGender(Integer.parseInt(gender));
		user.setTel(tel);
		user.setAddress(address);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/jsp/user/regist/input.jsp").forward(request, response);
	}

	/** postを受け取った場合getに送る */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
