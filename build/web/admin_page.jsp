<%-- 
    Document   : admin_page
    Created on : Jun 16, 2021, 7:56:10 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     
        <title>Admin Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER.roleID == 'ADM'}">
            <c:if test="${ not empty sessionScope.USER.roleID}">
                <c:if test="${sessionScope.USER.userName !=null}">
	  <c:if test="${not empty sessionScope.USER.userName}">
	      <h1>Welcome ${sessionScope.USER.userName}</h1>
	  </c:if>
                </c:if>
                <c:url var="logout" value="MainController">
	  <c:param name="action" value="Logout"> </c:param>
                </c:url>
	      <a href="${logout}">Logout</a><br/>
                <c:url var="insert" value="MainController">
	  <c:param name="action" value="Insert"> </c:param>
                </c:url>
                <a href="${insert}">Add New Book</a>
                <c:if test="${sessionScope.LIST_CATEGORY !=null}">
	  <c:if test="${not empty sessionScope.LIST_CATEGORY}">
	      <ul>
	          <li>Menu</li>
	              <c:forEach var="category" items="${sessionScope.LIST_CATEGORY}">
	              <li>
		<c:url var="Search" value="MainController">
		    <c:param name="action" value="Search"> </c:param>
		    <c:param name="cate" value="${category.cateName}"> </c:param>
		</c:url>
		<a href="${Search}">${category.cateName}</a>
	              </li>
	          </c:forEach>
	      </ul>
	  </c:if>
                </c:if>
                <c:if test="${requestScope.LIST_BOOK !=null}">
	  <c:if test="${not empty requestScope.LIST_BOOK}">
	      <table border="1">
	          <thead>
	              <tr>
		<th>No</th>
		<th>Book ID</th>
		<th>Title</th>
		<th>Image</th>
		<th>Description</th>
		<th>Price</th>
		<th>Author</th>
		<th>Category</th>
		<th>Quantity</th>
	              </tr>
	          </thead>
	          <tbody>
	              <c:forEach var="book" varStatus="counter" items="${requestScope.LIST_BOOK}">
	              <form action="MainController">
		<tr>
		    <td>${counter.count}</td>
		    <td>${book.bookID}</td>
		    <td>${book.title}</td>
		    <td>
		        <img src="${book.image}"  alt="Outside Book" width="125" height="250" > 
		    </td>
		    <td>
		        <img src="CSS/img/${book.image}"  alt="Outside Book" width="125" height="250" > 
		    </td>
		    <td>${book.description}</td>
		    <td>${book.price}</td>
		    <td>${book.author}</td>
		    <td>${book.cateID}</td>
		    <td>${book.quantity}</td>
		    <td>
		        <input type="hidden" name="bookID" value="${book.bookID}">
		        <input type="submit" name="action" value="Delete" onclick="return confirm('Are you sure you want to delete this item?');">
		    </td>
		    <td>
		        <input type="submit" name="action" value="Update"/>
		        <input type="hidden" name="bookID" value="${book.bookID}"/>
		    </td>
	              </form>
	          </tr>
	      </c:forEach>
	  </tbody>
                </table>
            </c:if>
        </c:if>
    </c:if>
</c:if>
</body>
</html>
