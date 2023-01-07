package test;

import java.sql.SQLException;

import dao.*;
import model.Product;
import controller.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {

	public static void main(String[] args) throws SQLException {
		CategoryDAO cat= new CategoryDAO();
		ProductDAO pro= new ProductDAO();
		AccountDAO acc= new AccountDAO();
//		
	System.out.println(acc.getAccountByUsernameAndPassword("Anna456", "456").getEmail());

	
	
	
	
		
		
		
	
		

	}

}
