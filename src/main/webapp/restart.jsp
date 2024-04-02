<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quests</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<h1>Game Over</h1>
<h2>${invalidStory}</h2>
<form action="restart" method="post">
    <input type="hidden" name="restart" value="Restart">
    <input type="submit" value="Restart">
</form>

</body>
</html>
