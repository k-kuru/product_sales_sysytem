package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDao  {

	/**
	 * productテーブルの全データを取得
	 */
	public static List<Product> findAllProduct() {
		Connection con = null;
		PreparedStatement ps = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductId(rs.getString("product_explain"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));
				product.setDeleteFlag(rs.getInt("delete_flag"));

               productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(ps, con);
        }
        return productList;
			}
}
