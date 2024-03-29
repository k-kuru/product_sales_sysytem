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
 * ユーザー一覧のサーブレット
 * @author kanno
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//全てのユーザー情報を入れるリスト
		List<User> userlist = UserDao.findAllUser();
		//セッションスコープに入れる変数
		request.setAttribute("userList",userlist);
		//ページ番号がなければ表示
		if(request.getParameter("page_num")==null) {
			request.setAttribute("page", 1);
		}else {
			//ページ番号があれば2以降も表示
			request.setAttribute("page", request.getParameter("page_num"));
		}
		//ユーザー一覧画面に遷移
		request.getRequestDispatcher("/jsp/user/list/user_list.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//全てのユーザー情報を入れるリスト
		List<User> userlist = UserDao.findAllUser();
		//セッションスコープに入れる変数
		request.setAttribute("userList",userlist);
		//ページ番号がなければ表示
		if(request.getParameter("page_num")==null) {
			request.setAttribute("page", 1);
		}else {
			//ページ番号があれば2以降も表示
			request.setAttribute("page", request.getParameter("page_num"));
		}
		//ユーザー一覧画面に遷移
		request.getRequestDispatcher("/jsp/user/list/user_list.jsp").forward(request,response);
	}

}
