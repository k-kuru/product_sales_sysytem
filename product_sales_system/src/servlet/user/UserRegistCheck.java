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
 * Servlet implementation class UserRegistInput
 */
@WebServlet("/UserRegistInput")
public class UserRegistCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

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
		user.setTel(Integer.parseInt(tel));
		user.setAddress(address);

		// 入力チェック
		List<String> errorMessageList = Validator.makeUserInputErrorMessageList(user);
		if(errorMessageList.size() == 0) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/user/regist/regist_check.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", errorMessageList);
			request.getRequestDispatcher("/jsp/regist/regist.jsp").forward(request, response);
		}
	}

}
