/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class MainController extends HttpServlet {

    private static final String LOGIN="LoginController";
    private static final String SEARCH="SearchController";
    private static final String InsertBook="AddController";
    private static final String Delete="DeleteController";
    private static final String Logout="LogoutController";
    private static final String Update="UpdateController";
    private static final String Confirm="UpdateBookController";
    private static final String INSERT="addNewBook_page.jsp";
    private static final String ADD="ADDController";
    private static final String VIEW_BOOK="ViewBookController";
    private static final String Add_TO_CART="AddToCartController";
    private static final String DELETE_FROM_CART="DeleteFromCartController";
    private static final String Update_CART="UpdateCartController";
    private static final String View_History="ViewHistoryController";
    private static final String Pay="PayController";
    private static final String ERROR="error.jsp";
    
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
	String url=ERROR;
	try {
	    String action=request.getParameter("action");
	    if("Login".equals(action)){
		url=LOGIN;
	    }if("Search".equals(action)){
		url=SEARCH;
	    }if("Delete".equals(action)){
		url=Delete;
	    }if("Logout".equals(action)){
		url=Logout;
	    }
	    if("Update".equals(action)){
		url=Update;
	    }
	    if("Confirm".equals(action)){
		url=Confirm;
	    }if("Insert".equals(action)){
		url=INSERT;
	    }if("ADD".equals(action)){
		url=ADD;
	    }if("ViewBook".equals(action)){
		url=VIEW_BOOK;
	    }if("Add To Cart".equals(action)){
		url=Add_TO_CART;
	    }if("Delete Book".equals(action)){
		url=DELETE_FROM_CART;
	    }if("+".equals(action)){
		url=Update_CART;
	    }if("-".equals(action)){
		url=Update_CART;
	    }if("Pay".equals(action)){
		url=Pay;
	    }if("view history".equals(action)){
		url=View_History;
	    }
	    
	    
	} catch (Exception e) {
	}finally{
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
