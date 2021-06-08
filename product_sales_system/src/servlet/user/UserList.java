package servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import db.UserDao;

/**
 * ユーザー一覧
 * @author kanno
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**全てのユーザー情報を入れるやつ*/
		List<User> userlist = UserDao.findAllUser();
		/**セッションスコープに入れるやつ*/
		request.setAttribute("userList",userlist);
		/**ページリンク*/
		if(request.getParameter("page_num")==null) {
			request.setAttribute("page", 1);
		}else {
			request.setAttribute("page", request.getParameter("page_num"));
		}
		/**ユーザー一覧に遷移*/
		request.getRequestDispatcher("/jsp/user/list/user_list.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**全てのユーザー情報を入れるやつ*/
		List<User> userlist = UserDao.findAllUser();
		/**セッションスコープに入れるやつ*/
		request.setAttribute("userList",userlist);
		/**ページリンク*/
		if(request.getParameter("page_num")==null) {
			request.setAttribute("page", 1);
		}else {
			request.setAttribute("page", request.getParameter("page_num"));
		}
		/**ユーザー一覧に遷移*/
		request.getRequestDispatcher("/jsp/user/list/user_list.jsp").forward(request,response);
	}

}
