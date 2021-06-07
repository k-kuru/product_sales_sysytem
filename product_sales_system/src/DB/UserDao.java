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
	 * @return userList ユーザ情報のリスト
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
				user.setTel(rs.getString("tel"));
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

	/**
	 * ユーザ情報表示
	 * @param user_id
	 * @return user ユーザ情報
	 */
	public static User showUserDetail(String user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		User user = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM user_table WHERE user_id = ?");
			ps.setString(1, user_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPass(rs.getString("pass"));
				Date birthday = rs.getDate("birthday");
				user.setBirthDay(sdf.format(birthday));
				user.setGender(rs.getInt("gender"));
				user.setTel(rs.getString("tel"));
				user.setAddress(rs.getString("address"));
				user.setAuthority(rs.getInt("authority"));
				user.setDeleteFlag(rs.getInt("delete_flag"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return user;
	}

	/**
	 * user_tableにユーザ情報を追加
	 * @param user ユーザ情報
	 */
	public static void registUser(User user) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("INSERT INTO user_table (user_id, user_name, "
					+ "pass, birthday, gender, tel, address, authority, delete_flag) "
					+ "VALUES(?,?,?,?,?,?,?,0,0)");

			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPass());
			ps.setString(4, user.getBirthDay());
			ps.setInt(5, user.getGender());
			ps.setString(6, user.getTel());
			ps.setString(7, user.getAddress());
			ps.executeUpdate();

		}
		catch (SQLException e) {
        e.printStackTrace();
		} finally {
        DBManager.close(ps, con);
		}
	}

	/**
	 * user_tableのユーザ情報を更新
	 * @param user ユーザ情報
	 */
	public static void updateUser(User user) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("UPDATE user_table SET user_name = ?, "
					+ "pass = ?, birthday = ?, gender = ?, tel = ?, address = ?, "
					+ "authority = ? WHERE user_id = ? ");

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getBirthDay());
			ps.setInt(4, user.getGender());
			ps.setString(5, user.getTel());
			ps.setString(6, user.getAddress());
			ps.setInt(7, user.getAuthority());
			ps.setString(8, user.getUserId());
			ps.executeUpdate();

		}
		catch (SQLException e) {
        e.printStackTrace();
		} finally {
        DBManager.close(ps, con);
		}

	}

	/**
	 * user_tableのユーザ情報を論理削除
	 * @param userId ユーザID
	 */
	public static void deleteUser(String userId) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("UPDATE user_table SET delete_flag = 1 WHERE user_id = ?");

			ps.setString(1, userId);
			ps.executeUpdate();

		}
		catch (SQLException e) {
        e.printStackTrace();
		} finally {
        DBManager.close(ps, con);
		}
	}
}
