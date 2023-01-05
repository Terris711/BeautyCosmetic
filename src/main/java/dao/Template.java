package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.GetConnection;

public class Template {
	public List<Category> getAllCategory() throws SQLException {
		Connection cons =GetConnection.getConnection();
		
		List<Category> categories =new ArrayList<Category>();
		String sql="SELECT * FROM category";
		try {
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
		} catch (SQLException ex) {
			
			Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		return categories;
		
	}
}
