/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BookDTO;
import DTO.CategoryDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author PC
 */
public class BookDAO {

    public String CreateID() {
	Random rnd = new Random();
	int number = rnd.nextInt(999999);
	return String.format("%06d", number);
    }

    public List<BookDTO> getListBook() throws SQLException {
	List<BookDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT bookID,title,image,description,price,quantity,author,cateID,status,createDate "
			+ " FROM tblBooks ";
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		while (rs.next()) {
		    String bookID = rs.getString("bookID");
		    String title = rs.getString("title");
		    String image = rs.getString("image");
		    String description = rs.getString("description");
		    float price = rs.getFloat("price");
		    int quantity = rs.getInt("quantity");
		    String author = rs.getString("author");
		    String cateID = rs.getString("cateID");
		    boolean status = rs.getBoolean("status");
		    Date createDate = rs.getDate("createDate");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    if (status == true && quantity > 0) {
			list.add(new BookDTO(bookID, title, image, description, price, quantity, author, cateID, status, createDate));
		    }
		}
	    }
	} catch (Exception e) {
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return list;
    }

    public List<CategoryDTO> getCategory() throws SQLException {
	List<CategoryDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT cateID,cateName FROM tblCategorys";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		while (rs.next()) {
		    String cateID = rs.getString("cateID");
		    String cateName = rs.getString("cateName");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    list.add(new CategoryDTO(cateID, cateName));
		}
	    }
	} catch (Exception e) {
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return list;
    }

    public List<BookDTO> getListByCate(String cate) throws SQLException {
	List<BookDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT B.bookID,B.title,B.image,B.description,B.price,B.quantity,B.author,C.cateName,B.status,B.createDate "
			+ " FROM tblBooks B,tblCategorys C"
			+ " WHERE B.cateID=C.cateID AND C.cateName='" + cate + "'";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		while (rs.next()) {
		    String bookID = rs.getString("bookID");
		    String title = rs.getString("title");
		    String image = rs.getString("image");
		    String description = rs.getString("description");
		    float price = rs.getFloat("price");
		    int quantity = rs.getInt("quantity");
		    String author = rs.getString("author");
		    String cateID = rs.getString("cateName");
		    boolean status = rs.getBoolean("status");
		    Date createDate = rs.getDate("createDate");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    if (status) {
			list.add(new BookDTO(bookID, title, image, description, price, quantity, author, cateID, status, createDate));
		    }
		}
	    }
	} catch (Exception e) {
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return list;
    }

    public boolean deleteBook(String bookID) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "UPDATE tblBooks SET status=0"
			+ " WHERE bookID='" + bookID + "'";
		stm = conn.prepareStatement(sql);
		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

    public BookDTO getBookByID(String bookID) throws SQLException {
	BookDTO book = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT B.bookID,B.title,B.image,B.description,B.price,B.quantity,B.author,C.cateName,B.status,B.createDate "
			+ " FROM tblBooks B, tblCategorys C "
			+ " WHERE B.cateID=C.cateID AND B.bookID='" + bookID + "'";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		if (rs.next()) {
		    String title = rs.getString("title");
		    float price = rs.getFloat("price");
		    int quantity = rs.getInt("quantity");
		    String author = rs.getString("author");
		    String image = rs.getString("image");
		    String description = rs.getString("description");
		    String cateID = rs.getString("cateName");
		    boolean status = rs.getBoolean("status");
		    Date createDate = rs.getDate("createDate");
		    if (book == null) {
			book = new BookDTO(bookID, title, image, description, price, quantity, author, cateID, true, createDate);
		    }
		}
	    }
	} catch (Exception e) {
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return book;
    }

    public String getCateIDbyName(String cateName) throws SQLException {
	String cateID = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT cateID from tblCategorys"
			+ " WHERE cateName='" + cateName + "'";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		if (rs.next()) {
		    cateID = rs.getString("cateID");
		}
	    }
	} catch (Exception e) {
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return cateID;
    }

    public boolean UpdateBook(BookDTO book) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "UPDATE tblBooks SET cateID='" + book.getCateID() + "', "
			+ " title='" + book.getTitle() + "', "
			+ " author='" + book.getAuthor() + "', "
			+ " price='" + book.getPrice() + "', "
			+ " quantity='" + book.getQuantity() + "'"
			+ " WHERE bookID='" + book.getBookID() + "'";
		stm = conn.prepareStatement(sql);

		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

    public boolean addNewBook(BookDTO book) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "INSERT INTO tblBooks(bookID,title ,image ,description ,price,quantity,author,cateID,status,createDate) "
			+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
		stm = conn.prepareStatement(sql);

		stm.setString(1, book.getBookID());
		stm.setString(2, book.getTitle());
		stm.setString(3, book.getImage());
		stm.setString(4, book.getDescription());
		stm.setFloat(5, book.getPrice());
		stm.setInt(6, book.getQuantity());
		stm.setString(7, book.getAuthor());
		stm.setString(8, book.getCateID());
		stm.setBoolean(9, book.isStatus());
		stm.setDate(10, book.getCreateDate());
		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

    public boolean addOrder(String orderID, Date createDate, Float total, String userID, String statusID) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "INSERT INTO tblOrders(orderID,orderDate,total,userID,status) "
			+ " values (?,?,?,?,?)";
		stm = conn.prepareStatement(sql);

		stm.setString(1, orderID);
		stm.setDate(2, createDate);
		stm.setFloat(3, total);
		stm.setString(4, userID);
		stm.setString(5, statusID);

		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

    public boolean addOrderDetail(String orderDetailID, float price, int quantity, String bookID, String orderID) throws SQLException {
	boolean check = false;
	Connection conn = null;
	PreparedStatement stm = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "INSERT INTO tblOrderDetails(orderDetailID,price,quantity,bookID,orderID) "
			+ " values (?,?,?,?,?)";
		stm = conn.prepareStatement(sql);

		stm.setString(1, orderDetailID);
		stm.setFloat(2, price);
		stm.setInt(3, quantity);
		stm.setString(4, bookID);
		stm.setString(5, orderID);

		check = stm.executeUpdate() > 0 ? true : false;
	    }
	} catch (Exception e) {
	} finally {
	    if (stm != null) {
		stm.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
	return check;
    }

}
