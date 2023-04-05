
<%@page import="com.entity.Customer"%>
<%@page import="com.dao.CustomerDAO"%>
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
                        <p class="fs-3 text-center">Edit Customer</p>
                        
                        <%
                        int id=Integer.parseInt(request.getParameter("id"));
                        CustomerDAO dao = new CustomerDAO(DBConnect.getConn());
                        Customer s=dao.getCustomerById(id);
                        %>
                        <form action="update" method="post">
                            <div class="mb-3">
                            <label  class="form-label">Full Name</label>
                            <input type="text" value="<%=s.getFullName()%>" name="name" class="form-control" >
                            </div>
                           <div class="mb-3">
                            <label  class="form-label">Date of Birth</label>
                            <input type="date" value="<%=s.getDob()%>" name="dob" class="form-control" >
                            </div>
                            <div class="mb-3">
                              <label  class="form-label">Address</label>
                              <input type="text" value="<%=s.getAddress()%>" name="address" class="form-control" >
                            </div>
                             <div class="mb-3">
                              <label  class="form-label">Phone Number</label>
                              <input type="text" value="<%=s.getPhonenumber()%>" name="phonenumber" class="form-control" >
                            </div>
                             <div class="mb-3">
                              <label  class="form-label">Email</label>
                              <input type="email" value="<%=s.getEmail()%>" name="email" class="form-control" >
                            </div>
                              <div class="mb-3">
                              <label  class="form-label">Password</label>
                              <input type="password" value="<%=s.getPassword()%>" name="password" class="form-control" >
                            </div>
                           <input type="hidden" name="id" value="<%=s.getId()%>">
                          <button type="submit" class="btn btn-primary col-md-12">Update</button>
                        </form>
                          
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
