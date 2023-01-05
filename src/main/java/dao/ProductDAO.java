package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.*;
import db.*;

import org.apache.tomcat.util.codec.binary.Base64;

public class ProductDAO {
	public ArrayList<Product> getAllProduct() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			conn = GetConnection.getConnection();
			String sql = "SELECT * FROM product;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setImageUrl(rs.getString("image_URL"));
				product.setPackageSize(rs.getString("package_size"));
				product.setDescription(rs.getString("description"));
				product.setUnitPrice(rs.getDouble("unit_price"));
				Brand brand = new Brand (rs.getInt("brand_id"),"");
				product.setBrand(brand);
				product.setLotNumber(rs.getString("lot_number"));
				Category cat = new Category (rs.getInt("category_id"),"");
				product.setCategory(cat);
				System.out.println(rs.getLong("category_id") + "/n");
				products.add(product);	
			} 
			conn.close();
		} catch (Exception ex) {
			Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
		}		
		return products;
	}
}
