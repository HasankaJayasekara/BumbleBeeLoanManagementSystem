
<%@page import="java.util.List"%>
<%@page import="com.entity.Customer"%>
<%@page import="com.dao.CustomerDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
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
       
        <div class ="container p-3">
         <div class="card">
         <div class="card-body">
             <a href="add_customer.jsp" class="btn btn-primary">Add Customer</a>
            <p class="text-center fs-1">All Customer Details</p>
             <c:if test="${not empty succMsg}">
             <p class="text-center text-success">${succMsg}</p>
            <c:remove var="succMsg"/>
            </c:if>
            <c:if test="${not empty errorMsg}">
            <p class="text-center text-success">${errorMsg}</p>
            <c:remove var="errorMsg"/>
            </c:if>
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">Full Name</th>
                  <th scope="col">DOB</th>
                  <th scope="col">Address</th>
                  <th scope="col">Phone Number</th>
                  <th scope="col">Email</th>
                  <th scope="col">Password</th>
                  <th scope="col">Action</th>
                  
                </tr>
              </thead>
              <tbody>
                  <%
                   CustomerDAO dao = new CustomerDAO(DBConnect.getConn());
                   List<Customer> list= dao.getAllCustomer();
                   for(Customer s : list){
                   %>
                   <tr>
                  <th scope="row"><%=s.getFullName()%></th>
                  <td><%=s.getDob()%></td>
                  <td><%=s.getAddress()%></td>
                  <td><%=s.getPhonenumber()%></td>
                  <td><%=s.getEmail() %></td>
                  <td><%=s.getPassword() %></td>
                  
                  <td><a href="edit_customer.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-primary">Edit</a>
                      <a href="delete?id=<%=s.getId()%>" class="btn btn-sm btn-danger ms-1">Delete</a></td>
                </tr>
                   <%
                       }
                    %>
               
              </tbody>
            </table>
        </div>
        </div>
        </div>
    </body>
</html>
