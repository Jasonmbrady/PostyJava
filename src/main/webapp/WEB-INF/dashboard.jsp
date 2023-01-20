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
    <h1>Welcome to Posty <c:out value="${user.username}" />!</h1>
    <a href="/logout">Log Out</a>
    <form:form action="/post/new" method="POST" modelAttribute="post">
        <div>
            <form:label path="title">Title:</form:label>
            <form:input path="title" />
            <form:errors path="title" />
        </div>
        <div>
            <form:textarea path="text" />
        </div>
        <button>Submit</button>
    </form:form>
    <div class="container">
        <div class="row">
            <ul class="col-sm">
                <h3>Your posts:</h3>
                <c:forEach var="post" items="${user.posts}">
                    <li><c:out value="${post.title}" /></li>
                </c:forEach>
            </ul>
            <ul class="col-sm">
                <h3>All posts:</h3>
                <c:forEach var="post" items="${allPosts}">
                    <li> <a href="/post/${post.id}"><c:out value="${post.title}" /></a>  <c:if test="${post.createdBy.id != idInSession}"><a href="post/${post.id}/like">Like</a></c:if> | <c:out value="${post.likedBy.size()}"/> likes so far!</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>