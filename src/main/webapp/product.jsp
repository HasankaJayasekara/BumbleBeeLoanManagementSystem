
<%@page import="java.util.List"%>
<%@page import="com.entity.Product"%>
<%@page import="com.dao.ProductDAO"%>
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
             <a href="add_product.jsp" class="btn btn-primary">Add Product</a>
            <p class="text-center fs-1">All Product Details</p>
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
                  <th scope="col">Product Name</th>
                  <th scope="col">Category</th>
                  <th scope="col">Price</th>
                  <th scope="col">Image</th>
                  <th scope="col">Action</th>
                  
                </tr>
              </thead>
              <tbody>
                  <%
                   ProductDAO dao = new ProductDAO(DBConnect.getConn());
                   List<Product> list= dao.getAllProducts();
                   for(Product p : list){
                   %>
                   <tr>
                  <th scope="row"><%=p.getName()%></th>
                  <td><%=p.getCategory()%></td>
                  <td><%=p.getPrice()%></td>
                  <td><img src="<%=p.getImage()%>" alt="<%=p.getName()%>" width="50px" height="50px" /></td>
                  
                  <td><a href="edit_product.jsp?id=<%=p.getId()%>" class="btn btn-sm btn-primary">Edit</a>
                      <a href="pdelete?id=<%=p.getId()%>" class="btn btn-sm btn-danger ms-1">Delete</a></td>
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
