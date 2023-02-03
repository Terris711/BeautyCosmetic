package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import dao.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private AccountDAO accountDAO = new AccountDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 if (request.getParameter("Command").equals("logout") ){
				HttpSession session = request.getSession();
				session.removeAttribute("username");
				response.sendRedirect("home");
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String err = "";
		try {
			String url=null;

			if (username.equals("") || password.equals("")) {
				err = "Please input your information";
			} else {
				Account account = accountDAO.getAccountByUsernameAndPassword(username, password);
				if (account == null) {
					err = "Wrong email or password";
				}
			}
			if (err.length() > 0)
				{request.setAttribute("err", err);
			url = "/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);}
			if (err.length() == 0) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				url = "home";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			} 
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
