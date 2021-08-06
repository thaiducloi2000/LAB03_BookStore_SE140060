<%-- 
    Document   : update_page
    Created on : Jun 25, 2021, 9:11:11 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Book Page</title>
    </head>
    <body>
        <form action="MainController">
            Book ID : <input type="text" name="bookID" value="${requestScope.BOOK.bookID}" readonly="true"> <br/>
            Title : <input type="text" name="title" value="${requestScope.BOOK.title}"><br/>
            Price : <input type="text" name="price" value="${requestScope.BOOK.price}"><br/>
            Author : <input type="text" name="author" value="${requestScope.BOOK.author}" ><br/>
            Category : 
            <select name="cate" value="${param.cate}">
                <option>${requestScope.BOOK.cateID}</option>
                <c:forEach var="category" items="${sessionScope.LIST_CATEGORY}">
	  <option>
	      ${category.cateName}
	  </option>
                </c:forEach>
            </select><br/>
            Quantity : <input type="text" name="quantity" value="${requestScope.BOOK.quantity}"><br/>
            <input type="submit" name="action" value="Confirm"/>
        </form>
        <a href="admin_page.jsp">Back</a>
    </body>
</html>
