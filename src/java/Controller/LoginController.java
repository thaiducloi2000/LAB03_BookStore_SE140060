/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BookDAO;
import DAO.UserDAO;
import DTO.CategoryDTO;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class LoginController extends HttpServlet {

    private static final String isAdmin = "admin_page.jsp";
    private static final String isUser = "shopping.jsp";
    private static final String ERROR = "login.jsp";

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
	    String userID = request.getParameter("userID");
	    String password = request.getParameter("password");
	    UserDAO userDao = new UserDAO();
	    UserDTO user = userDao.checkLogin(userID, password);
	    if (user.getRoleID().equals("ADM")) {
		BookDAO bookDao = new BookDAO();
		List<CategoryDTO> cateList = bookDao.getCategory();
		HttpSession session = request.getSession();
		session.setAttribute("USER", user);
		session.setAttribute("LIST_CATEGORY", cateList);
		url = isAdmin;
	    }
	    if (user.getRoleID().equals("US")) {
		BookDAO bookDao = new BookDAO();
		List<CategoryDTO> cateList = bookDao.getCategory();
		HttpSession session = request.getSession();
		session.setAttribute("USER", user);
		session.setAttribute("LIST_CATEGORY", cateList);
		url = isUser;
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
