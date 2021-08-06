/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BookDAO;
import DTO.BookDTO;
import DTO.CartDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class PayController extends HttpServlet {

    private static final String SUCCESS = "shopping.jsp";
    private static final String ERROR = "view_cart.jsp";
    private static final String LOGIN = "login.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String url = ERROR;
	try {
	    Float total = Float.parseFloat(request.getParameter("total"));
	    String userID = request.getParameter("userID");
	    if (userID == null) {
		url = LOGIN;
	    } else {
		long millis = System.currentTimeMillis();
		java.sql.Date createDate = new java.sql.Date(millis);
		BookDAO dao = new BookDAO();
		String orderID = dao.CreateID();
		boolean check = dao.addOrder(orderID, createDate, total, userID, "IP");
		if (check) {
		    HttpSession session = request.getSession();
		    CartDTO cart = (CartDTO) session.getAttribute("CART");
		    for (BookDTO obj : cart.getCart().values()) {
			String orderDetailID = dao.CreateID();
			boolean checkAdd = dao.addOrderDetail(orderDetailID, obj.getPrice(), obj.getQuantity(), obj.getBookID(), orderID);
			BookDTO book = dao.getBookByID(obj.getBookID());
			if (book.getQuantity() > obj.getQuantity()) {
			    int newQuantity = book.getQuantity() - obj.getQuantity();
			    book.setQuantity(newQuantity);
			    String cateID=dao.getCateIDbyName(book.getCateID());
			    book.setCateID(cateID);
			    boolean updateQuantity = dao.UpdateBook(book);
			    if (checkAdd && updateQuantity) {
				url = SUCCESS;
			    }
			}
		    }
		}
	    }
	} catch (Exception e) {
	} finally {
	    request.getRequestDispatcher(url).forward(request, response);
	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
