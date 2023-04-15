<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="update" method="POST">
  <input type="hidden" name="id" value="${id}">
  <label for="title">Title:</label>
  <input type="text" id="title" name="title" value="${title}" required><br><br>
  <label for="author">Author:</label>
  <input type="text" id="author" name="author" value="${author}" required><br><br>
  <button type="submit">Update</button>
</form>

<li><a href="manage">Back</a></li>

</body>
</html>
