package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import model.*;
import db.GetConnection;

public class AccountDAO {
	public Account getAccountByUsernameAndPassword(String username, String password) throws SQLException {
		// access to database to get Student Record by Email and Password.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// make connection to Mysql
			conn = GetConnection.getConnection();

			String sql = "SELECT * FROM account WHERE username = ? AND password = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt("id"));
				acc.setUsername(username);
				acc.setPassword(password);
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));
				acc.setPhone(rs.getString("Phone"));
				acc.setAddress(rs.getString("address"));
				return acc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			GetConnection.close(conn, ps, rs);
		}
		return null;
	}

	public Account checkAccountExist(String username) throws SQLException {
		// access to database to get Student Record by Email and Password.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// make connection to Mysql
			conn = GetConnection.getConnection();
			String sql = "SELECT * FROM account WHERE username = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt("id"));
				acc.setUsername(username);
				acc.setPassword(rs.getString("password"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));
				acc.setPhone(rs.getString("Phone"));
				acc.setAddress(rs.getString("address"));
				return acc;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			GetConnection.close(conn, ps, rs);
		}
		return null;
	}

	public Account getAccountByUsernameAndEmail(String username, String email) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// make connection to Mysql
			conn = GetConnection.getConnection();

			String sql = "SELECT * FROM account WHERE username = ? AND email = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);

			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt("id"));
				acc.setUsername(username);
				acc.setPassword(rs.getString("password"));
				acc.setName(rs.getString("name"));
				acc.setEmail(email);
				acc.setPhone(rs.getString("Phone"));
				acc.setAddress(rs.getString("address"));
				return acc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			GetConnection.close(conn, ps, rs);
		}
		return null;
	}

	public void registerAccount(String username, String password, String name, String email, String phone, String address) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// make connection to Mysql
			conn = GetConnection.getConnection();
			String sql = "INSERT INTO `beauty_cosmetic`.`account` (`username`, `password`, `name`, `email`, `phone`,`address`) VALUES (?,?,?,?,?,?);";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, phone);
			ps.setString(6, address);
			ps.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			GetConnection.closeRegister(conn, ps);
		}
	}

	public int getTotalAccount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = GetConnection.getConnection();
			String sql = "select count(*) from account";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GetConnection.close(conn, ps, rs);
		}
		return 0;
	}

	public List<Account> getAllAccount() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Account> accounts = new ArrayList<Account>();

		try {
			conn = GetConnection.getConnection();
			String sql = "SELECT * FROM account";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Account acc = new Account();
				acc.setId(rs.getInt("id"));
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));
				acc.setPhone(rs.getString("Phone"));
				acc.setAddress(rs.getString("address"));
				accounts.add(acc);
			}
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}finally {
			GetConnection.close(conn, ps, rs);
		}
	}

	public Account getAccountById(String id) throws Exception {
		// access to database to get Student Record by Email and Password.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account acc = null;

		try {
			// make connection to Mysql
			conn = GetConnection.getConnection();

			String sql = "SELECT * FROM account WHERE id = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));

			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				acc = new Account();
				acc.setId(Integer.parseInt(id));
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));
				acc.setPhone(rs.getString("Phone"));
				acc.setAddress(rs.getString("address"));
			} else {
				throw new Exception("Cannot find account with value id: " + id);
			}
		
			return acc;
		}  finally {
			GetConnection.close(conn, ps, rs);
		}
	}
	
	public void updateAccount(Account account) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// make connection to Mysql
			conn = GetConnection.getConnection();
			String sql = "update account set username=?, password=?, name=?, email=?, phone=?,address=? where id = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getName());
			ps.setString(4, account.getEmail());
			ps.setString(5, account.getPhone());
			ps.setString(6, account.getAddress());
			ps.setInt(7, account.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GetConnection.closeRegister(conn, ps);
		}
	}
	
	public void deleteAccount (int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = GetConnection.getConnection();
			String sql = "delete from account where id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
		} finally {
			GetConnection.closeRegister(conn, ps);
		}
	}
		

}