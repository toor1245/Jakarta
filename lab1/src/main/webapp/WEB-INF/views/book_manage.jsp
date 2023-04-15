<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Items List</title>
</head>
<body>
<form action="create" method="POST">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" required><br><br>
    <button type="submit">Add Item</button>
</form>

<jsp:useBean id="books" scope="request" type="java.util.ArrayList<com.example.lab1.view_models.BookViewModel>"/>
<c:choose>
    <c:when test="${books.size() > 0}">
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Remove</th>
                    <th>Edit</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book._id}</td>
                        <td>${book._title}</td>
                        <td>
                            <form method="post" action="delete">
                                <input type="hidden" name="id" value="${book._id}">
                                <button type="submit">Delete</button>
                            </form>
                        </td>
                        <td>
                            <form method="post" action="viewUpdate">
                                <input type="hidden" name="id" value="${book._id}">
                                <button type="submit">Edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        <p>No available books</p>
    </c:otherwise>
</c:choose>
</body>
</html>
