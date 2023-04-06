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
  .badge-danger {
    background-color: red;
    font-size: 0.8em;
  }
  .ml-auto {
    margin-left: auto !important;
  }
</style>

<nav class="navbar navbar-expand-lg navbar-light bg-blue">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Bumble Bee</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item"><a class="nav-link" href="CustomerIndex.jsp">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart <span class="badge badge-danger">${cart_list.size()}</span></a></li>
        <% if (auth != null) { %>
          <li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
          <li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>
        <% } else { %>
          <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
        <% } %>
      </ul>
    </div>
  </div>
</nav>