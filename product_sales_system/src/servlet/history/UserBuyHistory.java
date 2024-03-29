package servlet.history;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BuyHistory;
import bean.User;
import db.HistoryDao;

/**
 * 購入履歴を表示する
 * @author matsuzaki
 *
 */
@WebServlet("/UserBuyHistory")
public class UserBuyHistory extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		User loginuser = (User) session.getAttribute("loginuser");
		//購入履歴を返すメソッドを呼び出す
		List<BuyHistory> historyList = HistoryDao.findAllHistory(loginuser.getUserId());

		request.setAttribute("historyList",historyList);
		//ページ番号があれば次のページを表示する。
		if(request.getParameter("page_num")==null) {
			request.setAttribute("page", 1);
		}else {
			request.setAttribute("page", request.getParameter("page_num"));
		}
		request.getRequestDispatcher("/jsp/history/buy_history.jsp").forward(request,response);
	}

}
