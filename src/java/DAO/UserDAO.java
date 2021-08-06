/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.OrderDTO;
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class UserDAO {

    public UserDTO checkLogin(String userID, String password) throws SQLException {
	UserDTO user = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT userName,phoneNumber,email,roleID "
			+ " FROM tblUsers "
			+ " WHERE userID='" + userID + "' AND password='" + password + "'";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		if (rs.next()) {
		    String userName = rs.getString("userName");
		    String phoneNumber = rs.getString("phoneNumber");
		    String email = rs.getString("email");
		    String roleID = rs.getString("roleID");
		    user = new UserDTO(userID, userName, password, phoneNumber, email, roleID);
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
	return user;
    }

    public List<OrderDTO> getListOrder(String userID) throws SQLException {
	List<OrderDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT orderID,orderDate,total,status "
			+ " FROM tblOrders "
			+ " WHERE userID='" + userID + "'";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		while (rs.next()) {
		    String orderID = rs.getString("orderID");
		    Date orderDate = rs.getDate("orderDate");
		    Float total = rs.getFloat("total");
		    String status = rs.getString("status");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    list.add(new OrderDTO(orderID, orderDate, total, userID, status));
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

    public List<OrderDTO> getListOrderByDay(String userID, Date orderDate) throws SQLException {
	List<OrderDTO> list = null;
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;
	try {
	    conn = DBUtils.DBUtils.openConection();
	    if (conn != null) {
		String sql = "SELECT orderID,total,status "
			+ " FROM tblOrders "
			+ " WHERE user='" + userID + "'"
			+ " AND orderDate='" + orderDate + "'";
		stm = conn.prepareStatement(sql);

		rs = stm.executeQuery();
		while (rs.next()) {
		    String orderID = rs.getString("orderID");
		    Float total = rs.getFloat("total");
		    String status = rs.getString("status");
		    if (list == null) {
			list = new ArrayList<>();
		    }
		    list.add(new OrderDTO(orderID, orderDate, total, userID, status));
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
}
