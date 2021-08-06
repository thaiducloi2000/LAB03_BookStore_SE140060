<%-- 
    Document   : view_cart
    Created on : Jun 30, 2021, 1:32:55 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.CART.getCart().values() !=null}">
            <c:if test="${not empty sessionScope.CART.getCart().values()}">
                <table border="1">
	  <thead>
	      <tr>
	          <th>No</th>
	          <th>Title</th>
	          <th>Price</th>
	          <th>Quantity</th>
	          <th>Sub Total</th>
	      </tr>
	  </thead>
	  <tbody>
	      <c:set var="total" value="${0}"/> 
	      <c:forEach var="book" varStatus="counter" items="${sessionScope.CART.getCart().values()}">
	          <c:set var="total" value="${total+ book.price * book.quantity}"/>
	      <form action="MainController">
	          <tr>
	              <td>${counter.count}</td>
	              <td>${book.title}</td>
	              <td>${book.price}</td>
	          <form action="MainController">
	              <td>
		<input type="submit" name="action" value="-">
		<input type="hidden" name="bookID" value="${book.bookID}">
		<input name="quantity" type="number" value="${book.quantity}" readonly="true">
		<input type="submit" name="action" value="+">
	              </td>
	          </form>
	          <td>${book.price * book.quantity}</td>
	          <form action="MainController">
	              <td>
		<input type="hidden" name="bookID" value="${book.bookID}">
		<input type="submit" name="action" value="Delete Book"/>
	              </td>
	          </form>
	          </tr>
	      </c:forEach>	     
	      </tbody>
                </table>
                <c:out value="${total} VNĐ"/>
                <c:url var="checkout" value="MainController">
	  <c:param name="action" value="Pay"></c:param>
	  <c:param name="total" value="${total}"></c:param>
	  <c:param name="userID" value="${sessionScope.USER.userID}"></c:param>
                </c:url>
                <a href="${checkout}">Check Out</a>
            </c:if>
        </c:if>
    </body>
</html>
