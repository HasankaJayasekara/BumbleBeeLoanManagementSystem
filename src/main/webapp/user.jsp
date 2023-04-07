
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.UserDAO"%>
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
        <p class="text-center fs-1">All User Details</p>
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
              <th scope="col">Date Of Birth</th>
              <th scope="col">Email</th>
              <th scope="col">Password</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
              <%
               UserDAO dao = new UserDAO(DBConnect.getConn());
               List<User> list= dao.getAllUser();
               for(User u : list){
               %>
               <tr>
              <th scope="row"><%=u.getFullName()%></th>
              <td><%=u.getDateOfBirth() %></td>
              <td><%=u.getEmail() %></td>
              <td><%=u.getPassword() %></td>
              
              <td><a href="edit_user.jsp?id=<%=u.getId()%>" class="btn btn-sm btn-primary">Edit</a>
                  <a href="udelete?id=<%=u.getId()%>" class="btn btn-sm btn-danger ms-1">Delete</a></td>
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