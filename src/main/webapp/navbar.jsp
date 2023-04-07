<style>
  .navbar-brand {
    font-size: 2em;
    color: #DDA0DD!important;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-weight: bold;
  }
  .navbar {
    background-color: #E6E6FA;
  }
  .navbar-nav .nav-link {
    color: #9370DB;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }
</style>

<nav class="navbar navbar-expand-lg navbar-light bg-blue">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Bumble Bee</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user.jsp">User</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="loan.jsp">Loan</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="product.jsp">Product</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="category.jsp">Category</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/adminlogout">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

