<%@page import="com.entity.User"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <p class="fs-3 text-center">Edit User</p>
                        
                        <%
                        int id=Integer.parseInt(request.getParameter("id"));
                        UserDAO dao = new UserDAO(DBConnect.getConn());
                        User u=dao.getUserById(id);
                        %>
                        <form action="uupdate" method="post">
                            <div class="mb-3">
                            <label  class="form-label">Full Name</label>
                            <input type="text" value="<%=u.getFullName()%>" name="fullName" class="form-control" >
                            </div>
                             <div class="mb-3">
                              <label  class="form-label">Email</label>
                              <input type="email" value="<%=u.getEmail()%>" name="email" class="form-control" >
                            </div>
                              <div class="mb-3">
                              <label  class="form-label">Password</label>
                              <input type="password" value="<%=u.getPassword()%>" name="password" class="form-control" >
                            </div>
                           <input type="hidden" name="id" value="<%=u.getId()%>">
                          <button type="submit" class="btn btn-primary col-md-12">Update</button>
                        </form>
                          
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>