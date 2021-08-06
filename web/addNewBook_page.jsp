<%-- 
    Document   : addNewBook_page
    Created on : Jun 26, 2021, 7:18:41 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book Page</title>
    </head>
    <body>
        <form action="ADDController" enctype="multipart/form-data" method="POST">
            Title : <input type="text" name="title" value=""><br/>
            Image : <input type="file" name="image" value=""><br/>
            Description : <input type="text" name="description" value=""><br/>
            Price : <input type="text" name="price" value=""><br/>
            Author : <input type="text" name="author" value="" ><br/>
            Category : 
            <select name="cate" value="${param.cate}">
                <option>${requestScope.BOOK.cateID}</option>
                <c:forEach var="category" items="${sessionScope.LIST_CATEGORY}">
	  <option>
	      ${category.cateName}
	  </option>
                </c:forEach>
            </select><br/>
            Quantity : <input type="text" name="quantity" value=""><br/>
            <input type="submit" name="action" value="ADD"/>
        </form>
    </body>
</html>
