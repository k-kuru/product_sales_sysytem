package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class DBManager
 */
@WebServlet("/DBManager")
public class DBManager {
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@deployhandsonoracleinstance20210609.c2h1m6muiqww.ap-northeast-1.rds.amazonaws.com:1521:oracledb",
					"oracleadmin","eEuK1KWjY3zqBXvb3JNr");
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement ps, Connection con) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
