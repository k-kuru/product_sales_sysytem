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
 * ユーザ更新をしユーザ更新完了画面に遷移
 * @author matsuzaki
 *
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String authority = request.getParameter("authority");

		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPass(pass);
		user.setBirthDay(birthday);
		user.setGender(Integer.parseInt(gender));
		user.setTel(tel);
		user.setAddress(address);
		user.setAuthority(Integer.parseInt(authority));

		//ユーザを更新するメソッドを呼び出す
		UserDao.updateUser(user);

		//session呼び出し
		HttpSession session = request.getSession();

		//管理者が自分の名前を変更しているか
		User loginUser = (User) session.getAttribute("loginuser");
		if (user.getUserId() == loginUser.getUserId()) {
			//ヘッダーの表示名を変える。
			loginUser.setUserName(user.getUserName());

		}

		request.getRequestDispatcher("/jsp/user/update/complete.jsp").forward(request, response);

	}

}
