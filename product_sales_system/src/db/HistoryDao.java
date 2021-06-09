package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.BuyHistory;
import bean.Cart;
import bean.Product;
import bean.User;

/**
 * buy_historyテーブルに関するDAO
 * @author matsuzaki
 */
public class HistoryDao {

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * buy_historyテーブルの全データを取得
	 * @param userId ユーザID
	 * @return historyList 購入履歴
	 */
	public static List<BuyHistory> findAllHistory(String userId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<BuyHistory> historyList = new ArrayList<BuyHistory>();

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT history_id, user_id, h.product_id, quantity, "
					+ "buy_date, product_name, price from buy_history h inner join product p "
					+ "On h.product_id = p.product_id WHERE user_id = ? Order By history_id desc");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BuyHistory buyHistory = new BuyHistory();
				buyHistory.setHistoryId(rs.getInt("history_id"));
				buyHistory.setQuantity(rs.getInt("quantity"));

				Date buyDate = rs.getDate("buy_date");
				buyHistory.setBuyDate(sdf.format(buyDate));

				User user = new User();
				user.setUserId(rs.getString("user_id"));

				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getString("price"));

				buyHistory.setUser(user);
				buyHistory.setProduct(product);

				historyList.add(buyHistory);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return historyList;
	}

	/**
	 * buy_historyに購入履歴を登録
	 * @param cart カートの中身
	 * @param user ユーザ情報
	 */
	public static void registHistory(Cart cart, User user) {
		Connection con = null;
		PreparedStatement ps = null;
		String product_id=cart.getProduct().getProductId();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("INSERT INTO buy_history VALUES(seq_history.NEXTVAL,?,?,?,TO_DATE(?,'yyyy/MM/dd'))");
			ps.setString(1, user.getUserId());
			ps.setString(2, product_id);
			ps.setString(3, String.valueOf(cart.getQuantity()));
			Date d = new Date();
			java.sql.Date date = new java.sql.Date(d.getTime());
			ps.setDate(4, date);
			ps.executeUpdate();

			ProductDao.reduceStock(product_id,cart.getQuantity());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}
}
