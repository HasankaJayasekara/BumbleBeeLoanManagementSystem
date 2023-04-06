
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
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
