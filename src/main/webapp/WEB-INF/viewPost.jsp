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
    <h1>Viewing Post: <c:out value="${post.title}"/> by <c:out value="${post.createdBy.username}"/></h1>
    <a href="/dashboard">Home</a>
    <p><c:out value="${post.text}"/></p>
    <p>
    <c:if test="${post.createdBy.id != idInSession}">
        <a href="/post/${post.id}/like">Like</a>
    </c:if>
    | <c:out value="${post.likedBy.size()}"/> likes so far!</p>
    <form:form action="/post/${post.id}/addComment" method="Post" modelAttribute="comment">
        <form:label path="text">Add a comment...</form:label>
        <br>
        <form:textarea path="text" />
        <button>Submit</button>
    </form:form>
    <ul>
        <c:forEach var="oneComment" items="${post.comments}">
            <li><c:out value="${oneComment.text}" /> -<c:out value="${oneComment.user.username}"/></li>
        </c:forEach>
    </ul>
</body>
</html>