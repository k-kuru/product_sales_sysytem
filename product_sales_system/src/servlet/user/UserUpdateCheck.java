package servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import util.Validator;

/**
 * ユーザ情報を持ってユーザ更新確認画面に遷移
 * @author matsuzaki
 *
 */
@WebServlet("/UserUpdateCheck")
public class UserUpdateCheck extends HttpServlet {
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

		// 入力チェック
		List<String> errorMessageList = Validator.makeUserInputErrorMessageList(user);
		//エラーメッセージがなければ確認画面に遷移
		if(errorMessageList.size() == 0) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/user/update/check.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", errorMessageList);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/user/update/input.jsp").forward(request, response);
		}
	}

}
