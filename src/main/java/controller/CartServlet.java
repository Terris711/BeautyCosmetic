package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Product;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart==null) {
			cart= new Cart();00000000000000
		}
		
		String product_id=request.getParameter("id");
		String command=request.getParameter("command");
		ProductDAO productDAO= new ProductDAO();
		Product product= productDAO.getProductDetail(product_id);
		TreeMap<Product, Integer> list=cart.getList();
	
		ArrayList<Long> listBuy=null;
		String url="/cart.jsp";
		
		try {
		listBuy=(ArrayList<Long>) session.getAttribute("cartID");
		long idBuy=0;
		if(request.getParameter("cartID") != null) {
			idBuy=Long.parseLong(request.getParameter("cartID"));
		}
			Product product= productDAO.getProductDetail(product_id);
			switch(command) {
				case "insert":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cartID", listBuy);
					}
					if(listBuy.indexOf(idBuy)==-1) {
						cart.addToCart(product, 1);
						listBuy.add(idBuy);
					}
					url="/cart.jsp";
					break;
				case "add":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cartID", listBuy);
					}
					if(listBuy.indexOf(idBuy)==-1) {
						cart.addToCart(product, 1);
						listBuy.add(idBuy);
					}
					url="/cart.jsp";
					break;
				case "sub":
					if(listBuy==null) {
						listBuy=new ArrayList<>();
						session.setAttribute("cartID", listBuy);
					}
					if(listBuy.indexOf(idBuy)==-1) {
						cart.subToCart(product, 1);
						listBuy.add(idBuy);
					}
					url="/cart.jsp";
					break;
				case "remove":
					cart.removeToCart(product);
					url="/cart.jsp";
					break;
				default:
					break;
					
				
			}
			RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			
		
		} catch (Exception e){
			
		
		}
	}

}
