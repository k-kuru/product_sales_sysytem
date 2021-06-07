package servlet.history;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ページング用サーブレット
 * @author NaSkanaishi
 */
@WebServlet("/HistoryPaging")
public class HistoryPaging extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", request.getParameter("page_num"));
		request.getRequestDispatcher("jsp/history/buy_history.jsp").forward(request, response);
	}
}
