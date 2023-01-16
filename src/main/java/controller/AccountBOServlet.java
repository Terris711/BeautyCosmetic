package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import model.*;


/**
 * Servlet implementation class AccountBOServlet
 */
@WebServlet("/AccountBOServlet")
public class AccountBOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO = new AccountDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountBOServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			try {
			
			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}
			
			switch (command) {
			case "LIST":
				listAccount(request, response);
				break;
			case "ADD":
				addAccount(request, response);
				break;
			case "LOAD":
				loadAccount(request, response);
				break;
			case "UPDATE":
				updateAccount(request, response);
				break;
			case "DELETE":
				deleteAccount(request, response);
				break;
			default:
				listAccount(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listAccount (HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Account> accounts = accountDAO.getAllAccount();
		request.setAttribute("ACCOUNT_LIST", accounts);
		System.out.println(accounts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("account-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addAccount (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		accountDAO.registerAccount(username, password, name, email, phone, address);
		listAccount(request, response);
	}
	
	private void loadAccount (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Account account = accountDAO.getAccountById(id);
		request.setAttribute("LOAD_ACCOUNT", account);
		RequestDispatcher dispatcher = request.getRequestDispatcher("account-update-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateAccount (HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Account account= new Account(id, username, password, name, email, phone, address);
		accountDAO.updateAccount(account);
		listAccount(request, response);
	}
	
	private void deleteAccount (HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		accountDAO.deleteAccount(id);
		listAccount(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}