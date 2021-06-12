<%-- 
    Document   : add-category
    Created on : Apr 21, 2021, 1:35:19 PM
    Author     : seeminvasaikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <title>JSP Page</title>
    </head>
    <body>
         <nav class="navbar navbar-light bg-light">
  <span class="navbar-brand mb-0 h1">Add New Pet Category </span>
  <a style="float: right; margin-right: 50px;" href="homepage-redirect.htm"">HOME</a>
</nav>
        
            <h6 style="color: red; margin: 10px">${error}</h6>
        
        <div class="d-flex justify-content-center" style="margin-top: 2%">
         
        
            <form:form modelAttribute="category">
               <div class="form-group">
                    <label for="category_name">Category Name: </label>
                   <form:input path="category_name" size="30" /> <font color="red"><form:errors path="category_name"/>
                </div>
                
                <input type="submit" value="Create Category" class="btn btn-primary mb-2"/>
            </div>
                      
            </form:form>
        </div>
    </body>
</html>
