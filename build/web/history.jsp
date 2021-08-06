<%-- 
    Document   : history
    Created on : Jun 30, 2021, 4:31:22 PM
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
        <c:if test="${sessionScope.LIST_HISTORY !=null}">
            <c:if test="${not empty sessionScope.LIST_HISTORY}">
                <form action="SearchOrderDay">
	  <input type="date" name="orderDate" value="">
	  <input type="hidden" name="userID" value="${sessionScope.USER.userID}"
                </form>
                <table border="1">
	  <thead>
	      <tr>
	          <th>No</th>
	          <th>Order ID</th>
	          <th>Order Day</th>
	          <th>Total</th>
	      </tr>
	  </thead>
	  <tbody>
	      <c:forEach var="order" varStatus="counter" items="${sessionScope.LIST_HISTORY}">
	          <tr>
	              <td>${counter.count}</td>
	              <td>${order.orderID}</td>
	              <td>
		${order.orderDate}		
	              </td>
	              <td>
		${order.total}
	              </td>
	          </tr>
	      </c:forEach>
	  </tbody>
                </table>

            </c:if>
        </c:if>
        <a href="shopping.jsp"> Back </a>
    </body>
</html>
