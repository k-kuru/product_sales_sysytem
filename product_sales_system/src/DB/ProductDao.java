package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDao {

	/**
	 * productテーブルの全データを取得
	 */
	public static List<Product> findAllProduct() {
		Connection con = null;
		PreparedStatement ps = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM product WHERE delete_flag = 0 ORDER BY product_name ASC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductExplain(rs.getString("product_explain"));
				product.setPrice(rs.getString("price"));
				product.setStock(rs.getString("stock"));
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

	/**
	 * 商品詳細表示
	 * 商品IDで検索
	 * 一致する商品があればデータを取得
	 */
	public static Product showProductDetail(String product_id) {
		Connection con = null;
		PreparedStatement ps = null;
		Product product = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM product WHERE product_id = ?");
			ps.setString(1, product_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductExplain(rs.getString("product_explain"));
				product.setPrice(rs.getString("price"));
				product.setStock(rs.getString("stock"));
				product.setDeleteFlag(rs.getInt("delete_flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
		return product;
	}

	/**
	 * 商品名で検索
	 * 一致する名前があればデータを取得
	 */
	public static List<Product> serchProductName(String product_name) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			con = DBManager.getConnection();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b6c71dabc47fa845e2f5168d865d5c14d54d6592
			ps = con.prepareStatement("SELECT * FROM product WHERE product_name like ? AND delete_flag = 0 ORDER BY product_name ASC");
=======
<<<<<<< HEAD
			ps = con.prepareStatement("SELECT * FROM product WHERE product_name like ? AND delete_flag = 0 ORDER BY product_name ASC");
=======
			ps = con.prepareStatement("select * from product where product_name like ? And delete_flag = 0 order by product_name asc");
>>>>>>> 4828b1dbf8169efacbf6df73d8f68288e6723d98
>>>>>>> b6c71dabc47fa845e2f5168d865d5c14d54d6592
			ps.setString(1, "%" + product_name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("1");
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setProductExplain(rs.getString("product_explain"));
				product.setPrice(rs.getString("price"));
				product.setStock(rs.getString("stock"));
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

	/**
	 * productテーブルにデータを登録
	 */
	public static void registProduct(Product product) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("INSERT INTO product (product_id, "
					+ "product_name, product_explain, price, stock, delete_flag) VALUES(?,?,?,?,?,0)");

			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductExplain());
			ps.setString(4, product.getPrice());
			ps.setString(5, product.getStock());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}

	/**
	 * productテーブルのデータを更新
	 */
	public static void updateProduct(Product product) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("UPDATE product SET product_name = ?, "
					+ "product_explain = ?, price = ?, stock = ? WHERE product_id = ?");

			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductExplain());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getStock());
			ps.setString(5, product.getProductId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}

	/**
	 * productテーブルのデータを論理削除
	 */
	public static void deleteProduct(String product_id) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement("UPDATE product SET delete_flag = 1 WHERE product_id = ?");

			ps.setString(1, product_id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, con);
		}
	}
}
