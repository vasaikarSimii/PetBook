<%-- 
    Document   : view-ads
    Created on : Apr 21, 2021, 7:34:23 PM
    Author     : seeminvasaikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <span class="navbar-brand mb-0 h1">Add new Pet Category </span>
  <a style="float: right; margin-right: 50px;" href="homepage-redirect.htm"">HOME</a>
</nav>
        <h6 style="color: red; margin: 10px">${error}</h6>
        
        <div class="d-flex justify-content-center" style="margin-top: 2%">
                
            
                <h4 style="text-decoration: underline overline;margin-left: 50px; margin-right: 50px">PET ADOPTION ADVERTISEMENT FEED </h4>
                <form action="view-ads.htm"> 
                <div class ="row">
                   
                <c:forEach var="adv" items="${requestScope.petadv}">
                    <div class ="card">
                        <div class ="card-body">
                            <label for="category"> Pet Category: </label>
                            <h4 class="card-title" path ="category"><c:out value ="${adv.category}"/> </h4>
                            <label for="petage"> Pet Age: </label>
                            <p class="card-text" path ="petage"><c:out value ="${adv.petage}"/></p>
                     </div>   
                    </div>
                            <div class="form-group">
                     <label for="category">Select Pet Category: </label>
                     <form:select path="category">
                            <c:forEach var="categ" items="${requestScope.categories}">
                                        <form:option value="${categ.category_name}"/>
                            </c:forEach>
                        </form:select>
                 </div>
                
                
                       
                
            </c:forEach>
                </div>
                
                </form>      
                
    </body>
</html>
