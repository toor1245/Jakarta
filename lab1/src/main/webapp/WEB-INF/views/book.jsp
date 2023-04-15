<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Items List</title>
</head>
<body>
<h1>Books</h1>

<form action="findByAuthor" method="POST">
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" required><br><br>
    <button type="submit">Search</button>
</form>

<form action="findByKeyword" method="POST">
    <label for="keyword">Keyword:</label>
    <input type="text" id="keyword" name="keyword" required><br><br>
    <button type="submit">Search</button>
</form>

<form action="findByTitle" method="POST">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>
    <button type="submit">Search</button>
</form>

<jsp:useBean id="books" scope="request" type="java.util.ArrayList<com.example.lab1.view_models.BookViewModel>"/>

<c:if test="${books.size() > 0}">
    <c:forEach var="book" items="${books}">
        <ul>${book._title}, ${book._author._fullName}</ul>
    </c:forEach>
</c:if>
</body>
</html>