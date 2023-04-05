<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" integrity="sha384-..." crossorigin="anonymous">
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
</nav>
</head>

<body>
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h4>Login</h4>
                        <c:if test="${not empty error}">
                            <p class="text-center" style="color: red">${error}</p>
                            <c:remove var="error"/>
                        </c:if>
                    </div>
                    <div class="card-body">
                        <form action="login" method="post">
                            <div class="mb-3">
                                <label for="email" class="form-label">Email address</label>
                                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required>
                                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <div class="text-center mt-3">
                                <a href="add_customer.jsp">Not registered? Sign up here</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-..." crossorigin="anonymous"></script>
</body>
</html>
