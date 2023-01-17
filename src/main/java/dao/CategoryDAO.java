package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.GetConnection;
import model.*;


public class CategoryDAO {
	public List<Category> getAllCategory() throws SQLException {
		
		Connection conn = GetConnection.getConnection();

		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM category;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			Category category= new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			categories.add(category);
			}

			conn.close();
		} catch (SQLException ex) {

			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return categories;

	}
}
