<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quests</title>
</head>
<body>
<h1>Quest World</h1>
<h3>Hello! You'll be able to find here a lot of quests in the future</h3>


<form action ="quest" method="post">
<label for="name">Enter your name:</label>
<input type="text" id="name" name="name" placeholder="Name" required>
<input type="submit" value="Start the story">
</form>
</body>
</html>