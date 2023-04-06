<%@page import="com.entity.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	User auth = (User) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("CustomerIndex.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
	%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bumble Bee</title>
        <%@include file="all_css.jsp" %>
    </head>
    <body class="bg-light">
        <%@include file="navbar.jsp" %>
        
        <div class="container p-4">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                    <div class="card-body">
                        <p class="fs-3 text-center">Register User</p>
                        
                        <c:if test="${not empty succMsg}">
                            <p class="text-center text-success">${succMsg}</p>
                            <c:remove var="succMsg"/>
                        </c:if>
                         <c:if test="${not empty errorMsg}">
                            <p class="text-center text-success">${errorMsg}</p>
                            <c:remove var="succMsg"/>
                        </c:if>
                        <form action="uregister" method="post">
                            <div class="mb-3">
                            <label  class="form-label">Full Name</label>
                            <input type="text" name="fullName" class="form-control" >
                            </div>
                             <div class="mb-3">
                              <label  class="form-label">Email</label>
                              <input type="email" name="email" class="form-control" >
                            </div>
                            <div class="mb-3">
                              <label  class="form-label">Password</label>
                              <input type="password" name="password" class="form-control" >
                            </div>
                      
                          <button type="submit" class="btn btn-primary col-md-12">Submit</button>
                        </form>
                            <div class="text-center mt-3">
                                <a href="login.jsp">Already registered? Login here</a>
                            </div>
                      </div>  
                        
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
