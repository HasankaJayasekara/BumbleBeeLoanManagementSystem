
<%@page import="com.entity.Category"%>
<%@page import="com.dao.CategoryDAO"%>
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
                        <p class="fs-3 text-center">Edit Category Details</p>
                        
                        <%
                        int id=Integer.parseInt(request.getParameter("id"));
                        CategoryDAO dao = new CategoryDAO(DBConnect.getConn());
                        Category s=dao.getCategoryById(id);
                        %>
                        <form action="cupdate" method="post">
                            <div class="mb-3">
                            <label  class="form-label">Category Name</label>
                            <input type="text" value="<%=s.getCategoryName()%>" name="name" class="form-control" >
                            </div>
                           <div class="mb-3">
                            <label  class="form-label">Description</label>
                            <input type="text" value="<%=s.getDescription()%>" name="description" class="form-control" >
                            </div>
                           <input type="hidden" name="id" value="<%=s.getId()%>">
                          <button type="submit" class="btn btn-primary col-md-12">Edit</button>
                        </form>
                          
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
