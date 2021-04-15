<%-- 
    Document   : login
    Created on : Apr 15, 2021, 1:56:38 PM
    Author     : Seemin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>

<head>
  <link rel="stylesheet" href="css/style.css">
  <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
  <title>Login to Pet Adoption Portal</title>
</head>

<body>
  <div class="main">
    <p class="sign" align="center">Login</p>
    <form class="form1" method="POST" action="login.htm">
              Select Role <br>
                 <div class=" form-check-inline">
                     <input class="form-check-input" type="radio" name="role" id="approver" value="approver" minlength="4"/>
                <label class="form-check-label" for="approver">ApproverAdmin</label>
              </div>
                
                 <div class="form-check-inline">
  <input class="form-check-input" type="radio" name="role" id="user" value="user"/>
  <label class="form-check-label" for="user">User</label>
</div><br><br>
      <input name ="username" id ="username" type="text" align="center" placeholder="Username" required>
      <input name="password" id ="password" type="password" align="center" placeholder="Password" required>
      <a class="submit" align="center">Login</a>
      <a href="redirect-register-user.htm">Don't have an account? Register</a>
            
                
    
     </form>
    </div>
</body>

</html>



