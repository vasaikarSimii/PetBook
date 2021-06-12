<%-- 
    Document   : regiter-user
    Created on : Apr 18, 2021, 8:29:30 PM
    Author     : seeminvasaikar
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <title>User Registration</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
  <span class="navbar-brand mb-0 h1">Pet Adoption Portal </span>
  <a style="float: right; margin-right: 50px;" href="login.htm"">LOGIN</a>
</nav>
        <h6 style="color: red; margin: 10px">${error}</h6>
        
        <div class="d-flex justify-content-center" style="margin-top: 2%">
         
                <form method="POST" name="registerForm" action="registeruser.htm">
                    <h4 style="text-decoration: underline overline;margin-left: 35px">USER REGISTRATION</h4>
                <div class="form-group">
                  <label for="firstname">First Name</label>
                  <input type="text" name="firstname" class="form-control" id="firstname" maxlength="50" minlength="3" placeholder="Enter First Name" value="${firstname}" required/>
                </div>
                    
                <div class="form-group">
                  <label for="lastname">Last Name</label>
                  <input type="text" name="lastname" class="form-control" id="lastname" placeholder="Enter Last Name" maxlength="50" minlength="3" value="${lastname}" required/>
                </div>
                    
                Gender<br>
                <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="F" value="F"/>
                <label class="form-check-label" for="F">Female</label>
              </div>
                <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="M" value="M"/>
                <label class="form-check-label" for="M">Male</label>
              </div>
                <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="O" value="O"/>
                <label class="form-check-label" for="O">Other</label>
              </div>
      
                <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="N" value="N"/>
                <label class="form-check-label" for="N">Choose not to Disclose</label>
              </div>
                <br><br>
                <div class="form-group">
                <label for="address">Enter Age</label>
                <input type="age" class="form-control" id="age" rows="5" cols="25" placeholder="Enter Age" maxlength="100" name="age" value="${age}" required/>
                </div>
                
                <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" maxlength="30" id="email" placeholder="Enter Email" name="email" value="${email}" required/>
              </div>
                
                
                <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="phone" class="form-control" id="phone" maxlength="20" placeholder="Enter Phone" name="phone" value="${phone}" required/>
              </div>
                
                <div class="form-group">
                  <label for="username">Username</label>
                  <input type="text" name="username" class="form-control" id="username" placeholder="Enter Username" value="${username}" minlength="5" maxlength="10" required/>
                </div>
                
                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" name="password" class="form-control" id="password" placeholder="Enter Password" value="${password}" minlength="6" maxlength="10" required/>
                </div>

                <input type="hidden" name="option" value="register"/>
                <input type="submit" value="Register" class="btn btn-primary mb-2"/>
            </form>
        </div>
    </body>
</html>
