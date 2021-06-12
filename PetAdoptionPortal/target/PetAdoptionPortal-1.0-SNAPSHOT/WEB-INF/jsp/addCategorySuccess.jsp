

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category created successfully</title>
    </head>
    <body>
    <nav class="navbar navbar-light bg-light">
  <span class="navbar-brand mb-0 h1">Pet Adoption Portal </span>
  <a style="float: right; margin-right: 50px;" href="homepage-redirect.htm"">HOME</a>
</nav>
        New Category Created Successfully: 
        </br> 
        ${requestScope.category.category_name}
        
    </body>
</html>
