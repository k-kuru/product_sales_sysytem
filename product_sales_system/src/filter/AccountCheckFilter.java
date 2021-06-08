package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bean.User;

/**
 * Servlet Filter implementation class AccountCheckFilter
 */
@WebFilter(urlPatterns={})
public class AccountCheckFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AccountCheckFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// セッションを利用する準備
		HttpSession session = ((HttpServletRequest) request).getSession();
		// セッションスコープに登録されているユーザー情報を取得
		User user = (User) session.getAttribute("loginuser");
		if (user != null ) {
			// ユーザー情報が取得できたら通常通り遷移
			chain.doFilter(request, response);
		} else {
			// セッション情報を削除
			session.invalidate();
			// ユーザー情報が取得できなかったらログイン画面へ遷移
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}