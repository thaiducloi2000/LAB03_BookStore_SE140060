<%-- 
    Document   : shopping
    Created on : Jun 16, 2021, 7:55:59 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="keywords" content="" />
            <meta name="description" content="" />
            <link rel="stylesheet" href="CSS/css/main.css" type="text/css"/>
            <title>Shopping Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER.userName !=null}">
            <c:if test="${not empty sessionScope.USER.userName}">
                <h1>Welcome ${sessionScope.USER.userName}</h1>
                <div id="templatemo_container">
	  <div id="templatemo_menu">
	      <ul>
	          <li>
	              <c:url var="logout" value="MainController">
		<c:param name="action" value="Logout"> </c:param>
	              </c:url>
	              <a href="${logout}">Logout</a>
	          </li>
	          <li>
	              <a href="view_cart.jsp">View Cart</a>
	          </li>
	          <li>
	              <c:url var="view_history" value="MainController">
		<c:param name="action" value="view history"></c:param>
		<c:param name="userID" value="${sessionScope.USER.userID}"></c:param>
	              </c:url>
	              <a href="${view_history}">View history shopping</a>
	          </li>
	      </ul>
	  </div>
                </div>
            </c:if>
        </c:if>
        <c:if test="${sessionScope.USER.userName ==null}">
            <c:if test="${empty sessionScope.USER.userName}">
                <div id="templatemo_container">
	  <div id="templatemo_menu">
	      <ul>
	          <li><a href="login.jsp">Login</a></li>
	      </ul>
	  </div>
                </div>
            </c:if>
        </c:if>
        <c:if test="${sessionScope.LIST_CATEGORY !=null}">
            <c:if test="${not empty sessionScope.LIST_CATEGORY}">
                <div id="templatemo_content">
	  <div id="templatemo_content_left">
	      <div class="templatemo_content_left_section">
	          <h1>Categories</h1>
	          <ul>	      
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
	      </div>
	  </div>
                </div>
            </c:if>
        </c:if>
        <c:if test="${requestScope.LIST_BOOK !=null}">
            <c:if test="${not empty requestScope.LIST_BOOK}">
                <c:forEach var="book" varStatus="counter" items="${requestScope.LIST_BOOK}">
	  <div id="templatemo_content_right">
	      <div class="templatemo_product_box">
	          <h1>${book.title}</h1>
	          <img src="CSS/img/${book.image}" alt="image" width="125" height="250"/>
	          <div class="product_info">
	              <p></p>
	              <h3>${book.price} VNĐ</h3>
	              <div class="buy_now_button">
		<c:url var="viewBook" value="MainController">
		    <c:param name="action" value="ViewBook"></c:param>
		    <c:param name="bookID" value="${book.bookID}"></c:param>
		</c:url>
		<a href="${viewBook}">Buy Now</a>
	              </div>
	              <div class="detail_button">
		<c:url var="viewBook" value="MainController">
		    <c:param name="action" value="ViewBook"></c:param>
		    <c:param name="bookID" value="${book.bookID}"></c:param>
		</c:url>
		<a href="${viewBook}">Detail</a>
	              </div>
	          </div>
	          <div class="cleaner">&nbsp;</div>
	      </div>
	            
	      <div class="cleaner_with_width">&nbsp;</div>
	      
	  </c:forEach>
                </c:if>
            </c:if>
    </body>
</html>
