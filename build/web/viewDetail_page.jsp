<%-- 
    Document   : viewDetail_page
    Created on : Jun 30, 2021, 12:28:31 PM
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
            <title>JSP Page</title>
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
        <c:if test="${requestScope.BOOK !=null}">
            <c:if test="${not empty requestScope.BOOK }">               
                <div id="templatemo_content_right">

	  <h1>${requestScope.BOOK.title}</span></h1>
	  <div class="image_panel"><img src="CSS/img/${requestScope.BOOK.image}" alt="CSS Template" width="100" height="150" /></div>
	  <h2>Read the lessons - Watch the videos - Do the exercises</h2>
	  <ul>
	      <li>By ${requestScope.BOOK.author}</li>
	      <li>January 2024</li>
	      <li>${requestScope.BOOK.bookID}</li>
	  </ul>

	  <p>Description : ${requestScope.BOOK.description} <br/>
	      <c:url var="addToCart" value="MainController">
	          <c:param name="action" value="Add To Cart"></c:param>
	          <c:param name="bookID" value="${requestScope.BOOK.bookID}"></c:param>
	      </c:url>
	      <a href="${addToCart}">Add To Cart</a>
	  </p>

	  <div class="cleaner_with_height">&nbsp;</div>
                </div>
            </c:if>
        </c:if>
    </body>
</html>
