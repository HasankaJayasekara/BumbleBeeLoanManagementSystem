<%@page import="com.entity.*"%>
<%@page import="java.util.*"%>
<%@page import="com.dao.ProductDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>

	<%
        ProductDAO pd = new ProductDAO(DBConnect.getConn());
        List<Product> products = pd.getAllProducts();
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
	%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bumble Bee</title>
        <%@include file="all_css.jsp" %>
        <style>
	.row.mt-5 {
		background-color: #f7f7f7;
		padding: 40px;
	}
	.row.mt-5 h4 {
		font-weight: bold;
		color: #333;
		margin-bottom: 20px;
	}
	.row.mt-5 p {
		color: #666;
		font-size: 18px;
		margin-bottom: 30px;
	}
	.row.mt-5 a.btn-secondary {
		background-color: #ff5a5f;
		border-color: #ff5a5f;
	}
	.row.mt-5 a.btn-secondary:hover {
		background-color: #d9534f;
		border-color: #d43f3a;
	}
</style>
        
    </head>
    <body class="bg-light">
        
        <%@include file="cnavbar.jsp" %>

	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="product-image/<%=p.getImage() %>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="price">Price: Rs.<%=p.getPrice() %></h6>
						<h6 class="category">Category: <%=p.getCategory() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>">Add to Cart</a> <a
								class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no products");
			}
			%>
                        
                        </div>

	<!-- New div for interest-free payments -->
                    <div class="row mt-5">
                            <div class="col-md-12 text-center">
                                    <h4>Pay in 3 interest-free payments</h4>
                                    
                                    <a href="add_loan.jsp" class="btn btn-secondary">Apply Loan</a>
                            </div>
                    </div>

		</div>
	</div>
</body>
</html>