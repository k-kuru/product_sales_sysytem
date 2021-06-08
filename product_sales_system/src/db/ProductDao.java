package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

/**
 * product_tableに関するDAO
 * @author kuru
 */
public class ProductDao {

	/**
	 * productテーブルの全データを取得
	 *  @return productList 商品情報のリスト
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
	 *  @param product_id
	 *  @return product 商品情報
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
	 * @param product_name
	 * @return productList 商品情報のリスト
	 */
	public static List<Product> serchProductName(String product_name) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			con = DBManager.getConnection();

			ps = con.prepareStatement("SELECT * FROM product WHERE product_name like ? AND delete_flag = 0 ORDER BY product_name ASC");
			ps.setString(1, "%" + product_name + "%");
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
	 * productテーブルにデータを登録
	 * @param product 商品情報
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
	 * @param product 商品情報
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
	 * @param product 商品情報
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

	/**
	 * 商品の在庫取得
	 * @pram product_id
	 * @return stock 在庫
	 */
	public static int getStock(String product_id) {
		Connection con = null;
		PreparedStatement ps = null;
		int stock = 0;
		try {
			con = DBManager.getConnection();
			ps=con.prepareStatement("SELECT stock FROM product WHERE product_id = ?");
			ps.setString(1, product_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			stock=rs.getInt("stock");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps,con);
		}
		return stock;
	}

	/**
	 * 購入数にあわせ商品の在庫を減らす
	 * @pram product_id,quantity
	 */
	public static void reduceStock(String product_id,int quantity) {
		Connection con = null;
		PreparedStatement ps =null;
		try {
			con = DBManager.getConnection();
			int stock=ProductDao.getStock(product_id)-quantity;
			ps = con.prepareStatement("UPDATE product SET stock=? WHERE product_id=?");
			ps.setString(1, String.valueOf(stock));
			ps.setString(2, product_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(ps, con);
		}

	}
}
