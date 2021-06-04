package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.BuyHistory;
import bean.Product;
import bean.User;

public class HistoryDao {

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * buy_historyテーブルの全データを取得
	 * @return
	 */
	public static List<BuyHistory> findAllHistory(String userId) {
		Connection con = null;
		PreparedStatement ps = null;
		List<BuyHistory> historyList = new ArrayList<BuyHistory>();

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT history_id, user_id, h.product_id, quantity, "
					+ "buy_date, product_name from buy_history h inner join product p "
					+ "On h.product_id = p.product_id WHERE user_id = ? Order By history_id asc");
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
}
