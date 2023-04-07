<%@page import="java.util.List"%>
<%@page import="com.entity.Category"%>
<%@page import="com.dao.CategoryDAO"%>
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
             <a href="add_category.jsp" class="btn btn-primary">Add Category</a>
            <p class="text-center fs-1">All Category Details</p>
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
                  <th scope="col">Category Name</th>
                  <th scope="col">Category Description</th>
                  <th scope="col">Action</th>
                  
                </tr>
              </thead>
              <tbody>
                  <%
                   CategoryDAO dao = new CategoryDAO(DBConnect.getConn());
                   List<Category> list= dao.getAllCategory();
                   for(Category s : list){
                   %>
                   <tr>
                  <th scope="row"><%=s.getCategoryName()%></th>
                  <td><%=s.getDescription()%></td>
                  <td><a href="edit_category.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-primary">Edit</a>
                      <a href="cdelete?id=<%=s.getId()%>" class="btn btn-sm btn-danger ms-1">Delete</a></td>
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
