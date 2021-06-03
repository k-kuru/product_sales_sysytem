package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.User;

public class UserDao {

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	/**
	 * userテーブルの全データを取得
	 */
	public static List<User> findAllUser() {
		Connection con = null;
		PreparedStatement ps = null;
		List<User> userList = new ArrayList<User>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM user_table WHERE delete_flag = 0 ORDER BY user_id ASC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPass(rs.getString("pass"));
				Date birthday = rs.getDate("birthday");
				user.setBirthDay(sdf.format(birthday));
				user.setAddress(rs.getString("address"));
				user.setGender(rs.getInt("gender"));
				user.setTel(rs.getInt("tel"));
				user.setAuthority(rs.getInt("authority"));
				user.setDeleteFlag(rs.getInt("delete_flag"));

               userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return userList;
			}
}
