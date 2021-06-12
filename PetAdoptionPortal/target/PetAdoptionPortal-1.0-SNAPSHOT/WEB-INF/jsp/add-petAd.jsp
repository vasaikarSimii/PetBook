<%-- 
    Document   : add-petAd
    Created on : Apr 20, 2021, 10:45:03 PM
    Author     : seeminvasaikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <title>Post Advertisement</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
  <span class="navbar-brand mb-0 h1">Create New Pet Advertisement Post </span>
  <a style="float: right; margin-right: 50px;" href="homepage-redirect.htm"">HOME</a>
</nav>
        <h6 style="color: red; margin: 10px">${error}</h6>
        
        <div class="d-flex justify-content-center" style="margin-top: 2%">
               
             <form:form modelAttribute="petAdvertisement" method="POST" enctype="multipart/form-data">
                 <div class="form-group">
                  <label for="user">Pet Owner: </label>
                  <input path="user" value = "${sessionScope.user.getFirstname()}" readonly />
                </div>
                 <div class="form-group">
                     <label for="category">Select Pet Category: </label>
                     <form:select path="category">
                            <c:forEach var="categ" items="${requestScope.categories}">
                                        <form:option value="${categ.category_name}"/>
                            </c:forEach>
                        </form:select>
                 </div>
                
                 <div class="form-group">
                  <label for="postedBy">Ad Poster By: </label>
                  <form:input path="postedBy" placeholder="Enter username" required="required" ></form:input>
                </div> 
                <div class="form-group">
                    <label for="petpic">Pet Photo: </label>
                    File to upload: <input type="file" name="petpic"><br/>
                    <input type="submit" value="Press"> to upload the file!
                </div>
                
                
                 <div class="form-group">
                  <label for="petname">Pet Name: </label>
                  <form:input path="petname" placeholder="Enter Pet Name" required="required" ></form:input>
                </div>  
                
                <div class="form-group">
                  <label for="petage">Pet Age: </label>
                  <form:input class="form-control" path="petage" placeholder="Enter Pet Age" required="required"/>
                </div>
                <div>
                    <label for="petgender">Pet Gender: </label>
                    <form:radiobutton path="petgender" value="M"/>Male
                    <form:radiobutton path="petgender" value="F"/>Female
                </div>
               
             
                <div class="form-group">
                    <label for="numberofvaccines">Number of Vaccines Taken by the pet: </label>
                    <form:input  class="form-control" maxlength="30" path="numberofvaccines" placeholder="Enter Number of Vaccines" required="required" />             
              </div>
                <div class="form-group">
                    <label for="petvetname">Pet Vet Name: </label>
                    <form:input  class="form-control" path="petvetname" maxlength="20" placeholder="Enter Pet Vet Name" required="required" />
              </div>
                
                <div class="form-group">
                    <label for="levelofactiveness">Level Of Activeness on a Scale of 1-10: </label>
                    <form:input class="form-control" path="levelofactiveness" placeholder="Enter a number from 1-10" required="required" />
                </div>
                <div class="form-group">
                    <label for="microchip">Microchip Installed? </label>
                  <form:input class="form-control" path="microchip" placeholder="Enter Yes or No"  required="required" />
                </div>
                <input type="hidden" name="option" value="addpetAd"/>
                <input type="submit" value="Post Advertisement" class="btn btn-primary mb-2"/>
            </div>
             </form:form>
        
    </body>
</html>
