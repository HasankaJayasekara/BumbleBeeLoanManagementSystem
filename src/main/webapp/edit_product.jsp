<%@page import="com.entity.Product"%>
<%@page import="com.dao.ProductDAO"%>
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
                        <p class="fs-3 text-center">Edit Product</p>
                        
                        <%
                        int id=Integer.parseInt(request.getParameter("id"));
                        ProductDAO dao = new ProductDAO(DBConnect.getConn());
                        Product p=dao.getSingleProduct(id);
                        %>
                       <form action="pupdate" method="post" enctype="multipart/form-data">
                            <div class="mb-3">
                              <label class="form-label">Product Image</label>
                              <input type="file" name="image" class="form-control">
                            </div>
                            <div class="mb-3">
                              <img class="card-img-top" src="product-image/<%=p.getImage() %>" alt="Card image cap">
                            </div>
                            <div class="mb-3">
                              <label class="form-label">Product Name</label>
                              <input type="text" value="<%=p.getName()%>" name="productName" class="form-control">
                            </div>
                            <div class="mb-3">
                              <label class="form-label">Price</label>
                              <input type="number" value="<%=p.getPrice()%>" name="price" class="form-control">
                            </div>
                            <div class="mb-3">
                              <label class="form-label">Category</label>
                              <input type="text" value="<%=p.getCategory()%>" name="category" class="form-control">
                            </div>
                            <input type="hidden" name="id" value="<%=p.getId()%>">
                            <button type="submit" class="btn btn-primary col-md-12">Update</button>
                         </form>
                          
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
