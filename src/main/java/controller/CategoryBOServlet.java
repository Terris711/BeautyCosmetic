package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import model.Category;

/**
 * Servlet implementation class CategoryBOServlet
 */
@WebServlet("/CategoryBOServlet")
public class CategoryBOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Step 1: tao Dao object
	private CategoryDAO categoryDAO = new CategoryDAO();
	
       
 
    public CategoryBOServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command= request.getParameter("command");
			if(command==null)
				command="LIST";
			switch (command) {
			case "LIST":
				listCategory(request,response);
				break;
			default:
				listCategory(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		private void listCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
			List<Category> categories = categoryDAO.getAllCategory();
			System.out.println(categories.size());
			//ADD CATEGORY TO REQUEST
			request.setAttribute("CATEGORY_LIST", categories);
			//SEND TO JSP
			RequestDispatcher rd= request.getRequestDispatcher("category2.jsp");
			rd.forward(request, response);
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
