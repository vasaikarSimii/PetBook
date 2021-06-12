<%-- 
    Document   : login
    Created on : Apr 18, 2021, 8:26:20 PM
    Author     : seeminvasaikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <title>Login</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
  <span class="navbar-brand mb-0 h1">Pet Adoption Portal</span>
</nav>
        <h5 style="color: blue; margin: 6px">${error}</h5>
        <div class="d-flex justify-content-center" style="margin-top: 40px">
            
            <form method="POST" action="login.htm">
                <h4 style="text-decoration: underline overline;margin-left: 100px">LOGIN</h4><br>
                
                Select Role <br>
                <div class="form-check form-check-inline" required>
                <input class="form-check-input" type="radio" name="role" id="admin" value="admin"/>
                <label class="form-check-label" for="admin">Admin</label>
              </div>
                 <div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="role" id="user" value="user"/>
  <label class="form-check-label" for="user">User</label>
</div><br><br>
                
                <div class="form-group">
                  <label for="username">Username</label>
                  <input type="text" name="username" class="form-control" id="username" placeholder="Enter Username" required/>
                </div>
                
                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" name="password" class="form-control" id="password" placeholder="Enter Password" required/>
                </div>
                <input type="hidden" name="option" value="login"/>
                <input type="submit" value="Login" class="btn btn-primary mb-2"/>
                <br><br>
                <a href="registeruser.htm">Don't have an account? Register</a>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
    </body>
</html>
