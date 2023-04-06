<%@page import="com.entity.Cart"%>
<%@ page import="com.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
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
<meta charset="UTF-8">
<title>Login Page</title>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bumble Bee</title>
        <%@include file="all_css.jsp" %>
        
    </head>
    <body class="bg-light">
        
        <%@include file="cnavbar.jsp" %>
</head>

<body>
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h4>Login</h4>
                        <c:if test="${not empty error}">
                            <p class="text-center" style="color: red">${error}</p>
                            <c:remove var="error"/>
                        </c:if>
                    </div>
                    <div class="card-body">
                        <form action="user-login" method="post">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email address</label>
                                <input type="email" name="login-email" class="form-control" placeholder="Enter email">
                            
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" name="login-password" class="form-control" placeholder="Password">
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                            <div class="text-center mt-3">
                                <a href="UserRegistation.jsp">Not registered? Sign up here</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-..." crossorigin="anonymous"></script>
</body>
</html>
