<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Posty. Yes, ANOTHER social media site.</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> 
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
   <h1 class="text-center">Welcome to Posty!</h1>
   <div class="container">
    <div class="row">
        <form:form action="/register" method="POST" modelAttribute="user" class="col-sm">
             <h3>Register Here</h3>
             <div>
                 <form:label path="username">Username:</form:label>
                 <form:input path="username" />
                 <form:errors path="username" />
             </div>
     
             <div>
                 <form:label path="email">Email:</form:label>
                 <form:input path="email" />
                 <form:errors path="email" />
             </div>
             <div>
                 <form:label path="password">Password:</form:label>
                 <form:input path="password" type="password"/>
                 <form:errors path="password" />
             </div>
             <div>
                 <form:label path="confirmPass">Confirm Password:</form:label>
                 <form:input path="confirmPass" type="password"/>
                 <form:errors path="confirmPass" />
             </div>
             <button>Submit</button>
         </form:form>
         <form:form action="/login" method="POST" modelAttribute="loginUser" class="col-sm">
            <h3>Login Here</h3> 
            <div>
                 <form:label path="email">Email:</form:label>
                 <form:input path="email" />
                 <form:errors path="email" />
             </div>
             <div>
                 <form:label path="password">Password:</form:label>
                 <form:input path="password" />
                 <form:errors path="password" />
             </div>
             <button>Submit</button>
         </form:form>
    </div>
   </div>
</body>
</html>