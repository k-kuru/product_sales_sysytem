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
 * ユーザ登録をしユーザ登録完了画面に遷移するサーブレット
 * @author matsuzaki
 *
 */
@WebServlet("/UserRegist")
public class UserRegist extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		//ユーザを登録するメソッドを呼び出す
		UserDao.registUser(user);

		request.getRequestDispatcher("/jsp/user/regist/complete.jsp").forward(request, response);
	}

}
