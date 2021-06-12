<%-- 
    Document   : user-home
    Created on : Apr 19, 2021, 6:38:36 PM
    Author     : seeminvasaikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <style>
        body{
            background-image: url('images/petbgp.jpeg');
            
            background-attachment: fixed;
  
            
        }
        a{
                padding: 5px;
            }
    </style>
    
<body>  
    <nav class="navbar navbar-light bg-light">
        <span class="navbar-brand mb-0 h1"><h3>Welcome to Pet Adoption Portal : ${sessionScope.user.getFirstname()} </h3></span>
  <a style="float: right; margin-right: 50px;" href="login.htm"">LOGOUT </a>
  <a href="add-category.htm">[Add Pet Category]</a>
    <a class="nav-item nav-link" href="add-petAd.htm">[Post New Pet Advertisement]</a>
    <a class="nav-item nav-link" href="view-ads.htm">[View All Advertisements]</a>
    <a class="nav-item nav-link" href="search-ad.htm">[Search Pet By Category]</a>
</nav>
        
<div class="d-flex justify-content-center">
<form method ="POST" action="login.htm">
    
    
</form>
</div>
</body>
</html>

  