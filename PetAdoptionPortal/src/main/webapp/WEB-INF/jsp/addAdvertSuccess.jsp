<%-- 
    Document   : AddAdvertSuccess
    Created on : Apr 15, 2021, 4:39:06 PM
    Author     : dedhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
  <span class="navbar-brand mb-0 h1">Add New Pet Category </span>
  <a style="float: right; margin-right: 50px;" href="homepage-redirect.htm"">HOME</a>
</nav>
        Advert Posted Successfully: ${petAdvertisement.category}<br>
        Posted by: ${petAdvertisement.postedBy}<br><!-- comment -->
        
    </body>
</html>
