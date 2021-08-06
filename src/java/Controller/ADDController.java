/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BookDAO;
import DTO.BookDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author PC
 */
@MultipartConfig
public class ADDController extends HttpServlet {

    private static final String SUCCESS="admin_page.jsp";
    private static final String ERROR="addNewBook_page.jsp";
    
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
	    BookDAO dao=new BookDAO();
	    String bookID=dao.CreateID();
	    String titile=request.getParameter("title");
	    Part part = request.getPart("image");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	    part.write("E:/Program Files/New world/For Studying/pc1438/LAB231/LAB03_BookStore_SE140060/web/CSS/img" + "/" + fileName);
	    String description=request.getParameter("description");
	    float price=Float.parseFloat(request.getParameter("price"));
	    String author=request.getParameter("author");
	    String cateName=request.getParameter("cate");
	    String cateID = dao.getCateIDbyName(cateName);
	    int quantity=Integer.parseInt(request.getParameter("quantity"));
	    long millis = System.currentTimeMillis();
	    java.sql.Date createDate = new java.sql.Date(millis);
	    BookDTO book=new BookDTO(bookID, titile, fileName, description, price, quantity, author, cateID, true, createDate);
	    boolean check=dao.addNewBook(book);
	    if(check){
		url=SUCCESS;
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
